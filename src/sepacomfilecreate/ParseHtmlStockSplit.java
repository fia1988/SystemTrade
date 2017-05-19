/**
 *
 */
package sepacomfilecreate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import au.com.bytecode.opencsv.CSVWriter;

/**
 * @author sigre
 *
 */
public class ParseHtmlStockSplit {

	public final static int NORMAL_END = 0;
	public final static int ERROR_SAMEFILENAME = 1;
	public final static int ERROR_NOFOLDEREXIST = 2;
	public final static int ERROR_IOERROR = 3;
	public final static int ERROR_WEBCONNECT = 4;
	public final static int ERROR_OTHER = 5;
	public final static int ERROR_DATAINCOLLECT = 6;
	public final static int NO_UPDATE = 7;
	public final static int ERROR_SQL = 8;


	/**
	 *
	 */
	public ParseHtmlStockSplit() {
	}

	public int makeSplitCsv(String strFolder, String strDate) {
		String url = "http://kabu.com/process/bunkatu.js";

		File folder = new File(strFolder);
		if (!folder.exists()) return ERROR_NOFOLDEREXIST;

		String outputFilePath = strFolder;
		if (!strFolder.endsWith(File.separator)) outputFilePath += File.separator;
		outputFilePath += strDate;

		File file = new File(outputFilePath);
		if (file.exists()) return ERROR_SAMEFILENAME;

		List<SplitMergeInfo> infoList = null;
		try {
			infoList = getSplitData(url);
		} catch (UnknownHostException e) {
			return ERROR_WEBCONNECT;
		} catch (IOException e) {
			return ERROR_OTHER;
		} catch (NoDataException e) {
			return ERROR_DATAINCOLLECT;
		} catch (Exception e) {
			return ERROR_OTHER;
		}

		for (SplitMergeInfo info : infoList) {
			if (!checkData(info)) return ERROR_DATAINCOLLECT;
		}

		return makeCsvFile(outputFilePath, infoList);

	}

	public int makeMergeCsv(String strFolder, String strDate) {
		String url = "http://kabu.com/process/gensi.js";

		File folder = new File(strFolder);
		if (!folder.exists()) return ERROR_NOFOLDEREXIST;

		String outputFilePath = strFolder;
		if (!strFolder.endsWith(File.separator)) outputFilePath += File.separator;
		outputFilePath += strDate;

		File file = new File(outputFilePath);
		if (file.exists()) return ERROR_SAMEFILENAME;


		List<SplitMergeInfo> infoList = null;
		try {
			infoList = getMergeData(url);
		} catch (UnknownHostException e) {
			return ERROR_WEBCONNECT;
		} catch (IOException e) {
			return ERROR_OTHER;
		} catch (NoDataException e) {
			return ERROR_DATAINCOLLECT;
		} catch (Exception e) {
			return ERROR_OTHER;
		}


		for (SplitMergeInfo info : infoList) {
			if (!checkData(info)) {
				return ERROR_DATAINCOLLECT;
			}
		}

		return makeCsvFile(outputFilePath, infoList);

	}

	private int makeCsvFile (String outputFilePath, List<SplitMergeInfo> infoList) {
		Writer iowriter = null;
		CSVWriter writer = null;
		try {

			iowriter = new OutputStreamWriter(
					new FileOutputStream(outputFilePath),"UTF-8");
			writer = new CSVWriter(iowriter, ',', CSVWriter.NO_QUOTE_CHARACTER);

			Iterator<SplitMergeInfo> ite = infoList.iterator();
			while(ite.hasNext()){

				SplitMergeInfo tt = ite.next();

				//効力発生日、銘柄コード、比率、権利付最終日、フラグ、
				//セパフラグ（0で固定）、備忘列
				String[] entries = new String[]{tt.getStrStartDate(),
						tt.getStrStockCode(),
						removePointZero(String.valueOf(Double.parseDouble(tt.getStrWariateRate2()))),
						tt.getStrLastDate(),
						String.valueOf(tt.isSplit),
						"0",
						""
				};

				writer.writeNext(entries);

			}
			writer.close();

		}catch (Exception e) {
			return ERROR_IOERROR;
		}finally{

			try{
				iowriter.close();
			}catch(Exception e){
				return ERROR_IOERROR;
			}

		}

		return NORMAL_END;
	}

	private String removePointZero(String str) {
		if (str.endsWith(".0")) return str.replace(".0", "");

		return str;
	}

	private List<SplitMergeInfo> getMergeData(String url)
			throws UnknownHostException, IOException, NoDataException, Exception{

		Document document = null;
		List<SplitMergeInfo> groupList = new ArrayList<>();
		SplitMergeInfo info = new SplitMergeInfo();
		//boolean halfFlag = true;

//		document = Jsoup.connect(url).get();

		//System.out.println(document.html());

		String strSite = getPageText(url);
		//document.html().replace("\n", "");

		String regex = "document.write\\(\\'\\s*<tr>\\s*\\\\\\s*<td>(.*?)</td>\\\\\\s*<td>(.*?)</td>.*?<td>(.*?)</td>.*?\\<td>'\\);";

		//System.out.println(strSite);
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(strSite);
		while (m.find()){
			info = new SplitMergeInfo();
			info.setStrStartDate(m.group(1));
			info.setStrStockCode(m.group(2));
			info.setStrStockName(m.group(3));
			info.setIsSplit(0);

			groupList.add(info);

		}

		if (groupList.size()==0) throw new NoDataException();

		regex = "document.write\\(\\'</td>\\\\\\s*?<td>(.*?)</td>\\\\\\s*?</tr>\\'\\);";
		p = Pattern.compile(regex);

		//System.out.println(regex);
		int count = 0;

		m = p.matcher(strSite);
		while (m.find()){
			//			System.out.println("group:" + m.group());
			//			System.out.println(m.group(1));
			groupList.get(count).setStrLastDate(m.group(1));
			count += 1;
		}

		regex = "ARatioW\\s=\\s\"(.*?)\";";
		p = Pattern.compile(regex);

		count = 0;

		m = p.matcher(strSite);
		while (m.find()){
			groupList.get(count).setIntWariateRate1(m.group(1));
			count += 1;
		}

		regex = "BRatioW\\s=\\s\"(.*?)\";";
		p = Pattern.compile(regex);

		count = 0;

		m = p.matcher(strSite);
		while (m.find()){
			groupList.get(count).setIntWariateRate2(m.group(1));
			count += 1;
		}
		//
		//		for (SplitMergeInfo group : groupList) {
		//			System.out.println(group.toString());
		//		}

		return groupList;
	}

	private List<SplitMergeInfo> getSplitData(String url)
			throws UnknownHostException, IOException, NoDataException, Exception{
		Document document = null;
		//String url = "http://kabu.com/process/bunkatu.js";
		List<SplitMergeInfo> groupList = new ArrayList<>();
		SplitMergeInfo info = new SplitMergeInfo();
//
//		document = Jsoup.connect(url).get();
//
//		System.out.println(document.html());

		String strSite = getPageText(url);
		//document.html().replace("\n", "");

		String regex = "document.write\\(\\'\\s*<tr>\\s*\\\\\\s*<td>(.*?)</td>.*?<td>(.*?)</td>.*?<td>(.*?)</td>.*?\\'\\);";
		//String regex = "document.write\\(\\'.*?<td>(.*?)</td>.*?<td>(.*?)</td>.*?<td>(.*?)</td>.*?\\'\\);";

		//System.out.println(strSite);
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(strSite);
		while (m.find()){
			//System.out.println("groupcount:" + m.group());
			//System.out.println("group1:" + m.group(1) + m.group(2) + m.group(3));
			info = new SplitMergeInfo();
			info.setStrWariateDate(m.group(1));
			info.setStrStockCode(m.group(2));
			info.setStrStockName(m.group(3));

			groupList.add(info);
		}

		if (groupList.size()==0) throw new NoDataException();

		regex = "document.write\\(\\'</td>\\\\\\s*<td>(.*?)</td>.*?<td>(.*?)</td>.*?<td>(.*?)</td>.*?\\'\\);";

		//System.out.println(strSite);
		p = Pattern.compile(regex);

		int count = 0;

		m = p.matcher(strSite);
		while (m.find()){
			//System.out.println("groupcount:" + m.group());
			//System.out.println("group1:" + m.group(1) + m.group(2) + m.group(3));

			groupList.get(count).setStrLastDate(m.group(1));
			groupList.get(count).setStrStartDate(m.group(2));
			groupList.get(count).setStrSalableDate(m.group(3));
			groupList.get(count).setIsSplit(1);

			count += 1;
		}


		regex = "BRatioW\\s*=\\s*\"(.*?)\";";
		p = Pattern.compile(regex);

		//System.out.println(regex);
		count = 0;

		m = p.matcher(strSite);
		while (m.find()){
			groupList.get(count).setIntWariateRate1(m.group(1));
			count += 1;
		}


		regex = "ARatioW\\s*=\\s*\"(.*?)\";";
		p = Pattern.compile(regex);

		//System.out.println(regex);
		count = 0;

		m = p.matcher(strSite);
		while (m.find()){
			groupList.get(count).setIntWariateRate2(m.group(1));
			count += 1;
		}

//		for (SplitMergeInfo group : groupList) {
//			System.out.println(group.toString());
//		}

		return groupList;
	}

	private boolean checkData (SplitMergeInfo info) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		if (info.getIsSplit()==0) {
			if (!info.getStrWariateDate().equals("")) return false;
			if (!info.getStrSalableDate().equals("")) return false;
		} else if (info.getIsSplit()==1) {
			if (info.strWariateDate.length()!=10) return false;
			if (info.strSalableDate.length()!=10) return false;
		} else return false;

		if (info.strLastDate.length()!=10) return false;
		if (info.strStartDate.length()!=10) return false;
		if (info.strStockCode.length()>=6) return false;

		try {
			Date formatDate = null;
			Date formatDate1 = null;
			Date formatDate2 = null;
			//割当日
			if (info.getIsSplit()==1) formatDate = sdf.parse(info.strWariateDate);
			//権利付き最終日
			formatDate1 = sdf.parse(info.strLastDate);
			//効力発生日
			formatDate2 = sdf.parse(info.strStartDate);
			//売却可能予定日
			if (info.getIsSplit()==1) formatDate = sdf.parse(info.strSalableDate);
			//銘柄コード
			Integer.parseInt(info.strStockCode);
			//割当比率1
			Double.parseDouble(info.strWariateRate1);
			//割当比率2
			Double.parseDouble(info.strWariateRate2);

			//効力発生日は権利付き最終日より必ずあとになるはず
			if (formatDate1.after(formatDate2)){
				return false;
			}

		} catch (Exception e) {
			return false;
		}

		//銘柄名
		if (info.strStockName.length()==0) return false;

		return true;
	}

	public String getUpdateDate(String name)
			throws UnknownHostException, IOException, ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		String strUpdate = "";
		Date dateUpdate = null;

		Document document = Jsoup.connect("http://kabu.com/process/LastUpdate.js").get();

		for (String line : document.html().split("; ")) {
			if (line.startsWith(name)) {
				int intLength = line.length();
				strUpdate = line.substring(intLength-15, intLength-5);
			}
		}

		dateUpdate = sdf.parse(strUpdate);

		return strUpdate;
	}

	private String getPageText(String strUrl) throws IOException {
		URL url = new URL(strUrl); // ダウンロードする URL
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();

		BufferedReader br = new BufferedReader(
				new InputStreamReader(in));

		StringBuilder sb = new StringBuilder();

		String line;

		while ((line = br.readLine()) != null) {
			sb.append(line);
		}

		//System.out.println(sb.toString());

		br.close();

		//		File file = new File("c:\\download\\file.zip"); // 保存先
		//		FileOutputStream out = new FileOutputStream(file, false);
		//		int b;
		//		while((b = in.read()) != -1){
		//		    out.write(b);
		//		}

		in.close();
		return sb.toString();
	}
}

class NoDataException extends Exception {
	public NoDataException() {
		super();
	}
}
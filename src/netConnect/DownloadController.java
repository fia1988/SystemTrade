package netConnect;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.codec.binary.Base64;

/**
 * pom.xmlの<dependencies>内に下記を追加
 *
 *	<dependency>
 *		<groupId>commons-codec</groupId>
 *		<artifactId>commons-codec</artifactId>
 *		<version>1.10</version>
 *	</dependency>
 *
 * @author sigre
 *
 */

public class DownloadController {

	/**
	 *
	 * @param strUrl	サイトURL
	 * @param id		認証ID
	 * @param pass		認証パスワード
	 * @return			CSVを1行ごとにわけたStringリスト
	 * @throws IOException				取得した文字列が処理失敗した場合
	 * @throws UnknownHostException		サイト自体が存在しない場合
	 * @throws WebAccessException		ファイルが存在しない場合
	 * @throws MalformedURLException	httpじゃないURLが入った場合
	 */



	public List<String> getData(String strUrl, String id, String pass)
			throws IOException, UnknownHostException, WebAccessException, MalformedURLException,
			KeyManagementException, NoSuchAlgorithmException {

		URL url = new URL(strUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		//===========新へそのごま対応のために追加==============
		HttpsURLConnection sConn = (HttpsURLConnection)conn;

        // 証明書の検証をしない
        // sun.security.validator.ValidatorException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target

		SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null,
                        new X509TrustManager[] { new LooseTrustManager() },
                        new SecureRandom());

        sConn.setSSLSocketFactory(sslContext.getSocketFactory());

        // ホスト名の検証をしない
        // java.security.cert.CertificateException: No name matching [ホスト名] found
        // HttpsURLConnection.setDefaultHostnameVerifier(new LooseHostnameVerifier());
        sConn.setHostnameVerifier(new LooseHostnameVerifier());

        //========================================================
		
		
		String strKey = id + ":" + pass;

		String encodedBytes = new String(Base64.encodeBase64(strKey.getBytes()));

		conn.setRequestProperty("Authorization", "Basic " + encodedBytes);
//		System.out.println(conn.getResponseCode());

		int intRes = conn.getResponseCode();

		//アクセス失敗（存在しないURL、認証失敗など）
		if (200 != intRes) throw new WebAccessException(intRes);

		InputStream is = conn.getInputStream();
		String strCsv = convertInputStreamToString(is);

		strCsv = strCsv.replace("\r", "");
		return Arrays.asList(strCsv.split("\n"));
	}

	static String convertInputStreamToString(InputStream is) throws IOException {
	    InputStreamReader reader = new InputStreamReader(is, "SJIS");
	    StringBuilder builder = new StringBuilder();
	    char[] buffer = new char[512];
	    int read;
	    while (0 <= (read = reader.read(buffer))) {
	        builder.append(buffer, 0, read);
	    }
	    return builder.toString();
	}
}

class LooseTrustManager implements X509TrustManager {
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
            return null;
    }
}

class LooseHostnameVerifier implements HostnameVerifier {
    public boolean verify(String hostname, SSLSession session) {
            return true;
    }
}



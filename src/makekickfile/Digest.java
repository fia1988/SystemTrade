package makekickfile;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Arrays;

public class Digest {

	final static String DIG_ALGORITHM = "MD5";

	static String target1 = "target\\TestFile\\target1.txt";
	static String target2 = "target\\TestFile\\target2.txt";
	static String target3 = "target\\TestFile\\target3.txt";
	static String target4 = "target\\TestFile\\target4.txt";

	public Digest() {
	}



	public boolean makeDigestFile(String path, String key, int count) {
		String digest = getDigestStr(key);

		File keyFile = new File(path);

		FileWriter writer = null;
		try {
			if (keyFile.exists()) {
				keyFile.delete();
			}
			keyFile.createNewFile();
			writer = new FileWriter(keyFile);
			writer.write(digest);
			writer.write("\n" + count);

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}

	public boolean checkDigestFile(String path, String key) {

		String digest = getDigestStr(key);

		File keyFile = new File(path);

		if (!keyFile.exists()) {
			return false;
		}

		String digestInFile = "";
		int count = -1;

		try {
			FileReader reader = new FileReader(new File(path));
			BufferedReader br = new BufferedReader(reader);
			digestInFile = br.readLine();
			String strCount = br.readLine();
			System.out.println(strCount);

			if (strCount!=null) {
				count = Integer.parseInt(strCount);
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (!digest.equals(digestInFile)) {
			System.out.println(digestInFile);
			return false;
		}

		if (count >= 5) {
			return false;
		}

		return true;
	}

	public String getDigestStr(String key) {

		String md5 = "";

		byte[] digest = getDigest(key);
		for (int loop = 0;loop < digest.length;loop++) {
			md5 += Integer.toHexString(0xff&(char)digest[loop]).toString();
		}

		return md5;
	}

	private byte[] getDigest(String key) {
		MessageDigest msgDig = null;
		byte[] digest = null;
		try {
			msgDig = MessageDigest.getInstance(DIG_ALGORITHM);
			digest = msgDig.digest(key.getBytes());

		} catch (Exception e) {
			//e.printStackTrace();
			Arrays.fill(digest,(byte)0);
			return digest;
		}

		return digest;
	}

}

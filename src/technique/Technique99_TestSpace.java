package technique;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import proparty.S;

public class Technique99_TestSpace {


	public void basicTester(String className_L,String className_S,String methodName_L,String methodName_S,String code,String TBL,S s){
		try {
			//クラス名を指定。パッケージ名のクラス名
			Class cl_L = Class.forName("analysis." + className_L);
			Class cl_S = Class.forName("analysis." + className_S);

			try {
				// メソッドに引き渡すクラスの順番を定義
				Class para_L[] = new Class[] { String.class ,S.class};
				Class para_S[] = new Class[] { String.class ,S.class};
//				Class para[] = new Class[] { Bean_CodeList.class ,S.class};
				// 引数ありのメソッドを取得する。methodNameがメソッド名
				Method m_L = cl_L.getMethod(methodName_L,para_L);
				Method m_S = cl_L.getMethod(methodName_S,para_S);


				// メソッドに引き渡すパラメータを、オブジェクトの配列で準備
				Object[] ob = new Object[] { code ,s};
				// 引数をいれて実行
				try {
					m_L.invoke(cl_L.newInstance(), ob);
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException
						| InstantiationException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}

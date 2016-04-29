package insertPackage;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import proparty.S;
import bean.Bean_CodeList;
import bean.Bean_FinancialStatement;
import bean.Bean_TBLRecord;


public class InsertSuper {




	public void superTBLRecord(String className,String methodName,List<Bean_TBLRecord> beanList,String TBLName,S s){
		try {
			//クラス名を指定。パッケージ名のクラス名
			Class cl = Class.forName("insertPackage." + className);

			try {
				// メソッドに引き渡すクラスの順番を定義
				Class para[] = new Class[] { Bean_TBLRecord.class, String.class, S.class };
				// 引数ありのメソッドを取得する。methodNameがメソッド名
				Method m = cl.getMethod(methodName,para);

				for(int i=0;i<beanList.size();i++){
					// メソッドに引き渡すパラメータを、オブジェクトの配列で準備
					Object[] ob = new Object[] { beanList.get(i), TBLName ,s };
					// 引数をいれて実行
					try {
						m.invoke(cl.newInstance(), ob);
					} catch (IllegalAccessException | IllegalArgumentException
							| InvocationTargetException
							| InstantiationException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}



	public void superCODEList(String className,String methodName,List<Bean_CodeList> beanList,S s){
		try {
			//クラス名を指定。パッケージ名のクラス名
			Class cl = Class.forName("insertPackage." + className);

			try {
				// メソッドに引き渡すクラスの順番を定義
				Class para[] = new Class[] { Bean_CodeList.class ,S.class};
				// 引数ありのメソッドを取得する。methodNameがメソッド名
				Method m = cl.getMethod(methodName,para);

				for(int i=0;i<beanList.size();i++){
					// メソッドに引き渡すパラメータを、オブジェクトの配列で準備
					Object[] ob = new Object[] { beanList.get(i) ,s};
					// 引数をいれて実行
					try {
						m.invoke(cl.newInstance(), ob);
					} catch (IllegalAccessException | IllegalArgumentException
							| InvocationTargetException
							| InstantiationException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}


	public void superFinansialStmt(String className,String methodName,List<Bean_FinancialStatement> beanList,String TBLName,S s){
		try {
			//クラス名を指定。パッケージ名のクラス名
			Class cl = Class.forName("insertPackage." + className);

			try {
				// メソッドに引き渡すクラスの順番を定義
				Class para[] = new Class[] { Bean_FinancialStatement.class, String.class ,S.class};
				// 引数ありのメソッドを取得する。aaaがメソッド名
				Method m = cl.getMethod(methodName,para);

				for(int i=0;i<beanList.size();i++){
					// メソッドに引き渡すパラメータを、オブジェクトの配列で準備
					Object[] ob = new Object[] { beanList.get(i), TBLName,s };
					// 引数をいれて実行
					try {
						m.invoke(cl.newInstance(), ob);
					} catch (IllegalAccessException | IllegalArgumentException
							| InvocationTargetException
							| InstantiationException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
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


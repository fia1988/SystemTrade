package bean;

import java.util.List;

public class Bean_Oneline {
	private String B_CL;
	private String B_FS;
	private String B_TR;


	//リストをセットするといい感じに一行にして返すBeanクラス

	public void setBean_CL(List<Bean_CodeList> x){
		for(int i = 0;i<x.size();i++){
			B_CL = B_CL + x.get(i);
		}
	}

	public String getBean_CL(){
		return B_CL;
	}

	public void setBean_FS(List<Bean_FinancialStatement> x){

	}

	public String getBean_FS(){
		return B_FS;
	}

	public void setBean_TR(List<Bean_TBLRecord> x){

	}

	public String getBean_TR(){
		return B_TR;
	}

}

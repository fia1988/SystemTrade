package createTBL;

import java.util.List;

import proparty.S;
import sql.createTBL;
import bean.Bean_CodeList;
import constant.ReCord;

public class GetCodeTBL {
	createTBL CTBL = new createTBL();
	public void controll_CreateTBL_DD(List<Bean_CodeList> DTO ,S s){
		//個別銘柄・・・1
		//統計・・・2
		//指数・・・3
		//ETF・・・4
		//先物・・・5
		//通貨・・・6
		for(int i = 0;i<DTO.size();i++){
			switch(DTO.get(i).getCateflg()){
			case ReCord.CODE_01_STOCK:
				createTBL_DD_STOCK(DTO.get(i),s);
				break;
			case ReCord.CODE_02_SATISTICS:
				createTBL_DD_STATISTICS(DTO.get(i),s);
				break;
			case ReCord.CODE_03_INDEX:
				createTBL_DD_INDEX(DTO.get(i),s);
				break;
			case ReCord.CODE_04_ETF:
				createTBL_DD_STOCK(DTO.get(i),s);
				break;
			case ReCord.CODE_05_SAKIMONO:
				break;
			case ReCord.CODE_06_CURRENCY:
				break;
			default:
			}
		}




	}

	private void createTBL_DD_INDEX(Bean_CodeList DTO ,S s){

			CTBL.dayTable_INDEX(DTO.getCode(), s);

	}

	private void createTBL_DD_STOCK(Bean_CodeList DTO ,S s){

			CTBL.dayTable_Stock(DTO.getCode(), s);

	}

	private void createTBL_DD_STATISTICS(Bean_CodeList DTO ,S s){

			CTBL.dayTable_Statistical(DTO.getCode(), s);

	}
}

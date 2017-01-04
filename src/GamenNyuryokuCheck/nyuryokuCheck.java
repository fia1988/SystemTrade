package GamenNyuryokuCheck;

import GamenDTO.TAB_MainDTO;
import constant.nyuryokuCheckResultConst;

public class nyuryokuCheck {
	public String nyuryokuChecker(TAB_MainDTO mainDTO){

		//タイマーチェック
		//TRUEのときはタイマー起動中なのでオフを返す。
		if(mainDTO.isJudgeTimer()==true){
			return nyuryokuCheckResultConst.ON_TIMER_ERR;
		}


		return nyuryokuCheckResultConst.SUCCESS;
	}
}

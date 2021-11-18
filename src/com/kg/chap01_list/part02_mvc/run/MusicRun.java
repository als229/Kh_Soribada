package com.kg.chap01_list.part02_mvc.run;

import com.kg.chap01_list.part02_mvc.view.MusicView;

public class MusicRun {

	// MVC패턴 적용한 음악 관리 프로그램
	// M : Model , 데이터를 담당한느 역할 (model.vo : 값을 담는다.
	//								model.dao : 값을 처리한다.)
	// V : View , 사용자가 보는 화면을 처리(입력, 출력)
	// => View가 아닌곳에서 입출력문 사용을 자제!!!!
	// C : Controller , 사용자가 화면을 통해서 요청한 것을 받아서 처리하고
	//     결과를 돌려주는 역할
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		// 메인화면 띄우기
		MusicView m = new MusicView();
		m.mainMenu();
		
	}
}

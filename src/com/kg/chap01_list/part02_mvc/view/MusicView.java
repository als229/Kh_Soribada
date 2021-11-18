package com.kg.chap01_list.part02_mvc.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kg.chap01_list.part02_mvc.controller.MusicController;
import com.kg.chap01_list.part02_mvc.model.vo.Music;

// View : 시각적인 요소 , 입/출력

public class MusicView {
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();

	// 메인화면
	public void mainMenu() {

		while (true) {
			System.out.println("***음악은 역시 즤니 ~ ***");
			System.out.println("1. 새로운 곡 추가"); // add 메서드
			System.out.println("2. 곡 전체 조회"); // 반복문 or toString
			System.out.println("3. 특정 곡 검색"); // 반복문 + get메서드
			System.out.println("4. 특정 곡 삭제"); // remove 메서드
			System.out.println("5. 특정 곡 수정"); // set 메서드
			System.out.println("0. 프로그램 종료");

			System.out.print("메뉴 입력 > : ");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				insertMenu();
				break;
			case 2:
				selectMusic();
				break;
			case 3:
				searchMusic();
				break;
			case 4:
				deleteMusic();
				break;
			case 5:
				updateMusic();
				break;
			case 0:
				System.out.println("잘가고 ~");
				return;
			default:
				System.out.println("없는 메뉴입니다. 다시 입력해");
			} // switch 종료
		} // while 종료

	}// mainMenu 종료

	// 1. 새로운 곡을 추가시킬 수 있는 화면
	public void insertMenu() {

		System.out.println("-------- 곡 추가 --------");
		System.out.print("곡명 입력 > ");
		String title = sc.nextLine();
		System.out.print("가수명 입력 >");
		String artist = sc.nextLine();

		// 요청 => Controller 에 메서드 호출
		mc.insertMusic(title, artist);

		System.out.println("성공적으로 추가되었습니다.");
	}

	// 2. 전체 곡을 조회할 수 있는 화면
	public void selectMusic() {

		System.out.println("----------전체 곡 조회----------");

		// 요청
		ArrayList<Music> list = mc.selectMusic();

		if (list.isEmpty() == true) {
			System.out.println("저장된 곡이 없습니다.");
		} else {
			for (Music m : list) {
				System.out.println(m);
			}
		}
	}// selectMusic 끝

	// 3. 특정 곡을 검색할 수 있는 화면
	public void searchMusic() {
		System.out.println("---------- 특정 곡 검색 ----------");
		System.out.print("검색하고 싶은 곡 키워드를 검색해 주세용. >");
		String keyword = sc.nextLine().trim();

		// 요청
		ArrayList<Music> list = mc.searchMusic(keyword);
		if (list.isEmpty() == true) {
			System.out.println("검색된 결과가 없습니다?");
		} else {
			for (Music m : list) {
				System.out.println(m);
			}
		}

	} // searchMusic 끝

	// 4. 특정 곡을 삭제할 수 있는 화면

	public void deleteMusic() {
		System.out.println("--------- 곡 삭제 --------");
		System.out.print("삭제하고 싶은 곡을 입력하세용. >");
		String title = sc.nextLine().trim();

		// 요청
		int result = mc.deleteMusic(title);

		if (result != 0) {
			System.out.println("성공적으로 삭제!!!");

		} else {
			System.out.println("잘 못들었슴다?");
		}

	}// deleteMusic 끝

	// 5. 특정 곡을 수정할 수 있는 화면
	public void updateMusic() {

		System.out.println("-------- 곡 수정 ----------");
		
		// 기존 곡명(검색용도), 수정할 곡명, 수정할 가수명(수정할 용도)
		System.out.print("바꾸고싶은 곡명을 입력하세용. >");
		String title = sc.nextLine().trim();
		System.out.print("수정하고 싶은 곡명을 입력하세용. > ");
		String newTitle = sc.nextLine().trim();
		System.out.print("수정하고 싶은 가수명을 입력하세용. >");
		String newArtist = sc.nextLine().trim();
		
		int result = mc.updateMusic(title,newTitle,newArtist);
		
		if (result != 0) {
			System.out.println("성공적으로 수정!!!");
		} else {
			System.out.println("잘 못들었슴다?");
		}
	}// updateMusic 끝
}

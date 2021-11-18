package com.kg.chap01_list.part02_mvc.controller;

import java.util.ArrayList;

import com.kg.chap01_list.part02_mvc.model.vo.Music;

// Controller : 사용자의 요청을 받아서 처리해 주는 클래스
//				처리결과를 View로 반환한다.
public class MusicController {
	// 음악 리스트
	private ArrayList<Music> list = new ArrayList<>();
	{ // 초기화 블록 : 객체 생성시 무조건 수행되는 블록
		list.add(new Music("넥스트 레벨", "에스파"));
		list.add(new Music("오빠한번 믿어봐", "박현빈"));
	}

	// 새로운 곡 추가 요청이 있을 때 실행되는 메서드
	public void insertMusic(String title, String artist) {
		list.add(new Music(title, artist));
	}

	// 곡 전체 조회 요청 시 실행되는 메서드
	public ArrayList<Music> selectMusic() {

		return list;

	}

	// 특정 곡 검색 요청이 있을 때 실행되는 메서드
	public ArrayList<Music> searchMusic(String keyword) {

		// 검색된 결과가 담길 ArrayList<Music> 객체 생성
		ArrayList<Music> searched = new ArrayList<>();

		// 조회 => 맞는 keyword만 searched에 추가
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().contains(keyword)) {
				searched.add(list.get(i));
			}
		}
		return searched;
	}

	// 특정 곡 삭제 요청 시 실행할 메서드
	public int deleteMusic(String title) {

		// 결과를 담을 변수 먼저 생성
		int result = 0; // 삭제가 진행될 횟수

		// 처리
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().equals(title)) {
				list.remove(i);
				result++;
			}
		}
		return result;
	}
	public int updateMusic(String title, String newTitle, String newArtist) {
		
		int result = 0;
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().equals(title)) {
				list.get(i).setTitle(newTitle);
				list.get(i).setArtist(newArtist);
				result++;
			}
		}
		return result;
	}
	
}

package com.lee.jul22.sdi;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

public class Human {
	
	// abcd.xml에 등록해놓은 ChunChangwon객체와 자동연결
	//	setter 없어도 됨, getter만 생성
	@Autowired
	private ChunChangwon maknae;
	
	
	
	public ChunChangwon getMaknae() {
		return maknae;
	}

	// 기본형
	private String name;
	private int age;
	
	// 컬렉션
	private String[] nickname;
	private ArrayList<String> family;
	private HashMap<String, Integer> score;
	
	// Has A
	private Dog pet;
	
	
	public Human() {
		// TODO Auto-generated constructor stub
	}

	public Human(String name, int age, String[] nickname, ArrayList<String> family, HashMap<String, Integer> score,
			Dog pet) {
		super();
		this.name = name;
		this.age = age;
		this.nickname = nickname;
		this.family = family;
		this.score = score;
		this.pet = pet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String[] getNickname() {
		return nickname;
	}

	public void setNickname(String[] nickname) {
		this.nickname = nickname;
	}

	public ArrayList<String> getFamily() {
		return family;
	}

	public void setFamily(ArrayList<String> family) {
		this.family = family;
	}

	public HashMap<String, Integer> getScore() {
		return score;
	}

	public void setScore(HashMap<String, Integer> score) {
		this.score = score;
	}

	public Dog getPet() {
		return pet;
	}

	public void setPet(Dog pet) {
		this.pet = pet;
	}
	
	
	
}

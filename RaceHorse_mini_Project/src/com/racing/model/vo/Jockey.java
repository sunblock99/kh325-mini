package com.racing.model.vo;

import java.util.Date;

public class Jockey {

	private int rowNum;
	private String jkNo; // 기수번호
	private String jkName; // 기수이름
	private String meet; // 시행경마장명
	private int age; // 나이
	private Date debut; // 데뷔일자
	private int rcCntT; // 통산총출주횟수
	private int ord1CntT; // 통산 1착 횟수
	private int ord2CntT; // 통산 2착 횟수
	private int ord3CntT; // 통산 3착 횟수
	
	public Jockey() {
		super();

	}

	public Jockey(String jkNo, String jkName, String meet, int age, Date debut, int rcCntT, int ord1CntT, int ord2CntT,
			int ord3CntT) {
		super();
		this.jkNo = jkNo;
		this.jkName = jkName;
		this.meet = meet;
		this.age = age;
		this.debut = debut;
		this.rcCntT = rcCntT;
		this.ord1CntT = ord1CntT;
		this.ord2CntT = ord2CntT;
		this.ord3CntT = ord3CntT;
	}
	
	public Jockey(int rowNum, String jkNo, String jkName, String meet, int age, Date debut, int rcCntT, int ord1CntT, int ord2CntT,
			int ord3CntT) {
		super();
		this.rowNum = rowNum;
		this.jkNo = jkNo;
		this.jkName = jkName;
		this.meet = meet;
		this.age = age;
		this.debut = debut;
		this.rcCntT = rcCntT;
		this.ord1CntT = ord1CntT;
		this.ord2CntT = ord2CntT;
		this.ord3CntT = ord3CntT;
	}

	public String toString1() {
		return "Jockey [jkNo=" + jkNo + ", jkName=" + jkName + ", meet=" + meet + ", age=" + age + ", debut=" + debut
				+ ", rcCntT=" + rcCntT + ", ord1CntT=" + ord1CntT + ", ord2CntT=" + ord2CntT + ", ord3CntT=" + ord3CntT
				+ "]";
	}
	
	
	@Override
	public String toString() {
		return "Jockey [rowNum=" + rowNum + ", jkNo=" + jkNo + ", jkName=" + jkName + ", meet=" + meet + ", age=" + age + ", debut=" + debut
				+ ", rcCntT=" + rcCntT + ", ord1CntT=" + ord1CntT + ", ord2CntT=" + ord2CntT + ", ord3CntT=" + ord3CntT
				+ "]" + "\n";
	}
	
	public String  toStringForConsole1() {
        String str = "";
        str += "기수 번호 : " + jkNo + "\n";
        str += "기수 이름 : " + jkName + "\n";
        str += "시행경마장 : " + meet + "\n";
        str += "기수 나이 : " + age + "\n";
        str += "데뷔일자 : " + debut + "\n";
        str += "통산총출주횟수 : " + rcCntT + "\n";
        str += "통산1착횟수 : " + ord1CntT + "\n";
        str += "통산2착횟수 : " + ord2CntT + "\n";
        str += "통산3착횟수 : " + ord3CntT + "\n";
        str += "=========================================================\n";
        return str;
    }

    public String  toStringForConsole() {
        String str = "";
        str += "순위 : " + rowNum + "\n";
        str += "기수 번호 : " + jkNo + "\n";
        str += "기수 이름 : " + jkName + "\n";
        str += "시행경마장 : " + meet + "\n";
        str += "기수 나이 : " + age + "\n";
        str += "데뷔일자 : " + debut + "\n";
        str += "통산총출주횟수 : " + rcCntT + "\n";
        str += "통산1착횟수 : " + ord1CntT + "\n";
        str += "통산2착횟수 : " + ord2CntT + "\n";
        str += "통산3착횟수 : " + ord3CntT + "\n";
        str += "=========================================================\n";
        return str;
    }
	
	
	
	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	public String getJkNo() {
		return jkNo;
	}

	public void setJkNo(String jkNo) {
		this.jkNo = jkNo;
	}

	public String getJkName() {
		return jkName;
	}

	public void setJkName(String jkName) {
		this.jkName = jkName;
	}

	public String getMeet() {
		return meet;
	}

	public void setMeet(String meet) {
		this.meet = meet;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDebut() {
		return debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public int getRcCntT() {
		return rcCntT;
	}

	public void setRcCntT(int rcCntT) {
		this.rcCntT = rcCntT;
	}

	public int getOrd1CntT() {
		return ord1CntT;
	}

	public void setOrd1CntT(int ord1CntT) {
		this.ord1CntT = ord1CntT;
	}

	public int getOrd2CntT() {
		return ord2CntT;
	}

	public void setOrd2CntT(int ord2CntT) {
		this.ord2CntT = ord2CntT;
	}

	public int getOrd3CntT() {
		return ord3CntT;
	}

	public void setOrd3CntT(int ord3CntT) {
		this.ord3CntT = ord3CntT;
	}

	
}
package com.racing.model.vo;

public class RaceFacility {
	private String fltSeq; // 13/fltSeq
	private String fltTitle; // 어린이승마장/fltTitle
	private String fltEcodeName; // 즐길거리/fltEcodeName
	private String fltEndday; // 2015-12-27/fltEndday
	private String fltHour; // 10:00~16:30/fltHour
	private String fltLcodeName; // 서울/fltLcodeName
	private String fltMcodeName; // 공원시설/fltMcodeName
	private String fltObjText; // 나이 6세∼13세, 키 100㎝이상/fltObjText
	private String fltPositionAdd; // 가족공원 내 포니랜드 인근 어린이 놀이터 옆/fltPositionAdd
	private String fltRentStatusName; // 불가능/fltRentStatusName
	private String fltScodeName; // 어린이동산/fltScodeName
	private String fltStatusName; // 미게시/fltStatusName
	private String fltText; // (3월~12월) 10:00 ~ 16:30 (현장접수)/fltText

	public RaceFacility() {
		super();
	}

	public RaceFacility(String fltSeq, String fltTitle, String fltEcodeName, String fltEndday, String fltHour,
			String fltLcodeName, String fltMcodeName, String fltObjText, String fltPositionAdd,
			String fltRentStatusName, String fltScodeName, String fltStatusName, String fltText) {
		super();
		this.fltSeq = fltSeq;
		this.fltTitle = fltTitle;
		this.fltEcodeName = fltEcodeName;
		this.fltEndday = fltEndday;
		this.fltHour = fltHour;
		this.fltLcodeName = fltLcodeName;
		this.fltMcodeName = fltMcodeName;
		this.fltObjText = fltObjText;
		this.fltPositionAdd = fltPositionAdd;
		this.fltRentStatusName = fltRentStatusName;
		this.fltScodeName = fltScodeName;
		this.fltStatusName = fltStatusName;
		this.fltText = fltText;
	}

	@Override
	public String toString() {
		return "RaceFacility [fltSeq=" + fltSeq + ", fltTitle=" + fltTitle + ", fltEcodeName=" + fltEcodeName
				+ ", fltEndday=" + fltEndday + ", fltHour=" + fltHour + ", fltLcodeName=" + fltLcodeName
				+ ", fltMcodeName=" + fltMcodeName + ", fltObjText=" + fltObjText + ", fltPositionAdd=" + fltPositionAdd
				+ ", fltRentStatusName=" + fltRentStatusName + ", fltScodeName=" + fltScodeName + ", fltStatusName="
				+ fltStatusName + ", fltText=" + fltText + "]" + "\n";
	}

	public String toStringForConsole() {
		String str = "";
		str += "시설명 : " + fltTitle + "\n";
		str += "유흥구분 : " + fltEcodeName + "\n";
		str += "오픈일 : " + fltText + "\n";
		str += "오픈시간 : " + fltHour + "\n";
		str += "지역/지사명 : " + fltLcodeName + "\n";
		str += "건물구분 : " + fltMcodeName + "\n";
		str += "시설구분 : " + fltScodeName + "\n";
		str += "이용대상 : " + fltObjText + "\n";
		str += "위치 : " + fltPositionAdd + "\n";
		str += "예약가능/불가능여부 : " + fltRentStatusName + "\n";
		str += "연번호 : " + fltSeq + "\n";
		str += "게시여부 : " + fltStatusName + "\n";
		str += "=========================================================\n";

		return str;
	}

	public String getFltSeq() {
		return fltSeq;
	}

	public void setFltSeq(String fltSeq) {
		this.fltSeq = fltSeq;
	}

	public String getFltTitle() {
		return fltTitle;
	}

	public void setFltTitle(String fltTitle) {
		this.fltTitle = fltTitle;
	}

	public String getFltEcodeName() {
		return fltEcodeName;
	}

	public void setFltEcodeName(String fltEcodeName) {
		this.fltEcodeName = fltEcodeName;
	}

	public String getFltEndday() {
		return fltEndday;
	}

	public void setFltEndday(String fltEndday) {
		this.fltEndday = fltEndday;
	}

	public String getFltHour() {
		return fltHour;
	}

	public void setFltHour(String fltHour) {
		this.fltHour = fltHour;
	}

	public String getFltLcodeName() {
		return fltLcodeName;
	}

	public void setFltLcodeName(String fltLcodeName) {
		this.fltLcodeName = fltLcodeName;
	}

	public String getFltMcodeName() {
		return fltMcodeName;
	}

	public void setFltMcodeName(String fltMcodeName) {
		this.fltMcodeName = fltMcodeName;
	}

	public String getFltObjText() {
		return fltObjText;
	}

	public void setFltObjText(String fltObjText) {
		this.fltObjText = fltObjText;
	}

	public String getFltPositionAdd() {
		return fltPositionAdd;
	}

	public void setFltPositionAdd(String fltPositionAdd) {
		this.fltPositionAdd = fltPositionAdd;
	}

	public String getFltRentStatusName() {
		return fltRentStatusName;
	}

	public void setFltRentStatusName(String fltRentStatusName) {
		this.fltRentStatusName = fltRentStatusName;
	}

	public String getFltScodeName() {
		return fltScodeName;
	}

	public void setFltScodeName(String fltScodeName) {
		this.fltScodeName = fltScodeName;
	}

	public String getFltStatusName() {
		return fltStatusName;
	}

	public void setFltStatusName(String fltStatusName) {
		this.fltStatusName = fltStatusName;
	}

	public String getFltText() {
		return fltText;
	}

	public void setFltText(String fltText) {
		this.fltText = fltText;
	}

}
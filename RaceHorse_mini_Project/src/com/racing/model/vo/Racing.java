package com.racing.model.vo;

public class Racing {

	private int RNO;// 일련번호
	private String rcDate; // 경주일자
	private int rcNo; // 경주번호
	private int rcDist; // 경주거리
	private int rcOrd; // 순위
	private double rcTime; // 경주기록
	private int rcChul; // 출전번호
	private String hrno; // 마번
	private String hrName; // 마명
	private int wgHr; // 마체중
	private String jkNo; // 기수번호
	private String jkName; // 기수명
	private int chaksun; // 착순상금
	private String weath; // 날씨

	public Racing(int rcNo) {
		super();

		this.rcNo = rcNo;
	}

	public Racing(int rNO, String rcDate, int rcNo, int rcDist, int rcOrd, double rcTime, int rcChul, String hrno,
			String hrName, int wgHr, String jkNo, String jkName, int chaksun, String weath) {
		super();
		RNO = rNO;
		this.rcDate = rcDate;
		this.rcNo = rcNo;
		this.rcDist = rcDist;
		this.rcOrd = rcOrd;
		this.rcTime = rcTime;
		this.rcChul = rcChul;
		this.hrno = hrno;
		this.hrName = hrName;
		this.wgHr = wgHr;
		this.jkNo = jkNo;
		this.jkName = jkName;
		this.chaksun = chaksun;
		this.weath = weath;
	}

	@Override
	public String toString() {
		String str = "";
		str += "일련번호 : " + RNO + "\n";
		str += "경주일자 : " + rcDate + "\n";
		str += "경주번호 : " + rcNo + "\n";
		str += "경주거리 : " + rcDist + "\n";
		str += "순위 : " + rcOrd + "\n";
		str += "경주기록 : " + rcTime + "\n";
		str += "출전번호 : " + rcChul + "\n";
		str += "마번 : " + hrno + "\n";
		str += "마명 : " + hrName + "\n";
		str += "마체중 : " + wgHr + "\n";
		str += "기수번호 : " + jkNo + "\n";
		str += "기수명 : " + jkName + "\n";
		str += "착순상금 : " + chaksun + "\n";
		str += "날씨 : " + weath + "\n";
		str += "=========================================================\n";
		return str;
	}

	// 날짜+경주정보 검색 시 순위기준 정렬
	public String toStringrcOrd() {
		String str = "";
		str += "순위 : " + rcOrd + "\n";
		str += "일련번호 : " + RNO + "\n";
		str += "경주일자 : " + rcDate + "\n";
		str += "경주번호 : " + rcNo + "\n";
		str += "경주거리 : " + rcDist + "\n";
		str += "경주기록 : " + rcTime + "\n";
		str += "출전번호 : " + rcChul + "\n";
		str += "마번 : " + hrno + "\n";
		str += "마명 : " + hrName + "\n";
		str += "마체중 : " + wgHr + "\n";
		str += "기수번호 : " + jkNo + "\n";
		str += "기수명 : " + jkName + "\n";
		str += "착순상금 : " + chaksun + "\n";
		str += "날씨 : " + weath + "\n";
		str += "=========================================================\n";
		return str;
	}

	public int getRNO() {
		return RNO;
	}

	public void setRNO(int rNO) {
		RNO = rNO;
	}

	public String getRcDate() {
		return rcDate;
	}

	public void setRcDate(String rcDate) {
		this.rcDate = rcDate;
	}

	public int getRcNo() {
		return rcNo;
	}

	public void setRcNo(int rcNo) {
		this.rcNo = rcNo;
	}

	public int getRcDist() {
		return rcDist;
	}

	public void setRcDist(int rcDist) {
		this.rcDist = rcDist;
	}

	public int getRcOrd() {
		return rcOrd;
	}

	public void setRcOrd(int rcOrd) {
		this.rcOrd = rcOrd;
	}

	public double getRcTime() {
		return rcTime;
	}

	public void setRcTime(double rcTime) {
		this.rcTime = rcTime;
	}

	public int getRcChul() {
		return rcChul;
	}

	public void setRcChul(int rcChul) {
		this.rcChul = rcChul;
	}

	public String getHrno() {
		return hrno;
	}

	public void setHrno(String hrno) {
		this.hrno = hrno;
	}

	public String getHrName() {
		return hrName;
	}

	public void setHrName(String hrName) {
		this.hrName = hrName;
	}

	public int getWgHr() {
		return wgHr;
	}

	public void setWgHr(int wgHr) {
		this.wgHr = wgHr;
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

	public int getChaksun() {
		return chaksun;
	}

	public void setChaksun(int chaksun) {
		this.chaksun = chaksun;
	}

	public String getWeath() {
		return weath;
	}

	public void setWeath(String weath) {
		this.weath = weath;
	}
}
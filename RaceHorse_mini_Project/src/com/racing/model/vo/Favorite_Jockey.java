package com.racing.model.vo;

public class Favorite_Jockey {
	private int JNO;
	private String jkNo;
	private int UNO;
	private String jkName;

	public Favorite_Jockey() {
		super();
	}

	public Favorite_Jockey(int jNO, int uNO, String jkNo, String jkName) {
		super();
		JNO = jNO;
		UNO = uNO;
		this.jkNo = jkNo;
		this.jkName = jkName;
	}

	public Favorite_Jockey(int uNO, String jkno, String jkname) {
		super();
		UNO = uNO;
		this.jkNo = jkno;
		this.jkName = jkname;
	}

	public Favorite_Jockey(String jkno, String jkName) {
		super();
		this.jkNo = jkno;
		this.jkName = jkName;
	}

	public Favorite_Jockey(int jNO, String jkNo, int uNO) {
		super();
		JNO = jNO;
		this.jkNo = jkNo;
		UNO = uNO;
	}

	public int getJNO() {
		return JNO;
	}

	public void setJNO(int jNO) {
		JNO = jNO;
	}

	public String getJkNo() {
		return jkNo;
	}

	public void setJkNo(String jkNo) {
		this.jkNo = jkNo;
	}

	public int getUNO() {
		return UNO;
	}

	public void setUNO(int uNO) {
		UNO = uNO;
	}

	public String getJkName() {
		return jkName;
	}

	public void setJkName(String jkName) {
		this.jkName = jkName;
	}

	@Override
	public String toString() {
		return "Favorite_Jockey [JNO=" + JNO + ", jkNo=" + jkNo + ", UNO=" + UNO + ", jkName=" + jkName + "]";
	}

	public String toStringForConsole() {
		String str = "";
		str += "관심 기수번호 : " + jkNo + "\n";
		str += "관심 기수이름 : " + jkName + "\n";
		str += "=========================================================\n";
		return str;
	}

}
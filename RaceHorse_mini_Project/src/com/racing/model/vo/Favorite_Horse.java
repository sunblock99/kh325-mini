package com.racing.model.vo;

public class Favorite_Horse {
	private int UNO;
	private String hrNo;
	private String hrName;
	private String birthday;

	public Favorite_Horse() {
		super();
	}

	public Favorite_Horse(int uNO, String hrNo, String hrName) { // 즐겨찾기 목록 전체조회 생성자
		super();
		UNO = uNO;
		this.hrNo = hrNo;
		this.hrName = hrName;
	}

	public Favorite_Horse(int uNO, String hrName, String hrNo, String birthday) { // 말이름,마번으로 검색하면 나오는 결과 생성자
		super();
		UNO = uNO;
		this.hrName = hrName;
		this.hrNo = hrNo;
		this.birthday = birthday;
	}

	public Favorite_Horse(String hrName, String hrNo, String birthday) { // 즐겨찾기 번호로 검색하면 나오는 결과 생성자
		super();
		this.hrName = hrName;
		this.hrNo = hrNo;
		this.birthday = birthday;
	}

	public int getUNO() {
		return UNO;
	}

	public void setUNO(int uNO) {
		UNO = uNO;
	}

	public String getHrNo() {
		return hrNo;
	}

	public void setHrNo(String hrNo) {
		this.hrNo = hrNo;
	}

	public String getHrName() {
		return hrName;
	}

	public void setHrName(String hrName) {
		this.hrName = hrName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Favorite_Horse UNO=" + UNO + ", hrNo=" + hrNo + ", hrName=" + hrName + ", birthday=" + birthday + "]";
	}

	public String toStringForConsole() {
		String str = "";
		str += "관심 경주마 번호 : " + hrNo + "\n";
		str += "관심 경주마 이름 : " + hrName + "\n";
		str += "=========================================================\n";
		return str;
	}

}
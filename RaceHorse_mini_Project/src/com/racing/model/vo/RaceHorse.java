package com.racing.model.vo;

public class RaceHorse {
	private int rowNum;					  // 순위
	private String hrNo         ;         // 마번
	private String meet	     ;            // 시행경마장명
	private String hrName    ;            // 마명
	private String name	     ;            // 출생지
	private String sex	     ;            // 성별
	private String birthday    ;          // 생년월일
	private String rank	     ;            // 등급
	private String faHrName  ;            // 부마명
	private String moHrName  ;            // 모마명
	private long rcCntT	     ;            // 통산총출주회수
	private int ord1CntT     ;            // 통산1착회수
	private int ord2CntT     ;            // 통산2착회수
	private int ord3CntT     ;            // 통산3착회수
	private long chaksunT     ;            // 통산착순상금
	private String hrLastAmt    ;         // 말도입가
	
	public RaceHorse() {
		super();
	}
	
	// 전체
	public RaceHorse(String hrNo, String meet, String hrName, String name, String sex, String birthday, String rank,
			String faHrName, String moHrName, long rcCntT, int ord1CntT, int ord2CntT, int ord3CntT, long chaksunT,
			String hrLastAmt) {
		super();
		this.hrNo = hrNo;
		this.meet = meet;
		this.hrName = hrName;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.rank = rank;
		this.faHrName = faHrName;
		this.moHrName = moHrName;
		this.rcCntT = rcCntT;
		this.ord1CntT = ord1CntT;
		this.ord2CntT = ord2CntT;
		this.ord3CntT = ord3CntT;
		this.chaksunT = chaksunT;
		this.hrLastAmt = hrLastAmt;
	}

	// 통산총출주회수(rcCntT) 높은순서대로  1-10등까지 출력 	// 통산 착순 상금(chaksunT) 높은 순서대로 1-10등까지 출력
	
	public RaceHorse(int rowNum, String hrNo, String hrName, String sex, String birthday, long rcCntT) {
		super();
		this.rowNum = rowNum;
		this.hrNo = hrNo;
		this.hrName = hrName;
		this.sex = sex;
		this.birthday = birthday;
		this.rcCntT = rcCntT;
		this.chaksunT = rcCntT;
	}
	
	
	// 말도입가(hrLastAmt) 높은 순서대로 1-10등까지 출력
	public RaceHorse(int rowNum, String hrNo, String hrName, String sex, String birthday, String hrLastAmt) {
		super();
		this.rowNum = rowNum;
		this.hrNo = hrNo;
		this.hrName = hrName;
		this.sex = sex;
		this.birthday = birthday;
		this.hrLastAmt = hrLastAmt;
	}
	
	public String toStringForConsole() {
		return  "마번 : " + hrNo + 
				"\n시행경마장명 : " + meet + 
				"\n마명 : " + hrName + 
				"\n출생지 : " + name + 
				"\n성별 : " + sex + 
				"\n생년월일 : " + birthday + 
				"\n등급 : " + rank + 
				"\n부마명 : " + faHrName + 
				"\n모마명 : " + moHrName + 
				"\n통산총출주회 : " + rcCntT + 
				"\n통산1착회수 : " + ord1CntT + 
				"\n통산2착회수 : " + ord2CntT + 
				"\n통산3착회수 : " + ord3CntT + 
				"\n통산착순상금 : " + chaksunT + 
				"\n말도입가 : " + hrLastAmt + 
				"\n=================================";
	}
	
	 public String  toStringForConsoleRankRcCntT() {
		 return "순위 : " + rowNum +                      
				 "\n마번 : " + hrNo +                  
				 "\n마명 : " + hrName +                    
				 "\n성별 : " + sex +                       
				 "\n생년월일 : " + birthday +                
				 "\n통산총출주회 : " + rcCntT +                
				 "\n=================================";  
	 }
	 
	 public String  toStringForConsoleRankChaksunT() {
		 return "순위 : " + rowNum +                      
				 "\n마번 : " + hrNo +                  
				 "\n마명 : " + hrName +                    
				 "\n성별 : " + sex +                       
				 "\n생년월일 : " + birthday +                
				 "\n통산착순상금 : " + chaksunT + "원" +            
				 "\n=================================";  
	 }
	 
	 public String  toStringForConsoleRankHrLastAmt() {
		 return "순위 : " + rowNum +                      
				 "\n마번 : " + hrNo +                  
				 "\n마명 : " + hrName +                    
				 "\n성별 : " + sex +                       
				 "\n생년월일 : " + birthday +                
				 "\n말도입가 : " + hrLastAmt + "(천원)" +           
				 "\n=================================";  
	 }
	 

	public String getHrNo() {
		return hrNo;
	}



	public void setHrNo(String hrNo) {
		this.hrNo = hrNo;
	}

	public String getMeet() {
		return meet;
	}

	public void setMeet(String meet) {
		this.meet = meet;
	}

	public String getHrName() {
		return hrName;
	}

	public void setHrName(String hrName) {
		this.hrName = hrName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getFaHrName() {
		return faHrName;
	}

	public void setFaHrName(String faHrName) {
		this.faHrName = faHrName;
	}

	public String getMoHrName() {
		return moHrName;
	}

	public void setMoHrName(String moHrName) {
		this.moHrName = moHrName;
	}

	public long getRcCntT() {
		return rcCntT;
	}

	public void setRcCntT(long rcCntT) {
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

	public long getChaksunT() {
		return chaksunT;
	}

	public void setChaksunT(long chaksunT) {
		this.chaksunT = chaksunT;
	}

	public String getHrLastAmt() {
		return hrLastAmt;
	}

	public void setHrLastAmt(String hrLastAmt) {
		this.hrLastAmt = hrLastAmt;
	}

	

	@Override
	public String toString() {
	
		return "raceHorse [hrNo=" + hrNo + ", meet=" + meet + ", hrName=" + hrName + ", name=" + name + ", sex=" + sex
				+ ", birthday=" + birthday + ", rank=" + rank + ", faHrName=" + faHrName + ", moHrName=" + moHrName
				+ ", rcCntT=" + rcCntT + ", ord1CntT=" + ord1CntT + ", ord2CntT=" + ord2CntT + ", ord3CntT=" + ord3CntT
				+ ", chaksunT=" + chaksunT + ", hrLastAmt=" + hrLastAmt + "]";
	}



}
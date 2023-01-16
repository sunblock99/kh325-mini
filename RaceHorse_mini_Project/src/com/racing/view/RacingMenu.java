package com.racing.view;

import java.util.List;

import com.racing.common.Util;
import com.racing.controller.Favorite_HorseController;
import com.racing.controller.Favorite_JockeyController;
import com.racing.controller.JockeyController;
import com.racing.controller.RaceFacilityController;
import com.racing.controller.RaceHorseController;
import com.racing.controller.RacingController;
import com.racing.controller.UserController;
import com.racing.model.vo.Favorite_Horse;
import com.racing.model.vo.Favorite_Jockey;
import com.racing.model.vo.Jockey;
import com.racing.model.vo.RaceFacility;
import com.racing.model.vo.RaceHorse;
import com.racing.model.vo.Racing;

public class RacingMenu {
	private UserController userController = new UserController();
	private Favorite_JockeyController favorite_JockeyController = new Favorite_JockeyController();
	private Favorite_HorseController favorite_HorseController = new Favorite_HorseController();
	private JockeyController jockeyController = new JockeyController();
	private RaceHorseController raceHorseController = new RaceHorseController();
	private RacingController racingController = new RacingController();
	private RaceFacilityController raceFacilityController = new RaceFacilityController();

	// 메인메뉴
	public void mainMenu() {

		String menu = "======= 환영합니다! 한국서울마사회입니다. ======\n" 
				+ "	1. 로그인\n" 
				+ "	2. 경주정보조회\n" 
				+ "	3. 경주마정보조회\n"
				+ "	4. 기수정보조회\n" 
				+ "	5. 부대시설조회\n" 
				+ "	0. 종료\n" 
				+ "----------------------------------------\n"
				+ "메뉴번호를 입력해주세요  : ";
		while (true) {
			System.out.print(menu);
			int num = Util.readIntForConsol();
			switch (num) {
			case 1:
				login();
				break;
			case 2:
				racingMenu();
				break;
			case 3:
				raceHorseMenu();
				break;
			case 4:
				jockeyMenu();
				break;
			case 5:
				racingFacilityMenu();
				break;
			case 0:
                while(true) {
                    System.out.print("정말로 종료 하시겠습니까?(y/n) : ");
                    String end = Util.readStrForConsol().toUpperCase();
                    if(end.toUpperCase().equals("Y")) {
                        System.out.println("\n--------------- 종료합니다. ---------------\n" 
                                + "---- 한국서울마사회에 방문해주셔서 감사합니다. ----\n");
                        System.exit(0);
                    }else if(end.toUpperCase().equals("N")) {
                        mainMenu();
                        break;
                    }else if (!end.toUpperCase().equals("Y") && !end.toUpperCase().equals("N")) {
                        System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
                    }
                    continue;
                }
                break;
            default:
                System.out.println("잘못된 번호입니다. 다시 입력해주세요.\n");
                continue;
            }
            return;
        }
    }
	// 마이페이지
	public void loginMenu() {

		String menu = "================ 마이페이지 ==============\n" 
				+ "	1. 나의찜\n" 
				+ "	2. 경주정보조회\n" 
				+ "	3. 경주마정보조회\n"
				+ "	4. 기수정보조회\n" 
				+ "	5. 부대시설조회\n" 
				+ "	0. 로그아웃\n" 
				+ "----------------------------------------\n"
				+ "메뉴번호를 선택해주세요  : ";
		while (true) {
			System.out.print(menu);
			int num = Util.readIntForConsol();
			switch (num) {
			case 1:
				favoriteMenu();
				break;
			case 2:
				racingMenu();
				break;
			case 3:
				raceHorseMenu();
				break;
			case 4:
				jockeyMenu();
				break;
			case 5:
				racingFacilityMenu();
				break;
			case 0:
				UserController.logout();
				System.out.println("로그아웃 되었습니다.");
				mainMenu();
				return;
			default:
				System.out.println("일치하지 않는 번호입니다. 다시 입력해주세요.");
				break;
			}

		}
	}

	// 로그인
	public void login() {
		while (true) {
			System.out.print("	ID : ");
			String id = Util.readStrForConsol();
			System.out.print("	PW : ");
			String pw = Util.readStrForConsol();
			boolean login = userController.login(id, pw);
			if (login == true) {
				System.out.println("로그인에 성공하였습니다!");
				loginMenu();
				break;
			} else {
				System.out.println("사용자 정보가 정확하지 않습니다. 다시 한번 확인해 보시기 바랍니다.");
			}
		}
	}

	// 즐겨찾기메뉴
	public void favoriteMenu() {
		String menu = "================ 찜메뉴 ================\n" 
				+ "---------------- 경주마 ----------------\n"
				+ "	1. 경주마 찜목록\n" 
				+ "	2. 경주마 찜하기\n" 
				+ "	3. 경주마 찜수정\n" 
				+ "---------------- 기  수 ----------------\n"
				+ "	4. 기수 찜목록\n" 
				+ "	5. 기수 찜하기\n" 
				+ "	6. 기수 찜수정\n" 
				+ "	0. 마이페이지로 돌아가기\n"
				+ "---------------------------------------\n" 
				+ "메뉴번호를 선택해주세요 : ";

		while (true) {
			int result = 1;
			System.out.println(menu);
			int num = Util.readIntForConsol();
			switch (num) {
			case 1:
				favoriteHrList();
				break;
			case 2:
				int hrUNO1 = UserController.getLoginUser().getuNo();
				System.out.print("찜 추가하실 마번을 입력해주세요 : ");
				String hrNo1 = Util.readStrForConsol();
				result = favorite_HorseController.insert(hrUNO1, hrNo1);
				System.out.println(result < 1 ? "실패 하였습니다." : "성공하였습니다.");
				returnButton();
				break;
			case 3:
				int hrUNO2 = UserController.getLoginUser().getuNo();
				System.out.print("찜 삭제하실 마번을 입력해주세요 : ");
				String hrNo2 = Util.readStrForConsol();
				result = favorite_HorseController.delete(hrUNO2, hrNo2);
				System.out.println(result < 1 ? "실패 하였습니다." : "성공하였습니다.");
				returnButton();
				break;
			case 4:
				favoriteJkList();
				break;
			case 5:
				int jkUNO1 = UserController.getLoginUser().getuNo();
				System.out.print("찜추가하실 기수번호을 입력해주세요 : ");
				String jkNo1 = Util.readStrForConsol();
				result = favorite_JockeyController.insert(jkUNO1, jkNo1);
				System.out.println(result < 1 ? "실패 하였습니다." : "성공하였습니다.");
				returnButton();
				break;
			case 6:
				int jkUNO2 = UserController.getLoginUser().getuNo();
				System.out.print("찜삭제하실 기수번호을 입력해주세요 : ");
				String jkNo2 = Util.readStrForConsol();
				result = favorite_JockeyController.delete(jkUNO2, jkNo2);
				System.out.println(result < 1 ? "실패 하였습니다." : "성공하였습니다.");
				returnButton();
				break;
			case 0:
				return;
			default:
				System.out.println("일치하지 않는 번호입니다. 다시 입력해주세요.");
				break;
			}
		}
	}

	// 경주마 즐겨찾기 메뉴
	public void favoriteHrList() {
		String menu = "================ 찜목록 ================\n" 
				+ "---------------- 경주마 ----------------\n"
				+ "	1. 경주마 찜 전체 출력\n" 
				+ "	2. 경주마 마번으로 검색\n" 
				+ "	3. 경주마 마명으로 검색\n" 
				+ "	0. 뒤로 돌아가기\n" 
				+ "---------------------------------------\n" 
				+ "메뉴번호를 선택해주세요 : ";
		while (true) {
			int count = 1;
			List<Favorite_Horse> fhList = null;

			System.out.println(menu);
			int num = Util.readIntForConsol();
			switch (num) {
			case 1:
				@SuppressWarnings("all")
				int uNo1 = userController.getLoginUser().getuNo();
				fhList = favorite_HorseController.selectAll(uNo1);
				if (fhList.size() < 1) {
					System.out.println("찜이 존재하지 않습니다.");
				} else {
					for (Favorite_Horse item : fhList) {
						System.out.println(count++ + "번째 관심 경주마 입니다.");
						System.out.println(item.toStringForConsole());
					}
				}
				returnButton();
				break;
			case 2:
				System.out.print("마번을 입력하세요 : ");
				String hrNo = Util.readStrForConsol();
				@SuppressWarnings("all")
				int uNo2 = userController.getLoginUser().getuNo();
				fhList = favorite_HorseController.selectByHorseNumber(uNo2,hrNo);
				if (fhList.size() < 1) {
					System.out.println("찜이 존재하지 않습니다.");
				} else {
					for (Favorite_Horse item : fhList) {
						System.out.println(count++ + "번째 관심 경주마 입니다.");
						System.out.println(item.toStringForConsole());
					}
				}
				returnButton();
				break;
			case 3:
				System.out.print("마명을 입력하세요 : ");
				String hrName = Util.readStrForConsol();
				@SuppressWarnings("all")
				int uNo3 = userController.getLoginUser().getuNo();
				fhList = favorite_HorseController.selectByName(uNo3,hrName);
				if (fhList.size() < 1) {
					System.out.println("찜이 존재하지 않습니다.");
				} else {
					for (Favorite_Horse item : fhList) {
						System.out.println(count++ + "번째 관심 경주마 입니다.");
						System.out.println(item.toStringForConsole());
					}
				}
				returnButton();
				break;
			case 0:
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			default:
				System.out.println("일치하지 않는 번호입니다. 다시 입력해주세요.");
				break;
			}
		}
	}

	// 기수 즐겨찾기 메뉴
	public void favoriteJkList() {
		String menu = "================ 찜목록 ================\n" 
				+ "---------------- 기수 ----------------\n"
				+ "	1. 기수 찜 전체 출력\n" 
				+ "	2. 기수 기수번호으로 검색\n" 
				+ "	3. 기수 기수명으로 검색\n" 
				+ "	0. 뒤로 돌아가기\n" 
				+ "---------------------------------------\n" 
				+ "메뉴번호를 선택해주세요 : ";
		while (true) {
			int count = 1;
			List<Favorite_Jockey> fjList = null;
			System.out.println(menu);
			int num = Util.readIntForConsol();
			switch (num) {
			case 1:
				@SuppressWarnings("all")
				int uNo1 = userController.getLoginUser().getuNo();
				fjList = favorite_JockeyController.selectAll(uNo1);
				if (fjList.size() < 1) {
					System.out.println("찜이 존재하지 않습니다.");
				} else {
					for (Favorite_Jockey item : fjList) {
						System.out.println(count++ + "번째 관심 기수 입니다.");
						System.out.println(item.toStringForConsole());
					}
				}
				returnButton();
				break;
			case 2:
				System.out.print("기수번호를 입력하세요 : ");
				String jkNo = Util.readStrForConsol();
				@SuppressWarnings("all")
				int uNo2 = userController.getLoginUser().getuNo();
				fjList = favorite_JockeyController.selectByJockeyNumber(uNo2,jkNo);
				if (fjList.size() < 1) {
					System.out.println("찜이 존재하지 않습니다.");
				} else {
					for (Favorite_Jockey item : fjList) {
						System.out.println(count++ + "번째 관심 기수 입니다.");
						System.out.println(item.toStringForConsole());
					}
				}
				returnButton();
				break;
			case 3:
				System.out.print("기수명을 입력하세요 : ");
				String jockeyName = Util.readStrForConsol();
				@SuppressWarnings("all")
				int uNo3 = userController.getLoginUser().getuNo();
				fjList = favorite_JockeyController.selectByName(uNo3,jockeyName);
				if (fjList.size() < 1) {
					System.out.println("찜이 존재하지 않습니다.");
				} else {
					for (Favorite_Jockey item : fjList) {
						System.out.println(count++ + "번째 관심 기수 입니다.");
						System.out.println(item.toStringForConsole());
					}
				}
				returnButton();
				break;
			case 0:
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			default:
				System.out.println("일치하지 않는 번호입니다. 다시 입력해주세요.");
				break;
			}
		}
	}

	// 경기정보메뉴
	public void racingMenu() {
		String menu = "=============== 경주정보조회 ==============\n" 
				+ "	1. 날짜로 검색\n" 
				+ "	2. '마명' 검색\n"
				+ "	3. '기수명' 검색\n" 
				+ "	0. 메인메뉴로 돌아가기\n" 
				+ "------------------------------------\n" 
				+ "메뉴번호를 선택해주세요 : ";

		while (true) {
			int result = 1;
			List<Racing> rcList = null;
			System.out.println(menu);
			int num = Util.readIntForConsol();
			switch (num) {
			case 1:
				System.out.print("조회하고자 하는 '날짜를 입력'하여 주십시오.(YYYYDDMM) : ");
				String rcDate = Util.readStrForConsol();
				rcList = racingController.selectDate(rcDate);
				System.out.print(rcDate + "에는 총 " + rcList.size() + "번의 경기가 있었습니다\n");
				if (rcList.size() != 0) {
					System.out.print("조회하고자 하는 '경기 번호를 입력'하여 주십시오 : ");
					int rcNo = Util.readIntForConsol();
					rcList = racingController.selectDateNo(rcDate, rcNo);
					if (rcList.size() < 1) {
						System.out.println("해당 경기는 존재하지 않습니다.");
					} else {
						for (Racing item : rcList) {
							System.out.println(item.toStringrcOrd());
						}

					}
				}
				returnButton();
				break;
			case 2:
				System.out.print("조회하고자 하는 '마명을 입력'하여 주십시오. 예) 라임, 소피아 : ");
				String hrName = Util.readStrForConsol();
				rcList = racingController.selectByHrName(hrName);
				if (rcList.size() < 1) {
					System.out.println("해당 경주마는 존재하지 않습니다.");
				} else {

					for (Racing item : rcList) {
						System.out.println(item.toString());
					}
					if (UserController.loginUser != null) {
						System.out.print("찜 하시려면 'Y'를, 아니면 아무 문자를 입력하세요 : ");
						char go = Util.readStrForConsol().toUpperCase().charAt(0);
						if (go == 'Y') {
							int hrUNO1 = UserController.getLoginUser().getuNo();
							System.out.print("찜추가하실 마명을 입력해주세요 : ");
							String hrName1 = Util.readStrForConsol();
							result = favorite_HorseController.insertHorseName(hrUNO1, hrName1);
							System.out.println(result < 1 ? "실패 하였습니다." : "성공하였습니다.");
						}
					}
				}
				returnButton();
				break;
			case 3:
				System.out.print("조회하고자 하는 '기수명을 입력'하여 주십시오. 예) 선형채, 윤하영 : ");
				String jkName = Util.readStrForConsol();
				rcList = racingController.selectByJkName(jkName);
				if (rcList.size() < 1) {
					System.out.println("해당 기수는 존재하지 않습니다.");
				} else {
					for (Racing item : rcList) {
						System.out.println(item.toString());
					}
					if (UserController.loginUser != null) {
						System.out.print("찜 하시려면 'Y'를, 아니면 아무 문자를 입력하세요 : ");
						char go = Util.readStrForConsol().toUpperCase().charAt(0);
						if (go == 'Y') {
							int jkUNO1 = UserController.getLoginUser().getuNo();
							System.out.print("찜추가하실 기수번호을 입력해주세요 : ");
							String jkNo1 = Util.readStrForConsol();
							result = favorite_JockeyController.insert(jkUNO1, jkNo1);
							System.out.println(result < 1 ? "실패 하였습니다." : "성공하였습니다.");
						}
					}
				}
				returnButton();
				break;
			case 0:
				if (UserController.loginUser != null) {
					loginMenu();
					return;
				} else {
					mainMenu();
					return;
				}
			default:
				System.out.println("일치하지 않는 번호입니다. 다시 입력해주세요.");
				break;
			}
		}

	}

	// 경주마메뉴
	public void raceHorseMenu() {
		String menu = "============= 경주마정보조회 ==============\n" 
				+ "	1. '마명' 검색\n" 
				+ "	2. '마번' 검색\n"
				+ "	3. [통산총출주회수] 랭킹 TOP 10\n" 
				+ "	4. [말도입가] 랭킹 TOP 10\n" 
				+ "	5. [상금] 랭킹 TOP 10\n"
				+ "	0. 메인메뉴로 돌아가기\n" 
				+ "------------------------------------\n" 
				+ "메뉴번호를 선택해주세요 : ";
		
		while (true) {
			int result = 1;
			List<RaceHorse> rhList = null;
			System.out.println(menu);
			int num = Util.readIntForConsol();
			switch (num) {
			case 1:
				System.out.print("조회하고자 하는 '마명을 입력'하여 주십시오. 예) 라임, 소피아 : ");
				String hrName = Util.readStrForConsol();
				rhList = raceHorseController.selectByHorseName(hrName);
				if (rhList.size() < 1) {
					System.out.println("해당 경주마는 존재하지 않습니다.");
				} else {
					printRaceHorse(rhList);
					if (UserController.loginUser != null) {
						System.out.print("찜 하시려면 'Y'를, 아니면 아무 문자를 입력하세요 : ");
						char go = Util.readStrForConsol().toUpperCase().charAt(0);
						if (go == 'Y') {
							int hrUNO1 = UserController.getLoginUser().getuNo();
							System.out.print("찜추가하실 마명을 입력해주세요 : ");
							String hrName1 = Util.readStrForConsol();
							result = favorite_HorseController.insertHorseName(hrUNO1, hrName1);
							System.out.println(result < 1 ? "실패 하였습니다." : "성공하였습니다.");
						}
					}
				}
					returnButton();
					break;
			case 2:
				System.out.print("조회하고자 하는 마번 를 입력하여 주십시오. 예) 0045418 : ");
				String hrNo = Util.readStrForConsol();
				rhList = raceHorseController.selectByHorseNo(hrNo);
				if (rhList.size() < 1) {
					System.out.println("해당 경주마는 존재하지 않습니다.");
				} else {
					printRaceHorse(rhList);
					if (UserController.loginUser != null) {
						System.out.print("찜 하시려면 'Y'를, 아니면 아무 문자를 입력하세요 : ");
						char go = Util.readStrForConsol().toUpperCase().charAt(0);
						if (go == 'Y') {
							int hrUNO1 = UserController.getLoginUser().getuNo();
							System.out.print("찜추가하실 마번을 입력해주세요 : ");
							String hrNo1 = Util.readStrForConsol();
							result = favorite_HorseController.insert(hrUNO1, hrNo1);
							System.out.println(result < 1 ? "실패 하였습니다." : "성공하였습니다.");
						}
					}
				}
					returnButton();
					break;
			case 3:
				System.out.println("[통산총출주회수] 랭킹 TOP 10 목록입니다. ");
				rhList = raceHorseController.selectByrcCntT();
				printRaceHorseRcCntT(rhList);
				if (UserController.loginUser != null) {
					System.out.print("찜 하시려면 'Y'를, 아니면 아무 문자를 입력하세요 : ");
					char go = Util.readStrForConsol().toUpperCase().charAt(0);
					if (go == 'Y') {
						int hrUNO1 = UserController.getLoginUser().getuNo();
						System.out.print("찜추가하실 마번을 입력해주세요 : ");
						String hrNo1 = Util.readStrForConsol();
						result = favorite_HorseController.insert(hrUNO1, hrNo1);
						System.out.println(result < 1 ? "실패 하였습니다." : "성공하였습니다.");
					}
				}
					returnButton();
					break;
			case 4:
				System.out.println("[말도입가] 랭킹 TOP 10 목록입니다. ");
				rhList = raceHorseController.selectByhrLastAmt();
				printRaceHorseHrLastAmt(rhList);
				if (UserController.loginUser != null) {
					System.out.print("찜 하시려면 'Y'를, 아니면 아무 문자를 입력하세요 : ");
					char go = Util.readStrForConsol().toUpperCase().charAt(0);
					if (go == 'Y') {
						int hrUNO1 = UserController.getLoginUser().getuNo();
						System.out.print("찜추가하실 마명을 입력해주세요 : ");
						String hrName1 = Util.readStrForConsol();
						result = favorite_HorseController.insertHorseName(hrUNO1, hrName1);
						System.out.println(result < 1 ? "실패 하였습니다." : "성공하였습니다.");
					}
				}
					returnButton();
					break;
			case 5:
				System.out.println("[상금] 랭킹 TOP 10 목록입니다. ");
				rhList = raceHorseController.selectBychaksunT();
				printRaceHorseChaksunT(rhList);
				if (UserController.loginUser != null) {
					System.out.print("찜 하시려면 'Y'를, 아니면 아무 문자를 입력하세요 : ");
					char go = Util.readStrForConsol().toUpperCase().charAt(0);
					if (go == 'Y') {
						int hrUNO1 = UserController.getLoginUser().getuNo();
						System.out.print("찜추가하실 마명을 입력해주세요 : ");
						String hrName1 = Util.readStrForConsol();
						result = favorite_HorseController.insertHorseName(hrUNO1, hrName1);
						System.out.println(result < 1 ? "실패 하였습니다." : "성공하였습니다.");
					}
				}
					returnButton();
					break;
			case 0:
				if (UserController.loginUser != null) {
					loginMenu();
					return;
				} else {
					mainMenu();
					return;
				}
			default:
				System.out.println("일치하지 않는 번호입니다. 다시 입력해주세요.");
				break;
			}
		}
	}

	// 기수 메뉴
	public void jockeyMenu() {
		String menu = "=============== 기수정보조회 ===============\n" 
				+ "	1. '기수명' 검색\n" 
				+ "	2. '기수번호' 검색\n"
				+ "	3. [통산총출주회수] 랭킹 TOP 10\n" 
				+ "	4. [1착/2착/3착 횟수] 랭킹 TOP 10\n" 
				+ "	0. 메인메뉴로 돌아가기\n"
				+ "-----------------------------------------\n" 
				+ "메뉴번호를 선택해주세요 : ";

		while (true) {
			int result = 1;
			List<Jockey> jkList = null;
			System.out.println(menu);
			int num = Util.readIntForConsol();
			switch (num) {
			case 1:
				System.out.print("조회하고자 하는 '기수명을 입력'하여 주십시오. 예) 선형채, 윤하영 : ");
				String jkName = Util.readStrForConsol();
				jkList = jockeyController.selectByJkName(jkName);
				if (jkList.size() < 1) {
					System.out.println("해당 기수는 존재하지 않습니다.");
				} else {
					for (Jockey item : jkList) {
						System.out.println(item.toStringForConsole1());
					}
					if (UserController.loginUser != null) {
						System.out.print("찜 하시려면 'Y'를, 아니면 아무 문자를 입력하세요 : ");
						char go = Util.readStrForConsol().toUpperCase().charAt(0);
						if (go == 'Y') {
							int jkUNO1 = UserController.getLoginUser().getuNo();
							System.out.print("찜추가하실 기수명을 입력해주세요 : ");
							String jkName1 = Util.readStrForConsol();
							result = favorite_JockeyController.insertJockeyName(jkUNO1, jkName1);
							System.out.println(result < 1 ? "실패 하였습니다." : "성공하였습니다.");
						}
					}
				}
					returnButton();
					break;
			case 2:
				System.out.print("조회하고자 하는 기수번호를 입력하여 주십시오. 예) 080029 : ");
				String jkNo = Util.readStrForConsol();
				jkList = jockeyController.selectByJkNo(jkNo);
				if (jkList.size() < 1) {
					System.out.println("해당 기수는 존재하지 않습니다.");
				} else {
					for (Jockey item : jkList) {
						System.out.println(item.toStringForConsole1());
					}
					if (UserController.loginUser != null) {
						System.out.print("찜 하시려면 'Y'를, 아니면 아무 문자를 입력하세요 : ");
						char go = Util.readStrForConsol().toUpperCase().charAt(0);
						if (go == 'Y') {
							int jkUNO1 = UserController.getLoginUser().getuNo();
							System.out.print("찜추가하실 기수번호를 입력해주세요 : ");
							String jkNo1 = Util.readStrForConsol();
							result = favorite_JockeyController.insert(jkUNO1, jkNo1);
							System.out.println(result < 1 ? "실패 하였습니다." : "성공하였습니다.");
						}
					}
				}
					returnButton();
					break;
			case 3:
				System.out.println("[통산총출주회수] 랭킹 TOP 10 목록입니다. ");
				jkList = jockeyController.rankedByRcCntT();
				for (Jockey item : jkList) {
					System.out.println(item.toStringForConsole());
				}
				if (UserController.loginUser != null) {
					System.out.print("찜 하시려면 'Y'를, 아니면 아무 문자를 입력하세요 : ");
					char go = Util.readStrForConsol().toUpperCase().charAt(0);
					if (go == 'Y') {
						int jkUNO1 = UserController.getLoginUser().getuNo();
						System.out.print("찜추가하실 기수번호을 입력해주세요 : ");
						String jkNo1 = Util.readStrForConsol();
						result = favorite_JockeyController.insert(jkUNO1, jkNo1);
						System.out.println(result < 1 ? "실패 하였습니다." : "성공하였습니다.");
					}
				}
				returnButton();
				break;
			case 4:
				System.out.println("[1착/2착/3착 횟수] 랭킹 TOP 10 목록입니다. ");
				jkList = jockeyController.rankedByOrd1CntT();
				for (Jockey item : jkList) {
					System.out.println(item.toStringForConsole());
				}
				if (UserController.loginUser != null) {
					System.out.print("찜 하시려면 'Y'를, 아니면 아무 문자를 입력하세요 : ");
					char go = Util.readStrForConsol().toUpperCase().charAt(0);
					if (go == 'Y') {
						int jkUNO1 = UserController.getLoginUser().getuNo();
						System.out.print("찜추가하실 기수번호를 입력해주세요 : ");
						String jkNo1 = Util.readStrForConsol();
						result = favorite_JockeyController.insert(jkUNO1, jkNo1);
						System.out.println(result < 1 ? "실패 하였습니다." : "성공하였습니다.");
					}
				}
				returnButton();
				break;
			case 0:
				if (UserController.loginUser != null) {
					loginMenu();
					return;
				} else {
					mainMenu();
					return;
				}
			default:
				System.out.println("일치하지 않는 번호입니다. 다시 입력해주세요.");
				break;
			}
		}
	}

	// 부대시설 메뉴
	public void racingFacilityMenu() {
		String menu = "================ 부대시설조회 ==============\n" 
				+ "	1. 검색하기\n" 
				+ "	2. 카테고리로 보기\n"
				+ "	0. 메인메뉴로 돌아가기\n" 
				+ "----------------------------------------\n" 
				+ "메뉴번호를 선택해주세요 : ";

		while (true) {
			List<RaceFacility> rfList = null;
			System.out.println(menu);
			int num = Util.readIntForConsol();
			switch (num) {
			case 1:
				System.out.print("검색할 시설명을 입력하세요 예) 어린이승마장, 편의점, 롯데리아 : ");
				String facTitle = Util.readStrForConsol();
				rfList = raceFacilityController.selectBySearchFltTitle(facTitle);
				if (rfList.size() < 1) {
					System.out.println("해당 시설명은 존재하지 않습니다.");
				} else {
					printRaceFacility(rfList);
				}
				returnButton();
				break;
			case 2:
				catRFmenu();
				break;
			case 0:
				if (UserController.loginUser != null) {
					loginMenu();
					return;
				} else {
					mainMenu();
					return;
				}
			default:
				System.out.println("일치하지 않는 번호입니다. 다시 입력해주세요.");
				break;
			}
		}

	}

	private void catRFmenu() {
		String catMenu = "================ 부대시설 카테고리 ==============\n" 
				+ "	1. 먹거리\n" 
				+ "	2. 볼거리\n" 
				+ "	3. 즐길거리\n"
				+ "	4. 편의시설\n" 
				+ "	5. 회원전용실\n" 
				+ "	6. 기타\n" 
				+ "	0. 이전메뉴로 돌아가기\n"
				+ "----------------------------------------\n" 
				+ "메뉴번호를 선택해주세요 : ";
		while (true) {
			List<RaceFacility> catList = null;
			System.out.println(catMenu);
			int catNum = Util.readIntForConsol();
			switch (catNum) {
			case 1:
				catList = raceFacilityController.selectByFood();
				printRaceFacility(catList);
				returnButton();
				break;
			case 2:
				catList = raceFacilityController.selectBySee();
				printRaceFacility(catList);
				returnButton();
				break;
			case 3:
				catList = raceFacilityController.selectByFun();
				printRaceFacility(catList);
				returnButton();
				break;
			case 4:
				catList = raceFacilityController.selectByFac();
				printRaceFacility(catList);
				returnButton();
				break;
			case 5:
				catList = raceFacilityController.selectByMemOnly();
				printRaceFacility(catList);
				returnButton();
				break;
			case 6:
				catList = raceFacilityController.selectByEtc();
				printRaceFacility(catList);
				returnButton();
				break;
			case 0:
				System.out.println("이전 메뉴로 돌아갑니다");
				return;
			default:
				System.out.println("일치하지 않는 번호입니다. 다시 입력해주세요.");
				break;

			}
		}
	}

	private void printRaceFacility(List<RaceFacility> list) {
		System.out.println("================== 조회 건수 총 :" + list.size() + "건 ===================");
		for (RaceFacility item : list) {
			System.out.println(item.toStringForConsole());
		}
		System.out.println("=================================================================\n");
	}

	// 경주마 출력
	private void printRaceHorse(List<RaceHorse> list) {
		System.out.println("================== 조회 건수 총 :" + list.size() + "건 ===================");
		for (RaceHorse item : list) {
			System.out.println(item.toStringForConsole());
		}
		System.out.println("=================================================================\n");
	}

	// 경주마 출주회(rcCntT) 출력
	private void printRaceHorseRcCntT(List<RaceHorse> list) {
		System.out.println("================== 조회 건수 총 :" + list.size() + "건 ===================");
		for (RaceHorse item : list) {
			System.out.println(item.toStringForConsoleRankRcCntT());
		}
		System.out.println("=================================================================\n");
	}

	// 경주마 도입가(hrLastAmt) 출력
	private void printRaceHorseHrLastAmt(List<RaceHorse> list) {
		System.out.println("================== 조회 건수 총 :" + list.size() + "건 ===================");
		for (RaceHorse item : list) {
			System.out.println(item.toStringForConsoleRankHrLastAmt());
		}
		System.out.println("=================================================================\n");
	}

	// 경주마 상금(chaksunT) 출력
	private void printRaceHorseChaksunT(List<RaceHorse> list) {
		System.out.println("================== 조회 건수 총 :" + list.size() + "건 ===================");
		for (RaceHorse item : list) {
			System.out.println(item.toStringForConsoleRankChaksunT());
		}
		System.out.println("=================================================================\n");
	}

	public void returnButton() {
		System.out.println("\n---------------- 정보조회완료 ---------------\n" 
							+ "-> 아무 문자를 입력하면 이전메뉴로 이동됩니다.");
		Util.readNoTextForConsol();
	}

	public static void main(String[] args) {
		new RacingMenu().mainMenu();
		System.out.println("---- 프로그램 종료 ----");
	}

	public void inputNum6() {
		// 0 누르면 돌아가게끔 해달라는 코드가 이거고 String 비교할때 == 쓰면 안됩니다. equals에요.
		while (true) {
			System.out.println("정수 6글자를 입력해주세요.");
			String str = Util.readStrForConsol();
			if (str.equals("%6d")) {
				break;
			}
		}

	}
}

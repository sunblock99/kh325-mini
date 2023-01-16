package com.racing.api;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.racing.model.vo.RaceFacility;

public class RaceFacilityOpenApiManager {
	public static String key = "lzhpNoakCHo5aenwJe7kub6egAg%2FlsfQ9QbSTSGrD%2F3JDieSA91XYej7TpMMWphOX%2BnHR7ZUVXj8lS6wP4ROig%3D%3D";
	public static String XML_URL = "http://apis.data.go.kr/B551015/API201/RaceFacility";

	public static void main(String[] args) {
		RaceFacilityOpenApiManager.callRaceFacilityListByXML();
	}

	public static List<RaceFacility> callRaceFacilityListByXML() {
		List<RaceFacility> rList = new ArrayList<RaceFacility>();
		try {
			// 1. URL을 가공하는 코드 시작
			StringBuilder urlBuilder = new StringBuilder(XML_URL); /* URL */
			urlBuilder.append("?" + "ServiceKey=" + key); // 첫 번째만 물음표로 설정
			urlBuilder.append("&" + "numOfRows=" + "1000");
			urlBuilder.append("&" + "pageNo=" + "1");
			System.out.println(urlBuilder);
			// 1. URL을 가공하는 코드 끝!

			// 2. URL을 HTTP객체를 통해 요청하는 코드 시작
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			// setRequestProperty 이 부분의 코드는 OPEN API마다 다름으로 권장하는 방식으로 요청할것!
//			conn.setRequestProperty("Content-type", "application/json");
			conn.setRequestProperty("Accept", "application/xml");

			int code = conn.getResponseCode(); // 실제 요청하는 부
			System.out.println("ResponseCode : " + code);
			if (code < 200 || code >= 300) {
				System.out.println("페이지가 잘못되었습니다.");
				return rList;
			}
			// 2. URL을 HTTP객체를 통해 요청하는 코드 종료

			// 3. 페이지 Parsing부 (해석부) 시작
			// DocumentBuilderFactory
			// https://pangtrue.tistory.com/222
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(conn.getInputStream()); // xml부를 가져와 파싱할 준비 완료!
			doc.normalizeDocument(); // xml을 표준으로 다시 정리해주는 기능 -> 해도되고 안해도 될수도 있으나.
			// 셋팅부 끝!

			NodeList itemList = doc.getElementsByTagName("item");

			System.out.println(itemList.getLength());
			for (int i = 0; i < itemList.getLength(); i++) {
				Node node = itemList.item(i);

				String fltSeq = getData(node, "fltSeq");
				String fltTitle = getData(node, "fltTitle");
				String fltEcodeName = getData(node, "fltEcodeName");
				String fltEndday = getData(node, "fltEndday");
				String fltHour = getData(node, "fltHour");
				String fltLcodeName = getData(node, "fltLcodeName");
				String fltMcodeName = getData(node, "fltMcodeName");
				String fltObjText = getData(node, "fltObjText");
				String fltPositionAdd = getData(node, "fltPositionAdd");
				String fltRentStatusName = getData(node, "fltRentStatusName");
				String fltScodeName = getData(node, "fltScodeName");
				String fltStatusName = getData(node, "fltStatusName");
				String fltText = getData(node, "fltText");
				RaceFacility raceFacility = new RaceFacility(fltSeq, fltTitle, fltEcodeName, fltEndday, fltHour,
						fltLcodeName, fltMcodeName, fltObjText, fltPositionAdd, fltRentStatusName, fltScodeName,
						fltStatusName, fltText);
				rList.add(raceFacility);
				System.out.println(raceFacility);
			}
			// 3. 페이지 Parsing부 (해석부) 종료

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rList;
	}

	public static String getData(Node node, String name) {
		try {
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				return "" + eElement.getElementsByTagName(name).item(0).getTextContent();
			}
		} catch (Exception e) {
		}
		return "";
	}

}

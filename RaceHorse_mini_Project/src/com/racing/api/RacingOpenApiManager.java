package com.racing.api;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.racing.model.vo.Racing;

public class RacingOpenApiManager {
	public static String key = "pfrapdaIE4JSQTQlbaf%2FgQ5PHzhztyuhwsMSut4RNds4eIJE5iXE6%2F0WwwqeizAeieFOgSqPaRZN1PXF0bjYwA%3D%3D";
	public static String XML_URL = "http://apis.data.go.kr/B551015/API186/SeoulRace";

	public static void main(String[] args) {
		RacingOpenApiManager.callRacingListByXML();
	}

	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	public static List<Racing> callRacingListByXML() {
		List<Racing> rList = new ArrayList<>();
		StringBuilder urlBuilder = new StringBuilder(XML_URL);
		urlBuilder.append("?" + "ServiceKey=" + key); // 첫 번째만 물음표로 설정
		urlBuilder.append("&" + "pageNo=" + "1");
		urlBuilder.append("&" + "numOfRows=" + "1976");
		urlBuilder.append("&" + "rc_date_fr=" + "20191222");
		urlBuilder.append("&" + "rc_date_to=" + "20200222");
		System.out.println(urlBuilder);
		try {
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/xml");

			int code = conn.getResponseCode(); // 실제 요청하는 부
			System.out.println("ResponseCode : " + code);
			if (code < 200 || code >= 300) {
				System.out.println("페이지가 잘못되었습니다.");
				return null;
			}

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(conn.getInputStream());
			doc.normalizeDocument();

			NodeList itemList = doc.getElementsByTagName("item");

			System.out.println(itemList.getLength());

			for (int i = 0; i < itemList.getLength(); i++) {
				Node node = itemList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					try {
						Element eElement = (Element) node;

						int rNo = getIntData(eElement, "rNO");
						String rcDate = getStrData(eElement, "rcDate");
						int rcNo = getIntData(eElement, "rcNo");
						int rcDist = getIntData(eElement, "rcDist");
						int rcOrd = getIntData(eElement, "rcOrd");
						double rcTime = getDoubleData(eElement, "rcTime");
						int rcChul = getIntData(eElement, "rcChul");
						String hrno = getStrData(eElement, "hrno");
						String hrName = getStrData(eElement, "hrName");
						int wgHr = getIntData(eElement, "wgHr");
						String jkNo = getStrData(eElement, "jkNo");
						String jkName = getStrData(eElement, "jkName");
						int chaksun = getIntData(eElement, "chaksun");
						String weath = getStrData(eElement, "weath");

						Racing rc_info = new Racing(rNo, rcDate, rcNo, rcDist, rcOrd, rcTime, rcChul, hrno, hrName,
								wgHr, jkNo, jkName, chaksun, weath);
						rList.add(rc_info);
						System.out.println(rc_info.toString());
					} catch (Exception e) {
						System.out.println("데이터가 잘못되었습니다");
						e.printStackTrace();
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rList;
	}

	private static String getStrData(Element eElement, String tagName) {
		try {
			return eElement.getElementsByTagName(tagName).item(0).getTextContent();
		} catch (Exception e) {
			return "-";
		}
	}

	private static int getIntData(Element eElement, String tagName) {
		try {
			return Integer.parseInt(eElement.getElementsByTagName(tagName).item(0).getTextContent());
		} catch (Exception e) {
			return 0;
		}
	}

	private static double getDoubleData(Element eElement, String tagName) {
		try {
			return Double.parseDouble(eElement.getElementsByTagName(tagName).item(0).getTextContent());
		} catch (Exception e) {
			return 0;
		}
	}

}

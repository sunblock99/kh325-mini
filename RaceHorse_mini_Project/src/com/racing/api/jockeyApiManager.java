package com.racing.api;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.racing.model.vo.Jockey;

public class jockeyApiManager {
	public static String key = "lzhpNoakCHo5aenwJe7kub6egAg%2FlsfQ9QbSTSGrD%2F3JDieSA91XYej7TpMMWphOX%2BnHR7ZUVXj8lS6wP4ROig%3D%3D";
	public static String CURRENT_JOCKEY_INFO_URL = "http://apis.data.go.kr/B551015/currentjockeyInfo/getcurrentjockeyinfo";
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	public static void main(String[] args) {
		jockeyApiManager.callCurrentJockeyInfoByXML();
	}

	public static List<Jockey> callCurrentJockeyInfoByXML() {

		List<Jockey> list = new ArrayList<>();

		StringBuffer urlBuffer = new StringBuffer();
		urlBuffer.append(CURRENT_JOCKEY_INFO_URL);
		urlBuffer.append("?" + "serviceKey=" + key); // 첫 번째만 물음표로 설정
		urlBuffer.append("&" + "pageNo=" + "1");
		urlBuffer.append("&" + "numOfRows=" + "100");
		urlBuffer.append("&" + "meet=" + "1");

		System.out.println(urlBuffer);

		try {
			URL url = new URL(urlBuffer.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/xml");
			int code = conn.getResponseCode(); // 실제 호출하는 부
			System.out.println("ResponseCode : " + code);

			if (code < 200 || code > 300) {
				System.out.println("페이지가 잘못되었습니다.");
				return null;
			}

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(conn.getInputStream()); //
			doc.normalizeDocument();

			NodeList nList = doc.getElementsByTagName("item");
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				System.out.println("\nCurrent Element : " + node.getNodeName());
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					try {
						Element eElement = (Element) node;

						String jkNo = getStrData(eElement, "jkNo");
						String jkName = getStrData(eElement, "jkName");
						String meet = getStrData(eElement, "meet");
						int age = getIntData(eElement, "age");
						Date debut = getDateData(eElement, "debut");
						int rcCntT = getIntData(eElement, "rcCntT");
						int ord1CntT = getIntData(eElement, "ord1CntT");
						int ord2CntT = getIntData(eElement, "ord2CntT");
						int ord3CntT = getIntData(eElement, "ord3CntT");

						Jockey jockey = new Jockey(jkNo, jkName, meet, age, debut, rcCntT, ord1CntT, ord2CntT,
								ord3CntT);
						list.add(jockey);
					} catch (Exception e) {
						System.out.println("데이터가 잘못되었습니다!");
					}
				}
			}
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
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

	private static Date getDateData(Element eElement, String tagName) {
		try {
			Date date = sdf.parse(eElement.getElementsByTagName(tagName).item(0).getTextContent());
			return new java.sql.Date(date.getTime());
		} catch (Exception e) {
			return null;
		}
	}
}
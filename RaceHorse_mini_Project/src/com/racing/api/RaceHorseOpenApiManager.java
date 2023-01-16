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

import com.racing.model.vo.RaceHorse;

public class RaceHorseOpenApiManager {
	public static String key = "lzhpNoakCHo5aenwJe7kub6egAg%2FlsfQ9QbSTSGrD%2F3JDieSA91XYej7TpMMWphOX%2BnHR7ZUVXj8lS6wP4ROig%3D%3D";
	public static String horse_Info_XML_URL = "http://apis.data.go.kr/B551015/API8/raceHorseInfo";
	

	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	public static void main(String[] args) {
		RaceHorseOpenApiManager.callRaceHorseOpenListByXML();
	}

	public static List<RaceHorse> callRaceHorseOpenListByXML() {
		List<RaceHorse> list = new ArrayList<>();

		try {
			StringBuffer urlBuffer = new StringBuffer();
			urlBuffer.append(horse_Info_XML_URL);
			urlBuffer.append("?" + "ServiceKey=" + key); // 첫 번째만 물음표로 설정
			urlBuffer.append("&" + "pageNo=" + 1);
			urlBuffer.append("&" + "numOfRows=" + "25161");

			System.out.println(urlBuffer);

			URL url = new URL(urlBuffer.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Content-type", "application/json");
			conn.setRequestProperty("Accept", "application/xml");

			int code = conn.getResponseCode(); // 실제 호출하는 부
			System.out.println("ResponseCode : " + code);

			if (code < 200 || code >= 300) {
				System.out.println("페이지가 잘못되었습니다.");
				return null;
			}

			// 3. 페이지 Parsing(해석)
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			Document doc = db.parse(conn.getInputStream()); // xml 부를 파싱하여 객체화

			doc.getDocumentElement().normalize();

			System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
			System.out.println("======================================================");

			NodeList nList = doc.getElementsByTagName("item");
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) node;

					String hrNo = eElement.getElementsByTagName("hrNo").item(0).getTextContent();
					String meet = eElement.getElementsByTagName("meet").item(0).getTextContent();
					String hrName = eElement.getElementsByTagName("hrName").item(0).getTextContent();
					String name = eElement.getElementsByTagName("name").item(0).getTextContent();
					String sex = eElement.getElementsByTagName("sex").item(0).getTextContent();
					String birthday = eElement.getElementsByTagName("birthday").item(0).getTextContent();
					String rank = eElement.getElementsByTagName("rank").item(0).getTextContent();
					String faHrName = eElement.getElementsByTagName("faHrName").item(0).getTextContent();
					String moHrName = eElement.getElementsByTagName("moHrName").item(0).getTextContent();
					long rcCntT = Long.parseLong(eElement.getElementsByTagName("rcCntT").item(0).getTextContent());
					int ord1CntT = Integer.parseInt(eElement.getElementsByTagName("ord1CntT").item(0).getTextContent());
					int ord2CntT = Integer.parseInt(eElement.getElementsByTagName("ord2CntT").item(0).getTextContent());
					int ord3CntT = Integer.parseInt(eElement.getElementsByTagName("ord3CntT").item(0).getTextContent());
					long chaksunT = Long.parseLong(eElement.getElementsByTagName("chaksunT").item(0).getTextContent());
					String hrLastAmt = eElement.getElementsByTagName("hrLastAmt").item(0).getTextContent();
					RaceHorse horse = new RaceHorse(hrNo, meet, hrName, name, sex, birthday, rank, faHrName, moHrName, rcCntT, ord1CntT, ord2CntT, ord3CntT, chaksunT, hrLastAmt);
					list.add(horse);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

}

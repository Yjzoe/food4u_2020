package com.remake.food4u.domain.searchfood;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class Search {

    public static ArrayList<SearchFood> addList(String foodname,String pageNum) throws IOException, ParserConfigurationException {
        ArrayList<SearchFood> list = new ArrayList<SearchFood>();
        String uri = getUri(foodname, pageNum);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        String totalCount = "";
        try {
            Document doc = builder.parse(uri);
            NodeList nodeList = doc.getElementsByTagName("body");
            for (int i = 0; i < nodeList.getLength(); i++) {
                for (Node node = nodeList.item(i).getFirstChild(); node != null; node = node.getNextSibling()) {
                    if (node.getNodeName().equals("totalCount")) {
                        totalCount = node.getTextContent();
                    }
                }
            }
        } catch (SAXException e) {
            e.printStackTrace();
        }
        try {
            Document doc = builder.parse(uri);
            NodeList nodeList = doc.getElementsByTagName("item");
            for (int i = 0; i < nodeList.getLength(); i++) {
                String s1 = "";
                String s2 = "";
                String s3 = "";
                String s4 = "";
                String s5 = "";
                String s6 = "";
                String s7 = "";
                String s8 = "";
                String s9 = "";
                String s10 = "";
                String s11 = "";

                for (Node node = nodeList.item(i).getFirstChild(); node != null; node = node.getNextSibling()) {
                    if (node.getNodeName().equals("DESC_KOR")) {
                        s1 = node.getTextContent();
                    }
                    if (node.getNodeName().equals("SERVING_WT")) {
                        s2 = node.getTextContent();
                        if (s2.equals("N/A") || s2.equals("TRACE")) {
                            s2 = "0";
                        }
                    }
                    if (node.getNodeName().equals("NUTR_CONT1")) {
                        s3 = node.getTextContent();
                        if (s3.equals("N/A") || s3.equals("TRACE")) {
                            s3 = "0";
                        }
                    }
                    if (node.getNodeName().equals("NUTR_CONT2")) {
                        s4 = node.getTextContent();
                        if (s4.equals("N/A") || s4.equals("TRACE")) {
                            s4 = "0";
                        }
                    }
                    if (node.getNodeName().equals("NUTR_CONT3")) {
                        s5 = node.getTextContent();
                        if (s5.equals("N/A") || s5.equals("TRACE")) {
                            s5 = "0";
                        }
                    }
                    if (node.getNodeName().equals("NUTR_CONT4")) {
                        s6 = node.getTextContent();
                        if (s6.equals("N/A") || s6.equals("TRACE")) {
                            s6 = "0";
                        }
                    }
                    if (node.getNodeName().equals("NUTR_CONT5")) {
                        s7 = node.getTextContent();
                        if (s7.equals("N/A") || s7.equals("TRACE")) {
                            s7 = "0";
                        }
                    }
                    if (node.getNodeName().equals("NUTR_CONT6")) {
                        s8 = node.getTextContent();
                        if (s8.equals("N/A") || s8.equals("TRACE")) {
                            s8 = "0";
                        }
                    }
                    if (node.getNodeName().equals("NUTR_CONT7")) {
                        s9 = node.getTextContent();
                        if (s9.equals("N/A") || s9.equals("TRACE")) {
                            s9 = "0";
                        }
                    }
                    if (node.getNodeName().equals("NUTR_CONT8")) {
                        s10 = node.getTextContent();
                        if (s10.equals("N/A") || s10.equals("TRACE")) {
                            s10 = "0";
                        }
                    }
                    if (node.getNodeName().equals("NUTR_CONT9")) {
                        s11 = node.getTextContent();
                        if (s11.equals("N/A") || s11.equals("TRACE")) {
                            s11 = "0";
                        }
                    }
                }
                list.add(new SearchFood(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,totalCount));
            }

        } catch (SAXException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static String parser(String foodname,String pageNum) throws IOException, ParserConfigurationException
    {
        ArrayList<SearchFood> list = new ArrayList<SearchFood>();
        String uri = getUri(foodname, pageNum);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        String str = "[";
        try {
            Document doc = builder.parse(uri);
            NodeList nodeList = doc.getElementsByTagName("item");

            for (int i = 0; i < nodeList.getLength(); i++) {
                for (Node node = nodeList.item(i).getFirstChild(); node != null; node = node.getNextSibling()) {
                    if(node.getNodeName().equals("DESC_KOR")) {
                        str += "{\"foodname\":\""+node.getTextContent()+"\",";
                    }
                    if(node.getNodeName().equals("SERVING_WT"))
                    {
                        str += "\"serving\":"+node.getTextContent()+",";
                    }
                    if(node.getNodeName().equals("NUTR_CONT1"))
                    {
                        str += "\"kcal\":"+node.getTextContent()+",";
                    }
                    if(node.getNodeName().equals("NUTR_CONT2"))
                    {
                        str += "\"carbohydrate\":"+node.getTextContent()+",";
                    }
                    if(node.getNodeName().equals("NUTR_CONT3"))
                    {
                        str += "\"protein\":"+node.getTextContent()+",";
                    }
                    if(node.getNodeName().equals("NUTR_CONT4"))
                    {
                        str += "\"fat\":"+node.getTextContent()+",";
                    }
                    if(node.getNodeName().equals("NUTR_CONT5"))
                    {
                        str += "\"sugar\":"+node.getTextContent()+",";
                    }
                    if(node.getNodeName().equals("NUTR_CONT6"))
                    {
                        str += "\"natrium\":"+node.getTextContent()+",";
                    }
                    if(node.getNodeName().equals("NUTR_CONT7"))
                    {
                        str += "\"cholesterol\":"+node.getTextContent()+",";
                    }
                    if(node.getNodeName().equals("NUTR_CONT8"))
                    {
                        str += "\"fatty_acid\":"+node.getTextContent()+",";
                    }
                    if(node.getNodeName().equals("NUTR_CONT9"))
                    {
                        str += "\"transfatty_acid\":"+node.getTextContent()+"},";
                    }
                }
            }
        } catch (SAXException e) {
            e.printStackTrace();
        }

        str = str.substring(0, str.length() - 1)+"]";
        return str;
    }

    public static String getUri(String foodname,String pageNum) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1470000/FoodNtrIrdntInfoService/getFoodNtrItdntList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=rhjOjaXZcs1uC4y3flYMxiv%2F1%2BrQVACh%2Brg3XhBdZMp2TgYd7i7Vk1OP3Envcs1kuNtcj3O3l%2FwndSWdEqRorQ%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("desc_kor","UTF-8") + "=" + URLEncoder.encode(foodname, "UTF-8")); /*식품이름*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(pageNum, "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("5", "UTF-8")); /*한 페이지 결과 수*/
        URL url = new URL(urlBuilder.toString());
        String uri = url.toString();
        return uri;
    }

    public static String search(String foodname,String pageNum) throws IOException
    {
        URL url = new URL(getUri(foodname , pageNum));

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        return sb.toString();
    }

    public static void main(String []args)
    {
        try {
            Search.search("계란", "2");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

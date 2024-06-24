package com.fm.lifevoy.generatefeed.clients;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class UserClient {
    public static List<String> getFollowings(String username) throws IOException {
        String wsURL = "http://localhost:8301/ws/";
        URL url;
        URLConnection connection;
        HttpURLConnection httpConn;
        String responseString;
        String outputString="";
        OutputStream out;
        InputStreamReader isr;
        BufferedReader in;

        String xmlInput =
            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:gen=\"http://www.fm.com/lifevoy/user/generated\">"+
                "<soapenv:Header/>"+
                "<soapenv:Body>"+
                "<gen:GetFollowingsRequest>"+
                    "<gen:username>"+username+"</gen:username>"+
                "</gen:GetFollowingsRequest>"+
            "</soapenv:Body>"+
        "</soapenv:Envelope>";


        url = new URL(wsURL);
        connection = url.openConnection();
        httpConn = (HttpURLConnection) connection;

        byte[] buffer;
        buffer = xmlInput.getBytes();

        String SOAPAction = "";
        // Set the appropriate HTTP parameters.
        httpConn.setRequestProperty("Content-Length", String
                .valueOf(buffer.length));
        httpConn.setRequestProperty("Content-Type",
                "text/xml; charset=utf-8");


        httpConn.setRequestProperty("SOAPAction", SOAPAction);
        httpConn.setRequestMethod("POST");
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);
        out = httpConn.getOutputStream();
        out.write(buffer);
        out.close();

        // Read the response and write it to standard out.
        isr = new InputStreamReader(httpConn.getInputStream());
        in = new BufferedReader(isr);

        while ((responseString = in.readLine()) != null)
        {
            outputString = outputString + responseString;
        }
        System.out.println(outputString);

        // Get the response from the web service call
        Document document = parseXmlFile(outputString);

        NodeList nodeLst = document.getElementsByTagName("ns2:userName");
        List<String> followings = new ArrayList<String>();
        for(int i=0;i<nodeLst.getLength();i++){
            followings.add(nodeLst.item(i).getTextContent());
        }
        return followings;

    }

    private static Document parseXmlFile(String in) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(in));
            return db.parse(is);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.fm.lifevoy.generatefeed.clients;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class XMLUtils {

    public static Document getParsedOutput(String xmlInput, String link) throws IOException {
        URL url = new URL(link);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

        byte[] buffer = xmlInput.getBytes();
        httpConn.setRequestProperty("Content-Length", String.valueOf(buffer.length));
        httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        httpConn.setRequestProperty("SOAPAction", "");
        httpConn.setRequestMethod("POST");
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);

        OutputStream out = httpConn.getOutputStream();
        out.write(buffer);
        out.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));

        String responseString;
        String outputString="";
        while ((responseString = in.readLine()) != null)
            outputString += responseString;

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(outputString));
            return db.parse(is);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}

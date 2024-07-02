package com.fm.lifevoy.v2.comment;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostEligibilityClient {
    public static boolean canPost(String text,String username) throws IOException, ParserConfigurationException, SAXException {
        /***************************** REQUEST ***************************************
         * <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:str="http://fm.com/lifevoy/v2/strikecheck">
         *    <soapenv:Header/>
         *    <soapenv:Body>
         *       <str:PostEligibilityCheckRequest>
         *          <str:username>username1</str:username>
         *          <str:text>xyz</str:text>
         *       </str:PostEligibilityCheckRequest>
         *    </soapenv:Body>
         * </soapenv:Envelope>
         * */

        String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:str=\"http://fm.com/lifevoy/v2/strikecheck\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <str:PostEligibilityCheckRequest>\n" +
                "         <str:username>"+username+"</str:username>\n" +
                "         <str:text>"+text+"</str:text>\n" +
                "      </str:PostEligibilityCheckRequest>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        
        Document document = getParsedOutput(xmlInput,"http://localhost:8087/ws");

        /***************************** RESPONSE ***************************************
         * <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
         *    <SOAP-ENV:Header/>
         *    <SOAP-ENV:Body>
         *       <ns2:PostEligibilityCheckResponse xmlns:ns2="http://fm.com/lifevoy/v2/strikecheck">
         *          <ns2:eligible>false</ns2:eligible>
         *       </ns2:PostEligibilityCheckResponse>
         *    </SOAP-ENV:Body>
         * </SOAP-ENV:Envelope>
         * */


        return document.getElementsByTagName("ns2:eligible").item(0).getTextContent().equals("true");
    }

    public static Document getParsedOutput(String xmlInput, String link) throws IOException, ParserConfigurationException, SAXException {
        URL url = new URL(link);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

        byte[] buffer = xmlInput.getBytes();
        httpConn.setRequestProperty("Content-Length", String.valueOf(buffer.length));
        httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        httpConn.setRequestProperty("SOAPAction", "");
        httpConn.setRequestMethod("POST");
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);

        OutputStream request = httpConn.getOutputStream();
        request.write(buffer);
        request.close();

        BufferedReader response = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));

        String line;
        String outputString="";
        while ((line = response.readLine()) != null)
            outputString += line;

        InputSource inputSource = new InputSource(new StringReader(outputString));
        return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
    }
}

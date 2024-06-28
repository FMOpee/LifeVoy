package com.fm.lifevoy.v2.strikechecker.clients;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.fm.lifevoy.v2.strikechecker.clients.XMLUtils.getParsedOutput;

public class UserClient {
    public static List<String> getAllUsers() throws IOException, ParserConfigurationException, SAXException {
        String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:user=\"http://fm.com/lifevoy/v2/user\">\n" +
                        "   <soapenv:Header/>\n" +
                        "   <soapenv:Body>\n" +
                        "      <user:GetAllUserNamesRequest>\n" +
                        "         <user:token>123456789</user:token>\n" +
                        "      </user:GetAllUserNamesRequest>\n" +
                        "   </soapenv:Body>\n" +
                        "</soapenv:Envelope>";

        Document document = getParsedOutput(xmlInput,"http://localhost:8081/ws");

        NodeList nodeLst = document.getElementsByTagName("ns2:usernames");
        List<String> usernames = new ArrayList<>();
        for(int i=0;i<nodeLst.getLength();i++)
            usernames.add(nodeLst.item(i).getTextContent());

        return usernames;
    }


}

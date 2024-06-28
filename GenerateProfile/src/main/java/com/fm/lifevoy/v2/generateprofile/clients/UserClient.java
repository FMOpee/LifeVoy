package com.fm.lifevoy.v2.generateprofile.clients;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static com.fm.lifevoy.v2.generateprofile.clients.XMLUtils.getParsedOutput;

public class UserClient {
    public static PairOfLong getFollowingAndFollowerCount(String username) throws IOException, ParserConfigurationException, SAXException {
        String xmlInput =
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:user=\"http://fm.com/lifevoy/v2/user\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <user:GetUserRequest>\n" +
                "         <!--1 or more repetitions:-->\n" +
                "         <user:usernames>"+username+"</user:usernames>\n" +
                "      </user:GetUserRequest>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        Document document = getParsedOutput(xmlInput,"http://localhost:8081/ws");

        NodeList followings = document.getElementsByTagName("ns2:followings");
        NodeList followers = document.getElementsByTagName("ns2:followers");

        return new PairOfLong(followers.getLength(), followings.getLength());
    }
}

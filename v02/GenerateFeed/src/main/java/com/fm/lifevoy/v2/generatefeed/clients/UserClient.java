package com.fm.lifevoy.v2.generatefeed.clients;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.fm.lifevoy.v2.generatefeed.clients.XMLUtils.getParsedOutput;

public class UserClient {
    public static List<String> getFollowings(String username) throws IOException, ParserConfigurationException, SAXException {
        String xmlInput =
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:user=\"http://fm.com/lifevoy/v2/user\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <user:GetFollowingsRequest>\n" +
                "         <user:username>"+username+"</user:username>\n" +
                "      </user:GetFollowingsRequest>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        Document document = getParsedOutput(xmlInput,"http://localhost:8081/ws");

        NodeList nodeLst = document.getElementsByTagName("ns2:followingUsernames");
        List<String> followings = new ArrayList<>();
        for(int i=0;i<nodeLst.getLength();i++)
            followings.add(nodeLst.item(i).getTextContent());

        return followings;
    }


}

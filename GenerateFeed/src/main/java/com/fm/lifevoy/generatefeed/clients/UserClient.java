package com.fm.lifevoy.generatefeed.clients;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.fm.lifevoy.generatefeed.clients.XMLUtils.*;

public class UserClient {
    public static List<String> getFollowings(String username) throws IOException {
        String xmlInput =
        "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:gen=\"http://www.fm.com/lifevoy/user/generated\">"+
            "<soapenv:Header/>"+
            "<soapenv:Body>"+
                "<gen:GetFollowingsRequest>"+
                    "<gen:username>"+username+"</gen:username>"+
                "</gen:GetFollowingsRequest>"+
            "</soapenv:Body>"+
        "</soapenv:Envelope>";

        Document document = getParsedOutput(xmlInput,"http://localhost:8301/ws/");

        NodeList nodeLst = document.getElementsByTagName("ns2:userName");
        List<String> followings = new ArrayList<String>();
        for(int i=0;i<nodeLst.getLength();i++)
            followings.add(nodeLst.item(i).getTextContent());

        return followings;
    }


}

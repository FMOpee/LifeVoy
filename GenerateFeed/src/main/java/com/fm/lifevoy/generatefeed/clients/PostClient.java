package com.fm.lifevoy.generatefeed.clients;

import com.fm.lifevoy.generatefeed.generated.feed.Post;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.fm.lifevoy.generatefeed.clients.XMLUtils.*;

public class PostClient {
    public static List<Post> getFeed(List<String> usernames) throws IOException {
        String xmlInput=
                    "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:gen=\"http://www.fm.com/lifevoy/post/generated\">\n" +
                    "   <soapenv:Header/>\n" +
                    "   <soapenv:Body>\n" +
                    "      <gen:GetFeedRequest>\n";
        for (String username : usernames) {  xmlInput +=
                    "          <gen:followingUsernames>"+username+"</gen:followingUsernames>\n";}
        xmlInput+=  "      </gen:GetFeedRequest>\n" +
                    "   </soapenv:Body>\n" +
                    "</soapenv:Envelope>";

        Document document = getParsedOutput(xmlInput,"http://localhost:8201/ws/");

        NodeList nodeLst = document.getElementsByTagName("ns2:posts");
        List<Post> posts = new ArrayList<>();

        for(int i=0;i<nodeLst.getLength();i++){
            NodeList children = nodeLst.item(i).getChildNodes();

            Post post = new Post();
            for(int j=0;j<children.getLength();j++){
                String textContent = children.item(j).getTextContent();
                String nodeName = children.item(j).getNodeName();
                switch (nodeName) {
                    case "ns2:postID" -> post.setPostID(Long.parseLong(textContent));
                    case "ns2:text" -> post.setText(textContent);
                    case "ns2:posterUsername" -> post.setPosterUsername(textContent);
                    case "ns2:likers" -> post.getLikers().add(textContent);
                }
            }
            posts.add(post);
        }
        return posts;
    }


}

package com.fm.lifevoy.v2.generateprofile.clients;

import com.fm.lifevoy.v2.generateprofile.generated.Post;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.fm.lifevoy.v2.generateprofile.clients.XMLUtils.*;

public class PostClient {
    public static List<Post> getFeed(List<String> usernames) throws IOException, ParserConfigurationException, SAXException {
        String xmlInput=
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:post=\"http://fm.com/lifevoy/v2/post\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <post:GetPostsUsingPosterRequest>\n" +
                "         <!--1 or more repetitions:-->\n";
        for (String username : usernames)
            xmlInput +=
                "         <post:posterUsernames>"+username+"</post:posterUsernames>\n";
        xmlInput+=
                "      </post:GetPostsUsingPosterRequest>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        Document document = getParsedOutput(xmlInput,"http://localhost:8082/ws");

        NodeList nodeLst = document.getElementsByTagName("ns2:post");
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
                    case "ns2:likerUsernames" -> post.getLikers().add(textContent);
                }
            }
            posts.add(post);
        }
        return posts;
    }


}

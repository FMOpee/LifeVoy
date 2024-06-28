package com.fm.lifevoy.v2.onepost.clients;

import com.fm.lifevoy.v2.onepost.generated.Comment;
import com.fm.lifevoy.v2.onepost.generated.Post;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

import static com.fm.lifevoy.v2.onepost.clients.XMLUtils.getParsedOutput;

public class PostClient {
    public static Post getpost(long postID, List<Comment> comments) throws IOException, ParserConfigurationException, SAXException {
        String xmlInput="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:post=\"http://fm.com/lifevoy/v2/post\">\n" +
                        "   <soapenv:Header/>\n" +
                        "   <soapenv:Body>\n" +
                        "      <post:GetPostUsingIDRequest>\n" +
                        "         <post:postID>"+postID+"</post:postID>\n" +
                        "      </post:GetPostUsingIDRequest>\n" +
                        "   </soapenv:Body>\n" +
                        "</soapenv:Envelope>";

        Document document = getParsedOutput(xmlInput,"http://localhost:8082/ws");

        Post post = new Post();
        post.setPostID(Long.parseLong(document.getElementsByTagName("ns2:postID").item(0).getTextContent()));
        post.setPosterUsername(document.getElementsByTagName("ns2:posterUsername").item(0).getTextContent());
        post.setText(document.getElementsByTagName("ns2:text").item(0).getTextContent());
        NodeList nodeLst = document.getElementsByTagName("ns2:likerUsernames");
        for(int i=0;i< nodeLst.getLength();i++){
            post.getLikers().add(nodeLst.item(i).getTextContent());
        }
        for (Comment comment : comments) {
            post.getComments().add(comment);
        }
        return post;
    }
}

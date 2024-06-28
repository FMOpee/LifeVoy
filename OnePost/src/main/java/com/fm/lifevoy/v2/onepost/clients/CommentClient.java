package com.fm.lifevoy.v2.onepost.clients;

import com.fm.lifevoy.v2.onepost.generated.Comment;
import com.fm.lifevoy.v2.onepost.generated.Post;
import com.fm.lifevoy.v2.onepost.generated.Reply;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.fm.lifevoy.v2.onepost.clients.XMLUtils.getParsedOutput;

public class CommentClient {
    public static List<Comment> getComments(long postID) throws IOException, ParserConfigurationException, SAXException {
        String xmlInput=
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:com=\"http://fm.com/lifevoy/v2/comment\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <com:GetCommentsRequest>\n" +
                "         <com:postID>"+postID+"</com:postID>\n" +
                "      </com:GetCommentsRequest>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        Document document = getParsedOutput(xmlInput,"http://localhost:8083/ws");

        NodeList nodeLst = document.getElementsByTagName("ns2:comments");
        List<Comment> comments = new ArrayList<Comment>();
        for(int i=0;i<nodeLst.getLength();i++){
            NodeList children = nodeLst.item(i).getChildNodes();
            Comment comment = new Comment();
            for(int j=0;j<children.getLength();j++){
                Node child = children.item(j);
                switch (child.getNodeName()){
                    case "ns2:commenter" -> comment.setUsername(child.getTextContent());
                    case "ns2:text" -> comment.setText(child.getTextContent());
                    case "ns2:replies"-> comment.getReplies().add(getReply(child));
                }
            }
            comments.add(comment);
        }
        return comments;
    }

    private static Reply getReply(Node node) {
        NodeList children = node.getChildNodes();
        Reply reply = new Reply();
        for (int k=0;k< children.getLength();k++){
            switch (children.item(k).getNodeName()){
                case "ns2:username" ->reply.setUsername(children.item(k).getTextContent());
                case "ns2:text" ->reply.setText(children.item(k).getTextContent());
            }
        }
        return reply;
    }
}

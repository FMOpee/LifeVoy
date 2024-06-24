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
        for (String username : usernames) {
            xmlInput += "           <gen:followingUsernames>"+username+"</gen:followingUsernames>\n";}
        xmlInput+=      "      </gen:GetFeedRequest>\n" +
                        "   </soapenv:Body>\n" +
                        "</soapenv:Envelope>";

        Document document = getParsedOutput(xmlInput,"http://localhost:8201/ws/");

        NodeList nodeLst = document.getElementsByTagName("ns2:posts");
        List<Post> posts = new ArrayList<>();

        for(int i=0;i<nodeLst.getLength();i++){
            NodeList children = nodeLst.item(i).getChildNodes();
            long postID = 0L;
            for(int j=0;j<children.getLength();j++)
                if(children.item(j).getNodeName().equals("ns2:postID")){
                    postID= Long.parseLong(children.item(j).getTextContent());
                    break;}
            String text="";
            for(int j=0;j<children.getLength();j++)
                if(children.item(j).getNodeName().equals("ns2:text")){
                    text=children.item(j).getTextContent();
                    break;}
            String posterUsername="";
            for(int j=0;j<children.getLength();j++)
                if(children.item(j).getNodeName().equals("ns2:posterUsername")){
                    posterUsername=children.item(j).getTextContent();
                    break;}
            List<String> likers=new ArrayList<>();
            for(int j=0;j<children.getLength();j++)
                if(children.item(j).getNodeName().equals("ns2:likers"))
                    likers.add(children.item(j).getTextContent());

            Post post = new Post();
            post.setPostID(postID);
            post.setText(text);
            post.setPosterUsername(posterUsername);
            post.getLikers().addAll(likers);
            posts.add(post);
        }
        return posts;
    }


}

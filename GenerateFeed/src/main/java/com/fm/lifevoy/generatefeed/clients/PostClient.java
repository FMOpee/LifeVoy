package com.fm.lifevoy.generatefeed.clients;

import com.fm.lifevoy.generatefeed.generated.feed.Post;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class PostClient {
    public static List<Post> getFeed(List<String> usernames) throws IOException {
        String wsURL = "http://localhost:8201/ws/";
        URL url;
        URLConnection connection;
        HttpURLConnection httpConn;
        String responseString;
        String outputString="";
        OutputStream out;
        InputStreamReader isr;
        BufferedReader in;

        String xmlInput =
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:gen=\"http://www.fm.com/lifevoy/post/generated\">\n" +
                        "   <soapenv:Header/>\n" +
                        "   <soapenv:Body>\n" +
                        "      <gen:GetFeedRequest>\n";

        for (String username : usernames) {
            xmlInput += "           <gen:followingUsernames>"+username+"</gen:followingUsernames>\n";
        }

        xmlInput+=      "      </gen:GetFeedRequest>\n" +
                        "   </soapenv:Body>\n" +
                        "</soapenv:Envelope>";


        url = new URL(wsURL);
        connection = url.openConnection();
        httpConn = (HttpURLConnection) connection;

        byte[] buffer;
        buffer = xmlInput.getBytes();

        String SOAPAction = "";
        // Set the appropriate HTTP parameters.
        httpConn.setRequestProperty("Content-Length", String
                .valueOf(buffer.length));
        httpConn.setRequestProperty("Content-Type",
                "text/xml; charset=utf-8");


        httpConn.setRequestProperty("SOAPAction", SOAPAction);
        httpConn.setRequestMethod("POST");
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);
        out = httpConn.getOutputStream();
        out.write(buffer);
        out.close();

        // Read the response and write it to standard out.
        isr = new InputStreamReader(httpConn.getInputStream());
        in = new BufferedReader(isr);

        while ((responseString = in.readLine()) != null)
        {
            outputString = outputString + responseString;
        }
        System.out.println(outputString);

        // Get the response from the web service call
        Document document = parseXmlFile(outputString);

        NodeList nodeLst = document.getElementsByTagName("ns2:posts");
        List<Post> posts = new ArrayList<Post>();
        for(int i=0;i<nodeLst.getLength();i++){
            Post post = new Post();
//            System.out.println(nodeLst.item(i));
            NodeList children = nodeLst.item(i).getChildNodes();
            Long postID = 0L;
            for(int j=0;j<children.getLength();j++){
                if(children.item(j).getNodeName().equals("ns2:postID")){
                    postID= Long.parseLong(children.item(j).getTextContent());
                    break;
                }
            }
            String text="";
            for(int j=0;j<children.getLength();j++){
                if(children.item(j).getNodeName().equals("ns2:text")){
                    text=children.item(j).getTextContent();
                    break;
                }
            }
            String posterUsername="";
            for(int j=0;j<children.getLength();j++){
                if(children.item(j).getNodeName().equals("ns2:posterUsername")){
                    posterUsername=children.item(j).getTextContent();
                    break;
                }
            }
            List<String> likers=new ArrayList<>();
            for(int j=0;j<children.getLength();j++){
                if(children.item(j).getNodeName().equals("ns2:likers")){
                    likers.add(children.item(j).getTextContent());
                }
            }

            post.setPostID(postID);
            post.setText(text);
            post.setPosterUsername(posterUsername);
            post.getLikers().addAll(likers);
            posts.add(post);
        }
        return posts;

    }

    private static Document parseXmlFile(String in) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(in));
            return db.parse(is);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.fm.lifevoy.v2.strikechecker;

import com.fm.lifevoy.v2.strikechecker.clients.UserClient;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Component
public class StrikeRepository {
    private static HashMap<String,Long> strikes = new HashMap<>();

    private void updateHashmap() throws IOException, ParserConfigurationException, SAXException {
        List<String> usernames = UserClient.getAllUsers();
        for (String username : usernames) {
            if (!strikes.containsKey(username)) {
                strikes.put(username, 0L);
            }
        }
    }

    public void tickStrike(String username) throws IOException, ParserConfigurationException, SAXException {
        updateHashmap();
        if (!strikes.containsKey(username)) {
            strikes.put(username, 1L);
        }
        else {
            strikes.put(username, strikes.get(username) + 1);
        }
    }

    public long getStrike(String username) {
        if(!strikes.containsKey(username)) {
            strikes.put(username, 0L);
        }
        return strikes.get(username);
    }
}

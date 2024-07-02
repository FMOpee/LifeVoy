package adnan.messaging;

import adnan.messaging.generated.ChatHead;
import adnan.messaging.generated.Chats;
import adnan.messaging.generated.Message;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class MessagingRepository {
    private static final HashMap<Long, Chats> chatlogs = new HashMap<>();
    @PostConstruct
    public void init(){}

    public Chats getChatlogRequest (long chatlogID){
        return chatlogs.get(chatlogID);
    }

    public void createMessage(String sender, String receiver, String text){
        Chats chat = null;
        for(Chats c: chatlogs.values()){
            if(c.getSenders().contains(sender) && c.getSenders().contains(receiver)){
                chat = c;
                break;
            }
        }
        if(chat != null){
            Message m = new Message();
            m.setChatID(chat.getChatID());
            m.setText(text);
            m.setSenderUsername(sender);
            m.setTimestamp(chat.getMessages().size()+1);
            chat.getMessages().add(m);
        }
        else{
            Chats chatnew = new Chats();
            chatnew.setChatID(chatlogs.values().size()+1);
            chatnew.getSenders().add(sender);
            chatnew.getSenders().add(receiver);
            Message m = new Message();
            m.setChatID(chatnew.getChatID());
            m.setText(text);
            m.setSenderUsername(sender);
            m.setTimestamp(1L);
            chatnew.getMessages().add(m);
            chatlogs.put(chatnew.getChatID(),chatnew);
        }

    }

    public List<ChatHead> getListOfChathead(String username){
        List<ChatHead> chatHeads = new ArrayList<>();
        for(Chats c: chatlogs.values()){
            if(c.getSenders().contains(username)){
                ChatHead ch = new ChatHead();
                ch.setChatID(c.getChatID());
                Message lm = new Message();
                lm.setTimestamp(-1);
                for(Message m:c.getMessages()){
                    if(lm.getTimestamp() < m.getTimestamp())
                        lm = m;
                }
                ch.setLastMessage(lm);
                chatHeads.add(ch);
            }
        }
        return chatHeads;
    }

    public List<Message> getListOfMessage(String username1, String username2){
        List<Message> messages = new ArrayList<>();
        Chats target = null;
        for(Chats c: chatlogs.values()){
            if(c.getSenders().contains(username1) && c.getSenders().contains(username2)){
                target = c;
                break;
            }
        }
        if(target != null){
            messages.addAll(target.getMessages());
        }
        return messages;
    }
}

package adnan.messaging;

import adnan.messaging.generated.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class MessagingEndpoint {
    private static final String NAMESPACE_URI = "http://service.messaing";
    private final MessagingRepository messagingRepository;
    @Autowired
    public MessagingEndpoint(MessagingRepository messagingRepository) {
        this.messagingRepository = messagingRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetChatLogRequest")
    @ResponsePayload
    public GetChatLogResponse getChatLog(@RequestPayload GetChatLogRequest request) {
        GetChatLogResponse response = new GetChatLogResponse();
        response.setChatlog(messagingRepository.getChatlogRequest(request.getChatID()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetListOfChatsRequest")
    @ResponsePayload
    public GetListOfChatsResponse getListOfChats(@RequestPayload GetListOfChatsRequest request) {
        GetListOfChatsResponse response = new GetListOfChatsResponse();
        response.getChatheads().addAll(messagingRepository.getListOfChathead(request.getUsername()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SendMessageRequest")
    @ResponsePayload
    public SendMessageResponse sendMessage(@RequestPayload SendMessageRequest request) {
        messagingRepository.createMessage(request.getSender(),request.getReceiver(),request.getText());
        SendMessageResponse response = new SendMessageResponse();
        response.setSuccess(true);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetMessagesRequest")
    @ResponsePayload
    public GetMessagesResponse getMessages(@RequestPayload GetMessagesRequest request) {
        GetMessagesResponse response = new GetMessagesResponse();
        response.getMessages().addAll(messagingRepository.getListOfMessage(request.getParticipant1(),request.getParticipant2()));
        return response;
    }
}

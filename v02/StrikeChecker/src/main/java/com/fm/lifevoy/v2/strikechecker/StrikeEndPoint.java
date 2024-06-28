package com.fm.lifevoy.v2.strikechecker;

import com.fm.lifevoy.v2.strikechecker.generated.PostEligibilityCheckRequest;
import com.fm.lifevoy.v2.strikechecker.generated.PostEligibilityCheckResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Endpoint
public class StrikeEndPoint {
    private static final String NAMESPACE_URI = "http://fm.com/lifevoy/v2/strikecheck";
    private static final long strikeLimit = 3L;
    private final StrikeRepository repository;

    @Autowired
    public StrikeEndPoint(StrikeRepository strikeRepository){
        this.repository = strikeRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "PostEligibilityCheckRequest")
    @ResponsePayload
    public PostEligibilityCheckResponse canPost(@RequestPayload PostEligibilityCheckRequest request) throws IOException, ParserConfigurationException, SAXException {
        PostEligibilityCheckResponse response = new PostEligibilityCheckResponse();
        if(request.getText().contains("x")){
            repository.tickStrike(request.getUsername());
            response.setEligible(false);
            return response;
        }
        response.setEligible(repository.getStrike(request.getUsername()) <= strikeLimit);
        return response;
    }
}

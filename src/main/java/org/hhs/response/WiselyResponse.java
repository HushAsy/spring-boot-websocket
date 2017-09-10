package org.hhs.response;

/**
 * Created by hewater on 2017/9/10.
 */
public class WiselyResponse {
    private String responseMessage;

    public WiselyResponse(String responseMessage){
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage(){
        return responseMessage;
    }
}

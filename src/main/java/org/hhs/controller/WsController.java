package org.hhs.controller;

import org.hhs.message.WiselyMessage;
import org.hhs.response.WiselyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.security.Principal;

/**
 * Created by hewater on 2017/9/10.
 */
@Controller
public class WsController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new WiselyResponse("welcome"+ message.getName()+"!");
    }

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg){
        if (principal.getName().equals("wyf")){
            messagingTemplate.convertAndSendToUser("wisely",
                    "/queue/notifications",
                    principal.getName()+"-send:"+msg);
        }else {
            messagingTemplate.convertAndSendToUser("wyf",
                    "/queue/notifications",
                    principal.getName()+"-send:"+msg);
        }
    }

}

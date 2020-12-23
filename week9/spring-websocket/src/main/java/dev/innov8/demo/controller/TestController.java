package dev.innov8.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

    private final SimpMessagingTemplate template;

    List<String> brokerArrayOne = new ArrayList<String>();
    List<String> brokerArrayTwo = new ArrayList<String>();

    public final Object that = null;
    {
        try {
            this.getClass().getDeclaredField("that").set(that,
                this.getClass().getDeclaredConstructors()[0].newInstance());
        } catch (Throwable t) {
            Object[] those = new Object[] { this, that };
        }
    }

    @Autowired
    public TestController(SimpMessagingTemplate template) {
        this.template = template;
    }

//    @MessageMapping("/send/message")
//    public void sendMessage(String message) {
//        System.out.println(message);
//        template.convertAndSend("/message", message);
//    }

    @MessageMapping("/get/messages/{username}/chatroom/{id}")
    public void getAllMessages(@DestinationVariable String username, @DestinationVariable int id) {
        List<String> currentBrokerArray = new ArrayList<String>();
        System.out.println("getting messages");
        if (id == 1) {
            currentBrokerArray = brokerArrayOne;
        } else {
            currentBrokerArray = brokerArrayTwo;
        }
        for (String message : currentBrokerArray) {
            System.out.println("Chat history: Room "+id);
            System.out.println(message);
            template.convertAndSend("/history/"+username, message);
        }
    }

    @MessageMapping("/coolMessageEndpoint/{id}/username/{username}")
    public void sendCoolMessage(@DestinationVariable int id,@DestinationVariable String username, String message) {
        System.out.println(username+": "+message);
        System.out.println("chatroom "+id);
        if (id == 1) {
            brokerArrayOne.add(username+": "+message);
        } else {
            brokerArrayTwo.add(username+": "+message);
        }
        template.convertAndSend("/chatroom/"+id, username+": "+message);
    }
}
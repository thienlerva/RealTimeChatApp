package com.example.RealTimeChat.controller;

import com.example.RealTimeChat.model.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/socket")
@CrossOrigin("*")
public class ChatController {

    @Autowired
    SimpMessagingTemplate template;

    @PostMapping
    public ResponseEntity<?> userSimpleRest(@RequestBody Message message) {

        System.out.println(message);
//        if (message.containsKey("Message")) {
//            //if the toId is present the Message will be sent privately else broadcast it to all users
//            if (message.containsKey("toId") && message.get("toId") != null && !message.get("toId").equals("")) {
//                template.convertAndSend("/socket-publisher/" + message.get("toId"), message);
//                template.convertAndSend("/socket-publisher/" + message.get("toId"), message);
//            } else {
//                template.convertAndSend("/socket-publisher", message);
//            }
        template.convertAndSend("/socket-publisher", message);
        return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.OK);

        //return new ResponseEntity<>(new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @MessageMapping("/send/message")
    //public Map<String, String> useSocketCommunication(String Message) {
    public Message userSocketCommunication(Message message) {
//        ObjectMapper mapper = new ObjectMapper();
//        Map<String, String> messageConverted = null;
//
//        try {
//            messageConverted = mapper.readValue(Message, Map.class);
//        } catch (IOException e) {
//            messageConverted = null;
//        }
//
//        if (messageConverted != null) {
//            if (messageConverted.containsKey("toId") && messageConverted.get("toId") != null &&
//                !messageConverted.get("toId").equals("")) {
//                template.convertAndSend("/socket-publisher/" + messageConverted.get("toId"), Message);
//                template.convertAndSend("/socket-publisher/" + messageConverted.get("toId"), Message);
//            } else {
//                template.convertAndSend("/socket-publisher", Message);
//            }
//        }
        System.out.println(message);
        if (message != null) {
            if (message.getToId() != null) {
                template.convertAndSend("/socket-publisher/" + message.getToId(), message);
                template.convertAndSend("/socket-publisher/" + message.getFromId(), message);
            } else {
                template.convertAndSend("/socket-publisher", message);
            }
        }
        return message;
    }
}

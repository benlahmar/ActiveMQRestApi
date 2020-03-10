/**
 * 
 */
package com.app.moi.controller;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;

@RestController
@RequestMapping("/publish")
public class PublishController {

    @Autowired
    private JmsMessagingTemplate jms;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    @RequestMapping("/queue")
    public String queue() {

        for (int i = 0; i < 2; i++) {
            jms.convertAndSend(queue, "queue" + i);
        }

        return "queue ..";
    }

    @JmsListener(destination = "${spring.activemq.out-queue-name}")
    public String consumerMsg(String msg) {
    	
        System.out.println(msg);
        return msg;
    } 

    @RequestMapping("/topic")
    public String topic() {

        for (int i = 0; i < 2; i++) {
            jms.convertAndSend(topic, "topic" + i);
        }

        return "topic ...";
    }
    
    
}
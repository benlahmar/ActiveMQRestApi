/**
 * 
 */
package com.app.moi.config;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TopicListener {

    private static final Logger logger = LoggerFactory.getLogger(QueueListener.class);

    @JmsListener(destination = "${spring.activemq.topic-name}", containerFactory = "jmsListenerContainerTopic")
    public void receive(String text){
        logger.info("Topic Listener: consumer-a : " + text);
    }
}
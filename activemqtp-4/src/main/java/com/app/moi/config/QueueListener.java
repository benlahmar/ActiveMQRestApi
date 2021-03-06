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
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class QueueListener {
    private static final Logger logger = LoggerFactory.getLogger(QueueListener.class);


    @JmsListener(destination = "${spring.activemq.queue-name}", containerFactory = "jmsListenerContainerQueue")
    @SendTo("${spring.activemq.out-queue-name}")
    public String receive(String text){
        logger.info("QueueListener: consumer-a " + text);
        return "consumer-a received : " + text;
    }
}

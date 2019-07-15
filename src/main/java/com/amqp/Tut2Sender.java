package com.amqp;

import java.time.LocalDateTime;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Gary Russell
 * @author Scott Deeg
 * @author Arnaud Cogoluègnes
 */
public class Tut2Sender {

  @Autowired
  private RabbitTemplate template;

  AtomicInteger count = new AtomicInteger(0);

  @Scheduled(fixedDelay = 3000, initialDelay = 500)
  public void send() {
    StringBuilder builder = new StringBuilder("Hello ");

    builder.append(count.incrementAndGet());
    builder.append(" ");
    builder.append(LocalDateTime.now());


    String messageStr = builder.toString();

    MessageProperties messageProperties = new MessageProperties();
    messageProperties.setDelay(60000);
    Message message = template.getMessageConverter().toMessage(messageStr, messageProperties);

    template.send("myDelayedExchange","myDelayedKey", message);
    System.out.println(" [x] Sent '" + messageStr + "'");
  }

}
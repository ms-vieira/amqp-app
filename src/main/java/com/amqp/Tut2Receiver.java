package com.amqp;

import static org.springframework.amqp.rabbit.annotation.Exchange.TRUE;

import java.time.LocalDateTime;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

/**
 * @author Gary Russell
 * @author Scott Deeg
 */
@RabbitListener(
    bindings = @QueueBinding(
        value = @Queue("myDelayedQueue"),
        exchange = @Exchange(value = "myDelayedExchange", delayed = TRUE),
        key = "myDelayedKey")
)
public class Tut2Receiver {

  private final int instance;

  public Tut2Receiver(int i) {
    this.instance = i;
  }

  @RabbitHandler
  public void receive(String in) throws InterruptedException {
    System.out.println("instance " + this.instance + " [x] Received '" + in + "' " + LocalDateTime.now());
  }

  private void doWork(String in) throws InterruptedException {
    for (char ch : in.toCharArray()) {
      if (ch == '.') {
        Thread.sleep(10);
      }
    }
  }

}
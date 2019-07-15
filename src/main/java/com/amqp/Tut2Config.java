package com.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Gary Russell
 * @author Scott Deeg
 */
@Configuration
@EnableScheduling
@EnableRabbit
public class Tut2Config {

  @Profile("receiver")
  private static class ReceiverConfig {

    @Bean
    public Tut2Receiver receiver1() {
      return new Tut2Receiver(1);
    }

    @Bean
    public Tut2Receiver receiver2() {
      return new Tut2Receiver(2);
    }

  }

  @Profile("sender")
  @Bean
  public Tut2Sender sender() {
    return new Tut2Sender();
  }

}
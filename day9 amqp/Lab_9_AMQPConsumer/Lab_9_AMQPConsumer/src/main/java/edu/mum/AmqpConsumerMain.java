package edu.mum;

import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AmqpConsumerMain {

//    @Autowired
//    private RabbitAdmin rabbitAdmin;
	
    public static void main(String[] args) {
        new GenericXmlApplicationContext("classpath:META-INF/spring/item-app-context.xml");
    }
}

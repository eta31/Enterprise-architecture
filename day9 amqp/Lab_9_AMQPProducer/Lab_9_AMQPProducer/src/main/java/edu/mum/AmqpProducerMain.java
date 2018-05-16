package edu.mum;

import edu.mum.amqp.ItemService;
import edu.mum.amqp.ItemServiceImpl;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AmqpProducerMain {
	
    public static void main(String[] args) {

        ApplicationContext context = new GenericXmlApplicationContext("classpath:META-INF/spring/item-app-context.xml");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Write something and enter:   ");
        try {
            in.readLine();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        RabbitTemplate itemTemplate = context.getBean("itemTemplate", RabbitTemplate.class);
        ItemService itemService = new ItemServiceImpl();
        itemService.publish(itemTemplate);

        System.out.println("Done ...");
 
    }
}

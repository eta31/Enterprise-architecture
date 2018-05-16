package edu.mum.amqp;

import edu.mum.domain.Item;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class ItemServiceImpl implements ItemService {
    public void publish(RabbitTemplate rabbitTemplate) {

        Item it1 = new Item("Kazoo", "Kazoo desc");
        Item it2 = new Item("Hammer", "Hammer desc");

        rabbitTemplate.convertAndSend(it1);
        rabbitTemplate.convertAndSend(it2);


    }

}

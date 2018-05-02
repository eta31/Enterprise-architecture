package edu.mum;

import java.io.IOException;

import edu.mum.component.FileCreate;
import edu.mum.component.MessageOrigin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.mum.component.MessageDisplay;

public class HelloWorld {
    public static void main(String[] args) {
   	 ApplicationContext applicationContext = new AnnotationConfigApplicationContext( JavaConfiguration.class );
 
    	//MessageDisplay messageDisplay = (MessageDisplay) applicationContext.getBean("standardOutMessageDisplay");

		FileCreate fileCreate = (FileCreate) applicationContext.getBean("fileMessageDisplay");
		fileCreate.display();
	}
}

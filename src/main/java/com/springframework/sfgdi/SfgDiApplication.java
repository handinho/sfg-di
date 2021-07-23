package com.springframework.sfgdi;

import com.springframework.sfgdi.controllers.ConstructorInjectedController;
import com.springframework.sfgdi.controllers.MyController;
import com.springframework.sfgdi.controllers.PropertyInjectedController;
import com.springframework.sfgdi.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		// bean name is class name starting with a lowercase letter
		MyController myController = (MyController)ctx.getBean("myController");

		String greeting = myController.sayHello();
		System.out.println(greeting);

		/* OUTPUT:
			Hello World!!!
			Hi Folks!
		 */

		System.out.println("----------- Property Based");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController") ;
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("----------- Setter Based");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController") ;
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("----------- Constructor Based");
		// no need for @Autowired annotation on constructors
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController") ;
		System.out.println(constructorInjectedController.getGreeting());
	}

}

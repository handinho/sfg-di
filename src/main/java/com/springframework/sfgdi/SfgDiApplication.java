package com.springframework.sfgdi;

import com.springframework.sfgdi.controllers.ConstructorInjectedController;
import com.springframework.sfgdi.controllers.I18nController;
import com.springframework.sfgdi.controllers.MyController;
import com.springframework.sfgdi.controllers.PropertyInjectedController;
import com.springframework.sfgdi.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.springframework.sfgdi", "com.springframework.pets"})
@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		System.out.println("----------- I18n Bean");
        I18nController i18nController = (I18nController)ctx.getBean("i18nController");
        System.out.println(i18nController.getGreeting());

		System.out.println("----------- Primary Bean");
		// bean name is class name starting with a lowercase letter
		MyController myController = (MyController)ctx.getBean("myController");
		System.out.println(myController.getGreeting());

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

		/* OUTPUT:
			----------- Primary Bean
			Hello world! - from PRIMARY bean
			----------- Property Based
			Hello World! - Property
			----------- Setter Based
			Hello World! - Setter
			----------- Constructor Based
			Hello world! - Constructor
		 */
	}

}

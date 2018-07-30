package com.example.square;

import com.example.square.model.AutoConfig;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SquareApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SquareApplication.class, args);
		Binder binder = Binder.get(context.getEnvironment());
		AutoConfig autoConfig = binder.bind("square.auto.config", Bindable.of(AutoConfig.class)).get();
		System.out.println(autoConfig);

		System.out.println(autoConfig);
	}
}

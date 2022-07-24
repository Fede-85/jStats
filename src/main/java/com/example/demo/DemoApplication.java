package com.example.demo;

import com.example.demo.lib.Generator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		Generator<Integer> generator = new Generator<>();
		Integer[] originalArray = new Integer[]{1,2,3};
		//generator.allCombinazioni(originalArray);
		generator.kCombinazioni(2,originalArray,new Integer[0]);
	}
}

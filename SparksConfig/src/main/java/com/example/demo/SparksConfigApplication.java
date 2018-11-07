package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SparksConfigApplication implements CommandLineRunner{

	private static String cluster = System.getProperty("cluster");
	private static String keyspace = System.getProperty("keyspace");
	
	public static void main(String[] args) {
		SpringApplication.run(SparksConfigApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("cluster:"+cluster);
		System.out.println("keyspace:"+keyspace);
		
	}
}

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SparksConfigApplication implements CommandLineRunner{

	private static String cluster = System.getenv("cluster");
	private static String keyspace = System.getenv("keyspace");
	private static String readTimeout = System.getenv("readTimeout");
	private static String compression = System.getenv("compression");
	private static String connectionPerExecutorMax = System.getenv("connectionPerExecutorMax");
	
	@Autowired
	ApplicationArguments appArgs;
	
	public static void main(String[] args) {
		SpringApplication.run(SparksConfigApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("cluster:"+cluster);
		System.out.println("keyspace:"+keyspace);
		System.out.println("readTimeout:"+readTimeout);
		System.out.println("compression:"+compression);
		System.out.println("connectionPerExecutorMax:"+connectionPerExecutorMax);
		
		
	}
}

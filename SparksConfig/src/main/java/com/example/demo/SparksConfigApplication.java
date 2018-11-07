package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SparksConfigApplication implements CommandLineRunner{

	private static String cluster = System.getProperty("cluster");
	private static String keyspace = System.getProperty("keyspace");
	
	@Autowired
	ApplicationArguments appArgs;
	
	public static void main(String[] args) {
		SpringApplication.run(SparksConfigApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<String> cluster = appArgs.getOptionValues("cluster");
		System.out.println("cluster:"+cluster.get(0));
		List<String> keyspace = appArgs.getOptionValues("keyspace");
		System.out.println("keyspace:"+keyspace.get(0));
		
	}
}

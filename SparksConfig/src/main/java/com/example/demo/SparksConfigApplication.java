package com.example.demo;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.vo.GlobalProperties;

@SpringBootApplication
public class SparksConfigApplication implements CommandLineRunner {

	private static String cluster = System.getenv("cluster");
	private static String keyspace = System.getenv("keyspace");
	private static String readTimeout = System.getenv("readTimeout");
	private static String compression = System.getenv("compression");
	private static String connectionPerExecutorMax = System.getenv("connectionPerExecutorMax");
	
	private static Properties properties=getSparkConfigProperties();

	@Autowired
	ApplicationArguments appArgs;

	public static void main(String[] args) {
		SpringApplication.run(SparksConfigApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("**Jenkins Parameters*********");
		System.out.println("cluster:" + cluster);
		System.out.println("keyspace:" + keyspace);
		System.out.println("readTimeout:" + readTimeout);
		System.out.println("compression:" + compression);
		System.out.println("connectionPerExecutorMax:" + connectionPerExecutorMax);
		
		//Properties properties = getSparkConfigProperties();
		System.out.println("**Local Parameters*********");
		System.out.println("cluster:" + properties.getProperty("cluster"));
		System.out.println("keyspace:" +  properties.getProperty("keyspace"));
		System.out.println("readTimeout:" +  properties.getProperty("readTimeout"));
		System.out.println("compression:" +  properties.getProperty("compression"));
		System.out.println("connectionPerExecutorMax:" +  properties.getProperty("connectionPerExecutorMax"));

	}

	public static Properties getSparkConfigProperties() {
		Properties properties = new Properties();

		try {
			properties.load(
					SparksConfigApplication.class.getClassLoader().getResourceAsStream("sparks-config.properties"));
		} catch (IOException e) {
			e.getMessage();
		}

		return properties;
	}
	
	

}

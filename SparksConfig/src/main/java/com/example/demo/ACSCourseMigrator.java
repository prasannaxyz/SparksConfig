package com.example.demo;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class ACSCourseMigrator {

	private static Properties properties = getSparkConfigProperties();

	private static String cluster = System.getenv("cluster");

	private static String readTimeout = properties.getProperty("readTimeout");

	private static String keyspace = System.getenv("keyspace");

	private static String connectionPerExecutorMax = properties.getProperty("connectionsPerExecutorMax");

	private static String compression = properties.getProperty("compression");

	public static Properties getSparkConfigProperties() {

		Properties properties = new Properties();

		try {

			properties.load(ACSCourseMigrator.class.getClassLoader().getResourceAsStream("sparks-config.properties"));

		} catch (IOException e) {

			e.getMessage();

		}

		return properties;

	}

	public static void main(String[] args) {

		System.out.println(cluster);
		System.out.println(readTimeout);
		System.out.println(keyspace);
		System.out.println(connectionPerExecutorMax);
		System.out.println(compression);

	}

}
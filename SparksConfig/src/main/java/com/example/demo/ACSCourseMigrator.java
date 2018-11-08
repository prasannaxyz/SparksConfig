package com.example.demo;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class ACSCourseMigrator {

	private static Properties properties = getSparkConfigProperties();

	private static String cluster = System.getenv("env_cluster");

	private static String targetCluster = System.getenv("env_targetCluster");

	private static String keyspace = System.getenv("env_keyspace");

	private static String targetKeyspace = System.getenv("env_targetKeyspace");

	private static String sourceTable = properties.getProperty("ACSCourceMigratorSourceTable");

	private static String targetTable = properties.getProperty("ACSCourceMigratorTargetTable");

	private static String sumatraKey = properties.getProperty("ACSCourceMigratorSumatraKey");

	private static String revelKey = properties.getProperty("ACSCourceMigratorRevelKey");

	private static String readTimeout = properties.getProperty("readTimeout");

	private static String compression = properties.getProperty("compression");

	private static String connectionPerExecutorMax = properties.getProperty("connectionsPerExecutorMax");

	public static Properties getSparkConfigProperties() {

		Properties properties = new Properties();

		try {

			properties.load(ACSCourseMigrator.class.getClassLoader().getResourceAsStream("sparks-config.properties"));

		} catch (IOException e) {

			e.getMessage();

		}

		return properties;

	}

	public void run(String sourceKeyspace, String sourceCluster, String targetCluster, String targetKeySpace) {

		if (sourceKeyspace == null) {

			sourceKeyspace = properties.getProperty("ACSCourceMigratorKeyspace");

		}

		if (sourceCluster == null) {

			sourceCluster = properties.getProperty("ACSCourceMigratorSourceCluster");

		}

		if (targetCluster == null) {

			targetCluster = properties.getProperty("ACSCourceMigratorTargetCluster");

		}

		if (targetKeySpace == null) {

			targetKeySpace = properties.getProperty("ACSCourceMigratorTargetKeyspace");

		}

		System.out.println("sourceCluster:" + sourceCluster);
		System.out.println("targetCluster:" + targetCluster);
		System.out.println("sourceKeyspace:" + sourceKeyspace);
		System.out.println("targetKeyspace:" + targetKeySpace);

	}

	public static void main(String[] args) {

		ACSCourseMigrator acsMigrate = new ACSCourseMigrator();

		acsMigrate.run(keyspace, cluster, targetCluster, targetKeyspace);

	}

}
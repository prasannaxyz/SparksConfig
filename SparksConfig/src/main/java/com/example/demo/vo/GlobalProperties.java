package com.example.demo.vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:sparks-config.properties")
public class GlobalProperties {

	@Value("${cluster}")
	private String cluster;
	
	@Value("${readTimeout}")
	private String readTimeout;
	
	@Value("${keyspace}")
	private String keyspace;
	
	@Value("${connectionPerExecutorMax}")
	private String connectionPerExecutorMax;
	
	@Value("${compression}")
	private String compression;

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	public String getReadTimeout() {
		return readTimeout;
	}

	public void setReadTimeout(String readTimeout) {
		this.readTimeout = readTimeout;
	}

	public String getKeyspace() {
		return keyspace;
	}

	public void setKeyspace(String keyspace) {
		this.keyspace = keyspace;
	}

	public String getConnectionPerExecutorMax() {
		return connectionPerExecutorMax;
	}

	public void setConnectionPerExecutorMax(String connectionPerExecutorMax) {
		this.connectionPerExecutorMax = connectionPerExecutorMax;
	}

	public String getCompression() {
		return compression;
	}

	public void setCompression(String compression) {
		this.compression = compression;
	}

}

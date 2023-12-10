package com.example.jocdedaus.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class PlayerRestService {

	@Value("${server.port}")
	private String serverPort;
//	@Value("${server.port}")
//	private String springDatasourceUrl;
//	@Value("${server.port}")
//	private String springDatasourceUsername;
//	@Value("${server.port}")
//	private String springDatasourcePassword;
//	@Value("${server.port}")
//	private String springDatasourceDriverClassName;
//	@Value("${server.port}")
//	private Boolean springJpaShowSql;
//	@Value("${server.port}")
//	private String springJpaHibernateDdlAuto;
//	@Value("${server.port}")
//	private String springJpaPropertiesHibernateDialect;
//	@Value("${server.port}")
//	private String springdocSwaggerUiPath;
	
	@GetMapping("/myConfig")
	public Map<String, Object>  myConfig(){
		Map<String, Object> params = new HashMap<>();
		params.put("serverPort", serverPort);
		//
		params.put("threadName", Thread.currentThread().getName());
		return params;
				
	}

}

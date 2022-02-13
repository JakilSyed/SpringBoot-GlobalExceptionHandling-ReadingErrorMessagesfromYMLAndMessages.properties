package com.jakil.EMS.utils;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "exceptiontype")
public class ErrorTypeFromYML {

	private Map<String, String> type;

	public Map<String, String> getType() {
		return type;
	}

	public void setType(Map<String, String> type) {
		this.type = type;
	}

	public String getErrorTypeFromYML(String code) {
		String alertType = type.get(code);
		return alertType;
	}
}

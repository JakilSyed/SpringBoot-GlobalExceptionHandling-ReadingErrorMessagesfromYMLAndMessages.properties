package com.jakil.EMS.utils;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

@Component
public class ErrorMessageFromMessageProperties {

	@Autowired
	private MessageSource messageSource;
	private MessageSourceAccessor messageSourceAccessor;

	@PostConstruct
	private void init() {
		messageSourceAccessor = new MessageSourceAccessor(messageSource, Locale.ENGLISH);
	}

	public String getMessageFromMessageProp(String code) {
		return messageSourceAccessor.getMessage(code);
	}
}

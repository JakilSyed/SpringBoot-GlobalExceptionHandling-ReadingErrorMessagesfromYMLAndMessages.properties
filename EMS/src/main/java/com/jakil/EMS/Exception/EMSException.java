package com.jakil.EMS.Exception;

public class EMSException extends RuntimeException {

	private String code;

	public EMSException(String code) {
		super();
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}

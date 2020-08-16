/**
 * 
 */
package com.hidalgoventures.c19ca.model;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author patricio
 *
 */
public class Message {
	
	@NotBlank
	private final String mobile;
	@NotBlank
	private final String text;
	
	public Message (
			@JsonProperty("mobile") String mobile,
			@JsonProperty("text") String text) {
		this.mobile = mobile;
		this.text = text;
	}

	public String getMobile() {
		return mobile;
	}

	public String getText() {
		return text;
	}
}

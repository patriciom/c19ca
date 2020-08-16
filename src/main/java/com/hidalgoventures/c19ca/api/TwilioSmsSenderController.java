/**
 * 
 */
package com.hidalgoventures.c19ca.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Install the Java helper library from twilio.com/docs/libraries/java
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 * @author patricio
 *
 */
@RequestMapping("api/v1/sms")
@RestController
@ConfigurationProperties("app")
public class TwilioSmsSenderController {

	// Find your Account Sid and Auth Token at twilio.com/console
	@Value("${app.twilio.ACCOUNT_SID}")
	private String ACCOUNT_SID;
	@Value("${app.twilio.AUTH_TOKEN}")
	private String AUTH_TOKEN;
	@Value("${app.twilio.FROM_NUMBER}")
	private PhoneNumber FROM_NUMBER;

	@PostMapping
	public void sendSMS(
			@Valid
			@NonNull
			@RequestBody
			com.hidalgoventures.c19ca.model.Message _message) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		Message sms = Message
				.creator(new PhoneNumber(_message.getMobile()), // to
						FROM_NUMBER, // from
						_message.getText())
				.create();

		System.out.println(sms.getSid());
	}
}

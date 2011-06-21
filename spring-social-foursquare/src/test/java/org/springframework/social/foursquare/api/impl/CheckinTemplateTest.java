package org.springframework.social.foursquare.api.impl;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.social.test.client.RequestMatchers.body;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.social.foursquare.api.Checkin;
import org.springframework.social.foursquare.api.CheckinParams;

public class CheckinTemplateTest extends AbstractFoursquareApiTest {

	@Test
	public void get() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/checkins/CHECKIN_ID/?access_token=ACCESS_TOKEN&v=20110608"))
			.andExpect(method(GET))
			.andRespond(withResponse(new ClassPathResource("testdata/checkin.json", getClass()), responseHeaders));
		
		Checkin checkin = foursquare.checkinOperations().get("CHECKIN_ID");
		assertEquals("4d627f6814963704dc28ff94", checkin.getId());
		mockServer.verify();
	}
	
	public void add() {
		mockServer.expect(requestTo("https://api.foursquare.com/v2/checkins/add/?access_token=ACCESS_TOKEN&v=20110608"))
			.andExpect(method(POST))
			.andExpect(body("venueId=VENUE_ID&shout=SHOUT&broadcast=public&ll=10.0,10.0&llAcc=10&alt=200.0&altAcc=10"))
			.andRespond(withResponse(new ClassPathResource("testdata/checkin.json", getClass()), responseHeaders));
		
		CheckinParams params = new CheckinParams().venueId("VENUE_ID").shout("SHOUT").broadcast("public").latitude(10d).longitude(10d).locationAccuracy(10l).altitude(200d).altitudeAccuracy(10l);
		Checkin checkin = foursquare.checkinOperations().add(params);
		assertEquals("4d627f6814963704dc28ff94", checkin.getId());
		mockServer.verify();
	}
}

package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.springframework.social.foursquare.api.CheckinInfo;

public class HereNowContainerDeserializer extends AbstractFoursquareDeserializer<HereNowContainer> {
	@Override
	public HereNowContainer deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return new HereNowContainer(deserializeNestedResponseObject(jp, "hereNow", CheckinInfo.class));
	}
}

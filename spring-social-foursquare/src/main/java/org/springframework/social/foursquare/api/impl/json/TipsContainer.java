package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.social.foursquare.api.Tips;

@JsonDeserialize(using=TipsContainerDeserializer.class)
public class TipsContainer {
	
	private Tips tips;
	
	public TipsContainer(Tips tips) {
		this.tips = tips;
	}
	
	public Tips getTips() {
		return tips;
	}
}

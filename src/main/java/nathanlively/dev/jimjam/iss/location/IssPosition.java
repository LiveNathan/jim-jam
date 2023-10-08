package nathanlively.dev.jimjam.iss.location;

import com.fasterxml.jackson.annotation.JsonProperty;

public record IssPosition(

	@JsonProperty("latitude")
	String latitude,

	@JsonProperty("longitude")
	String longitude
) {
}
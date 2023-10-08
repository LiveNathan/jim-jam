package nathanlively.dev.jimjam.iss.location;

import com.fasterxml.jackson.annotation.JsonProperty;

public record IssLocationResponse(

	@JsonProperty("iss_position")
	IssPosition issPosition,

	@JsonProperty("message")
	String message,

	@JsonProperty("timestamp")
	int timestamp
) {
}
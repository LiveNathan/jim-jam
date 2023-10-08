package nathanlively.dev.jimjam.iss.pop;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public record IssPopResponse(

	@JsonProperty("number")
	int number,

	@JsonProperty("message")
	String message,

	@JsonProperty("people")
	List<PeopleItem> people
) {
}
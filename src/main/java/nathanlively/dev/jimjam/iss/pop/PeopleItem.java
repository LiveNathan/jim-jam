package nathanlively.dev.jimjam.iss.pop;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PeopleItem(

	@JsonProperty("craft")
	String craft,

	@JsonProperty("name")
	String name
) {
}
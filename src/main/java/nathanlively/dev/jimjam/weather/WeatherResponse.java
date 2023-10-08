package nathanlively.dev.jimjam.weather;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public record WeatherResponse(

	@JsonProperty("current")
	Current current,

	@JsonProperty("timezone")
	String timezone,

	@JsonProperty("timezone_offset")
	int timezoneOffset,

	@JsonProperty("daily")
	List<DailyItem> daily,

	@JsonProperty("lon")
	Object lon,

	@JsonProperty("lat")
	Object lat
) {
}
package nathanlively.dev.jimjam.weather;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public record DailyItem(

	@JsonProperty("moonset")
	int moonset,

	@JsonProperty("summary")
	String summary,

	@JsonProperty("rain")
	Object rain,

	@JsonProperty("sunrise")
	int sunrise,

	@JsonProperty("temp")
	Temp temp,

	@JsonProperty("moon_phase")
	Object moonPhase,

	@JsonProperty("uvi")
	Object uvi,

	@JsonProperty("moonrise")
	int moonrise,

	@JsonProperty("pressure")
	int pressure,

	@JsonProperty("clouds")
	int clouds,

	@JsonProperty("feels_like")
	FeelsLike feelsLike,

	@JsonProperty("wind_gust")
	Object windGust,

	@JsonProperty("dt")
	int dt,

	@JsonProperty("pop")
	Object pop,

	@JsonProperty("wind_deg")
	int windDeg,

	@JsonProperty("dew_point")
	Object dewPoint,

	@JsonProperty("sunset")
	int sunset,

	@JsonProperty("weather")
	List<WeatherItem> weather,

	@JsonProperty("humidity")
	int humidity,

	@JsonProperty("wind_speed")
	Object windSpeed
) {
}
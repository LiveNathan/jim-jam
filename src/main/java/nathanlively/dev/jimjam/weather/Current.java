package nathanlively.dev.jimjam.weather;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public record Current(

	@JsonProperty("sunrise")
	int sunrise,

	@JsonProperty("temp")
	int temp,

	@JsonProperty("visibility")
	int visibility,

	@JsonProperty("uvi")
	int uvi,

	@JsonProperty("pressure")
	int pressure,

	@JsonProperty("clouds")
	int clouds,

	@JsonProperty("feels_like")
	Object feelsLike,

	@JsonProperty("wind_gust")
	Object windGust,

	@JsonProperty("dt")
	int dt,

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
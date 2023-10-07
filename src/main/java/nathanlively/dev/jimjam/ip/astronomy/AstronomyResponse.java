package nathanlively.dev.jimjam.ip.astronomy;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AstronomyResponse(

	@JsonProperty("date")
	String date,

	@JsonProperty("moonset")
	String moonset,

	@JsonProperty("sunrise")
	String sunrise,

	@JsonProperty("solar_noon")
	String solarNoon,

	@JsonProperty("day_length")
	String dayLength,

	@JsonProperty("sun_status")
	String sunStatus,

	@JsonProperty("moonrise")
	String moonrise,

	@JsonProperty("moon_distance")
	Object moonDistance,

	@JsonProperty("moon_azimuth")
	Object moonAzimuth,

	@JsonProperty("sun_distance")
	Object sunDistance,

	@JsonProperty("moon_altitude")
	Object moonAltitude,

	@JsonProperty("sun_azimuth")
	Object sunAzimuth,

	@JsonProperty("moon_status")
	String moonStatus,

	@JsonProperty("moon_parallactic_angle")
	Object moonParallacticAngle,

	@JsonProperty("sunset")
	String sunset,

	@JsonProperty("location")
	Location location,

	@JsonProperty("current_time")
	String currentTime,

	@JsonProperty("sun_altitude")
	Object sunAltitude
) {
}
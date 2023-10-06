package nathanlively.dev.jimjam.ip;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Geo(

	@JsonProperty("zipcode")
	String zipcode,

	@JsonProperty("city")
	String city,

	@JsonProperty("district")
	String district,

	@JsonProperty("latitude")
	String latitude,

	@JsonProperty("country_code2")
	String countryCode2,

	@JsonProperty("country_name")
	String countryName,

	@JsonProperty("country_code3")
	String countryCode3,

	@JsonProperty("country_name_official")
	String countryNameOfficial,

	@JsonProperty("state_prov")
	String stateProv,

	@JsonProperty("state_code")
	String stateCode,

	@JsonProperty("longitude")
	String longitude
) {
}
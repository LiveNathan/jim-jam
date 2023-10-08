package nathanlively.dev.jimjam.ip.location;

import com.fasterxml.jackson.annotation.JsonProperty;

public record IpGeoLocationResponse(

	@JsonProperty("date")
	String date,

	@JsonProperty("week")
	int week,

	@JsonProperty("year")
	int year,

	@JsonProperty("timezone")
	String timezone,

	@JsonProperty("timezone_offset")
	int timezoneOffset,

	@JsonProperty("year_abbr")
	String yearAbbr,

	@JsonProperty("geo")
	Geo geo,

	@JsonProperty("date_time")
	String dateTime,

	@JsonProperty("month")
	int month,

	@JsonProperty("dst_savings")
	int dstSavings,

	@JsonProperty("timezone_offset_with_dst")
	int timezoneOffsetWithDst,

	@JsonProperty("date_time_wti")
	String dateTimeWti,

	@JsonProperty("date_time_unix")
	Object dateTimeUnix,

	@JsonProperty("time_24")
	String time24,

	@JsonProperty("time_12")
	String time12,

	@JsonProperty("date_time_txt")
	String dateTimeTxt,

	@JsonProperty("date_time_ymd")
	String dateTimeYmd,

	@JsonProperty("is_dst")
	boolean isDst
) {
}
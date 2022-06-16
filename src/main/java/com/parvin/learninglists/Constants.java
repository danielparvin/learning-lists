package com.parvin.learninglists;

public class Constants {
	public static final String API_BASE = "/api/v1";
	public static final String APPLICATION_JSON = "application/json";

	public static final String DEFAULT_PAGE_NUMBER_STRING = "0";
	public static final String DEFAULT_PAGE_SIZE_STRING = "10";
	public static final String DEFAULT_SORT_BY_STRING = "id";

	private Constants() {
		throw new IllegalStateException("Utility class");
	}
}

package moblab.bme.sipka.bence.mobillabor2017f1.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonHelper {
	public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

	private static Gson gson;

	static {
		gson = new GsonBuilder().setDateFormat(DATE_FORMAT).create();
	}

	public static Gson getGson() {
		return gson;
	}
}
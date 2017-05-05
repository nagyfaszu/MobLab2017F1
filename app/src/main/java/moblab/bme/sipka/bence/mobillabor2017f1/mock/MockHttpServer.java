package moblab.bme.sipka.bence.mobillabor2017f1.mock;

import moblab.bme.sipka.bence.mobillabor2017f1.mock.interceptors.MockInterceptor;
import okhttp3.Request;
import okhttp3.Response;

public class MockHttpServer {

	public static Response call(Request request) {
		MockInterceptor mockInterceptor = new MockInterceptor();
		return mockInterceptor.process(request);
	}
}
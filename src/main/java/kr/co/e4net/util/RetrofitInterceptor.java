package kr.co.e4net.util;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RetrofitInterceptor implements Interceptor{
	
	private String authToken;

    public RetrofitInterceptor(String token) {
        this.authToken = token;
    }
	@Override
	public Response intercept(Chain arg0) throws IOException {
		Request original = arg0.request();

        Request.Builder builder = original.newBuilder()
                .header("Authorization", authToken);

        Request request = builder.build();
        return arg0.proceed(request);
		
	}

}

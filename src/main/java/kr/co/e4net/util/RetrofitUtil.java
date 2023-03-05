package kr.co.e4net.util;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.http.util.TextUtils;

import devcsrj.okhttp3.logging.HttpLoggingInterceptor;
import kr.co.e4net.dto.Token;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class RetrofitUtil {

	private static final String BASE_URL = "http://api.iamport.kr/";
    // 2. log interceptor
    private static final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
    // 3. 사용할 http client
    private static final OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor);
    
    
    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build();

    // 4. 서비스 등록
    public static <T> T createService(Class<T> serviceClass ) {
        return retrofit.create(serviceClass);
    }

    public static <T> T createService(Class<T> serviceClass, final String authToken, final String key ) {
        if(!TextUtils.isEmpty(authToken)) {
        	
        }
    	
    	return retrofit.create(serviceClass);
    }
    
    // 5. 서비스 호출
    public static <T> Optional<T> requestSync(Call<T> call) {
        try {
            Response<T> execute = call.execute();
            System.out.println("execute = " + execute);
            if (execute.isSuccessful()) {
                return Optional.ofNullable(execute.body());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static <T> void requestAsync(Call<T> call, CustomCallback<T> callback) {
        call.enqueue(callback);
    }

	public static void requestAsynca(Call<Token> token, CustomCallback<Object> customCallback) {
		// TODO Auto-generated method stub
		
	}
	
}

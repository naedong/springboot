package kr.co.e4net.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.co.e4net.config.server.ServerAPIs;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class retrofitConfig {


    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder().connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }
    	// 
    
    @Bean
    public Retrofit retrofit(OkHttpClient client) {
        String baseURL = "https://api.iamport.kr";
        String testUrl = "http://localhost:8888";
        return new Retrofit.Builder().baseUrl(baseURL)
             .addConverterFactory(GsonConverterFactory.create()) //데이터 수정이 필요없기 때문에
                .client(client)
                .build();
    }

    @Bean
   public ServerAPIs serverAPI(Retrofit retrofit) {
       return retrofit.create(ServerAPIs.class);
    }
	
}

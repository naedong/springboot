package kr.co.e4net.config.server;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import kr.co.e4net.dto.Token;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ServerAPIs {

	
    @GET("user/getToken")
    Call<String> gToken(
            @Header("Authorization") String token,
            @Query("query") String query,
            @Query("category_group_code") String categoryGroupCode,
            @Query("size") int size,            // 1 ~ 15
            @Query("page") int page,            // 1 ~ 45
            @Query("sort") String sort,         // distance 또는 accuracy (기본값: accuracy)
            @Query("x") String x,
            @Query("y") String y
    );
    
    
    @GET("/test/url")
    Call<Object> getTest(
    		@Header("Content-Type") String content 
    		 );
    
    @FormUrlEncoded
  //  @Headers("Content-Type: application/json")
    @POST("/users/getToken")
    Call<Object> getToken(@Field(value = "imp_key") String imp_key, @Field(value = "imp_secret") String imp_secret
    		); 
    
    
//    @GET("/certificaions/{imp_uid}")
//    Call<>
//    
    
    
}

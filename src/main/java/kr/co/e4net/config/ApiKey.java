package kr.co.e4net.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class ApiKey {
	
	@Value("${app.apikey}")
	private String key;
	
	@Value("${app.secretapikey}")
	private String secretKey;
	
	

    @SerializedName("imp_key")
    @Value("${app.portkey}")
	private  String PORTKEY;
	
    
    @SerializedName("imp_secret")
	@Value("${app.portrestkey}")
	private  String restportkey;

    

	@SerializedName("access_token")
    private String token;
	    
	
}

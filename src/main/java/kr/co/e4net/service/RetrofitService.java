package kr.co.e4net.service;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.catalina.mapper.Mapper;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;

import aj.org.objectweb.asm.TypeReference;
import kr.co.e4net.config.ApiKey;
import kr.co.e4net.config.server.ServerAPIs;
import kr.co.e4net.dto.Token;
import kr.co.e4net.util.CustomCallback;
import kr.co.e4net.util.RetrofitUtil;
import lombok.RequiredArgsConstructor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import springfox.documentation.spring.web.json.Json;

@Service
@RequiredArgsConstructor
public class RetrofitService {

	private static final String CONTENTTYPE = "application/json";
	
	private final ServerAPIs serverAPI;
	
	private final ApiKey apikey;
	
	public void apiTest() throws Exception {
		
	ServerAPIs serverAPI = RetrofitUtil.createService(ServerAPIs.class);
		
		Call<Object> test = serverAPI.getTest(CONTENTTYPE);
//		RetrofitUtil.requestSync(test);
		
		RetrofitUtil.requestAsync(serverAPI.getTest(CONTENTTYPE), new CustomCallback<Object>() {
			 @Override
			    public void onResponse(Call<Object> call, Response<Object> response) {
			        super.onResponse(call, response);

			 }

			    @Override
			    public void onFailure(Call<Object> call, Throwable t) {
			        super.onFailure(call, t);
			    }
	});
//	
	
		//Call<Object> call = serverAPI.getToken(CONTENT_TYPE, json, json, 0, 0, json, json, json);
		
		
	}

		//Call<Object> call = serverAPI.getToken(CONTENT_TYPE, json, json, 0, 0, json, json, json);
		
	public String getToken(String String, String sekey) throws Exception {
		ServerAPIs serverAPI = RetrofitUtil.createService(ServerAPIs.class);
		
		Call<Object> test = serverAPI.getToken( String, sekey);
//		RetrofitUtil.requestSync(test);
		
		RetrofitUtil.requestAsync(serverAPI.getToken( String, sekey), new CustomCallback<Object>() {
			 @Override
			    public void onResponse(Call<Object> call, Response<Object> response) {
			        super.onResponse(call, response);
			        if(response.isSuccessful()) {
			        	  response.body();
			        }
			        Map<String,Object> map = new HashMap<String,Object>();
			        Gson gson = new Gson();
//			        try {
//			        	JsonNode jsonNode = new ObjectMapper().readTree((JsonParser)response.body()); 
//						Token token = new Token();
//						token.setToken(jsonNode.get("response").get(0).textValue());
//						System.out.println(token.getToken()+"node");
//			        } catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
			        map = (Map<String,Object>) gson.fromJson(new Gson().toJson(response.body()), map.getClass());
			        for(Entry<java.lang.String, Object> ee : map.entrySet() ) {
			        	if(ee.getKey().equals("response")) {
			        		map = gson.fromJson(new Gson().toJson(ee.getValue()), map.getClass());
			        		System.out.println(ee.getValue());
			        		for(Entry<java.lang.String, Object> et : map.entrySet()) {
			        			if(et.getKey().equals("access_token")){
			        				System.out.println(et.getValue());
			        				 apikey.setToken(et.getValue().toString());
			        				 
			        			} 
			        		}
			        }     
			 }			        
			 }
			    @Override
			    public void onFailure(Call<Object> call, Throwable t) {
			        super.onFailure(call, t);
			        	System.out.println("-----------------------ERROR");
			        t.printStackTrace();
			    }
	});
		
			return apikey.getToken();
		}

			
		
	
}

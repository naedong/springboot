package kr.co.e4net.dto;

import java.util.Map;

import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Token {
	
	
	
	@SerializedName("access_token")
	private String token;
	
	
	
	
}

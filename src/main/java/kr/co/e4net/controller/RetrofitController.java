package kr.co.e4net.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.e4net.config.ApiKey;
import kr.co.e4net.dto.Token;
import kr.co.e4net.service.RetrofitService;
import kr.co.e4net.service.TbMembService;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@CrossOrigin
public class RetrofitController {

	private final RetrofitService retrofitService;
	private final ApiKey apiKey;
	
	@GetMapping("usert")
	public ResponseEntity<String> tsetdd() throws Exception{

		String token =	retrofitService.getToken(apiKey.getPORTKEY(), apiKey.getRestportkey());
		System.out.println(token);
		return ResponseEntity.ok(token);
	}
	
	
	
}

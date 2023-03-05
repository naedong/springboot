package kr.co.e4net.controller;

import java.util.Random;

import javax.naming.AuthenticationNotSupportedException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.e4net.config.ApiKey;
import kr.co.e4net.dto.TbMembDto.Phone;
import kr.co.e4net.dto.TbMembDto.TbMembSign;
import kr.co.e4net.entity.TbMembEntity;
import kr.co.e4net.service.SMSService;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@CrossOrigin
public class SMSController {
	
	private final SMSService smsService;
	
	  @PostMapping("login/send-one")
	    public ResponseEntity<Boolean> sendSms(@RequestBody Phone requestDto) {
	        smsService.sendSms(requestDto.getPhone());
	        return ResponseEntity.ok(true);
	    }
	  
	   //인증번호 확인
	    @PostMapping("login/send-two")
	    public ResponseEntity<Boolean> SmsVerification(@RequestBody Phone requestDto) throws AuthenticationNotSupportedException  {
	        return ResponseEntity.ok(smsService.verifySms(requestDto));
	    }
	  
}

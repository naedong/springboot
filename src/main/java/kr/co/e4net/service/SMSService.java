package kr.co.e4net.service;

import static kr.co.e4net.dto.SmsTemplate.coolSmsConstants.APP_VERSION;
import static kr.co.e4net.dto.SmsTemplate.coolSmsConstants.SMS_TYPE;

import java.util.HashMap;
import java.util.Random;

import javax.naming.AuthenticationNotSupportedException;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;


import kr.co.e4net.dto.SmsTemplate;
import kr.co.e4net.dto.TbMembDto.Phone;
import kr.co.e4net.exception.SmsFailExcetion;
import kr.co.e4net.respository.Redis;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;


@Slf4j
@RequiredArgsConstructor
@Service
@ConfigurationProperties("app")
public class SMSService {
	
		private final Redis redis;
		
		@Value("${app.apikey}")
		private  String apikey;
		
		@Value("${app.secretapikey}")
		private  String secretapikey;
		
	    public static final String makeRandomNumber() {
	        Random random = new Random();
	        return String.valueOf(100000 + random.nextInt(900000));
	    }
	    
	    
	    
	    // 인증 메세지 내용 생성
	    public String makeSmsContent(String certificationNumber) {
	        SmsTemplate content = new SmsTemplate();
	        return content.builderContent(certificationNumber);
	    }

	    public HashMap<String, String> makeParams(String to, String text) {
	        HashMap<String, String> params = new HashMap();
	        params.put("from", "01087190962");
	        params.put("type", SMS_TYPE);
	        params.put("app_version", APP_VERSION);
	        params.put("to", to);
	        params.put("text", text);
	        return params;
	    }

	    // sms로 인증번호 발송하고, 발송 정보를 세션에 저장
	    public void sendSms(String phone) {
	        Message coolsms = new Message(apikey,
	            secretapikey);
	        String randomNumber = makeRandomNumber();
	        String content = makeSmsContent(randomNumber);
	        HashMap<String, String> params = makeParams(phone, content);

	        try {
	            JSONObject result = coolsms.send(params);
	            if (result.get("success_count").toString().equals("0")) {
	                throw new SmsFailExcetion();
	            }
	        } catch (CoolsmsException exception) {
	            exception.printStackTrace();
	        }

	        	redis.createSmsCertification(phone, randomNumber);
	    }

	    // 입력한 인증번호가 발송되었던(세션에 저장된) 인증번호가 동일한지 확인
	    public Boolean verifySms(Phone requestDto) throws AuthenticationNotSupportedException {
	        if (isVerify(requestDto)) {
	            throw new AuthenticationNotSupportedException("인증번호가 일치하지 않습니다.");
	        }
	       return redis.removeSmsCertification(requestDto.getPhone());
	    }

	    private boolean isVerify(Phone requestDto) {
	        return !(redis.hasKey(requestDto.getPhone()) &&
	        		redis.getSmsCertification(requestDto.getPhone())
	                .equals(requestDto.getCertificationNumber()));
	    }
}

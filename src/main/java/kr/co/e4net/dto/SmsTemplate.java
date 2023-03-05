package kr.co.e4net.dto;

public class SmsTemplate {
	
	 public String builderContent(String certificationNumber) {

	        StringBuilder builder = new StringBuilder();
	        builder.append("[E4Net] 인증번호는 ");
	        builder.append(certificationNumber);
	        builder.append("입니다. ");

	        return builder.toString();
	    }
	 
	 
	 public static class coolSmsConstants {
		 
		    public static final String SMS_TYPE = "text";
		    public static final String APP_VERSION = "test 1.2";
		
	 }
}

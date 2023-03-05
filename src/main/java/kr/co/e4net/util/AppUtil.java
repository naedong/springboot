package kr.co.e4net.util;

public class AppUtil implements UtillInter{
	
	public String ChangeInt(final int numb) {
		String any = null;
		switch (numb) {
		case 10:
			any = "가입";
			break;
	
		case 20:
			any = "휴면";
			break;
		
		case 99:
			any = "탈퇴";
			break;
}

		return any;
	}
}

package kr.co.e4net.enums;


import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
@Getter
public enum MembCls implements EnumMap {
	ROLE_ADMIN( "관리자"),
	ROLE_SELLER( "판매자"),
	ROLE_USER("사용자");

	
	private static Map map = new HashMap<>();
	
	static {
		for( MembCls membCls : MembCls.values()) {
			map.put(membCls.legacyCodeName, membCls);
		}
	}
	

	private  String legacyCodeName;
//    private static Map map = new HashMap<>();
	
	MembCls( String legacyCodeName) {
		// TODO Auto-generated constructor stub
	
		this.legacyCodeName = legacyCodeName;
	}

	public static MembCls toSting(String legacyCodeName) {
		return (MembCls) map.get(legacyCodeName);
	}
	
	
	public String getLegacyCodeName() {
		// TODO Auto-generated method stub
		return this.legacyCodeName;
	}


	
}

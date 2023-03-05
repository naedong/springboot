//package kr.co.e4net.util;
//
//import java.util.EnumSet;
//
//import org.apache.commons.lang.StringUtils;
//
////import com.nimbusds.oauth2.sdk.util.StringUtils;
//
//import kr.co.e4net.enums.EnumMap;
//import lombok.AccessLevel;
//import lombok.NoArgsConstructor;
//
//@NoArgsConstructor(access = AccessLevel.PRIVATE)
//public class LegacyEnumConvertUtils {
//	public static<T extends Enum<T> & EnumMap> T ofLegacyCodeName(Class<T> enumClass, String legacyCodeName) throws Exception {
//		
//		if(StringUtils.isBlank(legacyCodeName)) {
//			return null;
//		}
//		
//		return EnumSet.allOf(enumClass).stream()
//				.filter(v -> v.getLegacyCodeName().equals(legacyCodeName))
//				.findAny()
//				.orElseThrow(() -> new NullPointerException(String.format("enum =[%s], legacyCodeName=[%s]가 존재하지 않습니다..", enumClass, legacyCodeName)));
//		
//	}
//	public static <T extends Enum<T> & EnumMap> String toLegacyCodeName(T enumValue) {
//	if(enumValue == null) {
//		return "";
//	}
//	return enumValue.getLegacyCodeName();
//	}
//	
//	
////	public static 
//}

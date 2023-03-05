//package kr.co.e4net.enums.converter;
//
//import javax.persistence.AttributeConverter;
//
//import org.springframework.stereotype.Component;
//
//import kr.co.e4net.enums.EnumMap;
//import kr.co.e4net.enums.MembCls;
//import kr.co.e4net.enums.MembStatusCd;
////import kr.co.e4net.util.LegacyEnumConvertUtils;
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//import lombok.Setter;
//
//
//
//@Getter
//@Setter
//
//public class AbstractConverter<E extends Enum<E> & EnumMap>  implements AttributeConverter<E, String>{
//
//	private  Class<E> EnumClass;
//	private boolean nullable;
//	private String enumName;
//		
//	
//
//
//	@Override
//	public String convertToDatabaseColumn(E attribute) {
//		// TODO Auto-generated method stub
//		if(!nullable && attribute == null) {
//			try {
//				throw new IllegalAccessException(String.format("%s 불가능", "ENUm이 생성되지 않습니다."));
//			} catch (IllegalAccessException e) {
//				throw new RuntimeException(e);
//			}
////		왜???	throw new IllegalAccessException("불가능 합니다.");
//		}
//		
//		return LegacyEnumConvertUtils.toLegacyCodeName(attribute);
//	}
//
//	@Override
//	public E convertToEntityAttribute(String dbData) {
//		if(!nullable && StringUtils.isBlank(dbData)) {
//			try {
//				throw new IllegalAccessException(String.format("%s DB에 Null 또는 empty()", dbData));
//			} catch (IllegalAccessException e) {
//				throw new RuntimeException(e);
//			}
//		}
//			try {
//				return LegacyEnumConvertUtils.ofLegacyCodeName(EnumClass, dbData);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return null;
//
//	}		
//}

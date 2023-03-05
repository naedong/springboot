package kr.co.e4net.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public enum MembStatusCd implements EnumMap{
	join(10),
	dormancy(20),
	delete(99);
	

	private Integer value;
	

	
	  private static HashMap<Integer, MembStatusCd> enumById = new HashMap<>();
	    static {
	        Arrays.stream(values()).forEach(e -> enumById.put(e.getValue(), e));
	    }

	  public Integer getValue() {
	        return this.value;
	    }
	
	public static MembStatusCd valueOf(Integer membStatusCd) {
		return (MembStatusCd) enumById.get(membStatusCd);
	}
	
	MembStatusCd(Integer value){
		this.value = value;
	}

//	private static final Map<Integer, MembStatusCd> codeTOEnum =
//			Stream.of(values()).collect(toMap(MembStatusCd::getNumbName, e -> e));
//	
//	public static MembStatusCd fromCode(Integer dto) {
//		MembStatusCd membStatusCd = codeTOEnum.get(dto);
//	return membStatusCd;
//	}
//	
	


}

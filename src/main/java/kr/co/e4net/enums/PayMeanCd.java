package kr.co.e4net.enums;

import java.util.Arrays;
import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter

public enum PayMeanCd implements EnumMap {
	card(01),
	tongjang(02),
	cash(03);
	
	
	private Integer value;


	  private static HashMap<Integer, PayMeanCd> enumById = new HashMap<>();
	    static {
	        Arrays.stream(values()).forEach(e -> enumById.put(e.getValue(), e));
	    }

	  public Integer getValue() {
	        return this.value;
	    }
	
	public static PayMeanCd valueOf(Integer payMeanCd) {
		return (PayMeanCd) enumById.get(payMeanCd);
	}
	
	PayMeanCd(Integer value){
		this.value = value;
	}
}

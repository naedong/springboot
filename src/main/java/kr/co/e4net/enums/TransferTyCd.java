package kr.co.e4net.enums;

import java.util.Arrays;
import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public enum TransferTyCd implements EnumMap {

	charge(01),
	use(02),
	change(03);
	


	
	private Integer value;


	  private static HashMap<Integer, TransferTyCd> enumById = new HashMap<>();
	    static {
	        Arrays.stream(values()).forEach(e -> enumById.put(e.getValue(), e));
	    }

	  public Integer getValue() {
	        return this.value;
	    }
	
	public static TransferTyCd valueOf(Integer payMeanCd) {
		return (TransferTyCd) enumById.get(payMeanCd);
	}
	
	TransferTyCd(Integer value){
		this.value = value;
	}
}

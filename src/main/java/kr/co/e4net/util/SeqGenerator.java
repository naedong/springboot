package kr.co.e4net.util;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Stream;

import javax.persistence.ParameterMode;

import org.apache.catalina.SessionIdGenerator;
import org.apache.velocity.runtime.directive.Parse;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.exception.spi.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.hibernate.result.Outputs;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;
import org.springframework.context.annotation.Configuration;
import org.hibernate.internal.util.config.ConfigurationHelper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;




public class SeqGenerator extends SequenceStyleGenerator {
	
	public static final String SEQ_GENERATOR_PARAM_KEY = "GOODS_NO_SEQ";
	private String goodsNo;
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub

  
//        	String query = String.format("select %s from %s", 
//        			session.getEntityPersister(object.getClass().getName(),
//        					object)
//        			.getIdentifierPropertyName(), 
//        			object.getClass().getSimpleName());
//        	
//        	Stream ids = session.createQuery(query).stream();
//        	
     return  String.format(goodsNo, super.generate(session, object));
        	
//        	 Connection connection = session.connection();
//             int id=0;
//                try {
//
//                    PreparedStatement ps = connection
//                            .prepareStatement("SELECT MAX(GOODS_NO) as value from project_00.TB_GOODS");
//
//                    ResultSet rs = ps.executeQuery();
//                    if (rs.next()) {
//                        id = rs.getInt("value");
//                       id++;
//                    }
//                    ps = connection
//                            .prepareStatement("INSERT INTO project_00.COURIER_TRANSACTIONS_SER_TABLE VALUES("+id+")");
//                    ps.execute();
//                } catch (SQLException e) {       
//                    e.printStackTrace();
//                }
//                return goodsNo+id;
//        }
//        	
//			Long max = ids.map(o -> ((Properties) o).replace(formatedNow + 0000 + goodsNo, ""))
//					.mapToLong(null)
//					.count();
					
        	//long maxl = max + Long.parseLong("1");
        	
//			return formatedNow + maxl;
//		
     //   ProcedureCall procedureCall = session.createStoredProcedureCall("SEQ_GENERATOR"); // 호출할 프로시저
//
//        procedureCall.registerParameter("InputParam", String.class, ParameterMode.IN); // 프로시저에 선언된 입력받는 변수명 등록
//        procedureCall.registerParameter("GOODS_NO", String.class, ParameterMode.OUT); // 프로시저에 선언된 반환하는 변수명 등록
//
//        procedureCall.setParameter("InputParam", formatedNow); // 프로시저의 변수에 전달할 파라미터 설정
//
//        ProcedureOutputs outputs = procedureCall.getOutputs(); // 프로시저에서 반환하는값들

	}
	
	 	
	@Override
		public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
			super.configure(LongType.INSTANCE, params, serviceRegistry);
			this.goodsNo = 
ConfigurationHelper.getString("dateformat", params, LocalDate.now()
		.format(DateTimeFormatter.ofPattern("yyyyMMdd"))) 
 + ConfigurationHelper.getString("numberformat", params, "%07d") ; 			
	}
	
	



}

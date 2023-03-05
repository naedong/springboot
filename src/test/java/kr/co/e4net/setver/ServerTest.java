package kr.co.e4net.setver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.e4net.config.retrofitConfig;
import kr.co.e4net.config.server.ServerAPIs;
import kr.co.e4net.util.CustomCallback;
import kr.co.e4net.util.RetrofitUtil;
import retrofit2.Call;
import retrofit2.Response;

@SpringBootTest
public class ServerTest {

//	private final String ContentType = "Application/Json";
//
//	@Test
//	public void Test() {
//		ServerAPIs serverAPI = RetrofitUtil.createService(ServerAPIs.class);
//
//		Call<Object> test = serverAPI.getTest( "테스트 중");
//		RetrofitUtil.requestSync(test);
//
//		RetrofitUtil.requestAsync(serverAPI.getTest(ContentType), new CustomCallback<Object>() {
//			 @Override
//			    public void onResponse(Call<Object> call, Response<Object> response) {
//			        super.onResponse(call, response);
//			    }
//
//			    @Override
//			    public void onFailure(Call<Object> call, Throwable t) {
//			        super.onFailure(call, t);
//			    }
//		});
//
//	}
}

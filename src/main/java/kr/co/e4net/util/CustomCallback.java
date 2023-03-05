package kr.co.e4net.util;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class CustomCallback<T> implements Callback<T> {

	@Override
	public void onResponse(Call<T> call, Response<T> response) {
		// TODO Auto-generated method stub
		
		System.out.println("여기 확인"+response);

		System.out.println("여기 확인+++++++++++++++++++++++++++++++++");
		System.out.println("여기 확인"+call);
		
	}

	@Override
	public void onFailure(Call<T> call, Throwable t) {
		// TODO Auto-generated method stub
		t.printStackTrace();
		
		
	}

}

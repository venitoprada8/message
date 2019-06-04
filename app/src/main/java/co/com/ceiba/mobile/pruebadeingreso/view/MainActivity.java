package co.com.ceiba.mobile.pruebadeingreso.view;

import android.app.Activity;
import android.os.Bundle;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.entity.User;
import co.com.ceiba.mobile.pruebadeingreso.models.Users;
import co.com.ceiba.mobile.pruebadeingreso.rest.Iservices;
import co.com.ceiba.mobile.pruebadeingreso.rest.Restapidata;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Iservices iservices=Restapidata.getClientService();
        Call<List<Users>>call=iservices.getComics();
        call.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                System.out.println(response.body().size());
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                System.out.println("");
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }


}
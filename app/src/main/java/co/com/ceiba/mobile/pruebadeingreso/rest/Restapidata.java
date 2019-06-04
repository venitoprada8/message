package co.com.ceiba.mobile.pruebadeingreso.rest;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static co.com.ceiba.mobile.pruebadeingreso.rest.Endpoints.URL_BASE;

public class Restapidata {
    private static Iservices API_SERVICE;

    public static Iservices getClientService(){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client= new OkHttpClient.Builder();
        client.addInterceptor(logging);

        if (API_SERVICE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client.build()) // <-- usamos el log level
                    .build();
            API_SERVICE = retrofit.create(Iservices.class);
        }
        return API_SERVICE;
    }
}

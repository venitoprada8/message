package co.com.ceiba.mobile.pruebadeingreso.data;

import co.com.ceiba.mobile.pruebadeingreso.entity.User;
import retrofit2.Call;
import retrofit2.http.GET;

import static co.com.ceiba.mobile.pruebadeingreso.rest.Endpoints.GET_USERS;

public interface Iservices {

    @GET(GET_USERS)
    Call<User> getComics();

}

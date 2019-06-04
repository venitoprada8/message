package co.com.ceiba.mobile.pruebadeingreso.rest;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.entity.User;
import co.com.ceiba.mobile.pruebadeingreso.models.Users;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

import static co.com.ceiba.mobile.pruebadeingreso.rest.Endpoints.GET_USERS;

public interface Iservices {

    @GET(GET_USERS)
    Call<List<Users>> getComics();

}

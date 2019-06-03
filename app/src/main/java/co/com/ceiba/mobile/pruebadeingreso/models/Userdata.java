package co.com.ceiba.mobile.pruebadeingreso.models;

import java.util.ArrayList;

import co.com.ceiba.mobile.pruebadeingreso.entity.User;

public class Userdata {


    public ArrayList<User> getResults() {
        return results;
    }

    public void setResults(ArrayList<User> results) {
        this.results = results;
    }

    private ArrayList<User> results = new ArrayList<>();
}

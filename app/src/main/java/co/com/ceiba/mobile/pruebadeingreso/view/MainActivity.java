package co.com.ceiba.mobile.pruebadeingreso.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.adapters.AdaptadorUsers;
import co.com.ceiba.mobile.pruebadeingreso.database.AppDatabase;
import co.com.ceiba.mobile.pruebadeingreso.models.Users;
import co.com.ceiba.mobile.pruebadeingreso.rest.Iservices;
import co.com.ceiba.mobile.pruebadeingreso.rest.Restapidata;
import co.com.ceiba.mobile.pruebadeingreso.utils.DatabaseInitializer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends Activity {

    private RecyclerView myrecyclerview;
    private AdaptadorUsers myadapter;
    private TextView editTextSearch;
    List<Users> postList;
    private ProgressDialog progress ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myrecyclerview = (RecyclerView) findViewById(R.id.recyclerViewSearchResults);
        myrecyclerview.setHasFixedSize(true);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        editTextSearch = (TextView) findViewById(R.id.editTextSearch);

        progress= new ProgressDialog(this);

        postList =DatabaseInitializer.getdata(AppDatabase.getAppDatabase(MainActivity.this));
        if (postList.isEmpty())
            getdata();
        else{
            myadapter = new AdaptadorUsers(this, postList);
            myrecyclerview.setAdapter(myadapter);
        }

        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = editTextSearch.getText().toString().toLowerCase(Locale.getDefault());
                myadapter.filter(text);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    private void getdata(){

        progress.setCanceledOnTouchOutside(false);
        progress.setMessage("Cargando...");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.isIndeterminate();
        progress.setCancelable(false);
        progress.show();

        Iservices iservices = Restapidata.getClientService();
        Call<List<Users>> call = iservices.getComics();
        call.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                postList = response.body();
                DatabaseInitializer.populateAsync(AppDatabase.getAppDatabase(MainActivity.this),postList);
                myadapter = new AdaptadorUsers(MainActivity.this, postList);
                myrecyclerview.setAdapter(myadapter);
                progress.dismiss();
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                System.out.println("");
            }
        });
    }

}
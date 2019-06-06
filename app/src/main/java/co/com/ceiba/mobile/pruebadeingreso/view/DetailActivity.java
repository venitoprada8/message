package co.com.ceiba.mobile.pruebadeingreso.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.models.Users;

public class DetailActivity extends AppCompatActivity {
    public TextView nombre, telefonon, email;
    public ImageView foto;
    public Button btn_view_post;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list_item);
        nombre = (TextView) findViewById(R.id.name);
        telefonon =(TextView) findViewById(R.id.phone);
        email =(TextView) findViewById(R.id.email);
        btn_view_post =(Button)findViewById(R.id.btn_view_post);
        Bundle bundle = getIntent().getExtras();
        Users us= (Users) bundle.getSerializable("Users");
        nombre.setText(us.getName());
        telefonon.setText(us.getPhone());
        email.setText(us.getEmail());
        btn_view_post.setText("Regresar");
        btn_view_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

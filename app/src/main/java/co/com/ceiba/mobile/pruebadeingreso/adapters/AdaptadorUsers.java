package co.com.ceiba.mobile.pruebadeingreso.adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.models.Users;

public class AdaptadorUsers extends RecyclerView.Adapter<AdaptadorUsers.ViewHolder>  implements  Filterable{

    private Context context;
    private List<Users> apiObjectList;
    private ArrayList<Users> arraylist;
    private Filter searchFilter;


    public AdaptadorUsers(Context context, List<Users> apiObjectList) {
        this.context = context;
        this.apiObjectList = apiObjectList;
        this.arraylist=new ArrayList<Users>();
        this.arraylist.addAll(apiObjectList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Users apiObject = apiObjectList.get(position);
        holder.email.setText(apiObject.getEmail());
        holder.nombre.setText(apiObject.getName());
        holder.telefonon.setText(apiObject.getPhone());

    }

    @Override
    public int getItemCount() {
        return apiObjectList.size();
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        apiObjectList.clear();
        if (charText.length() == 0) {
            apiObjectList.addAll(arraylist);
        } else {
            for (Users wp : arraylist) {
                if (wp.getName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    apiObjectList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombre, telefonon, email;
        public ImageView foto;


        public ViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.name);
            telefonon =(TextView) itemView.findViewById(R.id.phone);
            email =(TextView) itemView.findViewById(R.id.email);

        }


    }
}



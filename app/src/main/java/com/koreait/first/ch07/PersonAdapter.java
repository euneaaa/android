package com.koreait.first.ch07;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.koreait.first.R;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.MyViewHolder> {

    List<Person> items = new ArrayList<>();

    public void addItem(Person item){
        items.add(item);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.person_item, parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //Person item = items.get(position);
        //holder.setItem(item);

        holder.setItem(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvAge;

        public MyViewHolder(@NonNull View v) {
            super(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //클로져(closure)

                    String name = tvName.getText().toString();
                    String age = tvAge.getText().toString();

                    Snackbar.make(v,name+", "+ age,Snackbar.LENGTH_LONG).show();
                }
            });

            tvName = v.findViewById(R.id.tvName);
            tvAge = v.findViewById(R.id.tvAge);
        }

        public void setItem(Person item){
            tvName.setText(item.getName());
            tvAge.setText(item.getAge()+"살");
            //정수값은 R에서 관리하고 있는 정수값만 들어갈 수 있다. tvAge.setText(aa) -> int aa=R.string.opp.name (O)  ,int aa=10 (X)
        }
    }
}

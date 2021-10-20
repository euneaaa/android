package com.koreait.first.ch07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.koreait.first.R;
import com.koreait.first.Utils;

public class BookPersonActivity extends AppCompatActivity {

    private RecyclerView rvList;
    private PersonAdapter adapter;
    private EditText etName;
    private EditText etAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_person);

        rvList = findViewById(R.id.rvList);
        adapter = new PersonAdapter();
        etName =findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);


        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(adapter);

        adapter.addItem(new Person("홍길동",20));
        adapter.addItem(new Person("난다김",23));
        adapter.addItem(new Person("블랙보리",24));
        adapter.notifyDataSetChanged();
    }

    public void clkBtn(View v){
        String name = etName.getText().toString();
        String age = etAge.getText().toString();
        //int intAge = Integer.parseInt(age); //문자열>정수형 변환
        int intAge = Utils.parseStringToInt(age);
        if (intAge == 0){
            Toast.makeText(this, "문제가 발생하였습니다.", Toast.LENGTH_LONG).show();
        }else {
            Person p = new Person(name, intAge);
            adapter.addItem(p);
            adapter.notifyDataSetChanged();
            etName.setText("");
            etAge.setText("");
        }
    }
}

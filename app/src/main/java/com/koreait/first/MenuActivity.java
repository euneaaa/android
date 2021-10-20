package com.koreait.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.koreait.first.ch07.BookPersonActivity;
import com.koreait.first.ch10.DailyBoxofficeActivity;
import com.koreait.first.picsum.PicsumActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void call(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"));
        startActivity(intent);
    }

    public void moveToActivity(View v){
        int id = v.getId();

        Class c = null;
        //분기
        switch (id) {
            case R.id.menubtn1:
                c = MainActivity.class; break;
            case R.id.menubtn2:
                c= LinearActivity.class; break;
            case R.id.menubtn3:
                c= ConstraintActivity.class; break;
            case R.id.menubtn4:
                c= WriteActivity.class; break;
            case R.id.menubtn5:
                c= BookPersonActivity.class; break;
            case R.id.menubtn6:
                c= ImageViewActivity.class; break;
            case R.id.menubtn7:
                c= PicsumActivity.class; break;
            case R.id.menubtn8:
                c= DailyBoxofficeActivity.class; break;
        }
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }


    public void moveToActivityWithText(View v){
        TextView tv = (TextView)v;
        String text = (String)tv.getText();
        Log.i("myLog", text);

        Class c = null;

        switch (text) {
            case "메인":
                c = MainActivity.class;
                break;
            case "리니어레이아웃":
                c = LinearActivity.class;
                break;
            case "제약레이아웃":
                c = ConstraintActivity.class;
                break;
        }
            Intent intent = new Intent(this, c);
            startActivity(intent);
    }

    /*
    public void moveToMain(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void moveToLinear(View v){
        Intent intent = new Intent(this, LinearActivity.class);
        startActivity(intent);
    }

    public void moveToConstraint(View v){
        Intent intent = new Intent(this, ConstraintActivity.class);
        startActivity(intent);
    }
    */
}
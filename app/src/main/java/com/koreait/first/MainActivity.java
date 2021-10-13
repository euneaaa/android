package com.koreait.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //이벤트 연결 (event binding) 버튼 클릭시 실행될 메소드 연결
    public void clkBtn(View v){
        Button btn = (Button)v;
        String btnText = (String)btn.getText();
        Toast.makeText(this, "버튼을 눌렀습니다", Toast.LENGTH_LONG).show();
    }

    public void ddd(View v){
        TextView tv= (TextView)v;
        String str = (String)tv.getText();
        Toast.makeText(this, str,Toast.LENGTH_LONG).show();
        //Toast toast =Toast.makeText(this, str,Toast.LENGTH_LONG);
        //toast.show();

    /*
    TextView tv= (TextView)v;
    Toast.makeText(this, tv.getText(), Toast.LENGTH_LONG).show();
     */
    }

}
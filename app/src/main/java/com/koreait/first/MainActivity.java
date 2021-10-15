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
        //누를 때 마다 1씩 증가시키기.
        //v에 담겨있는 객체주소값을 TextView타입으로 저장할 수 있으면 true 없으면 false
        if(v instanceof TextView){
            TextView tv = (TextView)v;
            String val = (String)tv.getText();
            int intVal = Integer.parseInt(val);
            intVal +=1;
            String parseStrVal = String.valueOf(intVal);
            tv.setText(parseStrVal);
        }
    }

    /*
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

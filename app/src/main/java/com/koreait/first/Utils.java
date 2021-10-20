package com.koreait.first;

import android.widget.Toast;

public class Utils {
    public static int parseStringToInt(String val){
        //예외처리
        int intVal = 0;

        try {
            intVal = Integer.parseInt(val);
        }catch (Exception e){
            //예외가 발생되었을 때 실행되고 싶은 것들을 여기에다 작성
            e.printStackTrace(); //에러 내용을 로그에 찍는다.
        } finally {
            //에러가 터지던 안터지던 <<<무조건>>> 실행됐으면 하는 것들을 작성
        }
        return intVal;
    }
}

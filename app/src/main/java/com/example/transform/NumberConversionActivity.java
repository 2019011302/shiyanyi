package com.example.transform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.computer.R;

import java.time.temporal.TemporalAdjuster;

public class NumberConversionActivity extends AppCompatActivity implements View.OnClickListener{
    String number="";
    String result="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_conversion);
        Button one = (Button) findViewById(R.id.one);
        Button two = (Button) findViewById(R.id.two);
        Button three = (Button) findViewById(R.id.three);
        Button four = (Button) findViewById(R.id.four);
        Button five = (Button) findViewById(R.id.five);
        Button six = (Button) findViewById(R.id.six);
        Button seven = (Button) findViewById(R.id.seven);
        Button eight = (Button) findViewById(R.id.eight);
        Button nine = (Button) findViewById(R.id.nine);
        Button zero = (Button) findViewById(R.id.zero);
        Button c = (Button) findViewById(R.id.c);
        Button ac = (Button) findViewById(R.id.ac);
        Button equ = (Button)findViewById(R.id.equ);

        //字母
        Button btn_a = (Button)findViewById(R.id.btn_a);
        Button btn_b = (Button)findViewById(R.id.btn_b);
        Button btn_c = (Button)findViewById(R.id.btn_c);
        Button btn_d = (Button)findViewById(R.id.btn_d);
        Button btn_e = (Button)findViewById(R.id.btn_e);
        Button btn_f = (Button)findViewById(R.id.btn_f);
        //监听
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        c.setOnClickListener(this);
        ac.setOnClickListener(this);

        btn_a.setOnClickListener(this);
        btn_b.setOnClickListener(this);
        btn_c.setOnClickListener(this);
        btn_d.setOnClickListener(this);
        btn_e.setOnClickListener(this);
        btn_f.setOnClickListener(this);

        //
        Spinner spMenu = (Spinner)findViewById(R.id.List);
       // spMenu.setOnItemSelectedListener(this);
        Spinner spL = (Spinner)findViewById(R.id.LList);
        Spinner spR = (Spinner)findViewById(R.id.RList);

        equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String unitL = spL.getSelectedItem().toString();
                String unitR = spR.getSelectedItem().toString();
                TextView text = (TextView)findViewById(R.id.result) ;
                if(spMenu.getSelectedItem().toString().equals("进制换算"))
                    result = Transform.transformNumber(unitL,unitR,number);
                else
                    result = Transform.transformLenght(unitL,unitR,number);
                text.setText(result);
                result="";
            }
        });
        spMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String content = adapterView.getItemAtPosition(i).toString();
                String[] arrL = { "千米" , "米" , "分米", "厘米", "毫米", "微米", "纳米"};
                String[] arrS = { "平方千米" , "公顷" ,"公亩" , "平方分米", "平方厘米", "平方毫米"};
                String[] arrV = { "立方千米" , "立方米" , "立方分米", "立方厘米", "立方毫米", "升" ,"分升","厘升","毫升"};
                String[] arrW = { "吨" , "千克" , "克", "毫克", "微克"};
                String[] arrN = { "二进制" , "八进制" , "十进制", "十六进制"};
                switch (content){//根据内容配置左右spinnner
                    case "长度单位":
                        setUnableClick();
                        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this , R.id.layout.);
                        ArrayAdapter<String> adapterL=new ArrayAdapter<String>(NumberConversionActivity.this,android.R.layout.simple_spinner_dropdown_item ,arrL);
                        spL.setAdapter(adapterL);
                        spR.setAdapter(adapterL);
                        break;
                    case "面积单位":
                        setUnableClick();
                        ArrayAdapter<String> adapterS=new ArrayAdapter<String>(NumberConversionActivity.this,android.R.layout.simple_spinner_dropdown_item,arrS);
                        spL.setAdapter(adapterS);
                        spR.setAdapter(adapterS);
                        break;
                    case "体积单位":
                        setUnableClick();
                        ArrayAdapter<String> adapterV=new ArrayAdapter<String>(NumberConversionActivity.this,android.R.layout.simple_spinner_dropdown_item,arrV);
                        spL.setAdapter(adapterV);
                        spR.setAdapter(adapterV);
                        break;
                    case "重量单位":
                        setUnableClick();
                        ArrayAdapter<String> adapterW=new ArrayAdapter<String>(NumberConversionActivity.this,android.R.layout.simple_spinner_dropdown_item,arrW);
                        spL.setAdapter(adapterW);
                        spR.setAdapter(adapterW);
                        break;
                    case "进制换算":
                        setableClick();
                        ArrayAdapter<String> adapterN=new ArrayAdapter<String>(NumberConversionActivity.this,android.R.layout.simple_spinner_dropdown_item,arrN);
                        spL.setAdapter(adapterN);
                        spR.setAdapter(adapterN);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


   }

    //设置字母控件不可点击
    public void setUnableClick(){
        //字母
        Button btn_a = (Button)findViewById(R.id.btn_a);
        Button btn_b = (Button)findViewById(R.id.btn_b);
        Button btn_c = (Button)findViewById(R.id.btn_c);
        Button btn_d = (Button)findViewById(R.id.btn_d);
        Button btn_e = (Button)findViewById(R.id.btn_e);
        Button btn_f = (Button)findViewById(R.id.btn_f);
        btn_a.setClickable(false);
        btn_b.setClickable(false);
        btn_c.setClickable(false);
        btn_d.setClickable(false);
        btn_e.setClickable(false);
        btn_f.setClickable(false);
    }

    //设置字母控件可以点击
    public void setableClick(){
        //字母
        Button btn_a = (Button)findViewById(R.id.btn_a);
        Button btn_b = (Button)findViewById(R.id.btn_b);
        Button btn_c = (Button)findViewById(R.id.btn_c);
        Button btn_d = (Button)findViewById(R.id.btn_d);
        Button btn_e = (Button)findViewById(R.id.btn_e);
        Button btn_f = (Button)findViewById(R.id.btn_f);
        btn_a.setClickable(true);
        btn_b.setClickable(true);
        btn_c.setClickable(true);
        btn_d.setClickable(true);
        btn_e.setClickable(true);
        btn_f.setClickable(true);
    }

    @Override
    public void onClick(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);

        switch (view.getId()){
            case R.id.c:
                if(number.length()!=0)
                    number = number.substring(0,number.length()-1) ;
                break;
            case R.id.ac:
                number="";break;
            default:
                number+= ((Button)findViewById(view.getId())).getText().toString();
        }
        editText.setText(number);
    }

}
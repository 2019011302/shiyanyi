package com.example.computer;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class LandscapeActivity extends AppCompatActivity implements View.OnClickListener {
    String formula = "";
    String res="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landscape);
        //横屏时去除标题栏
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        EditText editText_1 = (EditText) findViewById(R.id.editText_1);
        //获取MainActivity传来的字符串
        Intent intent = getIntent();
        formula = intent.getStringExtra("formula");//获取MainActivity内容并显示在屏幕上
        editText_1.setText(formula);
        editText_1.setSelection(formula.length());
        //button
        //number
        Button btn_1 = (Button) findViewById(R.id.btn_1);
        Button btn_2 = (Button) findViewById(R.id.btn_2);
        Button btn_3 = (Button) findViewById(R.id.btn_3);
        Button btn_4 = (Button) findViewById(R.id.btn_4);
        Button btn_5 = (Button) findViewById(R.id.btn_5);
        Button btn_6 = (Button) findViewById(R.id.btn_6);
        Button btn_7 = (Button) findViewById(R.id.btn_7);
        Button btn_8 = (Button) findViewById(R.id.btn_8);
        Button btn_9 = (Button) findViewById(R.id.btn_9);
        Button btn_0 = (Button) findViewById(R.id.btn_0);
        Button btn_add = (Button) findViewById(R.id.btn_add);
        Button btn_sub = (Button) findViewById(R.id.btn_sub);
        Button btn_mul = (Button) findViewById(R.id.btn_mul);
        Button btn_div = (Button) findViewById(R.id.btn_div);
        Button btn_dot = (Button) findViewById(R.id.btn_dot);
        Button btn_per = (Button) findViewById(R.id.btn_per);
        Button btn_ac = (Button) findViewById(R.id.btn_ac);
        Button btn_c = (Button) findViewById(R.id.btn_c);
        Button btn_equ = (Button) findViewById(R.id.btn_equ);

        //operator
        Button btn_pai = (Button) findViewById(R.id.btn_pai);
        Button btn_l = (Button) findViewById(R.id.btn_l);
        Button btn_r = (Button) findViewById(R.id.btn_r);
        Button btn_ln = (Button) findViewById(R.id.btn_ln);
        Button btn_reciprocal = (Button) findViewById(R.id.btn_reciprocal);
        Button btn_sqr = (Button) findViewById(R.id.btn_sqr);
        Button btn_cube = (Button) findViewById(R.id.btn_cube);
        Button btn_x_power_of_y = (Button) findViewById(R.id.btn_x_power_of_y);
        Button btn_factorial = (Button) findViewById(R.id.btn_factorial);
        Button btn_square_root = (Button) findViewById(R.id.btn_square_root);
        Button btn_x_root = (Button) findViewById(R.id.btn_x_root);
        Button btn_lg = (Button) findViewById(R.id.btn_lg);
        Button btn_sin = (Button) findViewById(R.id.btn_sin);
        Button btn_cos = (Button) findViewById(R.id.btn_cos);
        Button btn_tan = (Button) findViewById(R.id.btn_tan);
        Button btn_log2 = (Button) findViewById(R.id.btn_log2);
        Button btn_arcsinx = (Button) findViewById(R.id.btn_arcsinx);
        Button btn_arcscos = (Button) findViewById(R.id.btn_arccos);
        Button btn_arctan = (Button) findViewById(R.id.btn_arctan);
        Button btn_exponent = (Button) findViewById(R.id.btn_exponent);
        Button btn_back = (Button) findViewById(R.id.btn_back);

        //监听
        btn_1.setOnClickListener(LandscapeActivity.this);
        btn_2.setOnClickListener(LandscapeActivity.this);
        btn_3.setOnClickListener(LandscapeActivity.this);
        btn_4.setOnClickListener(LandscapeActivity.this);
        btn_5.setOnClickListener(LandscapeActivity.this);
        btn_6.setOnClickListener(LandscapeActivity.this);
        btn_7.setOnClickListener(LandscapeActivity.this);
        btn_8.setOnClickListener(LandscapeActivity.this);
        btn_9.setOnClickListener(LandscapeActivity.this);
        btn_0.setOnClickListener(LandscapeActivity.this);
        btn_ac.setOnClickListener(LandscapeActivity.this);
        btn_c.setOnClickListener(LandscapeActivity.this);
        btn_add.setOnClickListener(LandscapeActivity.this);
        btn_sub.setOnClickListener(LandscapeActivity.this);
        btn_mul.setOnClickListener(LandscapeActivity.this);
        btn_div.setOnClickListener(LandscapeActivity.this);
        btn_dot.setOnClickListener(LandscapeActivity.this);
        btn_per.setOnClickListener(LandscapeActivity.this);
        btn_equ.setOnClickListener(LandscapeActivity.this);
        btn_pai.setOnClickListener(LandscapeActivity.this);
        btn_l.setOnClickListener(LandscapeActivity.this);
        btn_r.setOnClickListener(LandscapeActivity.this);
        btn_ln.setOnClickListener(LandscapeActivity.this);
        btn_reciprocal.setOnClickListener(LandscapeActivity.this);
        btn_sqr.setOnClickListener(LandscapeActivity.this);
        btn_cube.setOnClickListener(LandscapeActivity.this);
        btn_x_power_of_y.setOnClickListener(LandscapeActivity.this);
        btn_factorial.setOnClickListener(LandscapeActivity.this);
        btn_square_root.setOnClickListener(LandscapeActivity.this);
        btn_x_root.setOnClickListener(LandscapeActivity.this);
        btn_lg.setOnClickListener(LandscapeActivity.this);
        btn_sin.setOnClickListener(LandscapeActivity.this);
        btn_cos.setOnClickListener(LandscapeActivity.this);
        btn_tan.setOnClickListener(LandscapeActivity.this);
        btn_log2.setOnClickListener(LandscapeActivity.this);
        btn_arcsinx.setOnClickListener(LandscapeActivity.this);
        btn_arcscos.setOnClickListener(LandscapeActivity.this);
        btn_arctan.setOnClickListener(LandscapeActivity.this);
        btn_exponent.setOnClickListener(LandscapeActivity.this);
        btn_back.setOnClickListener(LandscapeActivity.this);
    }

    @Override
    public void onClick(View view) {
        EditText editText_1 = (EditText)findViewById(R.id.editText_1);
        EditText editText_2 = (EditText)findViewById(R.id.editText_2);
        Button btn = (Button) findViewById(view.getId());
        switch (view.getId()){
            case R.id.btn_ac://清空
                formula ="";
                break;
            case R.id.btn_c://清最后一个字符
                formula = Check.check_clear(formula);
                break;
            case R.id.btn_back://返回竖屏
                Intent intent = getIntent();
                intent.putExtra("formula_2" , formula);
                setResult(0 , intent);
                finish();
                break;
            case R.id.btn_dot://处理小数点，防止多次点击 以及不能紧跟在加减乘除等符号的后面
                formula = Check.check_dot(formula);
                break ;
            case R.id.btn_add:
            case R.id.btn_sub:
            case R.id.btn_mul:
            case R.id.btn_div:
            case R.id.btn_per:
                formula = Check.check_operater(formula , btn.getText().toString());
                break;
            case R.id.btn_reciprocal:
                formula +="1/";
                break;
            case R.id.btn_sqr: // ^2
            case R.id.btn_cube: //^3
            case R.id.btn_x_power_of_y: //^
                formula = Check.check_power(formula , btn.getText().toString());
                break;

            case R.id.btn_factorial:
                formula +="!";
                break;
            case R.id.btn_x_root:
                formula +="√";
                break;
            case R.id.btn_square_root:
                formula +="2√";
                break;
            case R.id.btn_exponent:
                formula +="2^";
                break;
            case R.id.btn_log2:
                formula +="log";
                break;
            case R.id.btn_l://(
                formula = Check.checkLeftBrackets(formula);
                break;
            case R.id.btn_r://)
                formula = Check.checkRightBrackets(formula);
                break;
            case R.id.btn_equ:
                //等号 计算
                formula = Check.check_brackets(formula);
                formula = Check.check_equ(formula);
                res = String.valueOf(Computer.data_hending( formula));
                break ;
            default:
                formula = Check.check_number(formula , btn.getText().toString());//处理数字--不能紧跟在右括号后
                break;
        }
        editText_1.setText(formula);
        editText_1.setSelection(editText_1.getText().length());
        editText_2.setText(res);
        res="";
    }
}
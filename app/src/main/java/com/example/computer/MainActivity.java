
package com.example.computer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.transform.NumberConversionActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String formula="";//式子
    String res = "";//运行结果


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        btn_1.setOnClickListener(MainActivity.this);
        btn_2.setOnClickListener(MainActivity.this);
        btn_3.setOnClickListener(MainActivity.this);
        btn_4.setOnClickListener(MainActivity.this);
        btn_5.setOnClickListener(MainActivity.this);
        btn_6.setOnClickListener(MainActivity.this);
        btn_7.setOnClickListener(MainActivity.this);
        btn_8.setOnClickListener(MainActivity.this);
        btn_9.setOnClickListener(MainActivity.this);
        btn_0.setOnClickListener(MainActivity.this);
        btn_ac.setOnClickListener(MainActivity.this);
        btn_c.setOnClickListener(MainActivity.this);
        btn_add.setOnClickListener(MainActivity.this);
        btn_sub.setOnClickListener(MainActivity.this);
        btn_mul.setOnClickListener(MainActivity.this);
        btn_div.setOnClickListener(MainActivity.this);
        btn_dot.setOnClickListener(MainActivity.this);
        btn_per.setOnClickListener(MainActivity.this);
        btn_equ.setOnClickListener(MainActivity.this);

        Button btn_other = (Button) findViewById(R.id.btn_tran);
        btn_other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , LandscapeActivity.class);
                intent.putExtra("formula" , formula);
                //startActivity(intent);
                startActivityForResult(intent , 0);
            }
        });
    }

    @Override
    public void onClick(View view) {
        EditText editText_1 = (EditText)findViewById(R.id.editText_1);
        EditText editText_2 = (EditText)findViewById(R.id.editText_2);
        Button btn_op = (Button) findViewById(view.getId());
        switch (view.getId()){
            case R.id.btn_ac://清空
                formula ="";
                break;
            case R.id.btn_c://清最后一个字符
                formula = Check.check_clear(formula);
                break;
            case R.id.btn_dot://处理小数点，防止多次点击 以及不能紧跟在加减乘除等符号的后面
                formula = Check.check_dot(formula);
                break ;

            case R.id.btn_add:
            case R.id.btn_sub:
            case R.id.btn_mul:
            case R.id.btn_div:
            case R.id.btn_per:
                formula = Check.check_operater(formula , btn_op.getText().toString());
                break;
            case R.id.btn_equ:
                //等号 计算
                formula = Check.check_brackets(formula);
                formula = Check.check_equ(formula);
                res = String.valueOf(Computer.data_hending( formula));
                break ;
            default:
                formula = Check.check_number(formula , btn_op.getText().toString());//处理数字--不能紧跟在右括号后
                break;
        }
        editText_1.setText(formula);
        editText_1.setSelection(editText_1.getText().length());
        editText_2.setText(res);
        res="";
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( requestCode == 0){
            formula = data.getStringExtra("formula_2");
            EditText editText_1 = (EditText)findViewById(R.id.editText_1);
            editText_1.setText(formula);
            editText_1.setSelection(formula.length());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            case R.id.computer: break;
            case R.id.numberConversion:
                Intent Nintent = new Intent(MainActivity.this , NumberConversionActivity.class);
                startActivity(Nintent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
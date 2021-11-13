package com.example.computer;

import java.util.Stack;

public class Computer {

    static int lp(char op) {//出栈
        switch (op){
            case '+' : return 3;
            case '-' : return 3;
            case '*' : return 5;
            case '/' : return 5;
            case '(' : return 1;
            case ')' : return 8;
            case '=' : return 0;
            case '^':
            case '√':
            case '!':
            case 'e':
            case 'g':
            case 'l':
            case 's':
            case 'c':
            case 't':
            case 'x':
            case 'y':
            case 'z':
                return 7;

        }
        return 0;
    }
    //运算优先级 右 入栈
    static int rp(char op) {
        switch (op){
            case '+' : return 2;
            case '-' : return 2;
            case '*' : return 4;
            case '/' : return 4;
            case '(' : return 8;
            case ')' : return 1;
            case '=' : return 0;

            case '^':
            case '!':
            case '√':
            case 'e':
            case 'g':
            case 'l':
            case 's':
            case 'c':
            case 't':
            case 'x':
            case 'y':
            case 'z':
                return 6;
        }
        return 0;
    }

    public static double myComputer(double num_1, double num_2, char op){
        double res=0;
        switch (op){
            case '+': return num_1 + num_2;
            case '-': return num_1 - num_2;
            case '*': return num_1 * num_2;
            case '/':
                if(num_2 == 0){
                    System.out.println("输入有误");
                    num_2 = 1;
                }
                return num_1 / num_2;
            case '^': return Math.pow(num_1 , num_2);
            case '√':
                int x = (int)num_1 ;
                int y = (int)num_2 ;
                if(y==0)
                    res = 0;
                else
                    res = Math.pow(y,1.0/x);
        }
        return res;
    }
    //计算前的式子处理(在Computer类内调用，因为此时修改式子formula不需要在屏幕显示） ， 将多字符转化成单字符：如 ln-> e
    public static String check_formula(String formula){
        formula = formula.replace("arcsin","x");
        formula = formula.replace("arccos","y");
        formula = formula.replace("arctan","z");

        formula = formula.replace("ln","e");
        formula = formula.replace("lg","g");
        formula = formula.replace("log","l");
        formula = formula.replace("sin","s");
        formula = formula.replace("cos","c");
        formula = formula.replace("tan","t");
        return formula;
    }
    public static double computerUnaryOperator(double num , char op){
        double res = 1;
        switch (op){
            case 'e': res = Math.log(num) ;break;
            case 'g': res = Math.log10(num);break;
            case 'l': res = Math.log(num) / Math.log(2);break;
            case 's': res = Math.sin(Math.toRadians(num));break;
            case 'c': res = Math.cos(Math.toRadians(num));break;
            case 't': res = Math.tan(Math.toRadians(num));break;
            case 'x': res = Math.toDegrees(Math.asin(num));break;
            case 'y': res = Math.toDegrees(Math.acos(num));break;
            case 'z': res = Math.toDegrees(Math.atan(num));break;
            case '!': int number = (int)num;
                for(int i = 1 ; i<=number ; i++)
                    res *= i;
        }
        return res;
    }
    //将式子中的数字和操作符分别存入栈
    public static double data_hending(String formula){
        formula = check_formula(formula);//将式子处理成“标准”格式 单符号替换多符号
        Stack<Double> number = new Stack<Double>();
        Stack<Character> operate = new Stack<Character>();
        operate.push('=');
        String numString = "";
        //遍历字符串
        for(int i=0 ; i< formula.length();i++){
            char c = formula.charAt(i);
            if(( c <= '9' && c>= '0') || c == '.' ){
                numString += c;
            }
            else if( c=='π'){
                number.push(Math.PI);
                continue;
            }
            else{
                //数字压栈
                if(numString.length()!=0){
                    double numdouble = Double.parseDouble(numString);
                    number.push(numdouble);
                    numString = "";
                }
                char op = operate.peek();//操作符栈顶元素

                //若为 % 号 ， 将 % 号变成乘号号 ， 乘数是0.01 。不能变除号，因为会有数据混淆的问题，乘数与被乘数可以互换位置，而除数和被除数不可以。
                if( c=='%'){
                    c='*';
                    number.push(0.01);
                }

 //               while ((lp(op) > rp(c) && op != '(' ) || c==')'){//左>右 计算并压栈 计算已经入栈的元素
               while (lp(op) > rp(c) && op != '(' ){
                    //设置op != '(' 是为防止 3*(2+ 的情况 此时，若 op=( 而 c=+ ，左<右  ,需要计算
                    //设置 c =')'是考虑到 (3+2)*5 c取到） 时，需要计算
                    if(isUnary(op)){//如果是单目运算符，则只取一个数
                        double num = number.pop();
                        double result = computerUnaryOperator(num , op);
                        number.push(result);
                    }else{
                        double num_2 = number.pop();
                        double num_1 = number.pop();
                        double result = myComputer(num_1 , num_2 , op);
                        number.push(result);
                    }
                    operate.pop();//将计算过的符号抛弃
                    if(c ==')' && operate.peek()=='(')//计算完括号内的数据，要把左括号去除 如 3*(2+5)=
                        operate.pop();
                    op = operate.peek();
                    if(op == '=')break;//取到栈底
                }
                //左<右 直接压栈
                if(c!=')' && c!='=')//将下一个符号加入栈
                    operate.push(c);
            }
        }
        //处理栈内剩余元素
        char op = operate.pop();
        while (op != '='){
            if(op == '('){
                op = operate.pop();
                continue;
            }
            if(isUnary(op)){
                double num = number.pop();
                double result = computerUnaryOperator(num , op);
                number.push(result);
            }else{
                double num_2 = number.pop();
                double num_1 = number.pop();
                double result = myComputer(num_1 , num_2 , op);
                number.push(result);
            }
            op = operate.pop();
        }
        //res = String.valueOf(number.pop());
        return number.pop();
    }
    //判断是否单目运算符
    public static boolean isUnary(char op){
        boolean bool = false;
        if( op =='l' || op =='g' || op =='e' || op =='s' || op =='c' || op =='t' || op =='x' || op =='y' || op =='z' || op=='!')
            bool = true;
        return bool ;
    }
}

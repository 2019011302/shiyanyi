package com.example.computer;
public class Check {
    public static String check_dot(String formula){
        //处理小数点出现在开头的问题
        if(formula.length()==0 ){
            formula += "0.";
            return formula;
        }
        //处理多次点击小数点问题 以及限制小数点只能跟在数字后
        char formula_last_char = formula.charAt(formula.length()-1);
        //如果最后一个字符是数字，将遍历该 段 字符是否出现过小数点
        if(formula_last_char >='0' && formula_last_char <='9'){
            for(int i = formula.length()-1 ; i>=0 ;i--){//已经确定 formula.length()-1 是数字
                char c = formula.charAt(i);
                if(c=='.')
                    return formula;
                else if(c == '+' || c=='-' || c == '*' || c=='/' || c=='(' || c==')'){
                    formula += "." ;
                    return formula;
                }
            }
            formula += "." ;
        }
        //如果最后一个字符不是数字，如+、-符号等，不允许添加小数点
        return formula;
    }
    //处理多次点击加减乘除号百分号问题 以及限制+-*/^%不能出现在式子开头
    public static String check_operater(String formula, String op){
        //char p = op.charAt(0);//某个操作符
        String myOperate = "+-*/^.=%";//如：不能出现 1*(+=
        if(formula.length()!=0){
            //取式子最后一个字符
            String formula_last_char = formula.substring(formula.length()-1 ,formula.length());//可能是数字，也可能是操作符
            //处理多次点击操作符问题
            if(myOperate.contains(formula_last_char)){
                formula = formula.substring(0 ,formula.length()-1 );
                formula += op;
                return formula;
            }
            //处理加减乘除号不允许紧跟在左括号后面的问题 如：（+、(.这种形式，不允许出现
            if(formula.charAt(formula.length()-1) == '('){
                return formula;//保证左括号后不直接添加 加减乘除等操作符
            }
            return formula+op; //以上情况不出现，则允许添加加减乘除等操作符
        }
        return "";
    }

//    public static String check_per(String formula){
//        char formulaLast = formula.charAt(formula.length()-1);
//
//    }

    //处理等号：多次点击、出现在开头的问题
    public static String check_equ(String formula){
        if(formula.length() != 0){
            String formula_last_char = formula.substring(formula.length()-1 ,formula.length());
            if(!formula_last_char.equals("="))
                formula += "=";
            return formula;
        }
        return "";
    }
    // 处理添加 ^ 的问题 ^2 ^3 ^ ，1+2^ 不能直接再添加
    public static String check_power(String formula , String op){
        //判断最后一个字符是否是^ 或等号; 若是,则删除后添加新内容
        if(formula.length() !=0 ){
            //将 x^y中的 x与y去除
            op = op.replace("x" ,"");
            op = op.replace("y" ,"");
            char formulaLastChar = formula.charAt(formula.length()-1);
            if(formulaLastChar == '^' || formulaLastChar == '='){
                formula = formula.substring(0,formula.length()-1);
            }
            return formula + op;
        }
        return "" ;
    }
    //点击等号后对式子校验，主要是对括号完整性验证，使式子完整。如：(1+2= 需要补充括号，修改为(1+2)=
    //传入的式子formula不带等号 //这个方法可以不用实现,括号是否完整不会导致程序崩溃,而且能正常计算出结果
    public static String check_brackets(String formula){
        int num = 0; //从左到右遍历formula , 遇到左括号 num加1 ， 遇到右括号 num减1
        for(int i = 0 ; i< formula.length() ; i++){
            char c = formula.charAt(i);
            if(c=='(')
                num +=1;
            else if( c == ')')
                num -=1;
        }
        //根据 num 的正负、数值 确定应该添加什么括号（左 或 右）
        if(num > 0){//左括号多了num个 ， 在式子后、等号前，补num个右括号
            for(int i =0 ;i< num ; i++){
                formula +=")";
            }
        }else if(num < 0){//右括号多了num个 ， 在式子开头，补num个左括号
            num = Math.abs(num);
            String prifixFormula = "";
            for(int i =0 ;i< num ; i++){
                prifixFormula +="(";
            }
            formula = prifixFormula + formula ;
        }
        return formula;
    }


    //处理输入数字问题 右括号/百分号以及等号 后不能紧跟数字 )3 %3
    public static String check_number(String formula , String number){
        if(formula.length()!=0){
            char formulaLast = formula.charAt(formula.length()-1);
            if(formulaLast == ')' || formulaLast == '%' || formulaLast == '='){
                return formula;
            }
            return formula+number;
        }
        return number ;//数字可以直接出现在开头
    }
    // 处理左括号问题 左括号只能跟在+-*/(的后面 ; 若括号前是数字 则在数字与括号间添加*号
    public static String checkLeftBrackets(String formula){
        if(formula.length()!=0){
            String operator = "+-*/(";
            String number = "0123456789";
            String formulaLast = formula.substring(formula.length()-1 , formula.length());
            if(operator.contains(formulaLast)){
                return formula+"(";
            }
            if(number.contains(formulaLast)){
                return formula+"*(";
            }
            return formula;
        }
        return "(";//左括号可以出现在开头
    }
    // 处理右括号问题 右括号只能跟在数字 或 π 或 )的后面 且右括号不能出现在开头
    public static String checkRightBrackets(String formula){
        if(formula.length()!=0){
            char formulaLast = formula.charAt(formula.length()-1);
            if((formulaLast >= '0' && formulaLast <= '9') || formulaLast == ')' || formulaLast == 'π'){
                return formula+")";
            }
            return formula;
        }
        return "";//右括号不能出现在开头
    }
    //处理函数清除问题
    public static String check_clear(String formula){

        if(formula.length()!=0){
            char formulaLastChar = formula.charAt(formula.length()-1);
            if(formulaLastChar <'a' || formulaLastChar > 'z') //1+2+3+ 删一个
                return formula.substring(0,formula.length()-1);
            if(formula.length()>=2){//删两个 此时删一个的可能已经排除
                char formulaSecondLastChar = formula.charAt(formula.length()-2);//lg ln
                if(formulaSecondLastChar =='l' )
                    return formula.substring(0,formula.length()-2);
            }
            if(formula.length()>=3){//删三个 此时删一个、两个的可能已经排除
                char formulaThreeLastChar = formula.charAt(formula.length()-3);
                if(formulaThreeLastChar > 'a' && formulaThreeLastChar < 'z' ) {// sin cos log 或 arcsin
                    //可能是反三角函数 再判断第六位 arcsin 、arccos、arctan
                    if(formula.length()>=6){
                        char formulaSixLastChar = formula.charAt(formula.length()-6);
                        if(formulaSixLastChar == 'a')
                            return formula.substring(0,formula.length()-6);
                    }
                }
                return formula.substring(0,formula.length()-3);
            }
        }
        return "";
    }
}

package com.example.transform;
//进制、单位转化类
public class Transform {
    //设置长度单位映射关系
    static int mapping(String unit){
        switch (unit){
            //长度单位
            case "千米": return 10;
            case "米": return 7;
            case "分米": return 6;
            case "厘米": return 5;
            case "毫米": return 4;
            case "微米": return 3;
            case "纳米": return 0;

            //面积单位
            case "平方千米": return 12;
            case "公顷" : return 10;
            case "公亩":return 8;
            case "平方米": return 6;
            case "平方分米": return 4;
            case "平方厘米": return 2;
            case "平方毫米": return 0;

            //体积单位
            case "立方千米": return 15;
            case "立方米": return 6;
            case "立方分米": return 3;
            case "立方厘米": return 0;
            case "立方毫米": return -3;
            case "升": return 3;
            case "分升": return 2;
            case "厘升": return 1;
            case "毫升": return 0;

            //重量单位
            case "吨": return 12;
            case "千克": return 9;
            case "克": return 6;
            case "毫克": return 3;
            case "微克": return 0;

            //进制换算
            case "二进制":return 2;
            case "八进制":return 8;
            case "十进制":return 10;
            case "十六进制":return 16;
        }
        return 0;
    }
    public static String transformLenght(String unitL , String unitR , String num){
        double number = Double.parseDouble(num);
        int pow = mapping(unitL)-mapping(unitR);
        double result = Math.pow(10 , pow) * number;
        return String.valueOf(result);
    }
    public static String transformNumber(String unitL , String unitR , String num){
        String result="";
        int k = mapping(unitL);
        //先转十进制
        int numof10 = Integer.valueOf(num , k);
        //十进制转为目标进制
        switch (unitR){
            case "二进制":
                result = Integer.toBinaryString(numof10);break;
            case "八进制":
                result = Integer.toOctalString(numof10);break;
            case "十六进制":
                result = Integer.toHexString(numof10);break;
            default:
                result = String.valueOf(numof10);
        }
        return result;
    }
}

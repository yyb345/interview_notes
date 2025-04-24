package org.algorithm.category.math;

public class Hex16 {

    public String toHexspeak(String num) {
        StringBuffer sb = new StringBuffer();

        Long number = Long .parseLong(num);
        while(number>0){

            Long div = number%16;

            if(div==0){
                sb.append("O");
            }else if(div==1){
                sb.append("I");
            }else if(div<10){
                return "ERROR";
            }else {
                sb.append(String.valueOf(('A'+div-10)));
            }
            number = number /16;
        }
        return sb.toString();
    }



    public static void main(String[] args) {
        String s = new Hex16().toHexspeak("3");
        System.out.println(s);
    }
}

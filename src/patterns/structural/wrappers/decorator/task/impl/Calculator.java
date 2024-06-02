package patterns.structural.wrappers.decorator.task.impl;

import patterns.structural.wrappers.decorator.task.Calculable;
import sun.security.x509.IPAddressName;

/**
 * Object of calculator closed for any changes(final);
 */
public final class Calculator implements Calculable {
    private String result;
    private String[] arrayA;
    private String[] arrayB;
    private String a1;
    private String b1;
    private String c1;
    private String d1;


    public Calculator() {
        this.result = "";
    }

    public String[] validNumber(String number){
       if(number.charAt(0) == '-'){
           number = "0 "+number;
       }
       number = number.replace("i", "");
       String [] res = number.split("\\s");
       return res.length == 4 ? new String[] {res[1] , res[2] + res[3]} : new String[] {res[0],res[1]+res[2]};
    }

    @Override
    public void sum(String a, String b) {
        arrayA = validNumber(a);
        arrayB = validNumber(b);
        a1 = arrayA[0];
        b1 = arrayA[1];
        c1 = arrayB[0];
        d1 = arrayB[1];

        if(parseInt(b1) + parseInt(d1) == 0){
           String tempResult = (parseInt(a1) + parseInt(c1)) + "";
           result+= tempResult;
        }
        if(parseInt(a1) + parseInt(c1) == 0){
            String tempResult = (parseInt(b1) + parseInt(d1)) + "i";
            result += tempResult;
        }
        else {
           String tempResult = (parseInt(a1) + parseInt(c1)) +
                   " + " + (parseInt(b1) + parseInt(d1)) + "i";
            result+= tempResult;
        }

    }

    @Override
    public void multiply(String a, String b) {
        arrayA = validNumber(a);
        arrayB = validNumber(b);
        a1 = arrayA[0];
        b1 = arrayA[1];
        c1 = arrayB[0];
        d1 = arrayB[1];

        String deistvResult = (parseInt(a1) * parseInt(c1) -
                parseInt(b1) * parseInt(d1)) + "";
        String mnimResult = (parseInt(b1) * parseInt(c1) +
                parseInt(a1) * parseInt(d1)) + "";

        if(parseInt(deistvResult) == 0){
           result += mnimResult + "i";

        }
        if(parseInt(mnimResult) == 0) {
            result += deistvResult;

        }
        if(parseInt(deistvResult) != 0 && parseInt(mnimResult) != 0){
            if(mnimResult.charAt(0) == '-'){
                result += deistvResult + " " + mnimResult + "i";
            }
            if(mnimResult.charAt(0) != '-'){
                result += deistvResult + " " + "+" + " " + mnimResult + "i";
                //этот момент в коде мне не нравится, но если делать через обычный элс, то почему-то резалт задваивается,
                //либо выполняется некорректно
            }
        }

    }

    @Override
    public void divide(String a, String b) {
        arrayA = validNumber(a);
        arrayB = validNumber(b);
        a1 = arrayA[0];
        b1 = arrayA[1];
        c1 = arrayB[0];
        d1 = arrayB[1];

        String deistvResult = (parseInt(a1) * parseInt(c1) +
                parseInt(b1) * parseInt(d1)) / (parseInt(c1) * parseInt(c1) + (parseInt(d1) * parseInt(d1))) + "";
        String mnimResult =  (parseInt(b1) * parseInt(c1) -
                parseInt(a1) * parseInt(d1)) / (parseInt(c1) * parseInt(c1) + (parseInt(d1) * parseInt(d1))) + "";
        if(parseInt(deistvResult) == 0){
            result += mnimResult + "i";
        }
        if(parseInt(mnimResult) == 0) {
            result += deistvResult;
        }
        if(parseInt(deistvResult) != 0 && parseInt(mnimResult) != 0){
            if(mnimResult.charAt(0) == '-'){
                result += deistvResult + " " + mnimResult + "i";
            }
            if(mnimResult.charAt(0) != '-'){
                result += deistvResult + " " + "+" + " " + mnimResult + "i";
                //этот момент в коде мне не нравится, но если делать через обычный элс, то почему-то резалт задваивается,
                //либо выполняется некорректно
            }
        }


    }

    @Override
    public void subtraction(String a, String b) {
        arrayA = validNumber(a);
        arrayB = validNumber(b);
        a1 = arrayA[0];
        b1 = arrayA[1];
        c1 = arrayB[0];
        d1 = arrayB[1];
        if (parseInt(b1) - parseInt(d1) == 0) {
            String tempResult = (parseInt(a1) - parseInt(c1)) + "";
            result += tempResult;
        }
        if(parseInt(a1) - parseInt(c1) == 0){
            String tempResult = parseInt(b1) - parseInt(d1) + "i";
            result += tempResult;
        }
            else {
            String tempResult = (parseInt(a1) - parseInt(c1)) +
                    " + " + (parseInt(b1) - parseInt(d1)) + "i";
            result += tempResult;
        }
    }

    @Override
    public String result() {
        System.out.printf("Result: %s%n", result);
        return result;
    }

    @Override
    public void clear() {
            this.result = null;
        }

    public int parseInt(String a){
        return Integer.parseInt(a);
    }

}

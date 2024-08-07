class Solution {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        if (num1.equals("1"))
            return num2;
        if (num2.equals("1"))
            return num1;

        int lenNum1 = num1.length();
        int lenNum2 = num2.length();
        StringBuilder ansSb = new StringBuilder("0");

        String temp;

        for (int i = lenNum2 - 1; i >= 0; i--) {
            temp = multiply(num1, Integer.parseInt(num2.charAt(i) + ""), lenNum2 - i - 1);
            ansSb = add(temp, ansSb.toString());
        }

        return ansSb.toString();
    }

    static String multiply(String mul, int digit, int zeros) {
        if (digit == 0)
            return "0";
        if (digit == 1 && zeros == 0)
            return mul;
        StringBuilder ansSb = new StringBuilder();
        int lenMul = mul.length()-1;

        int car = 0;

        while(lenMul>=0){
            int ans = ((mul.charAt(lenMul--) - '0') * digit) + car;
            car = ans / 10;
            ansSb.append(ans % 10);
        }

        if (car > 0) {
            ansSb.append( car);
        }
        
        ansSb=ansSb.reverse();

        for (int i = 0; i < zeros; i++) {
            ansSb.append("0");
        }

        return ansSb.toString();
    }

    static StringBuilder add(String num1, String num2) {
        int lenNum1 = num1.length() - 1;
        int lenNum2 = num2.length() - 1;

        StringBuilder ansSb = new StringBuilder();
        int car = 0;

        while (lenNum1 >= 0 || lenNum2 >= 0 || car==1) {
            int d1 = lenNum1 >= 0 ? num1.charAt(lenNum1--) - '0' : 0;
            int d2 = lenNum2 >= 0 ? num2.charAt(lenNum2--) - '0' : 0;
            int add = d1 + d2 + car;
            car = add / 10;
            ansSb.append( add % 10);
        }
        return ansSb.reverse();
    }
}
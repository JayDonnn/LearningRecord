package Algorithm.work1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Fraction2Decimal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(",");
        if (inputs.length != 2)
            return;
        int numerator, denominator;
        if (inputs[0].split("=").length != 2 || inputs[1].split("=").length != 2)
            return;
        numerator = Integer.parseInt(inputs[0].split("=")[1].trim());
        denominator = Integer.parseInt(inputs[1].split("=")[1].trim());

        Fraction2Decimal fraction2Decimal = new Fraction2Decimal();
        System.out.println(fraction2Decimal.fractionToDecimal(numerator, denominator));
    }

    //    public String fractionToDecimal(int numerator, int denominator) {
//        if(denominator == 0){
//            return null;
//        } else {
//            if(numerator == 0) {
//                return "0";
//            } else {
//                StringBuilder fraction = new StringBuilder();
//                if(numerator < 0 ^ denominator < 0)
//                    fraction.append("-");
//                long dividend = Math.abs(Long.valueOf(numerator));
//                long divisor = Math.abs(Long.valueOf(denominator));
//                fraction.append(String.valueOf((dividend / divisor)));
//                long remainder = dividend % divisor;
//                if(remainder == 0)
//                    return fraction.toString();
//                fraction.append(".");
//
//                HashMap<Long, Integer> map = new HashMap<>();
//                while (remainder > 0){
//                    if(map.containsKey(remainder)){
//                        fraction.insert(map.get(remainder), "(");
//                        fraction.append(")");
//                        break;
//                    }
//                    map.put(remainder, fraction.length());
//                    remainder *= 10;
//                    fraction.append(String.valueOf(remainder / divisor));
//                    remainder %= divisor;
//                }
//                return fraction.toString();
//
//            }
//        }
//    }
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder fraction = new StringBuilder();
        // If either one is negative (not both)
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }
        // Convert to Long or else abs(-2147483648) overflows
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(String.valueOf(dividend / divisor));
        long remainder = dividend % divisor;
        if (remainder == 0) {
            return fraction.toString();
        }
        fraction.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }
        return fraction.toString();
    }
}

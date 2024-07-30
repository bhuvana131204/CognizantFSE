package finance;

import java.util.HashMap;
import java.util.Map;

public class Forecast {
   
    private static Map<Integer, Double> memo = new HashMap<>();

    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
 
        if (years == 0) {
            return presentValue;
        }
 
        if (memo.containsKey(years)) {
            return memo.get(years);
        }
 
        double futureValue = calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
        memo.put(years, futureValue);
        return futureValue;
    }

    public static void main(String[] args) {
        double presentValue = 1000.0;
        double growthRate = 0.05;
        int years = 10;

        double futureValue = calculateFutureValue(presentValue, growthRate, years);
        System.out.println("Future Value after " + years + " years: " + futureValue);
    }
}


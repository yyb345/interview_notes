package leetcode;

public class NumsUtil {

    public static String numProcess(String raw){

        return raw.replaceAll("\\[", "{")
                .replaceAll("\\]", "}");
    }

    public static double mySqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Input cannot be negative");
        }

        double left = 0;
        double right = x;

        int iter=0;
        while (left <= right) {
            double mid = left + (right - left) / 2;
            double square = mid * mid;
            iter++;
            if (Math.abs(square - x) < 0.001) {
                System.out.println(iter);
                return mid;
            } else if (square < x) {
                left = mid;
            } else {
                right = mid;
            }
        }


        return -1; // 未找到满足条件的值
    }


    public static void main(String[] args){

        System.out.println(mySqrt(8888));
    }
}

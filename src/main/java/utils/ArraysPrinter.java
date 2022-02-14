package utils;

public class ArraysPrinter {
    public static void print(String text, double[] arr, double epsilon){
        System.out.print(text + ": \n\t");
        for (double v : arr) {
            if (epsilon > 1) {
                System.out.format("%" + (String.valueOf(epsilon).length() + 1) + ".f ", v);
            } else {
                System.out.format("%." + (String.valueOf(epsilon).length() - 1) + "f ", v);
            }

        }
        System.out.println();
    }
}

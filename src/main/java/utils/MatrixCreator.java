package utils;

import entities.Matrix;

import java.util.Scanner;

public class MatrixCreator {
    public static Matrix createMatrix(int size, Scanner scanner) throws Exception {

        double[][] elemArr = new double[size][size];
        double[] bArr = new double[size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size + 1; j++) {
                if (j == size)
                    bArr[i] = scanner.nextDouble();
                else
                    elemArr[i][j] = scanner.nextDouble();
            }
        }

        return new Matrix(size, elemArr, bArr);
    }
}

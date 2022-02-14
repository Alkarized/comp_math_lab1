package commands;

import entities.Command;
import entities.Matrix;
import entities.MatrixRuler;
import utils.ArraysPrinter;

import java.util.Arrays;

public class MathCommand extends Command {

    public MathCommand(MatrixRuler ruler) {
        super(ruler);
    }

    @Override
    public void execute() {
        Matrix matrix = getRuler().getMatrix();
        //Диагональная фигня
        if (checkDiagonal(matrix)) {
            double[] dArray = makeZeroIteration(matrix); //Вектор первоначальных значений (начальное приближение)
            System.out.println("Итерация №0");
            ArraysPrinter.print("Начальное приближение", dArray, getRuler().getEpsilon());
            System.out.println("--------------------------------");
            double[] prevArray = dArray; //Вектор предыдущих значений
            int k = 1; // Кол-во итераций;
            while (k < getRuler().getMaxIterations()) {
                double[] xArray = new double[matrix.getSize()]; //Вектор новых значений (k-ая итерация)
                double[] difArray = new double[matrix.getSize()]; // Вектор погрешностей
                for (int i = 0; i < matrix.getSize(); i++) {
                    double sum = 0;
                    for (int j = 0; j < i; j++) {
                        sum += xArray[j] * matrix.getElementsArray()[i][j] / matrix.getElementsArray()[i][i];
                    }

                    for (int j = i + 1; j < matrix.getSize(); j++) {
                        sum += prevArray[j] * matrix.getElementsArray()[i][j] / matrix.getElementsArray()[i][i];
                    }
                    xArray[i] = dArray[i] - sum;
                    difArray[i] = Math.abs(xArray[i] - prevArray[i]);
                }
                System.out.println("Итерация №" + k);
                ArraysPrinter.print("Вектор неизвестных", xArray, getRuler().getEpsilon());
                ArraysPrinter.print("Вектор погрешностей", difArray, getRuler().getEpsilon());
                Arrays.sort(difArray);
                if (difArray[matrix.getSize() - 1] < getRuler().getEpsilon()) {
                    System.out.println("--------------------------------");
                    System.out.println("Кол-во итераций для нахождения - " + k);
                    return;
                }
                k++;
                prevArray = xArray;
                System.out.println("--------------------------------");
            }
            System.out.println("Превысили кол-во итераций");
        } else {
            System.out.println("Не удалось получить условия диагонального преобладания");
        }
    }

    private boolean checkDiagonal(Matrix matrix) {
        boolean isCanBeDiagonal = true;
        boolean isOneStrict = false;
        double sum;
        for (int i = 0; i < matrix.getSize(); i++) {
            sum = 0;
            for (int j = 0; j < getRuler().getMatrix().getSize(); j++) {
                sum += Math.abs(matrix.getElementsArray()[i][j]);
            }
            double diagonalElement = Math.abs(matrix.getElementsArray()[i][i]);
            sum -= diagonalElement;
            if (sum > diagonalElement) {
                isCanBeDiagonal = false;
            }
            if (sum < diagonalElement) { //А надо ли??
                isOneStrict = true;
            }
        }
        return isCanBeDiagonal && isOneStrict;
    }

    private double[] makeZeroIteration(Matrix matrix) {
        double[] zeroArr = new double[matrix.getSize()];
        for (int i = 0; i < matrix.getSize(); i++) {
            zeroArr[i] = matrix.getBArray()[i] / matrix.getElementsArray()[i][i];
        }
        return zeroArr;
    }


}

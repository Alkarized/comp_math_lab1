package commands;

import entities.Command;
import utils.MatrixCreator;
import utils.MatrixRuler;

import java.util.Scanner;


public class TerminalReaderCommand extends Command {

    public TerminalReaderCommand(MatrixRuler ruler) {
        super(ruler);
    }

    @Override
    public void execute() {
        while (true) {
            try {
                System.out.println("Введите размер матрицы");
                int size = new Scanner(System.in).nextInt();
                if (!(size >= 1 && size <= 20)) throw new IndexOutOfBoundsException();
                System.out.println("Введите коэффициенты СЛАУ с учетом столбца B");
                getRuler().setMatrix(MatrixCreator.createMatrix(size, new Scanner(System.in)));

                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Размер введенной матрицы превышает допустимые значения");
            } catch (Exception e) {
                System.out.println("Произошла ошибка чтения из консольки, проверьте правильность данных");
            }
        }
    }
}

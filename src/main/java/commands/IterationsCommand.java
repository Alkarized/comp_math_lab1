package commands;

import entities.Command;
import entities.MatrixRuler;

import java.util.Scanner;

public class IterationsCommand extends Command {

    public IterationsCommand(MatrixRuler ruler) {
        super(ruler);
    }

    @Override
    public void execute() {
        while (true) {
            try {
                System.out.println("Введите максимальное кол-во итераций");
                int iter = new Scanner(System.in).nextInt();
                if (iter <= 0) throw new IndexOutOfBoundsException();
                getRuler().setMaxIterations(iter);
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Введенное число не подходит!");
            } catch (Exception e) {
                System.out.println("Произошла ошибка ввода итераций");
            }
        }
    }
}

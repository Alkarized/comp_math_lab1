package commands;

import entities.Command;
import utils.MatrixRuler;

import java.util.Scanner;

public class ChooseCommand extends Command {

    public ChooseCommand(MatrixRuler ruler) {
        super(ruler);
    }

    @Override
    public void execute() {
        while (true) {
            try {
                printChose();

                int choose = new Scanner(System.in).nextInt();
                if (choose != 1 && choose != 2) throw new Exception();

                getRuler().setChosenOption(choose);

                break;
            } catch (Exception e) {
                System.out.println("Неправильный выбор, исправляйся");
            }
        }
    }

    private void printChose() {
        System.out.println("--------------------------------");
        System.out.println("Выберите формат вводимых данных");
        System.out.println("1 - Ввод из файла");
        System.out.println("2 - Ввод с клавиатуры");
        System.out.println("--------------------------------");
    }
}

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

                Scanner scanner = new Scanner(System.in); //Возможно стоит поместить его в конструкцию try(Scanner ...)?

                int choose = scanner.nextInt();
                if (choose != 1 && choose != 2) throw new Exception();

                getRuler().setChosenOption(choose);

                scanner.close();
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

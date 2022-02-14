package commands;

import entities.Command;
import utils.MatrixRuler;

import java.util.Scanner;

public class EpsilonReaderCommand extends Command {

    public EpsilonReaderCommand(MatrixRuler ruler) {
        super(ruler);
    }

    @Override
    public void execute() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите точность");
                double eps = Double.parseDouble(scanner.nextLine().trim());
                if (eps < 0) throw new Exception();
                getRuler().setEpsilon(eps);
                System.out.println("Введенная точность - " + eps);
                scanner.close();
                break;
            } catch (Exception e) {
                System.out.println("Введена неправильная точность!");
            }
        }
    }
}

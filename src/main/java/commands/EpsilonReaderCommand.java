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
                System.out.println("Введите точность");
                double eps = Double.parseDouble( new Scanner(System.in).nextLine().trim());

                if (eps < 0) throw new Exception();

                getRuler().setEpsilon(eps);

                System.out.println("Введенная точность - " + eps);
                break;
            } catch (Exception e) {
                System.out.println("Введена неправильная точность!");
            }
        }
    }
}

package commands;

import entities.Command;
import utils.MatrixCreator;
import entities.MatrixRuler;

import java.io.File;
import java.util.Scanner;

public class FileReaderCommand extends Command {

    public FileReaderCommand(MatrixRuler ruler) {
        super(ruler);
    }

    @Override
    public void execute() {
        Scanner fileScanner = null;
        while (true) {
            try {
                System.out.println("Введите название файла");
                String filename = new Scanner(System.in).nextLine();
                fileScanner = new Scanner(new File(filename));
                int size = fileScanner.nextInt();

                getRuler().setMatrix(MatrixCreator.createMatrix(size, fileScanner));

                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Размер введенной матрицы превышает допустимые значения");
            } catch (Exception e) {
                System.out.println("Произошла ошибка чтения из файлика, проверьте правильность данных");
            } finally {
                if (fileScanner != null) fileScanner.close();
            }
        }


    }
}

package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Matrix {
    private int size;
    private double[][] elementsArray;
    private double[] bArray;

    @Override
    public String toString() {
        StringBuilder answer = new StringBuilder("\t");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size + 1; j++) {
                if (j == size)
                    answer.append(bArray[i]).append("\n\t");
                else
                    answer.append(elementsArray[i][j]).append(" ");
            }
        }
        return "size: " + size + "\n" +
                "Matrix: \n" + answer.toString();

    }
}

package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import utils.MatrixRuler;

import java.util.Scanner;

@AllArgsConstructor
@Getter
public abstract class Command {
    private final MatrixRuler ruler;

    public abstract void execute();


}

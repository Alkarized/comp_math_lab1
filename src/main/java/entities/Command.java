package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Command {
    private final MatrixRuler ruler;

    public abstract void execute();


}

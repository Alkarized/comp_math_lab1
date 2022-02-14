package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import utils.MatrixRuler;

@AllArgsConstructor
@Getter
public abstract class Command {
    private final MatrixRuler ruler;

    public abstract void execute();


}

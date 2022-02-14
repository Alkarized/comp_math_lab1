package utils;

import commands.*;
import entities.Command;
import entities.MatrixRuler;
import lombok.Getter;

import java.util.HashMap;

public class Invoker {
    @Getter
    private final HashMap<String, Command> commands;

    public Invoker() {
        commands = new HashMap<>();
    }

    public void setCommands(MatrixRuler ruler) {
        commands.put("epsilon", new EpsilonReaderCommand(ruler));
        commands.put("file", new FileReaderCommand(ruler));
        commands.put("math", new MathCommand(ruler));
        commands.put("terminal", new TerminalReaderCommand(ruler));
        commands.put("choose", new ChooseCommand(ruler));
        commands.put("iterations", new IterationsCommand(ruler));
    }
}

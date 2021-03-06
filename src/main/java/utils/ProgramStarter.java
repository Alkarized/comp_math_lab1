package utils;

public class ProgramStarter {
    public void startProgram() {
        MatrixRuler ruler = new MatrixRuler();

        Invoker invoker = new Invoker();
        invoker.setCommands(ruler);

        invoker.getCommands().get("epsilon").execute();

        invoker.getCommands().get("choose").execute();

        if (ruler.getChosenOption() == 1)
            invoker.getCommands().get("file").execute();
        else
            invoker.getCommands().get("terminal").execute();

        System.out.println(ruler.getMatrix());
    }
}

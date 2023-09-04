package geo_group;

public class GeoPrint extends Command {

    public GeoPrint(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Печать семейного древа.";
    }

    @Override
    public void execute() {
        getConsole().geoPrint();
    }
}
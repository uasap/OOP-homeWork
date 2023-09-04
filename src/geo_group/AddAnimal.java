package geo_group;

public class AddAnimal extends Command {
    public AddAnimal(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Добавление человека в семью. ";
    }

    @Override
    public void execute() {
        getConsole().addHumanNew();
    }
}
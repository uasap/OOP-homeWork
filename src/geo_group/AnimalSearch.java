package geo_group;

public class AnimalSearch extends Command {
    public AnimalSearch(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Поиск человека по имени. ";
    }

    @Override
    public void execute() {
        getConsole().humanSearch();
    }
}

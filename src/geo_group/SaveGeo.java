package geo_group;

public class SaveGeo extends Command {
    public SaveGeo(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Сохранить семью. ";
    }

    @Override
    public void execute() {
        getConsole().saveGeo();
    }
}
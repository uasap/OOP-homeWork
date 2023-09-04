package geo_group;

public interface View {
    
    void setPresenter(Presenter presenter);

    void start();

    void print(String text);

    String scan();

}

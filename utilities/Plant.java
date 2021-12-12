package utilities;

public abstract class Plant implements PlantInterface {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

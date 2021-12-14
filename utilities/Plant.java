package utilities;

public abstract class Plant implements PlantInterface {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equals("")) {
            throw new IllegalArgumentException("Name must has at least 1 symbol");
        }
        this.name = name;
    }
}

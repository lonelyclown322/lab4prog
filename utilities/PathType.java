package utilities;

public enum PathType {
    Casual("обычная"), Narrow("узкая"), Thistle("между чертополохом");
    String name;

    PathType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

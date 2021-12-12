package utilities;

public enum MoveType {
    Circling("носится, описывая большие круги"), Looped("описывал петли"), HereAndThere("носится туда-сюда"),
    Goosing("идет гуськом"), Casual("обычно");
    String name;

    MoveType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

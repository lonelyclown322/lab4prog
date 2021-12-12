package utilities;

public enum Home implements Location{

    PyatachokHome("дом Пяточка"), RabbitHome("дом Кролика"),
    PoohHome("дом Винни-Пуха"), TigerHome("дом Тигры"),
    RooHome("дом Кенги и Ру"), KengaHome("дом Кенги и Ру");
    private final String name;

    Home(String s) {
        this.name = s;
    }

    @Override
    public String getLocationName() {
        return name;
    }

    @Override
    public Location getLocation() {
        return this;
    }
}

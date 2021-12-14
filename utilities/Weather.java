package utilities;

public enum Weather {
    Sunny("солнечно"), Warm("тепло"), Cold("холодно"), Foggy("тумманно");
    private final String weatherName;

    Weather(String s) {
        this.weatherName = s;
    }

    public String getWeatherName() {
        return weatherName;
    }

}

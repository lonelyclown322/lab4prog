package utilities;

public interface StatusInterface {
    Weather[] getCurrentWeather();

    int getCurrentDay();

    void nextDay();

    void turnWeatherToBad();

    void turnWeatherToGood();
}

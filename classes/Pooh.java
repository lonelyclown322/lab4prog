package classes;

import utilities.*;

import java.util.Objects;

public class Pooh extends MainHero {

    public Pooh(String name, Location currentPosition, Home home) {
        super(name, currentPosition, home);
    }

    public void thinkOfHoney(Status s) {
        if (s == null) {
            throw new NullPointerException("Status can't be null");
        }
        if ((s.getCurrentWeather()[0] == Weather.Cold) && (s.getCurrentWeather()[1] == Weather.Foggy)) {
            this.setAfraid(true);
        }
        System.out.println(this.getName() + " представил себе мед, который пчёлы не смогут " +
                "сделать из-за плохой погоды.");
    }

    @Override
    public void goTo(Location l) {
        if (l == null) {
            throw new NullPointerException("Location can't be null");
        }
        this.setCurrentPosition(l);
        System.out.println(this.getName() + " подошел к " + this.getCurrentPosition().getLocationName() + ".");
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Pooh{" +
                "home=" + this.getHome().getLocationName() +
                '}';
    }
}

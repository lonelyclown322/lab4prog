package classes;

import utilities.*;

import java.util.Objects;

public class Pyatachok extends MainHero {

    public Pyatachok(String name, Location currentPosition, Home home) {
        super(name, currentPosition, home);
    }

    @Override
    public void goTo(Location l) {
        this.setCurrentPosition(l);
        System.out.println(this.getName() + " подошел к " + this.getCurrentPosition().getLocationName() + ".");
    }


    public void thinkOfEvilPlan(Status s) {
        if ((s.getCurrentWeather()[0] == Weather.Cold) && (s.getCurrentWeather()[1] == Weather.Foggy)) {
            System.out.println(this.getName() + " думал о том, как грустно будет тому, кого будто бы случайно" +
                    " забудут в этот день в лесу.");
        }
    }

    public void shareEvilPlan(Status s, Tiger t) {
        if (((s.getCurrentWeather()[0] == Weather.Cold) && (s.getCurrentWeather()[1] == Weather.Foggy)) &&
                (t.jumpsForwardOnTail())) {
            System.out.println(this.getName() + " сказал: \"День подходящий, " + t.getName() + " всегда выскакивает вперед," +
                    " так что все получится.\"");
        }
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
        return "Pyatachok{" +
                "home=" + this.getName() +
                '}';
    }
}

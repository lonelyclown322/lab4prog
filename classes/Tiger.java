package classes;

import utilities.*;

import java.util.Objects;

public class Tiger extends MainHero {

    public Tiger(String name, Location currentPosition, Home home) {
        super(name, currentPosition, home);
    }

    public boolean jumpsForwardOnTail() {
        return false;
    }

    public void scare(MainHero h) throws HeroesNotCloseException {
        if (h == null) {
            throw new NullPointerException("MainHero can't be null");
        }
        if (getCurrentPosition() == h.getCurrentPosition()) {
            h.setAfraid(true);
            h.setHid(true);
            System.out.println(getName() + " напугал " + h.getName() + ".");
            System.out.println(h.getName() + " спрятался.");
        } else {
            throw new HeroesNotCloseException("Ошибка! Герои не рядом!");
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
        return "Tiger{" +
                "home=" + this.getHome().getLocationName() +
                '}';
    }
}

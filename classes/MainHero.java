package classes;

import java.util.Objects;

import utilities.*;

public class MainHero extends Hero implements MainHeroInterface, Moveable {
    private final String name;
    private boolean Afraid = false;
    private final Home home;
    private MoveType moveType = MoveType.Casual;

    public Location getHome() {
        return home;
    }

    public boolean getAfraid() {
        return Afraid;
    }

    public void setAfraid(boolean t) {
        this.Afraid = t;
    }



    public void tell(MainHero h, String message) throws HeroesNotCloseException {
        if (this.getCurrentPosition() == h.getCurrentPosition()) {
            System.out.println(this.name + " сказал " + h.getName() + ": " + message);
        }
        else {
            throw new HeroesNotCloseException("Ошибка! Герои не рядом!");
        }
    }



    public MainHero(String name, Location currentPosition, Home home) {
        super(name, currentPosition);
        this.name = name;
        this.home = home;
    }


    public String getName() {
        return name;
    }

    @Override
    public void inviteToHike(MainHero whoIsAsked, Hike hike) {
        System.out.println(this.name + " хочет спросить " + whoIsAsked.getName() + ": \"Что ты завтра собираешься делать?" +
                " Если ничего, то давай сходим в " + hike.getName() + "?\"");
        hike.appendHeroInInvited(whoIsAsked);
    }

    @Override
    public void isAfraid() {
        if (!Afraid) {
            System.out.println(this.name + " не боялся.");
        } else {
            System.out.println(this.name + " испугался.");
        }
    }

    @Override
    public void shareFeelings(MainHero h) {
        if (this.Afraid) {
            System.out.println(this.name + " сказал персонажу " + h.name + ", что ему страшно.");
        }
    }

    @Override
    public void setMoveType(MoveType t) {
        moveType = t;
        System.out.println(this.name + " " + t.getName() + ".");;
    }

    @Override
    public MoveType getMoveType() {
        return moveType;
    }

    public void push(Hero h) {
        if (!h.isHid()) {
            System.out.println(name + " пихнул локтем " + h.getName() + ".");
        } else {
            System.out.println(name + " не нашел " + h.getName() + ", поэтому не смог пихнуть.");
        }
        }

    @Override
    public void beIndifferent(MainHero h) {
        System.out.println(this.name + " сказал персонажу " + h.name + ", что его это не особо волнует.");
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", currentPosition=" + getCurrentPosition() +
                ", Afraid=" + Afraid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MainHero)) return false;
        MainHero mainHero = (MainHero) o;
        return Afraid == mainHero.Afraid && Objects.equals(getName(), mainHero.getName())
                && Objects.equals(getCurrentPosition(), mainHero.getCurrentPosition())
                && getHome() == mainHero.getHome();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCurrentPosition(), Afraid, getHome());
    }
}
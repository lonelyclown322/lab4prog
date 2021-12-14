package classes;

import java.util.Objects;

import utilities.*;

public class MainHero extends Hero implements MainHeroInterface, Moveable, Coughable {
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
        if (h == null) {
            throw new NullPointerException("MainHero can't be null");
        }
        if (message.equals("")) {
            throw new IllegalArgumentException("message must has at least 1 symbol");
        } else {
            if (this.getCurrentPosition() == h.getCurrentPosition()) {
                System.out.println(getName() + " сказал " + h.getName() + ": " + message);
            } else {
                throw new HeroesNotCloseException("Ошибка! Герои не рядом!");
            }
        }
    }


    public MainHero(String name, Location currentPosition, Home home) {
        super(name, currentPosition);
        if (home == null) {
            throw new NullPointerException("Home can't be null");
        } else {
            this.home = home;
        }
    }

    @Override
    public void inviteToHike(MainHero whoIsAsked, Hike hike) {
        if (whoIsAsked == null) {
            throw new NullPointerException("MainHero can't be null");
        }
        if (hike == null) {
            throw new NullPointerException("Hike can't be null");
        } else {
            System.out.println(getName() + " хочет спросить " + whoIsAsked.getName() + ": \"Что ты завтра собираешься делать?" +
                    " Если ничего, то давай сходим в " + hike.getName() + "?\"");
            hike.appendHeroInInvited(whoIsAsked);
        }
    }

    @Override
    public void isAfraid() {
        if (!Afraid) {
            System.out.println(getName() + " не боялся.");
        } else {
            System.out.println(getName() + " испугался.");
        }
    }

    @Override
    public void shareFeelings(MainHero h) {
        if (h == null) {
            throw new NullPointerException("MainHero can't be null");
        } else {
            if (this.Afraid) {
                System.out.println(getName() + " сказал персонажу " + getName() + ", что ему страшно.");
            }
        }
    }

    @Override
    public void setMoveType(MoveType t) {
        if (t == null) {
            throw new NullPointerException("MoveType can't be null");
        } else {
            moveType = t;
            System.out.println(getName() + " " + t.getName() + ".");
        }
    }

    @Override
    public MoveType getMoveType() {
        return moveType;
    }

    public void push(Hero h) {
        if (h == null) {
            throw new NullPointerException("Hero can't be null");
        } else {
            if (!h.isHid()) {
                System.out.println(getName() + " пихнул локтем " + h.getName() + ".");
            } else {
                System.out.println(getName() + " не нашел " + h.getName() + ", поэтому не смог пихнуть.");
            }
        }
    }

    public void askNotToGoToHike(MainHero whoIsCoughing, StatusInterface status, MainHero whoIsAsked) {
        if (whoIsCoughing == null || whoIsAsked == null) {
            throw new NullPointerException("MainHero can't be null");
        }
        if (status == null) {
            throw new NullPointerException("StatusInterface can't be null");
        } else {
            if (whoIsCoughing.isCoughing() && status.getCurrentWeather()[0] == Weather.Cold &&
                    status.getCurrentWeather()[1] == Weather.Foggy) {
                this.tell(whoIsAsked, "\"Может " + whoIsCoughing.getName() + " не стоит сегодня идти в поход?\"");
            }
        }
    }

    @Override
    public void beIndifferent(MainHero h) {
        if (h == null) {
            throw new NullPointerException("MainHero can't be null");
        } else {
            System.out.println(getName() + " сказал персонажу " + getName() + ", что его это не особо волнует.");
        }
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + getName() + '\'' +
                ", currentPosition=" + getCurrentPosition() +
                ", Afraid=" + Afraid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            throw new NullPointerException("Object can't be null");
        }
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

    @Override
    public boolean isCoughing() {
        return false;
    }
}
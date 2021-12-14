import classes.*;
import classes.MainHero;
import utilities.*;

import java.nio.file.Path;
import java.util.Arrays;

public class Story {
    public static void main(String[] args) {

        Pyatachok pyatachok = new Pyatachok("Пятачок", Home.PyatachokHome, Home.PyatachokHome);
        MainHero rabbit = new MainHero("Кролик", Home.RabbitHome, Home.RabbitHome);
        Pooh pooh = new Pooh("Винни-Пух", Home.PoohHome, Home.PoohHome);
        Tiger tiger = new Tiger("Тигра", Home.TigerHome, Home.TigerHome) {
            @Override
            public boolean jumpsForwardOnTail() {
                return true;
            }

            @Override
            public void goTo(Hero h) {
                setCurrentPosition(h.getCurrentPosition());
                System.out.println(getName() + " подошёл к " + h.getName() + ".");
            }
        };
        KangarooHero roo = new KangarooHero("Ру", Home.RooHome, Home.RooHome, 10) {
            @Override
            public boolean isCoughing() {
                return true;
            }

        };
        KangarooHero kenga = new KangarooHero("Кенга", Home.KengaHome, Home.KengaHome, 5);

        MainHero[] crew = new MainHero[]{pyatachok, rabbit, pooh};
        Hike hike = new Hike(crew, "утренний поход");

        rabbit.inviteToHike(tiger, hike);

        rabbit.goTo(tiger.getHome());

        Status status = new Status();

        status.nextDay();
        status.turnWeatherToBad();
        pooh.isAfraid();
        pooh.thinkOfHoney(status);
        pooh.isAfraid();
        pyatachok.goTo(pooh.getCurrentPosition());
        pooh.shareFeelings(pyatachok);
        pyatachok.beIndifferent(pooh);
        pyatachok.thinkOfEvilPlan(status);
        pyatachok.goTo(rabbit.getHome());
        pooh.goTo((rabbit.getHome()));
        pyatachok.shareEvilPlan(status, tiger);

        System.out.println();
        pyatachok.goTo(kenga.getHome());
        pooh.goTo(kenga.getHome());
        roo.setCurrentPosition(roo.getHome());
        System.out.println("Ру находится возле " + roo.getCurrentPosition().getLocationName() + ".");
        pooh.askNotToGoToHike(roo, status, kenga);
        hike.appendHero(tiger);
        hike.start();
        System.out.println();

        Hike.Path footPath = new Hike.Path("тропинка");
        hike.setCurrentPath(footPath);
        tiger.setMoveType(MoveType.Circling);
        footPath.setPathType(PathType.Narrow);
        rabbit.setMoveType(MoveType.Goosing);
        pyatachok.setMoveType(MoveType.Goosing);
        pooh.setMoveType(MoveType.Goosing);
        tiger.setMoveType(MoveType.Looped);
        footPath.setPathType(PathType.Thistle);
        tiger.setMoveType(MoveType.HereAndThere);

        System.out.println();

        try {
            status.gettingMoreFoggy();
        } catch (WeatherIsNotFoggyException e) {
            System.out.println("Ошибка! Погода не была туманной!");
        }

        Hike.Path hikeGlade = new Hike.Path("прогалина");
        hike.setCurrentPath(hikeGlade);
        pooh.setCurrentPosition(tiger.getCurrentPosition());
        roo.setCurrentPosition(tiger.getCurrentPosition());
        pooh.goTo(tiger);
        pyatachok.goTo(tiger);

        Plant paporotnik = new Plant() {
            @Override
            public void hide(Hero h) {
                System.out.println(h.getName() + " притаился за " + this.getName() + ".");
            }

            {
                this.setName("папоротник");
            }
        };

        paporotnik.hide(pooh);
        paporotnik.hide(pyatachok);
        status.setQuietly(true);
        tiger.goTo(pyatachok);
        tiger.scare(pyatachok);
        pyatachok.isAfraid();
        rabbit.push(pooh);
        pooh.push(pyatachok);
    }
}
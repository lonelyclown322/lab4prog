package utilities;

import classes.MainHero;
import classes.Hike;

public interface MainHeroInterface extends HeroInterface{

    void inviteToHike(MainHero whoIsAsked, Hike hike);

    void isAfraid();

    void shareFeelings(MainHero h);

    void beIndifferent(MainHero h);

}

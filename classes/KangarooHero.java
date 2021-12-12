package classes;

import utilities.*;

import java.util.ArrayList;

public class KangarooHero extends MainHero implements Coughable {

    public KangarooHero(String name, Location currentPosition, Home home, int pouchVolume) {
        super(name, currentPosition, home);
        this.pouchVolume = pouchVolume;
    }

    private int pouchVolume;

    @Override
    public boolean isCoughing() {
        return false;
    }

    public class KangarooPouch {
        private ThingInterface[] thingList = new ThingInterface[pouchVolume];


        public String WhatIsInPouch() {

            class WhatIsInPouchOuter {

                 String outInConsole() {
                    String out = "Список вещей в сумке: ";
                    for (ThingInterface t : thingList) {
                        if(t != null) {
                            out += t.toString();
                        }
                    }
                    return out;
                }

            }

            WhatIsInPouchOuter terminalOuter = new WhatIsInPouchOuter();
            return terminalOuter.outInConsole();
            }

        }
    }
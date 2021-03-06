package classes;

import com.sun.xml.internal.bind.api.impl.NameConverter;
import utilities.Location;
import utilities.PathType;

import java.util.Arrays;

public class Hike {
    private final MainHero[] heroes = new MainHero[100];

    private Path currentPath;

    public Path getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(Path currentPath) {
        if (currentPath == null) {
            throw new NullPointerException("Path can't be null");
        } else {
            this.currentPath = currentPath;
        }
    }

    private final MainHero[] invitedHeroes = new MainHero[100];

    private int quantity;

    private int invitedQuantity;

    private final String name;

    public static class Path implements Location {
        String name;

        public Path(String name) {
            if (name.equals("")) {
                throw new IllegalArgumentException("Name should be at least 1 symbol");
            } else {
                this.name = name;
                System.out.println("Герои идут по " + name + ".");
            }
        }

        PathType pathType = PathType.Casual;

        @Override
        public String getLocationName() {
            return name;
        }

        @Override
        public Location getLocation() {
            return this;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            if (name.equals("")) {
                throw new IllegalArgumentException("Name should be at least 1 symbol");
            } else {
                this.name = name;
            }
        }

        public PathType getPathType() {
            return pathType;
        }

        public void setPathType(PathType pathType) {
            if (pathType == null) {
                throw new NullPointerException("PathType can't be null");
            } else {
                this.pathType = pathType;
                System.out.println(name + " стала " + pathType.getName() + ".");
            }
        }
    }

    public Hike(MainHero[] heroes, String name) {
        if (heroes == null) {
            throw new NullPointerException("heroes can't be null");
        }
        if (name.equals("")) {
            throw new IllegalArgumentException("Name should be at least 1 symbol");
        } else {
            quantity = heroes.length;
            this.name = name;
            for (int i = 0; i < heroes.length - 1; i++) {
                System.out.print(heroes[i].getName() + ", ");
                this.heroes[i] = heroes[i];
            }
            System.out.println(heroes[heroes.length - 1].getName() + " выступят в " + name + ".");
            this.heroes[heroes.length - 1] = heroes[heroes.length - 1];
        }
    }

    public MainHero[] getHeroes() {
        return heroes;
    }

    public MainHero[] getInvitedHeroes() {
        return invitedHeroes;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getInvitedQuantity() {
        return invitedQuantity;
    }

    public void appendHero(MainHero h) {
        if (h == null) {
            throw new NullPointerException("MainHero can't be null");
        } else {
            heroes[quantity] = h;
            quantity++;
        }
    }

    public void start() {
        for (int i = 0; i < quantity - 1; i++) {
            System.out.print(heroes[i].getName() + ", ");
        }
        System.out.println(heroes[quantity - 1].getName() + " выдвигаются в " + this.getName() + ".");
    }

    public void appendHeroInInvited(MainHero h) {
        if (h == null) {
            throw new NullPointerException("MainHero can't be null");
        } else {
            invitedHeroes[invitedQuantity] = h;
            invitedQuantity++;
        }
    }

    public boolean findInHeroes(MainHero h) {
        if (h == null) {
            throw new NullPointerException("MainHero can't be null");
        } else {
            for (MainHero hero : heroes) {
                if (hero == h) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean findInInvitedHeroes(MainHero h) {
        if (h == null) {
            throw new NullPointerException("MainHero can't be null");
        } else {
            for (MainHero hero : invitedHeroes) {
                if (hero == h) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            throw new NullPointerException("Object can't be null");
        } else {
            if (this == o) return true;
            if (!(o instanceof Hike)) return false;
            Hike hike = (Hike) o;
            return Arrays.equals(heroes, hike.getHeroes());
        }
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getHeroes());
    }

    @Override
    public String toString() {
        return "Hike= " + name;
    }
}

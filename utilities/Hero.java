package utilities;

public abstract class Hero implements HeroInterface {

    private Location currentPosition;
    private final String name;

    protected Hero(String name, Location currentPosition) {
        if (name.equals("")) {
            throw new IllegalArgumentException("Name must has at least 1 symbol");
        }
        if (currentPosition == null) {
            throw new NullPointerException("Location can't be null");
        }
        this.name = name;
        this.currentPosition = currentPosition;
    }


    @Override
    public void goTo(Location l) {
        if (l == null) {
            throw new NullPointerException("Location can't be null");
        }
        currentPosition = l;
        System.out.println(name + " пойдет сейчас в " + currentPosition.getLocation().getLocationName() + ".");
    }

    @Override
    public void goTo(Hero h) {
        if (h == null) {
            throw new NullPointerException("Hero can't be null");
        }
        currentPosition = h.getCurrentPosition();
        System.out.println(this.name + " погнался за " + h.name + ".");
    }

    private boolean hid = false;

    public boolean isHid() {
        return hid;
    }

    public void setHid(boolean hid) {
        this.hid = hid;
    }

    public Location getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Location currentPosition) {
        if (currentPosition == null) {
            throw new NullPointerException("Location can't be null");
        }
        this.currentPosition = currentPosition;
    }

    public String getName() {
        return name;
    }
}

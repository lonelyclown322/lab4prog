package utilities;

public abstract class Hero implements HeroInterface{

    private Location currentPosition;
    private final String name;

    protected Hero(String name, Location currentPosition) {
        this.name = name;
        this.currentPosition = currentPosition;
    }


    @Override
    public void goTo(Location l) {
        currentPosition = l;
        System.out.println(name + " пойдет сейчас в " + currentPosition.getLocation().getLocationName() + ".");
    }

    @Override
    public void goTo(Hero h) {
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
        this.currentPosition = currentPosition;
    }

    public String getName() {
        return name;
    }
}

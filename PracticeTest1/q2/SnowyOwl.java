public class SnowyOwl extends Owl {
    private  boolean sex;
    public SnowyOwl(boolean sex ) {
        super("SnowyOwl");
        this.sex = sex;
    }
    public String getFood() {
        return "a hare, a lemming, or ...";
    }
    public String getColor() {
        if(sex) return "white";
        return "speckled";
    }

}

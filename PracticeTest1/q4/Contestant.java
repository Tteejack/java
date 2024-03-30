public class Contestant {
    private String name;

    public int getScore() {
        return score;
    }

    private int score;
    public Contestant(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public String getName() {
        return name;
    }
}

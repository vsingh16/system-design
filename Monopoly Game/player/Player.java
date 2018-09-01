package player;

/**
 * Created by vishal on 14-Aug-18.
 */
public class Player {

    private Integer id;
    private Integer amount;
    private Integer currentPosition;

    public Player(Integer id, Integer amount, Integer currentPosition) {
        this.id = id;
        this.amount = amount;
        this.currentPosition = currentPosition;
    }

    public int movePlayer(int steps) {
        int newPosition = currentPosition + steps;
        currentPosition = newPosition % 10;

        return currentPosition;
    }

    public void detectAmount(Integer amount) {
        this.amount = this.amount - amount;
    }

    public void addAmount(Integer amount) {
        this.amount = this.amount + amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getId() {
        return id;
    }

}

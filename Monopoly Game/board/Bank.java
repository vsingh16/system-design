package board;

/**
 * Created by vishal on 14-Aug-18.
 */
public class Bank {

    private Integer amount;

    public Bank(Integer initialAmount) {
        amount = initialAmount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void detectAmount(Integer amount) {
        this.amount = this.amount - amount;
    }

    public void addAmount(Integer amount) {
        this.amount = this.amount + amount;
    }
}

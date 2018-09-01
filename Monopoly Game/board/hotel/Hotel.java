package board.hotel;

import player.Player;

/**
 * Created by vishal on 14-Aug-18.
 */
public class Hotel {

    private String type;
    private Integer value;
    private Integer rent;
    private Player owner;

    public Hotel(String type, Integer value, Integer rent) {
        this.type = type;
        this.value = value;
        this.rent = rent;
    }

    public String getType() {
        return type;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getRent() {
        return rent;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}

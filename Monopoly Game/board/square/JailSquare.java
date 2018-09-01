package board.square;

import board.Bank;
import player.Player;

/**
 * Created by vishal on 15-Aug-18.
 */
public class JailSquare extends Square {

    public void action(Player player, Bank bank) {
        System.out.println("Player " + player.getId() + "has been Jail and lost 500");
        player.detectAmount(500);
        bank.addAmount(500);
        System.out.println("Player " + player.getId() + "updated balance " + player.getAmount());
        System.out.println("Bank Updated Balance" + bank.getAmount());
    }

}

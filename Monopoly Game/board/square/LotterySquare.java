package board.square;

import board.Bank;
import player.Player;

/**
 * Created by vishal on 15-Aug-18.
 */
public class LotterySquare extends Square {

    public void action(Player player, Bank bank) {
        System.out.println("Player " + player.getId() + "hit the jackpot and got 500");
        player.addAmount(700);
        bank.detectAmount(700);
        System.out.println("Player " + player.getId() + "updated balance " + player.getAmount());
        System.out.println("Bank Updated Balance" + bank.getAmount());
    }

}

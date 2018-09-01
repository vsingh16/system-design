package board.square;

import board.Bank;
import board.hotel.Hotel;
import board.hotel.HotelUtil;
import player.Player;

/**
 * Created by vishal on 15-Aug-18.
 */
public class HotelSquare extends Square {

    private Hotel hotel;

    public void action(Player player, Bank bank) {

        if (hotel != null) {
            //hotel already created on square
            //if same player owns hotel, upgrade
            if (hotel.getOwner().equals(player)) {
                hotel = HotelUtil.upgradeToSuperiorHotel(player, hotel, bank);
                System.out.println("Player " + player.getId() + "upgraded to new hotel " + hotel.getType());
            } else {
                //hotel is owned by other player, player has to pay rent to owner
                HotelUtil.transferRent(hotel, player);
                System.out.println("Hotel Type :" + hotel.getType() + " rent " + hotel.getRent() + "transferred from " + player.getId() + "to " + player.getId());
            }
        } else {
            //if hotel is not yet opened at this square
            hotel = HotelUtil.createNewHotel(player, bank);
            System.out.println("Player " + player.getId() + "owns " + hotel.getType());
        }
    }

}

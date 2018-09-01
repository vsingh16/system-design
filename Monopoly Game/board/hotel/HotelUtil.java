package board.hotel;

import board.Bank;
import player.Player;

/**
 * Created by vishal on 15-Aug-18.
 */
public class HotelUtil {

    public static Hotel createNewHotel(Player owner, Bank bank) {

        Hotel silverHotel = new Hotel("Silver", 500, 200);
        silverHotel.setOwner(owner);
        owner.detectAmount(500);
        bank.addAmount(500);

        return silverHotel;
    }

    public static Hotel upgradeToSuperiorHotel(Player owner, Hotel hotel, Bank bank) {
        Hotel newUpgradedHotel = "Silver".equals(hotel.getType()) ? new Hotel("Gold", 700, 400) : new Hotel("Platinum", 1000, 600);
        newUpgradedHotel.setOwner(owner);
        Integer priceDiff = newUpgradedHotel.getValue() - hotel.getValue();
        owner.detectAmount(priceDiff);//player will pay only delta or upgrdation charges
        bank.addAmount(priceDiff);

        return newUpgradedHotel;
    }

    public static void transferRent(Hotel hotel, Player tenant) {

        Integer rent = hotel.getRent();
        tenant.detectAmount(rent);
        hotel.getOwner().addAmount(rent);

    }
}

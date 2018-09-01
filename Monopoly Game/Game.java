import board.Bank;
import board.Board;
import board.square.HotelSquare;
import board.square.JailSquare;
import board.square.LotterySquare;
import board.square.Square;
import player.Player;

/**
 * Created by vishal on 15-Aug-18.
 */
public class Game {

    private Bank centralBank;
    private Board board;
    private Player players[];
    private Integer[] diceOutputs;

    public Game(Player players[], Board board, Bank bank, Integer[] diceOutputs) {
        this.centralBank = bank;
        this.board = board;
        this.players = players;
        this.diceOutputs = diceOutputs;
    }

    public void start() {

        for (int i = 0; i < diceOutputs.length; i++) {
            int newPosition = players[i % 3].movePlayer(diceOutputs[i]);
            board.getSquares()[newPosition].action(players[i % 3], centralBank);
            System.out.println("=============================");
        }

        //After all moves,check for player with max socre
        Player winner = null;
        Integer maxAmount = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if (players[i].getAmount() > maxAmount) {
                maxAmount = players[i].getAmount();
                winner = players[i];
            }
        }

        System.out.println("Player " + winner.getId() + "has won the game");
    }

    public static void main(String[] args) {

        Integer diceOutputs[] = {2, 2, 1, 4, 4, 2, 4, 4, 2, 2, 2, 1, 4, 4, 2, 4, 4, 2, 2, 2, 1};
        Game game = new Game(createPlayers(), createBoard(), new Bank(5000), diceOutputs);
        game.start();
    }

    private static Player[] createPlayers() {

        Player player1 = new Player(1, 1000, -1);
        Player player2 = new Player(2, 1000, -1);
        Player player3 = new Player(3, 1000, -1);

        Player players[] = new Player[3];
        players[0] = player1;
        players[1] = player2;
        players[2] = player3;

        return players;
    }

    private static Board createBoard() {

        Square squares[] = new Square[10];
        squares[0] = new JailSquare();
        squares[1] = new HotelSquare();
        squares[2] = new LotterySquare();
        squares[3] = new LotterySquare();
        squares[4] = new Square();
        squares[5] = new LotterySquare();
        squares[6] = new Square();
        squares[7] = new LotterySquare();
        squares[8] = new Square();
        squares[9] = new JailSquare();

        return new Board(squares);
    }

}















import java.util.*;

public class Game {

    private List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }


    public int round(String playerName1, String playerName2) {


        Player player1 = null;
        Player player2 = null;
        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException(
                    "Игрок " + playerName1 + " не найден"
            );
        }
        if (player2 == null) {
            throw new NotRegisteredException(
                    "Игрок " + playerName2 + "не найден"
            );
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }

        return 0;
    }


}


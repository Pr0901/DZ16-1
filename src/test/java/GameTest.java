import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game = new Game();


    @Test
    void roundWinFirst() {
        Player player1 = new Player(1, "Петр", 300);
        Player player2 = new Player(2, "Ольга", 200);
        Player player3 = new Player(3, "Мария", 500);

        game.register(player1);
        game.register(player2);
        game.register(player3);

        int expected = 1;
        int actual = game.round("Петр", "Ольга");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void roundWinSecond() {
        Player player1 = new Player(1, "Петр", 100);
        Player player2 = new Player(2, "Ольга", 200);
        Player player3 = new Player(3, "Мария", 500);

        game.register(player1);
        game.register(player2);
        game.register(player3);

        int expected = 2;
        int actual = game.round("Петр", "Ольга");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void roundWinDraw() {
        Player player1 = new Player(1, "Петр", 100);
        Player player2 = new Player(2, "Ольга", 100);
        Player player3 = new Player(3, "Мария", 500);

        game.register(player1);
        game.register(player2);
        game.register(player3);

        int expected = 0;
        int actual = game.round("Петр", "Ольга");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findNothingToPlayerFirst() {
        Player player1 = new Player(1, "Петр", 100);
        Player player2 = new Player(2, "Ольга", 100);
        Player player3 = new Player(3, "Мария", 500);

        game.register(player1);
        game.register(player2);


        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Петр", "Мария");
        });
    }

    @Test
    void findNothingToPlayerSecond() {
        Player player1 = new Player(1, "Петр", 100);
        Player player2 = new Player(2, "Ольга", 100);
        Player player3 = new Player(3, "Мария", 500);

        game.register(player3);
        game.register(player2);


        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Петр", "Мария");
        });
    }


}
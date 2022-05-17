package ru.netology.tournament.game;

import org.junit.jupiter.api.Test;
import ru.netology.tournament.data.Player;
import ru.netology.tournament.exception.NotRegisteredException;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void roundForSecondPlayerVictory() {
        Game game = new Game();
        Player player1 = new Player(1, "Коля", 50);
        Player player2 = new Player(2, "Миша", 70);
        game.register(player1);
        game.register(player2);
        int expected = 2;
        int actual = game.round("Коля", "Миша");
        assertEquals(expected, actual);
    }

    @Test
    void roundForThirstPlayerVictory() {
        Game game = new Game();
        Player player1 = new Player(1, "Коля", 90);
        Player player2 = new Player(2, "Миша", 70);
        game.register(player1);
        game.register(player2);
        int expected = 1;
        int actual = game.round("Коля", "Миша");
        assertEquals(expected, actual);
    }

    @Test
    void roundForDrawGame() {
        Game game = new Game();
        Player player1 = new Player(1, "Коля", 70);
        Player player2 = new Player(2, "Миша", 70);
        game.register(player1);
        game.register(player2);
        int expected = 0;
        int actual = game.round("Коля", "Миша");
        assertEquals(expected, actual);
    }

    @Test
    void roundForNotRegisteredPlayers1() {
        Game game = new Game();
        Player player1 = new Player(1, "Коля", 50);
        Player player2 = new Player(2, "Миша", 70);
        game.register(player1);
        game.register(player2);
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Петя", "Миша");
        });
    }

    @Test
    void roundForNotRegisteredPlayers2() {
        Game game = new Game();
        Player player1 = new Player(1, "Коля", 50);
        Player player2 = new Player(2, "Миша", 70);
        game.register(player1);
        game.register(player2);
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Коля", "Петя");
        });
    }
}
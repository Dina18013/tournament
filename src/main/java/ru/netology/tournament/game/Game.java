package ru.netology.tournament.game;

import ru.netology.tournament.data.Player;
import ru.netology.tournament.exception.NotRegisteredException;

import java.util.ArrayList;
import java.util.Collection;

public class Game {

    private Collection<Player> players = new ArrayList<>();

    public Game() {
    }

    public Game(Collection<Player> players) {
        this.players = players;
    }

    public Collection<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Collection<Player> players) {
        this.players = players;
    }

    public void register(Player player) {
        players.add(player);
    }

    public int strengthPlayer(String playerName) {
        for (Player player : players) {
            if (player.getName() == playerName) {
                int strengthPlayer = player.getStrength();
                return strengthPlayer;
            }
        }
        return 0;
    }

    public int round(String playerName1, String playerName2) {
        int strengthPlayer1 = strengthPlayer(playerName1);
        int strengthPlayer2 = strengthPlayer(playerName2);

        if (strengthPlayer1 == 0) {
            throw new NotRegisteredException("Первый игрок не зарегистрирован!");
        }
        if (strengthPlayer2 == 0) {
            throw new NotRegisteredException("Второй игрок не зарегистрирован!");
        }
        if (strengthPlayer1 > strengthPlayer2) {
            return 1;
        }
        if (strengthPlayer1 < strengthPlayer2) {
            return 2;
        }
        return 0;
    }
}

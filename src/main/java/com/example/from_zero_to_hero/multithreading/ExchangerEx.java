package com.example.from_zero_to_hero.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerEx {
    public static void main(String[] args) {
        Exchanger<Action> exchanger = new Exchanger<>();

        List<Action> friend1Actions = new ArrayList<>();
        friend1Actions.add(Action.NOJNICY);
        friend1Actions.add(Action.BUMAGA);
        friend1Actions.add(Action.NOJNICY);

        List<Action> friend2Actions = new ArrayList<>();
        friend2Actions.add(Action.BUMAGA);
        friend2Actions.add(Action.KAMEN);
        friend2Actions.add(Action.KAMEN);

        new BestFriend("Vanya", exchanger, friend1Actions);
        new BestFriend("Petya", exchanger, friend2Actions);
    }
}

enum Action {
    KAMEN, NOJNICY, BUMAGA;
}

class BestFriend extends Thread {
    private String name;
    private List<Action> myActions;
    private Exchanger<Action> exchanger;

    public BestFriend(String name, Exchanger<Action> exchanger, List<Action> actions) {
        this.exchanger = exchanger;
        this.name = name;
        this.myActions = actions;
        this.start();
    }

    private void whoWins(Action myAction, Action friendAction) {
        if (myAction == Action.KAMEN && friendAction == Action.NOJNICY
                || myAction == Action.NOJNICY && friendAction == Action.BUMAGA
                || myAction == Action.BUMAGA && friendAction == Action.KAMEN) {
            System.out.println(name + " wins!");
        }
    }

    public void run() {
        Action reply;
        for (Action action : myActions) {
            try {
                reply = exchanger.exchange(action);
                whoWins(action, reply);
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


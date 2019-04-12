package org.academiadecodigo.bootcamp22.sniperelite;

import org.academiadecodigo.bootcamp22.sniperelite.gameobjects.Destroyable;
import org.academiadecodigo.bootcamp22.sniperelite.gameobjects.GameObject;
import org.academiadecodigo.bootcamp22.sniperelite.gameobjects.ObjectFactory;

public class Game {

    private GameObject[] gameObjects;

    private SniperRifle sniperRifle;

    private int shotsFired;

    public void start() {

        shootObjects();
        System.out.println("Total shots fired: " + shotsFired);
    }

    private void createObjects(int objects) {

        this.gameObjects = new GameObject[objects];
        for (int i = 0; i < objects; i++) {

            gameObjects[i] = ObjectFactory.randomGameObject();
        }
    }

    public Game(SniperRifle sniperRifle, int objects) {

        if (objects < 1) {

            System.out.println("You need at least 1 game object");
            return;
        }

        createObjects(objects);
        this.sniperRifle = sniperRifle;
    }

    private void shootObjects() {

        for (int i = 0; i < gameObjects.length; i++) {

            if (gameObjects[i] instanceof Destroyable) {

                while (!((Destroyable) gameObjects[i]).isDestroyed()) {

                    System.out.println(sniperRifle.shoot((Destroyable) gameObjects[i])
                            ? gameObjects[i].getMessage()
                            : "Missed shot\n");
                    shotsFired++;
                }
            }
        }
    }
}

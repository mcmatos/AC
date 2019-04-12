package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.car.Car;
import org.academiadecodigo.bootcamp.car.CarFactory;
import org.academiadecodigo.bootcamp.car.PlayerCar;
import org.academiadecodigo.bootcamp.gfx.simplegfx.SimpleGfxColorMapper;
import org.academiadecodigo.bootcamp.gfx.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridFactory;
import org.academiadecodigo.bootcamp.grid.GridType;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

/**
 * The game logic
 */
public class Game {


    /**
     * Graphical Car field
     */
    private Grid grid;

    /**
     * Container of Cars
     */
    private Car[] cars;

    /**
     * Animation delay
     */
    private int delay;

    /**
     * The collision detector
     */
    private CollisionDetector collisionDetector;

    /**
     * Number of cars to manufacture
     */
    private int manufacturedCars = 20;

    private Player player;


    /**
     * Constructs a new game
     * @param gridType which grid type to use
     * @param cols number of columns in the grid
     * @param rows number of rows in the grid
     * @param delay animation delay
     */
    Game(GridType gridType, int cols, int rows, int delay) {

        grid = GridFactory.makeGrid(gridType, cols, rows);
        this.delay = delay;

    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init(Player player) {

        grid.init();

        cars = new Car[manufacturedCars];
        collisionDetector = new CollisionDetector(cars);
        this.player = player;
        for (int i = 0; i < manufacturedCars; i++) {

            if (i == 0) {
                cars[i] = player.getPlayerCar(grid);
                continue;
            }

            cars[i] = CarFactory.getNewCar(grid);
            cars[i].setCollisionDetector(collisionDetector);
            cars[i].setGrid(grid);

        }

    }

    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        /*if (grid instanceof SimpleGfxGrid) {

            startDelay();
        }*/


        while (true) {

            // Pause for a while
            Thread.sleep(delay);

            moveAllCars();

        }

    }

    /**
     * Moves all cars
     */
    public void moveAllCars() {

        for (Car c : cars) {
            c.move();
            collisionDetector.check(c);
        }

    }

    private void startDelay() throws InterruptedException {

        Text timer = new Text(SimpleGfxGrid.columnToX(grid.getCols())/2, SimpleGfxGrid.rowToY(grid.getRows())/2, "3");
        timer.setColor(Color.RED);
        timer.grow(20, 20);
        timer.draw();

        Thread.sleep(1000);
        timer.delete();
        timer.setText("2");
        timer.draw();

        Thread.sleep(1000);
        timer.delete();
        timer.setText("1");
        timer.draw();

        Thread.sleep(1000);
        timer.delete();

    }
}

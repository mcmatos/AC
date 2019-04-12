package org.academiadecodigo.bootcamp22.MapEditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Player implements KeyboardHandler {

    private Rectangle cursor;
    private float cellSize;
    private int size;
    private byte[] buffer;
    private int PADDING;
    private int cell;
    private FileInputStream inputStream;
    private FileOutputStream outputStream;
    private Rectangle[] marked;

    private final int KEY_UP;
    private final int KEY_DOWN;
    private final int KEY_LEFT;
    private final int KEY_RIGHT;
    private final int PAINT;
    private final int SAVE;
    private final int LOAD;

    public Player(int padding, int size, float cellSize) {

        this.cellSize = cellSize;
        this.size = size;
        this.PADDING = padding;

        cursor = new Rectangle(10, 10, cellSize, cellSize);
        marked = new Rectangle[(int) ((size / cellSize) * (size / cellSize))];


        this.buffer = new byte[(int) ((size / cellSize) * (size / cellSize)) + 1];


        cursor.setColor(Color.RED);
        cursor.fill();

        this.KEY_UP = KeyboardEvent.KEY_UP;
        this.KEY_DOWN = KeyboardEvent.KEY_DOWN;
        this.KEY_LEFT = KeyboardEvent.KEY_LEFT;
        this.KEY_RIGHT = KeyboardEvent.KEY_RIGHT;
        this.PAINT = KeyboardEvent.KEY_SPACE;
        this.SAVE = KeyboardEvent.KEY_S;
        this.LOAD = KeyboardEvent.KEY_L;

        Keyboard k = new Keyboard(this);

        KeyboardEvent UP = new KeyboardEvent();
        UP.setKey(this.KEY_UP);
        UP.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent DOWN = new KeyboardEvent();
        DOWN.setKey(this.KEY_DOWN);
        DOWN.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent LEFT = new KeyboardEvent();
        LEFT.setKey(this.KEY_LEFT);
        LEFT.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent RIGHT = new KeyboardEvent();
        RIGHT.setKey(this.KEY_RIGHT);
        RIGHT.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent PAINT = new KeyboardEvent();
        PAINT.setKey(this.PAINT);
        PAINT.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent SAVE = new KeyboardEvent();
        SAVE.setKey(this.SAVE);
        SAVE.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent DELETE = new KeyboardEvent();
        DELETE.setKey(this.LOAD);
        DELETE.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k.addEventListener(UP);
        k.addEventListener(DOWN);
        k.addEventListener(LEFT);
        k.addEventListener(RIGHT);
        k.addEventListener(PAINT);
        k.addEventListener(SAVE);
        k.addEventListener(DELETE);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KEY_UP) {
            if (cursor.getY() > PADDING)
                cursor.translate(0, -cellSize);

        }

        if (keyboardEvent.getKey() == KEY_DOWN) {
            if (cursor.getY() < size - cellSize)
                cursor.translate(0, cellSize);
        }

        if (keyboardEvent.getKey() == KEY_LEFT) {
            if (cursor.getX() > PADDING)
                cursor.translate(-cellSize, 0);
        }

        if (keyboardEvent.getKey() == KEY_RIGHT) {
            if (cursor.getX() < size - cellSize)
                cursor.translate(cellSize, 0);
        }

        if (keyboardEvent.getKey() == PAINT) {

            this.cell = (int) ((cursor.getX() / cellSize) + ((int) ((cursor.getY()) / cellSize) * 10));

            if (buffer[cell] != 0) {
                buffer[cell] = 0;
                marked[cell].delete();
                marked[cell] = null;
                return;
            }

            marked[cell] = new Rectangle(cursor.getX(), cursor.getY(), cellSize, cellSize);

            /*for (int i = 0; i < buffer.length; i++) {

                if (buffer[i] != 0) {
                    buffer[i] = 1;
                }
            }*/

            buffer[cell] = 1;
            marked[cell].fill();
            cursor.delete();
            cursor.fill();
        }

        if (keyboardEvent.getKey() == SAVE) {

            try {
                outputStream = new FileOutputStream("Resources/MapEditor");

            } catch (IOException e) {

                e.printStackTrace();
            }

            try {
                outputStream.write(buffer);
                outputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (keyboardEvent.getKey() == LOAD) {

            try {
                inputStream = new FileInputStream("Resources/MapEditor");

            } catch (IOException e) {

                e.printStackTrace();
            }

            try {
                inputStream.read(buffer);
                inputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < buffer.length -1; i++) {

                if (marked[i] != null) {
                    marked[i].delete();
                    marked[i] = null;
                }

                if (buffer[i] == 1) {

                    int n = (int) Math.floor(i / 10);
                    marked[i] = new Rectangle(((i  - (n * 10)) * cellSize) + PADDING, (n * cellSize) + PADDING, cellSize, cellSize);
                    marked[i].fill();
                }
            }
        }
    }

        @Override
        public void keyReleased (KeyboardEvent keyboardEvent){

        }
    }

package org.academiadecodigo.bootcamp22.MapEditor;

public class MapEditor {

    private Field field;
    private Player player;
    private float cellSize;
    private final int PADDING = 10;

    public MapEditor(int size) {

        this.cellSize = (float) (size / 10);
        field = new Field(PADDING, size, cellSize);
        player = new Player(PADDING, size, cellSize);

    }

    public void start() {
        field.paintField();
    }
}


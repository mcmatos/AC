package org.academiadecodigo.bootcamp22.MapEditor;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {

    private Rectangle rectangle;
    private int PADDING;
    private float cellSize;
    private int size;

    public Field(int padding, int size, float cellSize) {

        this.PADDING = padding;
        this.cellSize = cellSize;
        this.size = size;
        rectangle = new Rectangle(PADDING, PADDING, size, size);

    }

    public void paintField() {

        rectangle.draw();

        for (double i = PADDING; i <= size; i += cellSize) {

            for (double j = PADDING;  j <= size; j += cellSize) {

                new Rectangle(i, j , cellSize, cellSize).draw();
            }
        }
    }
}

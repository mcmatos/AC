package org.academiadecodigo.bootcamp.gfx.simplegfx;

import org.academiadecodigo.bootcamp.grid.GridColor;
import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.bootcamp.grid.position.AbstractGridPosition;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Simple graphics position
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;

    /**
     * Simple graphics position constructor
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(SimpleGfxGrid grid){

        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);
        simpleGfxGrid = grid;
        this.rectangle = new Rectangle(grid.getX() + grid.columnToX(super.getCol()), grid.getY() + grid.rowToY(super.getRow()),  grid.getCellSize(), grid.getCellSize());
        rectangle.draw();
    }

    /**
     * Simple graphics position constructor
     * @param col position column
     * @param row position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid) {

        super(col, row, grid);
        simpleGfxGrid = grid;
        this.rectangle = new Rectangle(grid.getX() + grid.columnToX(col), grid.getY() + grid.rowToY(row), grid.getCellSize(), grid.getCellSize());
        rectangle.draw();
    }

    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {
        rectangle.fill();
    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
        rectangle.delete();
    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */

    @Override
    public void moveInDirection(GridDirection direction, int distance) {

        int lastRow = getRow();
        int lastCol = getCol();
        super.moveInDirection(direction, distance);
        rectangle.translate(simpleGfxGrid.columnToX(getCol() - lastCol), simpleGfxGrid.rowToY(getRow() - lastRow));
    }

    /**
     * @see AbstractGridPosition#setColor(GridColor)
     */
    @Override
    public void setColor(GridColor color) {

        rectangle.setColor(SimpleGfxColorMapper.getColor(color));
        super.setColor(color);
    }
}

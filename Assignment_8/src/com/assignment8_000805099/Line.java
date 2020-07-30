package com.assignment8_000805099;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Implementation of Line class
 * @author Andy Le
 */
public class Line extends Shape{
    /**
     * No argument constructor for Line
     */
    public Line() {
        System.out.println("Line no-arg constructor.");
    }

    /**
     * Line class constructor
     * @param x
     * @param y
     * @param width
     * @param height
     * @param colorF
     * @param colorS
     */
    public Line(double x, double y, double width, double height, Color colorF, Color colorS) {
        super.setX(x);
        super.setY(y);
        super.setWidth(width);
        super.setHeight(height);
        super.setColorF(colorF);
        super.setColorS(colorS);
    }

    /**
     * Method to draw Line
     * @param gc
     */
    public void draw(GraphicsContext gc) {
        gc.strokeLine(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }
}

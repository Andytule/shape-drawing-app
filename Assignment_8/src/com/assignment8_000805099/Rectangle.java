package com.assignment8_000805099;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Implementation of Rectangle class which extends Shape abstract class
 * @author Andy Le
 */
public class Rectangle extends Shape{
    /**
     * No arguments constructor for Rectangle
     */
    public Rectangle() {
        System.out.println("Rectangle no-arg constructor.");
    }

    /**
     * Rectangle constructor
     * @param x
     * @param y
     * @param width
     * @param height
     * @param colorF
     * @param colorS
     */
    public Rectangle(double x, double y, double width, double height, Color colorF, Color colorS) {
        super.setX(x);
        super.setY(y);
        super.setWidth(width);
        super.setHeight(height);
        super.setColorF(colorF);
        super.setColorS(colorS);
    }

    /**
     * Method to draw Rectangle
     * @param gc
     */
    public void draw(GraphicsContext gc) {
        gc.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
        gc.strokeRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }
}

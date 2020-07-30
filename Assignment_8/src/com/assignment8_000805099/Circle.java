package com.assignment8_000805099;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Implementation of Circle class which Extends Shape abstract class
 * @author Andy Le
 */
public class Circle extends Shape{
    /**
     * No argument constructor for Circle
     */
    public Circle() {
        System.out.println("Circle no-arg constructor.");
    }

    /**
     * Circle class constructor
     * @param x
     * @param y
     * @param width
     * @param height
     * @param colorF
     * @param colorS
     */
    public Circle(double x, double y, double width, double height, Color colorF, Color colorS) {
        super.setX(x);
        super.setY(y);
        super.setWidth(width);
        super.setHeight(height);
        super.setColorF(colorF);
        super.setColorS(colorS);
    }

    /**
     * Method to draw Circle
     * @param gc
     */
    public void draw(GraphicsContext gc) {
        gc.fillOval(super.getX(), super.getY(), super.getWidth(), super.getHeight());
        gc.strokeOval(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }
}

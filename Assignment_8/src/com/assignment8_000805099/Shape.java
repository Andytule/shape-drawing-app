package com.assignment8_000805099;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Implementaiton of Shape abstract class which implements Drawing interface
 * @author Andy Le
 */
public abstract class Shape implements Drawing {
    /** X **/
    private double x;
    /** Y **/
    private double y;
    /** Width **/
    private double width;
    /** Height **/
    private double height;
    /** Color Fill **/
    private Color colorF;
    /** Color Stroke **/
    private Color colorS;

    /**
     * No argument constructor of Shape
     */
    public Shape() {
        System.out.println("\n");
    }

    /**
     * Constructor for Shape
     * @param x
     * @param y
     * @param width
     * @param height
     * @param colorF
     * @param colorS
     */
    public Shape(double x, double y, double width, double height, Color colorF, Color colorS) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.setColorF(colorF);
        this.setColorS(colorS);
    }

    /**
     * Method to get X
     * @return
     */
    @Override
    public double getX() {
        return x;
    }

    /**
     * Method to set X
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Method to get Y
     * @return
     */
    @Override
    public double getY() {
        return y;
    }

    /**
     * Method to set Y
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Method to get Width
     * @return
     */
    @Override
    public double getWidth() {
        return width;
    }

    /**
     * Method to set Width
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Method to get Height
     * @return
     */
    @Override
    public double getHeight() {
        return height;
    }

    /**
     * Method to set Height
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Method to get Fill Color
     * @return
     */
    public Color getColorF() {
        return colorF;
    }

    /**
     * Method to set Fill Color
     * @param colorF
     */
    public void setColorF(Color colorF) {
        this.colorF = colorF;
    }

    /**
     * Method to get Stroke Color
     * @return
     */
    public Color getColorS() {
        return colorS;
    }

    /**
     * Method to set Stroke Color
     * @param colorS
     */
    public void setColorS(Color colorS) {
        this.colorS = colorS;
    }

    /**
     * Method to draw shape
     * @param gc
     */
    public void draw(GraphicsContext gc) {

    }
}

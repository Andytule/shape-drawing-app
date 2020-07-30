package com.assignment8_000805099;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.ArrayList;


/**
 * Implemented a paint program.
 * @author Andy Le
 */
public class FXGUITemplate extends Application {

    // TODO: Instance Variables for View Components and Model
    Canvas c;
    Canvas trans;
    GraphicsContext gc;
    GraphicsContext transgc;
    private int buttonValue = 0;
    private Label fill, stroke;
    private Button rectBut, circleBut, lineBut, undo, clear;
    private Label r, g, b;
    private TextField txtfR, txtfG, txtfB, txtsR, txtsG, txtsB;
    private double x;
    private double y;
    private double pressX;
    private double pressY;
    private double width;
    private double height;
    private int shapeType = 0;
    private ArrayList<Shape> list = new ArrayList<Shape>();

    // TODO: Private Event Handlers and Helper Methods
    private void pressHandler(MouseEvent me) {
        if (me.getButton().equals(MouseButton.PRIMARY)) {
            pressX = me.getX();
            pressY = me.getY();
        }
    }

    private void releaseHandler(MouseEvent me) {
        if (shapeType == 0) {
            list.add(new Rectangle(x, y, width, height, Color.rgb(Integer.parseInt(txtfR.getText()),
                    Integer.parseInt(txtfG.getText()), Integer.parseInt(txtfB.getText())),
                    Color.rgb(Integer.parseInt(txtsR.getText()), Integer.parseInt(txtsG.getText()),
                            Integer.parseInt(txtsB.getText()))));
        } else if (shapeType == 1) {
            list.add(new Circle(x, y, width, height, Color.rgb(Integer.parseInt(txtfR.getText()),
                    Integer.parseInt(txtfG.getText()), Integer.parseInt(txtfB.getText())),
                    Color.rgb(Integer.parseInt(txtsR.getText()), Integer.parseInt(txtsG.getText()),
                            Integer.parseInt(txtsB.getText()))));
        } else if (shapeType == 2) {
            list.add(new Line(pressX, pressY, me.getX(), me.getY(), Color.rgb(Integer.parseInt(txtfR.getText()),
                    Integer.parseInt(txtfG.getText()), Integer.parseInt(txtfB.getText())),
                    Color.rgb(Integer.parseInt(txtsR.getText()), Integer.parseInt(txtsG.getText()),
                            Integer.parseInt(txtsB.getText()))));
        }
        System.out.println(list);
    }

    private void dragHandler(MouseEvent me) {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, 1000, 450);
        for (Shape i: list) {
            gc.setFill(i.getColorF());
            gc.setStroke(i.getColorS());
            i.draw(gc);
        }
        width = me.getX() - pressX;
        height = me.getY() - pressY;
        x = pressX;
        y = pressY;
        if (me.getX() < pressX) {
            width = pressX - me.getX();
            x = me.getX();
        }
        if (me.getY() < pressY) {
            height = pressY - me.getY();
            y = me.getY();
        }
        try {
            gc.setFill(Color.rgb(Integer.parseInt(txtfR.getText()),
                    Integer.parseInt(txtfG.getText()), Integer.parseInt(txtfB.getText())));
            gc.setStroke(Color.rgb(Integer.parseInt(txtsR.getText()), Integer.parseInt(txtsG.getText()),
                    Integer.parseInt(txtsB.getText())));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Illegal Argument Exception.");
            new Alert(Alert.AlertType.WARNING, "Invalid RGB Values.").showAndWait();
        }
        if (shapeType == 0) {
            gc.fillRect(x, y, width, height);
            gc.strokeRect(x, y, width, height);
        } else if (shapeType == 1) {
            gc.fillOval(x, y, width, height);
            gc.strokeOval(x, y, width, height);
        } else if (shapeType == 2) {
            gc.strokeLine(pressX, pressY, me.getX(), me.getY());
        }
    }

    private void rectBut(ActionEvent e) {
        shapeType = 0;
    }

    private void circleBut(ActionEvent e) {
        shapeType = 1;
    }

    private void lineBut(ActionEvent e) {
        shapeType = 2;
    }

    private void undoBut(ActionEvent e) {
        try {
            list.remove(list.size() - 1);
            gc.setFill(Color.WHITE);
            gc.fillRect(0, 0, 1000, 450);
            for (Shape i: list) {
                gc.setFill(i.getColorF());
                gc.setStroke(i.getColorS());
                i.draw(gc);
            }
        } catch (Exception f) {
            System.out.println("Caught Exception.");
            new Alert(Alert.AlertType.WARNING, "Nothing To Undo.").showAndWait();
        }
    }

    private void clearBut(ActionEvent e) {
        for (int i = list.size() - 1; i >= 0; i--) {
            list.remove(i);
        }
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, 1000, 450);
    }

    /**
     * This is where you create your components and the model and add event
     * handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 1000, 600); // set the size here
        stage.setTitle("Draw My Thing"); // set the window title here
        stage.setScene(scene);
        // TODO: Add your GUI-building code here

        // 1. Create the model

        // 2. Create the GUI components
        c = new Canvas(1000, 450);
        trans = new Canvas(1000, 450);
        gc = c.getGraphicsContext2D();
        transgc = trans.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, 1000, 450);
        rectBut = new Button("Rectangle");
        circleBut = new Button("Circle");
        lineBut = new Button("Line");
        undo = new Button("Undo");
        clear = new Button("Clear");
        fill = new Label("Fill");
        r = new Label("R");
        g = new Label("G");
        b = new Label("B");
        stroke = new Label("Stroke");
        txtfR = new TextField();
        txtfG = new TextField();
        txtfB = new TextField();
        txtsR = new TextField();
        txtsG = new TextField();
        txtsB = new TextField();

        // 3. Add components to the root
        root.getChildren().addAll(c, rectBut, circleBut, lineBut, undo, clear, fill, r, g, b, stroke, txtfR, txtfG, txtfB, txtsR, txtsG, txtsB);
        root.getChildren().add(trans);
        // 4. Configure the components (colors, fonts, size, location)
        rectBut.setPrefWidth(100);
        rectBut.relocate(50, 525);
        circleBut.setPrefWidth(100);
        circleBut.relocate(200, 525);
        lineBut.setPrefWidth(100);
        lineBut.relocate(350, 525);
        fill.relocate(525, 485);
        txtfR.setPrefWidth(40);
        txtfR.relocate(550, 480);
        txtfG.setPrefWidth(40);
        txtfG.relocate(600, 480);
        txtfB.setPrefWidth(40);
        txtfB.relocate(650, 480);
        r.relocate(560, 520);
        g.relocate(610, 520);
        b.relocate(660, 520);
        stroke.relocate(510, 555);
        txtsR.setPrefWidth(40);
        txtsR.relocate(550, 550);
        txtsG.setPrefWidth(40);
        txtsG.relocate(600, 550);
        txtsB.setPrefWidth(40);
        txtsB.relocate(650, 550);
        undo.setPrefWidth(75);
        undo.relocate(750, 525);
        clear.setPrefWidth(75);
        clear.relocate(850, 525);
        // 5. Add Event Handlers and do final setup
        trans.addEventHandler(MouseEvent.MOUSE_PRESSED, this::pressHandler);
        trans.addEventHandler(MouseEvent.MOUSE_RELEASED, this::releaseHandler);
        trans.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::dragHandler);
        rectBut.setOnAction(this::rectBut);
        circleBut.setOnAction(this::circleBut);
        lineBut.setOnAction(this::lineBut);
        undo.setOnAction(this::undoBut);
        clear.setOnAction(this::clearBut);
        // 6. Show the stage
        stage.show();
    }

    /**
     * Make no changes here.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}

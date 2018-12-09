import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class CartesianPanel extends JPanel {

    public static final int STEPS = 100;

    // x-axis coord constants
    public static final int X_AXIS_FIRST_X_COORD = 800;
    public static final int X_AXIS_SECOND_X_COORD = 1900;
    public static final int X_AXIS_Y_COORD = 500;

    // y-axis coord constants
    public static final int Y_AXIS_FIRST_Y_COORD = 0;
    public static final int Y_AXIS_SECOND_Y_COORD = 500;
    public static final int Y_AXIS_X_COORD = 800;

    //arrows of axis are represented with "hipotenuse" of
    //triangle
    // now we are define length of cathetas of that triangle
    public static final int FIRST_LENGHT = 10;
    public static final int SECOND_LENGHT = 5;

    // size of start coordinate lenght
    public static final int ORIGIN_COORDINATE_LENGHT = 6;

    // distance of coordinate strings from axis
    public static final int AXIS_STRING_DISTANCE = 20;

    // numerate axis
    public int xCoordNumbers = 1000;
    public int yCoordNumbers = 450;
    public int xLength = (X_AXIS_SECOND_X_COORD - X_AXIS_FIRST_X_COORD)
            / xCoordNumbers;
    public int yLength = (Y_AXIS_SECOND_Y_COORD - Y_AXIS_FIRST_Y_COORD)
            / yCoordNumbers;


    private List<Point> points = new ArrayList<>();

    public void drawPoint(List<Point> point) {
        points.addAll(point);
        repaint();
    }

    private void drawPointOnPanel(Point point, Graphics g) {
        final int pointDiameter = 5;
        final int x = X_AXIS_FIRST_X_COORD + (point.x * xLength) - pointDiameter / 2;
        final int y = Y_AXIS_SECOND_Y_COORD - (point.y * yLength) - pointDiameter / 2;
        g.setColor(point.color);
        g.fillOval(x, y, pointDiameter, pointDiameter);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // x-axis
        g2.drawLine(0, X_AXIS_Y_COORD,
                X_AXIS_SECOND_X_COORD, X_AXIS_Y_COORD);
        // y-axis
        g2.drawLine(Y_AXIS_X_COORD, Y_AXIS_FIRST_Y_COORD,
                Y_AXIS_X_COORD, 1000);

        // draw origin Point
        g2.fillOval(
                X_AXIS_FIRST_X_COORD - (ORIGIN_COORDINATE_LENGHT / 2),
                Y_AXIS_SECOND_Y_COORD - (ORIGIN_COORDINATE_LENGHT / 2),
                ORIGIN_COORDINATE_LENGHT, ORIGIN_COORDINATE_LENGHT);


        // draw x-axis numbers
        for(int i = -xCoordNumbers; i <= xCoordNumbers; i++) {
            if(abs(i) % STEPS == 0) {
                g2.drawLine(X_AXIS_FIRST_X_COORD + (i * xLength),
                        X_AXIS_Y_COORD - SECOND_LENGHT,
                        X_AXIS_FIRST_X_COORD + (i * xLength),
                        X_AXIS_Y_COORD + SECOND_LENGHT);
                g2.drawString(Integer.toString(i),
                        X_AXIS_FIRST_X_COORD + (i * xLength) - 3,
                        X_AXIS_Y_COORD + AXIS_STRING_DISTANCE);
            }
        }

        //draw y-axis numbers
        for(int i = -yCoordNumbers; i <= yCoordNumbers; i++) {
            if(abs(i) % STEPS == 0){
                g2.drawLine(Y_AXIS_X_COORD - SECOND_LENGHT,
                        Y_AXIS_SECOND_Y_COORD - (i * yLength),
                        Y_AXIS_X_COORD + SECOND_LENGHT,
                        Y_AXIS_SECOND_Y_COORD - (i * yLength));
                g2.drawString(Integer.toString(i),
                        Y_AXIS_X_COORD - AXIS_STRING_DISTANCE,
                        Y_AXIS_SECOND_Y_COORD - (i * yLength));
            }

        }

        // draw points
        points.forEach(p -> drawPointOnPanel(p, g));
    }

}
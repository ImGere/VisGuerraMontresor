import javax.swing.SwingUtilities;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Cartesian {
    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        try {
            List<String> allLines = Files.readAllLines(Paths.get("input.txt"));
            String[] numbersCS = allLines.get(0).split("\\s+");
            for (int i = 1; i <= Integer.parseInt(numbersCS[0]); i++){
                String[] coords = allLines.get(i).split("\\s+");
                points.add(new Point(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), Color.BLACK));
            }
            for (int i = Integer.parseInt(numbersCS[0]) + 1; i <= Integer.parseInt(numbersCS[1]) + Integer.parseInt(numbersCS[0]); i++){
                String[] coords = allLines.get(i).split("\\s+");
                points.add(new Point(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), Color.RED));
            }
            String[] coordsTarget = allLines.get(allLines.size() - 1).split("\\s+");
            Point target = new Point(Integer.parseInt(coordsTarget[0]), Integer.parseInt(coordsTarget[1]), Color.MAGENTA);
            points.add(target);
            for (Point p : points) {
                System.out.println(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                CartesianFrame frame = new CartesianFrame();
                frame.showUI();

                frame.panel.drawPoint(points);
            }
        });
    }

}


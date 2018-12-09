import javax.swing.*;

public class CartesianFrame extends JFrame {
    CartesianPanel panel;

    public CartesianFrame() {
        panel = new CartesianPanel();
        panel.setAutoscrolls(true);
        add(panel);
    }

    public void showUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Cartesian");
        setSize(2000, 1100);
        setVisible(true);
    }
}
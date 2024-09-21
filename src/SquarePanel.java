import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

@Getter
@Setter
class SquarePanel extends JPanel {

    ArrayList<Integer> array;
    ArrayList<Boolean> booleans;

    public SquarePanel(ArrayList<Integer> array, ArrayList<Boolean> booleans) {
        this.array = array;
        this.booleans = booleans;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int col = 0; col < array.size(); col++) {
            MySquare square = new MySquare(10, array.get(col));
            if (booleans.get(col) == Boolean.TRUE) {
                square.setFillColor(Color.RED);
            }
            square.draw(g, col, 0);
        }
    }

    public void updateArray() {
        repaint(); // Перерисовываем панель каждый раз, когда обновляем массив
    }

}
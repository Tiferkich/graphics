import java.awt.*;
import java.awt.geom.AffineTransform;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
@AllArgsConstructor
public class MySquare {
    private int width;
    private int height;
    private int borderWidth = 2;
    int padding = 10;
    private Color borderColor = Color.BLACK;
    private Color fillColor = Color.green;

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public MySquare(int width, int height) {
        this.width = width;
        this.height = height;
    }



    public void draw(Graphics g, int x, int y) {


        // Рисуем обводку

        g.setColor(borderColor);
        g.fillRect(x - 1 + x * padding, y - 1 + y * padding, width + borderWidth, height + borderWidth);

        // Рисуем квадрат внутри обводки
        g.setColor(fillColor);
        g.fillRect(x + x * padding, y + y * padding, width, height);
    }
}
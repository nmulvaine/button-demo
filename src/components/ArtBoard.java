package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class ArtBoard extends JPanel
{
    private java.util.List<Shape> shapes = new ArrayList<>();
    private java.util.List<StringShape> stringShape = new ArrayList<>();
    private Graphics2D g2D;

    class StringShape
    {
        String s;
        int x, y;

        public StringShape(String s, int x, int y)
        {
            this.s = s;
            this.x = x;
            this.y = y;
        }
    }

    public ArtBoard()
    {
        super.setSize(100, 100);


        addMouseListener(new MouseAdapter()
        {
            int x;
            int y;

            @Override
            public void mouseClicked(MouseEvent e)
            {

                StringShape s = new StringShape("Hello", e.getX(), e.getY());
                stringShape.add(s);
                repaint();

            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                x = e.getX();
                y = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                Shape s;
                s = new Line2D.Double(x, y, e.getX(), e.getY());
                shapes.add(s);
                repaint();
            }
        });
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2D = (Graphics2D) g;
        for (Shape s : shapes) {
            g2D.draw(s);
        }
        for (StringShape s : stringShape) {
            g2D.drawString(s.s, s.x, s.y);
        }
//
//        g2D.draw(new Line2D.Double(0, 0, getWidth(), getHeight()));
//        g2D.draw(new Line2D.Double(getWidth(), 0, 0, getHeight()));


    }

}

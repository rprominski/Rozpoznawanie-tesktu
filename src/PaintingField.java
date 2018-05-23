import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class PaintingField extends JPanel implements MouseMotionListener {
    int x,y,oldX, oldY;
    Image image;
    Graphics2D g2D;
    public PaintingField(){
        setPreferredSize((new Dimension(100,100)));
        addMouseMotionListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        if(g2D!=null)
        {
            g2D.drawLine(oldX,oldY,x,y);
            repaint();
            oldX = x;
            oldY = y;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        oldX = e.getX();
        oldY = e.getY();
    }

    @Override
    public void paintComponent(Graphics g) {
        if(image==null)
        {
            image=createImage(getSize().width, getSize().height);
            g2D = (Graphics2D) image.getGraphics();
            clear();
        }

        g.drawImage(image,0,0,null);
    }

    public void clear(){
        g2D.setPaint(Color.white);
        g2D.fillRect(0, 0,getSize().width, getSize().height);
        g2D.setPaint(Color.black);
        g2D.setStroke(new BasicStroke(5));
        repaint();
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
        g2D = (Graphics2D) image.getGraphics();
        g2D.setPaint(Color.black);
        g2D.setStroke(new BasicStroke(5));
        repaint();
    }
}

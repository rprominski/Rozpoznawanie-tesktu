import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

public class PaintingField extends JLabel {

    public PaintingField(){
        setOpaque(true);
        setBackground(Color.WHITE);
        setPreferredSize((new Dimension(100,100)));
        setVisible(true);
    }

}

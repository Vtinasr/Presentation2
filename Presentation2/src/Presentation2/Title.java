package Presentation2;

import javax.swing.JLabel;
import java.awt.*;

public class Title  extends JLabel{

    public Title(String title, Color backgroundColor){
        this.setText(title);
        this.setBackground(backgroundColor);
        this.setForeground(Color.BLACK);
        this.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setOpaque(true);
    }
}

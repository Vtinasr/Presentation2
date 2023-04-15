package Presentation2;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class GUIPresentation2 extends JFrame {


    private JButton myPhoto, myHobby, myExpectations;
    private JPanel containerImage;
    private Listener listener;

    private JLabel imageLabel;
    private JTextArea expectationsText;

    public GUIPresentation2() {
        initGUI();
        this.setTitle("My Presentation");
        this.setSize(600, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        Title Title = new Title("Valentina Sanchez Rosero", Color.WHITE);
        myPhoto = new JButton("This is me");
        myHobby = new JButton("This is my hobby");
        myExpectations = new JButton("What is my expectations");

        JPanel containerButtons = new JPanel();
        containerImage = new JPanel();
        listener = new Listener();
        imageLabel = new JLabel();
        expectationsText = new JTextArea(10, 12);

        containerImage.setBorder(BorderFactory.createTitledBorder(null, "About me", TitledBorder.CENTER,
                TitledBorder.DEFAULT_JUSTIFICATION, new Font(Font.MONOSPACED, Font.PLAIN, 20), Color.BLACK));
        containerImage.add(imageLabel);

        containerButtons.add(myPhoto);
        containerButtons.add(myHobby);
        containerButtons.add(myExpectations);


        myPhoto.addActionListener(listener);
        myHobby.addActionListener(listener);
        myExpectations.addActionListener(listener);

        myExpectations.addKeyListener(listener);
        myHobby.addKeyListener(listener);
        myPhoto.addKeyListener(listener);

        myHobby.addMouseListener(listener);


        this.add(Title, BorderLayout.NORTH);
        this.add(containerButtons, BorderLayout.SOUTH);
        this.add(containerImage, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUIPresentation2 myGui = new GUIPresentation2();
            }
        });
    }

    private class Listener implements ActionListener, KeyListener, MouseListener{
        private ImageIcon image;

        @Override
        public void actionPerformed(ActionEvent e) {
            imageLabel.setIcon(null);
            containerImage.remove(expectationsText);
            //JOptionPane.showMessageDialog(null, "Pressed button");
            if (e.getSource() == myPhoto) {
                System.out.println("Photo button pressed");
                this.image = new ImageIcon(getClass().getResource("/Recourses/Me(1).jpg"));
                imageLabel.setIcon(image);
            }


            revalidate();
            repaint();
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e){
            if(e.getKeyCode()==77){
            expectationsText.setText("Mis expectativas es poder entender  y amar Java\n");
            expectationsText.setBackground(null);
            expectationsText.setForeground(Color.BLACK);
            containerImage.add(expectationsText);}
        }


        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount()==2){
                this.image = new ImageIcon(getClass().getResource("/Recourses/Hobby(1).jpeg"));
                imageLabel.setIcon(image);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
        }
    }

package dynamic_beat_4;

import javax.swing.*;
import java.awt.*;

public class DynamicBeat extends JFrame {

    private Image screenImage;
    private Graphics screenGraphic;
    private Image introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
    //private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menubar.png")));
    //private JButton exitButton = new JButton(new ImageIcon(Main.class.getResource("../images/exitButton.jpg")));


    public DynamicBeat(){
        setUndecorated(true);
        setTitle("Dynamic Beats");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(new Color(0,0,0,0));
        setLayout(null);

        //define menubar position on background
        menuBar.setBounds(0,0,1280,30);
        add(menuBar);

        //define exit button on background
        //exitButton.setBounds(50,50,30,30);
        //add(exitButton);

        Music introMusic = new Music("dizzy.mp3", true);
        introMusic.start();
    }

    public void paint(Graphics g){
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage, 0, 0, null);
    }

    public void screenDraw(Graphics g){
        g.drawImage(introBackground, 0, 0, null);
        paintComponents(g);
        this.repaint();
    }

}

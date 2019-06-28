package racinggame;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.*;


public class RacingGame {

    public static void main(String[] args) throws InterruptedException {
        
        StartMusic("filepath");
        //pseudocode
        //display the images on screen
        //create a random speed at which they will move
        //on key press g to go
        //first to reach wins
        //game ends
        //ask to try again
        String answer;
        String ouput1;
        String ouput2;

        Object[] Options = {"Greencar",
            "Greycar",
            "Bluecar",};

        int Choice = JOptionPane.showOptionDialog(null,
                "which car do u choose to win",
                "Enter your car choice",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                Options,
                null);
        
        //DISPLAY THE IMAGES
//     	Jframe race = new Jframe("car racing game");  //this creates the frame
        JFrame race = new JFrame(); //create the frame
        race.setTitle("Asphalt 10");
        race.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         	// if you don't do this, your program will still run after you close the window
        race.setSize(1050, 550);	//determines the size of the background
        race.setBackground(Color.green);
        race.setResizable(false);
        race.setVisible(true);
        JButton button = new JButton("Clcik me");
        race.add(button);
        //use labels to hold the images
        JLabel Green = new JLabel();  // blue car image
        race.add(Green);
        int Greenposition = 0;    	//position of car before the race
        Green.setIcon(new ImageIcon("images/green1.png"));   //located in created folder images
        Green.setBounds((Greenposition), (70), Green.getPreferredSize().width, Green.getPreferredSize().height);
        JLabel Grey = new JLabel();
        race.add(Grey);
        
        int Greyposition = 0;
        Grey.setIcon(new ImageIcon("images/grey.png"));   //located in created folder images
        Grey.setBounds((Greyposition), (200), Grey.getPreferredSize().width, Grey.getPreferredSize().height);
        JLabel Blue = new JLabel();
        race.add(Blue);
        
        int Blueposition = 0;
        Blue.setIcon(new ImageIcon("images/blue.png"));   //located in created folder images
        Blue.setBounds((Blueposition), (350), Blue.getPreferredSize().width, Blue.getPreferredSize().height);  	//positon on x axis  	
        JLabel Background = new JLabel();
        race.add(Background);
        Background.setIcon(new ImageIcon("images/background.jpg"));   //located in created folder images
        Background.setBounds((0), (0), Background.getPreferredSize().width, Background.getPreferredSize().height);
        Random ran = new Random();
        
        
        //random number for speed of the cars   	
        int Greenacceleration = ran.nextInt(6) + 5;
        int Greyacceleration = ran.nextInt(6) + 5;
        int Blueacceleration = ran.nextInt(6) + 5;
        
        while (Greenposition <= 850 && Greyposition <= 850 && Blueposition <= 850) {
            Thread.sleep(50);
            Greenposition = Greenposition + Greenacceleration;
            Green.setBounds((Greyposition), (70), Green.getPreferredSize().width, Green.getPreferredSize().height);
            Greyposition = Greyposition + Greyacceleration;
            Grey.setBounds((Greyposition), (200), Grey.getPreferredSize().width, Grey.getPreferredSize().height);
            Blueposition = Blueposition + Blueacceleration;
            Blue.setBounds((Blueposition), (350), Blue.getPreferredSize().width, Blue.getPreferredSize().height);
        }
        
        if (Choice == 0 && Greenposition >= 850) {
            JOptionPane.showMessageDialog(null, "Green car wins", "", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        } else if (Choice == 1 && Greyposition >= 850) {
            JOptionPane.showMessageDialog(null, "grey car wins", "", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        } else if (Choice == 2 && Blueposition >= 850) {
            JOptionPane.showMessageDialog(null, "blue car wins", "", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "You lost the bet and your guess was wrong", "", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            
        }

        int Music;
        Music = ran.nextInt(4) + 1;
        switch (Music) {
            case 1:
                StartMusic("song/bamba.wav");
                break;
            case 2:
                StartMusic("song/lasagna.wav");
                break;
            case 3:
                StartMusic("song/oldtown.wav");
                break;
            case 4:
                StartMusic("song/spongebob.wav");
                break;
            default:
                break;
        }
    } 	//main method endds here
    //code for the options for car
    //creating a method for starting the music

    

    public static void StartMusic(String filepath) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         InputStream music;
        try {
            music = new FileInputStream(new File(filepath));
            AudioStream audios = new AudioStream(music);
            AudioPlayer.player.start(audios);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
}

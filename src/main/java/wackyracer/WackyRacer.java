package wackyracer;

import 
        javax.swing.JButton;

import 
        javax.swing.JFrame;

import 
        java.awt.BorderLayout;

import java.awt.Color;

import
        java.awt.event.ActionEvent;
import 
        javax.swing.JOptionPane;

public class WackyRacer {
    
    public static String imagePath[] = 
    {
    "images/speeder.png",//Teleporter
    "images/wiz.png",//Dragon
    "images/hk.png",//Hulk
    "images/shrinkk.png",//Flash
    "images/shil.png",//Freezer
    "images/rs.png",//Rocket
    "images/tr.png", //Inverter
    "images/turtle.png",//Shield
    "images/tk.png",//Topler
    "images/shifter.png"//Ghost
    };

    public static int speed[] =
    {
    8,
    8,
    12,
    8,
    8,
    8,
    8, 
    8,
    8,
    8//----------------  Ghost -------------------------//10
    };
    
    public static void main(String args[]) throws InterruptedException{
        
    JFrame frame = new JFrame("Wacky Racer Game");
    //-------- Set the size of the frame to fullscreen ----------//
    
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);

    //--------------- Create a new RaceTrack object ------------//
    RaceTrack track = new RaceTrack();

    //-------------- Create characters-------------------------
    createCharacters(track);

    //------------ Add a start and init button------------------//
    JButton startButton = new JButton("Start");
    JButton stopButton = new JButton("Stop");
    
    startButton.setVisible(true);
    stopButton.setEnabled(false);
    
    //----------------Add a actionlister to button-----------//
    startButton.addActionListener((ActionEvent e) -> {
        track.startRace();
        
        startButton.setVisible(false);
        stopButton.setEnabled(true);
    });
    
    stopButton.addActionListener((ActionEvent e) -> {
        track.stopRace();
        int flag = JOptionPane.showConfirmDialog(null, "Are you sure you want to stop the race?",
                "Stop the game", JOptionPane.YES_NO_OPTION);

        if (flag == JOptionPane.YES_OPTION) {
            InitRace(track);
            startButton.setVisible(true);
            stopButton.setEnabled(false);
        }
        else
        {
            track.startRace();
        }
    });
    
    frame.
            add(startButton, 
            BorderLayout.NORTH);
    frame.
            add(stopButton, 
            BorderLayout.SOUTH);
    
    frame.
            add(track);

    frame.
            setVisible(true);
}
    
    public static void InitRace(RaceTrack track)
    {
        WackyCharacter character;
        int y=1000;
        
        for(int i=0 ;i < track.getCharacters().size(); i++){
            character=track.getCharacters().get(i);
            character.setX(1800);
            character.setY(y-=100);
            character.setSpeed(speed[i]);
        }
    }

    private static void createCharacters(RaceTrack track) {
    //-------------- add character ------------//
        track.addCharacter(new TheTeleporter(JFrame.MAXIMIZED_HORIZ+1800, 900, 50, 30, imagePath[0], Color.BLUE, speed[0]));
        track.addCharacter(new TheSpeedster(JFrame.MAXIMIZED_HORIZ+1800, 800, 50, 30, imagePath[1], Color.WHITE, speed[1]));
        track.addCharacter(new TheHulk(JFrame.MAXIMIZED_HORIZ+1800, 700, 50, 30, imagePath[2], Color.WHITE, speed[2]));
        track.addCharacter(new TheFlash(JFrame.MAXIMIZED_HORIZ+1800, 600, 50, 30, imagePath[3], Color.WHITE, speed[3]));
        track.addCharacter(new TheFreezer(JFrame.MAXIMIZED_HORIZ+1800, 500, 50, 30, imagePath[4], Color.WHITE, speed[4]));
        track.addCharacter(new TheRocket(JFrame.MAXIMIZED_HORIZ+1800, 400, 50, 30, imagePath[5], Color.WHITE, speed[5]));
        track.addCharacter(new TheInverter(JFrame.MAXIMIZED_HORIZ+1800 , 300, 50, 30, imagePath[6], Color.WHITE, speed[6]));
        track.addCharacter(new TheShield(JFrame.MAXIMIZED_HORIZ+1800 , 200, 50, 30, imagePath[7], Color.WHITE, speed[7]));//fdsafsafds
        track.addCharacter(new TheTopler(JFrame.MAXIMIZED_HORIZ+1800 , 100, 50, 30, imagePath[8], Color.WHITE, speed[8]));//dfsadsfdsfds
        track.addCharacter(new TheGhost(JFrame.MAXIMIZED_HORIZ+1800, 0, 0, 30, imagePath[9], Color.WHITE, speed[9]));
    }
}

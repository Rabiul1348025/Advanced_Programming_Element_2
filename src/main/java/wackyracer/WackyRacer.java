package wackyracer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class WackyRacer {

    public static void main(String[] args) {
    JFrame frame = new JFrame("Wacky Racer Game");

    // Set the size of the frame to fullscreen
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);

    // Create a new RaceTrack object
    RaceTrack track = new RaceTrack();

    // Create characters
    createCharacters(track);

    // Add the race track to the frame
    frame.add(track);
//    track.startRace();
    
    // Add a start button
    JButton startButton = new JButton("Start");
    startButton.addActionListener((ActionEvent e) -> {
        track.startRace();
    });
    frame.add(startButton, BorderLayout.NORTH);
//
//    // Add a stop button
//    JButton stopButton = new JButton("Stop");
//    stopButton.addActionListener((ActionEvent e) -> {
//        track.stopRace();
//    });
//    frame.add(stopButton, BorderLayout.SOUTH);

    // Make the frame visible
    frame.setVisible(true);
}



    private static void createCharacters(RaceTrack track) {
        // Create a new Character object and add it to the race track
        String imagePath = "images/speeder.png";
        int speed = 15;
        //add teleporter
        track.addCharacter(new TheTeleporter(JFrame.MAXIMIZED_HORIZ, 520, 100, 80, 
                imagePath, Color.BLUE, speed));
        
//        //add TheWizard
        imagePath = "images/wiz.png";
        speed = 12;
        track.addCharacter(new TheWizard(JFrame.MAXIMIZED_HORIZ, 600, 150, 180, 
                imagePath, Color.WHITE, speed));
//        
//         //add TheHulk
        imagePath = "images/hk.png";
        speed = 2;
        track.addCharacter(new TheHulk(-JFrame.MAXIMIZED_HORIZ, 400, 200, 100, 
                imagePath, Color.WHITE, speed));
//        
//        
//        //add TheFlash
        imagePath = "images/shrinkk.png";
        speed = 20;
        track.addCharacter(new TheFlash(JFrame.MAXIMIZED_HORIZ +50, 300, 100, 80, 
                imagePath, Color.WHITE, speed));
//        
//        //add TheFreezer
        imagePath = "images/shil.png";
        speed = 7;
        track.addCharacter(new TheFreezer(JFrame.MAXIMIZED_HORIZ, 270, 150, 120, 
                imagePath, Color.WHITE, speed));
//        
//        //add TheRocket
        imagePath = "images/rs.png";
        speed = 15;
        track.addCharacter(new TheRocket(JFrame.MAXIMIZED_HORIZ +600, 650, 150, 120, 
                imagePath, Color.WHITE, speed));
//        
//        //add TheTopler
        imagePath = "images/topler.png";
        speed = 12;
        track.addCharacter(new TheTopler(JFrame.MAXIMIZED_HORIZ +780, 190, 250, 120, 
                imagePath, Color.WHITE, speed));
//        
//        //add TheInverter
        imagePath = "images/tr.png";
        speed = 9;
        track.addCharacter(new TheInverter(JFrame.MAXIMIZED_HORIZ +190, 150, 250, 120, 
                imagePath, Color.WHITE, speed));
//        
//        //add TheTurtle
        imagePath = "images/turtle.png";
        speed = 2;
        track.addCharacter(new TheTurtle(JFrame.MAXIMIZED_HORIZ +600, 450, 200, 150, 
                imagePath, Color.WHITE, speed));
//        
//        //add TheTinker
        imagePath = "images/tk.png";
        speed = 3;
        track.addCharacter(new TheTinker(JFrame.MAXIMIZED_HORIZ +200, 650, 200, 150, 
                imagePath, Color.WHITE, speed));
//        
//         //add TheGhost
        imagePath = "images/shifter.png";
        speed = 8;
        track.addCharacter(new TheGhost(JFrame.MAXIMIZED_HORIZ +10, 100, 200, 110, 
                imagePath, Color.WHITE, speed));
    }
}

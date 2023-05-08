package wackyracer;

import java.awt.Color;
import javax.swing.JFrame;

public class TheInverter extends WackyCharacter implements SpecialPower{
    private int direction = 1;
    
    public TheInverter(int x, int y, int width, int height, String imagePath, Color characterColor, int speed) {
        super(x, y, width, height, imagePath, characterColor, speed);
    }
    
    @Override
    public void usePower() {
        // Move up or down based on the current direction
        int newY = getY() + (direction * 10);

        // Check if new Y coordinate is within the bounds of the track
        if (newY < 0) {
            newY = 0;
            direction = 1; // Change direction to move down
        } else if (newY + getHeight() > JFrame.MAXIMIZED_VERT) {
            newY = JFrame.MAXIMIZED_VERT - getHeight();
            direction = -1; // Change direction to move up
        }
        // Set the new Y coordinate
        setY(newY);
    }
    
    @Override
    public void move() {
        this.usePower();
    }
}

package wackyracer;

import java.awt.Color;
import javax.swing.JFrame;

public class TheTopler extends WackyCharacter implements SpecialPower{
    
    public TheTopler(int x, int y, int width, int height, String imagePath, Color characterColor, int speed) {
        super(x, y, width, height, imagePath, characterColor, speed);
    }

    @Override
    public void usePower() {
 // Move up or down randomly
        int randomValue = (int) (Math.random() * 50) - 25; // random value between -25 and 25
        int newY = getY() + randomValue;

        // Check if new Y coordinate is within the bounds of the track
        if (newY < 0) {
            newY = 500;
        } else if (newY + getHeight() > 900) {
            newY = 600 - getHeight();
        }
        // Set the new Y coordinate
        setY(newY);
    }
    @Override
    public void move() {
        this.usePower();
    }
}

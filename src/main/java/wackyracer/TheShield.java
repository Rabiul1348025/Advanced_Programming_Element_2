package wackyracer;

import java.awt.Color;
import javax.swing.JFrame;


public class TheShield extends WackyCharacter implements SpecialPower {

    private boolean isHopping = false;
    private int hopHeight = 50;
    private int hopCounter = 0;

    public TheShield(int x, int y, int width, int height, String imagePath, Color characterColor, int speed) {
        super(x, y, width, height, imagePath, characterColor, speed);
    }

    @Override
    public void usePower() {
        if (!isHopping) {
            isHopping = true;
            hopCounter = 0;
        } else {
            hopCounter++;
            if (hopCounter > hopHeight) {
                isHopping = false;
                hopCounter = 0;
            }
        }
        // Move up or down depending on hop status
        int newY = getY() - (isHopping ? 2 : -2);
        // Check if new Y coordinate is within the bounds of the track
        if (newY < 0) {
            newY = 0;
        } else if (newY + getHeight() > JFrame.MAXIMIZED_VERT) {
            newY = JFrame.MAXIMIZED_VERT - getHeight();
        }
        // Set the new Y coordinate
        setY(newY);
    }

    @Override
    public void move() {
        this.usePower();
    }
}


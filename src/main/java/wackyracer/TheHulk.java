package wackyracer;

import java.awt.Color;
import javax.swing.JFrame;

public class TheHulk extends WackyCharacter implements SpecialPower{

    public TheHulk(int x, int y, int width, int height, String imagePath, Color characterColor, int speed) {
        super(x, y, width, height, imagePath, characterColor, speed);
    }

    @Override
    public void usePower() {
        // Move randomly in different directions
        int dx = (int) (Math.random() * 21) - 10; // random value between -10 and 10
        int dy = (int) (Math.random() * 21) - 10; // random value between -10 and 10
        int newX = getX() + dx;
        int newY = getY() + dy;

        // Check if new position is within bounds of the track
        if (newX < 0) {
            newX = JFrame.MAXIMIZED_HORIZ;
        } else if (newX + getWidth() > JFrame.MAXIMIZED_HORIZ) {
            newX = JFrame.MAXIMIZED_HORIZ - getWidth();
        }
        if (newY < 0) {
            newY = JFrame.MAXIMIZED_VERT;
        } else if (newY + getHeight() >= JFrame.MAXIMIZED_VERT) {
            newY = JFrame.MAXIMIZED_VERT + (getHeight() * 2);
        }
        // Set the new position
        setX(newX);
        setY(newY);
    }

    @Override
    public void move() {
        this.usePower();
    }
}

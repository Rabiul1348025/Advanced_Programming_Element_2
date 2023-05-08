package wackyracer;

import java.awt.Color;
import javax.swing.JFrame;

public class TheSpeedster extends WackyCharacter implements SpecialPower{
    
    public TheSpeedster(int x, int y, int width, int height, String imagePath, Color characterColor, int speed) {
        super(x, y, width, height, imagePath, characterColor, speed);
    }
    
    @Override
    public void usePower() {
        // Increase speed by a factor of 2
        setSpeed(getSpeed() * 2);
    }
    
    @Override
    public void move() {
        this.usePower();
        super.move(); // Call parent class move method to move character with the new speed
    }
}

package wackyracer;

import java.awt.Color;
import javax.swing.JFrame;

public class TheSpeedster extends WackyCharacter implements SpecialPower{
    
    public String name="Speedster";
    public TheSpeedster(int x, int y, int width, int height, String imagePath, Color characterColor, int speed) {
        super(x, y, width, height, imagePath, characterColor, speed);
        super.setName(name);
    }
    
    @Override
    public void usePower() {
        // Increase speed by a factor of 2//too fast so +1
        //        speed 1
        int speed = (getSpeed()+1);
        setSpeed(speed);
        
        int newX = getX()-getSpeed()/10;
        
        if(newX > 1800) newX = 1800;
        
        setX(newX);
    }
    
    @Override
    public void move() {
        this.usePower();
    }
}

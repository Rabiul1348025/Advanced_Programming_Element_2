package wackyracer;

import java.awt.Color;

public class TheFreezer extends WackyCharacter implements SpecialPower{
    private static final int JUMP_DISTANCE = 100;
    private static final int JUMP_DELAY = 500;
    private long lastJumpTime = System.currentTimeMillis() - JUMP_DELAY;
    private boolean jumping = false;
    
    public TheFreezer(int x, int y, int width, int height, String imagePath, Color characterColor, int speed) {
        super(x, y, width, height, imagePath, characterColor, speed);
    }
    
    @Override
    public void usePower() {
        if (!jumping && System.currentTimeMillis() - lastJumpTime >= JUMP_DELAY) {
            jumping = true;
            lastJumpTime = System.currentTimeMillis();
        }
    }
    
    @Override
    public void move() {
        if (jumping) {
            // Move character up by JUMP_DISTANCE
            setY(getY() - JUMP_DISTANCE);
            jumping = false;
        } else {
            // Move character down by its speed
            setY(getY() + getSpeed());
        }
    }
}

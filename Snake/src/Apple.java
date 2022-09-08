import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;

public class Apple {

    private static final int width = 400, height = 400;
    private static final int unitSize = 25;
    private int x,y;
    private Random random = new Random();

    public Apple() {
    }


    public int getX() {
        return x;
    }


    public void setX(int x) {
        this.x = x;
    }


    public int getY() {
        return y;
    }


    public void setY(int y) {
        this.y = y;
    }


    public void NewApple(){
       this.x = random.nextInt(width/unitSize)*unitSize;
       this.y = random.nextInt(height/unitSize)*unitSize;
    }
    
    public void Draw(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(this.x, this.y, unitSize, unitSize);
    }
}

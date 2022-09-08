import java.util.Random;
import java.util.Vector;

import java.awt.Color;
import java.awt.Graphics;

public class Snake {

    private static final int width = 400, height = 400;
    private static final int unitSize = 25;
    private int bodySize = 3;
    private int applesEaten = 0;
    private Vector<Segment> segments = new Vector<>();
    Random random = new Random();

    public Snake() {
        for (int i = bodySize - 1; i >= 0; i--) {
            segments.add(new Segment(i * unitSize, 0));
        }
    }
 
    public int getBodySize() {
        return bodySize;
    }

    public void setBodySize(int bodySize) {
        this.bodySize = bodySize;
    }

    public int getApplesEaten() {
        return applesEaten;
    }

    public void setApplesEaten(int applesEaten) {
        this.applesEaten = applesEaten;
    }

    public Vector<Segment> getSegments() {
        return segments;
    }

    public void setSegments(Vector<Segment> segments) {
        this.segments = segments;
    }

    public void Draw(Graphics g) {
        // head magenta and body green
/*         boolean head = true;
        

        for (Segment segment : segments) {
            if(head){
                g.setColor(Color.magenta);
                head=false;
            }
            else{
                g.setColor(Color.green);
            }
            g.fillRect(segment.getX(), segment.getY(), unitSize, unitSize);
        }  */

        // all random all the time!!!
        for (Segment segment : segments) {
           g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
            g.fillRect(segment.getX(), segment.getY(), unitSize, unitSize);
        } 

    }

    public void Move(char direction) {
        for (int i = bodySize - 1; i >= 0; i--) {
            if (i == 0) {
                switch (direction) {
                    case 'U':
                        segments.get(i).setY(segments.get(i).getY() - unitSize);
                        break;
                    case 'D':
                        segments.get(i).setY(segments.get(i).getY() + unitSize);
                        break;
                    case 'L':
                        segments.get(i).setX(segments.get(i).getX() - unitSize);
                        break;
                    case 'R':
                        segments.get(i).setX(segments.get(i).getX() + unitSize);
                        break;
                }
            } else {
                segments.get(i).setX(segments.get(i - 1).getX());
                segments.get(i).setY(segments.get(i - 1).getY());
            }
        }
    }

    public boolean CheckCollision(){
        for (int i = bodySize - 1; i > 0; i--) {
            if(segments.get(0).getX() == segments.get(i).getX() && segments.get(0).getY() == segments.get(i).getY()){
                return false;
            }
        }

        if(segments.get(0).getX()<0){
            return false;
        }

        if(segments.get(0).getX()>=width){
            return false;
        }

        if(segments.get(0).getY()<0){
            return false;
        }

        if(segments.get(0).getY()>=height){
            return false;
        }

        return true;
    }

    public void Grow(){
        bodySize++;
        applesEaten++;
        segments.add(new Segment( segments.lastElement().getX(), segments.lastElement().getY()));
    }
}

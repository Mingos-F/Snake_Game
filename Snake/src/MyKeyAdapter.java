import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyAdapter extends KeyAdapter {

    private char direction = 'R';

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                if (direction != 'R') {
                    direction = 'L';
                }
                break;
            case KeyEvent.VK_D:
                if (direction != 'L') {
                    direction = 'R';
                }
                break;
            case KeyEvent.VK_W:
                if (direction != 'D') {
                    direction = 'U';
                }
                break;
            case KeyEvent.VK_S:
                if (direction != 'U') {
                    direction = 'D';
                }
                break;
        }
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

}

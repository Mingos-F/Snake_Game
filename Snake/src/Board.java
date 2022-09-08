import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FontMetrics;

import javax.swing.plaf.DimensionUIResource;

public class Board extends JPanel implements ActionListener {

    private static final int width = 400, height = 400;
    private static final int unitSize = 25;
    private final int delay = 95;
    private Snake snake = new Snake();
    private Apple apple = new Apple();
    private MyKeyAdapter keyAdapter = new MyKeyAdapter();
    private boolean running = false;
    private Timer timer;

    public Board() {
        apple.NewApple();
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new DimensionUIResource(width, height));
        this.setFocusable(true);
        this.addKeyListener(keyAdapter);
        StartGame();
    }

    public void StartGame() {
        running = true;
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Draw(g);
    }

    public void Draw(Graphics g) {
        if (running) {
            g.setColor(Color.gray);

            for (int i = 0; i < height / unitSize; i++) {
                g.drawLine(i * unitSize, 0, i * unitSize, height);
                g.drawLine(0, i * unitSize, width, i * unitSize);
            }

            apple.Draw(g);
            snake.Draw(g);

            g.setColor(Color.red);
            g.setFont(new Font("Times New Roman", Font.BOLD, 35));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: " + snake.getApplesEaten(), (width - metrics.stringWidth("Score: " + snake.getApplesEaten()))/2, g.getFont().getSize());
        } else {
            GameOver(g);
        }
    }

    public void CheckCollisionApple() {
        if (snake.getSegments().get(0).getX() == apple.getX() && snake.getSegments().get(0).getY() == apple.getY()) {
            apple.NewApple();
            snake.Grow();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            snake.Move(keyAdapter.getDirection());
            running = snake.CheckCollision();
            CheckCollisionApple();
            if (!running) {
                timer.stop();
            }
        }
        repaint();
    }

    public void GameOver(Graphics g) {
        g.setColor(Color.red);
        g.setFont(new Font("Times New Roman", Font.BOLD, 55));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over", (width - metrics.stringWidth("Game Over"))/2, height / 2);
    }

}

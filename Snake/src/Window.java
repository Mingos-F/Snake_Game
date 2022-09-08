
import javax.swing.JFrame;

public class Window extends JFrame{

    Board board = new Board();

    public Window() {
        
        this.add(board);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }

}

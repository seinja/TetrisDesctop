import javax.swing.*;
import java.awt.*;

public class Tetris extends JFrame {
    public JLabel statusBar;

    public Tetris() {
        initGUI();
    }

    private void initGUI() {
        statusBar = new JLabel("0");
        add(statusBar, BorderLayout.SOUTH);

        var board = new GameBoard(this);
        add(board);
        board.start();

        setTitle("Tetris i fuck this shit");
        setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    JLabel getStatusBar() {
        return statusBar;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var game = new Tetris();
            game.setVisible(true);
        });
    }

}

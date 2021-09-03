import javax.swing.*;
import java.awt.*;

public class SudokuWindow
{
    private JPanel rootPanel = new JPanel();
    private JLabel case1 = new JLabel();

    //Constructeur
    public SudokuWindow()
    {

    }

    //Méthodes
    public void init()
    {
        //Init JFrame and rootPanel
        JFrame frame = new JFrame("Sudoku");
        frame.setContentPane(new SudokuWindow().rootPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Sudoku");
        ImageIcon icon = new ImageIcon("./images/icon.png");
        frame.setIconImage(icon.getImage());
        frame.add(rootPanel);

        int windowWidth = 600;
        int windowHeight = 600;
        frame.setSize(windowWidth, windowHeight);
        Dimension screenSize = frame.getToolkit().getScreenSize();
        double screenWidth = screenSize.getWidth();
        double screenHeight = screenSize.getHeight();
        frame.setLocation((int)screenWidth/2 - windowWidth/2, (int)screenHeight/2 - windowHeight/2);

        frame.setVisible(true);

        //Init the grid and sudokuPanel
        ImageIcon zero = new ImageIcon("./images/0.png");
        case1.setIcon(zero);
        rootPanel.add(case1);
    }
}

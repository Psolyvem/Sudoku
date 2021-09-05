import javax.swing.*;
import java.awt.*;

public class SudokuWindow
{
    private JPanel rootPanel = new JPanel();

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
        SudokuCase case1 = new SudokuCase(1, rootPanel);
        SudokuCase case2 = new SudokuCase(2, rootPanel);
        SudokuCase case3 = new SudokuCase(3, rootPanel);
        SudokuCase case4 = new SudokuCase(4, rootPanel);
        SudokuCase case5 = new SudokuCase(0, rootPanel);
        SudokuCase case6 = new SudokuCase(8, rootPanel);

        //Update display
        rootPanel.updateUI();
    }
}

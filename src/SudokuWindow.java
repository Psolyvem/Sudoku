import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SudokuWindow implements ActionListener
{
    private JPanel rootPanel = new JPanel();
    private JPanel sudokuPanel = new JPanel();
    private JPanel menuPanel = new JPanel();
    JButton play = new JButton("Play");

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
        rootPanel.add(sudokuPanel);
        rootPanel.add(menuPanel);
        sudokuPanel.setVisible(false);
        menuPanel.setVisible(false);

        int windowWidth = 600;
        int windowHeight = 600;
        frame.setSize(windowWidth, windowHeight);
        Dimension screenSize = frame.getToolkit().getScreenSize();
        double screenWidth = screenSize.getWidth();
        double screenHeight = screenSize.getHeight();
        frame.setLocation((int)screenWidth/2 - windowWidth/2, (int)screenHeight/2 - windowHeight/2);

        frame.setVisible(true);
    }

    public void menu()
    {
        menuPanel.setVisible(true);
        menuPanel.add(play);
        play.addActionListener(this);
    }

    public void play()
    {
        sudokuPanel.setVisible(true);
        //Init the grid and sudokuPanel
        SudokuCase case1 = new SudokuCase(1, sudokuPanel);
        SudokuCase case2 = new SudokuCase(2, sudokuPanel);
        SudokuCase case3 = new SudokuCase(3, sudokuPanel);
        SudokuCase case4 = new SudokuCase(4, sudokuPanel);
        SudokuCase case5 = new SudokuCase(0, sudokuPanel);
        SudokuCase case6 = new SudokuCase(8, sudokuPanel);

        //Update display
        rootPanel.updateUI();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == play);
        {
            menuPanel.setVisible(false);
            this.play();
        }
    }
}

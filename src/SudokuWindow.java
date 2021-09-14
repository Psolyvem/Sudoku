import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SudokuWindow implements ActionListener
{
    private final JPanel rootPanel = new JPanel();
    private final JPanel playPanel = new JPanel();
    private final JPanel sudokuPanel = new JPanel();
    private final JPanel subSudokuPanel = new JPanel();
    private final JPanel subSudokuPanel2 = new JPanel();
    private final JPanel menuPanel = new JPanel();
    private final JPanel optionsPanel = new JPanel();
    private final GridLayout layout = new GridLayout(9,9);
    private Grid grid = new Grid();
    private int difficulty = 1;
    private final JButton play = new JButton("Play");
    private final JButton options = new JButton("Options");
    private final JButton difficultyEasy = new JButton("Facile");
    private final JButton difficultyMedium = new JButton("Moyen");
    private final JButton difficultyHard = new JButton("Difficile");
    private final JButton menu = new JButton("Menu");
    private final JButton menu2 = new JButton("Menu");
    private final JButton endGame = new JButton("Valider");
    private final JLabel endMessage = new JLabel();


    //Constructeur
    public SudokuWindow()
    {
    }

    //Méthodes
    public void init()
    {
        //Init JFrame and Panels
        JFrame frame = new JFrame("Sudoku");
        frame.setContentPane(new SudokuWindow().rootPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Sudoku");
        ImageIcon icon = new ImageIcon("./images/icon.png");
        frame.setIconImage(icon.getImage());
        frame.add(rootPanel);

        //rootPanel
        rootPanel.add(menuPanel);
        rootPanel.add(playPanel);
        rootPanel.add(optionsPanel);

        //menuPanel
        menuPanel.add(play);
        menuPanel.add(options);

        //optionsPanel
        optionsPanel.add(difficultyEasy);
        optionsPanel.add(difficultyMedium);
        optionsPanel.add(difficultyHard);
        optionsPanel.add(menu);

        //playPanel
        playPanel.setLayout(new BoxLayout(playPanel, BoxLayout.PAGE_AXIS));
        playPanel.add(sudokuPanel);
        playPanel.add(subSudokuPanel);
        playPanel.add(subSudokuPanel2);

        //sudokuPanel
        sudokuPanel.setLayout(layout);
        layout.setHgap(5);
        layout.setVgap(5);
        sudokuPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        //subSudokuPanel
        subSudokuPanel.setLayout(new BoxLayout(subSudokuPanel, BoxLayout.PAGE_AXIS));
        subSudokuPanel.add(endGame);
        subSudokuPanel.add(menu2);

        //subSudokuPanel2
        subSudokuPanel2.add(endMessage);

        playPanel.setVisible(false);
        menuPanel.setVisible(false);
        optionsPanel.setVisible(false);

        int windowWidth = 600;
        int windowHeight = 650;
        frame.setSize(windowWidth, windowHeight);
        Dimension screenSize = frame.getToolkit().getScreenSize();
        double screenWidth = screenSize.getWidth();
        double screenHeight = screenSize.getHeight();
        frame.setLocation((int)screenWidth/2 - windowWidth/2, (int)screenHeight/2 - windowHeight/2);

        frame.setVisible(true);
    }

    public void menu()
    {
        playPanel.setVisible(false);
        optionsPanel.setVisible(false);
        menuPanel.setVisible(true);
        play.addActionListener(this);
        options.addActionListener(this);
    }

    public void options()
    {
        menuPanel.setVisible(false);
        playPanel.setVisible(false);
        optionsPanel.setVisible(true);
        difficultyEasy.addActionListener(this);
        difficultyMedium.addActionListener(this);
        difficultyHard.addActionListener(this);
        menu.addActionListener(this);
    }

    public void play()
    {
        menuPanel.setVisible(false);
        optionsPanel.setVisible(false);
        playPanel.setVisible(true);

        this.grid = new Grid();
        grid.init();
        grid.fill();
        grid.setDifficulty(difficulty);
        grid.hideNbr();
        sudokuPanel.removeAll();

        //Init the grid and sudokuPanel
        for (int x = 0; x < Grid.size; x++)
        {
            for (int y = 0; y < Grid.size; y++)
            {
                new SudokuCase(this.grid.grid[x][y], sudokuPanel, grid, x, y);
            }

        }
        endGame.addActionListener(this);
        menu2.addActionListener(this);

        //Update display
        grid.display();
        rootPanel.updateUI();
    }

    public void endTheGame()
    {
        if(this.grid.isCorrect())
            endMessage.setText("Félicitations, le Sudoku est correct !");
        else
            endMessage.setText("Nul.");
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton actionSource = (JButton) e.getSource();

        if(actionSource == play)
        {
            menuPanel.setVisible(false);
            this.play();
        }
        if(actionSource == endGame)
        {
            this.endTheGame();
        }
        if(actionSource == menu)
        {
            this.menu();
        }
        if(actionSource == menu2)
        {
            this.menu();
        }
        if(actionSource == options)
        {
            this.options();
        }
        if(actionSource == difficultyEasy)
        {
            difficulty = 3;
        }
        if(actionSource == difficultyMedium)
        {
            difficulty = 2;
        }
        if(actionSource == difficultyHard)
        {
            difficulty = 1;
        }
    }
}
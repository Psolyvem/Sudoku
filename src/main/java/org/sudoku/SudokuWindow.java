package org.sudoku;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SudokuWindow implements ActionListener
{
	private final JPanel rootPanel = new JPanel();
	private final JPanel playPanel = new JPanel();
	private final JPanel sudokuPanel = new JPanel();
	private final JPanel subSudokuPanel = new JPanel();
	private final JPanel subSudokuPanel2 = new JPanel();
	private final JPanel menuPanel = new JPanel();
	private final JPanel optionsPanel = new JPanel();
	private final GridLayout layout = new GridLayout(9, 9);
	private Grid grid = new Grid();
	private int difficulty = 1;
	private final JButton play = new JButton("Play");
	private final JButton options = new JButton("Options");
	private final JButton difficultyEasy = new JButton("Facile");
	private final JButton difficultyMedium = new JButton("Moyen");
	private final JButton difficultyHard = new JButton("Difficile");
	private final JButton menu = new JButton("Menu");
	private final JButton menu2 = new JButton("Menu");
	private final JButton endGame = new JButton("Vérifier");
	private final JLabel endMessage = new JLabel();
	private final JLabel difficultySetting = new JLabel();
	final JButton resolve = new JButton("Résoudre");

	private Map<Integer, SudokuCase> mapOfCases = new HashMap<>();

	//Constructeur
	public SudokuWindow()
	{
	}

	//Méthodes
	public void init() throws IOException
	{
		//Init JFrame and Panels
		JFrame frame = new JFrame("Sudoku");
		frame.setContentPane(new SudokuWindow().rootPanel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Sudoku");
		ImageIcon icon = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/icon.png")));
		frame.setIconImage(icon.getImage());
		frame.add(rootPanel);

		int windowWidth = 600;
		int windowHeight = 650;
		frame.setSize(windowWidth, windowHeight);
		Dimension screenSize = frame.getToolkit().getScreenSize();
		double screenWidth = screenSize.getWidth();
		double screenHeight = screenSize.getHeight();
		frame.setLocation((int) screenWidth / 2 - windowWidth / 2, (int) screenHeight / 2 - windowHeight / 2);

		//rootPanel
		rootPanel.add(menuPanel);
		rootPanel.add(playPanel);
		rootPanel.add(optionsPanel);

		//menuPanel
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.PAGE_AXIS));
		menuPanel.add(play);
		play.setAlignmentX(Component.CENTER_ALIGNMENT);
		menuPanel.add(options);
		options.setAlignmentX(Component.CENTER_ALIGNMENT);
		play.addActionListener(this);
		options.addActionListener(this);

		//optionsPanel
		optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.PAGE_AXIS));
		optionsPanel.add(difficultyEasy);
		difficultyEasy.setAlignmentX(Component.CENTER_ALIGNMENT);
		optionsPanel.add(difficultyMedium);
		difficultyMedium.setAlignmentX(Component.CENTER_ALIGNMENT);
		optionsPanel.add(difficultyHard);
		difficultyHard.setAlignmentX(Component.CENTER_ALIGNMENT);
		optionsPanel.add(menu);
		menu.setAlignmentX(Component.CENTER_ALIGNMENT);
		optionsPanel.add(difficultySetting);
		difficultySetting.setAlignmentX(Component.CENTER_ALIGNMENT);
		difficultyEasy.addActionListener(this);
		difficultyMedium.addActionListener(this);
		difficultyHard.addActionListener(this);
		menu.addActionListener(this);

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
		endGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		subSudokuPanel.add(resolve);
		resolve.setAlignmentX(Component.CENTER_ALIGNMENT);
		subSudokuPanel.add(menu2);
		menu2.setAlignmentX(Component.CENTER_ALIGNMENT);
		endGame.addActionListener(this);
		resolve.addActionListener(this);
		menu2.addActionListener(this);


		//subSudokuPanel2
		subSudokuPanel2.add(endMessage);

		playPanel.setVisible(false);
		menuPanel.setVisible(false);
		optionsPanel.setVisible(false);

		frame.setVisible(true);
	}

	public void menu()
	{
		playPanel.setVisible(false);
		optionsPanel.setVisible(false);
		menuPanel.setVisible(true);
	}

	public void options()
	{
		menuPanel.setVisible(false);
		playPanel.setVisible(false);
		optionsPanel.setVisible(true);

		if (difficulty == 1)
			difficultySetting.setText("Difficulty selected : Hard");
		if (difficulty == 2)
			difficultySetting.setText("Difficulty selected : Medium");
		if (difficulty == 3)
			difficultySetting.setText("Difficulty selected : Easy");
	}

	public void play()
	{
		menuPanel.setVisible(false);
		optionsPanel.setVisible(false);
		playPanel.setVisible(true);

		this.grid = new Grid(); //Initialisation de la grille
		grid.init();
		grid.fill();
		grid.setDifficulty(difficulty);
		grid.hideNbr();
		sudokuPanel.removeAll(); //Nettoyage du panel

		//Init the grid and sudokuPanel

		for (int i = 0; i < Grid.size * Grid.size; i++) //Remplissage de la map de org.sudoku.SudokuCase
		{
			try
			{
				mapOfCases.put(i, new SudokuCase(this.grid.grid[i / Grid.size][i % Grid.size], sudokuPanel, grid, i / Grid.size, i % Grid.size));
			}
            catch (Exception e)
			{
				System.out.println("bof");
			}
		}

		//Update display
		grid.display();
		rootPanel.updateUI();
	}

	public void endTheGame()
	{
		if (this.grid.isCorrect())
			endMessage.setText("Félicitations, le Sudoku est correct !");
		else
			endMessage.setText("Perdu.");
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		JButton actionSource = (JButton) e.getSource();

		//Menu Panel
		if (actionSource == play)
		{
			menuPanel.setVisible(false);
			this.play();
		}
		if (actionSource == options)
		{
			this.options();
		}

		//Play Panel
		if (actionSource == endGame)
		{
			this.endTheGame();
		}
		if (actionSource == resolve)
		{
			for (int i = 0; i < Grid.size * Grid.size; i++)
			{
				mapOfCases.get(i).resolve();
			}
		}
		if (actionSource == menu2)
		{
			this.menu();
		}

		//Options Panel
		if (actionSource == menu)
		{
			this.menu();
		}
		if (actionSource == difficultyEasy)
		{
			difficulty = 3;
			difficultySetting.setText("Difficulty selected : Easy");
		}
		if (actionSource == difficultyMedium)
		{
			difficulty = 2;
			difficultySetting.setText("Difficulty selected : Medium");
		}
		if (actionSource == difficultyHard)
		{
			difficulty = 1;
			difficultySetting.setText("Difficulty selected : Hard");
		}
	}
}
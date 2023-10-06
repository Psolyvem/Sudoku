package org.sudoku;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;

public class RessourcesLoader
{
	private static RessourcesLoader instance;
	public ImageIcon zero;
	public ImageIcon one;
	public ImageIcon two;
	public ImageIcon three;
	public ImageIcon four;
	public ImageIcon five;
	public ImageIcon six;
	public ImageIcon seven;
	public ImageIcon eight;
	public ImageIcon nine;
	public ImageIcon zeroHovered;
	public ImageIcon oneHovered;
	public ImageIcon twoHovered;
	public ImageIcon threeHovered;
	public ImageIcon fourHovered;
	public ImageIcon fiveHovered;
	public ImageIcon sixHovered;
	public ImageIcon sevenHovered;
	public ImageIcon eightHovered;
	public ImageIcon nineHovered;
	public ImageIcon zeroClicked;
	public ImageIcon oneClicked;
	public ImageIcon twoClicked;
	public ImageIcon threeClicked;
	public ImageIcon fourClicked;
	public ImageIcon fiveClicked;
	public ImageIcon sixClicked;
	public ImageIcon sevenClicked;
	public ImageIcon eightClicked;
	public ImageIcon nineClicked;
	public ImageIcon oneFix;
	public ImageIcon twoFix;
	public ImageIcon threeFix;
	public ImageIcon fourFix;
	public ImageIcon fiveFix;
	public ImageIcon sixFix;
	public ImageIcon sevenFix;
	public ImageIcon eightFix;
	public ImageIcon nineFix;
	public ImageIcon oneWrong;
	public ImageIcon twoWrong;
	public ImageIcon threeWrong;
	public ImageIcon fourWrong;
	public ImageIcon fiveWrong;
	public ImageIcon sixWrong;
	public ImageIcon sevenWrong;
	public ImageIcon eightWrong;
	public ImageIcon nineWrong;
	public ImageIcon oneRight;
	public ImageIcon twoRight;
	public ImageIcon threeRight;
	public ImageIcon fourRight;
	public ImageIcon fiveRight;
	public ImageIcon sixRight;
	public ImageIcon sevenRight;
	public ImageIcon eightRight;
	public ImageIcon nineRight;

	private RessourcesLoader()
	{
		instance = this;
		try
		{
			zero = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/0.png")));
			one = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/1.png")));
			two = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/2.png")));
			three = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/3.png")));
			four = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/4.png")));
			five = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/5.png")));
			six = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/6.png")));
			seven = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/7.png")));
			eight = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/8.png")));
			nine = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/9.png")));

			zeroHovered = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/0hovered.png")));
			oneHovered = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/1hovered.png")));
			twoHovered = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/2hovered.png")));
			threeHovered = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/3hovered.png")));
			fourHovered = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/4hovered.png")));
			fiveHovered = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/5hovered.png")));
			sixHovered = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/6hovered.png")));
			sevenHovered = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/7hovered.png")));
			eightHovered = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/8hovered.png")));
			nineHovered = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/9hovered.png")));

			zeroClicked = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/0clicked.png")));
			oneClicked = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/1clicked.png")));
			twoClicked = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/2clicked.png")));
			threeClicked = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/3clicked.png")));
			fourClicked = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/4clicked.png")));
			fiveClicked = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/5clicked.png")));
			sixClicked = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/6clicked.png")));
			sevenClicked = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/7clicked.png")));
			eightClicked = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/8clicked.png")));
			nineClicked = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/9clicked.png")));

			oneFix = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/1fix.png")));
			twoFix = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/2fix.png")));
			threeFix = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/3fix.png")));
			fourFix = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/4fix.png")));
			fiveFix = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/5fix.png")));
			sixFix = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/6fix.png")));
			sevenFix = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/7fix.png")));
			eightFix = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/8fix.png")));
			nineFix = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/9fix.png")));

			oneWrong = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/1wrong.png")));
			twoWrong = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/2wrong.png")));
			threeWrong = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/3wrong.png")));
			fourWrong = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/4wrong.png")));
			fiveWrong = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/5wrong.png")));
			sixWrong = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/6wrong.png")));
			sevenWrong = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/7wrong.png")));
			eightWrong = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/8wrong.png")));
			nineWrong = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/9wrong.png")));

			oneRight = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/1right.png")));
			twoRight = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/2right.png")));
			threeRight = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/3right.png")));
			fourRight = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/4right.png")));
			fiveRight = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/5right.png")));
			sixRight = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/6right.png")));
			sevenRight = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/7right.png")));
			eightRight = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/8right.png")));
			nineRight = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/9right.png")));
		}
		catch (IOException e)
		{
			System.err.println("Cannot load images");
		}

	}

	public static RessourcesLoader getInstance()
	{
		if (instance == null)
		{
			instance = new RessourcesLoader();
		}
		return instance;
	}
}

import javax.swing.*;
import java.awt.event.*;

public class SudokuCase implements MouseListener
{
    //Attributs
    Grid grid;
    int value; //Valeur de la case
    int posx; //Position de la case dans la grille
    int posy;
    ImageIcon actualIcon; //Valeur affichée actuellement par la case
    JLabel container = new JLabel();
    JPanel panel;
    boolean mouseHovering = false;
    boolean isGiven = false; //Case modifiable ou non
    boolean isLocked = false; //Case résolue, non modifiable

    ImageIcon zero = new ImageIcon("./images/0.png");
    ImageIcon one = new ImageIcon("./images/1.png");
    ImageIcon two = new ImageIcon("./images/2.png");
    ImageIcon three = new ImageIcon("./images/3.png");
    ImageIcon four = new ImageIcon("./images/4.png");
    ImageIcon five = new ImageIcon("./images/5.png");
    ImageIcon six = new ImageIcon("./images/6.png");
    ImageIcon seven = new ImageIcon("./images/7.png");
    ImageIcon eight = new ImageIcon("./images/8.png");
    ImageIcon nine = new ImageIcon("./images/9.png");

    ImageIcon zeroHovered = new ImageIcon("./images/0hovered.png");
    ImageIcon oneHovered = new ImageIcon("./images/1hovered.png");
    ImageIcon twoHovered = new ImageIcon("./images/2hovered.png");
    ImageIcon threeHovered = new ImageIcon("./images/3hovered.png");
    ImageIcon fourHovered = new ImageIcon("./images/4hovered.png");
    ImageIcon fiveHovered = new ImageIcon("./images/5hovered.png");
    ImageIcon sixHovered = new ImageIcon("./images/6hovered.png");
    ImageIcon sevenHovered = new ImageIcon("./images/7hovered.png");
    ImageIcon eightHovered = new ImageIcon("./images/8hovered.png");
    ImageIcon nineHovered = new ImageIcon("./images/9hovered.png");

    ImageIcon zeroClicked = new ImageIcon("./images/0clicked.png");
    ImageIcon oneClicked = new ImageIcon("./images/1clicked.png");
    ImageIcon twoClicked = new ImageIcon("./images/2clicked.png");
    ImageIcon threeClicked = new ImageIcon("./images/3clicked.png");
    ImageIcon fourClicked = new ImageIcon("./images/4clicked.png");
    ImageIcon fiveClicked = new ImageIcon("./images/5clicked.png");
    ImageIcon sixClicked = new ImageIcon("./images/6clicked.png");
    ImageIcon sevenClicked = new ImageIcon("./images/7clicked.png");
    ImageIcon eightClicked = new ImageIcon("./images/8clicked.png");
    ImageIcon nineClicked = new ImageIcon("./images/9clicked.png");

    ImageIcon oneFix = new ImageIcon("./images/1fix.png");
    ImageIcon twoFix = new ImageIcon("./images/2fix.png");
    ImageIcon threeFix = new ImageIcon("./images/3fix.png");
    ImageIcon fourFix = new ImageIcon("./images/4fix.png");
    ImageIcon fiveFix = new ImageIcon("./images/5fix.png");
    ImageIcon sixFix = new ImageIcon("./images/6fix.png");
    ImageIcon sevenFix = new ImageIcon("./images/7fix.png");
    ImageIcon eightFix = new ImageIcon("./images/8fix.png");
    ImageIcon nineFix = new ImageIcon("./images/9fix.png");

    ImageIcon oneWrong = new ImageIcon("./images/1wrong.png");
    ImageIcon twoWrong = new ImageIcon("./images/2wrong.png");
    ImageIcon threeWrong = new ImageIcon("./images/3wrong.png");
    ImageIcon fourWrong = new ImageIcon("./images/4wrong.png");
    ImageIcon fiveWrong = new ImageIcon("./images/5wrong.png");
    ImageIcon sixWrong = new ImageIcon("./images/6wrong.png");
    ImageIcon sevenWrong = new ImageIcon("./images/7wrong.png");
    ImageIcon eightWrong = new ImageIcon("./images/8wrong.png");
    ImageIcon nineWrong = new ImageIcon("./images/9wrong.png");

    ImageIcon oneRight = new ImageIcon("./images/1right.png");
    ImageIcon twoRight = new ImageIcon("./images/2right.png");
    ImageIcon threeRight = new ImageIcon("./images/3right.png");
    ImageIcon fourRight = new ImageIcon("./images/4right.png");
    ImageIcon fiveRight = new ImageIcon("./images/5right.png");
    ImageIcon sixRight = new ImageIcon("./images/6right.png");
    ImageIcon sevenRight = new ImageIcon("./images/7right.png");
    ImageIcon eightRight = new ImageIcon("./images/8right.png");
    ImageIcon nineRight = new ImageIcon("./images/9right.png");

    //Constructeur
    SudokuCase(int value, JPanel panel, Grid grid, int posx, int posy)
    {
        this.value = value;
        this.panel = panel;
        this.grid = grid;
        this.posx = posx;
        this.posy = posy;
        container.addMouseListener(this);
        if (value != 0)
            isGiven = true;

        switch (value) //On attribue la bonne image en fonction de la valeur
        {
            case 0 -> actualIcon = zero;
            case 1 -> actualIcon = oneFix;
            case 2 -> actualIcon = twoFix;
            case 3 -> actualIcon = threeFix;
            case 4 -> actualIcon = fourFix;
            case 5 -> actualIcon = fiveFix;
            case 6 -> actualIcon = sixFix;
            case 7 -> actualIcon = sevenFix;
            case 8 -> actualIcon = eightFix;
            case 9 -> actualIcon = nineFix;
        }
        container.setIcon(actualIcon);
        panel.add(container);
    }

    public void resolve()
    {
        if(value != grid.originalGrid[posx][posy])
        {
            value = grid.originalGrid[posx][posy]; //On remet la bonne valeur dans la case pour le corrigé
            switch (value) //On attribue la bonne image en fonction de la valeur
            {
                case 1 -> actualIcon = oneWrong;
                case 2 -> actualIcon = twoWrong;
                case 3 -> actualIcon = threeWrong;
                case 4 -> actualIcon = fourWrong;
                case 5 -> actualIcon = fiveWrong;
                case 6 -> actualIcon = sixWrong;
                case 7 -> actualIcon = sevenWrong;
                case 8 -> actualIcon = eightWrong;
                case 9 -> actualIcon = nineWrong;
            }
            container.setIcon(actualIcon);
        }
        else if(value == grid.originalGrid[posx][posy] && !isGiven)
        {
            switch (value) //On attribue la bonne image en fonction de la valeur
            {
                case 1 -> actualIcon = oneRight;
                case 2 -> actualIcon = twoRight;
                case 3 -> actualIcon = threeRight;
                case 4 -> actualIcon = fourRight;
                case 5 -> actualIcon = fiveRight;
                case 6 -> actualIcon = sixRight;
                case 7 -> actualIcon = sevenRight;
                case 8 -> actualIcon = eightRight;
                case 9 -> actualIcon = nineRight;
            }
            container.setIcon(actualIcon);
        }
        this.isLocked = true;
    }

    //Redéfinition de l'interface MouseListener
    @Override
    public void mouseClicked(MouseEvent e)
    {
        if (!isGiven && !isLocked)
        {
            if (value <= 9)
            {
                value++;
                this.grid.grid[posx][posy] = value;
            }
            if (value > 9)
            {
                value = 0;
                this.grid.grid[posx][posy] = value;
            }
            switch (value) //On attribue la bonne image en fonction de la valeur
            {
                case 0 -> actualIcon = zero;
                case 1 -> actualIcon = one;
                case 2 -> actualIcon = two;
                case 3 -> actualIcon = three;
                case 4 -> actualIcon = four;
                case 5 -> actualIcon = five;
                case 6 -> actualIcon = six;
                case 7 -> actualIcon = seven;
                case 8 -> actualIcon = eight;
                case 9 -> actualIcon = nine;
            }
            container.setIcon(actualIcon);
        }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        if (!isGiven && !isLocked)
        {
            if (mouseHovering)
            {
                switch (value) //On attribue la bonne image en fonction de la valeur
                {
                    case 0 -> actualIcon = zeroClicked;
                    case 1 -> actualIcon = oneClicked;
                    case 2 -> actualIcon = twoClicked;
                    case 3 -> actualIcon = threeClicked;
                    case 4 -> actualIcon = fourClicked;
                    case 5 -> actualIcon = fiveClicked;
                    case 6 -> actualIcon = sixClicked;
                    case 7 -> actualIcon = sevenClicked;
                    case 8 -> actualIcon = eightClicked;
                    case 9 -> actualIcon = nineClicked;
                }
                container.setIcon(actualIcon);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        if (!isGiven && !isLocked)
        {
            switch (value) //On attribue la bonne image en fonction de la valeur
            {
                case 0 -> actualIcon = zero;
                case 1 -> actualIcon = one;
                case 2 -> actualIcon = two;
                case 3 -> actualIcon = three;
                case 4 -> actualIcon = four;
                case 5 -> actualIcon = five;
                case 6 -> actualIcon = six;
                case 7 -> actualIcon = seven;
                case 8 -> actualIcon = eight;
                case 9 -> actualIcon = nine;
            }
            container.setIcon(actualIcon);

            if (mouseHovering)
            {
                switch (value) //On attribue la bonne image en fonction de la valeur
                {
                    case 0 -> actualIcon = zeroHovered;
                    case 1 -> actualIcon = oneHovered;
                    case 2 -> actualIcon = twoHovered;
                    case 3 -> actualIcon = threeHovered;
                    case 4 -> actualIcon = fourHovered;
                    case 5 -> actualIcon = fiveHovered;
                    case 6 -> actualIcon = sixHovered;
                    case 7 -> actualIcon = sevenHovered;
                    case 8 -> actualIcon = eightHovered;
                    case 9 -> actualIcon = nineHovered;
                }
                container.setIcon(actualIcon);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        if (!isGiven && !isLocked)
        {
            mouseHovering = true;
            switch (value) //On attribue la bonne image en fonction de la valeur
            {
                case 0 -> actualIcon = zeroHovered;
                case 1 -> actualIcon = oneHovered;
                case 2 -> actualIcon = twoHovered;
                case 3 -> actualIcon = threeHovered;
                case 4 -> actualIcon = fourHovered;
                case 5 -> actualIcon = fiveHovered;
                case 6 -> actualIcon = sixHovered;
                case 7 -> actualIcon = sevenHovered;
                case 8 -> actualIcon = eightHovered;
                case 9 -> actualIcon = nineHovered;
            }
            container.setIcon(actualIcon);
        }
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        if (!isGiven && !isLocked)
        {
            mouseHovering = false;
            switch (value) //On attribue la bonne image en fonction de la valeur
            {
                case 0 -> actualIcon = zero;
                case 1 -> actualIcon = one;
                case 2 -> actualIcon = two;
                case 3 -> actualIcon = three;
                case 4 -> actualIcon = four;
                case 5 -> actualIcon = five;
                case 6 -> actualIcon = six;
                case 7 -> actualIcon = seven;
                case 8 -> actualIcon = eight;
                case 9 -> actualIcon = nine;
            }
            container.setIcon(actualIcon);
        }
    }

}
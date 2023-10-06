package org.sudoku;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

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

    //Constructeur
    SudokuCase(int value, JPanel panel, Grid grid, int posx, int posy) throws IOException
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
            case 0 -> actualIcon = RessourcesLoader.getInstance().zero;
            case 1 -> actualIcon = RessourcesLoader.getInstance().oneFix;
            case 2 -> actualIcon = RessourcesLoader.getInstance().twoFix;
            case 3 -> actualIcon = RessourcesLoader.getInstance().threeFix;
            case 4 -> actualIcon = RessourcesLoader.getInstance().fourFix;
            case 5 -> actualIcon = RessourcesLoader.getInstance().fiveFix;
            case 6 -> actualIcon = RessourcesLoader.getInstance().sixFix;
            case 7 -> actualIcon = RessourcesLoader.getInstance().sevenFix;
            case 8 -> actualIcon = RessourcesLoader.getInstance().eightFix;
            case 9 -> actualIcon = RessourcesLoader.getInstance().nineFix;
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
                case 1 -> actualIcon = RessourcesLoader.getInstance().oneWrong;
                case 2 -> actualIcon = RessourcesLoader.getInstance().twoWrong;
                case 3 -> actualIcon = RessourcesLoader.getInstance().threeWrong;
                case 4 -> actualIcon = RessourcesLoader.getInstance().fourWrong;
                case 5 -> actualIcon = RessourcesLoader.getInstance().fiveWrong;
                case 6 -> actualIcon = RessourcesLoader.getInstance().sixWrong;
                case 7 -> actualIcon = RessourcesLoader.getInstance().sevenWrong;
                case 8 -> actualIcon = RessourcesLoader.getInstance().eightWrong;
                case 9 -> actualIcon = RessourcesLoader.getInstance().nineWrong;
            }
            container.setIcon(actualIcon);
        }
        else if(value == grid.originalGrid[posx][posy] && !isGiven)
        {
            switch (value) //On attribue la bonne image en fonction de la valeur
            {
                case 1 -> actualIcon = RessourcesLoader.getInstance().oneRight;
                case 2 -> actualIcon = RessourcesLoader.getInstance().twoRight;
                case 3 -> actualIcon = RessourcesLoader.getInstance().threeRight;
                case 4 -> actualIcon = RessourcesLoader.getInstance().fourRight;
                case 5 -> actualIcon = RessourcesLoader.getInstance().fiveRight;
                case 6 -> actualIcon = RessourcesLoader.getInstance().sixRight;
                case 7 -> actualIcon = RessourcesLoader.getInstance().sevenRight;
                case 8 -> actualIcon = RessourcesLoader.getInstance().eightRight;
                case 9 -> actualIcon = RessourcesLoader.getInstance().nineRight;
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
                case 0 -> actualIcon = RessourcesLoader.getInstance().zero;
                case 1 -> actualIcon = RessourcesLoader.getInstance().one;
                case 2 -> actualIcon = RessourcesLoader.getInstance().two;
                case 3 -> actualIcon = RessourcesLoader.getInstance().three;
                case 4 -> actualIcon = RessourcesLoader.getInstance().four;
                case 5 -> actualIcon = RessourcesLoader.getInstance().five;
                case 6 -> actualIcon = RessourcesLoader.getInstance().six;
                case 7 -> actualIcon = RessourcesLoader.getInstance().seven;
                case 8 -> actualIcon = RessourcesLoader.getInstance().eight;
                case 9 -> actualIcon = RessourcesLoader.getInstance().nine;
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
                    case 0 -> actualIcon = RessourcesLoader.getInstance().zeroClicked;
                    case 1 -> actualIcon = RessourcesLoader.getInstance().oneClicked;
                    case 2 -> actualIcon = RessourcesLoader.getInstance().twoClicked;
                    case 3 -> actualIcon = RessourcesLoader.getInstance().threeClicked;
                    case 4 -> actualIcon = RessourcesLoader.getInstance().fourClicked;
                    case 5 -> actualIcon = RessourcesLoader.getInstance().fiveClicked;
                    case 6 -> actualIcon = RessourcesLoader.getInstance().sixClicked;
                    case 7 -> actualIcon = RessourcesLoader.getInstance().sevenClicked;
                    case 8 -> actualIcon = RessourcesLoader.getInstance().eightClicked;
                    case 9 -> actualIcon = RessourcesLoader.getInstance().nineClicked;
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
                case 0 -> actualIcon = RessourcesLoader.getInstance().zero;
                case 1 -> actualIcon = RessourcesLoader.getInstance().one;
                case 2 -> actualIcon = RessourcesLoader.getInstance().two;
                case 3 -> actualIcon = RessourcesLoader.getInstance().three;
                case 4 -> actualIcon = RessourcesLoader.getInstance().four;
                case 5 -> actualIcon = RessourcesLoader.getInstance().five;
                case 6 -> actualIcon = RessourcesLoader.getInstance().six;
                case 7 -> actualIcon = RessourcesLoader.getInstance().seven;
                case 8 -> actualIcon = RessourcesLoader.getInstance().eight;
                case 9 -> actualIcon = RessourcesLoader.getInstance().nine;
            }
            container.setIcon(actualIcon);

            if (mouseHovering)
            {
                switch (value) //On attribue la bonne image en fonction de la valeur
                {
                    case 0 -> actualIcon = RessourcesLoader.getInstance().zeroHovered;
                    case 1 -> actualIcon = RessourcesLoader.getInstance().oneHovered;
                    case 2 -> actualIcon = RessourcesLoader.getInstance().twoHovered;
                    case 3 -> actualIcon = RessourcesLoader.getInstance().threeHovered;
                    case 4 -> actualIcon = RessourcesLoader.getInstance().fourHovered;
                    case 5 -> actualIcon = RessourcesLoader.getInstance().fiveHovered;
                    case 6 -> actualIcon = RessourcesLoader.getInstance().sixHovered;
                    case 7 -> actualIcon = RessourcesLoader.getInstance().sevenHovered;
                    case 8 -> actualIcon = RessourcesLoader.getInstance().eightHovered;
                    case 9 -> actualIcon = RessourcesLoader.getInstance().nineHovered;
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
                case 0 -> actualIcon = RessourcesLoader.getInstance().zeroHovered;
                case 1 -> actualIcon = RessourcesLoader.getInstance().oneHovered;
                case 2 -> actualIcon = RessourcesLoader.getInstance().twoHovered;
                case 3 -> actualIcon = RessourcesLoader.getInstance().threeHovered;
                case 4 -> actualIcon = RessourcesLoader.getInstance().fourHovered;
                case 5 -> actualIcon = RessourcesLoader.getInstance().fiveHovered;
                case 6 -> actualIcon = RessourcesLoader.getInstance().sixHovered;
                case 7 -> actualIcon = RessourcesLoader.getInstance().sevenHovered;
                case 8 -> actualIcon = RessourcesLoader.getInstance().eightHovered;
                case 9 -> actualIcon = RessourcesLoader.getInstance().nineHovered;
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
                case 0 -> actualIcon = RessourcesLoader.getInstance().zero;
                case 1 -> actualIcon = RessourcesLoader.getInstance().one;
                case 2 -> actualIcon = RessourcesLoader.getInstance().two;
                case 3 -> actualIcon = RessourcesLoader.getInstance().three;
                case 4 -> actualIcon = RessourcesLoader.getInstance().four;
                case 5 -> actualIcon = RessourcesLoader.getInstance().five;
                case 6 -> actualIcon = RessourcesLoader.getInstance().six;
                case 7 -> actualIcon = RessourcesLoader.getInstance().seven;
                case 8 -> actualIcon = RessourcesLoader.getInstance().eight;
                case 9 -> actualIcon = RessourcesLoader.getInstance().nine;
            }
            container.setIcon(actualIcon);
        }
    }

}
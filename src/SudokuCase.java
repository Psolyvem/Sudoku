import javax.swing.*;
import java.awt.event.*;

public class SudokuCase implements MouseListener
{
    //Attributs
    int value; //Valeur de la case
    ImageIcon actualIcon; //Valeur affichée actuellement par la case
    JLabel container = new JLabel();
    JPanel panel;
    boolean mouseHovering = false;

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

    //Constructeur
    SudokuCase(int value, JPanel panel)
    {
        this.value = value;
        this.panel = panel;
        container.addMouseListener(this);

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
        panel.add(container);
    }

    //Redéfinition de l'interface MouseListener
    @Override
    public void mouseClicked(MouseEvent e)
    {
        if(value <= 9)
            value++;
        if(value > 9)
            value =0;
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

    @Override
    public void mousePressed(MouseEvent e)
    {
        if(mouseHovering)
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

    @Override
    public void mouseReleased(MouseEvent e)
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

        if(mouseHovering)
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

    @Override
    public void mouseEntered(MouseEvent e)
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

    @Override
    public void mouseExited(MouseEvent e)
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
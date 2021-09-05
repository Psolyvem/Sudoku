import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

class Main
{
    public static void main(String[] args) throws Exception
    {
        Grid grid = new Grid();

        grid.init();
        grid.fill();
        grid.display();
        grid.hideNbr();
        grid.display();
        grid.solve(grid);
        grid.display();

        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        SudokuWindow mainWindow = new SudokuWindow();
        mainWindow.init();
        mainWindow.menu();
    }
}
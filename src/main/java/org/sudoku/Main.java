package org.sudoku;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

class Main
{
    public static void main(String[] args) throws Exception
    {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        SudokuWindow mainWindow = new SudokuWindow();
        mainWindow.init();
        mainWindow.menu();
    }
}
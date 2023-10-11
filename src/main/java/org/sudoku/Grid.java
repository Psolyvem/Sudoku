package org.sudoku;

import java.util.ArrayList;
import java.util.List;

public class Grid
{
    //Attributs
    public final static int size = 9; // Taille de la grille
    private int difficulty = 1;
    public int[][] grid = new int[size][size];
    public int [][] originalGrid = new int[size][size];
    protected boolean[][][] possibles = new boolean[size][size][size]; // Tableau de booléens listant les nombres possibles sur chaque case

    //Méthodes
    //Principales
    public void init() // Remplit la grille de zéros et initialise la liste des possibles
    {
        this.fillZero();
        this.initPossibles();
    }

    public void display() // Affiche la grille
    {
        System.out.println("   1 2 3 4 5 6 7 8 9");
        System.out.println("  -------------------");
        for (int x = 0; x < size; x++)
        {
            System.out.print(x + 1 + " |");
            for (int y = 0; y < size; y++)
            {
                if (grid[x][y] == 0)
                {
                    System.out.print(" ");
                } else
                {
                    System.out.print(grid[x][y]);
                }
                System.out.print("|");
            }
            System.out.print("\n");
            System.out.println("  -------------------");
        }
    }

    public void fill() // Génère une grille complète et cohérente
    {
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                List<Integer> listPossibles = new ArrayList<>();

                checkPossible(x, y); // Update les possibles de la case
                for (int i = 0; i < size; i++) // Ajoute tous les possibles restants à la liste
                {
                    if (possibles[x][y][i])
                        listPossibles.add(i + 1);
                }
                if (listPossibles.size() != 0) // S'il y a au moins un possible, on en choisi un au hasard et on teste
                {
                    grid[x][y] = listPossibles.get((int) (Math.random() * listPossibles.size()));
                } else // Sinon on rollback
                {
                    List<Integer> newCoo = this.rollback(x, y);
                    x = newCoo.get(0);
                    y = newCoo.get(1);

                    for (int i = 0; i < size; i++) // Puis on recommence
                    {
                        if (possibles[x][y][i])
                            listPossibles.add(i + 1);
                    }
                    grid[x][y] = listPossibles.get((int) (Math.random() * listPossibles.size()));
                }
            }
        }
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                originalGrid[x][y] = grid[x][y];
            }
        }
    }

    public void hideNbr() // Supprime des nombres de la grille en vérifiant qu'il n'existe toujours qu'une solution unique
    {
        int numbersToHide = 81; // On initialise à un nombre trop grand pour être résolu
        //Définition de la difficulté
        if(difficulty == 1)
            numbersToHide = 81;
        if(difficulty == 2)
            numbersToHide = 40;
        if(difficulty == 3)
            numbersToHide = 30;

        boolean[][] alreadyTested = new boolean[size][size]; // On crée une grille qui vérifie si une case a déjà été testée
        for (int i = 0; i < size; i++) // On initialise à false
        {
            for (int j = 0; j < size; j++)
            {
                alreadyTested[i][j] = false;
            }
        }
        int numbersHidden = 0;
        boolean gridFullyTested = false;

        while (!gridFullyTested)
        {
            if(numbersHidden == numbersToHide) // Si on a caché suffisamment de chiffres pour le niveau de difficulté, on arrête.
                break;

            int x = (int) (Math.random() * size); // On choisit au random des coordonnées
            int y = (int) (Math.random() * size);

            if (!alreadyTested[x][y]) // Si la case n'est pas déjà testée
            {
                int prevValue = grid[x][y]; // On sauvegarde la valeur de la case

                grid[x][y] = 0; // On vide la case
                if (!this.checkUniqueSolution()) // S'il y a plus d'une solution
                {
                    grid[x][y] = prevValue; // On restaure la case
                } else // Sinon, on décrémente le nombre de chiffres à cacher
                {
                    numbersHidden++;
                }
                alreadyTested[x][y] = true; // On marque la case comme testée
            }
            gridFullyTested = true; // On vérifie si toutes les cases ont été testées
            for (int i = 0; i < size; i++)
            {
                for (int j = 0; j < size; j++)
                {
                    if (!alreadyTested[i][j])
                    {
                        gridFullyTested = false;
                        break;
                    }
                }
            }
        }
    }

    public boolean checkUniqueSolution()
    {
        List<Integer[]> solutions = new ArrayList<>();
        int solutionTested = 0;
        int[][] gridCopy = new int[size][size]; // On fait une copie propre de la grille originale
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                gridCopy[x][y] = grid[x][y];
            }
        }

        while (!this.isFull()) // On résout la grille une première fois normalement, et on liste les chiffres mis dans la grille avec leurs coordonnées
        {
            int numbersPlaced = 0; // Nombre de chiffres placés durant cette lecture de la grille
            for (int x = 0; x < size; x++)
            {
                for (int y = 0; y < size; y++)
                {
                    if (grid[x][y] == 0)
                    {
                        List<Integer> listPossibles = new ArrayList<>();
                        checkPossible(x, y); // Update les possibles de la case
                        for (int i = 0; i < size; i++) // Ajoute tous les possibles restants à la liste
                        {
                            if (possibles[x][y][i])
                                listPossibles.add(i + 1);
                        }
                        if (listPossibles.size() == 1) // Si cette case à un seul possible on le met dedans
                        {
                            grid[x][y] = listPossibles.get(0);
                            numbersPlaced++; // On incrémente le compteur de nombres placés
                            Integer[] thisNumber = new Integer[3]; // On crée un tableau contenant les coordonnées et le chiffre mis dans la grille.
                            thisNumber[0] = x;
                            thisNumber[1] = y;
                            thisNumber[2] = (listPossibles.get(0) - 1);
                            solutions.add(thisNumber); // Et on ajoute ce tableau à la liste des solutions.
                        }
                    }
                }
            }
            if (numbersPlaced == 0) // Si une lecture de la grille n'a pas réussi à placer un seul chiffre, alors il n'y a pas de solution.
            {
                solutionTested++;
                for (int x = 0; x < size; x++) // On restaure la grille
                {
                    for (int y = 0; y < size; y++)
                    {
                        grid[x][y] = gridCopy[x][y];
                    }
                }
                return false;
            }
        }
        for (int x = 0; x < size; x++) // On restaure la grille
        {
            for (int y = 0; y < size; y++)
            {
                grid[x][y] = gridCopy[x][y];
            }
        }

        while (true) // On tente de résoudre la grille encore une fois, mais en interdisant un à un les chiffres de la liste des solutions
        {
            int numbersPlaced = 0; // Nombre de chiffres placés durant cette lecture de la grille

            for (int x = 0; x < size; x++)
            {
                for (int y = 0; y < size; y++)
                {
                    if (grid[x][y] == 0)
                    {
                        List<Integer> listPossibles = new ArrayList<>();
                        checkPossible(x, y); // Update les possibles de la case

                        Integer[] forbiddenNumber = solutions.get(solutionTested);
                        possibles[forbiddenNumber[0]][forbiddenNumber[1]][forbiddenNumber[2]] = false; // On interdit le chiffre de la liste qui correspond au nombre de solutions testées

                        for (int i = 0; i < size; i++) // Ajoute tous les possibles restants à la liste
                        {
                            if (possibles[x][y][i])
                                listPossibles.add(i + 1);
                        }
                        if (listPossibles.size() == 1) // Si cette case à un seul possible on le met dedans
                        {
                            grid[x][y] = listPossibles.get(0);
                            numbersPlaced++;
                        }
                    }
                }
            }
            if (this.isFull()) // Si une solution est trouvée, alors il n'y a pas de solution unique et on renvoie false
            {
                for (int x = 0; x < size; x++) // On restaure la grille
                {
                    for (int y = 0; y < size; y++)
                    {
                        grid[x][y] = gridCopy[x][y];
                    }
                }
                return false;
            }
            if (numbersPlaced == 0) // Si une lecture de la grille n'a pas réussi à placer un seul chiffre, alors il n'y a pas de solution avec cet interdit, on passe au suivant
            {
                solutionTested++;
                for (int x = 0; x < size; x++) // On restaure la grille
                {
                    for (int y = 0; y < size; y++)
                    {
                        grid[x][y] = gridCopy[x][y];
                    }
                }
            }
            if (solutionTested == solutions.size()) // Si tous les interdits ont été testés et qu'aucune solution n'a été trouvée, on renvoie true
            {
                for (int x = 0; x < size; x++) // On restaure la grille
                {
                    for (int y = 0; y < size; y++)
                    {
                        grid[x][y] = gridCopy[x][y];
                    }
                }
                return true;
            }
        }
    }

    public void solve(Grid grid) // Résout la grille passée en argument
    {
        while (!this.isFull())
        {
            for (int x = 0; x < size; x++)
            {
                for (int y = 0; y < size; y++)
                {
                    if (grid.grid[x][y] == 0)
                    {
                        List<Integer> listPossibles = new ArrayList<>();
                        checkPossible(x, y); // Update les possibles de la case
                        for (int i = 0; i < size; i++) // Ajoute tous les possibles restants à la liste
                        {
                            if (possibles[x][y][i])
                                listPossibles.add(i + 1);
                        }
                        if (listPossibles.size() == 1) // Si cette case à un seul possible on le met dedans
                        {
                            grid.grid[x][y] = listPossibles.get(0);
                        }
                    }
                }
            }
        }
    }

    public boolean isCorrect() // Vérifie si la grille est valide
    {
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                if(grid[x][y] != originalGrid[x][y])
                    return false;
            }
        }
        return true;
    }

    public void setDifficulty(int difficulty)
    {
        this.difficulty = difficulty;
    }

    //Secondaires
    private void fillZero() // Remplit la grille de zéros
    {
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                grid[x][y] = 0;
            }
        }
    }

    private void initPossibles() // initialise la liste des possibles à true
    {
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                for (int z = 0; z < size; z++)
                {
                    possibles[x][y][z] = true;
                }
            }
        }
    }

    private void checkPossible(int x, int y) // Update la liste des chiffres possibles pour les coordonnées données
    {
        for (int i = 0; i < size; i++)
        {
            possibles[x][y][i] = checkLine(x, i + 1) && checkColumn(y, i + 1) && checkSquare(x, y, i + 1);
        }
    }

    private boolean checkLine(int x, int nbrTest) // Vérifie si le nombre test est dans la ligne
    {
        for (int i = 0; i < size; i++)
        {
            if (nbrTest == grid[x][i])
                return false;
        }
        return true;
    }

    private boolean checkColumn(int y, int nbrTest) // Vérifie si le nombre test est dans la colonne
    {
        for (int i = 0; i < size; i++)
        {
            if (nbrTest == grid[i][y])
                return false;
        }
        return true;
    }

    private boolean checkSquare(int x, int y, int nbrTest) // Vérifie si le nombre test est dans son carré relatif
    {
        int rel_x = x % 3;
        int rel_y = y % 3;

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (grid[x - rel_x + i][y - rel_y + j] == nbrTest)
                    return false;
            }
        }
        return true;
    }

    private List<Integer> rollback(int x, int y) // Revient en arrière en marquant les nombres essayés comme faux et renvoie les nouvelles coordonnées de départ
    {
        List<Integer> coo = new ArrayList<>();
        List<Integer> listPossibles = new ArrayList<>();

        while (listPossibles.size() == 0)
        {
            if (y == 0) // Si on est en début de ligne, on remonte, on marque le test précédent comme faux et on vide la case
            {
                y = size - 1;
                x--;
                possibles[x][y][grid[x][y] - 1] = false;
                grid[x][y] = 0;
            } else if (y == 1)
            {
                y--;
                possibles[x][y][grid[x][y] - 1] = false;
                grid[x][y] = 0;
            } else // Sinon, on recule juste d'une case, on marque faux et on vide
            {
                y--;
                possibles[x][y][grid[x][y] - 1] = false;
                grid[x][y] = 0;
            }

            for (int i = 0; i < size; i++) // Ajoute tous les possibles de la case actuelle à la liste
            {
                if (possibles[x][y][i])
                    listPossibles.add(i + 1);
            }
        }

        coo.add(x); // On ajoute les coordonnées actuelles au retour
        coo.add(y);
        return coo;
    }

    private boolean isFull() // Vérifie si la grille est complète
    {
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                if (grid[x][y] == 0)
                    return false;
            }
        }
        return true;
    }
}
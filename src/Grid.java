import java.util.ArrayList;
import java.util.List;

public class Grid
{
    //Attributs
    private final int size = 9; // Taille de la grille
    public int[][] grid = new int[size][size];
    public boolean[][][] possibles = new boolean[size][size][size]; // Tableau de booléens listant les nombres possibles sur chaque case

    //Méthodes
        //Principales
    public void init() // Remplit la grille de Zéros et initialise la liste des possibles
    {
        this.fillZero();
        this.initPossibles();
    }
    public void display() // Affiche la grille
    {
        System.out.println("   1 2 3 4 5 6 7 8 9");
        System.out.println("  -------------------");
        for(int x = 0; x<size; x++)
        {
            System.out.print(x + " |");
            for(int y = 0; y<size; y++)
            {
                System.out.print(grid[x][y]);
                System.out.print("|");
            }
            System.out.print("\n");
            System.out.println("  -------------------");
        }
    }
    public void fill() // Génère une grille complète et cohérente
    {
        for(int x = 0; x < size; x++)
        {
            for(int y = 0; y < size; y++)
            {
                List<Integer> listPossibles = new ArrayList<>();

                checkPossible(x, y); // Update les possibles de la case
                for (int i = 0; i < size; i++) // Ajoute tous les possibles restants à la liste
                {
                    if (possibles[x][y][i])
                        listPossibles.add(i+1);
                }
                if (listPossibles.size() != 0) // S'il y a au moins un possible, on en choisi un au hasard et on teste
                {
                    grid[x][y] = listPossibles.get((int)(Math.random() * listPossibles.size()));
                }
                else // Sinon on rollback
                {
                    List<Integer> newCoo = this.rollback(x, y);
                    x = newCoo.get(0);
                    y = newCoo.get(1);

                    for (int i = 0; i < size; i++) // Puis on recommence
                    {
                        if (possibles[x][y][i])
                            listPossibles.add(i+1);
                    }
                    grid[x][y] = listPossibles.get((int)(Math.random() * listPossibles.size()));
                }
                this.display();
            }
        }
    }

        //Secondaires
    public void fillZero() // Remplit la grille de zéros
    {
        for(int x = 0; x<size; x++)
        {
            for(int y = 0; y<size; y++)
            {
                grid[x][y] = 0;
            }
        }
    }
    public void initPossibles() // initialise la liste des possibles à true
    {
        for(int x = 0; x < size; x++)
        {
            for(int y = 0; y < size; y++)
            {
                for(int z = 0; z < size; z++)
                {
                    possibles[x][y][z] = true;
                }
            }
        }
    }
    public void checkPossible(int x, int y) // Update la liste des chiffres possibles pour les coordonnées données
    {
        for (int i = 0; i < size; i++)
        {
            possibles[x][y][i] = checkLine(x, i+1) && checkColumn(y, i+1) && checkSquare(x, y, i+1);
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
                if (grid[x-rel_x+i][y-rel_y+j] == nbrTest)
                    return false;
            }
        }
        return true;
    }
    private List<Integer> rollback(int x, int y) //
    {
        List<Integer> coo = new ArrayList<>();
        List<Integer> listPossibles = new ArrayList<>();

        while (listPossibles.size() == 0)
        {
            listPossibles.clear(); // On vide la liste des possibles

            if (y == 0) // Si on est en début de ligne, on remonte, on marque le test précédent comme faux et on vide la case
            {
                y = size-1;
                x--;
                possibles[x][y][grid[x][y]-1] = false;
                grid[x][y] = 0;
            }
            else if (y == 1)
            {
                y--;
                possibles[x][y][grid[x][y]-1] = false;
                grid[x][y] = 0;
            }
            else // Sinon on recule juste d'une case, on marque faux et on vide
            {
                y--;
                possibles[x][y][grid[x][y]-1] = false;
                grid[x][y] = 0;
            }

            for (int i = 0; i < size; i++) // Ajoute tous les possibles de la case actuelle à la liste
            {
                if (possibles[x][y][i])
                    listPossibles.add(i+1);
            }
        }

        coo.add(x); // On ajoute les coordonnées actuelles au retour
        coo.add(y);
        return coo;
    }
}

class Main
{
    public static void main(String[] args)
    {
        Grid grid = new Grid();

        grid.init();
        grid.fill();
        grid.display();
        grid.hideNbr();
        grid.display();
        grid.solve(grid);
        grid.display();
    }
}
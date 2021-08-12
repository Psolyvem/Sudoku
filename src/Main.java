class Main
{
    public static void main(String[] args)
    {
        Grid grid = new Grid();

        grid.init();
        grid.fill();
        grid.display();
        grid.hideNbr(40);
        grid.display();

    }
}
package tabellen;

/**
 * Eine Klasse, die Tabellenausdruck-Methoden beinhaltet
 */
public class Tabelle {
    /**
     * Methode, um Funktionen auszudrucken
     * 
     * Bisher kein Parameter, deshalb funktioniert diese Methode bisher nicht
     */
    public void print()
    {
        for (int t=0;t<9;t++)
        {
            System.out.print(board[t] + "|"); 
            if (t==2 || t==5)
            {
                System.out.print("\n------\n");
            } 
        } 
        System.out.println("\n");
    }
}

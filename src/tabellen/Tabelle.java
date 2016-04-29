package tabellen;

public class Tabelle {
    void print(){
        for (int t=0;t<9;t++){
            System.out.print(board[t] + "|"); 
            if (t==2 || t==5){
                System.out.print("\n------\n");
            } 
        } 
        System.out.println("\n");
    }
}

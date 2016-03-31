public class Zoo {

     public static void main(String[] args) {
         Papagei alex = new Papagei();
         Ente dagobert =new Ente();

         dagobert.sagHallo();
         alex.sagAlter();
     }
}

/*public*/ class Ente {
    void sagHallo(){
        System.out.println("Quak");
    }
}
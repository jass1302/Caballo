package app;
import horse.caballo;
public class App {
    public static Boolean[][] tablero = new Boolean[8][8];
    public static void main(String[] args) throws Exception {
        //Se inicializa el tablero  
         caballo cab = new caballo();
        // Se invoca la función que resuelve el problema
         cab.cabalgar(3, 3);    // Partiendo de la posición 4,4
    }    
}
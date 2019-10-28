package horse;

import java.util.ArrayList;
import objeto.salto;
public class caballo {
    public static Boolean[][] tablero = new Boolean[8][8];
    ArrayList<salto> saltos = new ArrayList<>();
    private int maxSaltos = 0;
    public caballo(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = false;
            }

        }
    }
    public void cabalgar(int x,int y){
        maxSaltos++;
        saltos.clear();
        System.out.println(x+" "+y);
        tablero[x][y] = true; // Se pone en true el salto realizado
        //System.out.println(tablero[x][y]);
        imprimirTablero();    // Imprimimos el tablero con los saltos hasta el momento
        if(maxSaltos!=64){
            mover(x,y,true); //Se calculan los posibles saltos desde la ultima posicion
            for (salto s : saltos) {
                s.setSaltosPosibles(mover(s.getX(), s.getY(),false));
            }
            salto temp = siguiente();
            System.out.println("");
            cabalgar(temp.getX(), temp.getY());
        }
    }
    public salto siguiente(){
        salto temp = saltos.get(0);

        for (int i = 0; i < saltos.size(); i++) {
            if(saltos.get(i).getSaltosPosibles()<temp.getSaltosPosibles()){
            temp = saltos.get(i);
            }
        }
       // System.out.println("Saltos: "+temp.getSaltosPosibles());
        return temp;
    }
    public void imprimirTablero(){
        System.out.println("----------------------");   
        // Imprime el tablero
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print("["+tablero[i][j]+"]  ");
            }
            System.out.println("");
        }
        System.out.print("----------------------");
    }
    public boolean enTablero(int x, int y){ // Esta funcion revisa que no existan saltos fuera del tablero
        if((x>=0 && x<=7) && (y>=0 && y<=7)){
            if(tablero[x][y]){
                return false;
            }
            return true;
        }else{
            return false;
        }
    }

    public int mover(int x, int y,boolean sw){
        //
        // Vertical hacía arriba derecho
        if(sw){
        if(enTablero(x-2,y+1)){ saltos.add(new salto(x-2,y+1)); }
        // Vertical hacia arriba izquierdo
        if(enTablero(x-2,y-1)){ saltos.add(new salto(x-2,y-1)); }
        // Horizontal hacia arriba izquierdo
        if(enTablero(x-1,y-2)){ saltos.add(new salto(x-1,y-2)); }
        // Horizontal hacia arriba derecho
        if(enTablero(x-1,y+2)){ saltos.add(new salto(x-1,y+2)); }
        // Vertical hacia abajo derecho
        if(enTablero(x+2,y+1)){ saltos.add(new salto(x+2,y+1)); }
        // Vertical hacia abajo izquierdo
        if(enTablero(x+2,y-1)){ saltos.add(new salto(x+2,y-1)); }
        // Horizontal hacia abajo derecho
        if(enTablero(x+1,y+2)){ saltos.add(new salto(x+1,y+2)); }
        // Horizontal hacia abajo izquierdo
        if(enTablero(x+1,y-2)){ saltos.add(new salto(x+1,y-2)); }
        return 0; 
        } else{
            ArrayList<salto> temp = new ArrayList<>();
            if(enTablero(x-2,y+1)){ temp.add(new salto(x-2,y+1)); }
            // Vertical hacia arriba izquierdo
            if(enTablero(x-2,y-1)){ temp.add(new salto(x-2,y-1)); }
            // Horizontal hacia arriba izquierdo
            if(enTablero(x-1,y-2)){ temp.add(new salto(x-1,y-2)); }
            // Horizontal hacia arriba derecho
            if(enTablero(x-1,y+2)){ temp.add(new salto(x-1,y+2)); }
            // Vertical hacia abajo derecho
            if(enTablero(x+2,y+1)){ temp.add(new salto(x+2,y+1)); }
            // Vertical hacia abajo izquierdo
            if(enTablero(x+2,y-1)){ temp.add(new salto(x+2,y-1)); }
            // Horizontal hacia abajo derecho
            if(enTablero(x+1,y+2)){ temp.add(new salto(x+1,y+2)); }
            // Horizontal hacia abajo izquierdo
            if(enTablero(x+1,y-2)){ temp.add(new salto(x+1,y-2)); }    
            return temp.size();
        }
         
    }
    
    
}
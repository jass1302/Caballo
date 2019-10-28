package objeto;

public class salto {
    private int x;
    private int y;
    private int saltosPosibles;

    public salto(int i, int j) {
        this.x = i;
        this.y = j;
    }

    public int getSaltosPosibles() {
        return saltosPosibles;
    }

    public void setSaltosPosibles(int saltosPosibles) {
        this.saltosPosibles = saltosPosibles;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }
    /**
     * @return the y
     */
    public int getY() {
        return y;
    }
}
package Civitas;
import java.util.ArrayList;

public class Tablero {
    private int numCasillaCarcel; //entero que representa el número de la casilla donde está la carcel
    private ArrayList<Casilla> casillas; //contenedor de las casillas del juego
    private int porSalida; //Numero de veces que se ha pasado por la salida
    private Boolean tieneJuez; //para mostrar si el tablero dispone de casilla de ese tipo

    Tablero(int numCasillaCarcel) {

        //Si el índice que indica que el numero de casilla de la carcel no es mayor o igual que uno
        // Lo ignoraremos y haremos que la carcel sea la casilla 1.
        if (numCasillaCarcel>=1) {

            this.numCasillaCarcel=numCasillaCarcel;

        }

        else {

            numCasillaCarcel=1;

        }

        //Inicializamos el ArrayList vacío y añadimos la salida
        casillas = new ArrayList<Casilla>();
        Casilla Salida = new Casilla("Salida");
        casillas.add(Salida);

        //porSalida a 0 y tieneJuez a false
        porSalida=0;
        tieneJuez=false;

    }

    private Boolean correcto() {

    Boolean flag = true; //Se actualiza si no se cumplen las condiciones

    if (casillas.size()<numCasillaCarcel){

        flag = false;

    }

    //comprueba si tiene Juez
    if(tieneJuez=false) {

    flag = false;

    }

    return flag;

    }

    private Boolean correcto(int numCasilla) {

        Boolean flag = true;
        //llamamos al método anterior que ya realiza unas comprobaciones necesarias
        flag = correcto();

        //agregamos la nueva comprobacion
        if (numCasilla > casillas.size()) {

            flag=false;

        }

        return flag;

    }

    int getCarcel(){

        return numCasillaCarcel;

    }

    int getPorSalida(){

        if (porSalida>0){

        int auxiliar=porSalida; //auxiliar para guardar el valor de salida
        porSalida--;
        return auxiliar;

        }

        else {

            return porSalida;

        }

    }

    void añadeCasilla(Casilla casilla){

        //Comprobamos si hemos de añadir antes la casilla carcel antes de
        //la casilla que hemos recibido por parámetro
        if (casillas.size()==numCasillaCarcel) {
            Casilla Carcel = new Casilla("Carcel");
            casillas.add(Carcel);
            casillas.add(casilla);
        }
        else {
            casillas.add(casilla);

            //Volvemos a comprobar si tenemos que añadir la casilla carcel
            if(casillas.size()==numCasillaCarcel){
                Casilla Carcel = new Casilla("Carcel");
                casillas.add(Carcel);

            }

        }
    }

    void añadeJuez(){

        //Añadimos la casilla y actualizamos el Boolean
        Casilla juez = new Casilla("Juez");
        casillas.add(juez);
        tieneJuez=true;

    }

    Casilla getCasilla (int numCasilla){

        Boolean flag=true; //Para comprobar si son válidas las condiciones
        if (numCasilla<=casillas.size()){

            flag=false;

        }

        //Si es true, realizamos la siguiente comprobación
        if (flag==true) {

            flag=correcto(numCasilla);

        }

        //Si ambas comprobaciones son correctas, hacemos la última comprobación
        if (flag==true) {

            return getCasilla(numCasilla);

        }

        else {

            return null;

        }



    }

    int nuevaPosicion(int actual,int tirada){

        int destino; //Actual+tirada

        //Ver si el tablero es correcto
        if (correcto()==false){

            return -1;

        }

        destino = actual+tirada;

        //Ajustar la posición del tablero
        if (destino>casillas.size()){

            destino=destino-casillas.size();

        }

            return destino;

    }


    int calcularTirada (int origen, int destino){

        int tirada;

        tirada=destino-origen;

        //Ajustar tirada si es menor que 0 el resultado
        if (tirada<0) {

            tirada=tirada+casillas.size();

        }

        return tirada;

    }

}



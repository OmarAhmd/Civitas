package civitas;
import java.util.ArrayList;

public class MazoSorpresas {

    //Atributos de instancia
    private ArrayList<Sorpresa> sorpresas;  //Lista de cartas
    private Boolean barajada;               //Indica si el mazo ha sido barajada o no
    private int usadas;                    //Numero de cartas usadas
    private Boolean debug;                 //Activar o Desactivar el modo debug. Cuando está activo el mazo no se baraja
    private ArrayList<Sorpresa> cartas_especiales; //Almacena la carta SALIRCARCEL mientras la tenga el jugador
    private Sorpresa ultimaSorpresa;        //Almacena la ultima sorpresa que ha salido


    //Método para inicializar algunos atributos
    private void init(){
        sorpresas=new ArrayList<Sorpresa>();
        cartas_especiales=new ArrayList<Sorpresa>();
        barajada=false;
        usadas=0;
    }

    //Constructor sin parámetros
    MazoSorpresas(){
        init();
        debug=false;
    }

    //Constructor con parámetros
    MazoSorpresas(Boolean d){
        debug=d;

        init();
    }
}

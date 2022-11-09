package civitas;
import java.util.Random;


public class Dado {
    //Atributos de clase
    static final private Dado instance = new Dado();    //Patrón Singleton
    static private int SalidaCarcel = 5;

    //Atributos de instancia
    private Random random;
    private int ultimoResultado;
    private Boolean debug;

    //Constructor privado sin argumentos
    private Dado() {
        random = new Random();
        ultimoResultado = 0;
        debug = false;
    }

    //Consultor de clase para obtener la instancia del dado
    static Dado getInstance() {
        return instance;
    }

    //Método para tirar el dado
    int tirar() {

        if (!debug) {                                               //Si el modo debug está desactivado
            ultimoResultado=random.nextInt(1, 6);       // hacer una tirada enter 1 y 6
        }
        else{                                           // Si el modo debug está activado
            ultimoResultado=1;                          // siempre se devuelve 1
        }

        return ultimoResultado;
    }

    //Método para determinar si un jugador sale de la cárcel
    Boolean salgoDeLaCarcel(){
        if(random.nextInt(1,6) == SalidaCarcel){
            return true;
        }
        else {
            return false;
        }
    }

    //Método para decidir quien empieza
    int quienEmpieza(int n){
        return random.nextInt(0,n-1);
    }

    //Método para cambiar el modo debug
    void setDebug(Boolean d){
        debug=d;
        Diario diario = Diario.getInstance();
    }

    //Consultor del atributo ultimoResultado
    int getUltimoResultado(){
        return ultimoResultado;
    }
}

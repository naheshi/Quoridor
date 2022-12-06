import java.util.ArrayList;
import java.util.List;

public class QFinal {
    String[][] Tabla = new String[17][17];
    String[][] TablaInicial1 = new String[17][17];
    String[][] TablaPy2 = new String[17][17];
    /*
     * list es una colección ordenada de objetos en los que se pueden almacenar valores duplicados.
     * list conserva el orden de inserción, permite el acceso posicional y la inserción de elementos
     */
    List<String[][]> log1 = new ArrayList<>();
    List<String[][]> log2 = new ArrayList<>();
    int i, y;

    /*
     * manda el tablero (tablaInicial1) al constructor copiarTablero
     */
    public void Blanco() {
        log1.add(copiarTablero(TablaInicial1));
    } //Fin metodo Blanco
    /*
     * manda el tablero (TablaPy2) al constructor copiarTablero
     */
    public void Rojo() {
        log2.add(copiarTablero(TablaPy2));
    } //Fin metodo Rojo

    /*
     * Metodo constructor 
     * Su funcion es clonar el tablero en un String llamado copia para revolverlo y ser copiado en una lista de String[][] llamado log1 o log2.
     * String[][] tablero resive el tamaño en la list 
     * table.length es el tamaño del eje x
     * tablero[0].length es el tamaño del eje y
     * fil empieza por cero y aumenta el tamaño hasta que sea menor que el tamaño del list
     * tablero[fil].length indica el tamaño de la columna segun la fila
     * al final devuelve la Copia y se agrega al log en donde se guarda el registro
     */
    public String[][] copiarTablero(String[][] tablero) {
        String[][] Copia = new String[tablero.length][tablero[0].length];
        for (int fil = 0; fil < tablero.length; ++fil) {
            for (int col = 0; col < tablero[fil].length; ++col) {
                Copia[fil][col] = tablero[fil][col];
            }
        }
        return Copia;
    } //Fin metodo copiarTablero

    /*
     * For-each loop in Java
     * https://www.geeksforgeeks.org/for-each-loop-in-java/
     * Este metodo (imprimirLog) permite recorrer una lista de objetos o variables
     * primitivas, tiene la ventaja de que no es necesario utilizar una variable que
     * haga de contador ni requiere establecer una condición para comprobar si debe
     * finalizar la iteración. Fuente: https://open-bootcamp.com/cursos/java/bucles-for
     * como imprimirlo: https://www.delftstack.com/es/howto/java/java-print-2d-array/
     * 
     * 
     * Metodo constructor para imprimir la tabla
     * Se llama al metodo y se ingresa el log1 o log2 de tipo List String[][]
     * String[][] board : Registro significa
     * for(String[] line : board) el primer bucle for se itera sobre cada array en del array 2D
     * significa recorrer cada elemento de la matriz externa que establecerá line en la matriz de columnas actual.
     * mientras que el segundo bucle for se itera sobre los elementos individuales
     * String s : line  s es un elemento de "line"
     * String[] line : board line array es un elemento de board
     * String[][] board: registro board es un elemento de registro 2d array list
     */
    public static void imprimirLog(List<String[][]> Registro) {
        for (String[][] board : Registro) {
            System.out.println();
            System.out.println("----------------");
            for (String[] line : board) {
                System.out.println();
                for (String s : line) {
                    System.out.print(s);
                }
            }
        }
        System.out.println();
    } //Fin metodo imprimirlog

    /*
     * Metodo para imprimir el final
     * Se imprime la tabla del inicio 
     * Se hace llamado al constructor para imprimir las dos tabla
     */
    public void Imprimir() {
        System.out.println();
        System.out.println("La posición inicial de cada jugador");
        System.out.println();
        //Imprime la posición inicial
        for (i = 0; i < 17; i++) { 
            for (y = 0; y < 17; y++) {
                System.out.print(Tabla[i][y]);
            }
            System.out.print("\n");
        }
        System.out.println();
        System.out.println("Historial del recorrido del player 1");
        imprimirLog(log1);
        System.out.println("Fin de los movimientos del player 1");
        System.out.println();
        System.out.println("Historial del recorrido del player 2");
        imprimirLog(log2);
        System.out.println("Fin de los movimientos del player 2");
        System.out.println();
        System.out.println("Gracias por jugar, espero que te hayas divertido");
    }
}

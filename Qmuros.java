import java.util.Scanner;

public class Qmuros {
    String[][] TablaMuro = new String[17][17];
    int opc, i, y;
    // Variables de los muros del player1
    int cont = 0;
    int horizontalx, verticalx;
    int horizontaly, verticaly;
    int iniciador;
    // Fin variables de los muros del player1
    // Variables de los muros del player2
    int contpy2 = 0;
    int horizontalxpy2, verticalxpy2;
    int horizontalypy2, verticalypy2;
    int iniciadorpy2;
    // Fin variables de los muros del player 2
    // Variables para construir y verificar
    String muroX = "X";
    String space = " ";
    // Fin variables para construir y verificar
    Scanner MuroScan = new Scanner(System.in);

    public void muro1() {
        while (true) { // Inicio del ciclo WHILE
            try {
                System.out.println("---- Muro ----");
                System.out.println("1 - Horizontal");
                System.out.println("2 - Vertical");
                opc = MuroScan.nextInt();
                if (opc >= 1 && opc <= 2) { // Verifica la condicion
                    if (cont < 10) { // Verifica la cantidad de muros
                        if (opc == 1 && cont <= 10) { // Condicional de los muros horizontales
                            System.out.println("Ingrese el eje y");
                            horizontalx = MuroScan.nextInt();
                            System.out.println("Ingrese el eje x");
                            horizontaly = MuroScan.nextInt();
                            /*
                             * La condicion inicia verificando que el eje x(horizontalx) sea un numero del 0
                             * al 15 ademas de que sea impar. Como el tablero es 16x16 el eje x solamente
                             * podra ingresar en puntos impares. Si se usa par se pasaría a los cuadros de
                             * los jugadores
                             * La condicion del eje y(horizontaly) es que sea un numero del 0 al 14 ademas
                             * de que sea par.
                             * Tiene el limite de que sea par, es debido a que ocupa dos casillas y un
                             * espacio entre la casilla y el muro
                             * Si el eje y pasa a 15 se sale de la casilla.
                             */
                            if (horizontalx >= 0 && horizontalx <= 15 && horizontaly >= 0 && horizontaly <= 14
                                    && horizontalx % 2 != 0 && horizontaly % 2 == 0) {
                                iniciador = 0; // reinicia la variable del iniciador
                                for (i = 0; i < 17; i++) {
                                    for (y = 0; y < 17; y++) {
                                        /*
                                         * La construccion de los muros son de dos casilla abarcando uno de espacio
                                         * Esta verificacion verifica si se encuentra un muro primero recorriendo el
                                         * ciclo del arreglo y la posicion
                                         * Ejemplo: eje x 1, eje y 0
                                         * 1 0 y 1 0 y 1 1 y 1 2 Se compara y abarca los dos siguientes para saber si
                                         * hay o no muro
                                         */
                                        if (TablaMuro[i][y].equals(muroX)
                                                && TablaMuro[horizontalx][horizontaly].equals(muroX)
                                                && TablaMuro[horizontalx][horizontaly + 1].equals(muroX)
                                                && TablaMuro[horizontalx][horizontaly + 2].equals(muroX)) {
                                            iniciador = 0; // Valor que permite o no iniciar la condicion
                                            break; // termina el ciclo for si detecta muro
                                        }
                                        /*
                                         * Verifica si se encuentra espacio en caso de que se encuentre espacio, permite
                                         * iniciar la condicion
                                         */
                                        if (TablaMuro[i][y].equals(space)
                                                && TablaMuro[horizontalx][horizontaly].equals(space)
                                                && TablaMuro[horizontalx][horizontaly + 2].equals(space)) {
                                            iniciador = 1; // Valor que permite o no iniciar la condicion
                                            break; // termina el ciclo for si detecta espacio
                                        }
                                    } // Fin ciclo interno
                                } // Fin ciclo externo
                                  // Fin de la verificación
                                if (iniciador == 1) { // Verifica la condicion de los muros
                                    /*
                                     * Se usa i menor que 3 debido a que el eje X sigue siendo el mismo
                                     * lo unico que se expande a la horizontal es el eje y
                                     */
                                    for (i = 0; i < 3; i++) {
                                        TablaMuro[horizontalx][horizontaly + i] = muroX;
                                    }
                                    System.out.println();
                                    for (i = 0; i < 17; i++) { // Imprime la tabla
                                        for (y = 0; y < 17; y++) {
                                            System.out.print(TablaMuro[i][y]);
                                        }
                                        System.out.print("\n");
                                    }
                                    cont = cont + 1; // Contador de la cantidad de muros totales
                                    break; // rompe el ciclo while
                                } else {
                                    // En caso de que la condicion inciador = 0 porque hubo un muro ahi
                                    System.out.println("No se puede colocar un muro ahí");
                                }
                            } else { // validacion y verificar
                                System.out.println("Uno de los ejes que ingresó está incorrecto");
                            }
                        } else { // Muros verticales
                            System.out.println("Ingrese el eje x");
                            verticaly = MuroScan.nextInt();
                            System.out.println("Ingrese el eje y");
                            verticalx = MuroScan.nextInt();
                            /*
                             * El eje x (verticaly) debe der par y ir del 0 al 14, el eje y (verticalx) debe
                             * de ser impar y ir del 0 al 15
                             * El eje x es impar y va entre el espacio que hay entre los cuadros
                             * El eje y define en que posicion colorcarlo tomando que las casillas son pares
                             */
                            if (verticalx >= 0 && verticalx <= 14 && verticaly >= 0 && verticaly <= 15
                                    && verticalx % 2 == 0 && verticaly % 2 != 0) {
                                iniciador = 0; // reset del iniciador
                                for (i = 0; i < 17; i++) { // verifica los muros
                                    for (y = 0; y < 17; y++) {
                                        /*
                                         * La construccion de los muros son de dos casilla abarcando uno de espacio
                                         * Esta verificacion verifica si se encuentra un muro primero recorriendo el
                                         * ciclo del arreglo y la posicion
                                         * Ejemplo: eje x 1, eje y 0
                                         * 1 0 y 1 0 y 2 1 y 3 2 dado a que los muros en verticales aumenta los ejes de
                                         * la x por eso se compara de ese modo
                                         */
                                        if (TablaMuro[i][y].equals(muroX)
                                                && TablaMuro[verticalx][verticaly].equals(muroX)
                                                && TablaMuro[verticalx + 1][verticaly].equals(muroX)
                                                && TablaMuro[verticalx + 2][verticaly].equals(muroX)) {
                                            iniciador = 0; // Valor que permite o no iniciar la condicion
                                            break; //rompe el ciclo si encuentra un muro
                                        } 
                                        //Al contrario del otro este verifica si hay espacio
                                        if (TablaMuro[i][y].equals(space) 
                                                && TablaMuro[verticalx][verticaly].equals(space)
                                                && TablaMuro[verticalx + 2][verticaly].equals(space)
                                                && TablaMuro[verticalx + 1][verticaly].equals(space)) {
                                            iniciador = 1; // Valor que permite o no iniciar la condicion
                                            break; //rompe el ciclo si encuentra un espacio
                                        }
                                    }
                                }
                                if (iniciador == 1) {
                                    //Impresion de los muros aumentando el eje x y quedando igual el eje y
                                    for (i = 0; i < 3; i++) {
                                        TablaMuro[verticalx + i][verticaly] = muroX;
                                    }
                                    System.out.println();
                                    for (i = 0; i < 17; i++) { //Imprime el arreglo
                                        for (y = 0; y < 17; y++) {
                                            System.out.print(TablaMuro[i][y]);
                                        }
                                        System.out.print("\n");
                                    }
                                    cont = cont + 1; //cuenta la cantidad de muros totales
                                    break; //rompe el ciclo While
                                } else { //mensaje si encuentra muro
                                    System.out.println("No se puede colocar un muro ahí");
                                }
                            } else { //validacion y verificar
                                System.out.println("Uno de los ejes que ingresó está incorrecto");
                            }
                        }
                    } else { //Mensaje si el usuario supera el total de muros a usar
                        System.out.println("Ya ha usado los 10 muros");
                        break; //rompe el while
                    }
                } else { //rango de opciones
                    System.out.println("Elija una opción del 1 al 2");
                }

            } catch (Exception e) {
                System.out.println("Escribe solamente numeros enteros!");
                MuroScan.next();
            } // Fin Try-Catch
        }
    } //Fin metodo muro1

    public void muro2() {
        while (true) { // Inicio del ciclo WHILE
            try {
                System.out.println("---- Muro ----");
                System.out.println("1 - Horizontal");
                System.out.println("2 - Vertical");
                opc = MuroScan.nextInt();
                if (opc >= 1 && opc <= 2) { // Verifica la condicion
                    if (contpy2 < 10) { // Verifica la cantidad de muros
                        if (opc == 1) {   // Condicional de los muros horizontales
                            System.out.println("Ingrese el eje y");
                            horizontalxpy2 = MuroScan.nextInt();
                            System.out.println("Ingrese el eje x");
                            horizontalypy2 = MuroScan.nextInt();
                            /*
                             * La condicion inicia verificando que el eje x(horizontalxpy2) sea un numero del 0
                             * al 15 ademas de que sea impar. Como el tablero es 16x16 el eje x solamente
                             * podra ingresar en puntos impares. Si se usa par se pasaría a los cuadros de
                             * los jugadores
                             * La condicion del eje y(horizontalypy2) es que sea un numero del 0 al 14 ademas
                             * de que sea par.
                             * Tiene el limite de que sea par, es debido a que ocupa dos casillas y un
                             * espacio entre la casilla y el muro
                             * Si el eje y pasa a 15 se sale de la casilla.
                             */
                            if (horizontalxpy2 >= 0 && horizontalxpy2 <= 15 && horizontalypy2 >= 0
                                    && horizontalypy2 <= 14
                                    && horizontalxpy2 % 2 != 0 && horizontalypy2 % 2 == 0) {
                                iniciadorpy2 = 0; // reinicia la variable del iniciador
                                for (i = 0; i < 17; i++) {
                                    for (y = 0; y < 17; y++) { 
                                        /*
                                         * La construccion de los muros son de dos casilla abarcando uno de espacio
                                         * Esta verificacion verifica si se encuentra un muro primero recorriendo el
                                         * ciclo del arreglo y la posicion
                                         * Ejemplo: eje x 1, eje y 0
                                         * 1 0 y 1 0 y 1 1 y 1 2 Se compara y abarca los dos siguientes para saber si
                                         * hay o no muro
                                         */
                                        if (TablaMuro[i][y].equals(muroX)
                                                && TablaMuro[horizontalxpy2][horizontalypy2].equals(muroX)
                                                && TablaMuro[horizontalxpy2][horizontalypy2 + 1].equals(muroX)
                                                && TablaMuro[horizontalxpy2][horizontalypy2 + 2].equals(muroX)) {
                                            iniciadorpy2 = 0; // Valor que permite o no iniciar la condicion
                                            break; // termina el ciclo for si detecta muro
                                        }
                                        /*
                                         * Verifica si se encuentra espacio en caso de que se encuentre espacio, permite
                                         * iniciar la condicion
                                         */
                                        if (TablaMuro[i][y].equals(space)
                                                && TablaMuro[horizontalxpy2][horizontalypy2].equals(space)
                                                && TablaMuro[horizontalxpy2][horizontalypy2 + 2].equals(space)) {
                                            iniciadorpy2 = 1; // Valor que permite o no iniciar la condicion
                                            break; // termina el ciclo for si detecta muro
                                        }
                                    }
                                }
                                // Fin de la verificación
                                if (iniciadorpy2 == 1) { // Verifica la condicion de los muros
                                    /*
                                     * Se usa i menor que 3 debido a que el eje X sigue siendo el mismo
                                     * lo unico que se expande a la horizontal es el eje y
                                     */
                                    for (i = 0; i < 3; i++) {
                                        TablaMuro[horizontalxpy2][horizontalypy2 + i] = muroX;
                                    }
                                    System.out.println();
                                    for (i = 0; i < 17; i++) { // Imprime la tabla
                                        for (y = 0; y < 17; y++) {
                                            System.out.print(TablaMuro[i][y]);
                                        }
                                        System.out.print("\n");
                                    }
                                    contpy2 = contpy2 + 1; // Contador de la cantidad de muros totales
                                    break; // rompe el ciclo while
                                } else { // En caso de que la condicion inciador = 0 porque hubo un muro ahi
                                    System.out.println("No se puede colocar un muro ahí");
                                }
                            } else { // validacion y verificar
                                System.out.println("Uno de los ejes que ingresó está incorrecto");
                            }
                        } else {  // Muros verticales
                            System.out.println("Ingrese el eje x");
                            verticalypy2 = MuroScan.nextInt();
                            System.out.println("Ingrese el eje y");
                            verticalxpy2 = MuroScan.nextInt();
                            /*
                             * El eje x (verticaly) debe der par y ir del 0 al 14, el eje y (verticalxpy2) debe
                             * de ser impar y ir del 0 al 15
                             * El eje x es impar y va entre el espacio que hay entre los cuadros
                             * El eje y define en que posicion colorcarlo tomando que las casillas son pares
                             */
                            if (verticalxpy2 >= 0 && verticalxpy2 <= 14 && verticalypy2 >= 0 && verticalypy2 <= 15
                                    && verticalxpy2 % 2 == 0 && verticalypy2 % 2 != 0) {
                                iniciadorpy2 = 0; // reset del iniciador
                                for (i = 0; i < 17; i++) { // verifica los muros
                                    for (y = 0; y < 17; y++) {
                                        /*
                                         * La construccion de los muros son de dos casilla abarcando uno de espacio
                                         * Esta verificacion verifica si se encuentra un muro primero recorriendo el
                                         * ciclo del arreglo y la posicion
                                         * Ejemplo: eje x 1, eje y 0
                                         * 1 0 y 1 0 y 2 1 y 3 2 dado a que los muros en verticales aumenta los ejes de
                                         * la x por eso se compara de ese modo
                                         */
                                        if (TablaMuro[i][y].equals(muroX)
                                                && TablaMuro[verticalxpy2][verticalypy2].equals(muroX)
                                                && TablaMuro[verticalxpy2 + 1][verticalypy2].equals(muroX)
                                                && TablaMuro[verticalxpy2 + 2][verticalypy2].equals(muroX)) {
                                            iniciadorpy2 = 0; // Valor que permite o no iniciar la condicion
                                            break; //rompe el ciclo si encuentra un muro
                                        }
                                        //Al contrario del otro este verifica si hay espacio
                                        if (TablaMuro[i][y].equals(space) 
                                                && TablaMuro[verticalxpy2][verticalypy2].equals(space)
                                                && TablaMuro[verticalxpy2 + 2][verticalypy2].equals(space)
                                                && TablaMuro[verticalxpy2 + 1][verticalypy2].equals(space)) {
                                            iniciadorpy2 = 1; // Valor que permite o no iniciar la condicion
                                            break; //rompe el ciclo si encuentra un espacio
                                        }
                                    }
                                }
                                if (iniciadorpy2 == 1) {
                                    //Impresion de los muros aumentando el eje x y quedando igual el eje y
                                    for (i = 0; i < 3; i++) {
                                        TablaMuro[verticalxpy2 + i][verticalypy2] = muroX;
                                    }
                                    System.out.println();
                                    for (i = 0; i < 17; i++) { //Imprime el arreglo
                                        for (y = 0; y < 17; y++) {
                                            System.out.print(TablaMuro[i][y]);
                                        }
                                        System.out.print("\n");
                                    }
                                    contpy2 = contpy2 + 1; //cuenta la cantidad de muros totales
                                    break; //rompe el ciclo While
                                } else { //mensaje si encuentra muro
                                    System.out.println("No se puede colocar un muro ahí");
                                }
                            } else { //validacion y verificar
                                System.out.println("Uno de los ejes que ingresó está incorrecto");
                            }
                        }
                    } else { //Mensaje si el usuario supera el total de muros a usar
                        System.out.println("Ya ha usado los 10 muros");
                        break; //rompe el while
                    }
                } else { //rango de opciones
                    System.out.println("Elija una opción del 1 al 2");
                }

            } catch (Exception e) {
                System.out.println("Escribe solamente numeros enteros!");
                MuroScan.next();
            } // Fin Try-Catch
        } 
    } //Fin metodo muro2
} //Fin class Qmuros

import java.util.Scanner;

public class QMovimiento {
    String[][] TablaMovimiento = new String[17][17];
    String salir;
    int interrumpido, iniciador;
    // Variables del Player 1
    int ejeyD; // guarda los ejes
    int opc, y, i, k = 1, ky = 0; // contadores
    char cuadro = 0x25A0;
    int contA = 0, contB, contC;
    int ContadorDerecha = 10;
    int ContadorIzquierda = 6;
    int controlP = 1, ControlAtras = 0;
    int Movi = 0;
    int Vcontrol = 8;
    int Ycontrol;
    int guardY = 8; // Variable que almacena las columnas y borra puntos
    String player1 = "B";
    Scanner moviscan = new Scanner(System.in);
    // Fin de las variables del player 1
    int ganador; // Variable que declara quién gana
    // Variables del Player 2
    int ejeyDX;
    int opx, l = 1, lk = 0;
    String player2 = "R";
    int contQ = 16, contU = 14, contP = 16; // cambio en el contU de 16 a 14
    int ContadorDerechaAz = 10;
    int ContadorIzquierdaAz = 6;
    int controlQ = 1, ControlAzAtras = 0; // cambio en atras
    int MoviAz = 16;
    int Xcontrol = 8;
    int Zcontrol = 16;
    int guardAzY = 8;
    // Fin de las variables del player 2

    // Variables de los muros
    int muroT = 0;
    int muroY = 0;
    String muro = "X";
    String space = " ";
    // Variables de los muros player 1
    int frente1, frente2;
    int atras1, atras2;
    int derecha1, izquierda1;
    int derechaSuma = 9, izquierdaSuma = 7;
    int frenteSuma = 1, atrasSuma = -1;
    // Fin variables de los muros player 1
    // Variables de los muros player 2
    int frente1py2, frente2py2;
    int atras1py2, atras2py2;
    int derecha1py2, izquierda1py2;
    int derechaSumaPY2 = 9, izquierdaSumaPY2 = 7;
    int frentesSumaPY2 = 15, atrasSumaPY2 = 17;
    // Fin variables de los muros player 2
    // Fin de las varaibles de los muros
    // Feedback
    int conT, conT2;
    // Fin Feedback
    public void Movimiento() {
        while (true) {
            try {
                System.out.println("---- Player 1 B ----"); // Inicio player 1
                System.out.println("1. Mover ficha");
                System.out.println("2. Mover muro"); // Luego hacer esto y poner la verificacion correspondiente
                System.out.println("3. Salir(rendirse)");
                opc = moviscan.nextInt();
                System.out.println();
                if (opc >= 1 && opc <= 3) {
                    if (opc == 1) {
                        System.out.println("1. Mover hacia delante");
                        System.out.println("2. Mover hacia atras");
                        System.out.println("3. Mover hacia la derecha");
                        System.out.println("4. Mover hacia la izquierda");
                        opc = moviscan.nextInt();
                        if (opc >= 1 && opc <= 4) {
                            // Primer movimiento del usuario hacia adelante
                            if (opc == 1 && k != 0 && guardY == 8 && controlP == 1) {
                                frente1 = 0; // reset de la variable
                                /*
                                 * Las dos condiciones verifica si hacia adelante de el se encuentra un muro
                                 * como los movimiento de los peones son pares se verifica en la casilla impar
                                 * en este caso manteniendo el eje y pero aumentando en 1 para que sea impar el
                                 * eje x
                                 */
                                if (TablaMovimiento[contA + 1][guardY].equals(muro)) {
                                    frente1 = 0;
                                }
                                if (TablaMovimiento[contA + 1][guardY].equals(space)) {
                                    frente1 = 1;
                                }
                                // Fin verificación
                                // si no hay muro permite iniciar el movimiento
                                if (frente1 == 1) {
                                    ejeyD = 8;
                                    TablaMovimiento[2][ejeyD] = player1;
                                    /*
                                     * guardY es la variable que guarda el eje y para usarlo cuando se borre en los
                                     * siguientes movimientos.
                                     * Vcontrol guarda el eje y pero se utiliza en la variable de movimiento
                                     * Ycontrol es asignado 2 para luego calcular los muros y movimiento
                                     * frenteSuma realiza una suma a si misma para luego calcular la posicion de los
                                     * muros, frentesuma inicia en 1
                                     * atrasSuma se le asigna 1
                                     */
                                    guardY = ejeyD;
                                    Vcontrol = ejeyD;
                                    Ycontrol = 2;
                                    frenteSuma = frenteSuma + 2;
                                    atrasSuma = 1;
                                    // Borra el player y le ingresa un cuadro
                                    // Character.toString transforma un char a un String
                                    TablaMovimiento[contA][guardY] = Character.toString(cuadro);
                                    /*
                                     * Movi cuenta el siguiente movimiento hacia adelante para borrarlo en los otros
                                     * movimientos
                                     * contA cuenta el siguiente movimiento hacia adelante
                                     */
                                    Movi = contA + 2;
                                    contA = contA + 4;
                                    // Imprime la tabla
                                    for (i = 0; i < 17; i++) {
                                        for (y = 0; y < 17; y++) {
                                            System.out.print(TablaMovimiento[i][y]);
                                        }
                                        System.out.print("\n");
                                    }
                                    System.out.println();
                                    /*
                                     * ky=0 permite iniciar el movimiento opc == 1 && ky == 1
                                     * k=0 permite inicia el primer movimiento hacia atras
                                     */
                                    k = 0;
                                    ky = 1;
                                    break;
                                } else {
                                    // en caso de haber un muro no permite iniciar
                                    System.out.println("Hay un muro al frente tuyo");
                                }
                            } else if (opc == 2 && k != 1 && guardY == 8 && controlP == 1) {
                                // primer movimiento hacia atras
                                atras1 = 0;
                                /*
                                 * Verifica si al regresar hay un un muro quedando impar porque los muros
                                 * horizontales se encuentra en las posicion impar
                                 */
                                if (TablaMovimiento[1][ejeyD].equals(muro)) {
                                    atras1 = 0;
                                }
                                if (TablaMovimiento[1][ejeyD].equals(space)) {
                                    atras1 = 1;
                                }
                                if (atras1 == 1) {
                                    ejeyD = 8;
                                    // Vuelve a la posicion de inicio
                                    TablaMovimiento[0][ejeyD] = player1;
                                    /*
                                     * guardY guarda el eje y de ejeyD
                                     * contA realiza una resta de posicion
                                     * frenteSuma sirve para verificar los muros iniciando por 1
                                     * atrasSuma vuelve a 0 para verificar los muros
                                     */
                                    guardY = ejeyD;
                                    contA = contA - 4;
                                    frenteSuma = frenteSuma - 2;
                                    atrasSuma = -1;
                                    // elimina la posicion anterior y pone un cuadro
                                    TablaMovimiento[2][guardY] = Character.toString(cuadro);
                                    for (i = 0; i < 17; i++) {
                                        for (y = 0; y < 17; y++) {
                                            System.out.print(TablaMovimiento[i][y]);
                                        }
                                        System.out.print("\n");
                                    }
                                    /*
                                     * k permite iniciar el primer movimiento otra vez
                                     * ky permite iniciar las otras opciones derecha izquierda, adelante
                                     * Ycontrol vuelve a 0 siendo el ejeY
                                     * Movi vuelve a 0 siendo el ejeY
                                     */
                                    k = 1;
                                    ky = 1;
                                    Ycontrol = 0;
                                    Movi = 0;
                                    break;
                                } else {
                                    System.out.println("Hay un muro atrás tuyo");
                                }
                            } else if (opc == 3 && ContadorDerecha <= 16) {
                                // Movimiento hacia la derecha
                                derecha1 = 0;
                                /*
                                 * Verifica si a la derecha hay un muro o no, siendo derechaSuma 9 lo cual
                                 * indica el espacio entre los cuadros
                                 */
                                if (TablaMovimiento[Ycontrol][derechaSuma].equals(muro)) {
                                    derecha1 = 0;
                                }
                                if (TablaMovimiento[Ycontrol][derechaSuma].equals(space)) {
                                    derecha1 = 1;
                                }
                                // Inicia si no hay muro
                                if (derecha1 == 1) {
                                    /*
                                     * Ycontrol toma la posicion guardada en el movimiento hacia delante o
                                     * hacia atras
                                     * Movi igual toma la posicion en el movimiento hacia delante o hacia
                                     * atras
                                     * ContadorDerecha suma 2 a la posicion actual siendo 8+2
                                     * guardY guarda el antiguo eje y
                                     */
                                    TablaMovimiento[Ycontrol][ContadorDerecha] = player1;
                                    TablaMovimiento[Movi][guardY] = Character.toString(cuadro);
                                    /*
                                     * guardY guardara el ejey del contador
                                     * Vcontrol variable que se usa en el movimiento hacia adelante o atras tendra
                                     * el valor ese designado
                                     * contA es la variable que usa el movimiento hacia adelante
                                     * contB es la variable que usa el movimiento hacia atras
                                     * contC guarda el valor para ser borrado en el movimiento hacia atras
                                     * Como se mueve hacia la derecha los contadores ContadorDerecha y
                                     * ContadorIzquierda aumentan en dos
                                     * Al igual que los contadores la verificacion de muros aumentan en dos
                                     * (izquierdaSuma y derechaSuma)
                                     */
                                    guardY = ContadorDerecha;
                                    Vcontrol = ContadorDerecha;
                                    contA = Ycontrol + 2;
                                    contB = Ycontrol - 2;
                                    contC = Ycontrol;
                                    ContadorDerecha = ContadorDerecha + 2;
                                    ContadorIzquierda = ContadorIzquierda + 2;
                                    derechaSuma = derechaSuma + 2;
                                    izquierdaSuma = izquierdaSuma + 2;
                                    // Imprime la tabla
                                    for (i = 0; i < 17; i++) {
                                        for (y = 0; y < 17; y++) {
                                            System.out.print(TablaMovimiento[i][y]);
                                        }
                                        System.out.print("\n");
                                    }
                                    /*
                                     * Ky permite inicializar los movimientos alternos a los primeros movimientos
                                     * ControlP es desactivado y no permite el movimiento del primer hacia atras
                                     * ControlAtras tiene valor 1 permitiendo el otro movimiento hacia atras
                                     */
                                    ky = 1;
                                    controlP = 0;
                                    ControlAtras = 1;
                                    break; // termina el while
                                } else {
                                    // en caso de haber muro no permite iniciar el movimiento
                                    System.out.println("Hay un muro hacia su derecha");
                                }
                            } else if (opc == 4 && ContadorIzquierda >= 0) {
                                // Movimiento hacia la izquierda
                                izquierda1 = 0;
                                /*
                                 * Verifica si a la izquierda hay un muro o no, siendo izquierdaSuma 7 lo cual
                                 * indica el espacio entre los cuadros
                                 */
                                if (TablaMovimiento[Ycontrol][izquierdaSuma].equals(muro)) {
                                    izquierda1 = 0;
                                }
                                if (TablaMovimiento[Ycontrol][izquierdaSuma].equals(space)) {
                                    izquierda1 = 1;
                                }
                                // si no hay muro inicia
                                if (izquierda1 == 1) {
                                    /*
                                     * Ycontrol toma la posicion guardada en el movimiento hacia delante o
                                     * hacia atras
                                     * Movi toma la posicion en el movimiento hacia delante o hacia
                                     * atras
                                     * ContadorIzquierda resta 2 a la posicion actual siendo 8-2
                                     * guardY guarda el antiguo eje y
                                     */
                                    TablaMovimiento[Ycontrol][ContadorIzquierda] = player1;
                                    TablaMovimiento[Movi][guardY] = Character.toString(cuadro);
                                    /*
                                     * guardY guarda la nueva posicion del contadorIzquierda
                                     * Vcontrol guarda la nueva posicion del contadorIzquierda
                                     * contB guarda el valor para usarse en el movimiento hacia atras
                                     * conC guarda el valor para eliminar en el movimiento hacia atras
                                     * conA aumenta y se usa en el movimiento hacia adelante
                                     * Como se hace un movimiento hacia la izquierda los contadores deben de
                                     * retroceder 2 pasos
                                     * contadores: derechaSuma, izquierdaSuma, ContadorDerecha, ContadorIzquierda
                                     * Los dos primero se usan en la verificacion del muro
                                     */
                                    guardY = ContadorIzquierda;
                                    Vcontrol = ContadorIzquierda;
                                    contB = Ycontrol - 2;
                                    contC = Ycontrol;
                                    contA = Ycontrol + 2;
                                    ContadorDerecha = ContadorDerecha - 2;
                                    ContadorIzquierda = ContadorIzquierda - 2;
                                    derechaSuma = derechaSuma - 2;
                                    izquierdaSuma = izquierdaSuma - 2;
                                    // Imprime la tabla
                                    for (i = 0; i < 17; i++) {
                                        for (y = 0; y < 17; y++) {
                                            System.out.print(TablaMovimiento[i][y]);
                                        }
                                        System.out.print("\n");
                                    }
                                    /*
                                     * ky permite inicia el movimiento hacia adelante y atras
                                     * controlP desactiva los primeros movimientos
                                     * controlatras permite iniciar el movimiento hacia atras
                                     */
                                    ky = 1;
                                    controlP = 0;
                                    ControlAtras = 1;
                                    break; // termina el ciclo
                                } else {
                                    // si no hay muro se imprime el mensaje
                                    System.out.println("Hay un muro hacia su izquierda");
                                }
                            } else if (opc == 1 && ky == 1) {
                                frente2 = 0; // reset a la variable
                                /*
                                 * Movimiento hacia adelante
                                 * Verifica si hacia adelante hay un muro o un espacio tomando el valor de que
                                 * frenteSuma es una suma impar es decir un eje x que ve en las posiciones
                                 * impares
                                 */
                                if (TablaMovimiento[frenteSuma][Vcontrol].equals(muro)) {
                                    frente2 = 0;
                                }
                                if (TablaMovimiento[frenteSuma][Vcontrol].equals(space)) {
                                    frente2 = 1;
                                }
                                // si la condicion es verdadera inicia
                                if (frente2 == 1) {
                                    /*
                                     * el primer cambio al array es el movimiento donde contA tiene + 2 en posicion
                                     * hacia adelante
                                     * y Movi en el mismo cuadro que estaba para así borrarlo
                                     * Vcontrol y guardY poseen el mismo eje y
                                     */
                                    TablaMovimiento[contA][Vcontrol] = player1;
                                    TablaMovimiento[Movi][guardY] = Character.toString(cuadro);
                                    /*
                                     * Ycontrol guarda la posicion para usarse en los movimientos hacia la derecha o
                                     * izquierda
                                     * contA hace una suma para avanzar hacia el siguiente cuadro
                                     * conC resta la posicion de contA menos 2 para usarse en el movimiento hacia
                                     * atras
                                     * Movi se le suma 2 para que si avanza hacia delante otra vez borre la posicion
                                     * en que estaba
                                     * contB se le resta Movi menos 2 para obtener la posicion en que retrocede el
                                     * movimiento hacia atras
                                     * guardY guarda el eje en Vcontrol
                                     * FrenteSuma y atrasSuma suman 2 posiciones para luego poder verificar si hay
                                     * un muro ya sea adelante del usuario o atras
                                     */
                                    Ycontrol = contA;
                                    contA = contA + 2;
                                    contC = contA - 2;
                                    Movi = Movi + 2;
                                    contB = Movi - 2;
                                    guardY = Vcontrol;
                                    frenteSuma = frenteSuma + 2;
                                    atrasSuma = atrasSuma + 2;
                                    // Imprime la tabla
                                    for (i = 0; i < 17; i++) {
                                        for (y = 0; y < 17; y++) {
                                            System.out.print(TablaMovimiento[i][y]);
                                        }
                                        System.out.print("\n");
                                    }
                                    controlP = 0; // Desactiva el primer movimiento hacia atras y adelante
                                    ControlAtras = 1; // Activa el movimiento hacia atras
                                    break;
                                } else {
                                    // Mensaje si hay muro
                                    System.out.println("Hay un muro al frente tuyo");
                                }
                            } else if (opc == 2 && ky == 1 && contB != -2 && ControlAtras == 1) {
                                /*
                                 * Movimiento hacia atras
                                 * Verifica si hacia atras hay muro
                                 * atrasSuma verifica una posicion menos en el eje x es decir contB-1
                                 */
                                atras2 = 0;
                                if (TablaMovimiento[atrasSuma][Vcontrol].equals(muro)) {
                                    atras2 = 0;
                                }
                                if (TablaMovimiento[atrasSuma][Vcontrol].equals(space)) {
                                    atras2 = 1;
                                }
                                // inicia si no hay muro
                                if (atras2 == 1) {
                                    /*
                                     * contB guarda los valores obtenidos en el movimiento hacia delante, izquierda y derecha
                                     * Vcontrol guarda el ejey en los anteriores movimientos
                                     * contC obtiene el antiguo eje para borrar el player
                                     * guardY tiene almacenado el antiguo eje y 
                                     */
                                    TablaMovimiento[contB][Vcontrol] = player1;
                                    TablaMovimiento[contC][guardY] = Character.toString(cuadro);
                                    /*
                                     * Ycontrol guarda el valor de contB para usarlo en los movimientos hacia la
                                     * derecha o izquierda
                                     * Movi guarda contB para borrarlo y convertirlo en cuadro
                                     * contB se le resta por si quiere regresar hacia atras otra vez
                                     * contA se le resta igual para usarse en el movimiento hacia atras
                                     * contC se le resta la posicion del contA para borrar el player y ser
                                     * reemplazado por cuadro
                                     * frenteSuma y atrasSuma se le resta para poder verificar si encuentra muro en
                                     * las nueva posiciones
                                     */
                                    Ycontrol = contB;
                                    Movi = contB;
                                    contB = contB - 2;
                                    contA = contA - 2;
                                    contC = contA - 2;
                                    frenteSuma = frenteSuma - 2;
                                    atrasSuma = atrasSuma - 2;
                                    // Imprime la tabla
                                    for (i = 0; i < 17; i++) {
                                        for (y = 0; y < 17; y++) {
                                            System.out.print(TablaMovimiento[i][y]);
                                        }
                                        System.out.print("\n");
                                    }
                                    // Desactiva los primeros movimientos
                                    controlP = 0;
                                    /*
                                     * En caso de que al eliminar termine en un valor negativo este se le asigne
                                     * nuevos valores y reiniciar los contadores
                                     * controlAtras se vuelve 0 haciendo que no se pueda volver hacia atras sin
                                     * volver a moverse hacia adelante
                                     */
                                    if (contB == -2) {
                                        /*
                                         * Si al restar y queda en -2 se resetea el contador y desactiva el movimiento
                                         */
                                        contB = 2;
                                        ControlAtras = 0;
                                    }
                                    break;
                                } else {
                                    // Mensaje si hay muro
                                    System.out.println("Hay un muro atrás tuyo");
                                }
                            } else {
                                /*
                                 * Si el usuario ingreso un movimiento no valido no permite iniciar cualquier
                                 * movimiento
                                 * por ejemplo: si quiso ir hacia atras sin primero mover hacia adelante en el
                                 * primer movimiento
                                 */
                                System.out.println("Movimiento invalido");
                            }
                        }
                    } else if (opc == 2) {
                        /*
                         * Si el usuario quiere ingresar un muro le asigna un valor a muroT para que en
                         * el Main pueda acceder al condicional
                         * en break termina el ciclo
                         */
                        muroT = 1;
                        break;
                    } else {
                        /*
                         * Si el usuario al ingresar este menu confirma escribiendo EXIT termina el
                         * programa
                         * Hay una condicional en el otro caso si toca 1 volvera hacia atras al menu del
                         * jugador
                         * Le asigna valor a interrumpido para que pueda cerrar en el MAIN
                         */
                        System.out.println("Escriba EXIT para salir");
                        System.out.println("Escriba 1 para volver hacia atrás");
                        salir = moviscan.next();
                        if (salir.equals("EXIT") || salir.equals("1")) {
                            if (salir.equals("EXIT")) {
                                interrumpido = 1;
                                break;
                            } else {

                            }
                        } else {
                            System.out.println("Escriba una opción valida");
                        }
                    }
                } else {
                    System.out.println("Elije una opción del 1 al 3");
                } // Fin del player 1
            } catch (Exception e) {
                System.out.println("Escribe solamente numeros enteros!");
                moviscan.next();
            }
        }
    }

    public void Azul() {
        /*
         * Como el player2 es el inverso del player 1 los movimientos hacia adelante se
         * hace al contrario es decir hacia adelante resta y hacia atras suma con
         * respecto a los movimientos hacia la derecha y izquierda no cambian
         */
        while (true) { // Inicio del ciclo While
            try {
                System.out.println("---- Player 2 R ----"); // Inicio player 2
                System.out.println("1. Mover ficha");
                System.out.println("2. Mover muro");
                System.out.println("3. Salir(rendirse)");
                opx = moviscan.nextInt();
                if (opx >= 1 && opx <= 3) {
                    if (opx == 1) {
                        System.out.println("1. Mover hacia delante");
                        System.out.println("2. Mover hacia atras");
                        System.out.println("3. Mover hacia la derecha");
                        System.out.println("4. Mover hacia la izquierda");
                        opx = moviscan.nextInt();
                        if (opx >= 1 && opx <= 4) {
                            // Primer movimiento hacia adelante
                            if (opx == 1 && l != 0 && guardAzY == 8 && controlQ == 1) {
                                /*
                                 * contQ tiene valor 16 pero restando 1 queda en 15 como habia mencionado para
                                 * ir hacia adelante se resta y en esto la verificacion de muro se hace de esta
                                 * forma
                                 */
                                frente1py2 = 0; //reset de la variable
                                if (TablaMovimiento[contQ - 1][guardAzY].equals(muro)) {
                                    frente1py2 = 0;
                                }
                                if (TablaMovimiento[contQ - 1][guardAzY].equals(space)) {
                                    frente1py2 = 1;
                                }
                                // Si la condicion cumple inicia
                                if (frente1py2 == 1) {
                                    ejeyDX = 8;
                                    TablaMovimiento[14][ejeyDX] = player2;
                                    /*
                                     * guardAzY guarda el valor de ejeyDX
                                     * Xcontrol guarda el valor de ejeyDX
                                     * Zcontrol se le asigna 14
                                     * frentesSumaPY2 se le resta debido a que está subiendo en el arreglo
                                     * atrasSumaPY2 se le asigna 15 
                                     */
                                    guardAzY = ejeyDX;
                                    Xcontrol = ejeyDX;
                                    Zcontrol = 14;
                                    frentesSumaPY2 = frentesSumaPY2 - 2;
                                    atrasSumaPY2 = 15;
                                    TablaMovimiento[contQ][guardAzY] = Character.toString(cuadro);
                                    // MoviAz se le resta contQ 
                                    // Siendo 16-2 para ser borrado luego
                                    MoviAz = contQ - 2;
                                    //contQ se usa para los movimientos hacia adelante restado 16-4
                                    contQ = contQ - 4;
                                    //Imprime la tabla
                                    for (i = 0; i < 17; i++) {
                                        for (y = 0; y < 17; y++) {
                                            System.out.print(TablaMovimiento[i][y]);
                                        }
                                        System.out.print("\n");
                                    }
                                    System.out.println();
                                    l = 0; // Permite iniciar el primer movimiento hacia atras
                                    lk = 1; // Permite iniciar el movimiento hacia delante o atras
                                    break;
                                } else {
                                    // Si hay muro no permite ir hacia adelante
                                    System.out.println("Hay un muro al frente tuyo");
                                }
                            } else if (opx == 2 && l != 1 && guardAzY == 8 && controlQ == 1) { // Primer movimiento a
                                                                                               // hacia atras
                                /*
                                 * Verifica si en el eje de las x en la posicion 15 se encuentra un muro o no
                                 */
                                atras1py2 = 0; //reset de la variable
                                if (TablaMovimiento[15][ejeyDX].equals(muro)) {
                                    atras1py2 = 0;
                                }
                                if (TablaMovimiento[15][ejeyDX].equals(space)) {
                                    atras1py2 = 1;
                                }
                                if (atras1py2 == 1) {
                                    ejeyDX = 8;
                                    TablaMovimiento[16][ejeyDX] = player2;
                                    /*
                                     * guardAzy guarda la vairable ejeyDX
                                     * contQ como se movio hacia adelante en 4 posicion para volver hacia atras o el primer movimiento se le suma 4
                                     * frentesSumaPY2 se le suma 2 al contador para verificar si hay muro
                                     * atrasSumaPY2 se le asigna como valor 16
                                     */
                                    guardAzY = ejeyDX;
                                    contQ = contQ + 4; 
                                    frentesSumaPY2 = frentesSumaPY2 + 2;
                                    atrasSumaPY2 = 17;
                                    TablaMovimiento[14][guardAzY] = Character.toString(cuadro);
                                    // Imprime el tablero
                                    for (i = 0; i < 17; i++) {
                                        for (y = 0; y < 17; y++) {
                                            System.out.print(TablaMovimiento[i][y]);
                                        }
                                        System.out.print("\n");
                                    }
                                    System.out.println();
                                    /*
                                     * l se asigna 1 para que pueda iniciar el primer movimiento hacia adelante
                                     * lk se le asigna 1 para que pueda iniciar los movimientos hacia adelante y atras
                                     * Zcontrol se le asigna valor 16
                                     * MoviAZ se le asigna valor 16
                                     */
                                    l = 1;
                                    lk = 1;
                                    Zcontrol = 16;
                                    MoviAz = 16;
                                    break;
                                } else {
                                    System.out.println("Hay un muro atrás");
                                }
                            } else if (opx == 3 && ContadorDerechaAz <= 16) {
                                //Movimiento hacia la derecha
                                derecha1py2 = 0; //reset de la variable
                                /*
                                 * Verifica si a su derecha encuentra un muro o no 
                                 * En caso de no encontrar le asigna valor 1 para que inicie
                                 */
                                if (TablaMovimiento[Zcontrol][derechaSumaPY2].equals(muro)) {
                                    derecha1py2 = 0;
                                }
                                if (TablaMovimiento[Zcontrol][derechaSumaPY2].equals(space)) {
                                    derecha1py2 = 1;
                                }
                                if (derecha1py2 == 1) {
                                    TablaMovimiento[Zcontrol][ContadorDerechaAz] = player2;
                                    TablaMovimiento[MoviAz][guardAzY] = Character.toString(cuadro);
                                    /*
                                     * guardAzy guarda el valor del contadorDerechaAZ
                                     * Xcontrol guarda el valor del contadorDerechaAZ
                                     * contU guarda el eje x de zcontrol para usarlo en el borrado
                                     * contQ toma el valor de Zcontrol y le resta 2 para usarse en el movimiento hacia adelante
                                     * ContadorDerechaAz y contadorIzquierdaAZ aumentan en 2 si se avanza hacia la derecha
                                     * derechaSumaPY2 y izquierdaSumaPY2 aumenta en 2 posiciones
                                     */
                                    guardAzY = ContadorDerechaAz;
                                    Xcontrol = ContadorDerechaAz;
                                    contU = Zcontrol;
                                    contQ = Zcontrol - 2; 
                                    ContadorDerechaAz = ContadorDerechaAz + 2;
                                    ContadorIzquierdaAz = ContadorIzquierdaAz + 2;
                                    derechaSumaPY2 = derechaSumaPY2 + 2;
                                    izquierdaSumaPY2 = izquierdaSumaPY2 + 2;
                                    //impresion del tablero
                                    for (i = 0; i < 17; i++) {
                                        for (y = 0; y < 17; y++) {
                                            System.out.print(TablaMovimiento[i][y]);
                                        }
                                        System.out.print("\n");
                                    }
                                    System.out.println();
                                    /*
                                     * lk activa los movimientos hacia adelante y atras
                                     * controlQ desactiva los primeros movimientos
                                     * controlAzAtras activa el movimiento hacia atras
                                     * iniciador sirve para controlar si estan juntos en otro metodo
                                     */
                                    lk = 1;
                                    controlQ = 0;
                                    ControlAzAtras = 1;
                                    iniciador = 1; 
                                    break; //rompe el ciclo While
                                } else {
                                    System.out.println("Hay un muro a la derecha");
                                }
                            } else if (opx == 4 && ContadorIzquierdaAz >= 0) {
                                //Movimiento hacia la izquierda
                                izquierda1py2 = 0; //reset de la variable
                                /*
                                 * Verifica si a la izquierda hay un muro o no, siendo izquierdaSumaPY2 7 lo cual
                                 * indica el espacio entre los cuadros
                                 */
                                if (TablaMovimiento[Zcontrol][izquierdaSumaPY2].equals(muro)) {
                                    izquierda1py2 = 0;
                                }
                                if (TablaMovimiento[Zcontrol][izquierdaSumaPY2].equals(space)) {
                                    izquierda1py2 = 1;
                                }
                                if (izquierda1py2 == 1) {
                                    //Inicia si no hay muro
                                    /*
                                     * Ycontrol toma la posicion guardada en el movimiento hacia delante o
                                     * hacia atras
                                     * MoviAz toma la posicion en el movimiento hacia delante o hacia
                                     * atras
                                     * ContadorIzquierdaAz resta 2 a la posicion actual siendo 8-2
                                     * guardAzY guarda el antiguo eje y
                                     */
                                    TablaMovimiento[Zcontrol][ContadorIzquierdaAz] = player2;
                                    TablaMovimiento[MoviAz][guardAzY] = Character.toString(cuadro);
                                    /*
                                     * guardAzY guarda el eje y del ContadorIzquierdaAz 
                                     * Xcontrol guarda el eje y del ContadorIzquierdaAZ
                                     * contU guarda el eje x para ser usado en el movimiento hacia atras en el borrado
                                     * contQ hace un resta y se usa para el movimiento hacia adelante
                                     * ContadorDerechaAz y ContadorIzquierdaAz el movimiento al ir a la izquierda se le resta
                                     * DerechaSumaPY2 y izquierdaSumaPY2 como van a la izquierda se le resta -2 pero al impar
                                     */
                                    guardAzY = ContadorIzquierdaAz;
                                    Xcontrol = ContadorIzquierdaAz;
                                    contU = Zcontrol;
                                    contQ = Zcontrol - 2;
                                    ContadorDerechaAz = ContadorDerechaAz - 2;
                                    ContadorIzquierdaAz = ContadorIzquierdaAz - 2;
                                    derechaSumaPY2 = derechaSumaPY2 - 2;
                                    izquierdaSumaPY2 = izquierdaSumaPY2 - 2;
                                    // imprime la tabla
                                    for (i = 0; i < 17; i++) {
                                        for (y = 0; y < 17; y++) {
                                            System.out.print(TablaMovimiento[i][y]);
                                        }
                                        System.out.print("\n");
                                    }
                                    System.out.println();
                                    /*
                                     * lk activa los movimientos hacia adelante y atras
                                     * controlQ desactiva los primeros movimientos
                                     * controlAzAtras activa el movimiento hacia atras
                                     * iniciadro permite iniciar el metodo Juntos
                                     */
                                    lk = 1;
                                    controlQ = 0;
                                    ControlAzAtras = 1;
                                    iniciador = 1; // iniciador cuando están juntos
                                    break; //termina el ciclo While
                                } else {
                                    System.out.println("Hay un muro a tu izquierda");
                                }
                            } else if (opx == 1 && lk == 1) {
                                frente2py2 = 0;
                                /*
                                 * Movimiento hacia adelante
                                 * Verifica si hacia adelante hay un muro o un espacio tomando el valor de que
                                 * frenteSuma es una suma impar es decir un eje x que ve en las posiciones
                                 * impares
                                 */
                                if (TablaMovimiento[frentesSumaPY2][Xcontrol].equals(muro)) {
                                    frente2py2 = 0;
                                }
                                if (TablaMovimiento[frentesSumaPY2][Xcontrol].equals(space)) {
                                    frente2py2 = 1;
                                }
                                if (frente2py2 == 1) {
                                    //Inicia si no hay muro
                                    /*
                                     * el primer cambio al array es el movimiento donde contA tiene - 2 en posicion
                                     * hacia adelante
                                     * y Movi en el mismo cuadro que estaba para así borrarlo
                                     * Xcontrol y guardAzY poseen el mismo eje y
                                     */
                                    TablaMovimiento[contQ][Xcontrol] = player2;
                                    TablaMovimiento[MoviAz][guardAzY] = Character.toString(cuadro);
                                    /*
                                     * Zcontrol guarda el eje x de contQ para controlar el eje x de los movimientos hacia adelante y izquierda
                                     * contQ al avanzar hacia arriba se le resta 2
                                     * contU se usa para el borrado en el movimiento hacia atras y se borra 2 casillas
                                     * MoviAz se usa para el borrado en el movimiento hacia adelante y se borra 2 casillas
                                     * contP se usa para el movimiento hacia atras y suma MoviAZ dos posiciones para poder avanzar hacia atras y borrar el dato que dejó
                                     * guardAzY guardará el eje x de Xcontrol
                                     * frentesSumaPY2 y atrasSumaPY2 se restan 2 para la verificacion del muro
                                     */
                                    Zcontrol = contQ;
                                    contQ = contQ - 2;
                                    contU = contU - 2;
                                    MoviAz = MoviAz - 2;
                                    contP = MoviAz + 2;
                                    guardAzY = Xcontrol;
                                    frentesSumaPY2 = frentesSumaPY2 - 2;
                                    atrasSumaPY2 = atrasSumaPY2 - 2;
                                    //Impresion de tabla
                                    for (i = 0; i < 17; i++) {
                                        for (y = 0; y < 17; y++) {
                                            System.out.print(TablaMovimiento[i][y]);
                                        }
                                        System.out.print("\n");
                                    }
                                    System.out.println();
                                    /*
                                     * controlQ desactiva los dos primeros movimientos
                                     * controlAzAtras permite ingresar al movimiento hacia atras
                                     * iniciador sirve para verificar cuando estan juntos
                                     */
                                    controlQ = 0;
                                    ControlAzAtras = 1;
                                    iniciador = 1; // iniciador cuando están juntos
                                    break; //termina el ciclo
                                } else {
                                    System.out.println("Hay un muro al frente");
                                }
                            } else if (opx == 2 && lk == 1 && contP != 18 && ControlAzAtras == 1) { 
                                //Movimiento hacia atras
                                atras2py2 = 0;
                                /*
                                 * Movimiento hacia atras
                                 * Verifica si hacia atras hay muro
                                 * atrasSumaPY2 verifica una posicion mas en el eje x es decir +1
                                 */
                                if (TablaMovimiento[atrasSumaPY2][Xcontrol].equals(muro)) {
                                    atras2py2 = 0;
                                }
                                if (TablaMovimiento[atrasSumaPY2][Xcontrol].equals(space)) {
                                    atras2py2 = 1;
                                }
                                if (atras2py2 == 1) {
                                    /*
                                     * contP guarda los valores obtenidos en el movimiento hacia delante, izquierda y derecha
                                     * Xcontrol guarda el ejey en los anteriores movimientos
                                     * contU obtiene el antiguo eje para borrar el player
                                     * guardAzY tiene almacenado el antiguo eje y 
                                     */
                                    TablaMovimiento[contP][Xcontrol] = player2;
                                    TablaMovimiento[contU][guardAzY] = Character.toString(cuadro);
                                    /*
                                     * Zcontrol obtiene el valor de contP para usarse en el movimiento izquierda y derecha
                                     * MoviAz guarda el valor para borrarlo en el movimiento izquierda y derecha
                                     * contP como va hacia atras aumenta en 2 para ir atras
                                     * contQ aumenta en dos casilla para ir hacia adelante 
                                     * contU aumenta en dos para el borrado
                                     * frentesSumaPY2 y atrasSumaPY aumentan dado a que va hacia abajo
                                     */
                                    Zcontrol = contP;
                                    MoviAz = contP;
                                    contP = contP + 2;
                                    contQ = contQ + 2;
                                    contU = contQ + 2;
                                    frentesSumaPY2 = frentesSumaPY2 + 2;
                                    atrasSumaPY2 = atrasSumaPY2 + 2;
                                    //impresion de la tabla
                                    for (i = 0; i < 17; i++) {
                                        for (y = 0; y < 17; y++) {
                                            System.out.print(TablaMovimiento[i][y]);
                                        }
                                        System.out.print("\n");
                                    }
                                    System.out.println();
                                    /*
                                     * controlQ desactiva los primeros movimientos
                                     * iniciador permite la verificacion si estan juntos
                                     */
                                    controlQ = 0;
                                    iniciador = 1; // iniciador cuando están juntos
                                    if (contP == 18) {
                                        /*
                                         * Si al sumar y queda en 18 se resetea el contador y desactiva el movimiento
                                         */
                                        contP = 14;
                                        ControlAzAtras = 0;
                                    }
                                    break;
                                } else {
                                    System.out.println("Hay un muro atrás");
                                }
                            } else {
                                /* 
                                 * En caso de que el usuario esté mal ubicado o ninguna condicional se cumpla va a tirar un mensaje de error
                                 */
                                System.out.println("Movimiento invalido");
                            }
                        }
                    } else if (opx == 2) {
                        muroY = 1;
                        break;
                    } else {
                        /*
                         * Si el usuario al ingresar este menu confirma escribiendo EXIT termina el
                         * programa
                         * Hay una condicional en el otro caso si toca 1 volvera hacia atras al menu del
                         * jugador
                         * Le asigna valor a interrumpido para que pueda cerrar en el MAIN
                         */
                        System.out.println("Escriba EXIT para salir");
                        System.out.println("Escriba 1 para volver hacia atrás");
                        salir = moviscan.next();
                        if (salir.equals("EXIT") || salir.equals("1")) {
                            if (salir.equals("EXIT")) {
                                interrumpido = 1;
                                break;
                            } else {

                            }
                        } else {
                            System.out.println("Escriba una opción valida");
                        }
                    }
                } else {
                    // Mensaje de verificacion en caso de no seleccionar ninguno
                    System.out.println("Elije una opción del 1 al 3");
                }
            } catch (Exception e) {
                System.out.println("Escribe solamente numeros enteros!");
                moviscan.next();
            } // Fin Try-Catch
        }
    } // Fin Class Azul

    public void Ganador() {
        /*
         * La condicion revisa si en esa posicion se encuentra el player 1 en caso de
         * que se encuentre imprime el mensaje y manda a volver la variable ganador en 1
         * al main
         */
        if (TablaMovimiento[16][0].equals(player1) || TablaMovimiento[16][2].equals(player1)
                || TablaMovimiento[16][4].equals(player1) || TablaMovimiento[16][6].equals(player1)
                || TablaMovimiento[16][8].equals(player1) || TablaMovimiento[16][10].equals(player1)
                || TablaMovimiento[16][12].equals(player1) || TablaMovimiento[16][14].equals(player1)
                || TablaMovimiento[16][16].equals(player1)) {
            System.out.println("Ha ganado el player 1" + player1);
            ganador = 1;
        } else if (TablaMovimiento[0][0].equals(player2) || TablaMovimiento[0][2].equals(player2)
                || TablaMovimiento[0][4].equals(player2) || TablaMovimiento[0][6].equals(player2)
                || TablaMovimiento[0][8].equals(player2) || TablaMovimiento[0][10].equals(player2)
                || TablaMovimiento[0][12].equals(player2) || TablaMovimiento[0][14].equals(player2)
                || TablaMovimiento[0][16].equals(player2)) {
            /*
             * La condicion revisa si en esa posicion se encuentra el player 2 en caso de
             * que se encuentre imprime el mensaje y manda a volver la variable ganador en 1
             * al main
             */
            System.out.println("Ha ganado el player 2" + player2);
            ganador = 1;
        } else {

        }
    } //Fin metodo Ganador

    public void Juntos() {
        int sumacontA, sumacontB; // variables hacia adelante
        sumacontA = contA - 2;
        sumacontB = contQ + 2;
        if (sumacontA == sumacontB && Vcontrol == Xcontrol) {
            /*
             * Si los ejes de los dos peones coinciden estos se re-escribe por un 0
             * indicando que están ahí
             */
            TablaMovimiento[sumacontA][Xcontrol] = "o";
            System.out.println();
            System.out.println("Los dos peones se encuentran en la misma casilla");
            System.out.println();
            for (i = 0; i < 17; i++) {
                for (y = 0; y < 17; y++) {
                    System.out.print(TablaMovimiento[i][y]);
                }
                System.out.print("\n");
            }
            System.out.println();
        }
        // Condiciones de actualizacion del player 1
        /*
         * Si en la posicion del player2 es un cuadro pero se encuentra el player 1
         * vuelve a imprimir el player 2 cuando se mueve el player 1
         */
        if (TablaMovimiento[Movi][guardY].equals(player1)
                && TablaMovimiento[MoviAz][guardAzY].equals(Character.toString(cuadro))) {
            TablaMovimiento[MoviAz][guardAzY] = player2;
            System.out.println();
            System.out.println("Actualizando posición de los peones tras separarse...");
            System.out.println();
            // imprime la tabla
            for (i = 0; i < 17; i++) {
                for (y = 0; y < 17; y++) {
                    System.out.print(TablaMovimiento[i][y]);
                }
                System.out.print("\n");
            }
        }
        /*
         * Si en la posicion del player2 es un cuadro pero se encuentra el player 1
         * vuelve a imprimir el player 2 cuando se mueve el player 1
         */
        if (TablaMovimiento[contU][guardAzY].equals(Character.toString(cuadro))
                && TablaMovimiento[contC][guardY].equals(player1) && iniciador == 1) {
            TablaMovimiento[contU][guardAzY] = player2;
            System.out.println();
            System.out.println("Actualizando posición de los peones tras separarse...OwO");
            System.out.println();
            // imprime la tabla
            for (i = 0; i < 17; i++) {
                for (y = 0; y < 17; y++) {
                    System.out.print(TablaMovimiento[i][y]);
                }
                System.out.print("\n");
            }
        }
        // Fin de las condiciones de actualizacion del player 1
        // Condiciones de actualizacion del player 2
        /*
         * Si se encuentra el player 2 pero en los ejes del player 1 es un cuadro al
         * salir se remplaza con el player 1
         */
        if (TablaMovimiento[MoviAz][guardAzY].equals(player2)
                && TablaMovimiento[Movi][guardY].equals(Character.toString(cuadro))) {
            TablaMovimiento[Movi][guardY] = player1;
            System.out.println();
            System.out.println("Actualizando posición de los peones tras separarse...");
            System.out.println();
            // imprime la tabla
            for (i = 0; i < 17; i++) {
                for (y = 0; y < 17; y++) {
                    System.out.print(TablaMovimiento[i][y]);
                }
                System.out.print("\n");
            }
        }
        // Fin condiciones de actualizacion del player 2
    } //Fin metodo Juntos

    public void feedback1() {
        int ejeO, ejeI;
        /*
         * verifica la posicion del player 1 y imprime sus ejes con el contador de muro
         */
        for (i = 0; i < 17; i++) {
            for (y = 0; y < 17; y++) {
                if (TablaMovimiento[i][y].equals(player1)) {
                    ejeO = i;
                    ejeI = y;
                    System.out.println("El player 1 " + player1 + " se encuentra en " + ejeO + " x " + ejeI + " y");
                    System.out.println("Cantidad de muros usado = " + conT);
                    System.out.println();
                }
            }
        }
    } //Fin metodo feedback1

    public void feedback2() {
        int ejeY, ejeX;
        /*
         * verifica la posicion del player 2 y imprime sus ejes con el contador de muro
         */
        for (i = 0; i < 17; i++) {
            for (y = 0; y < 17; y++) {
                if (TablaMovimiento[i][y].equals(player2)) {
                    ejeX = i;
                    ejeY = y;
                    System.out.println("El player 2 " + player2 + " se encuentra en " + ejeX + " x " + ejeY + " y");
                    System.out.println("Cantidad de muros usado = " + conT2);
                    System.out.println();
                }
            }
        }
    } //Fin metodo feedback2
} //Fin class QMovimiento

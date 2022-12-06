import java.util.Scanner;

public class QuoridorMain {
    public static void main(String[] args) {
        // Declaraciones de objetos
        QPresentacion hoja = new QPresentacion();
        QTable tabla = new QTable();
        QMovimiento movi = new QMovimiento();
        Qmuros muro = new Qmuros();
        QFinal recorrido = new QFinal();
        // Fin de declaraciones de objetos
        // Variables contadores y de opcion
        int opc;
        int cont = 0;
        // Fin variables contadores y de opcion
        Scanner MainScan = new Scanner(System.in);
        // LLamado del metodo table2
        tabla.table2();
        // Se clona la tabla Qtabla1 a Tabla
        recorrido.Tabla = tabla.Qtabla1;
        while (true) {
            try {
                hoja.Presentacion();
                System.out.println("1 - Iniciar juego");
                System.out.println("2 - Salir");
                System.out.print("Opción = ");
                opc = MainScan.nextInt();
                System.out.println();
                if (opc >= 1 && opc <= 2) { // verifica el rango de número
                    if (opc == 1) { // Inicia el juego
                        tabla.table(); // Construye la tabla
                        movi.TablaMovimiento = tabla.Qtabla; // Clona la tabla de QTable a Qmovimiento
                        while (true) { // Inicio ciclo while
                            movi.Movimiento(); // Movimiento del player 1
                            movi.Juntos(); // Verifica si los dos player están juntos
                            movi.feedback1(); // Feedback del primer jugador
                            muro.TablaMuro = movi.TablaMovimiento; // Clonado de tablero en la clase QMovimiento a
                                                                   // QMuros
                            movi.Ganador(); // Verifica si ha llegado a la meta
                            /*
                             * Aquí se clona la tabla de TablaMovimiento hacia TablaInicial1 para luego
                             * usarse en el metodo Blanco
                             */
                            recorrido.TablaInicial1 = movi.TablaMovimiento;
                            recorrido.Blanco();
                            if (movi.muroT == 1) { // Condicional para iniciar los muros
                                muro.muro1(); // Entra a la clase muro1
                                movi.TablaMovimiento = muro.TablaMuro; // Clonado del tablero en la clase QMuros a
                                                                       // Qmovimiento
                                /*
                                 * Aquí se clona la tabla de TablaMovimiento hacia TablaInicial1 para luego
                                 * usarse en el metodo Blanco
                                 */
                                recorrido.TablaInicial1 = muro.TablaMuro;
                                recorrido.Blanco();
                                movi.conT = muro.cont; // Clona la variable para la clase feedback
                                movi.muroT = 0; // reset a la variable murot para que no active otra vez la opcion de
                                                // los muros
                            }
                            if (movi.ganador == 1) { // Verifica si hay un ganador
                                recorrido.Imprimir();
                                cont = 1;
                                break; // rompe la condicional
                            } else if (movi.interrumpido == 1) { // Verifica si fue interrumpido el juego
                                System.out.println();
                                System.out.println("PARTIDA INTERRUMPIDA");
                                recorrido.Imprimir();
                                cont = 1;
                                break; // rompe la condicional
                            } else if (cont == 1) { // verifica si cont es igual a 1
                                break; // termina el juego
                            } else {
                                movi.Azul(); // Movimiento del player 2
                                movi.Juntos(); // Verifica si los dos player se encuentran juntos
                                movi.feedback2(); // Manda un feedback del player 2
                                muro.TablaMuro = movi.TablaMovimiento; // Clona la tabla de QMovimiento a Qmuro
                                movi.Ganador(); // Verifica si alguien gano
                                /*
                                 * Aquí se clona la tabla de TablaMovimiento hacia TablaPy2 para luego
                                 * usarse en el metodo Rojo
                                 */
                                recorrido.TablaPy2 = movi.TablaMovimiento;
                                recorrido.Rojo();
                                if (movi.muroY == 1) { // Verifica si el usuario eligio la opción de muro
                                    muro.muro2(); // Inicia los muros
                                    movi.TablaMovimiento = muro.TablaMuro; // Clona la tabla de Qmuros a Qmovimiento
                                    /*
                                     * Aquí se clona la tabla de TablaMovimiento hacia TablaPy2 para luego
                                     * usarse en el metodo Rojo
                                     */
                                    recorrido.TablaPy2 = muro.TablaMuro;
                                    recorrido.Rojo();
                                    movi.conT2 = muro.contpy2; // Clona el contador para feedback
                                    movi.muroY = 0; // Reset de la condicional
                                }
                                if (movi.ganador == 1) { // Condicional del ganador
                                    recorrido.Imprimir();
                                    cont = 1;
                                    break; // Rompe la condicional
                                }
                                if (movi.interrumpido == 1) { // Verifica si fue interrumpido el juego
                                    System.out.println();
                                    System.out.println("PARTIDA INTERRUMPIDA");
                                    recorrido.Imprimir();
                                    cont = 1;
                                    break; // Rompe la condicional
                                }
                            }
                        }
                    } else { // Finaliza el juego si escribe 2
                        break;
                    }
                    if (cont == 1) {
                        break; // termina el juego
                    }
                } else { // Manda un mensaje para que el usuario escriba el rango de numero
                    System.out.println("Elija una opción del 1 al 2");
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println("Escribe solamente numeros enteros!");
                MainScan.next();
            } // Fin Try-Catch
        }
        MainScan.close();
    } // Fin Main
} // Fin Class

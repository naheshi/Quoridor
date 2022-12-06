public class QTable {
    String[][] Qtabla = new String[17][17]; //Declaracion de la tabla
    String[][] Qtabla1 = new String[17][17];
    String space = " ";
    int i, y;
    char cuadro=0x25A0; //Unicode Hexadecimal de un cuadrito https://unicodemap.org/details/0x25A0/index.html

    public void table() { 
        //Construccion de la tabla
        for (i = 0; i < 17; i++) {
            for (y = 0; y < 17; y++) {
                if (i % 2 == 0 && y % 2 == 0) { //Condicional si el eje x y y son pares
                    Qtabla[i][y] = Character.toString(cuadro); //Se rellena de cuadros los pares
                } else { //En caso contrario se rellena con un espacio
                    Qtabla[i][y] = space;
                }
            }
        }
        Qtabla[0][8]="B"; //Asigna la posicion del player1
        Qtabla[16][8]="R"; //Asigna la posicion del player2
        for (i = 0; i < 17; i++) { //Ciclo para imprimir la tabla
            for (y = 0; y < 17; y++) {
                System.out.print(Qtabla[i][y]);
            }
            System.out.print("\n");
        }
        System.out.println();
        System.out.println("Player 1 = " + "B");
        System.out.println("Player 2 = " + "R");
        System.out.println("Cada uno tiene 10 muros a su disposición " + "| | | | | | | | | |");
        System.out.println();
    } //Fin metodo table

    /*
     * Este metodo solamente se utiliza para copiar la tabla para usarse en la clase QFinal
     */
    public void table2() { 
        //Construccion de la tabla
        for (i = 0; i < 17; i++) {
            for (y = 0; y < 17; y++) {
                if (i % 2 == 0 && y % 2 == 0) { //Condicional si el eje x y y son pares
                    Qtabla1[i][y] = Character.toString(cuadro); //Se rellena de cuadros los pares
                } else { //En caso contrario se rellena con un espacio
                    Qtabla1[i][y] = space;
                }
            }
        }
        Qtabla1[0][8]="B"; //Asigna la posicion del player1
        Qtabla1[16][8]="R"; //Asigna la posicion del player2
    } //Fin metodo table2
} //Fin Class QTABLE

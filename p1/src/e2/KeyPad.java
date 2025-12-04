package e2;

import java.util.HashSet;
import java.util.Set;

public class KeyPad {
    public static boolean isValidKeyPad(char[][] keyPad) {
        if (keyPad == null || keyPad.length == 0) {
            return false; // Teclado no debe ser nulo ni vacío
        }

        int columnas = keyPad[0].length; // Número de columnas en la primera fila
        Set<Character> seen = new HashSet<>(); // Conjunto para almacenar caracteres únicos
        String validChars = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Lista de caracteres válidos

        // Recorrer cada fila del teclado y validar caracteres únicos y válidos
        for (char[] fila : keyPad) {
            if (fila == null || fila.length != columnas) {
                return false; // Verificar que todas las filas tengan la misma longitud (rectangular)
            }
            for (char c : fila) {
                if (seen.contains(c)) {
                    return false; // Carácter duplicado encontrado
                }
                if (validChars.indexOf(c) == -1) {
                    return false; // Carácter inválido encontrado
                }
                seen.add(c); // Añadir carácter al conjunto de caracteres vistos
            }
        }

        // Validación del orden secuencial: por filas o por columnas
        StringBuilder orderByRows = new StringBuilder();
        StringBuilder orderByColumns = new StringBuilder();

        // Construir cadena secuencial por filas
        for (char[] fila : keyPad) {
            for (char c : fila) {
                orderByRows.append(c);
            }
        }

        // Construir cadena secuencial por columnas
        for (int col = 0; col < columnas; col++) {
            for (char[] fila : keyPad) {
                orderByColumns.append(fila[col]);
            }
        }

        // Verificar si el teclado está en orden secuencial por filas o por columnas
        String keyPadOrderByRows = orderByRows.toString();
        String keyPadOrderByColumns = orderByColumns.toString();

        return validChars.startsWith(keyPadOrderByRows) || validChars.startsWith(keyPadOrderByColumns);
    }



    public static boolean areValidMovements(String[] movements){
        if (movements==null){
            return false;
        }//if

        for (String movement:movements){
            if (movement==null || !movement.matches("[UDLR]*")){
                return false;
            }//if
        }//for
        return true;
    }// areValidMovements

    public static String obtainCode(char[][] keyPad, String[] movements){
        if (!isValidKeyPad(keyPad)){
            throw new IllegalArgumentException("Teclado inválido");
        } else if(!areValidMovements(movements)) {
            throw new IllegalArgumentException("Movimientos inválidos");
        } //if

        StringBuilder code=new StringBuilder();
        int x=0, y=0; // pos inicial

        int filas = keyPad.length;
        int columnas = keyPad[0].length;

        for (String movement:movements){
            for (char c : movement.toCharArray()){
                switch (c){
                    case 'U':
                        if (x>0) x--;
                        break;
                    case 'D':
                        if (x<filas-1) x++;
                        break;
                    case 'L':
                        if (y>0) y--;
                        break;
                    case 'R':
                        if (y<columnas-1) y++;
                        break;
                }//switch
            }//for
            code.append(keyPad[x][y]);
        }//for
        return code.toString();
    }//obtainCode
}//KeyPadd
package com.mycompany.triqui;

import java.util.Scanner;

public class Triqui {
    static char[][] tablero = new char[3][3];
    /**
    static char[][] tablero = {
                                {'X', 'O', ' '},
                                {' ', 'X', ' '},
                                {'O', 'O', 'X'}
                              };
                              * */
    /**
    static char[][] tablero = {
                                {' ', ' ', 'O'},
                                {' ', 'O', ' '},
                                {'O', 'X', 'X'}
                              };
                              * */
    /**
    static char[][] tablero = {
                                {'X', ' ', 'O'},
                                {'X', 'O', ' '},
                                {'X', 'O', 'X'}
                              };
                              * */

    static boolean esTurnoDelJugador1 = true;
    
    public static boolean esTriquiPorDiagonalPrincipal(){
        if(tablero[0][0] == tablero[1][1] && tablero[0][0] == tablero[2][2] && (tablero[0][0] == 'X' || tablero[0][0] == 'O')){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static boolean esTriquiPorDiagonalInvertida(){
        if(tablero[0][2] == tablero[1][1] && tablero[0][2] == tablero[2][0] && (tablero[0][2] == 'X' || tablero[0][2] == 'O')){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static boolean esTriquiPorUnaColumna(){
        if(
                (tablero[0][0] == tablero[1][0] && tablero[0][0] == tablero[2][0] && (tablero[0][0] == 'X' || tablero[0][0] == 'O')) //columna 1
                || (tablero[0][1] == tablero[1][1] && tablero[0][1] == tablero[2][1] && (tablero[0][1] == 'X' || tablero[0][1] == 'O')) //columna 2
                || (tablero[0][2] == tablero[1][2] && tablero[0][2] == tablero[2][2] && (tablero[0][2] == 'X' || tablero[0][2] == 'O')) //columna 3
        ){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static boolean esTriquiPorUnaFila(){
        if(
                (tablero[0][0] == tablero[0][1] && tablero[0][0] == tablero[0][2] && (tablero[0][0] == 'X' || tablero[0][0] == 'O')) //fila 1
                || (tablero[1][0] == tablero[1][1] && tablero[1][0] == tablero[1][2] && (tablero[1][0] == 'X' || tablero[1][0] == 'O')) //fila 2
                || (tablero[2][0] == tablero[2][1] && tablero[2][0] == tablero[2][2] && (tablero[2][0] == 'X' || tablero[2][0] == 'O')) //fila 3
        ){
            return true;
        }
        else{
            return false;
        }
    }

    public static void imprimirTablero(){
        for (int y = 0; y < tablero.length; y++) {
            for (int x = 0; x < tablero[y].length; x++) {
                System.out.print(tablero[y][x]);
            }
            System.out.println();
        }
    }
    
    public static void solicitarMovimiento(){
        int x = 0;
        int y = 0;
        int cantidadMovimientos = 0;
        boolean esTriqui = false;
        
        Scanner lector = new Scanner(System.in);
        do{
            if(esTurnoDelJugador1 == true)
                System.out.println("Ingresa el movimiento del jugador 1");
            else
                System.out.println("Ingresa el movimiento del jugador 2");

            
            System.out.print("y:");
            y = lector.nextInt();
            System.out.print("x:");
            x = lector.nextInt();

            if(esTurnoDelJugador1 == true)
                tablero[y][x] = 'X';
            else
                tablero[y][x] = 'O';
            cantidadMovimientos += 1;
            imprimirTablero();
            esTriqui = esTriquiPorDiagonalPrincipal();
            if(esTriqui == false)
                esTriqui = esTriquiPorDiagonalInvertida();
            if(esTriqui == false)
                esTriqui = esTriquiPorUnaColumna();
            esTurnoDelJugador1 = !esTurnoDelJugador1;
        }while(cantidadMovimientos < 9 && esTriqui == false);
        
        if(esTriqui == true){
            if(esTurnoDelJugador1 == true)
                System.out.println("Ganó el jugador 2");
            else
                System.out.println("Ganó el jugador 1");
        }
        else
            System.out.println("Empate");
        
        
    }
    
    public static void main(String[] args) {
        solicitarMovimiento();
    }
}

package Ejercicios;

import java.util.Scanner;

public class Ejer01 extends Thread{
    Scanner tec = new Scanner(System.in);
    int factorial = 0;
    int numero;
    public Ejer01(){
        System.out.println("Números Ascendentes: ");
    }
    @Override
    public void run(){
        //int asc;
        for (int i = 1; i <= 10 ; i++) {
            System.out.println(i);
        }
    }
    
    public static void main(String[] args) {
        Thread descendentes = new Ejer01();
        Thread acendentes = new descen();
        descendentes.start();
        acendentes.start();
    }
}

class descen extends Thread{
    public descen(){
        System.out.println("Números Descendentes: ");
    }
    @Override
    public void run(){
        for (int i = 10; i >= 0; i--) {
            System.out.println(i);
        }
    }
}

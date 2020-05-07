package Ejercicios;

import java.util.Scanner;

public class Ejer03 extends Thread{
    Scanner tec = new Scanner(System.in);
    int factorial = 1;
    int numero;
    public Ejer03(){
        System.out.print("ingrese numero: ");
        numero= Integer.parseInt(tec.nextLine());
    }
    @Override
    public void run() {
        for (int i = 1; i <= numero; i++) {
            this.factorial=this.factorial*i;
        }
        System.out.println("Factorial es: "+this.factorial);
        Thread factorial = new Ejer03();
        factorial.start();
    }

    public static void main(String[] args) {
        Thread factorial = new Ejer03();
        factorial.start();
    }
}
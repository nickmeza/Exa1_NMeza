package Ejercicios;

import java.util.Scanner;

public class Ejer01 extends Thread{
    Scanner tec = new Scanner(System.in);
    int factorial = 0;
    int numero;
    public Ejer01(){
        System.out.println("Sumas");
    }
    @Override
    public void run() {
        try {Thread.sleep(1000);} catch (Exception e) {}
        for (int i = 0; i < numero; i++) {
            
        }
        System.out.print(this.numero+"");
    }

    public static void main(String[] args) {
        Thread factorial = new Ejer01();
        factorial.start();
    }
}
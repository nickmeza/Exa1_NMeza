package Cliente_Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
    private Socket s;
    private DataInputStream ois=null;
    private DataOutputStream oos=null; 
    private Scanner teclado=new Scanner(System.in);
    
    public void ejecutarConexion(){  
     Thread t=new Thread(new Runnable(){
      @Override
      public void run() {
     
       try {
        levantarConexion();//Levantamos la conexion
        flujos();//Abrimos los flujos
              recibirDatos();//Reciibimos datos
       }finally{
        cerrarConexion();//Cerramos conexiones
       }
      }   
     });t.start();  
    }
    public void levantarConexion() {
     try{
      s= new Socket("162.15.15.20",5050);//Conectamos el socket al Servidor
      mostrarTexto("Conectado a: "+s.getInetAddress().getHostName()+"\n");
     }catch(java.net.ConnectException ce){
      mostrarTexto("No hay ningún servicio disponible....\n");
      System.exit(0);
     } catch (UnknownHostException e) {
      
      mostrarTexto("Host desconocido....\n");
      System.exit(0);
     } catch (IOException e) {
      
      mostrarTexto("Error al conectar el socket....\n");
      System.exit(0);
     }
    }
    public void flujos() {
     try {
      ois=new DataInputStream(s.getInputStream());//Abro flujo de entrada
      oos=new DataOutputStream(s.getOutputStream());//Abro flujo de salida
      oos.flush();//Limpio información residual
     } catch (IOException e) {
      mostrarTexto("Error al abrir los flujos...\n");
     }
    }
    public void enviar(String s){
     try {
      oos.writeUTF("CLIENTE: "+s);//Mando datos al Servidor
      oos.flush();//Limpio información residual
     } catch (IOException e) {
      
      mostrarTexto("Ocurrio un problema al enviar el texto...\n");
     }
    }
    public void mostrarTexto(String s){
     System.out.print(s);//Escribo por pantalla
    }
    public void cerrarConexion(){
     try {
      ois.close();//Cierro flujo de entrada
      oos.close();//Cierro flujo de salida
      s.close();//Cierro socket
      mostrarTexto("Conversación finalizada....\n");
      System.exit(0);
     } catch (IOException e) {
     
      mostrarTexto("Se proujo un error al intentar cerrar las conexión...\n");
      System.exit(0);
     }
    }
    public void recibirDatos() {
     String st="";  
      
       try {
        do{
         st=(String)ois.readUTF();//Leo y almaceno los datos enviados por el servidor
         if(!st.equals("SERVER: fin"))mostrarTexto(st+"\n");//Muestro los datos por pantalla
        }while(!st.equals("SERVER: fin"));
       } catch (IOException e) {
        
        cerrarConexion();   
       }   
    }
    public void escribirDatos(){
     while(true){
      enviar(teclado.nextLine());//Leo por teclado y envio la información
     }
    }
    public static void main(String[] args) throws Exception {
        Cliente c=new Cliente();
        c.ejecutarConexion();
        c.escribirDatos();
    }
}
package Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloClienteParlante extends Thread {
    protected Socket socket;
    protected DataOutputStream dos;
    protected DataInputStream dis;
    private int id;
    public static String HOST = "localhost";

    public HiloClienteParlante(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la dirección IP del servidor: ");
        HOST = scanner.nextLine();
        try {
            socket = new Socket(HOST, 8080);
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
            System.out.println("Rafael envía un saludo");
            dos.writeUTF("hola");
            String respuesta = "";
            respuesta = dis.readUTF();
            System.out.println("Rafael el servidor te devuelve el saludo: " + respuesta);
            dis.close();
            dos.close();
            socket.close();
        } catch (IOException e) {
            Logger.getLogger(HiloClienteParlante.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}


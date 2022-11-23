package Cliente;

import java.util.ArrayList;

public class Cliente {

    public Cliente()  {
        ArrayList<Thread> cliente = new ArrayList<>();
        for(int i = 0; i < 1; i++) {
            cliente.add(new HiloClienteParlante(i));
        }
        for (Thread thread : cliente) {
            thread.start();
        }
    }
}

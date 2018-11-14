package barbeirodorminhoco;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Barbearia extends Thread{
    private int qtdeCadeiras = 5;
    private boolean dormindo = true;
    private LinkedBlockingQueue<Cliente> clientesNaFila = new LinkedBlockingQueue<>();
    private int qtdeClienteAtendidos = 0;
    private List<Cliente> clientesJaAtendidos = new ArrayList<Cliente>();
    boolean cortando = false;
    
            
    public synchronized void cortarCabelo() {
            try {   
                    if (clientesNaFila.size() == 0) {
                            System.out.println("Barbeiro está dormindo");
                            wait();
                            System.out.println("Barbeiro Acordou para cortar o cabelo");
                            qtdeClienteAtendidos++;
                    }

                    if (clientesNaFila.size() > 0) {
                                    cortando = true;
                                    System.out.println("O " + clientesNaFila.peek().nome + " está sendo atendido.");
                                    clientesNaFila.poll();
                                    Thread.sleep(1200);
                                    qtdeClienteAtendidos++;
                                    System.out.println("Foram atendidos " + qtdeClienteAtendidos + " clientes");
                    }
                    notifyAll();
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
    }

    public synchronized void aguardaVez(Cliente cliente) {
            try {
                    if (dormindo == false) {
                            if (clientesNaFila.size() < qtdeCadeiras) {
                                    clientesNaFila.offer(cliente);
                                    clientesJaAtendidos.add(cliente);
                                    System.out.println("Quantidade de clientes na barbearia = "+ clientesNaFila.size());
                            } else {
                                    System.out.println("Um Cliente chegou mas não existem cadeiras vazias, ele foi embora.");
                                    this.interrupted();
                            }
                    }

                    
                    if (dormindo) {
                        System.out.println("Acordando o barbeiro...");
                        dormindo = false;
                        notify();
                        wait();

                    }
                    notifyAll();

            } catch (Exception e) {
                    e.printStackTrace();
            }
    }

    public LinkedBlockingQueue<Cliente> getFilaClientes() {
            return clientesNaFila;
    }

    public boolean isCortando() {
            return cortando;
    }

    public boolean isDormindo() {
            return dormindo;
    }
    public int getAtendidos(){
            return qtdeClienteAtendidos;
    }

    
 
}

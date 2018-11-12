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
                            System.out.println("Barbeiro Dorme");
                            wait();
                            System.out.println("Barbeiro Acorda e comeca a cortar");
                    }

                    if (clientesNaFila.size() > 0) {
                                    cortando = true;
                                    System.out.println("Aguarde enquando o " + clientesNaFila.peek().nome + " é atendido......");
                                    clientesNaFila.poll();
                                    Thread.sleep(800);
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
                    if (!clientesJaAtendidos.contains(cliente)) {
                            if (clientesNaFila.size() < qtdeCadeiras) {
                                    clientesNaFila.offer(cliente);
                                    clientesJaAtendidos.add(cliente);
                                    System.out.println("Quantidade clientes esperando para cortar = "+ clientesNaFila.size());
                            } else {
                                    System.out.println("Um Cliente chegou mas não existem cadeiras vazias, ele voltará em breve.");
                                    Thread.sleep((int) (Math.random() * 3000));
                            }
                    }

                    while (clientesNaFila.size() < qtdeCadeiras) {
                            if (dormindo) {
                                    System.out.println("Acordando o barbeiro...");
                                    notify();
                                    dormindo = false;
                            }
                            wait();
                    }
                    notifyAll();

            } catch (InterruptedException e) {
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

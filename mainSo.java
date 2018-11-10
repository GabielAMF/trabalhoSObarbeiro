package barbeirodorminhoco;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;




public class mainSo {

    
        private static final Lock barbeiroCortando = new ReentrantLock();
        private static final Lock cliente = new ReentrantLock();
        private static final Lock mutua = new ReentrantLock();
        private static final int numMax = 10;
        private static int clientWait = 0;
        private static final Condition Cheio = barbeiroCortando.newCondition();
        private static final Condition Vazio = barbeiroCortando.newCondition();


        public static class Barbearia {

            private final int NCadeiras;
            private int Ncadeirasocupadas;


            public Barbearia(int n){
                this.NCadeiras = n;
                this.Ncadeirasocupadas = 0;
            }
        }

        public static class Barbeiro {


            private boolean cortando;
            private boolean dormindo;

            public Barbeiro(){
                this.cortando = false;
                this.dormindo = true;
            }

            public void cortar(){
                while(true){
                    cliente.lock();
                    mutua.lock();
                    System.out.println("Barbeiro Cortando");
                    System.out.println("Cliente Cortando");
                    clientWait--;
                    barbeiroCortando.unlock();
                    System.out.println("Cliente cortou o cabelo");
                    mutua.unlock();
                    System.out.println("Barbeiro Dorme");
                    //mensagem de execução

                }

                //thread.stopExecuting()

                //Se não existir cliente na fila, barbeiro dorme;
                //Garantir exclusão mutua (evitar que o barbeiro corte mais de 1 cabelo ao mesmo tempo
            }
        }

        public static class Cliente {
            
            public String nome;
            public Cliente(String nome){
                this.nome = nome;
            }

            public void sentar(){
                mutua.lock();
                //interface de cliente
                if(clientWait<numMax){
                    //aviso de chegada do cliente *interface
                    clientWait++;
                    System.out.println("Cliente sentou");
                    cliente.unlock();
                    mutua.unlock();
                    barbeiroCortando.lock();
                    // mensagem de cabelo(nome do cliente) sendo atendido
                }
                else{
                    mutua.lock();
                    System.out.println("Cliente foi embora");
                    //cliente é uma vadia impaciente
                    //cliente foi embora
                    // olhar metodo de interromper esse cliente por precaução
                }


                //Se não tiver ninguem cortando corta()
                //Se não estiver cheia mas alguem está cortando senta()
                //Soma numero de cadeiras ocupadas
                //Caso estiver cheia, cliente vai embora
            }
        }
    
    public static void main(String[] args) { 
        Barbearia b2 = new Barbearia(8);
        Barbeiro barbeiro = new Barbeiro();
        Cliente c1 = new Cliente("Gabriel");
        Cliente c2 = new Cliente("Gabriel1");
        Cliente c3 = new Cliente("Gabriel2");
        Cliente c4 = new Cliente("Gabriel3");
        Cliente c5 = new Cliente("Gabriel4");
        Cliente c6 = new Cliente("Gabriel5");
        Cliente c7 = new Cliente("Gabriel6");
        Cliente c8 = new Cliente("Gabriel7");
        Cliente c9 = new Cliente("Gabriel8");
        Cliente c10 = new Cliente("Gabrie8l");
        Cliente c11 = new Cliente("Gabriel9");
        Cliente c12 = new Cliente("Gabriel00");
        Cliente c13 = new Cliente("Gabriel08");
        
        
        
        c1.sentar();
        c2.sentar();
        c3.sentar();
        c4.sentar();
        c5.sentar();
        c6.sentar();
        c7.sentar();
        c8.sentar();
        c9.sentar();
        barbeiro.cortar();
        barbeiro.cortar();
        
    }   
}

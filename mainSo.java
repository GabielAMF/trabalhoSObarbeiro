package barbeirodorminhoco;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;




public class mainSo {
    public class BarbeiroDorminhoco {

        private final Lock barbeiroCortando = new ReentrantLock();
        private final Lock cliente = new ReentrantLock();
        private final Lock mutua = new ReentrantLock();
        private final int numMax = 10;
        private int clientWait = 0;
        private final Condition Cheio = barbeiroCortando.newCondition();
        private final Condition Vazio = barbeiroCortando.newCondition();


        public class Barbearia {

            private final int NCadeiras;
            private int Ncadeirasocupadas;


            public Barbearia(int n){
                this.NCadeiras = n;
                this.Ncadeirasocupadas = 0;
            }
        }

        public class Barbeiro {


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

        public class Cliente {

            public void cortar(){
                //
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
    }
    public static void main(String[] args) {
        BarbeiroDorminhoco.Barbeiro b = new BarbeiroDorminhoco.Barbeiro();
        
    }
}
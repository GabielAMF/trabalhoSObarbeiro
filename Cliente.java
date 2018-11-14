package barbeirodorminhoco;

public class Cliente extends Thread{
    private Barbearia barbearia;
    public boolean querCortar = true;
    public String nome;
    
    public Cliente(Barbearia b, String nome){
        this.barbearia = b;
        this.nome = nome;
    }
    
    public void run(){
        
            try{
                int sleepTime = ((int) (Math.random() * 6000));
                Thread.sleep(sleepTime);
                barbearia.aguardaVez(this);
            }catch(InterruptedException e){
                System.err.println(e);
            }
        
    }
    
}

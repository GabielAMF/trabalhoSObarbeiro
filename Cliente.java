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
        while(querCortar){
            try{
                int sleepTime = 200;
                Thread.sleep(sleepTime);
                
                barbearia.aguardaVez(this);
                
            }catch(Exception e){
                System.err.println(e);
            }
        }
    }
    
}

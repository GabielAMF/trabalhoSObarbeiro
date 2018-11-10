/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbeirodorminhoco;

/**
 *
 * @author Philippe
 */
public class Barbeiro  extends Thread{
        private Barbearia barbearia;
        public boolean cortar = true;
        
        public Barbeiro(Barbearia barbearia){
            this.barbearia = barbearia;
        }
        
       	public void run() {
		while (cortar) {
			try {
                            int sleepTime = 200;
                            Thread.sleep(sleepTime);
                            barbearia.cortarCabelo();
			} catch (Exception e) {
                            System.err.println(e);
			}
		}
	}
}

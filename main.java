package barbeirodorminhoco;

public class main {
    public static void main(String[] args) {
        Barbearia barbearia = new Barbearia();

        Barbeiro barb = new Barbeiro(barbearia);

        Cliente cli1 = new Cliente(barbearia, "João");
        Cliente cli2 = new Cliente(barbearia, "Maria");
        Cliente cli3 = new Cliente(barbearia, "Aline");
        Cliente cli4 = new Cliente(barbearia, "Allan");
        Cliente cli5 = new Cliente(barbearia, "Patrick");
        Cliente cli6 = new Cliente(barbearia, "Gabriel");
        Cliente cli7 = new Cliente(barbearia, "Ferreira");
        Cliente cli8 = new Cliente(barbearia, "Smith");
        Cliente cli9 = new Cliente(barbearia, "Philippe");
        Cliente cli10 = new Cliente(barbearia, "Andre");
        Cliente cli11 = new Cliente(barbearia, "Jessica");
        Cliente cli12 = new Cliente(barbearia, "Fernanda");

        barb.start();
        cli1.start();
        cli2.start();
        cli3.start();
        cli4.start();
        cli5.start();
        cli6.start();
        cli7.start();
        cli8.start();
        cli9.start();
        cli10.start();
        cli11.start();
        cli12.start();
        }
}

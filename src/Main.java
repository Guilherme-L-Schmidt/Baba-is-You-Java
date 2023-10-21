import Controler.ControleDeJogo;

public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ControleDeJogo controle = new ControleDeJogo();
            }
        }); 
    }
}


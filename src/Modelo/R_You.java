package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class R_You extends Rules implements Serializable{
    
    public R_You() {
        super("You.png");
        this.code = 41;
    }
}

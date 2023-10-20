package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class R_Rock extends Rules implements Serializable{
    
    public R_Rock() {
        super("T_Rock.png");
        this.code = 23;
    }
}

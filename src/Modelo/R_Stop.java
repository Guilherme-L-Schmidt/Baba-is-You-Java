package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class R_Stop extends Rules implements Serializable{
    
    public R_Stop() {
        super("Stop.png");
        this.code = 42;
    }
}

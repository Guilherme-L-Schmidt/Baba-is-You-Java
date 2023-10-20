package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class R_Push extends Rules implements Serializable {
    
    public R_Push() {
        super("Push.png");
        this.code = 43;
    }
}

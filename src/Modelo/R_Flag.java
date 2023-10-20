package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class R_Flag extends Rules implements Serializable{
    
    public R_Flag() {
        super("T_Flag.png");
        this.code = 25;
    }
}

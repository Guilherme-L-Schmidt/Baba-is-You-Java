package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class R_Baba extends Rules implements Serializable{
    
    public R_Baba() {
        super("T_Baba.png");
        this.code = 21;
    }
}

package Modelo;

import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class Fogo extends Personagem implements Serializable{
            
    public Fogo(String sNomeImagePNG) {
        super(sNomeImagePNG, 0);
        this.bMortal = true;
    }

    @Override
    public void autoDesenho() {
        super.autoDesenho();
        if(!this.moveRight())
            Desenho.acessoControleJogo().removeObject(this);
    }
    
}

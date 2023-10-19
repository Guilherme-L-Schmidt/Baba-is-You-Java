package Controler;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Modelo.Personagem;
import Modelo.Hero;
import Auxiliar.Posicao;
import Mapas.Mapa;
import Mapas.MapasNiveis;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.Component;

public class ControleDeJogo implements MouseListener, KeyListener {
    private Hero hero;
    private Tela tela;
    private Mapa mapa;
    
    public ControleDeJogo() {
        Desenho.setControle(this);
        this.mapa = new Mapa(MapasNiveis.mapa1);
        
        tela = new Tela(this);
        tela.setVisible(true);
        tela.createBufferStrategy(2);
        tela.go();
    }

    public ArrayList<Personagem> getFaseAtual() {
        return this.mapa.getFaseAtual();
    }
    // Remover e transferir para Mapa
    public void addPersonagem(Personagem umPersonagem) {
        mapa.getFaseAtual().add(umPersonagem);
    }

    public void removePersonagem(Personagem umPersonagem) {
        mapa.getFaseAtual().remove(umPersonagem);
    }
    
    public void desenhaTudo(ArrayList<Personagem> e){
        for(int i = 0; i < e.size(); i++){
            e.get(i).autoDesenho();
        }
    }
    public void processaTudo(ArrayList<Personagem> umaFase){

    }
    
    /*Retorna true se a posicao p é válida para Hero com relacao a todos os personagens no array*/
    public boolean ehPosicaoValida(Personagem p) {
        Personagem pIesimoPersonagem;
        for(int i = 0; i < this.mapa.getFaseAtual().size(); i++){
            pIesimoPersonagem = this.mapa.getFaseAtual().get(i);
            if(pIesimoPersonagem != p){
                if(pIesimoPersonagem.getPosicao().igual(p.getPosicao())) {
                    if(!pIesimoPersonagem.isbTransponivel()) {
                        if(pIesimoPersonagem.isbMovivel()) {
                            switch(p.getPosicao().getDirecao()){
                                case 1:
                                    return pIesimoPersonagem.moveUp();
                                case 2:
                                    return pIesimoPersonagem.moveRight();
                                case 3:
                                    return pIesimoPersonagem.moveDown();
                                case 4:
                                    return pIesimoPersonagem.moveLeft();
                                default:
                                    return true;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public void keyPressed(KeyEvent e) {
        for(int i = 0; i < mapa.getFaseAtual().size(); i++) {
            if(mapa.getFaseAtual().get(i).getSeMove()){
                this.hero = (Hero)mapa.getFaseAtual().get(i);
                if (e.getKeyCode() == KeyEvent.VK_C) {
                    this.tela.clearTela();
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    hero.moveUp();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    hero.moveDown();
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    hero.moveLeft();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    hero.moveRight();
                }
                this.mapa.updatePosMapa(hero);
                this.tela.setTitle("-> Cell: " + (hero.getPosicao().getColuna()) + ", " + (hero.getPosicao().getLinha()));   
            }
        }

        //repaint(); /*invoca o paint imediatamente, sem aguardar o refresh*/
    }

    public void mousePressed(MouseEvent e) {
        /* Clique do mouse desligado*/
         int x = e.getX();
         int y = e.getY();
     
         this.tela.setTitle("X: "+ x + ", Y: " + y +
         " -> Cell: " + (y/Consts.CELL_SIDE) + ", " + (x/Consts.CELL_SIDE));
        
         this.hero.getPosicao().setPosicao(y/Consts.CELL_SIDE, x/Consts.CELL_SIDE);
         
        tela.repaint();
    }

    
    public void mouseMoved(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}

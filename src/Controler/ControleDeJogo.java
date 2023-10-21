package Controler;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Modelo.Object;
import Modelo.Baba;
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
    private Baba hero;
    private Tela tela;
    private Mapa mapa;
    private Ruler ruler;
    private int numNivelAtual;
    
    public ControleDeJogo() {
        Desenho.setControle(this);
        this.numNivelAtual = 0;
        this.mapa = new Mapa(MapasNiveis.listaMapas[this.numNivelAtual]);
        this.ruler = new Ruler(this.mapa);
        
        this.UpdateWalls();
        
        tela = new Tela(this);
        tela.setVisible(true);
        tela.createBufferStrategy(2);
        tela.go();
    }
    
    public void UpdateWalls() {
        int[][] matrizWalls = new int[Consts.RES_VER][Consts.RES_HOR];
        ArrayList<Object> walls = new ArrayList<>();
        
        ArrayList<Object> fase = mapa.getFaseAtual();
        for(int i = 0; i < fase.size(); i++) {
            Object p = fase.get(i);
            if(p.getCode() == 10) {
                walls.add(p);
                int x = p.getPosicao().getColuna();
                int y = p.getPosicao().getLinha();
                
                if(x > 0)
                    matrizWalls[y][x-1] += 1;
                if(y+1 < Consts.RES_VER)
                    matrizWalls[y+1][x] += 2;
                if(x+1 < Consts.RES_HOR)
                    matrizWalls[y][x+1] += 4;
                if(y > 0)
                    matrizWalls[y-1][x] += 8;                
            }
        }
        
        for(int i = 0; i < walls.size(); i++) {
            Object wall = walls.get(i);
            int x = wall.getPosicao().getColuna();
            int y = wall.getPosicao().getLinha();
            
            wall.setImage(("Walls/wall_" + matrizWalls[y][x] + "_1.png"));
        }
    }

    public void UpdateRules() {
        this.ruler.AnalyseRules(this.mapa);
    }
    
    public ArrayList<Object> getFaseAtual() {
        return this.mapa.getFaseAtual();
    }
    // Remover e transferir para Mapa
    public void addPersonagem(Object umPersonagem) {
        mapa.getFaseAtual().add(umPersonagem);
    }

    public void removePersonagem(Object umPersonagem) {
        mapa.getFaseAtual().remove(umPersonagem);
    }
    
    public void desenhaTudo(ArrayList<Object> e){
        for(int i = 0; i < e.size(); i++){
            e.get(i).autoDesenho();
        }
    }
    
    /*Retorna true se a posicao p é válida para Baba com relacao a todos os personagens no array*/
    public boolean ehPosicaoValida(Object obj) {
        Object objAnalisado;
        for(int i = 0; i < this.mapa.getFaseAtual().size(); i++){
            objAnalisado = this.mapa.getFaseAtual().get(i);
            if(objAnalisado != obj){
                if(objAnalisado.getPosicao().igual(obj.getPosicao())) {
                    if(!objAnalisado.isbTransponivel()) {
                        if(objAnalisado.isbMovivel()) {
                            switch(obj.getPosicao().getDirecao()){
                                case 1:
                                    return objAnalisado.moveUp();
                                case 2:
                                    return objAnalisado.moveRight();
                                case 3:
                                    return objAnalisado.moveDown();
                                case 4:
                                    return objAnalisado.moveLeft();
                                default:
                                    return true;
                            }
                        }
                        return false;
                    }
                    if(objAnalisado.getbWin()) {
                        Vitoria();
                    }
                }
            }
        }
        return true;
    }
    
    public void Vitoria() {
        System.out.println("Ganhei");
        this.numNivelAtual++;
        this.mapa = new Mapa(MapasNiveis.listaMapas[this.numNivelAtual]);
        this.ruler = new Ruler(this.mapa);
    }
    
    public void updateMapa(Object obj) {
        if(obj.getCode() > 20) {
            this.mapa.updateRuleMap(obj);
        }
    }
    
    public void keyPressed(KeyEvent e) {
        for(int i = 0; i < mapa.getFaseAtual().size(); i++) {
            Object p = mapa.getFaseAtual().get(i);
            if(p.getSeMove()) {                
                if (e.getKeyCode() == KeyEvent.VK_C) {
                    this.tela.clearTela();
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    p.moveUp();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    p.moveDown();
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    p.moveLeft();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    p.moveRight();
                }
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
        
         //this.hero.getPosicao().setPosicao(y/Consts.CELL_SIDE, x/Consts.CELL_SIDE);
         
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

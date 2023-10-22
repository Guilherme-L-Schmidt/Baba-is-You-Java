package Controler;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Modelo.Object;
import Auxiliar.Posicao;
import Mapas.Mapa;
import Mapas.MapasNiveis;
import Modelo.Personagem_1;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.Component;

public class ControleDeJogo implements MouseListener, KeyListener {
    private Tela tela;
    private Mapa mapa;
    private Ruler ruler;
    private boolean EnterPressed;
    private int numNivelAtual;
    
    public ControleDeJogo() {
        Desenho.setControle(this);
        this.numNivelAtual = 0;
        this.mapa = new Mapa(MapasNiveis.listaMapas[this.numNivelAtual]);
        this.ruler = new Ruler(this.mapa);
        this.EnterPressed = false;
        this.UpdateObjetoVariavel("Walls/wall_", 10);
        
        tela = new Tela(this);
        tela.setVisible(true);
        tela.createBufferStrategy(2);
        tela.go();
    }
    
    public void UpdateObjetoVariavel(String name, int code) {
        int[][] matrizObjVars = new int[Consts.RES_VER][Consts.RES_HOR];
        ArrayList<Object> objVars = new ArrayList<>();
        
        ArrayList<Object> fase = mapa.getFaseAtual();
        for(int i = 0; i < fase.size(); i++) {
            Object obj = fase.get(i);
            if(obj.getCode() == code) {
                objVars.add(obj);
                int x = obj.getPosicao().getColuna();
                int y = obj.getPosicao().getLinha();
                
                if(x > 0)
                    matrizObjVars[y][x-1] += 1;
                if(y+1 < Consts.RES_VER)
                    matrizObjVars[y+1][x] += 2;
                if(x+1 < Consts.RES_HOR)
                    matrizObjVars[y][x+1] += 4;
                if(y > 0)
                    matrizObjVars[y-1][x] += 8;                
            }
        }
        
        for(int i = 0; i < objVars.size(); i++) {
            Object objVar = objVars.get(i);
            int x = objVar.getPosicao().getColuna();
            int y = objVar.getPosicao().getLinha();
            
            objVar.setName(name + matrizObjVars[y][x]);
            System.out.println(name + matrizObjVars[y][x]);
        }
    }

    public void UpdateRules() {
        this.ruler.AnalyseRules(this.mapa);
    }
    
    public ArrayList<Object> getFaseAtual() {
        return this.mapa.getFaseAtual();
    }
    // Remover e transferir para Mapa
    public void addObject(Object umObj) {
        mapa.getFaseAtual().add(umObj);
    }

    public void removeObject(Object umObj) {
        mapa.getFaseAtual().remove(umObj);
    }
    
    public void desenhaTudo(ArrayList<Object> e){
        for(int i = 0; i < e.size(); i++){
            e.get(i).autoDesenho();
        }
    }
    
    /*Retorna true se a posicao p é válida para Baba com relacao a todos os personagens no array*/
    public boolean ehPosicaoValida(Object obj) {
        Object objAnalisado;
        for(int i = 0; i < this.mapa.getFaseAtual().size(); i++) {
            objAnalisado = this.mapa.getFaseAtual().get(i);
            if(objAnalisado != obj){
                if(objAnalisado.getPosicao().igual(obj.getPosicao())) {
                    return analisaColisao(obj, objAnalisado, i);
                }
            }
        }
        return true;
    }
    
    public boolean analisaColisao(Object obj1, Object obj2, int i) {
        if((obj2.getShut() && obj1.getOpen()) || (obj2.getShut() && obj1.getOpen())) {
            this.mapa.getFaseAtual().remove(i);
            this.mapa.getFaseAtual().remove(obj1);
        }
        if(!obj2.isbTransponivel()) {         
            if(obj2.isbMovivel()) {
                switch(obj1.getPosicao().getDirecao()){
                    case 1:
                        return obj2.moveUp();
                    case 2:
                        return obj2.moveRight();
                    case 3:
                        return obj2.moveDown();
                    case 4:
                        return obj2.moveLeft();
                    default:
                        return true;
                }
            }
            return false;
        }
        if(obj1.getSeMove() && obj2.getbWin()) {
            Vitoria();
        }
        return true;
    }
    
    public void Vitoria() {
        System.out.println("Ganhei");
        this.mapa.getFaseAtual().clear();
        this.addObject(new Personagem_1("congratulationsScreenBabaIsYou.png"));
        this.EnterPressed = true;
    }
    
    public void loadFase() {
        this.mapa.getFaseAtual().clear();
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
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        } 
        if(e.getKeyCode() == KeyEvent.VK_ENTER && this.EnterPressed){
            this.EnterPressed = false;
            this.loadFase();
        }
        for(int i = 0; i < mapa.getFaseAtual().size(); i++) {
            Object p = mapa.getFaseAtual().get(i);
            if(p.getSeMove()) {                
                if (e.getKeyCode() == KeyEvent.VK_UP) {
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

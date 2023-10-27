package Controler;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Modelo.Object;
import Auxiliar.Posicao;
import Mapas.Mapa;
import Mapas.MapasNiveis;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ControleDeJogo implements MouseListener, KeyListener {
    private Tela tela;
    private Mapa mapa;
    private Ruler ruler;
    private boolean EnterPress;
    private int numNivelAtual;
    
    public ControleDeJogo() {
        Desenho.setControle(this);
        this.numNivelAtual = 0;
        this.mapa = new Mapa(MapasNiveis.listaMapas[this.numNivelAtual]);
        this.ruler = new Ruler(this.mapa);
        this.EnterPress = false;
        
        this.updateAllObjVar();
        
        tela = new Tela(this);
        tela.setVisible(true);
        tela.createBufferStrategy(2);
        tela.go();
    }
    
    public int[] getOffset() {
        return MapasNiveis.offset_bordas[numNivelAtual];
    }
    
    public void updateAllObjVar() {
        this.UpdateObjetoVariavel("Walls/wall_", 10);
        this.UpdateObjetoVariavel("Lava/lava_", 11);
        this.UpdateObjetoVariavel("Grass/grass_", 12);
        this.UpdateObjetoVariavel("Water/water_", 13);
        this.UpdateObjetoVariavel("Brick/brick_", 82);
    }
    
    public void UpdateObjetoVariavel(String name, int code) {
        int[][] matrizObjVars = new int[Consts.RES_VER][Consts.RES_HOR];
        ArrayList<Object> objVars = new ArrayList<>();
        ArrayList<Object> fase;
        
        if(code < 80)
            fase = mapa.getFaseAtual();
        else
            fase = mapa.getBackgroundAtual();
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
    
    public void desenhaTudo(ArrayList<Object> e) {
        ArrayList<Object> background = this.mapa.getBackgroundAtual();
        ArrayList<Object> transponiveis = new ArrayList<Object>();
        ArrayList<Object> outros = new ArrayList<Object>();
        ArrayList<Object> yous = new ArrayList<Object>();
        // loop de separacao
        for(int i = 0; i < e.size(); i++) {
            Object obj = e.get(i);
            if(!obj.getStop())
                transponiveis.add(obj);
            else if(obj.getYou())
                yous.add(obj);
            else
                outros.add(obj);
        }
        
        // loops para desenho
        for(int i = 0; i < background.size(); i++)
            background.get(i).autoDesenho();
        for(int i = 0; i < transponiveis.size(); i++)
            transponiveis.get(i).autoDesenho();
        for(int i = 0; i < outros.size(); i++)
            outros.get(i).autoDesenho();
        for(int i = 0; i < yous.size(); i++)
            yous.get(i).autoDesenho();
    }
    
    /*Retorna true se a posicao do objeto eh valida em relacao aos demais no array*/
    public boolean ehPosicaoValida(Object obj) {
        Object objAnalisado;
        for(int i = 0; i < this.mapa.getFaseAtual().size(); i++) {
            objAnalisado = this.mapa.getFaseAtual().get(i);
            if(objAnalisado != obj){
                if(objAnalisado.getPosicao().igual(obj.getPosicao())) {
                    if(!analisaColisao(obj, objAnalisado, i))
                        return false;
                }
            }
        }
        return true;
    }
    
    public boolean analisaColisao(Object obj1, Object obj2, int i) {
        // Check shut and open
        if((obj2.getShut() && obj1.getOpen()) || (obj2.getShut() && obj1.getOpen())) {
            this.mapa.getFaseAtual().remove(i);
            this.mapa.getFaseAtual().remove(obj1);
            this.updateAllObjVar();
        }
        // Check stop
        else if(obj2.getStop()) {
                // Then check push
                if(obj2.getPush()) {
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
        // Checks hot and melt
        else if((obj2.getMelt() && obj1.getHot())) {
            this.mapa.getFaseAtual().remove(i);
            this.updateAllObjVar();
        }// Checks hot and melt
        else if((obj1.getMelt() && obj2.getHot())) {
            this.mapa.getFaseAtual().remove(obj1);
            this.updateAllObjVar();
        }
        // Check sink
        else if(obj2.getSink() || obj1.getSink()) {
            this.mapa.getFaseAtual().remove(i);
            this.mapa.getFaseAtual().remove(obj1);
            this.updateAllObjVar();
        }
        // Check defeat
        else if(obj2.getYou() && obj1.getDefeat()) {
            this.mapa.getFaseAtual().remove(i);
            this.updateAllObjVar();
        }
        else if (obj2.getDefeat() && obj1.getYou()) {
            this.mapa.getFaseAtual().remove(obj1);
            this.updateAllObjVar();
        }
        // Check win
        else if(obj1.getYou() && obj2.getWin()) {
            Vitoria();
            return false;
        }
        return true;
    }
    
    public void Vitoria() {
        System.out.println("Ganhei");
        this.mapa.getFaseAtual().clear();
        this.EnterPress = true;
        this.numNivelAtual++;
    }
    
    public void loadFase() {
        this.mapa = new Mapa(MapasNiveis.listaMapas[this.numNivelAtual]);
        this.ruler = new Ruler(this.mapa);
        this.updateAllObjVar();        
    }
    
    public void updateMapa(Object obj) {
        if(obj.getCode() > 20) {
            this.mapa.updateRuleMap(obj);
        }
    }
    
    public void keyPressed(KeyEvent e) {
        // Reload command
        if (e.getKeyCode() == KeyEvent.VK_R) {
            this.loadFase();
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        } 
        if(e.getKeyCode() == KeyEvent.VK_ENTER && this.EnterPress){
            this.EnterPress = false;
            this.loadFase();
        }
        // Deals with movement
        if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            ArrayList<Object> ordem = new ArrayList<Object>();
            for(int i = 0; i < mapa.getFaseAtual().size(); i++) {
                Object p = mapa.getFaseAtual().get(i);
                int posl = p.getPosicao().getLinha();
                int posc = p.getPosicao().getColuna();
                int j;

                // System to move in order and prevent colisions
                if(p.getYou()) {
                    if (e.getKeyCode() == KeyEvent.VK_UP) {
                        for(j = 0; j < ordem.size(); j++) {
                            if(posl < ordem.get(j).getPosicao().getLinha())
                                break;
                        }
                        ordem.add(j, p);
                    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                        for(j = 0; j < ordem.size(); j++) {
                            if(posl > ordem.get(j).getPosicao().getLinha())
                                break;
                        }
                        ordem.add(j, p);
                    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        for(j = 0; j < ordem.size(); j++) {
                            if(posc < ordem.get(j).getPosicao().getColuna())
                                break;
                        }
                        ordem.add(j, p);
                    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        for(j = 0; j < ordem.size(); j++) {
                            if(posc > ordem.get(j).getPosicao().getColuna())
                                break;
                        }
                        ordem.add(j, p);
                    }
                }
            }

            // moves in the determined order
            for(int i = 0; i < ordem.size(); i++) {
                Object p = ordem.get(i);
                if (e.getKeyCode() == KeyEvent.VK_UP)
                    p.moveUp();
                else if (e.getKeyCode() == KeyEvent.VK_DOWN)
                    p.moveDown();
                else if (e.getKeyCode() == KeyEvent.VK_LEFT)
                    p.moveLeft();
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT) 
                    p.moveRight();
            }
        }

        //repaint(); /*invoca o paint imediatamente, sem aguardar o refresh*/
    }

    public void mousePressed(MouseEvent e) {}
    
    public void mouseMoved(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseDragged(MouseEvent e) {}

    public void keyTyped(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {}
}

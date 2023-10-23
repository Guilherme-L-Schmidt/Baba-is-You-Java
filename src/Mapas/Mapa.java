package Mapas;

import Auxiliar.Consts;
import Auxiliar.Posicao;
import Modelo.Object;
import Modelo.Personagem;
import Modelo.ObjetoVariavel;
import Modelo.PersonagemAnimado;
import Modelo.Rules;
import java.util.ArrayList;

public class Mapa {
    
    private int[][] matrizMapa;
    private int[][] ruleMap;
    private ArrayList<Object> faseAtual;   
    
    public Mapa(int[][] matrizM) {
        matrizMapa = matrizM;
        ruleMap = new int[Consts.RES_VER][Consts.RES_HOR];
        faseAtual = new ArrayList<Object>();
        for(int x = 0; x < Consts.RES_HOR; x++) {
            for(int y = 0; y < Consts.RES_VER; y++) {
                createObject(x, y, matrizMapa[y][x]);
            }
        }
    }
    
    public void createObject(int x, int y, int code) {
        switch(code) {
            case 1:
                PersonagemAnimado baba = new PersonagemAnimado("Baba/baba_", 1);
                baba.setPosicao(y,x);
                faseAtual.add(baba);
                break;
            case 2:
                Personagem key = new Personagem("key_0", 2);
                key.setPosicao(y,x);
                faseAtual.add(key);
                break;
            case 3:
                Personagem rock = new Personagem("rock_0", 3);
                rock.setPosicao(y,x);
                faseAtual.add(rock);
                break;
            case 4:
                Personagem door = new Personagem("door_0", 4);
                door.setPosicao(y,x);
                faseAtual.add(door);
                break;
            case 5:
                Personagem flag = new Personagem("flag_0", 5);
                flag.setPosicao(y, x);
                faseAtual.add(flag);
                break;
            case 6:
                Personagem skull = new Personagem("skull_24", 6);
                skull.setPosicao(y, x);
                faseAtual.add(skull);
                break;
            case 10:
                ObjetoVariavel wall = new ObjetoVariavel("Walls/wall_", 10);
                wall.setPosicao(y, x);
                faseAtual.add(wall);
                break;
            case 11:
                ObjetoVariavel lava = new ObjetoVariavel("Lava/lava_", 11);
                lava.setPosicao(y, x);
                faseAtual.add(lava);
                break;
            case 12:
                ObjetoVariavel grass = new ObjetoVariavel("Grass/grass_", 12);
                grass.setPosicao(y, x);
                faseAtual.add(grass);
                break;
            case 15:
                PersonagemAnimado robot = new PersonagemAnimado("Robot/robot_", 15);
                robot.setPosicao(y,x);
                faseAtual.add(robot);
                break;
            case 21:
                Rules r_baba = new Rules("text_baba_0", 21);
                r_baba.setPosicao(y, x);
                faseAtual.add(r_baba);
                break;
            case 22:
                Rules r_key = new Rules("text_key_0", 22);
                r_key.setPosicao(y, x);
                faseAtual.add(r_key);
                break;
            case 23:
                Rules r_rock = new Rules("text_rock_0", 23);
                r_rock.setPosicao(y, x);
                faseAtual.add(r_rock);
                break;
            case 24:
                Rules r_door = new Rules("text_door_0", 24);
                r_door.setPosicao(y, x);
                faseAtual.add(r_door);
                break;
            case 25:
                Rules r_flag = new Rules("text_flag_0", 25);
                r_flag.setPosicao(y, x);
                faseAtual.add(r_flag);
                break;
            case 26:
                Rules r_skull = new Rules("text_skull_0", 26);
                r_skull.setPosicao(y, x);
                faseAtual.add(r_skull);
                break;
            case 30:
                Rules r_wall = new Rules("text_wall_0", 30);
                r_wall.setPosicao(y, x);
                faseAtual.add(r_wall);
                break;
            case 31:
                Rules r_lava = new Rules("text_lava_0", 31);
                r_lava.setPosicao(y, x);
                faseAtual.add(r_lava);
                break;
            case 32:
                Rules r_grass = new Rules("text_grass_0", 31);
                r_grass.setPosicao(y, x);
                faseAtual.add(r_grass);
                break;
            case 35:
                Rules r_robot = new Rules("text_robot_0", 35);
                r_robot.setPosicao(y, x);
                faseAtual.add(r_robot);
                break;
            case 40:
                Rules r_is = new Rules("text_is_0", 40);
                r_is.setPosicao(y, x);
                faseAtual.add(r_is);
                break;
            case 41:
                Rules r_you = new Rules("text_you_0", 41);
                r_you.setPosicao(y, x);
                faseAtual.add(r_you);
                break;
            case 42:
                Rules r_stop = new Rules("text_stop_0", 42);
                r_stop.setPosicao(y, x);
                faseAtual.add(r_stop);
                break;
            case 43:
                Rules r_push = new Rules("text_push_0", 43);
                r_push.setPosicao(y, x);
                faseAtual.add(r_push);
                break;
            case 44:
                Rules r_shut = new Rules("text_shut_0", 44);
                r_shut.setPosicao(y, x);
                faseAtual.add(r_shut);
                break;
            case 45:
                Rules r_open = new Rules("text_open_0", 45);
                r_open.setPosicao(y, x);
                faseAtual.add(r_open);
                break;
            case 46:
                Rules r_sink = new Rules("text_sink_0", 46);
                r_sink.setPosicao(y, x);
                faseAtual.add(r_sink);
                break;
            case 47:
                Rules r_hot = new Rules("text_hot_0", 47);
                r_hot.setPosicao(y, x);
                faseAtual.add(r_hot);
                break;
            case 48:
                Rules r_melt = new Rules("text_melt_0", 48);
                r_melt.setPosicao(y, x);
                faseAtual.add(r_melt);
                break;
            case 50:
                Rules r_win = new Rules("text_win_0", 50);
                r_win.setPosicao(y, x);
                faseAtual.add(r_win);
                break;
            case 51:
                Rules r_defeat = new Rules("text_defeat_0", 51);
                r_defeat.setPosicao(y, x);
                faseAtual.add(r_defeat);
                break;
            case 60:
                Rules r_and = new Rules("text_and_0", 60);
                r_and.setPosicao(y, x);
                faseAtual.add(r_and);
                break;
            default:
                break;
        }
        if(code >= 20)
            ruleMap[y][x] = matrizMapa[y][x];
        else
            ruleMap[y][x] = 0;
    }
    
    public boolean swapObjects(int codeDel, int codeCrt) {
        boolean changed = false;
        for(int i = 0; i < faseAtual.size(); i++) {
            Object obj = faseAtual.get(i);
            if(obj.getCode() == codeDel) {
                int x = obj.getPosicao().getColuna();
                int y = obj.getPosicao().getLinha();
                faseAtual.remove(i);
                createObject(x, y, codeCrt);
                changed = true;
            }
        }
        return changed;
    }
    
    public int[][] getRuleMap() {
        return this.ruleMap;
    }
    
    public ArrayList<Object> getFaseAtual() {
        return this.faseAtual;
    }
    
    public void updateRuleMap(Object pers) {
        Posicao pos = pers.getPosicao();
        ruleMap[pos.getLinhaAnterior()][pos.getColunaAnterior()] = 0;
        ruleMap[pos.getLinha()][pos.getColuna()] = pers.getCode();        
    }
    
    public void updatePosMapa(Object pers) {
        Posicao pos = pers.getPosicao();
        matrizMapa[pos.getLinhaAnterior()][pos.getColunaAnterior()] = 0;
        matrizMapa[pos.getLinha()][pos.getColuna()] = pers.getCode();
    }
}
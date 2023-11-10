package Mapas;

import Auxiliar.Consts;
import Auxiliar.Posicao;
import Modelo.Objeto;
import Modelo.Personagem;
import Modelo.ObjetoVariavel;
import Modelo.PersonagemAnimado;
import Modelo.Rules;
import java.io.Serializable;
import java.util.ArrayList;

public class Mapa implements Serializable{
    
    private static final long serialVersionUID = 6529685098267757691L;
    public int[][] matrizMapa;
    public int[][] ruleMap;
    public ArrayList<Objeto> faseAtual;
    public ArrayList<Objeto> backgroundAtual;
    public int numNivelAtual;

    public int getNumNivelAtual() {
        return numNivelAtual;
    }

    public void setNumNivelAtual(int numNivelAtual) {
        this.numNivelAtual = numNivelAtual;
    }
    
    public Mapa(int[][] matrizM) {
        matrizMapa = matrizM;
        ruleMap = new int[Consts.RES_VER][Consts.RES_HOR];
        faseAtual = new ArrayList<Objeto>();
        backgroundAtual = new ArrayList<Objeto>();
        this.numNivelAtual = 0;
        for(int x = 0; x < Consts.RES_HOR; x++) {
            for(int y = 0; y < Consts.RES_VER; y++) {
                createObject(x, y, matrizMapa[y][x]);
            }
        }
    }

    public void setFaseAtual(ArrayList<Objeto> faseAtual) {
        this.faseAtual = faseAtual;
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
            case 13:
                ObjetoVariavel water = new ObjetoVariavel("Water/water_", 13);
                water.setPosicao(y, x);
                faseAtual.add(water);
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
                Rules r_grass = new Rules("text_grass_0", 32);
                r_grass.setPosicao(y, x);
                faseAtual.add(r_grass);
                break;
            case 33:
                Rules r_water = new Rules("text_water_0", 33);
                r_water.setPosicao(y, x);
                faseAtual.add(r_water);
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
            case 52:
                Rules r_start = new Rules("text_start_0", 52);
                r_start.setPosicao(y, x);
                faseAtual.add(r_start);
                break;
            case 53:
                Rules r_playText = new Rules("text_play_0", 53);
                r_playText.setPosicao(y, x);
                faseAtual.add(r_playText);
                break;
            case 54:
                Rules r_undo = new Rules("button_undo_0", 54);
                r_undo.setPosicao(y, x);
                faseAtual.add(r_undo);
                break;
            case 55:
                Rules r_newGame = new Rules("text_newgame_0", 55);
                r_newGame.setPosicao(y, x);
                faseAtual.add(r_newGame);
                break;
            case 56:
                Rules r_loadGame = new Rules("text_loadgame_0", 56);
                r_loadGame.setPosicao(y, x);
                faseAtual.add(r_loadGame);
                break;
            case 57:
                Rules r_press = new Rules("text_press_0", 57);
                r_press.setPosicao(y, x);
                faseAtual.add(r_press);
                break;
            case 58:
                Rules r_to = new Rules("text_to_0", 58);
                r_to.setPosicao(y, x);
                faseAtual.add(r_to);
                break;
            case 59:
                Rules r_restart = new Rules("button_restart_0", 58);
                r_restart.setPosicao(y, x);
                faseAtual.add(r_restart);
                break;
            case 60:
                Rules r_and = new Rules("text_and_0", 60);
                r_and.setPosicao(y, x);
                faseAtual.add(r_and);
                break;
            case 61:
                Rules r_enter = new Rules("text_enter_0", 61);
                r_enter.setPosicao(y, x);
                faseAtual.add(r_enter);
            case 80:
                Personagem tile = new Personagem("tile_0", 80);
                tile.setPosicao(y, x);
                backgroundAtual.add(tile);
                break;
            case 81:
                Personagem flower = new Personagem("flower_0", 81);
                flower.setPosicao(y, x);
                backgroundAtual.add(flower);
                break;
            case 82:
                ObjetoVariavel brick = new ObjetoVariavel("Brick/brick_", 82);
                brick.setPosicao(y, x);
                backgroundAtual.add(brick);
                break;
            case 100: // Letra A
                Rules r_A = new Rules("text_a_0", 100);
                r_A.setPosicao(y, x);
                faseAtual.add(r_A);
                break;
            case 101:
                Rules r_B = new Rules("text_b_0", 101);
                r_B.setPosicao(y, x);
                faseAtual.add(r_B);
                break;
            case 102:
                Rules r_C = new Rules("text_c_0", 102);
                r_C.setPosicao(y, x);
                faseAtual.add(r_C);
                break;
            case 103:
                Rules r_D = new Rules("text_d_0", 103);
                r_D.setPosicao(y, x);
                faseAtual.add(r_D);
                break;
            case 104:
                Rules r_E = new Rules("text_e_0", 104);
                r_E.setPosicao(y, x);
                faseAtual.add(r_E);
                break;
            case 106:
                Rules r_G = new Rules("text_g_0", 106);
                r_G.setPosicao(y, x);
                faseAtual.add(r_G);
                break;
            case 107:
                Rules r_H = new Rules("text_h_0", 107);
                r_H.setPosicao(y, x);
                faseAtual.add(r_H);
                break;
            case 108:
                Rules r_I = new Rules("text_i_0", 108);
                r_I.setPosicao(y, x);
                faseAtual.add(r_I);
                break;
            case 111:
                Rules r_L = new Rules("text_l_0", 111);
                r_L.setPosicao(y, x);
                faseAtual.add(r_L);
                break;
            case 112:
                Rules r_M = new Rules("text_m_0", 112);
                r_M.setPosicao(y, x);
                faseAtual.add(r_M);
                break;
            case 113:
                Rules r_N = new Rules("text_n_0", 113);
                r_N.setPosicao(y, x);
                faseAtual.add(r_N);
                break;
            case 114:
                Rules r_O = new Rules("text_o_0", 114);
                r_O.setPosicao(y, x);
                faseAtual.add(r_O);
                break;
            case 115:
                Rules r_P = new Rules("text_p_0", 115);
                r_P.setPosicao(y, x);
                faseAtual.add(r_P);
                break;
            case 117:
                Rules r_R = new Rules("text_r_0", 117);
                r_R.setPosicao(y, x);
                faseAtual.add(r_R);
                break;
            case 118:
                Rules r_S = new Rules("text_s_0", 118);
                r_S.setPosicao(y, x);
                faseAtual.add(r_S);
                break;
            case 119:
                Rules r_T = new Rules("text_t_0", 119);
                r_T.setPosicao(y, x);
                faseAtual.add(r_T);
                break;
            case 120:
                Rules r_U = new Rules("text_u_0", 120);
                r_U.setPosicao(y, x);
                faseAtual.add(r_U);
                break;
            case 124:
                Rules r_Y = new Rules("text_y_0", 124);
                r_Y.setPosicao(y, x);
                faseAtual.add(r_Y);
                break;
            case 125:
                Rules r_Z = new Rules("text_z_0", 120);
                r_Z.setPosicao(y, x);
                faseAtual.add(r_Z);
                break;
            case 200:
                Personagem p_instructions1 = new Personagem("text_instructions_0", 200);
                p_instructions1.setPosicao(y, x);
                faseAtual.add(p_instructions1);
                break;
            case 201:
                Personagem p_instructions2 = new Personagem("text_instructions_1", 201);
                p_instructions2.setPosicao(y, x);
                faseAtual.add(p_instructions2);
                break;
            case 202:
                Personagem p_instructions3 = new Personagem("text_instructions_2", 202);
                p_instructions3.setPosicao(y, x);
                faseAtual.add(p_instructions3);
                break;
            case 203:
                Personagem p_instructions4 = new Personagem("text_instructions_3", 203);
                p_instructions4.setPosicao(y, x);
                faseAtual.add(p_instructions4);
                break;
            case 204:
                Rules r_use = new Rules("text_use_0", 204);
                r_use.setPosicao(y, x);
                faseAtual.add(r_use);
                break;
            case 205:
                Rules r_move = new Rules("text_move_0", 205);
                r_move.setPosicao(y, x);
                faseAtual.add(r_move);
                break;
            case 206:
                Rules r_textArrow = new Rules("text_arrow_0", 206);
                r_textArrow.setPosicao(y, x);
                faseAtual.add(r_textArrow);
                break;
            case 207:
                Rules r_arrowRight = new Rules("arrow_0", 207);
                r_arrowRight.setPosicao(y, x);
                faseAtual.add(r_arrowRight);
                break;
            case 208:
                Rules r_arrowLeft = new Rules("arrow_16", 208);
                r_arrowLeft.setPosicao(y, x);
                faseAtual.add(r_arrowLeft);
                break;
            case 209:
                Rules r_arrowDown = new Rules("arrow_24", 209);
                r_arrowDown.setPosicao(y, x);
                faseAtual.add(r_arrowDown);
                break;
            case 210:
                Rules r_arrowUp = new Rules("arrow_8", 210);
                r_arrowUp.setPosicao(y, x);
                faseAtual.add(r_arrowUp);
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
            Objeto obj = faseAtual.get(i);
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
    
    public ArrayList<Objeto> getFaseAtual() {
        return this.faseAtual;
    }
    
    public ArrayList<Objeto> getBackgroundAtual() {
        return this.backgroundAtual;
    }

    public void startRuleMap() {
        for(int i = 0; i < Consts.RES_HOR; i++)
            for(int j = 0; j < Consts.RES_VER; j++)
                ruleMap[j][i] = 0;

        for(int i = 0; i < faseAtual.size(); i++) {
            Posicao pos = faseAtual.get(i).getPosicao();
            ruleMap[pos.getLinha()][pos.getColuna()] = faseAtual.get(i).getCode();
        }
    }
    
    public void updateRuleMap(Objeto pers) {
        Posicao pos = pers.getPosicao();
        ruleMap[pos.getLinhaAnterior()][pos.getColunaAnterior()] = 0;
        ruleMap[pos.getLinha()][pos.getColuna()] = pers.getCode();
    }
    
    public void updatePosMapa(Objeto pers) {
        Posicao pos = pers.getPosicao();
        matrizMapa[pos.getLinhaAnterior()][pos.getColunaAnterior()] = 0;
        matrizMapa[pos.getLinha()][pos.getColuna()] = pers.getCode();
    }
}

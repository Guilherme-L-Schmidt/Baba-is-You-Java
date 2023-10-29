package Controler;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Tela extends javax.swing.JFrame {

    private static final long serialVersionUID = 6529685098267757698L;
    private Graphics g2;
    private ControleDeJogo cj;
    private String canonicalPath;

    public Tela(ControleDeJogo cj) {
        Desenho.setCenario(this);
        initComponents();
        try {
            this.canonicalPath = new java.io.File(".").getCanonicalPath();
        }
        catch (IOException ex) {
            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.cj = cj;
        
        this.addMouseListener(cj); /*mouse*/
        this.addKeyListener(cj);   /*teclado*/
        
        /*Cria a janela do tamanho do tabuleiro + insets (bordas) da janela*/
        this.setSize(Consts.RES_HOR * Consts.CELL_SIDE + getInsets().left + getInsets().right,
                Consts.RES_VER * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);
    }

    public Graphics getGraphicsBuffer(){
        return g2;
    }
    
    public void paint(Graphics gOld) {
        Graphics g = this.getBufferStrategy().getDrawGraphics();
        /*Criamos um contexto gráfico*/
        g2 = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);
        /*************Desenha cenário de fundo**************/
        int[] offset = this.cj.getOffset();
        for (int i = 0; i < Consts.RES_VER; i++) {
            for (int j = 0; j < Consts.RES_HOR; j++) {
                Image newImage;
                // seleciona background de acordo com os limites do jogo
                if(i < offset[0] || i >= Consts.RES_VER - offset[0] || j < offset[1] || j >= Consts.RES_HOR - offset[2])
                    newImage = Toolkit.getDefaultToolkit().getImage(this.canonicalPath + Consts.PATH + "Limit.png");
                else
                    newImage = Toolkit.getDefaultToolkit().getImage(this.canonicalPath + Consts.PATH + "Background.png");
                g2.drawImage(newImage, j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
            }
        }
        if (!this.cj.getFaseAtual().isEmpty()) {
            this.cj.desenhaTudo(this.cj.getFaseAtual());
        }

        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
    }

    public void go() {
        TimerTask task = new TimerTask() {
            public void run() {
                repaint();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0, Consts.PERIOD);
    }
    
    public void clearTela() {
        this.cj.getFaseAtual().clear();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Baba is You");
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }
}

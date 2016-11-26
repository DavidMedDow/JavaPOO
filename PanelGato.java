import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import gnu.io.SerialPort;

public class PanelGato extends JPanel implements MouseListener{
	
	JToggleButton casilla1,casilla2, casilla3,casilla4,casilla5,casilla6,casilla7,casilla8,casilla9,
	casilla10,casilla11,casilla12,casilla13,casilla14,casilla15,casilla16,casilla17,casilla18,
	casilla19,casilla20,casilla21,casilla22,casilla23,casilla24,casilla25,casilla26,casilla27;
	
	private Casilla[][][] casillas;
	public static Tablero tab;
	private int turnosTotales;
	private int exceptionTurnos; //este hace que el contador no siga aumentando si el usuario cae en una excepci鏮 
	//private static int[] prueba;

	private int ejeX, ejeY, ejeZ, totalEjes;
	private StringTokenizer coordenada;

	private SerialPort serialPort;
	private static final String PORT_NAMES="COM6"; // Windows
	private BufferedReader input;
	private OutputStream output;

	private static final int TIME_OUT = 2000;	/** Milliseconds to block while waiting for port open */
	private static final int DATA_RATE = 9600;  /** Default bits per second for COM port. */
	private boolean encendido,
					reiniciar;
	
	private String[] val;
	
	private static PanelGato pg;
	
	private int ac1, ac2, ac3, ac4, ac5, ac6, ac7, ac8, ac9, ac10, ac11, ac12, ac13, ac14, ac15,
	ac16, ac17, ac18, ac19, ac20, ac21, ac22, ac23, ac24, ac25, ac26, ac27,turno,dis1,dis2,dis3,dis4,dis5,dis6,dis7,
	dis8,dis9,dis10,dis11,dis12,dis13,dis14,dis15,dis16,dis17,dis18,dis19,dis20,dis21,dis22,dis23,dis24,dis25,dis26,dis27;
	
	public PanelGato(){
		super();
		this.setPreferredSize(new Dimension(800,300));
		this.setBackground(Color.WHITE);
		this.ac1=this.ac2=this.ac3=this.ac4=this.ac5=this.ac6=this.ac7=this.ac8=this.ac9=0;
		this.ac10=this.ac11=this.ac12=this.ac13=this.ac14=this.ac15=this.ac16=this.ac17=this.ac18=0;
		this.ac19=this.ac20=this.ac21=this.ac22=this.ac23=this.ac24=this.ac25=this.ac26=this.ac27=0;
		
		this.dis1=this.dis2=this.dis3=this.dis4=this.dis5=this.dis6=this.dis7=this.dis8=this.dis9=this.dis10=1;
		this.dis11=this.dis12=this.dis13=this.dis14=this.dis15=this.dis16=this.dis17=this.dis18=this.dis19=1;
		this.dis20=this.dis21=this.dis22=this.dis23=this.dis24=this.dis25=this.dis26=this.dis27=1;
		
		this.turno=1;
		
		this.val = new String[27];
		
		//Primer Tablero
		this.casilla1=new JToggleButton("");
		this.casilla2=new JToggleButton("");
		this.casilla3=new JToggleButton("");
		this.casilla4=new JToggleButton("");
		this.casilla5=new JToggleButton("");
		this.casilla6=new JToggleButton("");
		this.casilla7=new JToggleButton("");
		this.casilla8=new JToggleButton("");
		this.casilla9=new JToggleButton("");
		//Segundo Tablero
		this.casilla10=new JToggleButton("");
		this.casilla11=new JToggleButton("");
		this.casilla12=new JToggleButton("");
		this.casilla13=new JToggleButton("");
		this.casilla14=new JToggleButton("");
		this.casilla15=new JToggleButton("");
		this.casilla16=new JToggleButton("");
		this.casilla17=new JToggleButton("");
		this.casilla18=new JToggleButton("");
		//Tercer Tablero
		this.casilla19=new JToggleButton("");
		this.casilla20=new JToggleButton("");
		this.casilla21=new JToggleButton("");
		this.casilla22=new JToggleButton("");
		this.casilla23=new JToggleButton("");
		this.casilla24=new JToggleButton("");
		this.casilla25=new JToggleButton("");
		this.casilla26=new JToggleButton("");
		this.casilla27=new JToggleButton("");
		
		this.casilla1.addMouseListener(this);
		this.casilla2.addMouseListener(this);
		this.casilla3.addMouseListener(this);
		this.casilla4.addMouseListener(this);
		this.casilla5.addMouseListener(this);
		this.casilla6.addMouseListener(this);
		this.casilla7.addMouseListener(this);
		this.casilla8.addMouseListener(this);
		this.casilla9.addMouseListener(this);
		this.casilla10.addMouseListener(this);
		this.casilla11.addMouseListener(this);
		this.casilla12.addMouseListener(this);
		this.casilla13.addMouseListener(this);
		this.casilla14.addMouseListener(this);
		this.casilla15.addMouseListener(this);
		this.casilla16.addMouseListener(this);
		this.casilla17.addMouseListener(this);
		this.casilla18.addMouseListener(this);
		this.casilla19.addMouseListener(this);
		this.casilla20.addMouseListener(this);
		this.casilla21.addMouseListener(this);
		this.casilla22.addMouseListener(this);
		this.casilla23.addMouseListener(this);
		this.casilla24.addMouseListener(this);
		this.casilla25.addMouseListener(this);
		this.casilla26.addMouseListener(this);
		this.casilla27.addMouseListener(this);
		
		this.setLayout(null);
		//Primer Tablero
		this.casilla1.setBounds(50, 50, 50, 50);
		this.casilla2.setBounds(110, 50, 50, 50);
		this.casilla3.setBounds(170, 50, 50, 50);
		this.casilla4.setBounds(50,110,50,50);
		this.casilla5.setBounds(110,110,50,50);
		this.casilla6.setBounds(170,110,50,50);
		this.casilla7.setBounds(50,170,50,50);
		this.casilla8.setBounds(110,170,50,50);
		this.casilla9.setBounds(170,170,50,50);
		//Segundo Tablero
		this.casilla10.setBounds(310,50,50,50);
		this.casilla11.setBounds(370,50,50,50);
		this.casilla12.setBounds(430,50,50,50);
		this.casilla13.setBounds(310,110,50,50);
		this.casilla14.setBounds(370,110,50,50);
		this.casilla15.setBounds(430,110,50,50);
		this.casilla16.setBounds(310,170,50,50);
		this.casilla17.setBounds(370,170,50,50);
		this.casilla18.setBounds(430,170,50,50);
		//Tercer Tablero
		this.casilla19.setBounds(570,50,50,50);
		this.casilla20.setBounds(630,50,50,50);
		this.casilla21.setBounds(690,50,50,50);
		this.casilla22.setBounds(570,110,50,50);
		this.casilla23.setBounds(630,110,50,50);
		this.casilla24.setBounds(690,110,50,50);
		this.casilla25.setBounds(570,170,50,50);
		this.casilla26.setBounds(630,170,50,50);
		this.casilla27.setBounds(690,170,50,50);
		//Adders
		this.add(this.casilla1);
		this.add(this.casilla2);
		this.add(this.casilla3);
		this.add(this.casilla4);
		this.add(this.casilla5);
		this.add(this.casilla6);
		this.add(this.casilla7);
		this.add(this.casilla8);
		this.add(this.casilla9);
		this.add(this.casilla10);
		this.add(this.casilla11);
		this.add(this.casilla12);
		this.add(this.casilla13);
		this.add(this.casilla14);
		this.add(this.casilla15);
		this.add(this.casilla16);
		this.add(this.casilla17);
		this.add(this.casilla18);
		this.add(this.casilla19);
		this.add(this.casilla20);
		this.add(this.casilla21);
		this.add(this.casilla22);
		this.add(this.casilla23);
		this.add(this.casilla24);
		this.add(this.casilla25);
		this.add(this.casilla26);
		this.add(this.casilla27);
	}

	public void paintComponent(Graphics g){
/*
 * Antes de pintar cada componente se establecio que cada casilla mide 50x50
 * Las lineas tienen de grueso 10px ya sea horizontal o vertical
 * Por conveniencia de aparencia, el "O" y "X" deberan de estar 10 px de diferencia en x & y 
 * Esto con el objetivo dee que no intercepten con las lineas del gato
 * Estos tambien tienen un tama隳 de 30x30 pixeles
 */
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		
		//--Gato 1--
		g.fillRect(50, 100, 170, 10); //--
		g.fillRect(50, 160, 170, 10); //--
		g.fillRect(100, 50, 10, 170); // |
		g.fillRect(160, 50, 10, 170); //   |
		g.drawString("Gato 1", 115, 240);
		
		//--Gato 2--
		g.fillRect(310, 100, 170, 10);
		g.fillRect(310, 160, 170, 10);
		g.fillRect(360, 50, 10, 170);
		g.fillRect(420, 50, 10, 170);
		g.drawString("Gato 2", 375, 240);
		
		//--Gato 3--
		g.fillRect(570, 100, 170, 10);
		g.fillRect(570, 160, 170, 10);
		g.fillRect(620, 50, 10, 170);
		g.fillRect(680, 50, 10, 170);
		g.drawString("Gato 3", 635, 240);
		
		
		
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		if((e.getSource() == this.casilla1)&&(this.turno==1)&&(this.dis1==1)){
			this.casilla1.setText("X");
			this.val[0]="X";
			if(this.val[0]=="X"&&this.val[1]=="X"&&this.val[2]=="X"){
				JOptionPane.showMessageDialog(null, "Gana el jugador 1");
			}
			this.dis1=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla1)&&(this.turno==0)&&(this.dis1==1)){
			this.casilla1.setText("O");
			this.val[0]="O";
			this.dis1=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla2)&&(this.turno==1)&&(this.dis2==1)){
			this.casilla2.setText("X");
			this.val[1]="X";
			if(this.val[0]=="X"&&this.val[1]=="X"&&this.val[2]=="X"){
				JOptionPane.showMessageDialog(null, "Gana el jugador 1");
			}
			this.dis2=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla2)&&(this.turno==0)&&(this.dis2==1)){
			this.casilla2.setText("O");
			this.val[1]="O";
			this.dis2=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla3)&&(this.turno==1)&&(this.dis3==1)){
			this.casilla3.setText("X");
			this.val[2]="X";
			if(this.val[0]=="X"&&this.val[1]=="X"&&this.val[2]=="X"){
				JOptionPane.showMessageDialog(null, "Gana el jugador 1");
			}
			this.dis3=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla3)&&(this.turno==0)&&(this.dis3==1)){
			this.casilla3.setText("O");
			this.val[2]="O";
			this.dis3=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla4)&&(this.turno==1)&&(this.dis4==1)){
			this.casilla4.setText("X");
			this.val[3]="X";
			if(this.val[3]=="X"&&this.val[4]=="X"&&this.val[5]=="X"){
				JOptionPane.showMessageDialog(null, "Gana el jugador 1");
			}
			this.dis4=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla4)&&(this.turno==0)&&(this.dis4==1)){
			this.casilla4.setText("O");
			this.val[3]="O";
			this.dis4=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla5)&&(this.turno==1)&&(this.dis5==1)){
			this.casilla5.setText("X");
			this.val[4]="X";
			if(this.val[3]=="X"&&this.val[4]=="X"&&this.val[5]=="X"){
				JOptionPane.showMessageDialog(null, "Gana el jugador 1");
			}
			this.dis5=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla5)&&(this.turno==0)&&(this.dis5==1)){
			this.casilla5.setText("O");
			this.val[4]="O";
			this.dis5=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla6)&&(this.turno==1)&&(this.dis6==1)){
			this.casilla6.setText("X");
			this.val[5]="X";
			if(this.val[3]=="X"&&this.val[4]=="X"&&this.val[5]=="X"){
				JOptionPane.showMessageDialog(null, "Gana el jugador 1");
			}
			this.dis6=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla6)&&(this.turno==0)&&(this.dis6==1)){
			this.casilla6.setText("O");
			this.val[5]="O";
			this.dis6=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla7)&&(this.turno==1)&&(this.dis7==1)){
			this.casilla7.setText("X");
			this.val[6]="X";
			if(this.val[6]=="X"&&this.val[7]=="X"&&this.val[8]=="X"){
				JOptionPane.showMessageDialog(null, "Gana el jugador 1");
			}
			this.dis7=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla7)&&(this.turno==0)&&(this.dis7==1)){
			this.casilla7.setText("O");
			this.val[6]="O";
			this.dis7=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla8)&&(this.turno==1)&&(this.dis8==1)){
			this.casilla8.setText("X");
			this.val[7]="X";
			if(this.val[6]=="X"&&this.val[7]=="X"&&this.val[8]=="X"){
				JOptionPane.showMessageDialog(null, "Gana el jugador 1");
			}
			this.dis8=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla8)&&(this.turno==0)&&(this.dis8==1)){
			this.casilla8.setText("O");
			this.val[7]="O";
			this.dis8=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla9)&&(this.turno==1)&&(this.dis9==1)){
			this.casilla9.setText("X");
			this.val[8]="X";
			if(this.val[6]=="X"&&this.val[7]=="X"&&this.val[8]=="X"){
				JOptionPane.showMessageDialog(null, "Gana el jugador 1");
			}
			this.dis9=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla9)&&(this.turno==0)&&(this.dis9==1)){
			this.casilla9.setText("O");
			this.val[8]="O";
			this.dis9=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla10)&&(this.turno==1)&&(this.dis10==1)){
			this.casilla10.setText("X");
			this.val[9]="X";
			if(this.val[9]=="X"&&this.val[10]=="X"&&this.val[11]=="X"){
				JOptionPane.showMessageDialog(null, "Gana el jugador 1");
			}
			this.dis10=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla10)&&(this.turno==0)&&(this.dis10==1)){
			this.casilla10.setText("O");
			this.val[9]="O";
			this.dis10=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla11)&&(this.turno==1)&&(this.dis11==1)){
			this.casilla11.setText("X");
			this.val[10]="X";
			if(this.val[9]=="X"&&this.val[10]=="X"&&this.val[11]=="X"){
				JOptionPane.showMessageDialog(null, "Gana el jugador 1");
			}
			this.dis11=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla11)&&(this.turno==0)&&(this.dis11==1)){
			this.casilla11.setText("O");
			this.val[10]="O";
			this.dis11=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla12)&&(this.turno==1)&&(this.dis12==1)){
			this.casilla12.setText("X");
			this.val[11]="X";
			if(this.val[9]=="X"&&this.val[10]=="X"&&this.val[11]=="X"){
				JOptionPane.showMessageDialog(null, "Gana el jugador 1");
			}
			this.dis12=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla12)&&(this.turno==0)&&(this.dis12==1)){
			this.casilla12.setText("O");
			this.val[11]="O";
			this.dis12=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla13)&&(this.turno==1)&&(this.dis13==1)){
			this.casilla13.setText("X");
			this.val[12]="X";
			if(this.val[12]=="X"&&this.val[13]=="X"&&this.val[14]=="X"){
				JOptionPane.showMessageDialog(null, "Gana el jugador 1");
			}
			this.dis13=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla13)&&(this.turno==0)&&(this.dis13==1)){
			this.casilla13.setText("O");
			this.val[12]="O";
			this.dis13=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla14)&&(this.turno==1)&&(this.dis14==1)){
			this.dis14=0;
			this.val[13]="X";
			if(this.val[12]=="X"&&this.val[13]=="X"&&this.val[14]=="X"){
				JOptionPane.showMessageDialog(null, "Gana el jugador 1");
			}
			this.casilla14.setText("X");
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla14)&&(this.turno==0)&&(this.dis14==1)){
			this.casilla14.setText("O");
			this.val[13]="O";
			this.dis14=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla15)&&(this.turno==1)&&(this.dis15==1)){
			this.casilla15.setText("X");
			this.val[14]="X";
			if(this.val[12]=="X"&&this.val[13]=="X"&&this.val[14]=="X"){
				JOptionPane.showMessageDialog(null, "Gana el jugador 1");
			}
			this.dis15=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla15)&&(this.turno==0)&&(this.dis15==1)){
			this.casilla15.setText("O");
			this.val[14]="O";
			this.dis15=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla16)&&(this.turno==1)&&(this.dis16==1)){
			this.casilla16.setText("X");
			this.val[15]="X";
			if(this.val[15]=="X"&&this.val[16]=="X"&&this.val[17]=="X"){
				JOptionPane.showMessageDialog(null, "Gana el jugador 1");
			}
			this.dis16=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla16)&&(this.turno==0)&&(this.dis16==1)){
			this.casilla16.setText("O");
			this.val[15]="O";
			this.dis16=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla17)&&(this.turno==1)&&(this.dis17==1)){
			this.casilla17.setText("X");
			this.val[16]="X";4if(this.val[15]=="X"&&this.val[16]=="X"&&this.val[17]=="X"){
				JOptionPane.showMessageDialog(null, "Gana el jugador 1");
			}
			this.dis17=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla17)&&(this.turno==0)&&(this.dis17==1)){
			this.casilla17.setText("O");
			this.val[16]="O";
			this.dis17=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla18)&&(this.turno==1)&&(this.dis18==1)){
			this.casilla18.setText("X");
			this.val[17]="X";
			if(this.val[15]=="X"&&this.val[16]=="X"&&this.val[17]=="X"){
				JOptionPane.showMessageDialog(null, "Gana el jugador 1");
			}
			this.dis18=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla18)&&(this.turno==0)&&(this.dis18==1)){
			this.casilla18.setText("O");
			this.val[17]="O";
			this.dis18=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla19)&&(this.turno==1)&&(this.dis19==1)){
			this.casilla19.setText("X");
			this.val[18]="X";
			if(this.val[18]=="X"&&this.val[19]=="X"&&this.val[20]=="X"){
				JOptionPane.showMessageDialog(null, "Gana el jugador 1");
			}
			this.dis19=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla19)&&(this.turno==0)&&(this.dis19==1)){
			this.dis19=0;
			this.val[18]="O";
			this.casilla19.setText("O");
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla20)&&(this.turno==1)&&(this.dis20==1)){
			this.casilla20.setText("X");
			this.val[19]="X";
			if(this.val[18]=="X"&&this.val[19]=="X"&&this.val[20]=="X"){
				JOptionPane.showMessageDialog(null, "Gana el jugador 1");
			}
			this.dis20=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla20)&&(this.turno==0)&&(this.dis20==1)){
			this.casilla20.setText("O");
			this.val[19]="O";
			this.dis20=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla21)&&(this.turno==1)&&(this.dis21==1)){
			this.casilla21.setText("X");
			this.val[20]="X";
			if(this.val[18]=="X"&&this.val[19]=="X"&&this.val[20]=="X"){
				JOptionPane.showMessageDialog(null, "Gana el jugador 1");
			}
			this.dis21=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla21)&&(this.turno==0)&&(this.dis21==1)){
			this.casilla21.setText("O");
			this.val[20]="O";
			this.dis21=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla22)&&(this.turno==1)&&(this.dis22==1)){
			this.casilla22.setText("X");
			this.val[21]="X";
			this.dis22=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla22)&&(this.turno==0)&&(this.dis22==1)){
			this.casilla22.setText("O");
			this.val[21]="O";
			this.dis22=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla23)&&(this.turno==1)&&(this.dis23==1)){
			this.casilla23.setText("X");
			this.val[22]="X";
			this.dis23=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla23)&&(this.turno==0)&&(this.dis23==1)){
			this.casilla23.setText("O");
			this.val[22]="O";
			this.dis23=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla24)&&(this.turno==1)&&(this.dis24==1)){
			this.casilla24.setText("X");
			this.val[23]="X";
			this.dis24=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla24)&&(this.turno==0)&&(this.dis24==1)){
			this.casilla24.setText("O");
			this.val[23]="O";
			this.dis24=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla25)&&(this.turno==1)&&(this.dis25==1)){
			this.casilla25.setText("X");
			this.val[24]="X";
			this.dis25=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla25)&&(this.turno==0)&&(this.dis25==1)){
			this.casilla25.setText("O");
			this.val[24]="O";
			this.dis25=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla26)&&(this.turno==1)&&(this.dis26==1)){
			this.casilla26.setText("X");
			this.val[25]="X";
			this.dis26=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla26)&&(this.turno==0)&&(this.dis26==1)){
			this.casilla26.setText("O");
			this.val[25]="O";
			this.dis26=0;
			this.turno=1;
			repaint();
		}
		if((e.getSource() == this.casilla27)&&(this.turno==1)&&(this.dis27==1)){
			this.casilla27.setText("X");
			this.val[26]="X";
			this.dis27=0;
			this.turno=0;
			repaint();
		}
		else if((e.getSource()==this.casilla27)&&(this.turno==0)&&(this.dis27==1)){
			this.casilla27.setText("O");
			this.val[26]="O";
			this.dis27=0;
			this.turno=1;
			repaint();
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

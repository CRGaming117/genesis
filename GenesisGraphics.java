package genesis;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GenesisGraphics extends JPanel
{
	private int w, h;
	private int boxWH;
	private int room=0;
	private int score=0;
	private Rectangle wallr1;
	private ArrayList<Rectangle> walls;
	private ArrayList<Rectangle> coins;
	private Rectangle coin;
	private Rectangle dhb;
	private Color dc;
	
	//player variables
	private int vX, vY;
	private int px, py;
	private Rectangle player;
	private int SPEED = 7;
	private boolean left, right, down, up;
	//coin variables
	private int cx, cy, cs;
	
	private Timer t;

	
	private Rectangle newPlayer(Rectangle p) {
		vX=0;
		vY=0;
		px=680;
		py=330;
		boxWH=40;
		p=new Rectangle(px, py, boxWH, boxWH);
		return p;
	}
	
	//Constructor
	public GenesisGraphics(int w, int h)
	{
		this.w = w;
		this.h = h;
		this.setPreferredSize(new Dimension(w,h));

		//player
		player=newPlayer(player);
		
		this.addKeyListener(new KL());
		this.setFocusable(true);
		
		t = new Timer(15, new AL());
		t.start();
		
		//walls:
		createWalls();
		
		dhb=new Rectangle(300, h/2-10, 20, 20);
		dc=Color.cyan;
		
		cs=30;
		cx=w-w/3;
		cy=h/2-cs/2;
		
		//coins
		createCoins();
	}
	//populates walls arraylist with rectangle objects that represent the wall location and dimension
	private void createWalls() {
		wallr1=new Rectangle((w/2)-400, (h/2)-100, 800, 200);
		
		walls = new ArrayList<Rectangle>();
		
		//room 2
		walls.add(new Rectangle(0, 0, 200, 200));//wall 0
		walls.add(new Rectangle(w-200, 100, 200, 200));//wall 1
		walls.add(new Rectangle(0, h-200, 900, 200));//wall 2
		walls.add(new Rectangle(500, h-300, 400, 300));//wall 3
		//room 3
		walls.add(new Rectangle(100, 200, 100, 200));//wall 4
		walls.add(new Rectangle(100, 500, 300, 100));//wall 5
		walls.add(new Rectangle(300, 200, 100, 300));//wall 6
		walls.add(new Rectangle(500, 0, 100, 500));//wall 7
		walls.add(new Rectangle(500, 400, 500, 100));//wall 8
		walls.add(new Rectangle(700, 200, 500, 100));//wall 9
		walls.add(new Rectangle(w-300, 200, 100, 500));//wall 10
		walls.add(new Rectangle(0, h-100, w-200, 100));//wall 11
		walls.add(new Rectangle(0, 0, 100, 300));//wall 12
		walls.add(new Rectangle(0, 200, 200, 100));//wall 13
		walls.add(new Rectangle(0, 0, w, 100));//top wall 14
		walls.add(new Rectangle(w-100, 0, 100, h));//right wall 15
		//room 4
		walls.add(new Rectangle(0, 0, w, 100));//wall 16
		walls.add(new Rectangle(0, h-100, 600, 100));//wall 17
		walls.add(new Rectangle(w-600, h-100, 600, 100));//wall 18
		walls.add(new Rectangle(0, 0, 100, h));//wall 19
		walls.add(new Rectangle(w-100, 0, 100, 300));//wall 20
		walls.add(new Rectangle(w-100, h-300, 100, 300));//wall 21
		for(int i=1;i<=6;i++) {//wall 22-27
			walls.add(new Rectangle(100*i, 0, 50, 150));
		}
		for(int i=1;i<=6;i++) {//walls 28-33
			walls.add(new Rectangle(650+100*i, 0, 50, 150));
		}
		for(int i=1;i<=5;i++) {//walls 34-38
			walls.add(new Rectangle(100*i, h-150, 50, 150));
		}
		for(int i=1;i<=5;i++) {//walls 39-43
			walls.add(new Rectangle(750+100*i, h-150, 50, 150));
		}
		walls.add(new Rectangle(0, 200, 150, 50));//wall 44
		walls.add(new Rectangle(0, 300, 150, 100));//wall 45
		walls.add(new Rectangle(0, h-250, 150, 50));//wall 46
		walls.add(new Rectangle(w-150, 200, 150, 50));//wall 47
		walls.add(new Rectangle(w-150, h-250, 150, 50));//wall 48
		//room 5
		walls.add(new Rectangle(0, 0, w, 100));//wall 49
		walls.add(new Rectangle(0, h-100, 600, 100));//wall 50
		walls.add(new Rectangle(w-600, h-100, 600, 100));//wall 51
		walls.add(new Rectangle(w-100, 0, 100, h));//wall 52
		walls.add(new Rectangle(0, 0, 100, 300));//wall 53
		walls.add(new Rectangle(0, h-300, 100, 300));//wall 54
		for(int i=1;i<=6;i++) {//wall 55-60
			walls.add(new Rectangle(100*i, 0, 50, 150));
		}
		for(int i=1;i<=6;i++) {//walls 61-66
			walls.add(new Rectangle(650+100*i, 0, 50, 150));
		}
		for(int i=1;i<=5;i++) {//walls 67-71
			walls.add(new Rectangle(100*i, h-150, 50, 150));
		}
		for(int i=1;i<=5;i++) {//walls 72-76
			walls.add(new Rectangle(750+100*i, h-150, 50, 150));
		}
		walls.add(new Rectangle(w-150, 200, 150, 50));//wall 77
		walls.add(new Rectangle(w-150, 300, 150, 100));//wall 78
		walls.add(new Rectangle(w-150, h-250, 150, 50));//wall 79
		walls.add(new Rectangle(0, 200, 150, 50));//wall 80
		walls.add(new Rectangle(0, h-250, 150, 50));//wall 81
		//room 11
		walls.add(new Rectangle(0, 0, 500, 100));//wall 82
		walls.add(new Rectangle(w-500, 0, 500, 250));//wall 83
		walls.add(new Rectangle(0, 0, 100, h));//wall 84
		walls.add(new Rectangle(0, h-100, w, 100));//wall 85
		walls.add(new Rectangle(w-200, h-250, 200, 250));//wall 86
		walls.add(new Rectangle(300, 300, 700, 100));//wall 87
		walls.add(new Rectangle(w-500, 0, 100, 300));//wall 88
		//room 12
		walls.add(new Rectangle(0, 0, w, 100));//wall 89
		walls.add(new Rectangle(0, h-100, w, 100));//wall 90
		walls.add(new Rectangle(w-100, h-300, 100, 300));//wall 91
		walls.add(new Rectangle(0, 0, 400, 250));//wall 92
		walls.add(new Rectangle(100, 400, 100, 300));//wall 93
		walls.add(new Rectangle(0, 450, 200, 250));//wall 94
		walls.add(new Rectangle(100, 0, 300, 300));//wall 95
		walls.add(new Rectangle(300, 0, 100, h-200));//wall 96
		walls.add(new Rectangle(500, 200, 100, 500));//wall 97
		walls.add(new Rectangle(700, 0, 100, 500));//wall 98
		walls.add(new Rectangle(900, 200, 100, 500));//wall 99
		walls.add(new Rectangle(w-300, 0, 300, 300));//wall 100
		walls.add(new Rectangle(w-300, 0, 100, h-200));//wall 101
		//room 13
		walls.add(new Rectangle(0, 0, w-200, 100));//wall 102
		walls.add(new Rectangle(w-100, 0, 100, 300));//wall 103
		walls.add(new Rectangle(w-100, 400, 100, 300));//wall 104
		walls.add(new Rectangle(0, 0, 100, 300));//wall 105
		walls.add(new Rectangle(0, 400, 100, 300));//wall 106
		walls.add(new Rectangle(0, h-100, 600, 100));//wall 107
		walls.add(new Rectangle(w-700, h-100, 700, 100));//wall 108
		walls.add(new Rectangle(200, 0, 100, 200));//wall 109
		walls.add(new Rectangle(200, 300, 100, 200));//wall 110
		walls.add(new Rectangle(400, 200, 100, 200));//wall 111
		walls.add(new Rectangle(400, h-200, 100, 200));//wall 112
		walls.add(new Rectangle(600, 0, 100, 200));//wall 113
		walls.add(new Rectangle(600, 300, 100, 200));//wall 114
		walls.add(new Rectangle(800, 200, 100, 200));//wall 115
		walls.add(new Rectangle(800, h-200, 100, 200));//wall 116
		walls.add(new Rectangle(1000, 0, 100, 200));//wall 117
		walls.add(new Rectangle(1000, 300, 100, 200));//wall 118
		walls.add(new Rectangle(w-200, 200, 200, 100));//wall 119
		walls.add(new Rectangle(w-200, h-200, 200, 200));//wall 120
		//room 14
		walls.add(new Rectangle(0, 0, 600, 100));//wall 121
		walls.add(new Rectangle(w-600, 0, 600, 100));//wall 122
		walls.add(new Rectangle(0, h-100, 600, 100));//wall 123
		walls.add(new Rectangle(w-600, h-100, 600, 100));//wall 124
		walls.add(new Rectangle(w-100, 0, 100, 300));//wall 125
		walls.add(new Rectangle(w-100, h-300, 100, 300));//wall 126
		walls.add(new Rectangle(0, 0, 100, 300));//wall 127
		walls.add(new Rectangle(0, h-300, 100, 300));//wall 128
		for(int i=1;i<6;i++) {//wall 129-133
			walls.add(new Rectangle(100*i, 0, 50, 150));
		}
		for(int i=1;i<6;i++) {//walls 134-138
			walls.add(new Rectangle(750+100*i, 0, 50, 150));
		}
		for(int i=1;i<6;i++) {//walls 139-143
			walls.add(new Rectangle(100*i, h-150, 50, 150));
		}
		for(int i=1;i<6;i++) {//walls 144-148
			walls.add(new Rectangle(750+100*i, h-150, 50, 150));
		}
		walls.add(new Rectangle(0, 200, 150, 50));//wall 149
		walls.add(new Rectangle(0, h-250, 150, 50));//wall 150
		walls.add(new Rectangle(w-150, 200, 150, 50));//wall 151
		walls.add(new Rectangle(w-150, h-250, 150, 50));//wall 152
		//room 15
		walls.add(new Rectangle(0, 0, 600, 100));//wall 153
		walls.add(new Rectangle(w-600, 0, 600, 100));//wall 154
		walls.add(new Rectangle(0, h-100, 600, 100));//wall 155
		walls.add(new Rectangle(w-600, h-100, 600, 100));//wall 156
		walls.add(new Rectangle(0, 0, 100, 300));//wall 157
		walls.add(new Rectangle(0, h-300, 100, 300));//wall 158
		walls.add(new Rectangle(w-100, 0, 100, h));//wall 159
		for(int i=1;i<6;i++) {//wall 160-164
			walls.add(new Rectangle(100*i, 0, 50, 150));
		}
		for(int i=1;i<6;i++) {//walls 165-169
			walls.add(new Rectangle(750+100*i, 0, 50, 150));
		}
		for(int i=1;i<6;i++) {//walls 170-174
			walls.add(new Rectangle(100*i, h-150, 50, 150));
		}
		for(int i=1;i<6;i++) {//walls 175-179
			walls.add(new Rectangle(750+100*i, h-150, 50, 150));
		}
		walls.add(new Rectangle(w-150, 200, 150, 50));//wall 180
		walls.add(new Rectangle(w-150, 300, 150, 100));//wall 181
		walls.add(new Rectangle(w-150, h-250, 150, 50));//wall 182
		walls.add(new Rectangle(0, 200, 150, 50));//wall 183
		walls.add(new Rectangle(0, h-250, 150, 50));//wall 184
		//room 21
		walls.add(new Rectangle(0, 0, w, 100));//wall 185
		walls.add(new Rectangle(0, h-100, w, 100));//wall 186
		walls.add(new Rectangle(0, 0, 100, h));//wall 187
		walls.add(new Rectangle(w-100, 0, 100, 200));//wall 188
		walls.add(new Rectangle(w-100, h-200, 100, 200));//wall 189
		//room 22
		walls.add(new Rectangle(0, 0, w, 100));//wall 190
		walls.add(new Rectangle(0, h-100, w, 100));//wall 191
		walls.add(new Rectangle(0, 0, 100, 200));//wall 192
		walls.add(new Rectangle(0, h-200, 100, 200));//wall 193
		walls.add(new Rectangle(w-100, 0, 100, 200));//wall 194
		walls.add(new Rectangle(w-100, h-200, 100, 200));//wall 195
		walls.add(new Rectangle(500, 150, 400, 100));//wall 196
		walls.add(new Rectangle(500, 150, 100, 150));//wall 197
		walls.add(new Rectangle(800, 150, 100, 150));//wall 198
		walls.add(new Rectangle(500, 400, 100, 150));//wall 199
		walls.add(new Rectangle(800, 400, 100, 150));//wall 200
		walls.add(new Rectangle(500, h-250, 400, 100));//wall 201
		//room 23
		walls.add(new Rectangle(0, 0, 600, 100));//wall 202
		walls.add(new Rectangle(w-700, 0, 700, 100));//wall 203
		walls.add(new Rectangle(0, h-100, w, 100));//wall 204
		walls.add(new Rectangle(0, 0, 100, 200));//wall 205
		walls.add(new Rectangle(0, h-200, 100, 200));//wall 206
		walls.add(new Rectangle(w-100, 0, 100, h));//wall 207
		walls.add(new Rectangle(300, 300, 100, 400));//wall 208
		walls.add(new Rectangle(300, 300, 400, 100));//wall 209
		walls.add(new Rectangle(800, 300, 100, 400));//wall 210
		walls.add(new Rectangle(1000, 300, 400, 100));//wall 211
		//room 24
		walls.add(new Rectangle(0, h-100, w, 100));//wall 212
		walls.add(new Rectangle(0, 0, 600, 100));//wall 213
		walls.add(new Rectangle(w-600, 0, 600, 100));//wall 214
		walls.add(new Rectangle(0, 0, 100, h));//wall 215
		walls.add(new Rectangle(w-100, 0, 100, 300));//wall 216
		walls.add(new Rectangle(w-100, h-300, 100, 300));//wall 217
		for(int i=1;i<=5;i++) {//wall 218-222
			walls.add(new Rectangle(100*i, 0, 50, 150));
		}
		for(int i=1;i<=5;i++) {//walls 223-227
			walls.add(new Rectangle(750+100*i, 0, 50, 150));
		}
		for(int i=1;i<=6;i++) {//walls 228-233
			walls.add(new Rectangle(100*i, h-150, 50, 150));
		}
		for(int i=1;i<=6;i++) {//walls 234-239
			walls.add(new Rectangle(650+100*i, h-150, 50, 150));
		}
		walls.add(new Rectangle(0, 200, 150, 50));//wall 240
		walls.add(new Rectangle(0, 300, 150, 100));//wall 241
		walls.add(new Rectangle(0, h-250, 150, 50));//wall 242
		walls.add(new Rectangle(w-150, 200, 150, 50));//wall 243
		walls.add(new Rectangle(w-150, h-250, 150, 50));//wall 244
		//room 25
		walls.add(new Rectangle(0, h-100, w, 100));//wall 245
		walls.add(new Rectangle(0, 0, 600, 100));//wall 246
		walls.add(new Rectangle(w-600, 0, 600, 100));//wall 247
		walls.add(new Rectangle(w-100, 0, 100, h));//wall 248
		walls.add(new Rectangle(0, 0, 100, 300));//wall 249
		walls.add(new Rectangle(0, h-300, 100, 300));//wall 250
		for(int i=1;i<=5;i++) {//wall 251-255
			walls.add(new Rectangle(100*i, 0, 50, 150));
		}
		for(int i=1;i<=5;i++) {//walls 256-261
			walls.add(new Rectangle(750+100*i, 0, 50, 150));
		}
		for(int i=1;i<=6;i++) {//walls 262-267
			walls.add(new Rectangle(100*i, h-150, 50, 150));
		}
		for(int i=1;i<=6;i++) {//walls 268-274
			walls.add(new Rectangle(650+100*i, h-150, 50, 150));
		}
		walls.add(new Rectangle(w-150, 200, 150, 50));//wall 275
		walls.add(new Rectangle(w-150, 300, 150, 100));//wall 276
		walls.add(new Rectangle(w-150, h-250, 150, 50));//wall 277
		walls.add(new Rectangle(0, 200, 150, 50));//wall 278
		walls.add(new Rectangle(0, h-250, 150, 50));//wall 279
	}
	//populates coins arraylist with rectangle objects that represent the coin location
	private void createCoins() {
		coin=new Rectangle(cx, cy, cs, cs);
		coins=new ArrayList<Rectangle>();
		coins.add(coin);//coin 0
		coins.add(new Rectangle(w/2-15, h-100-cs, cs, cs));//coin 1
		coins.add(new Rectangle((w-200)-cs/2, h/2-cs/2, cs, cs));//coin 2
		coins.add(new Rectangle(300, 300-cs/2, cs, cs));//coin 3
		coins.add(new Rectangle(w-300-cs, 300, cs, cs));//coin 4
		coins.add(new Rectangle(150-cs/2, 150-cs/2, cs, cs));//coin 5
		coins.add(new Rectangle(750-cs/2, h-150-cs/2, cs, cs));//coin 6
		coins.add(new Rectangle(650-cs/2, 250-cs/2, cs, cs));//coin 7
		coins.add(new Rectangle(w-150-cs/2, 400-cs/2, cs, cs));//coin 8
		coins.add(new Rectangle(450-cs/2, 350-cs/2, cs, cs));//coin 9
		coins.add(new Rectangle(w/2-cs/2, h/2-cs/2, cs, cs));//coin 10
		coins.add(new Rectangle(950-cs/2, h/2-cs/2, cs, cs));//coin 11
		coins.add(new Rectangle(450-cs/2, h/2-cs/2, cs, cs));//coin 12
		coins.add(new Rectangle(w/2-cs/2, h/2-cs/2, cs, cs));//coin 13
		coins.add(new Rectangle(950-cs/2, h/2-cs/2, cs, cs));//coin 14
		coins.add(new Rectangle(400-cs/2, 200-cs/2, cs, cs));//coin 15
		coins.add(new Rectangle(650-cs/2, h-200-cs/2, cs, cs));//coin 16
		coins.add(new Rectangle(450-cs/2, h/2-cs/2, cs, cs));//coin 17
		coins.add(new Rectangle(650-cs/2, h/2-cs/2, cs, cs));//coin 18
		coins.add(new Rectangle(w-550-cs/2, h/2-cs/2, cs, cs));//coin 19
		coins.add(new Rectangle(w-350-cs/2, h/2-cs/2, cs, cs));//coin 20
		coins.add(new Rectangle(w-200-cs/2, h-300-cs/2, cs, cs));//coin 21
		coins.add(new Rectangle(450-cs/2, h/2-cs/2, cs, cs));//coin 22
		coins.add(new Rectangle(w/2-cs/2, h/2-cs/2, cs, cs));//coin 23
		coins.add(new Rectangle(950-cs/2, h/2-cs/2, cs, cs));//coin 24
		coins.add(new Rectangle(450-cs/2, h/2-cs/2, cs, cs));//coin 25
		coins.add(new Rectangle(w/2-cs/2, h/2-cs/2, cs, cs));//coin 26
		coins.add(new Rectangle(950-cs/2, h/2-cs/2, cs, cs));//coin 27
		coins.add(new Rectangle(300-cs/2, h/2-cs/2, cs, cs));//coin 28
		coins.add(new Rectangle(w/2-cs/2, h/2-cs/2, cs, cs));//coin 29
		coins.add(new Rectangle(w-300-cs/2, h/2-cs/2, cs, cs));//coin 30
		coins.add(new Rectangle(500-cs/2, h-200-cs/2, cs, cs));//coin 31
		coins.add(new Rectangle(700-cs/2, h-200-cs/2, cs, cs));//coin 32
		coins.add(new Rectangle(w-400-cs/2, h-200-cs/2, cs, cs));//coin 33
		coins.add(new Rectangle(w-200-cs/2, h-200-cs/2, cs, cs));//coin 34
		coins.add(new Rectangle(w-200-cs/2, 200-cs/2, cs, cs));//coin 35
		coins.add(new Rectangle(450-cs/2, h/2-cs/2, cs, cs));//coin 36
		coins.add(new Rectangle(w/2-cs/2, h/2-cs/2, cs, cs));//coin 37
		coins.add(new Rectangle(950-cs/2, h/2-cs/2, cs, cs));//coin 38
		coins.add(new Rectangle(450-cs/2, h/2-cs/2, cs, cs));//coin 39
		coins.add(new Rectangle(w/2-cs/2, h/2-cs/2, cs, cs));//coin 40
		coins.add(new Rectangle(950-cs/2, h/2-cs/2, cs, cs));//coin 41
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//player
		g.setColor(new Color(50, 100, 0));
		g.fillRect(px, py, boxWH, boxWH);
		
		//coin
		g.setColor(new Color(240, 200, 10));
		g.fillOval(coin.x, coin.y, coin.width, coin.height);
		
		//room generator
		this.setBackground(Color.lightGray);
		g.setColor(Color.darkGray);
		//case = room
		switch(room) { 
		case 0: //
			g.fillRect(0, 0, w, 100);//top wall
			g.fillRect(w-100, 0, 100, 200);//right top wall
			g.fillRect(w-100, h-200, 100, 200);//right bottom wall			
			g.fillRect(0, 0, 100, h);//left wall
			g.fillRect(0, h-100, w, 100);//bottom wall
			//instructions
		    g.setFont(new Font("Times New Roman", Font.BOLD, 50));
		    g.drawString("Use the arrows keys to move.", 325, 200);
		    g.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		    g.drawString("Collect          and find the                .", 450, 250);
		    g.setColor(new Color(240, 200, 10));
		    g.drawString("coins", 525, 250);
		    g.setColor(Color.cyan);
		    g.drawString("diamond", 705, 250);
		    //coin
		    g.setColor(new Color(240, 200, 10));
		    g.drawOval(coin.x, coin.y, coin.width, coin.height);
		break;
		case 1: //
		    g.setColor(Color.darkGray);
			g.fillRect(0, 0, w, 100);//top wall
			g.fillRect(0, 0, 100, h);//left wall
			g.fillRect(0, h-100, 500, 100);//bottom left wall
			g.fillRect(w-500, h-100, 500, 100);//bottom right wall
			g.fillRect(w-100, 0, 100, 200);//right top wall
			g.fillRect(w-100, h-200, 100, 200);//right bottom wall
			g.fillRect(wallr1.x, wallr1.y, wallr1.width, wallr1.height);//middle wall
			for(int i=1;i<3;i++){//coins
				g.setColor(new Color(240, 200, 10));
				g.fillOval(coins.get(i).x, coins.get(i).y, coins.get(i).width, coins.get(i).height);
			}
		break;
		case 2: //
		    g.setColor(Color.darkGray);
			g.fillRect(0, 0, w, 100);//top wall
			g.fillRect(0, h-100, w, 100);//bottom wall
			for(int i=0;i<4;i++) {//walls
				g.fillRect(walls.get(i).x, walls.get(i).y, walls.get(i).width, walls.get(i).height);
			}
			for(int i=3;i<5;i++){//coins
				g.setColor(new Color(240, 200, 10));
				g.fillOval(coins.get(i).x, coins.get(i).y, coins.get(i).width, coins.get(i).height);
			}
		break;
		case 3: //
			for(int i=4; i<16;i++) {//walls
			    g.setColor(Color.darkGray);
				g.fillRect(walls.get(i).x, walls.get(i).y, walls.get(i).width, walls.get(i).height);
			}
			for(int i=5;i<9;i++){//coins
				g.setColor(new Color(240, 200, 10));
				g.fillOval(coins.get(i).x, coins.get(i).y, coins.get(i).width, coins.get(i).height);
			}
		break;
		case 4: //
			for(int i=16; i<49;i++) {//walls
			    g.setColor(Color.darkGray);
				g.fillRect(walls.get(i).x, walls.get(i).y, walls.get(i).width, walls.get(i).height);
			}
			for(int i=9;i<12;i++){//coins
				g.setColor(new Color(240, 200, 10));
				g.fillOval(coins.get(i).x, coins.get(i).y, coins.get(i).width, coins.get(i).height);
			}
		break;
		case 5: //
			for(int i=49; i<82;i++) {//walls
			    g.setColor(Color.darkGray);
				g.fillRect(walls.get(i).x, walls.get(i).y, walls.get(i).width, walls.get(i).height);
			}
			for(int i=12;i<15;i++){//coins
				g.setColor(new Color(240, 200, 10));
				g.fillOval(coins.get(i).x, coins.get(i).y, coins.get(i).width, coins.get(i).height);
			}
		break;
		case 11: //
			for(int i=82; i<89;i++) {//walls
			    g.setColor(Color.darkGray);
				g.fillRect(walls.get(i).x, walls.get(i).y, walls.get(i).width, walls.get(i).height);
			}
			for(int i=15;i<17;i++){//coins
				g.setColor(new Color(240, 200, 10));
				g.fillOval(coins.get(i).x, coins.get(i).y, coins.get(i).width, coins.get(i).height);
			}
		break;
		case 12: //
			for(int i=89; i<102;i++) {//walls
			    g.setColor(Color.darkGray);
				g.fillRect(walls.get(i).x, walls.get(i).y, walls.get(i).width, walls.get(i).height);
			}
			for(int i=17;i<21;i++){//coins
				g.setColor(new Color(240, 200, 10));
				g.fillOval(coins.get(i).x, coins.get(i).y, coins.get(i).width, coins.get(i).height);
			}
		break;
		case 13: //
			for(int i=102; i<121;i++) {//walls
			    g.setColor(Color.darkGray);
				g.fillRect(walls.get(i).x, walls.get(i).y, walls.get(i).width, walls.get(i).height);
			}
			g.setColor(new Color(240, 200, 10));
			g.fillOval(coins.get(21).x, coins.get(21).y, coins.get(21).width, coins.get(21).height);
		break;
		case 14: //
			for(int i=121; i<153;i++) {//walls
			    g.setColor(Color.darkGray);
				g.fillRect(walls.get(i).x, walls.get(i).y, walls.get(i).width, walls.get(i).height);
			}
			for(int i=22;i<25;i++){//coins
				g.setColor(new Color(240, 200, 10));
				g.fillOval(coins.get(i).x, coins.get(i).y, coins.get(i).width, coins.get(i).height);
			}
		break;
		case 15: //
			for(int i=153; i<185;i++) {//walls
			    g.setColor(Color.darkGray);
				g.fillRect(walls.get(i).x, walls.get(i).y, walls.get(i).width, walls.get(i).height);
			}
			for(int i=25;i<28;i++){//coins
				g.setColor(new Color(240, 200, 10));
				g.fillOval(coins.get(i).x, coins.get(i).y, coins.get(i).width, coins.get(i).height);
			}
		break;
		case 21: //
			for(int i=185; i<190;i++) {//walls
			    g.setColor(Color.darkGray);
				g.fillRect(walls.get(i).x, walls.get(i).y, walls.get(i).width, walls.get(i).height);
			}
		    g.setColor(dc);
			int[] xpoints= {dhb.x, dhb.x+dhb.width/2, dhb.x+dhb.width, dhb.x+dhb.width-dhb.width/4, dhb.x+dhb.width/4};
			int[] ypoints= {dhb.y+dhb.height/4, dhb.y+dhb.height, dhb.y+dhb.height/4, dhb.y, dhb.y};
			g.fillPolygon(xpoints, ypoints, xpoints.length);
			if(player.intersects(dhb)) {
				g.setColor(Color.cyan);
			    g.setFont(new Font("Times New Roman", Font.BOLD, 100));
				g.drawString("YOU WON!", w/2-250, 300);
			}
		break;
		case 22: //
			for(int i=190; i<202;i++) {//walls
			    g.setColor(Color.darkGray);				
			    g.fillRect(walls.get(i).x, walls.get(i).y, walls.get(i).width, walls.get(i).height);
			}
			for(int i=28;i<31;i++){//coins
				g.setColor(new Color(240, 200, 10));
				g.fillOval(coins.get(i).x, coins.get(i).y, coins.get(i).width, coins.get(i).height);
			}
		break;
		case 23: //
			for(int i=202; i<212;i++) {//walls
			    g.setColor(Color.darkGray);
				g.fillRect(walls.get(i).x, walls.get(i).y, walls.get(i).width, walls.get(i).height);
			}
			for(int i=31;i<36;i++){//coins
				g.setColor(new Color(240, 200, 10));
				g.fillOval(coins.get(i).x, coins.get(i).y, coins.get(i).width, coins.get(i).height);
			}
		break;
		case 24: //
			for(int i=212; i<245;i++) {//walls
			    g.setColor(Color.darkGray);
				g.fillRect(walls.get(i).x, walls.get(i).y, walls.get(i).width, walls.get(i).height);
			}
			for(int i=36;i<39;i++){//coins
				g.setColor(new Color(240, 200, 10));
				g.fillOval(coins.get(i).x, coins.get(i).y, coins.get(i).width, coins.get(i).height);
			}
		break;
		case 25: //
			for(int i=245; i<278;i++) {//walls
			    g.setColor(Color.darkGray);
				g.fillRect(walls.get(i).x, walls.get(i).y, walls.get(i).width, walls.get(i).height);
			}
			for(int i=39;i<42;i++){//coins
				g.setColor(new Color(240, 200, 10));
				g.fillOval(coins.get(i).x, coins.get(i).y, coins.get(i).width, coins.get(i).height);
			}
		break;
		}
		//coin score
		g.setColor(new Color(240, 200, 10));
	    g.setFont(new Font("Times New Roman", Font.BOLD, 25));
		g.drawString("Coins: "+score, 50, 50);
	}
	
	private class AL implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			update();
			//System.out.println(walls.size());
			wallCollider(room);
		}
	}
	
	//algorithm comparing the player's location with any wall of the room (parameter) to check if they intersect
	private void wallCollider(int r) {
		switch (r) {
		case 0:
			//wall colllider (room 0)
			if(py<=200||py>=h-200-boxWH)//right
				if(px>=w-100-boxWH)
					px=w-100-boxWH;
			if(px<=100)//left
		    	px=100;
		    if(py>=h-100-boxWH)//bottom
		    	py=h-100-boxWH;
		    if(py<=100)//top
		    	py=100;
		  //coin collect
		    if(player.intersects(coin)) {
				score++;
				coin.x=-100;
		    }
		break;
		case 1: 
			//wall colllider (room 1)
			if(py<=200||py>=h-200-boxWH)//right
				if(px>=w-100-boxWH)
					px=w-100-boxWH;
			if(px<=100)//left
		    	px=100;
		    if(px<=500||px>=w-500-boxWH)//bottom
		    	if(py>=h-100-boxWH)
		    		py=h-100-boxWH;
		    if(py<=100)//top
		    	py=100;
			//middle wall
			//right
			if(player.intersectsLine(wallr1.x, wallr1.y, wallr1.x, wallr1.y+wallr1.height)) {
				px=wallr1.x-boxWH;
			}
			//top
			else if(player.intersectsLine(wallr1.x, wallr1.y, wallr1.x+wallr1.width, wallr1.y)) {
				py=wallr1.y-boxWH;
			}
			//left
			else if(player.intersectsLine(wallr1.x+wallr1.width, wallr1.y, wallr1.x+wallr1.width, wallr1.y+wallr1.height)) {
				px=wallr1.x+wallr1.width;
			}
			//bottom
			else if(player.intersectsLine(wallr1.x, wallr1.y+wallr1.height, wallr1.x+wallr1.width, wallr1.y+wallr1.height)) {
				py=wallr1.y+wallr1.height;
			}
			
			//coin collect
			for(int i=1;i<3;i++) {
				if(player.intersects(coins.get(i))) {
					score++;
					coins.get(i).x=-100;
				}
			}
		break;
		case 2:
			//wall collider (room 2)
			if(py<=100)//top
				py=100;
			if(py>=h-boxWH-100)//bottom
				py=h-boxWH-100;
			for(int i=0;i<4;i++) {
				//left
				if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x-player.width;
				}
				//top
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y)) {
					py=walls.get(i).y-player.height;
				}
				//right
				else if(player.intersectsLine(walls.get(i).x+walls.get(i).width, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x+walls.get(i).width;
				}
				//bottom
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y+walls.get(i).height, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					py=walls.get(i).y+walls.get(i).height;
				}
			}
			for(int i=3;i<5;i++) {
				if(player.intersects(coins.get(i))) {
					score++;
					coins.get(i).x=-100;
				}
			}
			player=new Rectangle(px, py, boxWH, boxWH);
			repaint();
		break;
		case 3:
			//wall collider (room 3)
			if(py<=100)//top
				py=100;
			if(px>=w-boxWH-100)//right
				px=w-boxWH-100;
			if(px<=w-boxWH-200)//bottom
				if(py>=h-boxWH-100)
					py=h-boxWH-100;
			if(py<=300)//left
				if(px<=100)
					px=100;
			for(int i=4;i<16;i++) {
				//left
				if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x-player.width;
				}
				//top
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y)) {
					py=walls.get(i).y-player.height;
				}
				//right
				else if(player.intersectsLine(walls.get(i).x+walls.get(i).width, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x+walls.get(i).width;
				}
				//bottom
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y+walls.get(i).height, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					py=walls.get(i).y+walls.get(i).height;
				}
			}
			for(int i=5;i<9;i++) {
				if(player.intersects(coins.get(i))) {
					score++;
					coins.get(i).x=-100;
				}
			}
			player=new Rectangle(px, py, boxWH, boxWH);
			repaint();
		break;
		case 4:
			for(int i=16;i<49;i++) {
				//left
				if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x-player.width;
				}
				//top
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y)) {
					py=walls.get(i).y-player.height;
				}
				//right
				else if(player.intersectsLine(walls.get(i).x+walls.get(i).width, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x+walls.get(i).width;
				}
				//bottom
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y+walls.get(i).height, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					py=walls.get(i).y+walls.get(i).height;
				}
			}
			for(int i=9;i<12;i++) {
				if(player.intersects(coins.get(i))) {
					score++;
					coins.get(i).x=-100;
				}
			}
			player=new Rectangle(px, py, boxWH, boxWH);
			repaint();
		break;
		case 5:
			for(int i=49;i<82;i++) {
				//left
				if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x-player.width;
				}
				//top
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y)) {
					py=walls.get(i).y-player.height;
				}
				//right
				else if(player.intersectsLine(walls.get(i).x+walls.get(i).width, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x+walls.get(i).width;
				}
				//bottom
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y+walls.get(i).height, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					py=walls.get(i).y+walls.get(i).height;
				}
			}
			for(int i=12;i<15;i++) {
				if(player.intersects(coins.get(i))) {
					score++;
					coins.get(i).x=-100;
				}
			}
			player=new Rectangle(px, py, boxWH, boxWH);
			repaint();
		break;
		case 11:
			for(int i=82;i<89;i++) {
				//left
				if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x-player.width;
				}
				//top
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y)) {
					py=walls.get(i).y-player.height;
				}
				//right
				else if(player.intersectsLine(walls.get(i).x+walls.get(i).width, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x+walls.get(i).width;
				}
				//bottom
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y+walls.get(i).height, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					py=walls.get(i).y+walls.get(i).height;
				}
			}
			for(int i=15;i<17;i++) {
				if(player.intersects(coins.get(i))) {
					score++;
					coins.get(i).x=-100;
				}
			}
			player=new Rectangle(px, py, boxWH, boxWH);
			repaint();
		break;
		case 12:
			for(int i=89;i<102;i++) {
				//left
				if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x-player.width;
				}
				//top
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y)) {
					py=walls.get(i).y-player.height;
				}
				//right
				else if(player.intersectsLine(walls.get(i).x+walls.get(i).width, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x+walls.get(i).width;
				}
				//bottom
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y+walls.get(i).height, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					py=walls.get(i).y+walls.get(i).height;
				}
			}
			for(int i=17;i<21;i++) {
				if(player.intersects(coins.get(i))) {
					score++;
					coins.get(i).x=-100;
				}
			}
			player=new Rectangle(px, py, boxWH, boxWH);
			repaint();
		break;
		case 13:
			for(int i=102;i<121;i++) {
				//left
				if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x-player.width;
				}
				//top
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y)) {
					py=walls.get(i).y-player.height;
				}
				//right
				else if(player.intersectsLine(walls.get(i).x+walls.get(i).width, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x+walls.get(i).width;
				}
				//bottom
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y+walls.get(i).height, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					py=walls.get(i).y+walls.get(i).height;
				}
			}
			if(player.intersects(coins.get(21))) {
					score++;
					coins.get(21).x=-100;
			}
			player=new Rectangle(px, py, boxWH, boxWH);
			repaint();
		break;
		case 14:
			for(int i=121;i<153;i++) {
				//left
				if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x-player.width;
				}
				//top
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y)) {
					py=walls.get(i).y-player.height;
				}
				//right
				else if(player.intersectsLine(walls.get(i).x+walls.get(i).width, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x+walls.get(i).width;
				}
				//bottom
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y+walls.get(i).height, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					py=walls.get(i).y+walls.get(i).height;
				}
			}
			for(int i=22;i<25;i++) {
				if(player.intersects(coins.get(i))) {
					score++;
					coins.get(i).x=-100;
				}
			}
			player=new Rectangle(px, py, boxWH, boxWH);
			repaint();
		break;
		case 15:
			for(int i=153;i<185;i++) {
				//left
				if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x-player.width;
				}
				//top
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y)) {
					py=walls.get(i).y-player.height;
				}
				//right
				else if(player.intersectsLine(walls.get(i).x+walls.get(i).width, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x+walls.get(i).width;
				}
				//bottom
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y+walls.get(i).height, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					py=walls.get(i).y+walls.get(i).height;
				}
			}
			for(int i=25;i<28;i++) {
				if(player.intersects(coins.get(i))) {
					score++;
					coins.get(i).x=-100;
				}
			}
			player=new Rectangle(px, py, boxWH, boxWH);
			repaint();
		break;
		case 21:
			for(int i=185;i<190;i++) {
				//left
				if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x-player.width;
				}
				//top
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y)) {
					py=walls.get(i).y-player.height;
				}
				//right
				else if(player.intersectsLine(walls.get(i).x+walls.get(i).width, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x+walls.get(i).width;
				}
				//bottom
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y+walls.get(i).height, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					py=walls.get(i).y+walls.get(i).height;
				}
			}
			if(player.intersects(dhb)) {
				dc=new Color(50, 100, 0);
				px=dhb.x-10;
				py=dhb.y-10;
			}
			player=new Rectangle(px, py, boxWH, boxWH);
			repaint();
		break;
		case 22:
			for(int i=190;i<202;i++) {
				//left
				if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x-player.width;
				}
				//top
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y)) {
					py=walls.get(i).y-player.height;
				}
				//right
				else if(player.intersectsLine(walls.get(i).x+walls.get(i).width, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x+walls.get(i).width;
				}
				//bottom
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y+walls.get(i).height, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					py=walls.get(i).y+walls.get(i).height;
				}
			}
			for(int i=28;i<31;i++) {
				if(player.intersects(coins.get(i))) {
					score++;
					coins.get(i).x=-100;
				}
			}
			player=new Rectangle(px, py, boxWH, boxWH);
			repaint();
		break;
		case 23:
			for(int i=202;i<212;i++) {
				//left
				if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x-player.width;
				}
				//top
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y)) {
					py=walls.get(i).y-player.height;
				}
				//right
				else if(player.intersectsLine(walls.get(i).x+walls.get(i).width, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x+walls.get(i).width;
				}
				//bottom
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y+walls.get(i).height, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					py=walls.get(i).y+walls.get(i).height;
				}
			}
			for(int i=31;i<36;i++) {
				if(player.intersects(coins.get(i))) {
					score++;
					coins.get(i).x=-100;
				}
			}
			player=new Rectangle(px, py, boxWH, boxWH);
			repaint();
		break;
		case 24:
			for(int i=212;i<245;i++) {
				//left
				if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x-player.width;
				}
				//top
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y)) {
					py=walls.get(i).y-player.height;
				}
				//right
				else if(player.intersectsLine(walls.get(i).x+walls.get(i).width, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x+walls.get(i).width;
				}
				//bottom
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y+walls.get(i).height, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					py=walls.get(i).y+walls.get(i).height;
				}
			}
			for(int i=36;i<39;i++) {
				if(player.intersects(coins.get(i))) {
					score++;
					coins.get(i).x=-100;
				}
			}
			player=new Rectangle(px, py, boxWH, boxWH);
			repaint();
		break;
		case 25:
			for(int i=245;i<278;i++) {
				//left
				if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x-player.width;
				}
				//top
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y)) {
					py=walls.get(i).y-player.height;
				}
				//right
				else if(player.intersectsLine(walls.get(i).x+walls.get(i).width, walls.get(i).y, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					px=walls.get(i).x+walls.get(i).width;
				}
				//bottom
				else if(player.intersectsLine(walls.get(i).x, walls.get(i).y+walls.get(i).height, walls.get(i).x+walls.get(i).width, walls.get(i).y+walls.get(i).height)) {
					py=walls.get(i).y+walls.get(i).height;
				}
			}
			for(int i=39;i<coins.size();i++) {
				if(player.intersects(coins.get(i))) {
					score++;
					coins.get(i).x=-100;
				}
			}
			player=new Rectangle(px, py, boxWH, boxWH);
			repaint();
		break;
		}
	}
	
	//updates directional speed via the keylistener 
	private void update() 
	{
	    vX = 0;
	    vY = 0;
	    if(down) 
	    	vY = SPEED;
	    if(up) 
	    	vY = -SPEED;
	    if(left) 
	    	vX = -SPEED;
	    if(right) 
	    	vX = SPEED;
	    
	  //border collider (teleporter)
	    if(px>=w-50-boxWH) {//right
	    	px = 100;
	    	room++;
	    }	
	    if(px<=50) {//left
	    	px = w-100-boxWH;
	    	room--;
		}	
	    if(py>=h-50-boxWH) {//down
	    	py = 100;
	    	room=room+10;
	    }
	    if(py<=50) {//up
	    	py = h-100-boxWH;
	    	room=room-10;
		}
	    px+=vX;
	    py+=vY;

	    player=new Rectangle(px, py, boxWH, boxWH);
	    repaint();
	}
	
	private class KL implements KeyListener
	{
		public void keyTyped(KeyEvent e){}
		public void keyPressed(KeyEvent e)
		{
			if(e.getKeyCode() == KeyEvent.VK_DOWN)
				down = true; 
			if(e.getKeyCode() == KeyEvent.VK_UP)
				up = true; 
			if(e.getKeyCode() == KeyEvent.VK_LEFT)
				left = true;
			if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				right = true;		
		}
		public void keyReleased(KeyEvent e)
		{
			if(e.getKeyCode() == KeyEvent.VK_DOWN)
				down = false; 
			if(e.getKeyCode() == KeyEvent.VK_UP)
				up = false; 
			if(e.getKeyCode() == KeyEvent.VK_LEFT)
				left = false;
			if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				right = false;
		}
		
	}
}

/*	ACKNOWLEDGEMENTS
 *	
 *	Both program's main classes (GenesisFrame.java and GenesisGraphics.java) were developed independently by student.
 *
 *	Methods for graphics and events imported from Java Delopment Kit Version 20's libraries. 
 *	
 */

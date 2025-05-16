package genesis;

import javax.swing.JFrame;

public class GenesisFrame
{

	public static void main(String[] args)
	{
		int w = 1400;
		int h = 700;
		
		JFrame frame = new JFrame("Genesis");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new GenesisGraphics(w,h));
		frame.pack();
		frame.setVisible(true);
	}
}

/*	DESCRIPTION
 *	
 *	Genesis is an application with the purpose of entertainment, give the player (alias the user) an ability to go through a maze and collect coins along their way.
 *	The game ends once the player finds the room where the diamon is and collects it. The program will keep running after winning until the application is closed.
 *
 *	Acknowledgements at the bottom of GenesisGraphics.java
 *	
 */

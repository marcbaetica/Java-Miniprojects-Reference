//this is a simple Java GUI using JFrame
//note if you read documentation JFrame is not thread safe if you are planning on using this for a multithreaded application

import javax.swing.JFrame; //for window frame

import java.awt.BorderLayout;
import java.awt.Color; //for choosing colors
import java.awt.Graphics; //for drawing
import javax.swing.JLabel; //for the label
import javax.swing.JButton; //for the button
import javax.swing.JPanel; //for the panel


public class simpleGUI extends JFrame {

	JLabel jl; //JLabel is the GUI version of System.out.println()
	JButton jb;
	JPanel jp, jp2;
	
	public simpleGUI () { //constructor
		
		setTitle("GUI"); //appears at the top of the window
 		setSize(960,960); //size of window on run
		setResizable(false); //blocks the user from being able to resize the window
 		setVisible(true); //for window to appear
 		setDefaultCloseOperation(EXIT_ON_CLOSE); //for terminating the application when clicking close rather than just hiding it
 		
 		//comment out from here to the end of the constructor if you want to see the rectangles, circles and lines without being overlapped by the JFrame and JButton  
 		jl = new JLabel("This is a message.");
 		jb = new JButton("Press me!");
 		jp = new JPanel();
 		jp2 = new JPanel();
 		
 		//add(jl); //adds the JLabel to the JFrame
 		//add(jb); //this looks wierd without the JPanel because the whole window will be taken over by a gigantic button
 		jp.add(jl); //this looks wierd without the JPanel because the whole window will be taken by a button
 		jp2.add(jb); //second panel gets the button
 		
 		add(jp); //add the panel to the JFrame/window
 		add(jp2, BorderLayout.SOUTH); ////add the second panel to the JFrame/window and put it on the botton of the JFrame
 		
	}
	
	public void paint(Graphics g){ //instantiates an object of type Graphics and pass into a method that NEEDS TO be called paint
	
		//drawing two rectangles
		g.setColor(Color.RED);
		g.drawRect(480, 480, 300, 100);
		g.setColor(Color.BLUE);
		g.fillRect(600, 740, 200, 100);
		
		//drawing ovals and circles
		g.setColor(Color.GREEN);
		g.drawOval(100, 450, 200, 200);
		g.setColor(Color.BLACK);
		g.drawOval(300, 680, 100, 200);
		
		//for drawing lines
		g.drawLine(0, 400, 960, 400);
		
		
		
	}
		
	public static void main (String[] args) {
		
		simpleGUI gui = new simpleGUI(); //instantiate a simpleGUI. We don't really need a constructor.. we can call up all the methoeds manually (for example gui.setTitle("GUI")) but that would be time consuming if multiple frames are to be built
		gui.paint(null); //do not need to pass anything in because we already set the variable g to draw rectangles into the paint method
		
	}
	
}

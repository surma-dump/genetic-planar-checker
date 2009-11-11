import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.*; 
import java.awt.image.*; 
import java.awt.event.*; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class gpc extends PApplet {
	private Graph g ;

	public void setupGraph() {
		g = new Graph() ;
		Point p[] = {new Point(10, 10), 
				new Point(50,10),
				new Point(10,50),
				new Point(50,50)} ;
		g.addPoints(p) ;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if (i!=j) {
					g.connect(p[i],p[j]) ;
				}
			}
		}

	}

	public void setup() {
		size(300,300) ;
		background(0) ;
		frameRate(25) ;
		setupGraph() ;
	}

	public void drawPoint(Point p, boolean act) {
		if(act) {
			noFill() ;
			stroke(130,0,0) ;
			ellipse(p.x,p.y,20,20) ;
			fill(200,0,0) ;
			stroke(200,0,0) ;
			ellipse(p.x,p.y,6,6) ;
		}
		else {
			noFill() ;
			stroke(130) ;
			ellipse(p.x,p.y,20,20) ;
			fill(200) ;
			stroke(200) ;
			ellipse(p.x,p.y,6,6) ;
		}
	}

	public void draw() {
		for(Point p : g.getPoints()) {
			drawPoint(p,false) ;
			for(Point k : g.getConnections(p)) {
				stroke(80) ;
				line(p.x, p.y, k.x, k.y) ;
			}
		}
	}

	public static void main(String args[]) {
		PApplet.main(new String[] { "--bgcolor=#000000", "gpc" });
	}
}

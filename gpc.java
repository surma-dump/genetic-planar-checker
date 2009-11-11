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
	private Vector<Point> p ;
	private Point act ;
	public void setup() {
		p = new Vector<Point>() ;
		size(300,300) ;
		background(0) ;
		frameRate(25) ;
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
		fill(0) ;
		stroke(0) ;
		rect(0,0,width,height) ;
		for(Point _p : p) {
			drawPoint(_p,(_p.x-mouseX)*(_p.x-mouseX) + (_p.y-mouseY)*(_p.y-mouseY) <= 100) ;
		}
	}

	public void mouseDragged() {
		if (act != null) {
			act.x = mouseX ;
			act.y = mouseY ;
		}
	}

//	public void mouseDragged() {
//		if (act != null) {
//			fill(0) ;
//			stroke(0) ;
//			rect(act.x-10,act.y-10,20,20) ;
//			act.x = mouseX ;
//			act.y = mouseY ;
//			drawPoint(act, true) ;
//		}
//	}

	public void mousePressed() {
		for(Point _p : p) {
			if((_p.x-mouseX)*(_p.x-mouseX) + (_p.y-mouseY)*(_p.y-mouseY) <= 100) {
				act = _p ;
			}
		}
		if(act == null) {
			p.add(new Point(mouseX,mouseY)) ;
		}
	}

	public void mouseReleased() {
		act = null ;
	}

	public static void main(String args[]) {
		PApplet.main(new String[] { "--bgcolor=#000000", "gpc" });
	}
}

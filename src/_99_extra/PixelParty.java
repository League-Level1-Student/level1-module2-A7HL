package _99_extra;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Create a PixelRunner class and add a main method to it that creates a PixelParty.
 * Have your pixel party set its color, draw a few rectangles/circles/triangles.
 * Finally, have your PixelParty save the image, and display the image.
 */


public class PixelParty {
	public static int BLACK = getColor(255, 0, 0, 0);
	public int currentColor = BLACK;
	
	private BufferedImage img;
	private static int width = 512;
	private static int height = 512;
	private Random gen = new Random();
	private String fileName = "PixelParty";
	private static String fileType = "png";

	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel();
	
	private boolean isRainbow = false;
	
	public PixelParty() {
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	}
	public void drawRectangle(int x, int y, int width, int height) {
		System.out.println("Drawing a rectangle at (" + x + "," + y + ") with width " + width + " and height " + height);
		drawLine(x, y, x+width, y);
		drawLine(x, y, x, y+height);
		drawLine(x+width, y, x+width, y+height);
		drawLine(x, y+height, x+width, y+height);
	}
	
	public void drawCircle(int x, int y, int r) {
		System.out.println("Drawing a circle at (" + x + "," + y + ") with radius " + r);
		for(int x2 = 0; x2 < width; x2++) {
			for(int y2 = 0; y2 < height; y2++) {
				if(getDistance(x, y, x2, y2) == r) {
					if(isRainbow) {
						img.setRGB(x2, y2, getRandomColor());
					}
					else {
						img.setRGB(x2, y2, currentColor);
					}
				}
			}
		}
	}
	
	public void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		System.out.println("Drawing a triangle at points (" + x1 + "," + y1 + "), (" + x2 + "," + y2 + "), (" + x3 + "," + y3 + ")");
		drawLine(x1, y1, x2, y2);
		drawLine(x1, y1, x3, y3);
		drawLine(x2, y2, x3, y3);
	}
	
	public void drawLine(double x1, double y1, double x2, double y2) {
		int dist = getDistance(x1, y1, x2, y2);
		double xStep = (x2-x1)/dist;
		double yStep = (y2-y1)/dist;
		for(int i = 0; i < dist; i++) {
			if((int)(x1+(xStep*i)) < width && (int)(y1+(yStep*i)) < height) {
				if(isRainbow) {
					img.setRGB((int)(x1+(xStep*i)), (int)(y1+(yStep*i)), getRandomColor());
				}
				else {
					img.setRGB((int)(x1+(xStep*i)), (int)(y1+(yStep*i)), currentColor);
				}
			}
		}
	}
	
	public void wait(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public int getRandomColor() {
		int r = gen.nextInt(256);
		int g = gen.nextInt(256);
		int b = gen.nextInt(256);

		return getColor(255, r, g, b);
	}
	
	public void displayImage() {
		System.out.println("Displaying image in frame...");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		label = (JLabel) createLabel(fileName + "." + fileType);
		panel.add(label);
		frame.pack();
	}

	public void saveImage() {
		String fn = fileName + "." + fileType;
		try {
			File file = new File( "src/_99_extra/" + fn);
			System.out.println("Saving image to "+getLocalPath()+fn);
			ImageIO.write(img, fileType, file);
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
	}
	
	public void setColor(int r, int g, int b) {
		System.out.println("Setting color to (" + r + "," + g + "," + b + ")");
		currentColor = getColor(255, r, g, b);
	}
	
	public void setRainbow(boolean b) {
		isRainbow = b;
	}

	private int getDistance(double x1, double y1, double x2, double y2) {
		double distance = Math.sqrt(Math.pow((x2-x1), 2)+ Math.pow((y2-y1), 2));
		return (int) Math.abs(distance);
	}
	
	private static int getColor(int a, int r, int g, int b) {
		int rgb = ((int)a << 24) | ((int)r << 16) | ((int)g << 8) | (int)b;
		return rgb;
	}
	
	private JLabel createLabel(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		if (imageURL == null) {
			System.err.println("Could not find image " + fileName);
			return new JLabel();
		}
		Icon icon = new ImageIcon(imageURL);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}
	
	private String getLocalPath() {
		URL url = getClass().getResource("PixelParty.png");
		return url.toString().replace("PixelParty.png", "").replace("file:/", "").replace("bin", "src");
	}
}

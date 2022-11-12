package _99_extra;

public class PixelRunner {
public static void main(String[] args) {
	PixelParty party = new PixelParty();
	party.setColor(0, 255, 0);
	party.drawCircle(100, 240, 30);
	party.drawLine(25, 58, 300, 420);
	party.drawRectangle(412, 245, 98, 86);
	party.drawTriangle(2, 4, 8, 16, 32, 64);
	party.saveImage();
	party.displayImage();
}
}

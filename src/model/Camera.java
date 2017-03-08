package model;

public class Camera {
	
	public Vector Position = new Vector();
	
	private Vector ViewportSize;
	private double widthHalf;
	private double heightHalf;
	
	public double viewYOffset = 0.4d;
	
	public void setViewportSize(double width, double height) {
		ViewportSize = new Vector(width, height);
		
		widthHalf = width / 2d;
		heightHalf = height / 2d;
	}
	
	public Camera() {
		setViewportSize(1d,1d);
	}
	
	public void update(Game model) {
		if(model.Players.length > 0) {
			double y = 0;
			int n = 0;
			
			for(Player p : model.Players) {
				if(p.isAlive()) {
					y += p.Position.y;
					n++;
				}
			}
			
			if(n > 0) {
				this.Position.y = y - viewYOffset;
			}
		}
	}
	
	public double lowerBound() {
		return Position.y - heightHalf;
	}
	
	public double upperBound() {
		return Position.y + heightHalf;
	}
	
	public double leftBound() {
		return Position.x - widthHalf;
	}
	
	public double rightBound() {
		return Position.x + widthHalf;
	}
	
	public Vector getSize() {
		return ViewportSize;
	}
	
}
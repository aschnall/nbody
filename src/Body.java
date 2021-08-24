public class Body {
    
    public double px, py; //position
    public double vx, vy; //velocity
    public double m; //mass
    public String img; //image file
    
    public static final double G = 6.67e-11; //gravity constant
  
    
    /**
     * Constructor: This creates a new instance of a body object.
     */
    public Body(double mass, double posX, double posY, 
                double velX, double velY, String imageFile) {
        m = mass;
        px = posX;
        py = posY;
        vx = velX;
        vy = velY;
        img = imageFile;
    }
    
    /**
     * Description: returns a string representation of the body for the
     * purposes of printing. We will discuss toString methods in class.
     * 
     */
    public String toString() {
        return String.format("%12.5e %12.5e %12.5e %12.5e %12.5e %12s", 
                             m, px, py, vx, vy, img);
    }
    
    /**
     * Description: returns x distance from one body to another
     * 
     */
    public double distanceToX(Body other) {
       return other.px - px;
    }
    
    
    /**
     * Description: returns y distance from one body to another
     * 
     */
    public double distanceToY(Body other) {
    	return other.py - py;
    }
    
    /**
     * Description: calculates and returns total distance form one body
     * to another using the x and y distances
     */
    public double distanceTo(Body other) {
        return Math.sqrt((distanceToX(other)*distanceToX(other) + distanceToY(other)*distanceToY(other)));
    }

    /**
     * Description: calculates and returns the force exerted by one body on another
     * 
     */
    public double force(Body other) {
    	return (G*m*other.m)/(distanceTo(other)*distanceTo(other));
    }
    
    /**
     * Description: returns x force exerted from one body to another
     * 
     */
    public double forceX(Body other) {
    	return (force(other) * distanceToX(other)) / distanceTo(other);
    }
    
    /**
     * Description: returns y force exerted from one body to another
     * 
     */
    public double forceY(Body other) {
    	return (force(other) * distanceToY(other)) / distanceTo(other);
    }

    /**
     * Description: draws the bodies on the screen
     * 
     */
    public void draw() {
        PennDraw.picture(px, py, img);
    }
    
    /**
     * Description: updates positions of bodies
     * 
     */
    public void move(double timeStep) {
        px += timeStep*vx;
        py += timeStep*vy;
    }
    
    /**
     * Description: updates velocities of the bodies using the
     * time step and force exerted
     */
    public void getAffectedBy(Body other, double timeStep) {
        vx += timeStep*(forceX(other)/m);
        vy += timeStep*(forceY(other)/m);
    }    
}

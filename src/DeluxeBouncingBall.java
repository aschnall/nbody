/*************************************************************************
  *
  *  Implementation of a 2-d bouncing ball in the box from (-1, -1) to (1, 1).
  *
  *  % java DeluxeBouncingBall
  *
  *************************************************************************/

public class DeluxeBouncingBall { 
    public static void main(String[] args) {
        double rx = .480, ry = .860;     // position
        double vx = .015, vy = .023;     // velocity
        // a hack since "earth.gif" is in pixels
        double radius = .03;             
        
        // set the scale of the coordinate system
        PennDraw.setXscale(-1.0, 1.0);
        PennDraw.setYscale(-1.0, 1.0);
        
        // main animation loop
        while (true) { 
            if (Math.abs(rx + vx) + radius > 1.0) { 
                vx = -vx;     
            }
            if (Math.abs(ry + vy) + radius > 1.0) { 
                vy = -vy;                 
            }
            rx = rx + vx; 
            ry = ry + vy; 
            PennDraw.filledSquare(0.0, 0.0, 1.0);
            PennDraw.picture(rx, ry, "earth.gif");
            PennDraw.show(20); 
        } 
    } 
} 

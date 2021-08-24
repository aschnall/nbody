
public class NBodyObj {

	public static void main(String[] args) {
		Space s = new Space(args[2]);
		double simulationTime = Double.parseDouble(args[0]);
		double timeStep = Double.parseDouble(args[1]);
		double elapsedTime = 0.0;
		PennDraw.enableAnimation(30);
		while (elapsedTime < simulationTime) {
			s.simulate(timeStep);
			s.draw();
			PennDraw.advance();
			elapsedTime += timeStep;
		}
		PennDraw.disableAnimation();
	}

}

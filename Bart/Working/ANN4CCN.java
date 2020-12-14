import java.util.Arrays;
import java.util.ArrayList;

public class ANN4CCN{
	public static final double LEARNING_RATE = 0.2;
	public static double[] omega = new double[3];
	public static boolean convergence = false;

	public static void main(String[] args){
		int[] p1A = {1,6,9};
		int[] p2A = {1,1,8};
		int[] p3A = {1,-4,2};
		int[] p4A = {1,0,-2};
		int[] p5A = {1,-3,-4};
		int[] p6A = {1,7,2};

		Point p1 = new Point(1,p1A);
		Point p2 = new Point(1,p2A);
		Point p3 = new Point(1,p3A);
		Point p4 = new Point(0,p4A);
		Point p5 = new Point(0,p5A);
		Point p6 = new Point(0,p6A);

		ArrayList<Point> allPoints = new ArrayList<Point>();
		allPoints.add(p1);
		allPoints.add(p2);
		allPoints.add(p3);
		allPoints.add(p4);
		allPoints.add(p5);
		allPoints.add(p6);

		//Initializing omega with random values
		for(int i = 0; i<omega.length; i++){
			omega[i] = Math.random();
		}

		int iterations = 0;

		System.out.println();
		System.out.println("Original:");
		System.out.println("weight		1			2			3");
		System.out.println("value	" + omega[0] + "	" + omega[1] + "	" + omega[2]);
		System.out.println(omega[1] + "x + " + omega[2] + "y = " + (0 - omega[0]));

		while(!convergence){
			for(int i = 0; i < allPoints.size(); i++){
				Point p = allPoints.get(i);
				p.setOutput(dotProduct(omega, p.getVector()));
			}
			for(int i = 0; i < allPoints.size(); i++){
				Point p = allPoints.get(i);
				if(p.getTarget() != p.getOutput()){
					p.setClassified(false);
					update(omega, p);
				}
				else{
					p.setClassified(true);
				}
			}
			System.out.println();
			System.out.println("Iterations " + ++iterations + ":");
			System.out.println("weight		1			2			3");
			System.out.println("value	" + omega[0] + "	" + omega[1] + "	" + omega[2]);
			System.out.println(omega[1] + "x + " + omega[2] + "y = " + (0 - omega[0]));

			for(int i = 0; i < allPoints.size(); i++){
				Point p = allPoints.get(i);
				if(p.getClassified() == false){
					break;
				}
				if(i == allPoints.size()-1){
					convergence = true;
				}
			}

		}

		System.out.println();
		//System.out.println("Total Iterations: " + iterations);
		//System.out.println("Final weights: " + Arrays.toString(omega));
		//System.out.println();


	}

	public static void update(double[] omega, Point point){
		for(int i = 0; i<omega.length; i++){
			omega[i] = omega[i] + LEARNING_RATE * (point.getTarget() - point.getOutput()) * point.getVectorValue(i);
		}
	}

	public static double dotProduct(double[] omega, int[] pointVector){
		double total = 0;
		for(int i = 0; i<omega.length; i++){
			total += omega[i]*pointVector[i];
		}
		if (total <= 0){
			return 0;
		}
		return 1;
	}
}
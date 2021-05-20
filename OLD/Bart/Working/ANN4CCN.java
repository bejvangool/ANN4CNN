import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

////////
// INSTRUCTIONS:
// To run our code, all you have to do it compile and run. Right now it is set up to generate 100 points around the line y=x, and then run the perceptron 
// 1 time. It will then output the average results for the weights in the weight vector. These values can be edited in line 17 and 18.
// Furthermore, you can change the target line by editing the equations in lines 158, 167, and 174.
////////

public class ANN4CCN{
	public static final double LEARNING_RATE = 0.01;
	public static double[] omega = new double[3];
	public static boolean convergence = false;
	public static ArrayList<Point> allPoints = new ArrayList<>();
	public static int TARGET_VALUES = 100; //Amount of random points we are creating above/below a chosen line
	public static int runs = 1; //Amount of times the perceptron will run before outputting an average line

	public static void main(String[] args){
		
		//The original points used in question 1
		/*
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
		 */

		int iterations = 0;

		double w1Average = 0;
		double w2Average = 0;
		double w3Average = 0;

		for(int b = 0; b <= runs -1; b++) { //This loop runs the perceptron "runs" times
			convergence = false;
			allPoints.clear();
			iterations = 0;
			createValues(); //This creates our points, method found below

			//Initializing omega with random values
			for (int i = 0; i < omega.length; i++) {
				omega[i] = Math.random();
			}

			while (!convergence) { //Here we calculate the outputs for the current weights, and update the weights
				for (int i = 0; i < allPoints.size(); i++) {
					Point p = allPoints.get(i);
					p.setOutput(dotProduct(omega, p.getVector()));
				}
				for (int i = 0; i < allPoints.size(); i++) {
					Point p = allPoints.get(i);
					if (p.getTarget() != p.getOutput()) {
						p.setClassified(false);
						update(omega, p);
					} else {
						p.setClassified(true);
					}
				}
				iterations++;

				for (int i = 0; i < allPoints.size(); i++) { //If points are correctly classified we converge, otherwise we start over
					Point p = allPoints.get(i);
					if (p.getClassified() == false) {
						break;
					}
					if (i == allPoints.size() - 1) {
						convergence = true;
						System.out.println();
						System.out.println("Iterations: " + iterations);
						System.out.println("weight		1				2				 3");
						System.out.println("value      	" + omega[0] + "	        " + omega[1] + "              " + omega[2]);
						System.out.println(-omega[2] + "y = " + omega[1] + "x + " + omega[0]);
						System.out.println();
					}
				}
			}

			System.out.println();

			w1Average += omega[0];
			w2Average += omega[1];
			w3Average += omega[2];
		}

		//Print statement outputs the average weights and the average line the weights result in
		System.out.println("Average W1: " + w1Average/runs);
		System.out.println("Average W2: " + w2Average/runs);
		System.out.println("Average W3: " + w3Average/runs);
		System.out.println(-w3Average/runs + "y = " + w2Average/runs + "x + " + w1Average/runs);

	}

	/**
	 * This is the method to update the weights.
	 * @param omega
	 * @param point
	 */
	public static void update(double[] omega, Point point){
		for(int i = 0; i<omega.length; i++){
			omega[i] = omega[i] + LEARNING_RATE * (point.getTarget() - point.getOutput()) * point.getVectorValue(i);
		}
	}

	/**
	 * First we calculate the dot product between the weight vector and the input, then use the stepfunction to
	 * return either 0 or 1.
	 * @param omega
	 * @param pointVector
	 * @return
	 */
	public static int dotProduct(double[] omega, double[] pointVector){
		double total = 0;
		for(int i = 0; i<omega.length; i++){
			total += omega[i]*pointVector[i];
		}
		if (total <= 0){
			return 0;
		}
		return 1;
	}

	/**
	* Here we create "TARGET_VALUES" randomly generated points and assign them a target value of 1 or 0 depending on if 
	* they are above or below a predefined line. Right now it's set up for the line y=x.
	*/
	public static void createValues(){
		Random rnd = new Random();
		ArrayList<double[]> allVectors= new ArrayList<>();
		int aboveCount=0;
		int underCount=0;

		for (int i=0; i<TARGET_VALUES	; i++){

			while(allVectors.size()<TARGET_VALUES){

				double [] vector = {1, (Math.random() * (10 + 10 + 1) -10), (Math.random() * (10 + 10 + 1) -10)};
				if (allVectors.contains(vector)) { continue; }

				if(vector[2]< vector[1]){ //if the point is over the line
					if(aboveCount==TARGET_VALUES/2){continue;}

					allPoints.add(new Point(1,vector));
					allVectors.add(vector);
					aboveCount++;
					break;
				}

				else if (vector[2] > vector[1]){ //if the point is under the line
					if(underCount==TARGET_VALUES/2){continue;}
					allPoints.add(new Point(0,vector));
					allVectors.add(vector);
					underCount++;
					break;
				}
				else if(vector[2] == vector[1]){ //if the point is on the line
					continue;
				}
			}
		}
	}
}
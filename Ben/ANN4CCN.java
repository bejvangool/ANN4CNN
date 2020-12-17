import java.util.Arrays;
import java.util.ArrayList;
import java.util.*;

public class ANN4CCN{
	public static final double LEARNING_RATE = 0.0001;
	//public static int[] omega = new int[3];
	public static double[] omega = {Math.random(),Math.random(),Math.random()};
	public static boolean convergence = false;
	public static ArrayList<Point> allPoints = new ArrayList<>();
	public static int TARGET_VALUES=100;



	public static void main(String[] args){
		createValues();

		int iterations = 0;

		System.out.println(Arrays.toString(omega));

		for(int i = 0; i < allPoints.size(); i++){
			Point p = allPoints.get(i);
			p.setOutput(dotProduct(omega, p.getVector()));
			}


		for(int i = 0; i < allPoints.size(); i++){
			Point p = allPoints.get(i);
			if(p.getClassified() == false){
				break;
			}
			if(i == allPoints.size()-1){
				convergence = true;
			}
		}



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
		iterations++;

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
	System.out.println("Iterations: " + iterations);
	System.out.println("weight		1				2				 3");
	System.out.println("value      	" + omega[0] + "	        " + omega[1] + "              " + omega[2]);
	//System.out.println(omega[1] + "x + " + omega[2] + "y = " + (0 - omega[0]));
	System.out.println(-omega[2] + "y = " + omega[1] + "x + " + omega[0]);
	System.out.println();



	}

	public static void update(double[] omega, Point point){
		for(int i = 0; i<omega.length; i++){
			omega[i] = omega[i] + LEARNING_RATE * (point.getTarget() - point.getOutput()) * point.getVectorValue(i);
		}
		//System.out.println();
		//System.out.println("weight		1			2			3");
		//System.out.println("value       	" + omega[0] + "	          " + omega[1] + "              	" + omega[2]);
	}

	public static int dotProduct(double[] omega, double[] pointVector){
		int total = 0;
		for(int i = 0; i<omega.length; i++){
			total += omega[i]*pointVector[i];
		}
		if (total <= 0){
			return 0;
		}
		return 1;
	}


	public static void createValues(){
		Random rnd = new Random();
		ArrayList<double[]> allVectors= new ArrayList<>();
		int aboveCount=0;
		int underCount=0;
		//for (int j=0; j<omegaTemp.length ;j++) {
		/*	double [] omegaTemp = new double [omega.length];
		omegaTemp[j] = rnd.nextInt();
		}*/
		for (int i=0; i<TARGET_VALUES	; i++){

			while(allVectors.size()<TARGET_VALUES){

				double [] vector = {1, (Math.random() * (10 + 10 + 1) -10), (Math.random() * (10 + 10 + 1) -10)};
				if (allVectors.contains(vector)) { continue; }

				if(vector[2]< vector[1]){//if the point is over the line
					if(aboveCount==TARGET_VALUES/2){continue;}

					allPoints.add(new Point(1,vector));
					allVectors.add(vector);
					aboveCount++;
					System.out.println(Arrays.toString(vector) + "	  	1");
					break;
				}

				else if (vector[2] > vector[1]){
					if(underCount==TARGET_VALUES/2){continue;}
					allPoints.add(new Point(0,vector));
					allVectors.add(vector);
					underCount++;
					System.out.println(Arrays.toString(vector) + "	  	0");
					break;
				}
				else if(vector[2] == vector[1]){
					continue;
				}
			}

		}
	}
}

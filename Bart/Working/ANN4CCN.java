import java.uitl.Arrays;

public class ANN4CCN{
	public static final double learningRate = 0.2;

	public static void main(String[] args){
		int[] p1A = {1;6;9};
		int[] p2A = {1;1;8};
		int[] p3A = {1;-4;2};
		int[] p4A = {1;-1;-1};
		int[] p5A = {1;-3;-4};
		int[] p6A = {1;7;2};

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

		double[] omega = new double[2];
		for(int i = 0; i<omega.legnth; i++){
			omega[i] = Math.random();
		}
	}

	public double[] update(double[] omega, Point point, double output){
		for(int i = 0; i<omega.length; i++){
			omega[i] = omega[i] + learningRate * (point.getTarget() - point.getOutput()) * point.getVectorValue(i);
		}
		System.out.println(omega.toString());
	}

	public double dotProduct(double[] omega, int[] pointVector){
		double total = 0;
		for(int i = 0; i<omega.length; i++){
			total += omega[0]*point[0];
		}
		return total;
	}
}
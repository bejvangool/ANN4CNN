public class Point{
	int target = 0;
	int[] vector = new int[2];
	double output = 0;

	public Point(int target, int[] vector){
		this.target = target;
		this.vector = vector;
	}

	public int getTarget(){
		return target;
	}

	public void setOutput(double output){
		this.output = output;
	}

	public double getOutput(){
		return output;
	}

	public int[] getVector(){
		return vector;
	}
	public int getVectorValue(int x){
		return vector[x];
	}
}
public class Point{
	int target;
	double[] vector;
	int output = 0;
	boolean classified = false;


	public Point(int target, double[] vector){
		this.target = target;
		this.vector = vector;
	}

	public int getTarget(){
		return target;
	}

	public void setOutput(int output){
		this.output = output;
	}

	public int getOutput(){
		return output;
	}

	public double[] getVector(){
		return vector;
	}
	public double getVectorValue(int x){
		return vector[x];
	}

	public boolean getClassified(){
		return classified;
	}
	public void setClassified(boolean x){
		classified = x;
	}
}

public class Point{
	int target;
	int[] vector;
	double output = 0;
	boolean classified = false;


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

	public boolean getClassified(){
		return classified;
	}
	public void setClassified(boolean x){
		classified = x;
	}
}
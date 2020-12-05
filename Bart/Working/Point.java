public class Point{
	int d = 0;
	int[] vector = new int[2];

	public Point(int d, int[] vector){
		this.d = d;
		this.vector = vector;
	}

	public int getD(){
		return d;
	}

	public int[] getVector(){
		return vector;
	}
	public int getVectorValue(int x){
		return vector[x];
	}
}
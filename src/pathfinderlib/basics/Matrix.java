package pathfinderlib.basics;

import java.io.Serializable;

public class Matrix<type extends Object> implements Serializable {
	private static final long serialVersionUID = -5784707448900861521L;
	private type[][] matrix;
	private int width;
	private int height;

	@SuppressWarnings("unchecked")
	public Matrix(int w, int h) {
		// TODO Auto-generated constructor stub
		matrix = (type[][]) new Object[w][h];
		for (int i=0;i<matrix.length;i++) {
			for (int k=0;k<matrix[i].length;k++) {
				matrix[i][k] = null;
			}
		}
		width = w;
		height = h;
	}
	
	
	public void set(int x, int y, type value) {
		matrix[x][y] = value;
	}
	
	public type get(int x, int y) {
		return matrix[x][y];
	}
	
	public Matrix<type> submatrix(int w, int h) {
		Matrix<type> mat = new Matrix<type>(w,h);
		for (int i=0;i<Math.min(width, mat.width);i++) {
			for (int k=0;k<Math.min(height, mat.height);k++) {
				mat.set(i, k, get(i, k));
			}
		}
		return mat;
	}
	
	public int[] size() {
		int[] s = {width, height};
		return s;
	}


	public int getWidth() {
		return width;
	}


	public int getHeight() {
		return height;
	}

}

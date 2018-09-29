package pathfinderlib.basics;

import java.io.Serializable;

/**
 * Matrix class to manage 2D arrays easily
 * @author ttgc
 * @version 1.0
 * @param <type> The type for each items in the matrix
 * @serial
 */
public class Matrix<type extends Object> implements Serializable {
	private static final long serialVersionUID = -5784707448900861521L;
	private type[][] matrix;
	private int width;
	private int height;

	/**
	 * Create a Matrix (Constructor)
	 * @param w the width of the matrix
	 * @param h the height of the matrix
	 */
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
	
	/**
	 * Set the value at position (x;y) in the Matrix
	 * @param x the column position
	 * @param y the line position
	 * @param value the value that will be inserted at (x;y) position
	 */
	public void set(int x, int y, type value) {
		matrix[x][y] = value;
	}
	
	/**
	 * Get the value at position (x;y)
	 * @param x the column position
	 * @param y the line position
	 * @return the value at position (x;y)
	 */
	public type get(int x, int y) {
		return matrix[x][y];
	}
	
	/**
	 * Get a submatrix from your matrix
	 * @param w the width of the submatrix (need to be lower than or equal to the width of the matrix)
	 * @param h the height of the submatrix (need to be lower than or equal to the width of the matrix)
	 * @return the submatrix generated
	 */
	public Matrix<type> submatrix(int w, int h) {
		Matrix<type> mat = new Matrix<type>(w,h);
		for (int i=0;i<Math.min(width, mat.width);i++) {
			for (int k=0;k<Math.min(height, mat.height);k++) {
				mat.set(i, k, get(i, k));
			}
		}
		return mat;
	}
	
	/**
	 * Get the size of your matrix
	 * @return the size as an integer array of 2 values as following : {width, height}
	 */
	public int[] size() {
		int[] s = {width, height};
		return s;
	}

	/**
	 * @return width of the matrix
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return height of the matrix
	 */
	public int getHeight() {
		return height;
	}

}

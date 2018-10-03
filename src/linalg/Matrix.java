package linalg;

/*** A class that represents a two dimensional real-valued (double) matrix
 *   and supports various matrix computations required in linear algebra.
 *   
 *   Class and method comments are in JavaDoc: https://en.wikipedia.org/wiki/Javadoc
 * 
 * @author scott.sanner@utoronto.ca, <YOUR_EMAIL>
 *
 */
public class Matrix {

	private int _nRows; // Number of rows in this matrix; nomenclature: _ for data member, n for integer
	private int _nCols; // Number of columns in this matrix; nomenclature: _ for data member, n for integer
	// TODO: add your own data member to represent the matrix content
	//       you could use a 2D array, or an array of Vectors (e.g., for each row)
	private Vector[] _avMatrix;
	
	/** Allocates a new matrix of the given row and column dimensions
	 * 
	 * @param rows
	 * @param cols
	 * @throws LinAlgException if either rows or cols is <= 0
	 */
	public Matrix(int rows, int cols) throws LinAlgException {
		if(rows <= 0 || cols <= 0) {
			throw new LinAlgException("Matrix rows " + rows + " or cols " + cols + " cannot be less than 1");
		}
		_nRows = rows; //number of vectors
		_nCols = cols;  //dim of vetcors added
		_avMatrix = new Vector[_nRows];
		
		for (int i = 0 ; i < _nRows ; i++) {
			_avMatrix[i] = new Vector(_nCols);
		}
	}
	
	/** Copy constructor: makes a new copy of an existing Matrix m
	 *                    (note: this explicitly allocates new memory and copies over content)
	 * 
	 * @param m
	 */
	public Matrix(Matrix m) {
		_nRows = m.getNumRows();
		_nCols = m.getNumCols();
		_avMatrix = new Vector[_nRows];
        for (int i = 0 ; i < _nRows ; i++){
            _avMatrix[i] = m._avMatrix[i];
        }
		
	}

	/** Constructs a String representation of this Matrix
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < this._nRows ; i++) {
			sb.append(_avMatrix[i]);
			sb.append(" \n");
		}
		return sb.toString();
	}

	/** Tests whether another Object o (most often a matrix) is a equal to *this*
	 *  (i.e., are the dimensions the same and all elements equal each other?)
	 * 
	 * @param o the object to compare to
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Matrix) {
			Matrix m = (Matrix)o; // This is called a cast (or downcast)... we can do it since we
			                      // know from the if statement that o is actually of subtype Vector
			if(_nCols != m._nCols || _nRows != m._nRows) {
				return false;
			}
			for(int i = 0 ; i < _nRows ; i++) {
				if(!_avMatrix[i].equals(m._avMatrix[i])) {
					return false;

				}
			}
			return true;
		} else // if we get here "(o instanceof Vector)" was false
			return false; // Two objects cannot be equal if they don't have the same class type
	}
	
	/** Return the number of rows in this matrix
	 *   
	 * @return 
	 */
	public int getNumRows() {
		return _nRows;
	}

	/** Return the number of columns in this matrix
	 *   
	 * @return 
	 */
	public int getNumCols() {
		return _nCols;
	}

	/** Return the scalar value at the given row and column of the matrix
	 * 
	 * @param row
	 * @param col
	 * @return
	 * @throws LinAlgException if row or col indices are out of bounds
	 */
	public double get(int row, int col) throws LinAlgException {
		if(row < 0 || row > this._nRows || col < 0 || col > this._nCols) {
			throw new LinAlgException("Uuuuummm excuse me sempai ...... um how do you say ......... please only enter Matrixes of legal ages >.<");
		}
		else {
			return _avMatrix[row].get(col);
		}
	}
	
	/** Return the Vector of numbers corresponding to the provided row index
	 * 
	 * @param row
	 * @return
	 * @throws LinAlgException if row is out of bounds
	 */
	public Vector getRow(int row) throws LinAlgException {
		if(row < 0 || row > this._nRows) {
			throw new LinAlgException("Uuuuummm excuse me sempai ...... um how do you say ......... please only make me play with vectors my age >.<");
		}
		else{
			return _avMatrix[row];
		}
	}

	/** Set the row and col of this matrix to the provided val
	 * 
	 * @param row
	 * @param col
	 * @param val
	 * @throws LinAlgException if row or col indices are out of bounds
	 */
	public void set(int row, int col, double val) throws LinAlgException {
		if(row < 0 || row > this._nRows || col < 0 || col > this._nCols) {
			throw new LinAlgException("Uuuuummm excuse me sempai ...... um how do you say ......... please only enter Matrixes of legal ages >.<");
		}
		else {
			_avMatrix[row].set(col,val);
		}
	}
	
	/** Return a new Matrix that is the transpose of *this*, i.e., if "transpose"
	 *  is the transpose of Matrix m then for all row, col: transpose[row,col] = m[col,row]
	 *  (should not modify *this*)
	 * 
	 * @return
	 * @throws LinAlgException
	 */
	public Matrix transpose() throws LinAlgException {
		Matrix transpose = new Matrix(_nCols, _nRows);
		for (int row = 0; row < _nRows; row++) {
			for (int col = 0; col < _nCols; col++) {
				transpose.set(col, row, get(row,col));
			}
		}
		return transpose;
	}

	/** Return a new Matrix that is the square identity matrix (1's on diagonal, 0's elsewhere) 
	 *  with the number of rows, cols given by dim.  E.g., if dim = 3 then the returned matrix
	 *  would be the following:
	 *  
	 *  [ 1 0 0 ]
	 *  [ 0 1 0 ]
	 *  [ 0 0 1 ]
	 * 
	 * @param dim
	 * @return
	 * @throws LinAlgException if the dim is <= 0
	 */
	public static Matrix GetIdentity(int dim) throws LinAlgException {
		if(dim < 1) {
			throw new LinAlgException("Uuuuummm excuse me sempai ...... um how do you say ......... please only make me play with vectors my age >.<");
			}
		else {
			Matrix m = new Matrix(dim, dim);
			for(int i = 0 ; i < dim ; i++) {
				for (int j = 0 ; j < dim ; j++) {
					if(i == j) {
						m.set(i, j, 1);
					}
					else {
						m.set(i, j, 0);
					}
				}
			}		
		return m;
		}
	}
	
	/** Returns the Matrix result of multiplying Matrix m1 and m2
	 *  (look up the definition of matrix multiply if you don't remember it)
	 * 
	 * @param m1
	 * @param m2
	 * @return
	 * @throws LinAlgException if m1 columns do not match the size of m2 rows
	 */
	public static Matrix Multiply(Matrix m1, Matrix m2) throws LinAlgException {
        if(m1.getNumCols() != m2.getNumRows()){
        	throw new LinAlgException ("Uuuuummm excuse me sempai ...... um how do you say ......... please only make me play with vectors my age >.<");
        }
        else {
        	Matrix m = new Matrix(m1.getNumRows(), m2.getNumCols());
        	Matrix m3 = new Matrix(m1.getNumRows(), m2.getNumCols());
        	m3 = m2.transpose();
        		for(int i = 0 ; i < m1.getNumRows() ; i++){
        			for (int j = 0 ; j < m3.getNumCols(); j++) {
        				m.set(i, j, Vector.InnerProd(m1.getRow(i), m3.getRow(j)));
        			}
        		}
        	return m;
        }

	}
		
	/** Returns the Vector result of multiplying Matrix m by Vector v (assuming v is a column vector)
	 * 
	 * @param m
	 * @param v
	 * @return
	 * @throws LinAlgException if m columns do match the size of v
	 */
	public static Vector Multiply(Matrix m, Vector v) throws LinAlgException {
		if (v.getDim() != m._nCols){
			throw new LinAlgException("Uuuuummm excuse me sempai ...... um how do you say ......... please only make me play with vectors my age >.<");
            }               
        else{
        	Vector ve = new Vector(m.getNumRows());	
            for(int i = 0 ; i < m.getNumRows() ; i++){
                ve.set(i, Vector.InnerProd(m.getRow(i), v));
            }
            return ve;
        }
	}

}

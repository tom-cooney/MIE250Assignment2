import linalg.LinAlgException;
import linalg.Matrix; // This is Matrix from the linear algebra package you are writing 
import linalg.Vector; // This is Vector from the linear algebra package you are writing 

/** This is a small example of test cases.  Write your own test cases to understand all
 *  of the methods in Matrix and Vector.  To test correctness of your implementation,  
 *  see if the output on your tests matches the results of the same tests on the solution
 *  (e.g., see TestLinAlgSoln which provides results for the solution by importing 
 *         soln.Matrix and soln.Vector as opposed to linalg.Matrix and linalg.Vector
 *         that you are writing).
 * 
 * @author ssanner@mie.utoronto.ca
 *
 */
public class TestLinAlg {

	public static void main(String[] args) throws LinAlgException {		
		
		//*********************************** VECTOR TEST CASES ***************************************************
		
		
		/*
		
		Vector v1 = new Vector ("[ 1 2 3 4 5 ]");
		System.out.println("Does v1 print? :           " + v1);
		Vector v2 = new Vector ("[ 6 7 8 9 10 ]");
		Vector v3 = new Vector ("[ 20 21 ]");
		Vector v4 = new Vector ("[ 30 31 32 33 34 35 36 37 ]");
		System.out.println("Does v2 print? :                " + v2);
		System.out.println("v1 dim should be 5 :        " + v1.getDim());
		System.out.println("v1[0] still be 1 :       " + v1.get(0));
		v2.set(4, 11);
		System.out.println("v2[4] should now be 11 :          " + v2);
		v3.changeDim(5);
		System.out.println("Vector v3 should now be [ 20 21 0.0  0.0 0.0 ] :      " + v3);
		v4.changeDim(5);
		System.out.println("Vector v4 should now be [ 30 31 32 33 34 ] :       " + v4);
		v1.scalarAddInPlace(2);
		System.out.println("Vector v1 should now be [ 3 4 5 6 7 ] :      " + v1);
		Vector v5 = v2.scalarAdd(2);
		System.out.println("Vector v2 should still be [ 6 7 8 9 11 ] :      " + v2 + "         and temp should be [ 8 9 10 11 13 ] :          " + v5);
		v3.scalarMultInPlace(3);
		System.out.println("Vector v3 should now be [ 60 63 0.0  0.0 0.0 ] :        " + v3);
		Vector v6 = v3.scalarMult(3);
		System.out.println("Vector v3 still be [ 60 63 0.0  0.0 0.0 ] :      " + v3 + "       and temp should be [ 180 189 0.0 0.0 0.0 ] :          " + v6);
		v1.elementwiseAddInPlace(v2);
		System.out.println("Vector v1 should now be [ 9 11 13 15 18 ] + :        " + v1);
		Vector v7 = v2.elementwiseAdd(v1);
		System.out.println("Vector v2 still be [ 6 7 8 9 11 ] :      " + v2 + "       and temp should be [ 15 18 21 24 29 ] :          " + v7);
		Vector v8 = new Vector ("[ 2 2 2 2 2 ]");
		v8.elementwiseMultInPlace(v2);
		System.out.println("Vector v8 should now be [ 12 14 16 18 22 ] :      " + v8 + " Vector v2 still be [ 6 7 8 9 11 ] :      " + v2);
		Vector v9 = v8.elementwiseMult(v2);
		System.out.println("Vector v8 still be [ 12 14 16 18 22 ] :      " + v8 + " Vector v9 should be [ 72 98 128 162 242 ] :      " + v9);
		Vector v10 = new Vector ("[ 2 2 2 2 2 ]");
		Vector v11 = new Vector ("[ 3 -3 3 3 3 ]");
		Vector v12 = new Vector ("[ 1 1 1 1 1 ]");
		System.out.println("Inner product of v10 and v11 should be 18 :         " + v12.InnerProd(v10, v11));
		
		
		*/
		
		
		//*********************************** MATRIX TEST CASES ***************************************************
		
		
		
		
		
		Matrix m1 = new Matrix(4, 4);
		Matrix m5 = new Matrix(4, 4);
		Vector m6 = new Vector(4);
		Vector v = new Vector ("[ 1 2 3 4 ]");
		
		for(int i = 0 ; i < 4 ; i++) {
			for (int j = 0 ; j < 4 ; j++) {
				m1.set(i, j, i+j*j);
			}
		}
		System.out.println(m1);
		Matrix m2 = new Matrix(m1);
		System.out.println(m2);
		Matrix m3 = new Matrix(5, 5);
		Matrix m4 = new Matrix(5, 5);
		for(int i = 0 ; i < 5 ; i++) {
			for (int j = 0 ; j < 5 ; j++) {
				m3.set(i, j, i-j*j);
			}
		}
		System.out.println(m3);
		if(m1.equals(m2)) {
			System.out.println("yay m1 and m2 match");
		}
		if(!(m1.equals(m3))) {
			System.out.println("yay m1 and m3 dont match");
		}
		System.out.println("Should read 2.0 :         " + m2.get(1,1));
		System.out.println("Shoudl read [ 1.0  2.0  5.0  10.0 ] :         " + m2.getRow(1));
		m3.set(2, 2, 22);
		System.out.println("Should have entry [2,2] as 22 :      \n" + m3);
		System.out.println("i want to see a m3 flipped      \n" + m3.transpose());
		m4 = Matrix.GetIdentity(5);
		System.out.println("Should have a 5x5 identity matrix :         \n" + m4);
		m5 = Matrix.Multiply(m1, m2);
		System.out.println("For reference here is m1:  \n" + m1);
		System.out.println("For reference here is m2:  \n" + m2);
		System.out.println("Should have a 4x4 matirx which looks like \n[36 50 92 162]\n[42 60 114 204]\n[48 70 136 246]\n[54 80 158 288]:         \n" + m5);
		m6 = Matrix.Multiply(m1, v);
		System.out.println("Should have a vector whihc looks like \n [ 50 60 70 80 ]" + m6);
		
		
		
		
		
	}

}

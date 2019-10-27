package multiplymatrix;


import java.util.*;
import java.lang.*;
public class MatrixMultiplier
{

    /*************************************************************************
    * SUBMODULE: multiplySeries
    * IMPORTS: the number of matrices in the series.
    * EXPORTS: nothing
    * PURPOSE: To multiple several matrices, where each matrix comes from its 
    * own  text file.
    * BEHAVIOUR: Will throw an exception if anything is invalid.
    *************************************************************************/
    public static void multiplySeries(int num) throws InvalidMatrixMultiplication
    {
        Scanner sc = new Scanner(System.in);   //node1
        double matrix1[][] = null;
        double matrix2[][] = null;

        if(num < 2)   //node2
        {
            System.out.println("Cannot multiply "+num+" matricis");
            throw new IllegalArgumentException("Cannot multiply " + num + " matricis");  //node3
        }
        else  //node4
        {
            try
            {
                System.out.println("Please enter the file name for matrix 1:");
                String file = sc.nextLine();

                matrix1 = FileInput.readMatrix(file); 

                for(int ii = 1; ii < num; ii++)  //node5
                {
                    System.out.println("Please enter the file name for matrix " + (ii+1) + ":");
                    file = sc.nextLine();                                //node6
                    matrix2 = FileInput.readMatrix(file);

                    matrix1 = multiplyMatrix(matrix1, matrix2);
                }
                printMatrix(matrix1);  //node7
            }
            catch (IllegalArgumentException e)
            {
                throw new InvalidMatrixMultiplication("Error: " + e.getMessage());
            }
            catch (FileInputException e)
            {
                throw new InvalidMatrixMultiplication("Error: " + e.getMessage());
            }
        }
    }

    /*************************************************************************
    * SUBMODULE: multiplyMatrix
    * IMPORTS: double[][] matrix1, double[][] matrix 2
    * EXPORTS: double[][] result
    * PURPOSE: multiplies matrix1 by matrix2 in the same order as the imports.
    * BEHAVIOUR: if the matrices are incompatible, or either matrix is null 
    *            an exception is thrown.
    *************************************************************************/
    public static double[][] multiplyMatrix(double[][] matrix1, double matrix2[][])
    {
        double result[][] = null;  //node1
    
        if ( matrix1 == null)  //node2
        {
            throw new IllegalArgumentException("Cannot multiply null arrays");  //node3
        }
        else if (matrix1[0].length != matrix2.length)  //node4
        {
            throw new IllegalArgumentException("Array dimensions do not match");  //node5
        }
        else  //node6
        {
            result = new double[matrix1.length][matrix2[0].length];

            for(int ii = 0; ii < matrix1.length; ii++) //node6
            {
                for(int jj = 0; jj < matrix2[0].length; jj++)  //node7
                {
                    result[ii][jj] = 0;
                    for(int kk = 0; kk < matrix1[0].length; kk++)  //node8
                    {
                        result[ii][jj] += (matrix1[ii][kk] * matrix2[kk][jj]);  //node9
                    }
                }
            }
        }

        return result;  //node10
    }

    /*************************************************************************
    * SUBMODULE: printMatrix
    * IMPORTS:
    * EXPORTS:
    * PURPOSE:
    * BEHAVIOUR:
    *************************************************************************/
    public static void printMatrix(double[][] matrix) throws NullPointerException  
    {//node1
        for(int r = 0; r < matrix.length; r++)  //node2
        {
            
            System.out.print("[");
            for(int c = 0; c < matrix[0].length-1; c++)  //node3
            {
                System.out.format("%10.2f, ", matrix[r][c]);  //node4
            }   
            System.out.format("%10.2f]\n", matrix[r][matrix[r].length-1]);  //node5
        }
    } //node6
}

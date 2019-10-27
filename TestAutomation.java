package multiplymatrix;


import java.util.Scanner;

public class TestAutomation
{
    /*****************************************************
    * This is the main you can use to test MatrixMultiplier
    * It takes a single command line argument specifying 
    * the number of matricies to be multiplied.
    *****************************************************/
    public static void main(String args[]) throws InvalidMatrixMultiplication , NullPointerException
    {
        
            System.out.println("Begining of Test Automation");


            TestprintMatrix tpm = new TestprintMatrix();
            
            tpm.test();
            
//            TestmultiplySeries ts = new TestmultiplySeries();
//            
//            ts.test();
            
            TestmultiplyMatrix tm = new TestmultiplyMatrix();
            
            tm.test();
            
            System.out.println("End of test automation");

    }
}

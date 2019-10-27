package multiplymatrix;




/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.Scanner;
/*    */ 
/*    */ public class FileInput
/*    */ {
private static Scanner scanner;

/*    */   public static double[][] readMatrix(String paramString) throws FileInputException {
/*  8 */     double[][] arrayOfDouble = (double[][])null;
/*    */ 
/*    */     
/*    */     try {
scanner = new Scanner(new File(paramString));
/* 13 */       byte b = 0;
/* 14 */       int i = 0;
/*    */       
/* 16 */       if (scanner.hasNext()) {
/*    */         
/* 18 */         String str = scanner.nextLine();
/* 19 */         i = str.split(",").length;
/* 20 */         b++;
/*    */ 
/*    */         
/* 23 */         while (scanner.hasNext()) {
/*    */           
/* 25 */           str = scanner.nextLine();
/* 26 */           b++;
/* 27 */           if (i != str.split(",").length)
/*    */           {
/* 29 */             throw new FileInputException("Invalid matrix format");
/*    */           }
/*    */         } 
/* 32 */         scanner.close();
/* 33 */         scanner = new Scanner(new File(paramString));
/*    */         
/* 35 */         scanner.useDelimiter("\\s*,\\s*|\\n|\\r\\n");
/* 36 */         arrayOfDouble = new double[b][i];
/*    */         
/* 38 */         for (byte b1 = 0; b1 < arrayOfDouble.length; b1++) {
/*    */           
/* 40 */           for (byte b2 = 0; b2 < arrayOfDouble[0].length; b2++)
/*    */           {
/* 42 */             arrayOfDouble[b1][b2] = scanner.nextDouble();
/*    */           }
/*    */         } 
/*    */       } 
/* 46 */       scanner.close();
/*    */     }
/* 48 */     catch (IOException iOException) {
/*    */       
/* 50 */       throw new FileInputException("Invalid File");
/*    */     } 
/*    */     
/* 53 */     return arrayOfDouble;
/*    */   }
/*    */ }


/* Location:              C:\Users\Rocket Bunny\eclipse-workspace\SetApplicationTest\src\!\FileInput.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */
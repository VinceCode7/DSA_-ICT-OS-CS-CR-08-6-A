# A program to multiply to matrix 
A program that take two matrixes,multiplys then and display the results
 ## FEATURES
  1. Uses two dimensional Array
  2. Checks for compatibility
  3. Print result in an array like structure

  ## Pseudocode
	BEGIN 
	FUCTION MultiplyMatrix PARAMETERS int A, int B
	//A for MatrixA and B for MatrixB
	  SET rowA TO A.length 0 //get the number of matrix A rows
	  SET colA TO A.length 1  //get the number of matrix A columns
	  SET rowB TO B.length 0 //get the number of matrix B rows
	  SET colB TO B.length 1  //get the number of matrix B columns
	
		//check for compatibility
		IF colsB NOT = rowB
		PRINT Not Compatible matrix for multiplication
		END IF
	
	   SET result TO COMPUTE A*B
	   RETURN result
	END FUCTION
	
	FUCTION Main
	   SET A TO  {
	                { 1, 3, 3, 3},
	                { 4, 5, 6 ,4},
	                { 7, 8, 9,3 }
	            };
	   SET B TO {
	                { 7, 8,9 },
	                { 9, 10,4 },
	                { 11, 12 ,5},
	                {4,5,2}
	            };
	
	   SET displayResult TO CALL MultiplyMatrix (A,B)
	   DISPLAY displayResult
	   END FUCTION 
	END


// See https://aka.ms/new-console-template for more information
namespace MatrixCalculation
{
    public class Program
    {
        public static int[,] Multiply(int[,] A, int[,] B)
        {
            int rowsA = A.GetLength(0);
            int colsA = A.GetLength(1);
            int rowsB = B.GetLength(0);
            int colsB = B.GetLength(1);

            if (colsA != rowsB)
            {
                throw new InvalidOperationException("Matrix sizes don't match!");

            }
            int[,] result = new int[rowsA, colsB];

            for (int i = 0; i < rowsA; i++) //2
            {
                for (int j = 0; j < colsB; j++) //1
                {
                    for (int k = 0; k < colsA; k++) //3
                    {
                        result[i, j] += A[i, k] * B[k, j];
                    }
                }
            }

            return result;
        }

        public static void Main(string[] args)
        {


            int[,] A = {
                { 1, 3, 3, 3},
                { 4, 5, 6 ,4},
                { 7, 8, 9,3 }
            };

            int[,] B = {
                { 7, 8,9 },
                { 9, 10,4 },
                { 11, 12 ,5},
                {4,5,2}
            };

            int[,] C = Multiply(A, B);

            for (int i = 0; i < C.GetLength(0); i++)
            {
                for (int j = 0; j < C.GetLength(1); j++)
                {
                    Console.Write(C[i, j] + " ");
                }
                Console.WriteLine();
            }

            /*
            List<List<int>> pascalTriangle = new List<List<int>>();
            pascalTriangle.Add(new List<int> { 1 });
            pascalTriangle.Add(new List<int> { 1, 1 });
            pascalTriangle.Add(new List<int> { 1, 2, 1 });
            pascalTriangle.Add(new List<int> { 1, 3, 3, 1 });
            pascalTriangle.Add(new List<int> { 1, 4, 6, 4, 1 });
            pascalTriangle.Add(new List<int> { 1, 5, 10, 10, 5, 1 });
            pascalTriangle.Add(new List<int> { 1, 6, 15, 20, 15, 6, 1 });
            pascalTriangle.Add(new List<int> { 1, 7, 21, 35, 35, 21, 7, 1 });


            foreach (var row in pascalTriangle)
            {
                Console.WriteLine(string.Join(" ", row));
            }

            /**
            int numRows = 7; // Number of rows in Pascal's Triangle
            List<List<int>> pascalTriangle = GeneratePascalTriangle(numRows);

            foreach (var row in pascalTriangle)
            {
                Console.WriteLine(string.Join(" ", row));
            }
        }

        static List<List<int>> GeneratePascalTriangle(int numRows)
        {
            var triangle = new List<List<int>>();

            for (int i = 0; i < numRows; i++)
            {
                var row = new List<int> { 1 }; // First element is always 1

                for (int j = 1; j < i; j++)
                {
                    int value = triangle[i - 1][j - 1] + triangle[i - 1][j];
                    row.Add(value);
                }

                if (i > 0) row.Add(1); // Last element is always 1 for rows > 0
                triangle.Add(row);
            }

            return triangle;

 */
            /*
            int exponent = 3;
            int value1 = 7;
            //string value2=""

            int[] coeffecients = pascalTriangle[exponent].ToArray();

            for (int i = 0; i < coeffecients.Length; i++) { 

                Console.Write(coeffecients[i]+" ");
            }
            */
        }
        }


    }


import java.util.Scanner;

public class MatrixChain {

    public static int matrixChainOrder(int[] p, int n) {
        int[][] m = new int[n][n];

        for (int i = 1; i < n; i++) {
            m[i][i] = 0;
        }

        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                    }
                }
            }
        }

        return m[1][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of matrices: ");
        int n = sc.nextInt();

        int[] p = new int[n + 1];

        System.out.println("Enter dimension array:");
        for (int i = 0; i <= n; i++) {
            p[i] = sc.nextInt();
        }

        int result = matrixChainOrder(p, n + 1);

        System.out.println("Minimum multiplication cost: " + result);

        sc.close();
    }
}

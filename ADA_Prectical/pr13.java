import java.util.Scanner;

public class SCSProgram {

    public static String scs(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        int i = m, j = n;
        StringBuilder ans = new StringBuilder();

        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                ans.append(X.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] < dp[i][j - 1]) {
                ans.append(X.charAt(i - 1));
                i--;
            } else {
                ans.append(Y.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            ans.append(X.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            ans.append(Y.charAt(j - 1));
            j--;
        }

        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String X = sc.nextLine();

        System.out.print("Enter second string: ");
        String Y = sc.nextLine();

        String result = scs(X, Y);

        System.out.println("SCS: " + result);

        sc.close();
    }
}

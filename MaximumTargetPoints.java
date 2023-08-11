package Assignment;
// Question Number 3(a)
public class MaximumTargetPoints {
    public static int maxPoints(int[] a) {
        int n = a.length;
        int[] paddedArray = new int[n + 2];

        // Add padding of value 1 at the beginning and end of the array
        paddedArray[0] = paddedArray[n + 1] = 1;
        System.arraycopy(a, 0, paddedArray, 1, n);

        int[][] dp = new int[n + 2][n + 2];

        for (int len = 1; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;

                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][k - 1] + paddedArray[i - 1] * paddedArray[k] * paddedArray[j + 1] + dp[k + 1][j]);
                }
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 5, 8};
        System.out.println(maxPoints(a)); // Output: 167
    }
}


package Assignment;

public class Mains {
    public static void main(String[] args) {
    QuestionNFive solution=new QuestionNFive();
        int n = 6;
        int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        int output = solution.minReorder(n, connections);
        System.out.println(output); // Output: 3
    }
}

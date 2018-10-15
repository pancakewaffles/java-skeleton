package answers;

public class Question1 {
	private static int[][] answer_matrix;
	private static int max = 0;
	/*
	public static void main(String[] args) {
		System.out.println(bestMergedPortfolio(new int[] {9,7,12,2}  ));
	}
	*/
	public static int bestMergedPortfolio(int[] portfolios) {
		answer_matrix = new int[portfolios.length][portfolios.length];
		for(int i =0;i<portfolios.length;i++) {
			for(int j =0;j<portfolios.length;j++) {
				if(i != j) {
					answer_matrix[i][j] = portfolios[i] ^ portfolios[j];
					max = Math.max(max, answer_matrix[i][j]);
				}else {
					answer_matrix[i][j] = 0;
				}
			}
		}
		return max;
	}
	

}

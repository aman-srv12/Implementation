
public class LongestCommonSubsequence {
	public static void main(String args[]) {
		String text1 = "advuybn";
		String text2 = "abyan";
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		int len1 = text1.length();
		int len2 = text2.length();
		int m[][] = lcs.findLCS(text1, text2);
		System.out.println("The length of the longest common subsequence is "+
							m[len1][len2]);
		printLongestCommonSubsequence(m, text1, text2, len1, len2);
	}

	private static void printLongestCommonSubsequence(int[][] m, String text1, String text2, 
													  int len1, int len2) {
		// TODO Auto-generated method stub
		String commonSubsequence = "";
		int i = len1;
		int j = len2;
		while(i > 0 && j > 0) {
			if(text1.charAt(i-1) ==  text2.charAt(j-1)) {
				commonSubsequence = text1.charAt(i-1) + commonSubsequence;
				i--;
				j--;
			}
			else if(m[i][j-1] > m[i-1][j]) {
				j--;
			}
			else {
				i--;
			}
		}
		System.out.println("Common subsequence is "+ commonSubsequence);
	}

	private int[][] findLCS(String text1, String text2) {
		int len1 = text1.length() + 1;
		int len2 = text2.length() + 1;
		int m[][] = new int[len1][len2];

		for(int i = 1; i < len1; i++){
			for(int j = 1; j < len2; j++){
				if(text1.charAt(i-1) == text2.charAt(j-1)){
					m[i][j] = 1 + m[i-1][j-1];
				}
				else if(text1.charAt(i-1) != text2.charAt(j-1)){
					m[i][j] = Math.max(m[i-1][j], m[i][j-1]);
				}
			}
		}
		// System.out.println(len1);
		// System.out.println(len2);
		// for(int i = 0; i < len1; i++){
		//     for(int j = 0; j < len2; j++){
		//         System.out.print(m[i][j] + "  ");
		//     }
		//     System.out.println();
		// }
		return m;
	}
}

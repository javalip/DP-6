public class LongestPalindromicSubString {
    /**
     * and int max =0
     * goto each and every index and do 2 things
     * 1. Take l and r pointers. place on chatAt(i).
     * 2. check if I have palindromic substring.
     * length = r-l+1
     * when one of them result into non matching character or go out of bounds, stop
     * the process
     * 1. first move right and keep left on same.
     *
     * Move left to left and right to risht.
     * need for checking again with right pointer keeping on next char is to find
     * even length palindrome
     time - o(n2)
     spac - o(1)
     *
     */
    int max = 0;
    int start = 0;
    int end = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            // for odd length
            expandAroundCenter(s, i, i);
            // for even length
            if (i < s.length() - 1) {
                expandAroundCenter(s, i, i + 1);
            }
        }
        return s.substring(start,end+1);
    }
    private void expandAroundCenter(String s, int l, int r){
        while(l>=0 && r<s.length() &&(s.charAt(l)==s.charAt(r))){
            l--;
            r++;
        }
        l++;
        r--;
        if(max < r-l+1){
            max = r-l+1;
            start = l;
            end = r;
        }
    }
    /**
     * DP matrix with all characters in row and col
     * for each char matching if thethat aubstring is palindrome we store true or we store false
     *
     *
     *
     */

    /**
     time - o(n2)
     space - 0(n2)

     */
    public String longestPalindrome2(String s) {
        if(s==null || s.length()==0){
            return s;
        }

        int n= s.length();
        boolean[][] dp = new boolean[n][n];
        int max=0;
        int start=0;
        int end =0;
        for(int i=0; i<n;i++){
            for(int j=0; j<i; j++){
                if((s.charAt(i) == s.charAt(j))&& ((i-j-1<2) || (dp[i-1][j+1]))){
                    dp[i][j]=true;
                }if(dp[i][j]==true){
                    if(i-j+1>max){
                        max =i-j+1;
                        start=j;
                        end=i;
                    }
                }
            }
        }
        return s.substring(start, end+1);

    }
}

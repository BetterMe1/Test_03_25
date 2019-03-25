package Test_03_24;


/*
1020. 将数组分成和相等的三个部分  
给定一个整数数组 A，只有我们可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
形式上，如果我们可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... 
+ A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 
示例 1：
输出：[0,2,1,-6,6,-7,9,1,2,0,1]
输出：true
解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
示例 2：
输入：[0,2,1,-6,6,7,9,-1,2,0,1]
输出：false
示例 3：
输入：[3,3,6,5,-2,2,5,1,-9,4]
输出：true
解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4

提示：
3 <= A.length <= 50000
-10000 <= A[i] <= 10000
 */
/*
 * 分析：
 * 先算出数组所有数的和sum, c = sum/3,判断c*3是否等于sum，若不等于，说明sum不能被分为三部分，返回false，
 * 若等于，遍历数组，temp记录数组的部分和，f记录次数，统计过程中若temp等于c,temp清零，f加一，
 * 遍历完毕，若f等于3，返回true,不等于返回false。
 */
public class LeetcodeTest {
	public static void main(String[] args) {
		Solution So = new Solution();
		int[] A = {0,2,1,-6,6,-7,9,1,2,0,1};
		System.out.println(So.canThreePartsEqualSum(A));
	}
}
class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for(int i=0; i<A.length; i++){
            sum += A[i];
        }
        int c = sum/3;
        if(c*3 != sum){
            return false;
        }
        int temp = 0;
        int f = 0;
        for(int i=0; i<A.length; i++){
           temp += A[i];
            if(temp == c){
                temp = 0;
                f++;
            }
        }
        return f==3;
    }
}
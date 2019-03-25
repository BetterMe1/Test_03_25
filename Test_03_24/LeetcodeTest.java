package Test_03_24;


/*
1020. ������ֳɺ���ȵ���������  
����һ���������� A��ֻ�����ǿ��Խ��仮��Ϊ��������ȵķǿղ���ʱ�ŷ��� true�����򷵻� false��
��ʽ�ϣ�������ǿ����ҳ����� i+1 < j ������ (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... 
+ A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) �Ϳ��Խ��������ȷ֡�
 
ʾ�� 1��
�����[0,2,1,-6,6,-7,9,1,2,0,1]
�����true
���ͣ�0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
ʾ�� 2��
���룺[0,2,1,-6,6,7,9,-1,2,0,1]
�����false
ʾ�� 3��
���룺[3,3,6,5,-2,2,5,1,-9,4]
�����true
���ͣ�3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4

��ʾ��
3 <= A.length <= 50000
-10000 <= A[i] <= 10000
 */
/*
 * ������
 * ����������������ĺ�sum, c = sum/3,�ж�c*3�Ƿ����sum���������ڣ�˵��sum���ܱ���Ϊ�����֣�����false��
 * �����ڣ��������飬temp��¼����Ĳ��ֺͣ�f��¼������ͳ�ƹ�������temp����c,temp���㣬f��һ��
 * ������ϣ���f����3������true,�����ڷ���false��
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
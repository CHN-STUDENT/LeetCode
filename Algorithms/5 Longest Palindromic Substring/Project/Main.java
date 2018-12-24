public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.longestPalindrome("abcb"));
    }
}

class Solution {
    public String longestPalindrome(String s) {
        /**
         * 什么叫回文串？
         *      回文串是从左到右或者从右到左读都是相同的元素，也就是说它们关于一个对称轴对称。如ABBA,ABA
         * 什么叫子串？
         *      子串是一个字符串中所有连续元素的集合。对于一个长度为n的字符串来说，它的字串应该为(n+1)n/2+1。
         *      如长度为4的字符串ABCD字串为11个。A,B,C,D,AB,BC,CD,ABC,BCD,ABCD,""(空串) 4+3+2+1+1(空串)。
         * 有一种暴力方案解决此题是求出字符串的所有字串，并且判断他们是否为回文串，但是这种方案需要花费大量时间和空间。
         * 我参考了https://wizardforcel.gitbooks.io/the-art-of-programming-by-july/content/01.05.html上的一般方案学习这个问题。
         * 他的方案是假设每一位都是一个对称轴，判断对称轴两侧的元素是否相等，来判断最大回文串长度。
         *      ！！注意要处理长度为奇数或者为偶数的情况！！
         *      假设对称轴在第i(i<s.length())位。离对称轴i距离为j的元素分别为s.charAt(i-j)和s.charAt(i+j)
         *      对于奇数情况
         *        XXXXXXX i XXXXXXX
         *        i-j<--- i --->i+j
         *        分别比对s.charAt(i-j)和s.charAt(i+j)是否相等，若相等则让他们分别向对称轴靠近，直到有一个元素不相同
         *        此时长度为c=j*2+1;
         *      对于偶数情况
         *         XXXXXX i [i+1] XXXXXX
         *         i-j<-- i [i+1] -->i+j+1
         *         假设第i+1位也是对称轴，
         *         分别比对s.charAt(i-j)和s.charAt(i+j+1)是否相等，若相等则让他们分别向对称轴靠近，直到有一个元素不相同
         *         此时长度为c=j*2+2;
         *      对于以上两种情况都要考虑，还要声明一个开始索引坐标prev，最大长度值max，如果计算新的子串的回文长度大于就要更新
         *      然后截取，起始位置prev，结束位置prev+max;
         *      注意起始位置下标=对称轴下标+1-两边相同元素的个数
         */
        String result="";
        if(s.length()!=0) {
            //定义最大长度值，开始索引下标，两边相同元素个数j
            int max=0;
            int prev=-1;
            int j=0;
            //假设每一位都是对称轴
            for(int i=0,c=0;i<s.length();i++) {
                //每个循环前都应该将j重置
                j=0;
                for(;(i-j)>=0&&(i+j)<s.length();j++) {
                   if(s.charAt(i-j)!=s.charAt(i+j)) {
                       break;
                   }
                   c=j*2+1;
                }
                if(c>max) {
                   prev=i-j+1;
                   max=c;
                }
                //每个循环前都应该将j重置
                j=0;
                for(;(i-j)>=0&&(i+j+1)<s.length();j++) {
                   if(s.charAt(i-j)!=s.charAt(i+j+1)) {
                       break;
                   }
                   c=j*2+2;
                }
                if(c>max) {
                   prev=i-j+1;
                   max=c;
                }
            }
            result=s.substring(prev,prev+max);
        }
        return result;
    }
}
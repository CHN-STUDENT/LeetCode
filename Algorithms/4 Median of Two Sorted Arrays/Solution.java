class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) { ;
        int len1=nums1.length;
        int len2=nums2.length;
        int len=len1+len2;
        int i=0;
        int num[]=new int[len]; //用来将两个整形数组合并
        int index1,index2;//分别为每个整数数组的下标
        for(index1=0,index2=0;index1<len1&&index2<len2;i++){
            //&& 其中一个为假，则条件为假，退出循环，这里是循环到两个整形数组最小的长度那个
            if(nums1[index1]<nums2[index2]) {
                num[i]=nums1[index1];
                index1++; //变成下一个下标
            } else {
                num[i]=nums2[index2];
                index2++;
            }
        }
        //下面两个循环是为了拷贝整形数组可能剩余的部分
        for(;index1<len1;index1++,i++) {
            num[i]=nums1[index1];
        }
        for(;index2<len2;index2++,i++) {
            num[i]=nums2[index2];
        }
        if(len%2==0) {
            return (num[len/2-1]+num[len/2])/2.0;
        }
        return num[len/2];
    }
}
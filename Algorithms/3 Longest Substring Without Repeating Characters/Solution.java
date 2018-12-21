class Solution {
    public int lengthOfLongestSubstring(String s) {
        //参考：https://lierabbit.cn/2018/04/24/%E6%97%A0%E9%87%8D%E5%A4%8D%E5%AD%97%E7%AC%A6%E7%9A%84%E6%9C%80%E9%95%BF%E5%AD%90%E4%B8%B2/
        int reslut=0;
        if(s.length()!=0) {
            int prev=-1;//上次出现的的位置
            HashMap<Character,Integer> hashMap=new HashMap<>(); //构建哈希表，其中Key为字符，Value为该字符出现的位置
            for(int i=0;i<s.length();i++) {
                Character ch=s.charAt(i); //取当前位的字符
                Integer index=hashMap.get(ch); //在哈希表通过索引查找
                if(index!=null) { //如果找到
                       prev=(prev>index)?prev:index; //?更新当前索引位
                }
                //最长字符字串间隔=当前位置-上次出现的位置
                reslut=(reslut>i-prev)?reslut:i-prev; //如果新的长度大于原来的长度，更新长度
                hashMap.put(ch,i); //将该位放入哈希表
            }
        }
        return reslut;
    }
}
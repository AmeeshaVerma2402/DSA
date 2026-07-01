class Solution {
    public int removeDuplicates(int[] nums) 
    {
       int i=0,j=1,u=1;
       while(j<nums.length)
       {
            if(nums[j]==nums[j-1])
            {
                j++;
                continue;
            }
           nums[i+1]=nums[j];
           i++;
           u++;
           j++;
       }
       return u;
    }
}
class Solution 
{
    public int subarraySum(int[] nums, int k) 
    {
        int c=0;
        for(int i=0;i<nums.length;i++)
        {
            int m=0;
            for(int j=i;j<nums.length;j++)
            {
                m=m+nums[j];
                if(m==k)
                {
                    c++;
                }
            }
        }
        return c;
    }
}
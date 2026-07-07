class Solution 
{
    public long sumAndMultiply(int n) 
    {
        int rev = 0;
        while(n > 0)
        {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        long v = 0;
        int s = 0;
        while(rev > 0)
        {
            int d = rev % 10;
            if(d != 0)
            {
                v = v * 10 + d;
                s += d;
            }
            rev /= 10;
        }
        return v * s;
    }
}
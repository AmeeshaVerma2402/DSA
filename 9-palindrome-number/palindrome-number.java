class Solution {
    public boolean isPalindrome(int x) 
    {
        int n=x;
        int dig=0,rev=0;
        while(n>0)
        {
            dig=n%10;
            rev=rev*10+dig;
            n/=10;
        }
        if( rev == x )
            return true;
        else
            return false;
    }
}
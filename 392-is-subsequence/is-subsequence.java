class Solution {
    public boolean isSubsequence(String s, String t) 
    {
        int c=0; int k=-1;
        for(int i=0;i<s.length();i++)
        {
            for(int j=k+1;j<t.length();j++)
            {
                if(s.charAt(i)==t.charAt(j) )
                {
                    c++;
                    k=j;
                    break;
    
                }
            }   
        }
        if(c==s.length())
            return true;
        else
            return false;
        
    }
}
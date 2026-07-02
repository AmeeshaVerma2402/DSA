class Solution 
{
    public boolean rotateString(String s, String goal) 
    {
        if (s.length() != goal.length())
        {
            return false;
        }
        if(s.equals(goal))
        {
            return true;
        }
        for(int i=1;i<s.length();i++)
        {
            String str1=s.substring(0,i);
            String str2=s.substring(i);
            String res=str2.concat(str1);
            if(res.equals(goal))
            {
                return true;
            }
        }        
        return false;
    }
}
class Solution 
{
    public int lengthOfLastWord(String s) 
    {
        int c=0;
        boolean wordStarted =false;
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i) != ' ')
            {
                c++;
                wordStarted= true;
            }
            else if(wordStarted)
            {
                break;
            }
        }
        return c; 
    }
}
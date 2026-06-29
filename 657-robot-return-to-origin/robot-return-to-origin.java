class Solution {
    public boolean judgeCircle(String moves) 
    {
        int x=0,y=0;
        for(int i=0;i<moves.length();i++)
        {
            char ch=moves.charAt(i);
            if(ch=='L')
                x--;
            else if(ch=='R')
                x++;
            else if(ch=='U')
                y--;
            else if(ch=='D')
                y++;
        }
        if(x==0 &&y==0)
            return true;
        else
            return false;
    }
}
/*int c=0;
        if(moves.contains("L")&& moves.contains("R"))
        {
            c++;
        }   
        if( moves.contains("U")&& moves.contains("D"))
        {
            c++;
        }     
        if(c==1 || c==2)
        {
            return true;
        }
        else
        {
            return false;
        }*/
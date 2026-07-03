class Solution 
{
    public static long ncr(int n, int r)
    {
        long res=1;
        //r = Math.min(r, n - r);
        for(int i=0;i<r;i++)
        {
            res=res*(n-i);
            res=res/(i+1);
        }
        return res;
    }
    public List<Integer> getRow(int r) 
    {
        ArrayList<Integer> a=new ArrayList<>();
        long res;
        for(int i=0;i<r+1;i++)
        {
            res=ncr(r,i);
            a.add((int)res);
        }
        return a;        
    }
}
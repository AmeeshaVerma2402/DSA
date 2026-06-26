class Solution {
    public boolean canConstruct(String r, String m) 
    {
        HashMap<Character, Integer> n= new HashMap<>();
        for(Character c:m.toCharArray())
        {
                n.put(c,n.getOrDefault(c,0)+1);
        }
        for(Character c:r.toCharArray())
        {
            if(!n.containsKey(c)|| n.get(c)==0)
            {
                return false;
            }
            n.put(c,n.get(c)-1);            
        }   
        return true;

    }
}
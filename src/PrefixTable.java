public class PrefixTable {
    public static void main(String[] args) {
        String x = "TTAATTGTTAAATAA";//15 1 0 0 2 1 0 4 1 0 0 0 1 0 0
        int m = x.length();
       
        int[]pref = new int[m];
       
        pref[0]=m;
        int g = 0;
        int f = 0;
       
        for(int i = 1; i<m; i ++)
        {
            if(i<g && pref[i-f]!=g-i)
            {
                pref[i] = Math.min(pref[i-f], g-i);
            }
            else
            {
                g= Math.max(g, i);
                f= i; // F is always equal to I, potentially remove f
                while(g<m && (x.charAt(g)+"").equals(x.charAt(g-f)+""))
                {
                    g++;
                }
                pref[i]=g-i;
            }
        }
       
        for(int i :pref)
            System.out.print(i+"\t");
    }
}
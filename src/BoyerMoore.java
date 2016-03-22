
public class BoyerMoore {
	public static void main(String []args)
	{
		//B A A A A B B A B A A A B A A B A A A B A B A B A
		//                            A B A A A B A B A B A
		String y = "baaaabbabaaabaabaaabababa";
		int n = y.length();
		String x = "abaaabababa";
        int m = x.length();
        int []Suf = PrefixTable.calculateBorderTable(new StringBuilder(x).reverse().toString(), m);
        for(int i = 0; i < Suf.length / 2; i++)
        {
            int temp = Suf[i];
            Suf[i] = Suf[Suf.length - i - 1];
            Suf[Suf.length - i - 1] = temp;
        }
        int []D = DisplacementTable.computeDisplacementTable(x, m, Suf);
		calculateDachiStyle(x,y,m,n,D);
	}
	public static void calculateDachiStyle(String x, String y, int m, int n, int[]D)
	{
		for(int i = 0; i<=n-m;)
		{
			int shift = 1;
			for(int k = m-1; k>=0;k--)
			{
				if(x.charAt(k) == y.charAt(i+k))
				{
					System.out.print("\tMatch: "+x.charAt(k));
					if(k==0)
						System.out.print("\tComplete match!");
				}
				else
				{					
					shift = D[k];
					System.out.print("\tNo. push: "+shift);
					break;
				}			
			}
			i+=shift;
			System.out.println();
		}
	}
}

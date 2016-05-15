
public class MorisPratt {

	static int []MP_next = {-1,0,1,2,0,1,2};

	public static void main(String[]args)
	{
		//0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7
		//A A B A A A A B A B A A A B A A B B
		//A A A B A A
		String y = "aabaaaababaaabaabb";
		int n = y.length();
		
		String x = "aaabaa";
		int m = x.length();

//		calculate(x,y,m,n);
		calculateDachiStyle(x,y,m,n);
	}
	private static void calculateDachiStyle(String x, String y, int m, int n)
	{
		int k = 0;
		for(int i = 0; i<=n-m;)
		{
			int period = 1;
			for(; k<m; k++)
			{
				if(x.charAt(k) == y.charAt(i+k))
				{
					System.out.print("\tMatch: "+x.charAt(k));
					if(k+1==m)
						System.out.print("\tComplete match!");
				}
				else
				{
					period = k - MP_next[k];
					
					System.out.print("\tNo. push: "+period);
					break;
				}
			}
			k = MP_next[k];
			if (k<0) k = 0;
			i+=period;
			System.out.println();
		}
	}
}

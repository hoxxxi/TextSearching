
public class MorisPratt {

	static int []MP_next = {-1,0,1,2,0,1,2};

	public static void main(String[]args)
	{
		//0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7
		//A A B A A A A B A B A A A B A A B B
		//                    A A A B A A
		String y = "aabaaaababaaabaabb";
		int n = y.length();
		
		String x = "aaabaa";
		int m = x.length();

		calculateDachiStyle(x,y,m,n);
	}
	private static void calculateDachiStyle(String x, String y, int m, int n)
	{
		int k = 0;
		int i = 0;
		while (i<=n-m)
		{
			while(k<m && x.charAt(k) == y.charAt(i+k))
			{
					System.out.print("\tMatch: "+x.charAt(k));
					k++;
			}
			if(k==m)
				System.out.print("\tComplete match!");
			
			int period = k - MP_next[k];
			i=i + period;
			System.out.print("\tNo. push: "+period);
			
			k = MP_next[k];
			if (k<0) k = 0;
			System.out.println();
		}
	}
}
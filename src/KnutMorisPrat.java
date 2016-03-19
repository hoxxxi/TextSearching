
public class KnutMorisPrat {

	static int []KMP_next = {-1,0,-1,1,-1,0,-1,1,-1,0,6};

	public static void main(String[]args)
	{
		//0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5
		//A B A B A C A B A D A B D A C A A B A C A B A C A B
		//                                A B A C A B A C A B
		String y = "ababacabadabdacaabacabacab";
		int n = y.length();
		
		String x = "abacabacab";
		int m = x.length();

//		calculate(x,y,m,n);
		calculateDachiStyle(x,y,m,n);
	}
	private static void calculateDachiStyle(String x, String y, int m, int n)
	{
		for(int i = 0; i<=n-m;)
		{
			int period = 1;
			for(int k = 0; k<m; k++)
			{
				if(x.charAt(k) == y.charAt(i+k))
				{
					System.out.print("\tMatch: "+x.charAt(k));
					if(k+1==m)
						System.out.print("\tComplete match!");
				}
				else
				{
					period = k - KMP_next[k];
					
					System.out.print("\tNo. push: "+period);
					break;
				}
			}
			i+=period;
			System.out.println();
		}
	}
}


public class Naive {

	public static void main(String[]args)
	{
		//0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5
		//A A B A A A A B A B A A A B A A
		String y = "aabaaaababaaabaab";
		int n = y.length();
		
		String x = "aaabaa";
		int m = x.length();
		
		calculate(x,y,m,n);
	}

	private static void calculate(String x, String y, int m, int n) {		
		for(int pos = 0;pos<=n-m;pos++)
		{
			int i;
			for(i = 0; i<m && x.charAt(i) == y.charAt(pos+i) ;i++) {}
			if(i==m)
				System.out.println("x occurs in y at position "+pos);
		}
	}
}

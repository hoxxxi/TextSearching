
public class BorderTable {

	int[] BT;
	public static void main(String[]args)
	{
		String x = "aaabaa";
		int m = x.length();
		BorderTable BT = new BorderTable(x,m);
		

		System.out.print("i:\t");
		for(int i = 0;i<m+1;i++)
			System.out.print(i+"\t");
		System.out.println();
		

		System.out.print("x[i]:\t");
		for(String i : x.split(""))
			System.out.print(i+"\t");
		System.out.println();
		
		System.out.print("BT[i]:\t");
		for(int i :BT.BT)
			System.out.print(i+"\t");
	}
	public BorderTable(String x, int m) {
		BT = new int[m+1];
		BT[0] = -1;
		int i = 0;
		while (i<m)
		{
			int k = BT[i];
			while (k>=0 && x.charAt(i) != x.charAt(k))
			{
				k = BT[k];
			}
			BT[i+1] = k+1;
			i++;
		}
	}
}

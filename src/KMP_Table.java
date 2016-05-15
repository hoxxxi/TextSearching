
public class KMP_Table {

	int[] KMP;
	public static void main(String[]args)
	{
		String x = "abacabacab";
		int m = x.length();
		BorderTable BT = new BorderTable(x,m);
		KMP_Table KMP = new KMP_Table(x,m);
		

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
		System.out.println();
		
		System.out.print("KMP[i]:\t");
		for(int i :KMP.KMP)
			System.out.print(i+"\t");
	}
	public KMP_Table(String x, int m) {
		BorderTable BT = new BorderTable(x,m);
		x=x+"x";
		KMP = new int[m+1];
		KMP[0] = -1;
		int i = 0;
		while (i<m)
		{
			int k = BT.BT[i+1];
			while(k>=0 && x.charAt(i+1)==x.charAt(k))
			{
				k = BT.BT[k];
			}
			KMP[i+1]=k;
			i++;
		}
	}
}

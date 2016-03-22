
public class DisplacementTable {
	public static void main(String[]args)
	{
		String x = "abaaabababa";
        int m = x.length();
        int[]Suf = new int[]{1,0,3,1,1,0,3,0,5,0,11};
        int[]D = computeDisplacementTable(x,m,Suf);
        
        for(int i:D)
        	System.out.print(i+"\t");
	}
	public static int[] computeDisplacementTable(String x, int m, int[]Suf) {
		int[]D = new int[m];
		int j = 0;
		for(int i = m-2;i>=-1;i--)
		{
			if(i==-1 || Suf[i]==i+1)
			{
				while(j<m-i-1)
				{
					D[j]=m-i-1;
					j++;
				}
			}
		}
		for(int l = 0;l<=m-2;l++)
		{
			D[m-Suf[l]-1]=m-l-1;
		}
		return D;
	}
}

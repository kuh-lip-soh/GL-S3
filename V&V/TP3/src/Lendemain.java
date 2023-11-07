public class Lendemain {

	@SuppressWarnings("null")
	public int[] Calculer (int j, int m, int a) throws IllegalArgumentException {
		
		if(j>31)
			throw new IllegalArgumentException("Jour supérieur a 31");
		if(j<1)
			throw new IllegalArgumentException("Jour nul ou négatif");
		if(m>12)
			throw new IllegalArgumentException("Mois supérieur a 12");
		if(m<1)
			throw new IllegalArgumentException("Mois nul ou négatif");
		if(a>3000)
			throw new IllegalArgumentException("Année supérieur a 3000");
		if(a<1582)
			throw new IllegalArgumentException("Année inférieur a 1582");
		
		int L[] = null;
		L[1]=m;
		L[2]=a;
		
		if(j==31 && m==12)
			{
				L[0]=1;
				L[1]=1;
				L[2]++;
			}
		
		if(j==31 && (m==1 || m==3 || m==5 || m==7 || m==8 || m==10))
			{
				L[0]=1;
				L[1]++;
			}
		
		if(j==30 && (m==4 || m==6 || m==9 || m==11))
			{
				L[0]=1;
				L[1]++;
			}
		
		if(j==28 && m==2 && AnneeBissextille(a))
			{
				L[0]++;
			}
		else
			{
				L[0]=1;
				L[1]++;
			}
		

		
		return L;
	}
	
	public boolean AnneeBissextille(int a){
		
		if(a%4>0)
			return false;
		if(a%400==0)
			return true;
		else
			return false;
		
	}
	
}

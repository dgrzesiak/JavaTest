import java.util.Random;
import static java.lang.Math.*;

public class Kontrakt implements Psikus {

	@Override
	public Integer cyfrokrad(Integer liczba) {
		int len = liczba.toString().length();
		Random r = new Random(); 
		if(len<2)
		{
			return null;
		}
		else
		{
			int i = r.nextInt(len)+1;
			int w1 = Integer.parseInt(liczba.toString().substring(i-1, i));
			return w1;
		}
	}

	@Override
	public Integer hultajchochla(Integer liczba) throws NieduanyPsikusException {
		int len = liczba.toString().length();
		Random r = new Random(); 
		if(len<2)
		{
		}
		else
		{
			int wynik;
			int r1 = r.nextInt(len)+1;
			int wynik1=0;
			int z1=liczba;
			int n = 0;
			while(n!=r1)
			{
				wynik1 = z1%10;
				z1 = z1/10;
				n++;
			}
			int r2 = r.nextInt(len)+1;
			while (r1==r2)
			{
				r2 = r.nextInt(len)+1;
			}
			n=0;
			int wynik2 = 0;
			int z2 = liczba;
			while(n!=r2)
			{
				wynik2 = z2%10;
				z2=z2/10;
				n++;
			}
			int tmp = r2-1;
			while(tmp>0)
			{
				wynik1*=10;
				tmp--;
			}
			tmp = r1-1;
			while(tmp>0)
			{
				wynik2*=10;
				tmp--;
			}
			//String wynik = Integer.toString(wynik1)+Integer.toString(wynik2);
			//w = Integer.parseInt(wynik);
			wynik = wynik1+wynik2;
			
				
			return wynik;
		}
		return null;
	}

	@Override
	public Integer nieksztaltek(Integer liczba) {
		// TODO Auto-generated method stub
		return null;
	}

}

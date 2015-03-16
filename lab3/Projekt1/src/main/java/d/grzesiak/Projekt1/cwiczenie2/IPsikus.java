package d.grzesiak.Projekt1.cwiczenie2;
import java.util.Random;
public class IPsikus implements Psikus {

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
		//int w1 = Integer.parseInt(liczba.toString().substring(i-1, i));
      int w1 = 0;
      int z1=liczba;
      int n=0;
        while(n!=i)
        {
          w1 = z1%10;
	  z1 = z1/10;
	  n++;
        }
        int wynik =0;
        int rand = i;
        int tmp = rand-1;
        while(tmp>0)
        {
	  			w1*=10;
	  			tmp--;
        }
	  			wynik = liczba - w1;
	  			return wynik;
    }
  }
	public Integer hultajchochla(Integer liczba) throws NieduanyPsikusException {
		//potrzebna długość liczby
	int len = liczba.toString().length();
	Random r = new Random();
	if(len<2)
	{
	  throw new NieduanyPsikusException();
	}
	else
	{
		//ogolny wynik
	  int wynik;
		//r1 jako pozycja 1 cyfry do wymiany
	  int r1 = r.nextInt(len)+1;
		//zapamietany nr cyfry
	  int wynik1=0;
		//zmienna pomocnicza z1
	  int z1=liczba;
		//zmienna pomocnicza n
	  int n = 0;
	  while(n!=r1)
	  {
	    wynik1 = z1%10;
	    z1 = z1/10;
	    n++;
	  }
	    int r2 = r.nextInt(len)+1;
	//bedzie losowac tak długo az r1 i r2 beda od siebie rozne
	  while (r1==r2)
	  {
	    r2 = r.nextInt(len)+1;
	  }
	    n=0;
		//nasza 2 cyfra
	  int wynik2 = 0;
		//z2 rowniez zmienna pomocnicza
	  int z2 = liczba;
	  while(n!=r2)
	  {
	    wynik2 = z2%10;
	    z2=z2/10;
	    n++;
	  }
		//jest to wynik bez tych liczb
	  int wynik3=0;
		//obie zmienne pomocnicze
	  int rand1=r1;
	  int rand2=r2;
		//rowniez zmienne pomocnicze
	  int w1=wynik1;
	  int w2=wynik2;
		//warunek dla liczb o dlugosci wiekszych od 2
	  if(len>2){
	    int tmp1 = rand1-1;
	    while(tmp1>0)
	    {
	      w1*=10;
	      tmp1--;
	    }
	    int tmp2 = rand2-1;
	    while(tmp2>0)
	    {
	      w2*=10;
	      tmp2--;
	    }
	      wynik3=liczba-(w1+w2);
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
			wynik = wynik1+wynik2+wynik3;
			return wynik;
		}
		}
		/*
		3 -> 8
		7 -> 1
		6 -> 9
		*/
		public Integer nieksztaltek(Integer liczba) {
		int wynik = 0, n=0, k=0,w1=0,w2=0;
		int len = liczba.toString().length();
		int z1=liczba;
		while(n!=len+1)
		{
			n++;
			w1 = z1%10;
			z1 = z1/10;
			if(w1==3)
			{
				w1=8;
				n=len+1;
			}else if (w1 == 7)
			{
				w1 = 1;
				n=len+1;
			}
			else if (w1 == 6)
			{
				w1 = 9;
				n=len+1;
			}
				k++;
		}
		int tmp1 = k-1;
		while(tmp1>0)
		{
			w1*=10;
			tmp1--;
		}
			n=0;
			z1=liczba;
		while(n!=k)
		{
			w2 = z1%10;
			z1 = z1/10;
			n++;
		}
			tmp1 = k-1;
		while(tmp1>0)
		{
			w2*=10;
			tmp1--;
		}
			wynik = liczba - w2 + w1;
			return wynik;
	}
}

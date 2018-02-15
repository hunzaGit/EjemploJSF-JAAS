package negocio.restar.imp;
import negocio.TRes;
import negocio.restar.Restar;

public class RestarImp implements Restar {

	public TRes restar (int x, int y)
	{
		int z= x-y;
		
		if (z % 2 == 0) return new TRes(z, "par");
		else return new TRes (z, "impar");
	}
}

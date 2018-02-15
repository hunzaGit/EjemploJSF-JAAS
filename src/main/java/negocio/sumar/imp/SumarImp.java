package negocio.sumar.imp;

import negocio.TRes;
import negocio.sumar.Sumar;

public class SumarImp implements Sumar {

	
	public TRes sumar(int x, int y) {
		int z= x+y;
		if (z % 2 == 0) return new TRes(z, "par");
		else return new TRes(z, "impar");
	}

}

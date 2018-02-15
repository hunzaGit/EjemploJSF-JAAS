package negocio.imp;

import negocio.FactoriaNegocio;
import negocio.multiplicar.Multiplicar;
import negocio.multiplicar.imp.MultiplicarImp;
import negocio.restar.Restar;
import negocio.restar.imp.RestarImp;
import negocio.sumar.Sumar;
import negocio.sumar.imp.SumarImp;

public class FactoriaNegocioImp extends FactoriaNegocio {

	
	public Sumar nuevoSumar() {
	
		return new SumarImp();
	}

	public Restar nuevoRestar() {
		return new RestarImp();
	}

	public Multiplicar nuevoMultiplicar(){
		return new MultiplicarImp();
	}
}

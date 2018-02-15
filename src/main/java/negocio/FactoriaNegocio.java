package negocio;

import negocio.imp.FactoriaNegocioImp;
import negocio.multiplicar.Multiplicar;
import negocio.restar.Restar;
import negocio.sumar.Sumar;

public abstract class FactoriaNegocio {
	
	static FactoriaNegocio instancia;
	
	public static FactoriaNegocio getInstancia()
	{
		if (instancia==null) instancia= new FactoriaNegocioImp();
		
		return instancia;
	}
	
	public abstract Sumar nuevoSumar();
	
	public abstract Restar nuevoRestar();
	
	public abstract Multiplicar nuevoMultiplicar();

}

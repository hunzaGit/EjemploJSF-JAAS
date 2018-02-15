package negocio;

public class TRes {

	int z;
	String tipo;
	
	public TRes(int zP, String tipoP) {
		z=zP;
		tipo= tipoP;
	}
	
	public void setRes(int zP)
	{
		z= zP;
	}
	
	public void setTipo(String tipoP)
	{
		tipo= tipoP;
	}
	
	public int getZ()
	{
		return z;
	}
	
	public String getTipo(){
		return tipo;
	}
}

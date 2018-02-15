package presentacion.actions;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import negocio.FactoriaNegocio;
import negocio.Servicios_Usuarios.IBrokerSAUsuario;
import negocio.TRes;
import negocio.entidades.Usuario;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class NumerosAction implements Serializable {
	public String x;
	public String y;
	public int z;

	Usuario user;
    IBrokerSAUsuario portUsuarios;

    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }

    List<Usuario> lista;


	//public int evento;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public NumerosAction()
	{
		x= null;
		y= null;
		z=0;
		user = null;
		
		//evento=0;
	}
	
	public String getX()
	{
		return x;
	}
	
	public String getY()
	{
		return y;
	}
	
	public int getZ()
	{
		return z;
	}
	
	/*
	public int getEvento()
	{
		return evento;
	}
	 */
	public void setX(String xp)
	{
		x= xp;
	}
	
	public void setY(String yp)
	{
		y= yp;
	}
	
	public void setZ (int zp)
	{
		z= zp;
	}

	/*
	public void setEvento (int eP)
	{
		evento= eP;
	}


	public String accion()
	{
		String res=null;

		switch (evento){
			case Eventos.SUMAR: { res= FactoriaNegocio.getInstancia().nuevoSumar().sumar(x ,y).getTipo(); break; }
			case Eventos.RESTAR:  { res= FactoriaNegocio.getInstancia().nuevoRestar().restar(x ,y).getTipo(); break; }
			default: {res= "indice";}
		}

		return res;
	}

	*/


	public String sumar()
	{

		TRes res=  FactoriaNegocio.getInstancia().nuevoSumar().sumar(new Integer(x).intValue() ,new Integer(y).intValue());
		
		z= res.getZ();
		System.out.println("Sumando: " + this.x + " + " + this.y + " = " + this.z);

		return res.getTipo();
		
		
	}
	
	public String restar()
	{

		TRes res=  FactoriaNegocio.getInstancia().nuevoRestar().restar(new Integer(x).intValue() ,new Integer(y).intValue());

		z= res.getZ();

		System.out.println("Restando: " + this.x + " - " + this.y + " = " + this.z);
		return res.getTipo();
		
		

	}
	
	public String multiplicar()
	{
		z= FactoriaNegocio.getInstancia().nuevoMultiplicar().multiplicar(new Integer(x).intValue() ,new Integer(y).intValue());
		
		return "multiplicado";
	}

	public String saludar() throws MalformedURLException {
	    String str = "";

        {
            System.out.println("**********************************************************************");
            System.out.println("**********************************************************************");
            System.out.println("************  " + getPortUsuarios().buscarUsuarioByID(3L) + "  ************");
            System.out.println();
            //System.out.println("Listando usuarios de BBDD:");
            //portUsuarios.listarUsuarios().stream().forEach(System.out::println);
            System.out.println();
            System.out.println("**********************************************************************");
            System.out.println("**********************************************************************");

        }


        user = getPortUsuarios().buscarUsuarioByID(3L);


        System.out.println("Redirigiendo a vista...");
        return "user";
    }

    public String listar() throws MalformedURLException {

        System.out.println("listar");

        lista = getPortUsuarios().listarUsuarios();

        System.out.println("Redirigiendo a vista...");
        return "admin";
    }



    private IBrokerSAUsuario getPortUsuarios() throws MalformedURLException {

        if(portUsuarios == null) {

            QName SERVICE_USUARIOS = new QName("http://Servicio_Usuarios/", "Servicio_Usuarios.IBrokerSAUsuario");


            System.out.println("preURL");
            URL wsdlURLUsuarios = new URL("http://localhost:55556/cxf/services/SA_Usuarios?wsdl");
            System.out.println("Pre Service ss");
            Service ssUsuarios = Service.create(wsdlURLUsuarios, SERVICE_USUARIOS);
            System.out.println("pre port");
            this.portUsuarios = ssUsuarios.getPort(IBrokerSAUsuario.class);
            System.out.println("Post port");
        }

       return portUsuarios;
    }
}
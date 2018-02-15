package negocio.Servicios_Usuarios;


import negocio.entidades.Usuario;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://Servicio_Usuarios/", name = "IBrokerSAUsuario")
public interface IBrokerSAUsuario {

    @WebMethod(operationName="crearUsuario")
    public Usuario crearUsuario(@WebParam(name = "Usuario") Usuario usuarioNuevo);

    @WebMethod(operationName="buscarUsuarioByID")
    public Usuario buscarUsuarioByID(@WebParam(name = "id") Long id);


    @WebMethod(operationName="eliminarUsuario")
    public boolean eliminarUsuario(@WebParam(name = "Usuario") Usuario usuarioEliminar) ;


    @WebMethod(operationName="listarUsuarios")
    public List<Usuario> listarUsuarios();

}


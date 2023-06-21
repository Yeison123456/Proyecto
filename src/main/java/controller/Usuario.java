package controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario.UsuarioDao;
import model.Usuario.UsuarioVo;

public class Usuario extends HttpServlet{

    UsuarioVo rv=new UsuarioVo();
    UsuarioDao rd=new UsuarioDao();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String accion=req.getParameter("accion");
        System.out.println(accion);

        switch(accion){

            case "index":
            RequestDispatcher ind =req.getRequestDispatcher("index.jsp");
            ind.forward(req, resp);
            break;

            case "indexW":
            RequestDispatcher inW =req.getRequestDispatcher("views/indexW.jsp");
            inW.forward(req, resp);
            break;
    
            case "login":
            RequestDispatcher log =req.getRequestDispatcher("views/Login.jsp");
            log.forward(req, resp);
            break;

            case "home":
            RequestDispatcher hom= req.getRequestDispatcher("views/Home.jsp");
            hom.forward(req, resp);
            break;

            case "indexI":
            RequestDispatcher inI =req.getRequestDispatcher("views/IndexI.jsp");
            inI.forward(req, resp);
            break;
    
            case "loginI":
            RequestDispatcher logI =req.getRequestDispatcher("views/LoginI.jsp");
            logI.forward(req, resp);
            break;

            case "homeI":
            RequestDispatcher homI= req.getRequestDispatcher("views/HomeI.jsp");
            homI.forward(req, resp);
            break;
    
            case "usuarioC":
            RequestDispatcher usuc =req.getRequestDispatcher("views/Usuario/UsuarioC.jsp");
            usuc.forward(req, resp);
            break;

            case "usuarioM":
            RequestDispatcher usum= req.getRequestDispatcher("views/Usuario/UsuarioM.jsp");
            usum.forward(req, resp);
            break;

            case "usuarioCi":
            RequestDispatcher usuci =req.getRequestDispatcher("views/UsuarioI/UsuarioC.jsp");
            usuci.forward(req, resp);
            break;

            case "usuarioMi":
            RequestDispatcher usumi= req.getRequestDispatcher("views/UsuarioI/UsuarioM.jsp");
            usumi.forward(req, resp);
            break;

            case "abrir":
            abrirForm(req,resp);
            break;

            case "abrirI":
            abrirFormi(req,resp);
            break;

            case "usuarioL":
                listar(req,resp);
            break;
            case "usuarioLi":
                listari(req,resp);
            break;
  
        }
    }
       
    
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        System.out.println(req.getParameter("accion"));
        String accion=req.getParameter("accion");
        System.out.println(accion);
        
        switch(accion){
            case "crearU":
            add(req,resp);
            break;
            case "actualizarU":
            actualizar(req, resp);
            break;
            case "eliminar":
            eliminar(req, resp);
            break;
            case "crearUi":
            addi(req,resp);
            break;
            case "actualizarUi":
            actualizari(req, resp);
            break;
            case "eliminari":
            eliminari(req, resp);
            break;
            default:
            System.out.println("Que buscamos mi pana?"+accion);
        }
    }
    //WHATSAPP
    
    private void abrirForm(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Usuario/UsuarioC.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }
    private void add(HttpServletRequest req, HttpServletResponse resp) {

        String estado=req.getParameter("estado");
        System.out.println(estado);

        switch(estado){
            case "Activo":
            rv.setEstado("Activo");
            break;
            case "Inactivo":
            rv.setEstado("Inactivo");
            break;
            default:
            rv.setEstado("Inactivo");
            break;
        }

        if(req.getParameter("username")!=null){rv.setNombre(req.getParameter("username"));} //Para guardar en los setters los valores que se dan en el formulario
        if(req.getParameter("apellido")!=null){rv.setApellido(req.getParameter("apellido"));}
        if(req.getParameter("telefono")!=null){rv.setTelefono(Integer.parseInt(req.getParameter("telefono")));}
        if(req.getParameter("edad")!=null){rv.setEdad(Integer.parseInt(req.getParameter("edad")));}
        if(req.getParameter("NombreUsuario")!=null){rv.setNombreUsuario(req.getParameter("NombreUsuario"));}
        if(req.getParameter("password")!=null){rv.setContraseña(req.getParameter("password"));}
        
        try { 
                rd.registrar(rv); //Llamar al metodo de la clase Dao
                System.out.println("Registro insertado correctamente");
                req.getRequestDispatcher("views/Usuario/UsuarioC.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List usuario=rd.listar();//Llamar al metodo de la clase Dao
            req.setAttribute("usuario", usuario);
            req.getRequestDispatcher("views/Usuario/UsuarioL.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }

    private void actualizar(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("idUsuario")!=null) {
              rv.setIdUsuario(Integer.parseInt(req.getParameter("idUsuario")));//Para guardar en los setters los valores que se dan en el formulario
        }
        if (req.getParameter("username")!=null) {
              rv.setNombre(req.getParameter("username"));
        }
        if (req.getParameter("apellido")!=null) {
              rv.setApellido(req.getParameter("apellido"));
        } 
        if (req.getParameter("telefono")!=null) {
            rv.setTelefono(Integer.parseInt(req.getParameter("telefono")));
        } 
        if (req.getParameter("edad")!=null) {
        rv.setEdad(Integer.parseInt(req.getParameter("edad")));
        } 
        if (req.getParameter("nombreUsuario")!=null) {
            rv.setNombreUsuario(req.getParameter("nombreUsuario"));
        } 
        if (req.getParameter("password")!=null) {
        rv.setContraseña(req.getParameter("password"));
        } 
        
        String estado=req.getParameter("estado");
        System.out.println(estado);

        switch(estado){
            case "Activo":
            rv.setEstado("Activo");
            break;
            case "Inactivo":
            rv.setEstado("Inactivo");
            break;
            default:
            rv.setEstado("Inactivo");
            break;
        }
             
        try {
              rd.actualizar(rv.getIdUsuario() , rv.getNombre() , rv.getApellido(), rv.getTelefono() , rv.getEdad() , rv.getEstado(), rv.getNombreUsuario(), rv.getContraseña());
              req.setAttribute("proceso",true); 
              resp.sendRedirect("usuario?accion=usuarioL");
              System.out.println("Información actualiada exitosamente");
        } catch (Exception e) {
              req.setAttribute("msg","No se puede actualizar el registro "+e.getMessage());
             System.out.println("No se puede actualizar el registro"+e.getMessage());
        }
  }
  private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
            
    if (req.getParameter("idUsuario")!= null ) {
          rv.setIdUsuario(Integer.parseInt(req.getParameter("idUsuario")));//Para guardar en los setters los valores que se dan en el formulario
    }
    try {
          rd.Eliminar(rv.getIdUsuario());//Llamar al metodo de la clase Dao
          req.setAttribute("proceso",true);
          resp.sendRedirect("usuario?accion=usuarioL");
          System.out.println("Usuario eliminado");
    } catch (Exception e) {
          req.setAttribute("msg","No se puede eliminar el registro "+e.getMessage());
         System.out.println("No se puede eliminar el registro"+e.getMessage());
    }
}

    //INSTAGRAM

    private void abrirFormi(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/UsuarioI/UsuarioC.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }

    private void addi(HttpServletRequest req, HttpServletResponse resp) {

        String estado=req.getParameter("estado");
        System.out.println(estado);

        switch(estado){
            case "Activo":
            rv.setEstado("Activo");
            break;
            case "Inactivo":
            rv.setEstado("Inactivo");
            break;
            default:
            rv.setEstado("Inactivo");
            break;
        }

        if(req.getParameter("username")!=null){rv.setNombre(req.getParameter("username"));} 
        if(req.getParameter("apellido")!=null){rv.setApellido(req.getParameter("apellido"));}
        if(req.getParameter("telefono")!=null){rv.setTelefono(Integer.parseInt(req.getParameter("telefono")));}
        if(req.getParameter("edad")!=null){rv.setEdad(Integer.parseInt(req.getParameter("edad")));}
        if(req.getParameter("NombreUsuario")!=null){rv.setNombreUsuario(req.getParameter("NombreUsuario"));}
        if(req.getParameter("password")!=null){rv.setContraseña(req.getParameter("password"));}
        
        try { 
                rd.registrar(rv);
                System.out.println("Registro insertado correctamente");
                req.getRequestDispatcher("views/UsuarioI/UsuarioC.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }

    private void listari(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List usuario=rd.listar();
            req.setAttribute("usuario", usuario);
            req.getRequestDispatcher("views/UsuarioI/UsuarioL.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }

    private void actualizari(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("idUsuario")!=null) {
              rv.setIdUsuario(Integer.parseInt(req.getParameter("idUsuario")));
        }
        if (req.getParameter("username")!=null) {
              rv.setNombre(req.getParameter("username"));
        }
        if (req.getParameter("apellido")!=null) {
              rv.setApellido(req.getParameter("apellido"));
        } 
        if (req.getParameter("telefono")!=null) {
            rv.setTelefono(Integer.parseInt(req.getParameter("telefono")));
        } 
        if (req.getParameter("edad")!=null) {
        rv.setEdad(Integer.parseInt(req.getParameter("edad")));
        } 
        if (req.getParameter("nombreUsuario")!=null) {
            rv.setNombreUsuario(req.getParameter("nombreUsuario"));
        } 
        if (req.getParameter("password")!=null) {
        rv.setContraseña(req.getParameter("password"));
        } 
        
        String estado=req.getParameter("estado");
        System.out.println(estado);

        switch(estado){
            case "Activo":
            rv.setEstado("Activo");
            break;
            case "Inactivo":
            rv.setEstado("Inactivo");
            break;
            default:
            rv.setEstado("Inactivo");
            break;
        }
             
        try {
              rd.actualizar(rv.getIdUsuario() , rv.getNombre() , rv.getApellido(), rv.getTelefono() , rv.getEdad() , rv.getEstado(), rv.getNombreUsuario(), rv.getContraseña());
              req.setAttribute("proceso",true);
              resp.sendRedirect("usuario?accion=usuarioLi");
              System.out.println("Información actualiada exitosamente");
        } catch (Exception e) {
              req.setAttribute("msg","No se puede actualizar el registro "+e.getMessage());
             System.out.println("No se puede actualizar el registro"+e.getMessage());
        }
  }
  private void eliminari(HttpServletRequest req, HttpServletResponse resp) {
            
    if (req.getParameter("idUsuario")!= null ) {
          rv.setIdUsuario(Integer.parseInt(req.getParameter("idUsuario")));
    }
    try {
          rd.Eliminar(rv.getIdUsuario());
          req.setAttribute("proceso",true);
          resp.sendRedirect("usuario?accion=usuarioLi");
          System.out.println("Usuario eliminado");
    } catch (Exception e) {
          req.setAttribute("msg","No se puede eliminar el registro "+e.getMessage());
         System.out.println("No se puede eliminar el registro"+e.getMessage());
    }
}


}

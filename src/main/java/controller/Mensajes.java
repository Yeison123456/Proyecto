package controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Mensajes.MensajeDao;
import model.Mensajes.MensajeVo;

public class Mensajes extends HttpServlet{

    MensajeVo rv=new MensajeVo();
    MensajeDao rd=new MensajeDao();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String accion=req.getParameter("accion");
        System.out.println(accion);

        switch(accion){
    
            case "MensajeC":
            RequestDispatcher menc =req.getRequestDispatcher("views/Mensajes/MensajeC.jsp");
            menc.forward(req, resp);
            break;

            case "MensajeM":
            RequestDispatcher menm= req.getRequestDispatcher("views/Mensajes/MensajeM.jsp");
            menm.forward(req, resp);
            break;

            case "MensajeCi":
            RequestDispatcher menci =req.getRequestDispatcher("views/MensajesI/MensajeC.jsp");
            menci.forward(req, resp);
            break;

            case "MensajeMi":
            RequestDispatcher menmi= req.getRequestDispatcher("views/MensajesI/MensajeM.jsp");
            menmi.forward(req, resp);
            break;

            case "abrir":
            abrirForm(req,resp);
            break;

            case "abrirI":
            abrirFormi(req,resp);
            break;

            case "MensajeL":
                listar(req,resp);
            break;
  
             case "MensajeLi":
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

            case "crearM":
                add(req,resp);
            break;

            case "actualizarM":
            actualizar(req, resp);
          break;

          case "eliminar":
            eliminar(req, resp);
          break;

            case "crearMi":
                addi(req,resp);
            break;
            
            case "actualizarMi":
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
            req.getRequestDispatcher("views/Mensajes/MensajeC.jsp").forward(req, resp);
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

        if(req.getParameter("img")!=null || req.getParameter("video")==null){rv.setImg(req.getParameter("img"));} 
        if(req.getParameter("video")!=null || req.getParameter("video")==null){rv.setVideo(req.getParameter("video"));}
        if(req.getParameter("comentario")!=null || req.getParameter("video")==null){rv.setMensaje(req.getParameter("comentario"));}
        
        try { 
                rd.registrar(rv);
                System.out.println("Registro insertado correctamente");
                req.getRequestDispatcher("views/Mensajes/MensajeC.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List mensaje=rd.listar();
            req.setAttribute("mensaje", mensaje);
            req.getRequestDispatcher("views/Mensajes/MensajeL.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }

    private void actualizar(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("idMensaje")!=null) {
              rv.setIdMensaje(Integer.parseInt(req.getParameter("idMensaje")));
        }
        if (req.getParameter("img")!=null) {
              rv.setImg(req.getParameter("img"));
        }
        if (req.getParameter("video")!=null) {
              rv.setVideo(req.getParameter("video"));
        } 
        if (req.getParameter("comentario")!=null) {
            rv.setMensaje(req.getParameter("comentario"));
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
              rd.actualizar(rv.getIdMensaje() , rv.getImg() , rv.getVideo(), rv.getMensaje(), rv.getMensaje());
              req.setAttribute("proceso",true);
              resp.sendRedirect("mensajes?accion=MensajeL");
              System.out.println("Información actualiada exitosamente");
        } catch (Exception e) {
              req.setAttribute("msg","No se puede actualizar el registro "+e.getMessage());
             System.out.println("No se puede actualizar el registro"+e.getMessage());
        }
  }
  private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
            
    if (req.getParameter("idMensaje")!= null ) {
          rv.setIdMensaje(Integer.parseInt(req.getParameter("idMensaje")));
    }
    try {
          rd.Eliminar(rv.getIdMensaje());
          req.setAttribute("proceso",true);
          resp.sendRedirect("mensajes?accion=MensajeL");
          System.out.println("Mensaje eliminado");
    } catch (Exception e) {
          req.setAttribute("msg","No se puede eliminar el registro "+e.getMessage());
         System.out.println("No se puede eliminar el registro"+e.getMessage());
    }
}

//INSTAGRAM

    private void abrirFormi(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/MensajesI/MensajeC.jsp").forward(req, resp);
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

        if(req.getParameter("img")!=null || req.getParameter("video")==null){rv.setImg(req.getParameter("img"));} 
        if(req.getParameter("video")!=null || req.getParameter("video")==null){rv.setVideo(req.getParameter("video"));}
        if(req.getParameter("comentario")!=null || req.getParameter("video")==null){rv.setMensaje(req.getParameter("comentario"));}
        
        try { 
                rd.registrar(rv);
                System.out.println("Registro insertado correctamente");
                req.getRequestDispatcher("views/MensajesI/MensajeC.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }

    private void listari(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List mensaje=rd.listar();
            req.setAttribute("mensaje", mensaje);
            req.getRequestDispatcher("views/MensajesI/MensajeL.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }

    private void actualizari(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("idMensaje")!=null) {
              rv.setIdMensaje(Integer.parseInt(req.getParameter("idMensaje")));
        }
        if (req.getParameter("img")!=null) {
              rv.setImg(req.getParameter("img"));
        }
        if (req.getParameter("video")!=null) {
              rv.setVideo(req.getParameter("video"));
        } 
        if (req.getParameter("comentario")!=null) {
            rv.setMensaje(req.getParameter("comentario"));
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
              rd.actualizar(rv.getIdMensaje() , rv.getImg() , rv.getVideo(), rv.getMensaje(), rv.getMensaje());
              req.setAttribute("proceso",true);
              resp.sendRedirect("mensajes?accion=MensajeLi");
              System.out.println("Información actualiada exitosamente");
        } catch (Exception e) {
              req.setAttribute("msg","No se puede actualizar el registro "+e.getMessage());
             System.out.println("No se puede actualizar el registro"+e.getMessage());
        }
  }
  private void eliminari(HttpServletRequest req, HttpServletResponse resp) {
            
    if (req.getParameter("idMensaje")!= null ) {
          rv.setIdMensaje(Integer.parseInt(req.getParameter("idMensaje")));
         System.out.println("Entro a la condicion"+ req.getParameter("idMensaje"));
        }
    try {
          rd.Eliminar(rv.getIdMensaje());
          req.setAttribute("proceso",true);
          resp.sendRedirect("mensajes?accion=MensajeLi");
          System.out.println("Mensaje eliminado");
    } catch (Exception e) {
          req.setAttribute("msg","No se puede eliminar el registro "+e.getMessage());
         System.out.println("No se puede eliminar el registro"+e.getMessage());
    }
}

}


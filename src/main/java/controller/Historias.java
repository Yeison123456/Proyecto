package controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Historias.HistoriasDao;
import model.Historias.HistoriasVo;

public class Historias extends HttpServlet{

    HistoriasVo rv=new HistoriasVo();
    HistoriasDao rd=new HistoriasDao();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String accion=req.getParameter("accion");
        System.out.println(accion);

        switch(accion){
    
            case "HistoriaC":
            RequestDispatcher hisc =req.getRequestDispatcher("views/Historias/HistoriaC.jsp");
            hisc.forward(req, resp);
            break;

            case "HistoriaM":
            RequestDispatcher hism= req.getRequestDispatcher("views/Historias/HistoriaM.jsp");
            hism.forward(req, resp);
            break;

            case "HistoriaCi":
            RequestDispatcher hisci =req.getRequestDispatcher("views/HistoriasI/HistoriaC.jsp");
            hisci.forward(req, resp);
            break;

            case "HistoriaMi":
            RequestDispatcher hismi= req.getRequestDispatcher("views/HistoriasI/HistoriaM.jsp");
            hismi.forward(req, resp);
            break;

            case "abrir":
            abrirForm(req,resp);
            break;

            case "abrirI":
            abrirFormi(req,resp);
            break;

            case "HistoriaL":
                listar(req,resp);
            break;

            case "HistoriaLi":
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
            case "crearH":
                add(req,resp);
            break;

            case "actualizarH":
            actualizar(req, resp);
          break;

          case "eliminar":
          eliminar(req, resp);
          break;

          case "crearHi":
                addi(req,resp);
            break;
            
            case "actualizarHi":
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
            req.getRequestDispatcher("views/Historias/HistoriaC.jsp").forward(req, resp);
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
                req.getRequestDispatcher("views/Historias/HistoriaC.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List historia=rd.listar();
            req.setAttribute("historia", historia);
            req.getRequestDispatcher("views/Historias/HistoriaL.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }

    private void actualizar(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("idHistoria")!=null) {
              rv.setIdHistoria(Integer.parseInt(req.getParameter("idHistoria")));
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
              rd.actualizar(rv.getIdHistoria() , rv.getImg() , rv.getVideo(), rv.getMensaje(), rv.getMensaje());
              req.setAttribute("proceso",true);
              resp.sendRedirect("historias?accion=HistoriaL");
              System.out.println("Información actualiada exitosamente");
        } catch (Exception e) {
              req.setAttribute("msg","No se puede actualizar el registro "+e.getMessage());
             System.out.println("No se puede actualizar el registro"+e.getMessage());
        }
  }
  private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
            
    if (req.getParameter("idHistoria")!= null ) {
          rv.setIdHistoria(Integer.parseInt(req.getParameter("idHistoria")));
    }
    try {
          rd.Eliminar(rv.getIdHistoria());
          req.setAttribute("proceso",true);
          resp.sendRedirect("historias?accion=HistoriaL");
          System.out.println("Mensaje eliminado");
    } catch (Exception e) {
          req.setAttribute("msg","No se puede eliminar el registro "+e.getMessage());
         System.out.println("No se puede eliminar el registro"+e.getMessage());
    }
}

//INSTAGRAM

    private void abrirFormi(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/HistoriasI/HistoriaC.jsp").forward(req, resp);
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
                req.getRequestDispatcher("views/HistoriasI/HistoriaC.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }

    private void listari(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List historia=rd.listar();
            req.setAttribute("historia", historia);
            req.getRequestDispatcher("views/HistoriasI/HistoriaL.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }

    private void actualizari(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("idHistoria")!=null) {
              rv.setIdHistoria(Integer.parseInt(req.getParameter("idHistoria")));
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
              rd.actualizar(rv.getIdHistoria() , rv.getImg() , rv.getVideo(), rv.getMensaje(), rv.getMensaje());
              req.setAttribute("proceso",true);
              resp.sendRedirect("historias?accion=HistoriaLi");
              System.out.println("Información actualiada exitosamente");
        } catch (Exception e) {
              req.setAttribute("msg","No se puede actualizar el registro "+e.getMessage());
             System.out.println("No se puede actualizar el registro"+e.getMessage());
        }
  }
  private void eliminari(HttpServletRequest req, HttpServletResponse resp) {
            
    if (req.getParameter("idHistoria")!= null ) {
          rv.setIdHistoria(Integer.parseInt(req.getParameter("idHistoria")));
    }
    try {
          rd.Eliminar(rv.getIdHistoria());
          req.setAttribute("proceso",true);
          resp.sendRedirect("historias?accion=HistoriaLi");
          System.out.println("Mensaje eliminado");
    } catch (Exception e) {
          req.setAttribute("msg","No se puede eliminar el registro "+e.getMessage());
         System.out.println("No se puede eliminar el registro"+e.getMessage());
    }
}

}
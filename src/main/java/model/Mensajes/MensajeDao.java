package model.Mensajes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.conexion;

public class MensajeDao {
    
    Connection con; //Objeto de conexion
    PreparedStatement ps;  //Preparar sentencias
    ResultSet rs;  //Almacenar consultas
    String sql=null;  
    int r; //Cantidad de filas que devulve un sentencias

    public int registrar(MensajeVo mensaje) throws SQLException{
        sql="INSERT INTO mensajes(imagen, Video, Mensaje, estado) values(?,?,?,?)";
        try{
            con=conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            ps.setString(1, mensaje.getImg());
            ps.setString(2, mensaje.getVideo());
            ps.setString(3, mensaje.getMensaje());
            ps.setString(4, mensaje.getEstado());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se registró el mensaje correctamente");
        }catch(Exception e){
            System.out.println("Error en el mensaje "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
        }

    public List<MensajeVo> listar() throws SQLException{
        List<MensajeVo> mensaje=new ArrayList<>();
        sql="SELECT * FROM mensajes"; //Sentencia
        try {
            con=conexion.conectar(); //Abrir conexion
            ps=con.prepareStatement(sql); //preparar sentencia
            rs=ps.executeQuery(sql);// guardar el resultado de la sentencia
            while(rs.next()){
                MensajeVo r=new MensajeVo();
                //Escribir  en el setter cada valor encontrado
                r.setIdMensaje(rs.getInt("idMensaje"));
                r.setImg(rs.getString("imagen"));
                r.setVideo(rs.getString("Video"));
                r.setMensaje(rs.getString("Mensaje"));
                r.setEstado(rs.getString("estado"));
                mensaje.add(r);
            }
            ps.close(); //Cerramos la sentencia
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
        }
        finally{
            con.close(); //Cerrando conexion
        }

        return mensaje;
    }

    public void actualizar(int idMensaje, String img, String video, String mensaje, String estado) throws SQLException{
        sql="UPDATE `Mensajes` SET `imagen`='"+img+"',`video`='"+video+"',`Mensaje`='"+mensaje+"',`Estado`='"+estado+"' Where idMensaje="+idMensaje;
        try {
            con=conexion.conectar();//Abrir conexion
            ps=con.prepareStatement(sql); //Preparar la sentencia
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close();//Cerramos sentencia
            System.out.print("Se actualizo el mensaje exitosamente");

        } catch (Exception e) {
            System.out.println("Error al actualizar registro "+e.getMessage().toString());
        }finally{
            con.close();//Cerramos conexion
        }
    }

    public void Eliminar(int idMensaje) throws SQLException {
        sql="DELETE FROM Mensajes WHERE idMensaje="+idMensaje; //Sentencia
        try {
            con=conexion.conectar(); //Abrir conexion   
            ps=con.prepareStatement(sql); //Preparar la sentencia
            ps.executeUpdate(); //Ejecutar la sentencia
            ps.close(); //Cerramos sentencia
            System.out.print("Se elimino el mensaje que tiene el id:"+idMensaje+ " exitosamente ");

        } catch (Exception e) {
            System.out.println("Error al eliminar mensaje "+e.getMessage().toString());
        }finally{
            con.close();//Cerramos conexion
        }
    
    }
    }


//``''


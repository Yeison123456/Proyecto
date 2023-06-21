package model.Historias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.conexion;

public class HistoriasDao {
    
    Connection con; //Objeto de conexion
    PreparedStatement ps;  //Preparar sentencias
    ResultSet rs;  //Almacenar consultas
    String sql=null;  
    int r; //Cantidad de filas que devulve un sentencias

    public int registrar(HistoriasVo historia) throws SQLException{
        sql="INSERT INTO historias(imagen, Video, Mensaje, estado) values(?,?,?,?)";
        try{
            con=conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            ps.setString(1, historia.getImg());
            ps.setString(2, historia.getVideo());
            ps.setString(3, historia.getMensaje());
            ps.setString(4, historia.getEstado());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se registró la historia correctamente");
        }catch(Exception e){
            System.out.println("Error en el mensaje "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
        }

    public List<HistoriasVo> listar() throws SQLException{
        List<HistoriasVo> historia=new ArrayList<>();
        sql="SELECT * FROM historias";
        try {
            con=conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                HistoriasVo r=new HistoriasVo();
                //Escribir  en el setter cada valor encontrado
                r.setIdHistoria(rs.getInt("idHistorias"));
                r.setImg(rs.getString("imagen"));
                r.setVideo(rs.getString("Video"));
                r.setMensaje(rs.getString("Mensaje"));
                r.setEstado(rs.getString("estado"));
                historia.add(r);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return historia;
    }

    public void actualizar(int idHistoria, String img, String video, String mensaje, String estado) throws SQLException{
        sql="UPDATE `Historias` SET `imagen`='"+img+"',`video`='"+video+"',`Mensaje`='"+mensaje+"',`Estado`='"+estado+"' Where idHistorias="+idHistoria;
        try {
            con=conexion.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            System.out.print("Se actualizo la historia exitosamente");

        } catch (Exception e) {
            System.out.println("Error al actualizar registro "+e.getMessage().toString());
        }finally{
            con.close();
        }
    }

    public void Eliminar(int idHistoria) throws SQLException {
        sql="DELETE FROM Historias WHERE idHistorias="+idHistoria;
        try {
            con=conexion.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            System.out.print("Se elimino la historia exitosamente");

        } catch (Exception e) {
            System.out.println("Error al eliminar historia "+e.getMessage().toString());
        }finally{
            con.close();
        }
    
    }
    }


//``''

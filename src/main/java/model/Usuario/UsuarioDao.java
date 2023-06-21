package model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.conexion;

public class UsuarioDao {
    
    Connection con; //Objeto de conexion
    PreparedStatement ps;  //Preparar sentencias
    ResultSet rs;  //Almacenar consultas
    String sql=null;  
    int r; //Cantidad de filas que devulve un sentencias

    public int registrar(UsuarioVo usuario) throws SQLException{
        sql="INSERT INTO Usuario(Nombre, Apellido, Telefono, Edad, Estado, Nombre_Usuario, Contraseña) values(?,?,?,?,?,?,?)"; //Sentencia
        try{
            con=conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setInt(3, usuario.getTelefono());
            ps.setInt(4, usuario.getEdad());
            ps.setString(5, usuario.getEstado());
            ps.setString(6, usuario.getNombreUsuario());
            ps.setString(7, usuario.getContraseña());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se registró el usuario correctamente");
        }catch(Exception e){
            System.out.println("Error en el regisro "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
        }

    public List<UsuarioVo> listar() throws SQLException{
        List<UsuarioVo> usuario=new ArrayList<>();
        sql="SELECT * FROM Usuario"; //Sentencia
        try {
            con=conexion.conectar(); //Abrir conexion
            ps=con.prepareStatement(sql); //preparar sentencia
            rs=ps.executeQuery(sql); //guarda el resultado de la sentencia
            while(rs.next()){
                UsuarioVo r=new UsuarioVo();
                //Escribir  en el setter cada valor encontrado
                r.setIdUsuario(rs.getInt("idUsuario"));
                r.setNombre(rs.getString("Nombre"));
                r.setApellido(rs.getString("Apellido"));
                r.setTelefono(rs.getInt("Telefono"));
                r.setEdad(rs.getInt("Edad"));
                r.setEstado(rs.getString("Estado"));
                r.setNombreUsuario(rs.getString("Nombre_Usuario"));
                r.setContraseña(rs.getString("Contraseña"));
                usuario.add(r);
            }
            ps.close(); //cerramos la sentencia
            System.out.println("consulta exitosa"); 
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
        }
        finally{
            con.close(); //Cerrando conexion
        }

        return usuario;
    }

    public void actualizar(int idUsuario, String nombre, String apellido, int telefono, int edad, String estado, String nombreUsuario, String contraseña ) throws SQLException{
        sql="UPDATE `Usuario` SET `Nombre`='"+nombre+"',`Apellido`='"+apellido+"',`Telefono`='"+telefono+"',`Edad`='"+edad+"',`Estado`='"+estado+"',`Nombre_Usuario`='"+nombreUsuario+"',`Contraseña`='"+contraseña+"' Where idUsuario="+idUsuario;
        try {
            con=conexion.conectar(); //Abrir conexion
            ps=con.prepareStatement(sql); //Preparar la sentencia
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); // Cerramos sentencia
            System.out.print("Se actualizo el genero exitosamente");
        } catch (Exception e) {
            System.out.println("Error al actualizar registro "+e.getMessage().toString());
        }finally{
            con.close(); //Cerramos conexion
        }
    }

    public void Eliminar(int idUsuario) throws SQLException {
        sql="DELETE FROM Usuario WHERE idUsuario="+idUsuario; //Sentencia
        try {
            con=conexion.conectar(); //Abrir conexion
            ps=con.prepareStatement(sql); //Preparar la sentencia   
            ps.executeUpdate(); //Ejecutar la sentencia 
            ps.close(); //Cerramos sentencia
            System.out.print("Se elimino el usuario exitosamente");

        } catch (Exception e) {
            System.out.println("Error al eliminar usuario "+e.getMessage().toString());
        }finally{
            con.close(); //Cerramos conexion
        }
    
    }
    }


//``''

package inscripcionesDTO;

import org.example.InscripcionesEntity;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Crud {
    private Connection conn;

    public Crud() {
        try {
            String url = "jdbc:postgresql://localhost:5432/bdfinal";
            String user = "prax";
            String password = "17935906";

            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Create
    public void agregarInscripcion(InscripcionesEntity inscripcion) {
        String SQL = "INSERT INTO inscripciones(id_inscripcion, id_estudiante, id_curso, fecha_inscripcion) "
                + "VALUES(?,?,?,?)";

        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, inscripcion.getIdInscripcion());
            pstmt.setInt(2, inscripcion.getIdEstudiante());
            pstmt.setInt(3, inscripcion.getIdCurso());
            pstmt.setDate(4, new java.sql.Date(inscripcion.getFechaInscripcion().getTime()));

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Read
    public InscripcionesEntity leerInscripcion(int idInscripcion) {
        InscripcionesEntity inscripcion = null;
        String SQL = "SELECT * FROM inscripciones WHERE id_inscripcion = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, idInscripcion);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                inscripcion = new InscripcionesEntity();
                inscripcion.setIdInscripcion(rs.getInt("id_inscripcion"));
                inscripcion.setIdEstudiante(rs.getInt("id_estudiante"));
                inscripcion.setIdCurso(rs.getInt("id_curso"));
                inscripcion.setFechaInscripcion(rs.getDate("fecha_inscripcion"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return inscripcion;
    }

    // Update
    public void actualizarInscripcion(InscripcionesEntity inscripcion) {
        String SQL = "UPDATE inscripciones SET id_estudiante = ?, id_curso = ?, fecha_inscripcion = ? WHERE id_inscripcion = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, inscripcion.getIdEstudiante());
            pstmt.setInt(2, inscripcion.getIdCurso());
            pstmt.setDate(3, new java.sql.Date(inscripcion.getFechaInscripcion().getTime()));
            pstmt.setInt(4, inscripcion.getIdInscripcion());

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Delete
    public void eliminarInscripcion(int idInscripcion) {
        String SQL = "DELETE FROM inscripciones WHERE id_inscripcion = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, idInscripcion);

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

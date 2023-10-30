package org.example;

import java.util.Collection;
import java.util.Objects;

public class EstudiantesEntity {
    private int idEstudiante;
    private String nombre;
    private String apellido;
    private String email;
    private Collection<InscripcionesEntity> inscripcionesByIdEstudiante;

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstudiantesEntity that = (EstudiantesEntity) o;
        return idEstudiante == that.idEstudiante && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstudiante, nombre, apellido, email);
    }

    public Collection<InscripcionesEntity> getInscripcionesByIdEstudiante() {
        return inscripcionesByIdEstudiante;
    }

    public void setInscripcionesByIdEstudiante(Collection<InscripcionesEntity> inscripcionesByIdEstudiante) {
        this.inscripcionesByIdEstudiante = inscripcionesByIdEstudiante;
    }
}

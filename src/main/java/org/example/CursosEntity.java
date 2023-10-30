package org.example;

import java.util.Collection;
import java.util.Objects;

public class CursosEntity {
    private int idCurso;
    private String nombreCurso;
    private String profesor;
    private Collection<InscripcionesEntity> inscripcionesByIdCurso;

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursosEntity that = (CursosEntity) o;
        return idCurso == that.idCurso && Objects.equals(nombreCurso, that.nombreCurso) && Objects.equals(profesor, that.profesor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCurso, nombreCurso, profesor);
    }

    public Collection<InscripcionesEntity> getInscripcionesByIdCurso() {
        return inscripcionesByIdCurso;
    }

    public void setInscripcionesByIdCurso(Collection<InscripcionesEntity> inscripcionesByIdCurso) {
        this.inscripcionesByIdCurso = inscripcionesByIdCurso;
    }
}

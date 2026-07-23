/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.model;

import java.util.Objects;

/**
 *
 * @author Esteban Basurto, CodeBreakers, @ESPE
 */
public class Material {
    private String id;
    private String title;
    private String fileType;

    public Material() {
    }
    
    public Material(String id, String title, String fileType) {
        this.id = id;
        this.title = title;
        this.fileType = fileType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", fileType='" + fileType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return Objects.equals(id, material.id) &&
               Objects.equals(title, material.title) &&
               Objects.equals(fileType, material.fileType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, fileType);
    }
}

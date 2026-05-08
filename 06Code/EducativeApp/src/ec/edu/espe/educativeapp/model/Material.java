/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.educativeapp.model;

import java.util.Date;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class Material {
    private String title;
    private String typeOfMaterial;
    private int size;
    private Date uploadDate;

    public Material(String title, String typeOfMaterial, int size, Date uploadDate) {
        this.title = title;
        this.typeOfMaterial = typeOfMaterial;
        this.size = size;
        this.uploadDate = uploadDate;
    }

    @Override
    public String toString() {
        return "Material{" + "title=" + title + ", typeOfMaterial=" + typeOfMaterial + ", size=" + size + ", uploadDate=" + uploadDate + '}';
    }

    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the typeOfMaterial
     */
    public String getTypeOfMaterial() {
        return typeOfMaterial;
    }

    /**
     * @param typeOfMaterial the typeOfMaterial to set
     */
    public void setTypeOfMaterial(String typeOfMaterial) {
        this.typeOfMaterial = typeOfMaterial;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the uploadDate
     */
    public Date getUploadDate() {
        return uploadDate;
    }

    /**
     * @param uploadDate the uploadDate to set
     */
    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }
    
    
}

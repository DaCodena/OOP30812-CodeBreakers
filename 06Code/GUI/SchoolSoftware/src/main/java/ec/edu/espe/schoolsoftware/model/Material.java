/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.model;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class Material {

    private String id;
    private String title;
    private String fileType;

    public Material(String id, String title, String fileType) {
        this.id = id;
        this.title = title;
        this.fileType = fileType;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getFileType() {
        return fileType;
    }
}
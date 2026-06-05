/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.educativesoftware.model;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
import java.time.LocalDate;

public class Material {

    private String materialId;
    private String title;
    private String type;
    private LocalDate uploadDate;
    private String filePath;

    public Material() {
    }

    public Material(String materialId, String title,
            String type, LocalDate uploadDate,
            String filePath) {

        this.materialId = materialId;
        this.title = title;
        this.type = type;
        this.uploadDate = uploadDate;
        this.filePath = filePath;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDate uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
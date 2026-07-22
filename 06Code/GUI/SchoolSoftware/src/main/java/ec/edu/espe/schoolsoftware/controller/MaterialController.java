package ec.edu.espe.schoolsoftware.controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ec.edu.espe.schoolsoftware.model.Course;
import ec.edu.espe.schoolsoftware.model.Material;
import ec.edu.espe.schoolsoftware.repository.ICrudOperations;
import ec.edu.espe.schoolsoftware.repository.MaterialRepository;
import ec.edu.espe.schoolsoftware.utils.MongoConnection;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Esteban Basurto, CodeBreakers, @ESPE
 */
public class MaterialController implements ICreate<Material> {

    private ICrudOperations<Material> materialRepository;

    public MaterialController(ICrudOperations<Material> materialRepository) {
        this.materialRepository = materialRepository;
    }

    public MaterialController() {
    }

    @Override
    public Material create(Course course) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void download(Material material) {
        //TODO algorithm to download file
    }

    //Getter y Setter orientados a la interfaz (ICrudOperations)
    public ICrudOperations<Material> getMaterialRepository() {
        return materialRepository;
    }

    public void setMaterialRepository(ICrudOperations<Material> materialRepository) {
        this.materialRepository = materialRepository;
    }

}

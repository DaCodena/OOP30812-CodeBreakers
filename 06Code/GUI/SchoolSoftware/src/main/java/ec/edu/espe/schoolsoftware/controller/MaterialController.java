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
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class MaterialController implements ICreate<Material> {
    
    //Constructor actualizado
    private ICrudOperations<Material> materialRepository;
    
    //Cambia el parametro y constructor
    public MaterialController(ICrudOperations<Material> materialRepository) {
        this.materialRepository = materialRepository;
    }
    
    //Codigo antiguo
    /*
    private MaterialRepository materialRepository;

    public MaterialController() {
        materialRepository = new MaterialRepository();
    }
*/
    @Override
    public Material create(Course course) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void download(Material material){
        //TODO algorithm to download file
    }
    
    //Antes retornaba MaterialController
    public ICrudOperations<Material> getMaterialRepository() {
        return materialRepository;
    }

    public void setMaterialRepository(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }
}

package ec.edu.espe.schoolsoftware.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.schoolsoftware.model.Student;
import ec.edu.espe.schoolsoftware.utils.MongoConnection;
import org.bson.Document;
/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class StudentController implements CrudOperations<Student>{

    @Override
    public void save(Student student) {
        MongoDatabase database = MongoConnection.getDatabase();

        MongoCollection<Document> collection = database.getCollection("students");
        
        Document birthDate = new Document()
                .append("day", student.getDay())
                .append("month", student.getMonth())
                .append("year", student.getYear());

        Document document = new Document()
                .append("_id", student.getId())
                .append("firstName", student.getFirstName())
                .append("lastName", student.getLastName())
                .append("birthDate", birthDate);

        collection.insertOne(document);
        
    }

    
}

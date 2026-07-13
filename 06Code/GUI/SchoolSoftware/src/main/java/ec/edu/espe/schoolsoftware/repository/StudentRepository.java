/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import ec.edu.espe.schoolsoftware.model.Student;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.bson.Document;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class StudentRepository extends BaseRepository implements ICrudOperations<Student>, IFindBySurname<Student> {
    
    private final MongoCollection<Document> collection;

    public StudentRepository(){
        collection = getCollection("students");
    }
    
    @Override
    public void save(Student student) {
        
        Document birthDate = new Document()
                .append("day", student.getDay())
                .append("month", student.getMonth())
                .append("year", student.getYear());

        Document document = new Document()
                .append("_id", student.getId())
                .append("names", student.getNames())
                .append("surnames", student.getSurnames())
                .append("birthDate", birthDate);

        collection.insertOne(document);
    }

    @Override
    public ArrayList<Student> read() {
        
        ArrayList<Student> students = new ArrayList<>();
        FindIterable<Document> documents = collection.find();

        for (Document doc : documents) {
            Document birthDate = (Document) doc.get("birthDate");

            Student student = new Student(
                    doc.getString("_id"),
                    doc.getString("names"),
                    doc.getString("surnames"),
                    birthDate.getInteger("day"),
                    birthDate.getString("month"),
                    birthDate.getInteger("year")
            );

            students.add(student);
        }

        return students;
    }

    @Override
    public void update(Student student) {
        
        Document birthDate = new Document()
                .append("day", student.getDay())
                .append("month", student.getMonth())
                .append("year", student.getYear());
        
        Document update = new Document("$set",
                new Document("names", student.getNames())
                        .append("surnames", student.getSurnames())
                        .append("birthDate", birthDate)
        );

        collection.updateOne(Filters.eq("_id", student.getId()), update);
    }

    @Override
    public void delete(String id) {
        collection.deleteOne(Filters.eq("_id", id));
    }

    @Override
    public Student findById(String id) {
        
        Document doc = collection.find(Filters.eq("_id", id)).first();

        if (doc == null) {
            return null;
        }

        Document birthDate = (Document) doc.get("birthDate");

        Student student = new Student(doc.getString("_id"),
                doc.getString("names"),
                doc.getString("surnames"),
                birthDate.getInteger("day"),
                birthDate.getString("month"),
                birthDate.getInteger("year")
        );

        return student;
    }

    @Override
    public ArrayList<Student> findBySurname(String surname) {
        ArrayList<Student> students = new ArrayList<>();

        Pattern pattern = Pattern.compile(surname, Pattern.CASE_INSENSITIVE);
        FindIterable<Document> documents = collection.find(Filters.regex("surnames", pattern));

        for (Document doc : documents) {
            Document birthDate = (Document) doc.get("birthDate");
            students.add(
                    new Student(
                            doc.getString("_id"),
                            doc.getString("names"),
                            doc.getString("surnames"),
                            birthDate.getInteger("day"),
                            birthDate.getString("month"),
                            birthDate.getInteger("year")
                    )
            );
        }

        return students;
    }

}

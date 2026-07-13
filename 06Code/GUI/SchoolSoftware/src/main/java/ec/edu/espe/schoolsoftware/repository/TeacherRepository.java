/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import ec.edu.espe.schoolsoftware.model.Teacher;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.bson.Document;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class TeacherRepository extends BaseRepository implements ICrudOperations<Teacher>, IFindBySurname<Teacher>{
    private final MongoCollection<Document> collection;

    public TeacherRepository(){
        collection = getCollection("teachers");
    }
    @Override
    public void save(Teacher teacher) {
        Document document = new Document()
                .append("_id", teacher.getId())
                .append("names", teacher.getNames())
                .append("surnames", teacher.getSurnames())
                .append("profession", teacher.getProfession());

        collection.insertOne(document);
    }

    @Override
    public ArrayList<Teacher> read() {
        ArrayList<Teacher> teachers = new ArrayList<>();
        FindIterable<Document> documents = collection.find();

        for (Document doc : documents) {
            Teacher teacher = new Teacher(
                    doc.getString("_id"),
                    doc.getString("names"),
                    doc.getString("surnames"),
                    doc.getString("profession")
            );

            teachers.add(teacher);
        }

        return teachers;
    }

    @Override
    public void update(Teacher teacher) {
        Document update = new Document("$set",
                new Document("names", teacher.getNames())
                        .append("surnames", teacher.getSurnames())
                        .append("profession", teacher.getProfession())
        );

        collection.updateOne(Filters.eq("_id", teacher.getId()), update);
    }

    @Override
    public void delete(String id) {
        collection.deleteOne(Filters.eq("_id", id));
    }

    @Override
    public Teacher findById(String id) {
        Document doc = collection.find(Filters.eq("_id", id)).first();

        if (doc == null) {
            return null;
        }

        Teacher teacher = new Teacher(doc.getString("_id"),
                doc.getString("names"),
                doc.getString("surnames"),
                doc.getString("profession")
        );

        return teacher;
    }

    @Override
    public ArrayList<Teacher> findBySurname(String surname) {
        ArrayList<Teacher> teachers = new ArrayList<>();

        Pattern pattern = Pattern.compile(surname, Pattern.CASE_INSENSITIVE);
        FindIterable<Document> documents = collection.find(Filters.regex("surnames", pattern));

        for (Document doc : documents) {
            teachers.add(
                    new Teacher(doc.getString("_id"),
                            doc.getString("names"),
                            doc.getString("surnames"),
                            doc.getString("profession")
                    )
            );
        }

        return teachers;
    }
    
}

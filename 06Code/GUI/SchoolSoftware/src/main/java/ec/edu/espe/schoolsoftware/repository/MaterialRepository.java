/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import ec.edu.espe.schoolsoftware.model.Material;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class MaterialRepository extends BaseRepository implements ICrudOperations<Material> {

    private final MongoCollection<Document> collection;

    public MaterialRepository() {
        collection = getCollection("materials");
    }

    @Override
    public void save(Material material) {
        Document document = new Document()
                .append("_id", material.getId())
                .append("title", material.getTitle())
                .append("fileType", material.getFileType());

        collection.insertOne(document);
    }

    @Override
    public ArrayList<Material> read() {
        ArrayList<Material> materials = new ArrayList<>();
        FindIterable<Document> documents = collection.find();

        for (Document doc : documents) {
            Material material = new Material(
                    doc.getString("_id"),
                    doc.getString("title"),
                    doc.getString("fileType"));

            materials.add(material);
        }

        return materials;
    }

    @Override
    public void update(Material material) {
        Document update = new Document("$set",
                new Document("title",
                        material.getTitle())
                        .append("fileType",
                                material.getFileType()));

        collection.updateOne(Filters.eq("_id", material.getId()), update);
    }

    @Override
    public void delete(String id) {
        collection.deleteOne(Filters.eq("_id", id));
    }

    @Override
    public Material findById(String id) {
        Document doc = collection.find(Filters.eq("_id", id)).first();

        if (doc == null) {
            return null;
        }

        return documentToObject(doc);
    }

    public ArrayList<Material> findByCourseId(String courseId) {
        ArrayList<Material> materials = new ArrayList<>();

        FindIterable<Document> documents = collection.find(Filters.eq("courseId", courseId));

        for (Document document : documents) {
            materials.add(documentToObject(document));
        }

        return materials;
    }

    private Material documentToObject(Document document) {

        return new Material(
                document.getString("_id"),
                document.getString("title"),
                document.getString("fileType"));
    }
}

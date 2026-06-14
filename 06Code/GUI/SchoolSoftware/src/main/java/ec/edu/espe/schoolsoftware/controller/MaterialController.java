package ec.edu.espe.schoolsoftware.controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ec.edu.espe.schoolsoftware.model.Material;
import ec.edu.espe.schoolsoftware.utils.MongoConnection;
import java.util.ArrayList;
import org.bson.Document;
/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class MaterialController implements CrudOperations<Material> {

    @Override
    public void save(Material material) {

        MongoDatabase database =
                MongoConnection.getDatabase();

        MongoCollection<Document> collection =
                database.getCollection("materials");

        Document document = new Document()
                .append("_id", material.getId())
                .append("title", material.getTitle())
                .append("fileType", material.getFileType());

        collection.insertOne(document);
    }

    @Override
    public void update(Material material) {

        MongoDatabase database =
                MongoConnection.getDatabase();

        MongoCollection<Document> collection =
                database.getCollection("materials");

        Document update = new Document("$set",
                new Document("title",
                        material.getTitle())
                        .append("fileType",
                                material.getFileType()));

        collection.updateOne(
                Filters.eq("_id", material.getId()),
                update);
    }

    @Override
    public void delete(String id) {

        MongoDatabase database =
                MongoConnection.getDatabase();

        MongoCollection<Document> collection =
                database.getCollection("materials");

        collection.deleteOne(
                Filters.eq("_id", id));
    }

    @Override
    public Material findById(String id) {

        MongoDatabase database =
                MongoConnection.getDatabase();

        MongoCollection<Document> collection =
                database.getCollection("materials");

        Document doc =
                collection.find(
                        Filters.eq("_id", id))
                        .first();

        if (doc == null) {
            return null;
        }

        return new Material(
                doc.getString("_id"),
                doc.getString("title"),
                doc.getString("fileType"));
    }

    public ArrayList<Material> getAllMaterials() {

        ArrayList<Material> materials =
                new ArrayList<>();

        MongoDatabase database =
                MongoConnection.getDatabase();

        MongoCollection<Document> collection =
                database.getCollection("materials");

        FindIterable<Document> documents =
                collection.find();

        for (Document doc : documents) {

            Material material = new Material(
                    doc.getString("_id"),
                    doc.getString("title"),
                    doc.getString("fileType"));

            materials.add(material);
        }

        return materials;
    }
}
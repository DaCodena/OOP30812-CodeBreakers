/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsoftware.utils;

import java.io.FileReader;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class Configuration {
    private String uri;
    private String database;

    public Configuration() {

        try {

            FileReader reader = new FileReader("config.json");

            JsonObject json = JsonParser
                    .parseReader(reader)
                    .getAsJsonObject();

            uri = json.get("uri").getAsString();
            database = json.get("database").getAsString();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUri() {
        return uri;
    }

    public String getDatabase() {
        return database;
    }
    
}

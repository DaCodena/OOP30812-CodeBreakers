/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.educativesoftware;

import com.mongodb.client.MongoDatabase;
import ec.edu.espe.educativesoftware.dao.MongoConnection;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */

public class TestConnection {

    public static void main(String[] args) {

        MongoDatabase db =
                MongoConnection.getDatabase();

        System.out.println(
                "Connected to: "
                + db.getName()
        );
    }
}
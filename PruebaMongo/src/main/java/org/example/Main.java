package org.example;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

       MongoClient cliente= MongoClients.create("mongodb://root:root@localhost:27017");

        MongoDatabase badeDatos=cliente.getDatabase("pruebas");
    Document doc=new Document("elemento","album").append("cantidad",50).append("dim",new Document("h",8.5).append("w",12)).append("estados", Arrays.asList("A","B","C"));

        MongoCollection<Document> coleccion= badeDatos.getCollection("inventario");

       /* MongoCursor<Document> cursor=coleccion.find().iterator();

        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }
        cursor.close();*/
        //coleccion.insertOne(doc);

       /* List<Document> documents=new ArrayList<>();
        for (int i=0;i<20;i++){
            documents.add(new Document("i",i));
        }
        coleccion.insertMany(documents);*/

       // Document doc1=coleccion.find().first();

        //para tener solo campo cantidad
        //doc1.getInteger("cantidad",-1);

        //Formas de obtener un campo sin especificar tipo
        //int cantidad=(Integer)doc1.get("cantidad")

        //Forma no recomendable
        /*for (Document docu:coleccion.find()){
            System.out.println(doc.toJson());
        }*/
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bl.Util;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.connection.Connection;
import dao.LanguageDAO;
import entity.Language;
import java.sql.SQLException;
import java.util.List;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.lt;
import static com.mongodb.client.model.Updates.inc;
import com.mongodb.client.result.UpdateResult;
import java.net.UnknownHostException;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Алина
 */
public class MongoLanguageService extends Util implements LanguageDAO{

        MongoClient mongoClient = new MongoClient("localhost" , 27017 );
        MongoDatabase database = mongoClient.getDatabase("glossarydb");
        MongoCollection<Document> collection = database.getCollection("language");

        @Override
        public void add(Language language) {
            Document document = new Document("id", language.getId())
                    .append("contact", language.getName());
            collection.insertOne(document);
        }

        @Override
        public List<Language> getAll(){
    //        List<Language> languageList = new ArrayList<>();
    //        
    //        List<Document> resultSet = (List<Document>) collection.find();
    //        DBCursor cursor = collection.find();
    //        while(cursor.hasNext()) {
    //            language.setId(resultSet.getInt("ID"));
    //            language.setName(resultSet.getString("NAME"));
    //            System.out.println(cursor.next());
    //        }
//        try{
            MongoCursor<Document> cursor = collection.find().iterator();
//        } catch (UnknownHostException e){
//            throw new IllegalArgumentException(e);
//        }
//            List<Language> languages = (List<Language>) collection.find().iterator();
            try {
                while (cursor.hasNext()) {
                    System.out.println(cursor.next().toJson());
                }
            } finally {
                cursor.close();
            }
            return null;
        }

        @Override
        public Language getById(Integer id){
            Document myDoc = collection.find(eq("id", id)).first();
            System.out.println(myDoc.toJson());
            Language language = new Language();
            language.setId(id);
            language.setName(collection.find(eq("id", id)).first().toJson());
            return language;
        }

        @Override
        public void update(Language language){
            UpdateResult updateResult = collection.updateMany(lt("id", 100), inc("id", 100));
            System.out.println(updateResult.getModifiedCount());
    //        collection.updateOne(
    //                eq("_id", new ObjectId("57506d62f57802807471dd41")),
    //                combine(set("stars", 1), set("contact.phone", "228-555-9999"), currentDate("lastModified")));
        }

        @Override
        public void remove(Language language){
            collection.deleteOne(eq("id", language.getId()));
        }
}

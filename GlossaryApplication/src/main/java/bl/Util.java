/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Алина
 */
public class Util {
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/glossary?serverTimezone=UTC";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";
    
    public Connection getConnection(){
        Connection connection = null;
        
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection OK");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connection error");
        }
        return connection;
    }
    
    /*public void getMongoConnection(){
        Connection connection = null;
        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        
        MongoClient mongoClient = new MongoClient();
        DB db = mongoClient.getDB("database name");
        boolean auth = db.authenticate("username", "password".toCharArray());
        /*String user = "root";
        String database = "glossarydb";
        char[] password = new char[] {'r', 'o', 'o', 't'};
        
        MongoCredential credential = MongoCredential.createCredential(user, database, password);
        MongoClientOptions options = MongoClientOptions.builder().sslEnabled(true).build();
        MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017),
                                           Arrays.asList(credential),
                                           options);*/
        
        //MongoCollection<Document> collection = database.getCollection("test");
        
        //boolean authenticated = database.authenticate("root", "password".toCharArray());
//        if(mongoClient){
//            System.out.println("Successfully logged in to MongoDB!");
//        } else {
//            System.out.println("Invalid username/password");
//        }
    //}
}

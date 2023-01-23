/*package com.gromed.demo;
import java.sql.*;

public class ConnectOracle
{
  public static void main(String args[])
  {
    try
    {
      //étape 1: charger la classe de driver
      Class.forName("oracle.jdbc.driver.OracleDriver");
      //étape 2: créer l'objet de connexion
      Connection con = DriverManager.getConnection(
      "jdbc:oracle:thin:@im2ag-oracle.univ-grenoble-alpes.fr:1521:im2ag","bouissai","d9365417e5");
      //étape 3: créer l'objet statement
      Statement stmt = con.createStatement();
      //étape 4: exécuter la requête
      ResultSet res = stmt.executeQuery("select * from commande");
      while(res.next()){
        System.out.println(res.getInt(1)+"  "+res.getString(2)+"  "
        +res.getString(3));
      }
      //étape 5: fermez l'objet de connexion
      con.close();
    }
    catch(Exception e){
      System.out.println(e);
    }
  }
}*/

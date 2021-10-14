package gui1;
import java.sql.*;
import java.util.*;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class SourceCode {

        public static void main(String[] args) {
                  sampleGUIForm1 form1= new sampleGUIForm1();
                          form1.show(true);
      try{
      
      
      }catch (Exception e){
            System.out.println(e);
      }
      
   SourceCode  db = new SourceCode ("jdbc:mysql://localhost/finalterm_project","root","");
      
      
      
    }  
    
    
    
    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }
        
  public boolean insertData(String query, Object []data){
  
        boolean success= false;
        
       try{
       
       
           PreparedStatement stmt= this.con.prepareStatement(query);
       

        for(int i=0; i < data.length;i++){
           stmt.setObject(i+1,data [i]);
        
        }
         stmt.execute();
        
        success=true;
       
       }catch(SQLException e) {
       
       System.out.println("Error :"+e.getMessage());
       
       }
        return success;
  
  
  }
   
    
private Connection con;

public SourceCode (String host, String Username,String Password){


try{


        this.con= DriverManager.getConnection(host, Username, Password);


       }catch(SQLException e){

           System.out.println("Error : "+ e.getMessage());


}




}

public boolean deleteData(String query, String id){
    boolean  success= false;
    
    
    try {
    
    PreparedStatement stmt= this.con.prepareStatement(query);
    
       stmt.setString(1, id);
        
        stmt.execute();
        
        success= true;
    
    } catch (SQLException e){
    
    System.out.println("Error :"+e.getMessage ());
    
    }
    return success;
 
}


public ArrayList getRecord(){

    
     ArrayList list= new ArrayList();
    
    
    
try{
    
        Statement stmt= this.con.createStatement();
        
        ResultSet rs= stmt.executeQuery ("SELECT * FROM record");
        
            while (rs.next()){
            
                  int id = rs.getInt("id");
                  String LastName = rs.getString("LastName");
                  String FirstName = rs.getString("FirstName");
                  String   Year = rs.getString("Year");
                  String Section = rs.getString("Section");
                  
                  
                  System.out.printf("%-5s %-5s %-5s %-5s %-5s\n",
                          
                  id, LastName, FirstName, Year, Section
                  
                  
                  );
            
            
            }
      
        
}catch(SQLException e){
    
        System.out.println("Error :"+e.getMessage());


}
        return list;

}


public ArrayList getData(){

    
    ArrayList list= new ArrayList();
    
    
    try{
    
    Statement stmt= this.getCon().createStatement();
       
    ResultSet rs= stmt.executeQuery("SELECT * FROM record");
    
    while (rs.next()){
    
        int id = rs.getInt("id");
        String LastName= rs.getString("LastName");
       String FirstName= rs.getString ("FirstName");
       String Year = rs.getString ("Year");
       String Section= rs.getString ("Section");
       
       
       
       
       Object[] row ={id, LastName, FirstName,Year, Section};
       
       
       list.add(row);
       
    }
    
    }catch(SQLException e){
    
            System.out.println("Error : "+ e.getMessage());
    
    
    }
    
    
    
   return list; 
    
  
}

    boolean insertData(String insert_into_record_LastName_FirstName_Yea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    ArrayList<Object[]> getData(String select__from_users, String[] string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

    



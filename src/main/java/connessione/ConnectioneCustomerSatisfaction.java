package connessione;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class ConnectioneCustomerSatisfaction {
	public static void main(String[] args) {
		Connection con =null;
		Statement stm = null;
		try {
			con = DriverManager.getConnection(
					"jdbc:sqlserver://localhost;integratedSecurity=true;"
		
					);
				stm = con.createStatement();	
				 String sqlQuery1 = "";//Dichiarare query
				 ResultSet res = stm.executeQuery(sqlQuery1);
						 
						 while (res.next()) {
				                //Salvare i dati pressi dal db in locale
				            };
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		finally {
            if (stm != null){
                try {
                    stm.close();
                } catch (Exception e) {
                    // lasciato bianco intenzionalmente
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    // lasciata in bianco intenzionalmente
                }
            }
        }
	}

	
}

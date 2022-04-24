/*Projeto: Ex21_261_demo-dao-JDBC7
 */
package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;


//Classe auxiliar responsável por instanciar os Daos com operações estáticas.
public class DaoFactory {
    
    public static SellerDao createSellerDao(){
        
        return new SellerDaoJDBC(DB.getConnection());
    }
}

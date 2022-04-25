/*Projeto: Ex21_261_demo-dao-JDBC7
 */
package application;

import java.util.Date;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class programa_main_261 {

    public static void main(String[] args) {
        
        //Department obj = new Department(1, "Books");
        
        //Seller seller = new Seller(21, "Bob", "bobgmail.com", new Date(), 3000.00, obj);
        
        SellerDao sellerDao = DaoFactory.createSellerDao();
        
        System.out.println("==== TESTE-1: seller findById ====");
        Seller seller = sellerDao.findById(3);
        
         //System.out.println(""+obj);
         System.out.println(""+seller);
    }
    
}
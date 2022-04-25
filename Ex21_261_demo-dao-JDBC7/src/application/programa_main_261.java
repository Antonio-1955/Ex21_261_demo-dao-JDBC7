/*Projeto: Ex21_261_demo-dao-JDBC7
 */
package application;
//==============================================================================

import java.util.Date;
import java.util.List;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;
//==============================================================================

public class Programa_main_261 {

    public static void main(String[] args) {
        
        //Department obj = new Department(1, "Books");
        
        //Seller seller = new Seller(21, "Bob", "bobgmail.com", new Date(), 3000.00, obj);
        
        SellerDao sellerDao = DaoFactory.createSellerDao();
//==============================================================================        
        
        System.out.println("==== TESTE-1: seller findById ====");
        Seller seller = sellerDao.findById(3);
        
         //System.out.println(obj);
         System.out.println(seller);
//==============================================================================         
         
         System.out.println("\n==== TESTE-2: seller findByDepartment ====");
         Department department = new Department(2, null); 
         List<Seller> list = sellerDao.findByDepartment(department);
         
         for (Seller obj : list){
             System.out.println(obj);
         }
//==============================================================================         
         
         System.out.println("\n==== TESTE-3: seller findAll ====");
         //Department department = new Department(2, null); 
         list = sellerDao.findAll();
         
         for (Seller obj : list){
             System.out.println(obj);
         }
//==============================================================================         
         
          System.out.println("\n==== TESTE-4: seller insert ====");
          Seller newSeller = new Seller(null, "Greg Smith", "gregsmith@gmail.com", new Date(), 4000.00, department);
          sellerDao.insert(newSeller);
          System.out.println("Registro inserido! Novo id = " + newSeller.getId());
          
          
          System.out.println("\n==== TESTE-5: seller update ====");
          seller = sellerDao.findById(1);
          seller.setName("Maryanne Waine");
          seller.setEmail("maryanne.waine@gmail.com");
          sellerDao.update(seller);
          System.out.println("ATUALIZAÇÃO EFETUADA! id = " + seller.getId());
          System.out.println("Novo Nome = " + seller.getName());
          System.out.println("Novo Email = " + seller.getEmail());

    }
    
}
/*Projeto: Ex21_261_demo-dao-JDBC7
 */
package application;
//==============================================================================

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;
//==============================================================================

public class Programa_main_261 {

//    public static void main(String[] args) {
//        
//        Scanner sc = new Scanner(System.in);
//        
//        SellerDao sellerDao = DaoFactory.createSellerDao();
////==============================================================================        
//        
//        System.out.println("==== TESTE-1: seller findById ====");
//        Seller seller = sellerDao.findById(3);
//        
//         //System.out.println(obj);
//         System.out.println(seller);
////==============================================================================         
//         
//         System.out.println("\n==== TESTE-2: seller findByDepartment ====");
//         Department department = new Department(2, null); 
//         List<Seller> list = sellerDao.findByDepartment(department);
//         
//         for (Seller obj : list){
//             System.out.println(obj);
//         }
////==============================================================================         
//         
//         System.out.println("\n==== TESTE-3: seller findAll ====");
//         //Department department = new Department(2, null); 
//         list = sellerDao.findAll();
//         
//         for (Seller obj : list){
//             System.out.println(obj);
//         }
////==============================================================================         
//         
//          System.out.println("\n==== TESTE-4: seller insert ====");
//          Seller newSeller = new Seller(null, "Greg Smith", "gregsmith@gmail.com", new Date(), 4000.00, department);
//          sellerDao.insert(newSeller);
//          System.out.println("Registro inserido! Novo id = " + newSeller.getId());
////==============================================================================          
//          
//          
//          System.out.println("\n==== TESTE-5: seller update ====");
//          seller = sellerDao.findById(1);
//          seller.setName("Maryanne Waine");
//          seller.setEmail("maryanne.waine@gmail.com");
//          sellerDao.update(seller);
//          System.out.println("ATUALIZAÇÃO EFETUADA! id = " + seller.getId());
//          System.out.println("Novo Nome = " + seller.getName());
//          System.out.println("Novo Email = " + seller.getEmail());
////==============================================================================
//
//          System.out.println("\n==== TESTE-6: seller delete ====");
//          System.out.print("Digite o código do registro a deletar: ");
//          int id = sc.nextInt();
//          sellerDao.deleteById(id);
//          System.out.println("Registro foi deletado!");
//
//          sc.close();
//    }
    
    public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== TEST 1: findById =======");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);

		System.out.println("\n=== TEST 2: findAll =======");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}

		System.out.println("\n=== TEST 3: insert =======");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id: " + newDepartment.getId());

		System.out.println("\n=== TEST 4: update =======");
		Department dep2 = departmentDao.findById(1);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("Update completed");

		System.out.println("\n=== TEST 5: delete =======");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");

		sc.close();
	}
    
}
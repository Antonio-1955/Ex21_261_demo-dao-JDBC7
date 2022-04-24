/*Projeto: Ex21_261_demo-dao-JDBC7
 */
package model.dao.impl; //impl = implementação

import db.DB;
import db.DbException;
import java.sql.Connection;
import java.util.List;
import model.dao.SellerDao;
import model.entities.Seller;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import model.entities.Department;
import java.sql.SQLException;

//Esta é uma implementação JDBC da interface SellerDao.
public class SellerDaoJDBC implements SellerDao {
    
    //Atributo para fazer a conexão
    private Connection conn;
//==============================================================================

    //Construtor
    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }
//==============================================================================    
    
    

    @Override
    public void insert(Seller obj) {
        
    }

    @Override
    public void update(Seller obj) {
        
    }

    @Override
    public void deleteById(Integer id) {
        
    }

    @Override
    public Seller findById(Integer id) {
        
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
            "SELECT seller.*, department.Name as DepName "
                    + "FROM seller INNER JOIN department "
                    + "ON seller.DepartmentId = department.Id "
                    + "WHERE seller.Id = ? ");
            
            st.setInt(1, id);
            rs = st.executeQuery();
            
            /* Como o 'rs' está na posição '0', que não contém objeto, o 'if' 
             * testa se o 'executeQuery()' retornou algun registro*/
            if (rs.next()){ 
                Department dep = new Department();
                dep.setId(rs.getInt("DepartmentId"));
                dep.setName(rs.getString("DepName"));
                Seller obj = new Seller();
                obj.setId(rs.getInt("Id"));
                obj.setName(rs.getString("Name"));
                obj.setEmail(rs.getString("Email"));
                obj.setBaseSalary(rs.getDouble("BaseSalary"));
                obj.setBirthDate(rs.getDate("BirthDate"));
                obj.setDepartent(dep);
                return obj;
            }
            return null;
            
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Seller> findAll() {
        return null;
    }
    
}

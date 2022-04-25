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

    //Métodos inserir dados no o banco de dados
    @Override
    public void insert(Seller obj) {

    }
//==============================================================================

    //Métodos atualizar dados no o banco de dados
    @Override
    public void update(Seller obj) {

    }
//==============================================================================

    //Métodos deletar dados no o banco de dados
    @Override
    public void deleteById(Integer id) {

    }
//==============================================================================

    //Métodos pesquisar dados no o banco de dados
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
            if (rs.next()) {

                //A instanciação abaixo foi transformada no método instantiateDepartment().
                //Department dep = new Department();
                //dep.setId(rs.getInt("DepartmentId"));
                //dep.setName(rs.getString("DepName"));
                //Instancia o Departamento (Department)
                Department dep = instantiateDepartment(rs);

                //A instanciação abaixo foi transformada no método instantiateSeller().
                //Seller obj = new Seller();
                //obj.setId(rs.getInt("Id"));
                //obj.setName(rs.getString("Name"));
                //obj.setEmail(rs.getString("Email"));
                //obj.setBaseSalary(rs.getDouble("BaseSalary"));
                //obj.setBirthDate(rs.getDate("BirthDate"));
                //obj.setDepartent(dep);
                //return obj;

                //Instancia o Vendedor (Seller)
                Seller obj = instantiateSeller(rs, dep);
                return obj;

            }
            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
//==============================================================================

    //Método para listar dados do banco de dados
    @Override
    public List<Seller> findAll() {
        return null;
    }
//==============================================================================
    
    /* TRATAR O PROPAGAR EXCEÇÕES FOI DISCUTIDO NO CAPÍTULO DE EXECÕES.
     * NOTA: O compilador aqui indicava que o método poderia gerar uma 
     * SQLException que deveria ser tratada, mas como ela já está sendo
     * tratada acima no método 'findById()', aqui ela foi simplesmente
     * propagada (throws SQLException).
     */
    //Método para instanciar Departamento (Department)
    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("DepartmentId"));
        dep.setName(rs.getString("DepName"));
        return dep;
    }
//==============================================================================    

    /* TRATAR O PROPAGAR EXCEÇÕES FOI DISCUTIDO NO CAPÍTULO DE EXECÕES.
     * NOTA: O compilador aqui indicava que o método poderia gerar uma 
     * SQLException que deveria ser tratada, mas como ela já está sendo
     * tratada acima no método 'findById()', aqui ela foi simplesmente
     * propagada (throws SQLException)
     */
    //Método para instanciar o Vendedor (Seller)
    private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
        Seller obj = new Seller();
        obj.setId(rs.getInt("Id"));
        obj.setName(rs.getString("Name"));
        obj.setEmail(rs.getString("Email"));
        obj.setBaseSalary(rs.getDouble("BaseSalary"));
        obj.setBirthDate(rs.getDate("BirthDate"));
        obj.setDepartent(dep);
        return obj;
    }

}

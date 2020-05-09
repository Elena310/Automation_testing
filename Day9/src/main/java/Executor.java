import java.sql.SQLException;

public class Executor {
    public static void main(String[] args) throws SQLException {
        Operation operations = new Operation();
        SQLQueries queries = new SQLQueries();

        operations.deleteTable();
        operations.createTable();
        operations.addTenUsers();
        operations.loadUsers(queries.SELECT_ALL);
    }
}

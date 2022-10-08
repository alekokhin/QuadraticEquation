package org.example.database.dao;
import org.example.database.connectionpool.ConnectionPool;
import org.example.database.models.QuadraticDate;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuadraticDAO implements IDate{
    @Override
    public List<QuadraticDate> getAllquadraticDate(){
        Connection connection = ConnectionPool.getInstance().retrieve();
        List<QuadraticDate> quadraticDates = new ArrayList<>();
        Statement statement =null;
        ResultSet resultSet=null;
        try {
            statement= connection.createStatement();
            resultSet = statement.executeQuery("SELECT * from tablename");//Change the name of the table and set the name of your table
            while (resultSet.next()){
                QuadraticDate quadraticDate = new QuadraticDate();
                quadraticDate.setId(resultSet.getLong("id"));
                quadraticDate.setA(resultSet.getDouble("a"));
                quadraticDate.setB(resultSet.getDouble("b"));
                quadraticDate.setC(resultSet.getDouble("c"));

                quadraticDates.add(quadraticDate);

            }
        }catch (SQLException e){
            System.out.println(e);
        }finally {
            try {
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
          ConnectionPool.getInstance().putback(connection);

        }
        return quadraticDates;
    }
}

//We have created an interface where we have only one method to retrieve all the data and use it in the DAO
package org.example.database.dao;
import org.example.database.models.QuadraticDate;
import java.util.List;

public interface IDate {
     List<QuadraticDate> getAllquadraticDate();
}

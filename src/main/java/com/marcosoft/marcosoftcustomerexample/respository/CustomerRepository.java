package com.marcosoft.marcosoftcustomerexample.respository;

import com.marcosoft.marcosoftcustomerexample.config.CustomerDatabase;
import com.marcosoft.marcosoftcustomerexample.model.Customer;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class CustomerRepository {

    CustomerDatabase customerDatabase = new CustomerDatabase();


    public Customer save(Customer newCustomer){

        Connection dbConnection = customerDatabase.createConnection();

        String sqlCommand = "insert into customer (first_name, surname, uf) value (?,?,?)";

        try (PreparedStatement statement = dbConnection.prepareStatement(sqlCommand)) {

            statement.setString(1, newCustomer.getFirstName());
            statement.setString(2, newCustomer.getSurname());
            statement.setString(3, newCustomer.getUf());

            statement.execute();
            String lastCustomerSql = "select * from customer order by id desc limit 1";
            Statement lastCustomerStatement = dbConnection.createStatement();
            ResultSet rs = lastCustomerStatement.executeQuery(lastCustomerSql);
            while (rs.next()){
                Customer createdCustomer = Customer.builder()
                        .id(rs.getLong(1))
                        .firstName(rs.getString(2))
                        .surname(rs.getString(3))
                        .uf(rs.getString(4))
                        .build();

                return createdCustomer;
            }

        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            try {
                dbConnection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }

}

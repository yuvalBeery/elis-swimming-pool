package eli.swimming_pool.controllers;

import eli.swimming_pool.DBConnection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping("users")
    public ResponseEntity<Object> getAllUsers() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM eli.user;");
            ArrayList<User> users = new ArrayList<>();

            while (resultSet.next()) {
                users.add(User.createUserFromResultSet(resultSet));
            }

            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>("Something went wrong -> " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

package login;

import java.sql.ResultSet;
import java.sql.SQLException;
import db_operations.DBUtils;
import home_screen.HomeScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginScreenController {

	@FXML
	private TextField loginName;

	@FXML
	private TextField password;

	@FXML
	private Button loginButton;

	public void login(ActionEvent event) {
		boolean loginStatus = validateUserAndPassword(loginName.getText(), password.getText());
		if (loginStatus) {
			HomeScreen.showHomeScreen();
		} else {
			System.out.println("Login Unsuccessfull");

		}
	}

	public static boolean validateUserAndPassword(String loginName, String password) {
		String query = "select * from user where login_name ='" + loginName + "'and password='" + password + "';";
		ResultSet rs = DBUtils.executeQueryGetResult(query);
		try {
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}

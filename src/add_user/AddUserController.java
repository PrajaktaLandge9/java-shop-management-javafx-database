package add_user;

import db_operations.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import user_management.UserManagementScreen;

public class AddUserController {

	@FXML
	private TextField userName;

	@FXML
	private TextField loginName;

	@FXML
	private TextField userRole;

	@FXML
	private TextField password;

	@FXML
	private TextField confirmPassword;

	@FXML
	private Button save;

	@FXML
	private Button close;

	public void saveUser(ActionEvent event) {
		String query = "INSERT INTO User(user_name, login_name, user_role, password, confirm_Password) VALUES ('"
				+ userName.getText() + "', '" + loginName.getText() + "', '" + userRole.getText() + "','"
				+ password.getText() + "','" + confirmPassword.getText() + "')";
		DBUtils.executeQuery(query);
	}

	public void closeWindow(ActionEvent event) {
		UserManagementScreen.showUserManagementScreen();
		
	}
}

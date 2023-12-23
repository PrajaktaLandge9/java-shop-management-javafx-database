package delete_user;

import db_operations.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import user_management.UserManagementScreen;

public class DeleteUserController {

	@FXML
	private TextField userNameToDelete;

	@FXML
	private TextField userMessage;

	@FXML
	private Button close;

	@FXML
	private Button delete;

	public void deleteUser(ActionEvent event) {
		boolean status = delete(userNameToDelete.getText());
		if (status) {
			delete(userNameToDelete.getText());
			userMessage.setText("User deleted Successfully");
		} else {
			userMessage.setText("User Not Found");
		}
	}

	public void backToUserManagement(ActionEvent event) {
		UserManagementScreen.showUserManagementScreen();
	}

	public boolean delete(String userNameToDelete) {
		String query = "delete from User where user_name = '" + userNameToDelete + "' ";
		DBUtils.executeQuery(query);
		return true;
	}
}

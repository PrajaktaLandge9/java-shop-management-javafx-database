package edit_user;

import java.sql.ResultSet;
import java.sql.SQLException;
import db_operations.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import user_management.UserManagementScreen;

public class EditUserController {

	@FXML
	private TextField userNameToEdit;

	@FXML
	private TextField newUserName;

	@FXML
	private TextField newLoginName;

	@FXML
	private TextField newUserRole;

	@FXML
	private TextField newPassword;
	@FXML
	private TextField newConfirmPassword;

	@FXML
	private Button close;

	@FXML
	private Button update;

	public void updateUser(ActionEvent event) throws SQLException {
		boolean status = userToEdit(userNameToEdit.getText());
		if (status) {
			edit();
			System.out.println("User information is updated Successfully !");
		} else {
			System.out.println("User information is not updated");
		}
	}

	public void backToUserManagement(ActionEvent event) {
		UserManagementScreen.showUserManagementScreen();
	}

	public boolean userToEdit(String userNameToEdit) {
		String query = "select * from User where user_name='" + userNameToEdit + "'";
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

	public void edit() {
		String updatequery = "update User Set " + " user_name='" + newUserName.getText() + "',login_name='"
				+ newLoginName.getText() + "',user_role='" + newUserRole.getText() + "',password='"
				+ newPassword.getText() + "',confirm_password='" + newConfirmPassword.getText() + "'where user_name='"
				+ userNameToEdit.getText() + "';";
		DBUtils.executeQuery(updatequery);

	}
}
	
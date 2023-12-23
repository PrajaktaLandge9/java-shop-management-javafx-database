package search_user;

import java.sql.ResultSet;
import db_operations.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import user_management.UserManagementScreen;

public class SearchUserController {

	@FXML
	private TextField userNameToSearch;

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
	private Button search;

	@FXML
	private Button close;

	@FXML
	private Button Clear;

	public void searchUser(ActionEvent event) {

		search(userNameToSearch.getText());

	}

	public void backToUserManagement(ActionEvent event) {

		UserManagementScreen.showUserManagementScreen();
	}

	public void clearTextField(ActionEvent event) {
		userNameToSearch.clear();
		userName.clear();
		loginName.clear();
		userRole.clear();
		password.clear();
		confirmPassword.clear();
	}

	public void search(String userNameToSearch) {
		String query = "select * from User where user_name ='" + userNameToSearch + "' ";
		ResultSet rs = DBUtils.executeQueryGetResult(query);
		try {
			while (rs.next()) {
				if (rs.getString("user_name").equalsIgnoreCase(userNameToSearch)) {
					userName.setText(rs.getString("user_name"));
					loginName.setText(rs.getString("login_name"));
					userRole.setText(rs.getString("user_role"));
					password.setText(rs.getString("password"));
					confirmPassword.setText(rs.getString("confirm_password"));
				}
			}
		} catch (Exception e) {
			System.out.println("User not found");
		}
	}
}


	



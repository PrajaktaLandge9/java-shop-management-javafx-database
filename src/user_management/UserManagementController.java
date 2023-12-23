package user_management;

import add_user.AddUserScreen;
import delete_user.DeleteUserScreen;
import edit_user.EditUserScreen;
import home_screen.HomeScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import search_user.SearchUserScreen;

public class UserManagementController {

	@FXML
	private Button addUser;

	@FXML
	private Button editUser;

	@FXML
	private Button searchUser;

	@FXML
	private Button deleteUser;

	@FXML
	private Button quit;

	public void showAddUserScreen(ActionEvent event) {
		AddUserScreen.showAddUserScreen();
	}

	public void showEditUserScreen(ActionEvent event) {
		EditUserScreen.showEditUserScreen();
	}

	public void showSearchUserScreen(ActionEvent event) {
		SearchUserScreen.showSearchUserScreen();
	}

	public void deleteUser(ActionEvent event) {
		DeleteUserScreen.showDeleteUserScreen();
	}

	public void backToHomeScreen(ActionEvent event) {
		HomeScreen.showHomeScreen();
	}
}

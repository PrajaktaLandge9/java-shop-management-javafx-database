package product_management;

import add_product.AddProductScreen;
import delete_product.DeleteProductScreen;
import edit_product.EditProductScreen;
import home_screen.HomeScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import search_product.SearchProductScreen;

public class ProductManagementController {

	@FXML
	private Button addProduct;

	@FXML
	private Button editProduct;

	@FXML
	private Button searchProduct;

	@FXML
	private Button deleteProduct;

	@FXML
	private Button quit;

	public void showAddProductScreen(ActionEvent event) {
		AddProductScreen.showAddProductScreen();
	}

	public void showEditProductScreen(ActionEvent event) {
		EditProductScreen.showEditProductScreen();
	}

	public void showSearchProductScreen(ActionEvent event) {
		SearchProductScreen.showSearchProductScreen();
	}

	public void deleteProduct(ActionEvent event) {
		DeleteProductScreen.showDeleteProductScreen();
	}

	public void backToHomeScreen(ActionEvent event) {
		HomeScreen.showHomeScreen();
	}
}

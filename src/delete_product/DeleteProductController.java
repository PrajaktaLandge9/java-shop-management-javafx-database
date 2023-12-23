package delete_product;

import db_operations.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import product_management.ProductManagementScreen;

public class DeleteProductController {

	@FXML
	private TextField productNameToDelete;

	@FXML
	private TextField productMessage;

	@FXML
	private Button close;

	@FXML
	private Button delete;

	public void deleteProduct(ActionEvent event) {
		boolean status = delete(productNameToDelete.getText());
		if (status) {
			delete(productNameToDelete.getText());
			productMessage.setText("Product deleted Successfully");
		} else {
			productMessage.setText("Product Not Found");
		}

	}

	public void backToProductManagement(ActionEvent event) {
		ProductManagementScreen.showProductManagementScreen();
	}

	public boolean delete(String productNameToDelete) {
		String query = "delete from Product where product_name = '" + productNameToDelete + "' ";
		DBUtils.executeQuery(query);
		return true;
	}
}

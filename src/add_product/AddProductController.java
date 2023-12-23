package add_product;

import db_operations.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import product_management.ProductManagementScreen;

public class AddProductController {

	@FXML
	private TextField productId;

	@FXML
	private TextField productName;

	@FXML
	private TextField productPrice;

	@FXML
	private TextField productQuantity;

	@FXML
	private TextField productCategory;

	@FXML
	private Button save;

	@FXML
	private Button close;

	public void saveProduct(ActionEvent event) {
		String query = "INSERT INTO Product(product_id, product_name, product_price, product_quantity, product_category) VALUES ('"
				+ productId.getText() + "', '" + productName.getText() + "', '" + productPrice.getText() + "','"
				+ productQuantity.getText() + "','" + productCategory.getText() + "')";
		DBUtils.executeQuery(query);
	}

	public void closeWindow(ActionEvent event) {
		ProductManagementScreen.showProductManagementScreen();
		;
	}
}

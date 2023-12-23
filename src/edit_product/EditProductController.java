package edit_product;

import java.sql.ResultSet;
import java.sql.SQLException;
import db_operations.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import product_management.ProductManagementScreen;

public class EditProductController {

	@FXML
	private TextField productNameToEdit;

	@FXML
	private TextField newProductId;

	@FXML
	private TextField newProductName;

	@FXML
	private TextField newProductPrice;

	@FXML
	private TextField newProductQuantity;

	@FXML
	private TextField newProductCategory;

	@FXML
	private Button close;

	@FXML
	private Button update;

	public void updateProduct(ActionEvent event) throws SQLException {
		boolean status = productToEdit(productNameToEdit.getText());
		if (status) {
			edit();
			System.out.println("Product information is updated Successfully !");
		} else {
			System.out.println("Product information is not updated");
		}
	}

	public void backToProductManagement(ActionEvent event) {
		ProductManagementScreen.showProductManagementScreen();
	}

	public boolean productToEdit(String productNameToEdit) {
		String query = "select * from Product where product_name='" + productNameToEdit + "'";
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
		String updatequery = "update Product Set " + " product_id='" + newProductId.getText() + "',product_name='"
				+ newProductName.getText() + "',product_price='" + newProductPrice.getText() + "',product_quantity='"
				+ newProductQuantity.getText() + "',product_category='" + newProductCategory.getText()
				+ "'where product_name='" + productNameToEdit.getText() + "';";
		DBUtils.executeQuery(updatequery);
	}
}


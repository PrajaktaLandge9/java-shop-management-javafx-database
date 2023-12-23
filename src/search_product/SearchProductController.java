package search_product;

import java.sql.ResultSet;
import db_operations.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import product_management.ProductManagementScreen;

public class SearchProductController {

	@FXML
	private TextField productNameToSearch;

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
	private Button search;

	@FXML
	private Button close;

	public void searchProduct(ActionEvent event) {

		search(productNameToSearch.getText());

	}

	public void backToProductManagement(ActionEvent event) {

		ProductManagementScreen.showProductManagementScreen();
	}

	public void search(String productNameToSearch) {
		String query = "select * from Product where product_name ='" + productNameToSearch + "' ";
		ResultSet rs = DBUtils.executeQueryGetResult(query);
		try {
			while (rs.next()) {
				if (rs.getString("product_name").equalsIgnoreCase(productNameToSearch)) {
					productId.setText(rs.getString("product_id"));
					productName.setText(rs.getString("product_name"));
					productPrice.setText(rs.getString("product_price"));
					productQuantity.setText(rs.getString("product_quantity"));
					productCategory.setText(rs.getString("product_category"));
				}
			}
		} catch (Exception e) {
			System.out.println("Product not found");
		}
	}
}



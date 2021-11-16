package webservice;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	private static List<Product> dataList = new ArrayList<>();
	private static ProductDAO instance;
	static {
		dataList.add(new Product(1, "macbook", 2000f));
		dataList.add(new Product(2, "iphone", 1000f));
		dataList.add(new Product(3, "ipad", 200f));
	}

	private ProductDAO() {

	}

	public static ProductDAO getInstance() {
		if (instance == null) {
			instance = new ProductDAO();
		}
		return instance;
	}

	public List<Product> listAll() {
		return new ArrayList<Product>(dataList);
	}

	public int add(Product product) {
		int newId = dataList.size() + 1;
		product.setId(newId);
		dataList.add(product);
		return newId;
	}
	
	public Product get(int id) {
		Product productToFind = new Product(id);
		int index = dataList.indexOf(productToFind);
		if(index >= 0) {
			return dataList.get(index);
		}
		return null;
	}
	
	public boolean update(Product product) {
		int index = dataList.indexOf(product);
		if(index >= 0) {
			dataList.set(index, product);
			return true;
		}
		return false;
	}
	
	public boolean delete(int id) {
		Product productToFind = new Product(id);
		int index = dataList.indexOf(productToFind);
		if(index >= 0) {
			dataList.remove(index);
			return true;
		}
		return false;
	}
}

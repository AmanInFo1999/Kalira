package property;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.testng.annotations.DataProvider;

public class Dataprovider {
	public Properties pro = new Properties();

	public String getData(String name) throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\property\\config.properties");
		pro.load(fis);
		return pro.getProperty(name);
	}

		@DataProvider(name = "Login")
	public Iterator<Object[]> getEnv() throws IOException {
		Dataprovider d = new Dataprovider();
		ArrayList<Object[]> testdata = new ArrayList<Object[]>();
		String mobileNumber = d.getData("MobileNumber");
		Object[] ob = { mobileNumber };
		testdata.add(ob);
		return testdata.iterator();
	}
}

package d.grzesiak.Projekt3.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class Mat extends WebDriverPage {

	public Mat(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void open() {
		get("https://mat.ug.edu.pl/");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
}

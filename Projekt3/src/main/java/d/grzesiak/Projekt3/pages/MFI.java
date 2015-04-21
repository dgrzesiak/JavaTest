package d.grzesiak.Projekt3.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class MFI extends WebDriverPage {

	public MFI(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void open() {
		get("http://mfi.ug.edu.pl/");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
}

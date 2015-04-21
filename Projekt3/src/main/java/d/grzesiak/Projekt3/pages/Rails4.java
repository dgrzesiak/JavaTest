package d.grzesiak.Projekt3.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;


public class Rails4 extends WebDriverPage {

	//page elements
	
	/**********************/
	public Rails4(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void open() {
		get("http://wbzyl.inf.ug.edu.pl/rails4/");
		manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	
}

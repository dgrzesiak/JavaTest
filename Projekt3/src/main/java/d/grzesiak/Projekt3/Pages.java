package d.grzesiak.Projekt3;

import d.grzesiak.Projekt3.pages.*;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;


public class Pages {

	private WebDriverProvider driverProvider;
	
	//Pages
	private Home home;
	private Rails4 rails4;
	private TI ti;
	private NOSQL nosql;
	private Ce ce;
	private Mat mat;
	private MFI mfi;
	private Seminarium seminarium;
	
	
	
	public Pages(WebDriverProvider driverProvider) {
		super();
		this.driverProvider = driverProvider;
	}

	//Initializing
	
	public Home home() {
		if (home == null) {
			home = new Home(driverProvider);
		}
		return home;
	}
	public Rails4 rails4() {
		if (rails4 == null) {
			rails4 = new Rails4(driverProvider);
		}
		return rails4;
	}
	public TI ti() {
		if (ti == null) {
			ti = new TI(driverProvider);
		}
		return ti;
	}//****************
	public NOSQL forum() {
		if (nosql == null) {
			nosql = new NOSQL(driverProvider);
		}
		return nosql;
	}
	public Ce ce() {
		if (ce == null) {
			ce = new Ce(driverProvider);
		}
		return ce;
	}
	public Mat mat() {
		if (mat == null) {
			mat = new Mat(driverProvider);
		}
		return mat;
	}
	public MFI mfi() {
		if (mfi == null) {
			mfi = new MFI(driverProvider);
		}
		return mfi;
	}
	public Seminarium seminarium() {
		if (seminarium == null) {
			seminarium = new Seminarium(driverProvider);
		}
		return seminarium;
	}
	
	
}

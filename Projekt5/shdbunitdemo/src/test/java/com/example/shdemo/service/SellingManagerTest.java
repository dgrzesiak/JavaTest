package com.example.shdemo.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.shdemo.domain.Car;
import com.example.shdemo.domain.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class SellingManagerTest {

	@Autowired
	SellingManager sellingManager;

	private final String NAME_1 = "Bolek";
	private final String SURNAME_1 = "Bolkowy";
	private final String PIN_1 = "1234";

	private final String NAME_2 = "Lolek";
	private final String SURNAME_2 = "Lolkowy";
	private final String PIN_2 = "4321";

	private final String MODEL_1 = "126p";
	private final String MAKE_1 = "Fiat";

	private final String MODEL_2 = "Mondeo";
	private final String MAKE_2 = "Ford";

	@Test
	public void addClientCheck() {

		List<Person> retrievedClients = sellingManager.getAllClients();

		// If there is a client with PIN_1 delete it
		for (Person client : retrievedClients) {
			if (client.getPesel().equals(PIN_1)) {
				sellingManager.deleteClient(client);
			}
		}

		Person person = new Person();
		person.setFirstName(NAME_1);
		person.setSurName(SURNAME_1);
		person.setPesel(PIN_1);
		// ... other properties here

		// Pin is Unique
		sellingManager.addClient(person);

		Person retrievedClient = sellingManager.findClientByPesel(PIN_1);

		assertEquals(NAME_1, retrievedClient.getFirstName());
		assertEquals(SURNAME_1, retrievedClient.getSurName());
		assertEquals(PIN_1, retrievedClient.getPesel());
		// ... check other properties here
	}

	@Test
	public void addCarCheck() {

		Car car = new Car();
		car.setMake(MAKE_1);
		car.setModel(MODEL_1);
		// ... other properties here

		Long carId = sellingManager.addNewCar(car);

		Car retrievedCar = sellingManager.findCarById(carId);
		assertEquals(MAKE_1, retrievedCar.getMake());
		assertEquals(MODEL_1, retrievedCar.getModel());
		// ... check other properties here

	}

	@Test
	public void sellCarCheck() {

		Person person = new Person();
		person.setFirstName(NAME_2);
		person.setSurName(SURNAME_2);
		person.setPesel(PIN_2);
		

		sellingManager.addClient(person);

		Person retrievedPerson = sellingManager.findClientByPesel(PIN_2);

		Car car = new Car();
		car.setMake(MAKE_2);
		car.setModel(MODEL_2);

		Long carId = sellingManager.addNewCar(car);

		sellingManager.sellCar(retrievedPerson.getId(), carId);

		List<Car> ownedCars = sellingManager.getOwnedCars(retrievedPerson);

		assertEquals(1, ownedCars.size());
		assertEquals(MAKE_2, ownedCars.get(0).getMake());
		assertEquals(MODEL_2, ownedCars.get(0).getModel());
	}

}

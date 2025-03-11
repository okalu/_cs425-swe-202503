package edu.miu.cs.cs425.citylibraryapp;

import edu.miu.cs.cs425.citylibraryapp.model.Address;
import edu.miu.cs.cs425.citylibraryapp.model.MembershipType;
import edu.miu.cs.cs425.citylibraryapp.model.Publisher;
import edu.miu.cs.cs425.citylibraryapp.service.AddressService;
import edu.miu.cs.cs425.citylibraryapp.service.MembershipTypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.miu.cs.cs425.citylibraryapp.service.PublisherService;

@SpringBootApplication
public class CitylibrarycliappV1Application { //implements CommandLineRunner {

	private final PublisherService publisherService;
	private final AddressService addressService;
	private final MembershipTypeService membershipTypeService;

	public CitylibrarycliappV1Application(PublisherService publisherService,
								  AddressService addressService,
								  MembershipTypeService membershipTypeService) {
		this.publisherService = publisherService;
		this.addressService = addressService;
		this.membershipTypeService = membershipTypeService;
	}

	public static void main(String[] args) {
		SpringApplication.run(CitylibrarycliappV1Application.class,
				args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("Hello World of Spring Boot!");
//	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("Hello World of Spring Boot!");
//			registerNewPublisher("Addison-Wesley, Inc.", "sales@adw.com", "(242) 272-0987");
//			registerNewPublisher("Penguin-RandomHouse", "info@penguin.com", null,
//					"123 West Avenue", "Phoenix", "AZ", "85020");
//			registerNewPublisher2("Macmillan", "info@macmillan.com", null,
//					"2000 N Court Street", "Boston", "MA", "01234");
			System.out.println("List of Publishers");
			getAndPrintAllPublishers();
			System.out.println("Register new membership type");
//			registerAndPrintNewMembershipType(
//				new MembershipType(
//						null, "Seniors", 0.10, 21
//				)
//			);
		};
	}

	private void getAndPrintAllPublishers() {
		var publishers =  publisherService.getAllPublishers();
		publishers.forEach(System.out::println);
	}

	private void registerNewPublisher(String name, String  email, String phoneNumber,
									  String street, String city, String state, String zipCode) {
		var newPrimaryAddress = new Address(null, street, city, state, zipCode);
		var savedAddress = addressService.addNewAddress(newPrimaryAddress);
		var newPublisher = new Publisher(null, name, email, phoneNumber, savedAddress);
		try {
			var savedPublisher = publisherService.registerNewPublisher(newPublisher);
			System.out.printf("New Publisher created.\n%s", savedPublisher);
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

	// Using Cascade
	private void registerNewPublisher2(String name, String  email, String phoneNumber,
									  String street, String city, String state, String zipCode) {
		var newPrimaryAddress = new Address(null, street, city, state, zipCode);
		var newPublisher = new Publisher(null, name, email, phoneNumber, newPrimaryAddress);
		try {
			var savedPublisher = publisherService.registerNewPublisher(newPublisher);
			System.out.printf("New Publisher created.\n%s", savedPublisher);
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

	private void fetchAndUpdatePublisherById(Integer id, String name, String email, String phoneNumber) {
		var publisher = publisherService.getPublisherById(id);
		if(publisher != null) {
			publisher.setName(name);
			publisher.setEmail(email);
			publisher.setPhoneNumber(phoneNumber);
			var updatedPublisher = publisherService.updatePublisher(publisher);
			System.out.printf("Updated Publisher:\n%s", updatedPublisher);
		}
	}

	private void registerAndPrintNewMembershipType(MembershipType membershipType) {
		var newMembershipType = membershipTypeService.addNewMembershipType(membershipType);
		System.out.printf("New MembershipType created.\n%s\n", newMembershipType);
	}
}

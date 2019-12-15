package CliniqueManagement;



	

	import java.io.IOException;
	import java.util.Date;
	import java.util.Scanner;

	import org.codehaus.jackson.JsonParseException;
	import org.codehaus.jackson.map.JsonMappingException;
public class Clinique
{

		public static void main(String[] args)
				throws JsonParseException, JsonMappingException, IOException, InterruptedException {

			

			CliniqueImplemented service = new CliniqueImplemented();

			// reading json

			service.readJson();

			// creating menu list

			boolean exit = false;

			Scanner scanner = new Scanner(System.in);

			while (!exit) {
				System.out.println("\nSelect option from menu\n");

				System.out.println(
						"1. add doctor\n2. add patient\n3. search doctor by id\n4. search doctor by name\n5. search doctor by specialization\n6. search doctor by availability\n7. search patient by id\n8. search patient by name\n9. search patient by number\n10. add appointment\n11. save\n12. exit\n13. show records\n14. see popular doctor");
				switch (scanner.nextInt()) {
				case 1:
					// add doctor
					System.out.println();
					System.out.println("-------------------------add doctor-----------------------");
					System.out.println();

					Doctor doctor = service.getDoctor();
					service.addDoctor(doctor);

					
					break;
				case 2:
					// add patient
					System.out.println();
					System.out.println("-------------------------add patient-----------------------");
					System.out.println();

					Patient patient = service.getPatient();

					service.addPatient(patient);

					
					break;
				case 3:
					// search doctor by id
					System.out.println();
					System.out.println("-------------------------search doctor by id-----------------------");
					System.out.println();

					service.searchDoctorById();

					
					break;
				case 4:
					// search doctor by name
					System.out.println();
					System.out.println("-------------------------search doctor by name-----------------------");
					System.out.println();

					service.searchDoctorByName();

					
					break;
				case 5:
					// search doctor by specialization
					System.out.println();
					System.out.println("-------------------------search doctor by specialization-----------------------");
					System.out.println();

					String drname = service.getDoctorName();
					service.searchDoctorBySpecialization(drname);

					
					break;
				case 6:
					// search doctor by availability
					System.out.println();
					System.out.println("-------------------------search doctor by availability-----------------------");
					System.out.println();

					System.out.println("Enter doctor date: ");
					String	str = scanner.next();
					System.out.println("Enter time from");
					int time = scanner.nextInt();

					service.searchDoctorByAvailability(str, time);

					
					break;
				case 7:
					// search patient by id
					System.out.println();
					System.out.println("-------------------------search patient by id-----------------------");
					System.out.println();

					System.out.println("Instruction->Patient id starts from 1000 range");
					System.out.println("Enter patient id to search: ");
					int num = scanner.nextInt();

					service.searchPatientById(num);

					
					break;
				case 8:
					// search patient by name
					System.out.println();
					System.out.println("-------------------------search patient by name-----------------------");
					System.out.println();

					service.searchPatientByName();

					
					break;
				case 9:
					// search patient by mobile
					System.out.println("-------------------------search patient by mobile-----------------------");
					System.out.println();

					service.searchPatientByMobile();

					
					break;
				case 10:
					// add appointment
					System.out.println();
					System.out.println("-------------------------add appointment-----------------------");
					System.out.println();

					service.addAppointment();

					
					break;
				case 11:
					// save all objects into json
					System.out.println("-------------------------save-----------------------");
					System.out.println();
					// saving doctor

					service.save();

					
					break;

				case 12:
					// search patient by id
					exit = true;
					System.out.println("Thank you for your time...");
					Thread.sleep(2000);
					break;

				case 13:
					// show records
					service.showAllRecords();
					break;
				case 14:
					service.showPopularDoctor();
					break;
				default:
					System.out.println("Please select valid option");
					
					
				}//switch end
				
				
				
			}//while end

			scanner.close();

		}//main end

	


}//class end

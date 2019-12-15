package CliniqueManagement;



	import java.util.ArrayList;

	
	public class DoctorAppointmentList 
	{

		/**
		 * Purpose: show the records of doctors list
		 * 
		 * @param doctors        list of doctor input from user
		 * @param index          input from user
		 * @param hasSigleRecord input from user
		 */
		/* public static void showDoctorList(ArrayList<Doctor> doctors, int index, boolean hasSigleRecord)
		{

			

		} */

		/**
		 * Purpose: Printing doctor list with numbers on it
		 * 
		 * @param doctors input from user
		 * @param index   input from user
		 * @param num     input from user
		 */
		public static void showDoctorList(ArrayList<Doctor> doctors, int index, int num) {

			System.out.print(doctors.get(index).getDrid() + ". " + doctors.get(index).getDrname() + "\t");
			System.out.print(doctors.get(index).getDrspecialization() + "\t");
			System.out.print(doctors.get(index).getDravailability().getDate() + "\t");
			System.out.print(doctors.get(index).getDravailability().getTimein() + "\t");
			System.out.println(doctors.get(index).getDravailability().getTimeout() + "\t");

		}

		/**
		 * Purpose: method for printing patient list
		 * 
		 * @param patients       input from user
		 * @param index          input from user
		 * @param hasSigleRecord input from user
		 */
		public static void showPatientList(ArrayList<Patient> patients, int index, boolean hasSigleRecord)
		{
			if (hasSigleRecord)
			{
				System.out.print("Patient Details\t\n");
				System.out.print(patients.get(index).getPtid() + "\t");
				System.out.print(patients.get(index).getPtname() + "\t");
				System.out.print(patients.get(index).getPtage() + "\t");
				System.out.println(patients.get(index).getPtmobile() + "\t");
			} 
			else 
			{
				System.out.print(patients.get(index).getPtid() + "\t");
				System.out.print(patients.get(index).getPtname() + "\t");
				System.out.print(patients.get(index).getPtage() + "\t");
				System.out.println(patients.get(index).getPtmobile() + "\t");
			}
		}

	


}

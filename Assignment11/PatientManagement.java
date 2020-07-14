// Assignment #: 11
// Name: Madhav Arun Sharma
// StudentID: 1216873476
// Lecture: MW 4:35 PM
// Description: This program manages patient queues, assigns patients to doctors,
//              release them to check out, etc.
import java.util.LinkedList;
public class PatientManagement
{
	private LinkedList<Patient> highPriorityQueue; //Requires immediate life-saving intervention
	private LinkedList<Patient> intermediateQueue; //Requires significant intervention within two to four hours.
	private LinkedList<Patient> delayedCareQueue; //Needs medical treatment, but this can safely be delayed.
	private LinkedList<Patient> checkOutQueue; //queue for patients that need to check out
	private Doctor[] doctorList; //an array of doctors
	//Constructor to initialize member variables
	public PatientManagement(int numOfDoctors)
	{
		highPriorityQueue = new LinkedList<Patient>();
		intermediateQueue = new LinkedList<Patient>();
		delayedCareQueue = new LinkedList<Patient>();
		checkOutQueue = new LinkedList<Patient>();
		//creating doctor objects
		doctorList = new Doctor[numOfDoctors];
		for (int i=0; i<doctorList.length; i++)
		{
			doctorList[i] = new Doctor(i);
		}
	}
	//The printQueue prints out the content
	//of the queues and the array of doctors
	public void printPatientQueues()
	{
		System.out.print("\nHigh Priority Queue:\n" + highPriorityQueue.toString() + "\n");
		System.out.print("\nIntermediate Queue:\n" + intermediateQueue.toString() + "\n");
		System.out.print("\nDelayed Care Queue:\n" + delayedCareQueue.toString() +"\n\n");
		for (int i = 0; i < doctorList.length; i++)
		{
			System.out.println(doctorList[i].toString());
		}
		System.out.print("\nCheck Out Queue:\n" + checkOutQueue.toString() + "\n\n");
	}
	//More Methods need to be added here

	//Define the method addPatient()
	//This method adds a patient of the parameter patientID and conditionLevel 
	//to its corresponding queue.
	boolean addPatient(int patientID, String conditionLevel) 
	{
		//If the parameter conditionLevel is “High Priority”
		if (conditionLevel.equals("High Priority")) 
		{
			//instantiate a Patient object using its id and conditionLevel, 
			Patient patient1 = new Patient(patientID, conditionLevel);
			//and add it to the highPriorityQueue
			highPriorityQueue.add(patient1);

			return true;
		} 
		//If the parameter conditionLevel is “Intermediate”
		else if (conditionLevel.equals("Intermediate")) 
		{
			//instantiate a Patient object using its id and conditionLevel, 
			Patient patient1 = new Patient(patientID, conditionLevel);
			//and add it to the intermediateQueue
			intermediateQueue.add(patient1);

			return true;
		} 
		//If the parameter conditionLevel is “Delayed Care”
		else if (conditionLevel.equals("Delayed Care")) 
		{
			//instantiate a Patient object using its id and conditionLevel, 
			Patient patient1 = new Patient(patientID, conditionLevel);
			//and add it to the delayedCareQueue
			delayedCareQueue.add(patient1);

			return true;
		}
		//If the conditionLevel is none of these three, 
		//and it should return false
		return false;
	}

	//Define the method assignPatientToDoctor()
	//This method needs to check the priority queues and assign the patient to a doctor. 
	Patient assignPatientToDoctor() 
	{
		//check if there is any patient in the highPriorityQueue
		if (highPriorityQueue.size() != 0) 
		{
			//assign the patient to a doctor
			Patient patient1 = highPriorityQueue.getFirst();
			for (int i = 0; i < doctorList.length; i++) 
			{
				if (doctorList[i].hasPatient()) 
				{
					doctorList[i].assignPatient(patient1);
					highPriorityQueue.removeFirst();
					//return the patient object
					return patient1;
				}
			}
		} 
		//check if there is any patient in the intermediateQueue
		else if (intermediateQueue.size() != 0) 
		{
			//assign the patient to a doctor
			Patient patient1 = intermediateQueue.getFirst();
			for (int i = 0; i < doctorList.length; i++) 
			{
				if (doctorList[i].hasPatient()) 
				{
					doctorList[i].assignPatient(patient1);
					intermediateQueue.removeFirst();
					//return the patient object
					return patient1;
				}
			}
		} 
		//check if there is any patient in the delayedCareQueue
		else if (delayedCareQueue.size() != 0) 
		{
			//assign the patient to a doctor
			Patient patient1 = delayedCareQueue.getFirst();
			for (int i = 0; i < doctorList.length; i++) 
			{
				if (doctorList[i].hasPatient()) 
				{
					doctorList[i].assignPatient(patient1);
					delayedCareQueue.removeFirst();
					//return the patient object
					return patient1;
				}
			}
		}
		//no doctor available or no patient in any of the three waiting queues,
		//it should return null
		return null;
	}

	//Define the method releasePatientFromDoctorToCheckOutQueue()
	//This method should check if the doctor of the give parameter doctorID 
	//has any patient and release that patient,and add that patient into the checkOutQueue.
	Patient releasePatientFromDoctorToCheckOutQueue(int doctorID)
	{
		if (doctorList[doctorID].hasPatient() == false) 
		{
			//add the patient into the checkOutQueue
			Patient patient1 = doctorList[doctorID].releasePatient();
			checkOutQueue.add(patient1);

			//return the released the patient
			return patient1;
		}
		//If the doctor of the given parameter doctorID does not have any patient
		//or the parameter doctorID is not valid, it should return null
		return null;
	}

	//Define the method checkOutPatient()
	//If the checkOutQueue is not empty, this method should remove the next patient
	//from the queue and return it.
	Patient checkOutPatient() 
	{
		//If the checkOutQueue is not empty,
		if (checkOutQueue.isEmpty() == false) 
		{
			//remove the next patient from the queue
			Patient patient1 = checkOutQueue.getFirst();
			checkOutQueue.removeFirst();

			//and return the removed patient
			return patient1;
		}
		//If the checkOutQueue is empty, it should return null
		return null;
	}
}
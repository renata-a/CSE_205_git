// Assignment #: 11
// Name: Madhav Arun Sharma
// StudentID: 1216873476
// Lecture: MW 4:35 PM
// Description: This class checks if the doctor has an assigned patient, and
//              assigns and releases patients
public class Doctor
{
	private int doctorID;
	private Patient currentPatient;
	//Constructor to initialize member variables
	//Initially no patient is assigned
	public Doctor(int id)
	{
		this.doctorID = id;
		currentPatient = null;
	}
	//toString method returns a string containing
	//the information of a doctor 
	public String toString()
	{
		String result = "Doctor id " + doctorID;
		if (currentPatient == null)
			result += " is not seeing any patient";
		else
			result += " is seeing a patient with id " + currentPatient.getPatientID();
		return result;
	}
	//More Methods need to be added here

	//Define the method hasPatient()
	//If the doctor has an assigned patient, then it should return true.
	//Otherwise, it should return false. 
	public boolean hasPatient() 
	{
		//Check if currentPatient is null
		if (currentPatient == null)
			//if currentPatient is not null, then return
			return true;
		//else return false
		return false;
	}

	//Define the method assignPatient()
	//If the doctor does not have any assigned patient, assign the parameter patient1 
	//to its currentPatient and return true, otherwise return false.
	public boolean assignPatient(Patient patient1) 
	{
		//Check if currentPatient is null
		if (currentPatient == null) 
		{
			//if currentPatient is null, then assign the parameter patient1 to currentPatient
			currentPatient = patient1;
			return true;
		}
		//else return false
		return false;
	}

	//Define the method releasePatient()
	//If the doctor has an assigned patient, it should set its currentPatient to null
	//but it also needs to return the Patient object that was assigned as its currentPatient. 
	//Otherwise, it should return null.
	Patient releasePatient() 
	{
		//Check if currentPatient is null
		if (currentPatient != null) 
		{
			//if currentPatient is not null, then set currentPatient to null
			Patient patient1 = currentPatient;
			currentPatient = null;

			//return Patient object
			return patient1;
		}
		//else return null
		return null;
	}
}
// Assignment #: 8
//         Name: MADHAV ARUN SHARMA
//    StudentID: 1216873476
//      Lecture: M W 4:35 PM
//  Description: The ClubManagement class has a list of Club objects 
//               that can be organized at the club management system

import java.io.Serializable;

public class ClubManagement implements Serializable {
	//declare the variables
	private Club[] clubList;
	private int numberOfClubs;
	private int maxSize;

	//A Constructor of the ClubManagement class.
	public ClubManagement(int maximumsize){
		// initialize the member variable maxSize.
		this.maxSize =maximumsize;
		//instantiate an array of Club objects using the maxSize
		this.clubList = new Club[maxSize];
		//initialize each slot of the array to null for every index.
		for(int i=0; i<this.maxSize ;i++){
			clubList[i] = null;
		}
		//initialize the member variable numberOfClubs to 0
		numberOfClubs = 0;
	}
	//definition of the method clubExists()
	//Search for a Club object by clubName and university,
	//and return the index of the object if found.
	public int clubExists(String clubName, String university){
		for(int i=0; i<this.maxSize ;i++){

			Club current = this.clubList[i];
			if(null!=current){

				if(current.getClubName().equalsIgnoreCase(clubName) &&
						current.getUniversity().equalsIgnoreCase(university)){
					return i;
				}
			}
		}
		// Return -1 if not found.
		return -1;
	}
	//definition of the method currentPresidentExists()
	public int currentPresidentExists(String firstName, String lastName, String academicLevel){
		for(int i=0; i<this.maxSize ;i++){
			Club current = this.clubList[i];
			//Search and for Club objects in the club list that have the same
			//firstName, lastName and academicLevel as the
			//parameter values and return the index of such object if found
			if(null!=current){
				if(firstName.equalsIgnoreCase(current.getCurrentPresident().getFirstName())
						&& lastName.equalsIgnoreCase(current.getCurrentPresident().getLastName())
						&& academicLevel.equalsIgnoreCase(current.getCurrentPresident().getAcademicLevel())){
					return i;
				}
			}
		}
		//Return -1 if not found.
		return -1;
	}
	//definition of the method addClub()
	public boolean addClub(String clubName, int numberOfMembers, String university, String firstName, 
			String lastName, String academicLevel){

		Club club = new Club();
		//Add a Club object to the club list and
		//return true if such object was added successfully
		club.setClubName(clubName);
		club.setNumberOfMembers(numberOfMembers);
		club.setUniversity(university);
		club.setCurrentPresident(firstName, lastName, academicLevel);

		if(currentPresidentExists(firstName, lastName, academicLevel) < 0){

			if(this.numberOfClubs < this.maxSize){
				clubList[this.numberOfClubs] = club;
				this.numberOfClubs++;
				return true;
			}
		}
		//Return false if an object with the same clubName, numberOfMembers,
		//university, firstName, lastName and academicLevel already exists
		//or numberOfClubs is already same as maxSize
		return false;
	}
	//definition of the method removeClub()
	boolean removeClub(String clubName, String university){

		int i;

		int index = clubExists(clubName, university);
		
		if(index !=-1){

			for(i = index; i < numberOfClubs; i++){

				clubList[i] = clubList[i+1];
			}
			numberOfClubs--;
			return true;
		}

		//Return false if the object with the given
		//clubName and university does not exist.
		return false;
	}
	//definition of the method sortByClubNames()
	public void sortByClubNames(){
		Sorts.sort(clubList, numberOfClubs, new ClubNameComparator());
	}
	//definition of the method sortByMemberNumbers()
	public void sortByMemberNumbers(){
		Sorts.sort(clubList, numberOfClubs, new MemberNumberComparator());
	}
	//definition of the method sortByCurrentPresidents()
	public void sortByCurrentPresidents(){
		Sorts.sort(clubList, numberOfClubs, new CurrentPresidentComparator());
	}

	//definition of the method listClubs()
	//List all Club objects in the club list
	public String listClubs(){
		if(numberOfClubs == 0){
			return "\nno club\n\n";
		}
		String newStr = "";

		for(int i=0;i<numberOfClubs;i++){
			newStr += clubList[i].toString();
		}
		return "\n" + newStr + "\n";
	}
	//definition of the method closeClubManagement()
	public void closeClubManagement(){
		for(int i=0; i<this.maxSize ;i++){
			clubList[i] = null;
		}
		numberOfClubs =0;
	}
	//getter and setter methods of the instance variables.
	public Club[] getClubList() {
		return clubList;
	}
	public void setClubList(Club[] clubList) {
		this.clubList = clubList;
	}
	public int getNumberOfClubs() {
		return numberOfClubs;
	}
	public void setNumberOfClubs(int numberOfClubs) {
		this.numberOfClubs = numberOfClubs;
	}
	public int getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
}


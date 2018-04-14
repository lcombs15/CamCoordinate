package application;

public interface Organizable {
	
	//Merge yourself with destination
	public void merge(Organizable destination);
	
	/*
	 * 1.) Write file data to DB
	 * 2.) Physically move images on disk
	*/
	public void publish();
}
public class Commitment {

	private String name;
	private String hour;
	private String location;
			
	public Commitment(String name, String hour, String location) {
		this.name = name;
		this.hour = hour;
		this.location = location;
	}
	
	public Commitment() {
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Commitment: "+ this.name + "\n" +
				"At: " + this.hour + "\n" +
				"Location: " + this.location + "\n\n";
	}
		
	public String writeCommitment() { 
		return  this.name + " * " + this.hour + " * " + this.location + "\n";
	}
}

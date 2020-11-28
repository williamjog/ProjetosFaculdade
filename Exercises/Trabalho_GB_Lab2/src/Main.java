import java.util.Scanner;

public class Main {
	
	// William Jansen Ostrowski Gomes - Individual 
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		boolean validOption = true;

		String file = "Schedule.txt";
		
		Schedule schedule = new Schedule();
		
		schedule.getCommitments(file);
				
		while (validOption) {

			try {
				System.out.println("MENU:");
				System.out.println("1 - Create a new commitment");
				System.out.println("2 - Read all commitments");
				System.out.println("3 - Update a commitment info");
				System.out.println("4 - Delete a commitment by its name");
				System.out.println("5 - Exit");
				System.out.println("\nChoose an option from the menu above:");
				int option = Integer.parseInt(sc.nextLine());
				
				if (option < 1 || option > 8) {
					validOption = false;
					System.out.println("Terminated.");
				} else {
					if (option == 1) {
						System.out.println("\nWrite the commitment name: ");
						String name = sc.nextLine();
						System.out.println("\nWrite the commitment hour: ");
						String hour = sc.nextLine();
						System.out.println("\nWrite the commitment location: ");
						String location = sc.nextLine();
						Commitment commitment = new Commitment(name, hour, location);
						schedule.addCommitment(commitment, file);
					} else if (option == 2) {
						if (!schedule.isEmpty()) {
							System.out.println("\n" + schedule);
						} else {
							System.out.println("\nEmpty agenda!\n");
						}
					} else if (option == 3) {
						System.out.println("Write the commitment name: ");
						String name = sc.nextLine();
						boolean doesTheCommitentExist = schedule.searchCommitment(name);
						if (doesTheCommitentExist) {
							System.out.println("Which field should be updated?");
							System.out.println("[1 - Name] - [2 - Hour] - [3 - Location]");
							int field = Integer.parseInt(sc.nextLine());
							if (field < 0 || field > 3) {
								System.out.println("Invalid Option!\n");
								System.out.println("Which field should be updated?");
								System.out.println("[1 - Name] - [2 - Hour] - [3 - Location]");
								field = Integer.parseInt(sc.nextLine());
							}
							System.out.println("Write the new info: ");
							String newInfo = sc.nextLine();
							schedule.updateCommitmentInfo(name, field, newInfo, file);
						} else {
							System.out.println("Commitment not found!\n");
						}
					} else if (option == 4) {
						System.out.println("Write the commitment name: ");
						String name = sc.nextLine();
						schedule.removeCommitment(name, file);
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("\nInvalid Option!\n");
			}
	    }
		sc.close();
	}
}

import java.time.LocalDate;
import java.util.Scanner;
class HealthProfileCreator {
    public static HealthProfile createProfileFromInput() {
        try(Scanner in = new Scanner(System.in)) {
            System.out.println("Enter in the patient's full name in (Doe, John)");
            System.out.print("-> ");
            String fullName = in.nextLine();
            
            System.out.println("Enter in the patient's gender'");
            System.out.print("-> ");
            char gender = in.next().charAt(0);
            
            System.out.println("Enter in the patients date of birth (mm/dd/yyyy)");
            System.out.print("-> "); 
            String dob = in.nextLine();

            System.out.println("Enter in the patient's height");
            System.out.print("->" );
            int height = in.nextInt();

            System.out.println("Enter in the patient's wight");
            System.out.print("->" );
            int weight = in.nextInt();

            String[] numbers = dob.split("/");
            int month = Integer.parseInt(numbers[0]);
            int day = Integer.parseInt(numbers[1]);
            int year = Integer.parseInt(numbers[2]);

            return new HealthProfile(
                fullName, gender, LocalDate.of(year, month, day), height, weight);
        }
    }
}
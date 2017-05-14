import java.time.LocalDate;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
class HealthProfileFactory {
    public static HealthProfile createProfileFromInput() {
        try(Scanner in = new Scanner(System.in)) {

            String fullName = 
                prompt("Enter in the patient's full name ex: Doe, John" ,
                () -> in.nextLine());
            
            
            char gender = prompt("Enter in the patient's gender" , 
                () -> in.nextLine().charAt(0));

            String dob = prompt("Enter in the patients date of birth ex: mm/dd/yyyy",
                () -> in.nextLine());

            int height = prompt("Enter in the patient's height", 
                () -> in.nextInt());

            int weight = prompt("Enter in the patient's wight",
                () -> in.nextInt());

            String[] numbers = dob.split("/");
            int month = Integer.parseInt(numbers[0]);
            int day = Integer.parseInt(numbers[1]);
            int year = Integer.parseInt(numbers[2]);

            return new HealthProfile(
                fullName, gender, LocalDate.of(year, month, day), height, weight);
        }
    }

     public static <T> T prompt(String message, Supplier<T> func) {
            System.out.println(message);
            System.out.print("-> " );
            T result = func.get();
            return result;
        }
}
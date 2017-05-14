import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Supplier;

class HealthProfileFactory {
    public static HealthProfile createProfileFromInput() {
        try(Scanner in = new Scanner(System.in)) {

            String fullName = 
                prompt("Enter in the patient's full name ex: Doe, John" ,
                    () -> in.nextLine());
            
            char gender = 
                prompt("Enter in the patient's gender" , 
                    () -> in.nextLine().charAt(0));

            LocalDate dob = 
                prompt("Enter in the patients date of birth ex: mm/dd/yyyy",
                    () -> LocalDate.parse(in.nextLine(), 
                          DateTimeFormatter.ofPattern("M/dd/yyyy" , Locale.US)));

            int height = 
                prompt("Enter in the patient's height", 
                    () -> in.nextInt());

            int weight = 
                prompt("Enter in the patient's wight",
                    () -> in.nextInt());
            return new HealthProfile(
                fullName, gender, dob, height, weight);
        }
        catch(Exception e) {
            System.out.println("Something was not input correctly");
            return null;
        }
    }

     public static <T> T prompt(String message, Supplier<T> func) {
        System.out.println(message);
        System.out.print("-> " );
        T result = func.get();
        return result;
    }
}
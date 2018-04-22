import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        MyLinkedList<String> studentName = new MyLinkedList<>();
        Scanner input = new Scanner(System.in);
        String name = "";

        System.out.println("Enter your student name list. Enter 'n' to end.....");
        while(input.hasNext()){
            name = input.nextLine();
            if(!name.equals("n"))
                studentName.add(name);
            else
                break;
        }
        System.out.println();

        System.out.println("You have entered the following students' name : ");
        studentName.printList();
        System.out.println();

        System.out.println("The number of students entered is : " + studentName.getSize());
        System.out.println();

        System.out.println("All the names entered are correct? Enter 'r' to rename the student name, 'n' to proceed.");
        String option = input.nextLine();
        System.out.println();

        if(option.equals("r")){
            System.out.println("Enter the existing student name that you want to rename : ");
            String e = input.nextLine();
            System.out.println();

            System.out.println("Enter the new name : ");
            String newE = input.nextLine();
            System.out.println();
            studentName.replace(e,newE);

            System.out.println("The new student list is : ");
            studentName.printList();
            System.out.println();
        }

        System.out.println("Do you want to remove any of your sudent name? Enter 'y' for yes, 'n' to proceed.");
        String option2 = input.nextLine();
        System.out.println();

        if(option2.equals("y")){
            System.out.println("Enter a student name to remove : ");
            String name2 = input.nextLine();
            System.out.println();

            studentName.removeElement(name2);
            System.out.println("The number of updated student is : " + studentName.getSize());
            System.out.println();

            System.out.println("The updated students list is : ");
            studentName.printList();
            System.out.println();

            System.out.println("All student data captured complete. Thank you!");
        }
    }
}

import java.util.Scanner;

public class ClassObjects {


    public static void main(String[] args) {
        Trainer trainer = new Trainer();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the trainer name: ");
        trainer.trainerName = sc.nextLine();
        System.out.println("Enter the trainer technology: ");
        trainer.trainerTechnology = sc.nextLine();

        System.out.println(trainer.trainerName + " " + trainer.trainerTechnology);


        Student student = new Student();
        System.out.println("Enter the Student name: ");
        student.studentName = sc.nextLine();
        System.out.println("Enter the Student technology: ");
        student.enrolledTechnology = sc.nextLine();

        System.out.println(student.studentName + " " + student.enrolledTechnology);

        System.out.println("Enter your first name: ");
        trainer.fName = sc.nextLine();
        System.out.println("Enter your middle name: ");
        trainer.mName = sc.nextLine();
        System.out.println("Enter your last name: ");
        trainer.lName = sc.nextLine();

        String tName = trainer.nameConcatenates(trainer.fName, trainer.lName);
        String fullName = trainer.nameConcatenate(trainer.fName, trainer.mName, trainer.lName);
        System.out.println("Trainer full name in Japan: " + tName);
        System.out.println("Trainer Full name in India: " + fullName);

        //Student

        System.out.println("Enter your first name: ");
        student.fName = sc.nextLine();
        System.out.println("Enter your middle name: ");
        student.mName = sc.nextLine();
        System.out.println("Enter your last name: ");
        student.lName = sc.nextLine();

        String sName = student.nameConcatenates(student.fName, student.lName);
        String sfullName = student.nameConcatenate(student.fName, student.mName, student.lName);
        System.out.println("Student full name in Japan: " + sName);
        System.out.println("Student Full name in India: " + sfullName);
    }
}

class Trainer {
    String trainerName;
    String trainerTechnology;
    String fName;
    String lName;
    String mName;

    public static String nameConcatenates(String fName, String lName){

        return lName + " " + fName;
    }

    String nameConcatenate(String fName, String mName, String lName){

        return lName + mName + fName;
    }
}

class Student {
    String studentName;
    String enrolledTechnology;
    String fName;
    String lName;
    String mName;

    public static String nameConcatenates(String fName, String lName){

        return lName + " " + fName;
    }

    String nameConcatenate(String fName, String mName, String lName){

        return lName + mName + fName;
    }
}



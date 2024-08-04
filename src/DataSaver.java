import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataSaver
{
    public static void main(String[] args)
    {
        List<String> rec = new ArrayList<>();


        Scanner in = new Scanner(System.in);


        boolean input = true;


        while(input) {


            String firstName = SafeInput.getNonZeroLenString(in,"Enter First Name: ");
            String lastName = SafeInput.getNonZeroLenString(in,"Enter Last Name: ");
            String idNumber = SafeInput.getRegExString (in,"Enter ID Number (6 digits): ","^\\d{6}$");
            String email = SafeInput.getNonZeroLenString(in,"Enter Email: ");
            String yearOfBirth = SafeInput.getRegExString(in,"Enter Year of Birth (4 digits): ","^\\d{4}$");


            String csvRecord = String.format("%s, %s, %s, %s, %s", firstName, lastName, idNumber, email, yearOfBirth);
            rec.add(csvRecord);


            input = SafeInput.getYNConfirm(in,"Do you want to add another record? (yes/no): ");
        }


        String fileName = SafeInput.getNonZeroLenString(in,"Enter the file name (include .csv extension): ");


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/" + fileName)))
        {
            for (String record : rec)
            {
                writer.write(record);
                writer.newLine();
            }
            System.out.println("Data file written to: " + fileName);
        }
           catch (IOException e)

           {

            e.printStackTrace();

           }

        in.close();

    }

}

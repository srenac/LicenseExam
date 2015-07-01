package licenseexam;
import java.util.Scanner;//input

/**
 *
 * @author SerenaCha
 */
public class LicenseExam {

    /**
     * @param args the command line arguments
     */
    //STORE correct answers into an array 
    public String[] user_Input;
    public String[] correctAnswers = {"B","D","A","A","C","A","B","A","C","D","B","C","D","A",
                                      "D","C","C","B","D","A"};
    int[] missedQ = new int[correctAnswers.length];
    int correctCount;
    int incorrectCount;
    
    public LicenseExam(String[] input)
    {
        user_Input = input;
    }
    
    public boolean pass()
    {
        if(correctCount >= 15) //pass only if they answer 15 or more
        {
            System.out.println("\nYou passed the Driver's License Exam.");
            return true;
        }
        else
        {
            System.out.println("\nYou failed the Driver's License Exam.");
            return false;
        }
    }
    //Correct() function checks to see how many user got correct
    public int Correct()
    {
        for(int i = 0; i < correctAnswers.length; i++)
        {
            if(user_Input[i].equalsIgnoreCase(correctAnswers[i]))
            {
                correctCount++;
            }
        }
        return correctCount;
    }
    //Incorrect() function checks to see how many the user got incorrect
    public int Incorrect()
    {
        for(int i = 0; i < correctAnswers.length; i++)
        {
            if(!user_Input[i].equalsIgnoreCase(correctAnswers[i]))
            {
                missedQ[incorrectCount] = i + 1;
                incorrectCount++;
            }
        }
        return incorrectCount;
    }
    //Missed() function to display the question number the user got wrong
    public int[] Missed()
    {
        int total;
        total = correctAnswers.length - correctCount;
        int [] missedQ = new int [total];
        int counter = 0;
        
        for(int i = 0; i < correctAnswers.length; i++)
        {
            if(!user_Input[i].equalsIgnoreCase(correctAnswers[i]))
            {
                missedQ[counter] = i + 1;
                System.out.println("You missed question number " 
                        + missedQ[counter]);
                counter++;
            }          
        }
        return missedQ;
    } 
    //main
    public static void main(String[] args) {
        // TODO code application logic here
        
        String[] exam_answers = new String[20];
        String answers;
        
        System.out.println("Driver's License Exam");
        System.out.println("This exam is consist of 20 questions. You must answer 15/20 to"
                + "\npass the exam, otherwise you fail the exam. Goodluck.");

        for(int i = 0; i < exam_answers.length; i++)
        {
            System.out.println("License Exam Q# " + (i + 1) + ": ");
            Scanner input = new Scanner(System.in);
            answers = input.next();
            
            while((!answers.equalsIgnoreCase("A")) && (!answers.equalsIgnoreCase("B"))
                    &&(!answers.equalsIgnoreCase("C")) && (!answers.equalsIgnoreCase("D")))
            {
                System.out.println("Please only answer with A, B, C, D.");
                answers = input.next();
            }   
            exam_answers[i] = answers;
        }
        LicenseExam le = new LicenseExam(exam_answers); //create object& le stands for License Exam
        System.out.println("\nCorrect answers : " + le.Correct());
        System.out.println("Incorrect answers : " + le.Incorrect());
        
        //just call the pass function to display if they passes the exam or not
        le.pass();
        //just call the Missed function to show what questions were missed.
        //note: not sure how to display in one whole line so displayed it in a 
        le.Missed();        
    }
}

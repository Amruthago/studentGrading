import java.util.Scanner;
public class StudentGrading {
    public static void main(String[] args) {
        System.out.println("=======================STUDENT GRADING=========================");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        int n=sc.nextInt();
        System.out.println("Enter the number of subjects: ");
        int m=sc.nextInt();
        String[] names=new String[n];
        int[][] marks=new int[n][m]; 
        char[] grades=new char[n];
        double[] percentages=new double[n];

        StudentDetails(names,marks,n,m,percentages,grades,sc);
        int Topper=FinfTopper(percentages);
        displayResults(names,marks,percentages,grades,n,m,Topper);
    }
        
        public static void StudentDetails(String[] names,int[][] marks,int n,int m,double[] percentages,char[] grades,Scanner scanner){
            System.out.println("=======================ENTER STUDENT DETAILS============================");
            for(int i=0;i<n;i++){
                System.out.println("Enter the Student name "+(i+1)+":  ");
                names[i]=scanner.next();
                int sum=0;
                for(int j=0;j<m;j++){
                    System.out.println("Enter the marks of Student "+names[i]+" in subject "+(j+1)+":  ");
                    marks[i][j]=scanner.nextInt();
                    if(marks[i][j]>=0  && marks[i][j]<=100){
                        
                        System.out.println("");
                    }
                    else{
                        System.out.println("Invalid input. Please enter positive marks between 0 and 100.");
                        j--;
                        continue;
                       
                    }
                    sum+=marks[i][j];
                }
                percentages[i]=(int)sum/m;
                grades[i]=GradeCount(percentages[i]);
            


            }
        }
        public static char  GradeCount(double percentage){
            if(percentage>=90){
                return 'A';
            }
            else if(percentage>=80){
                return 'B';
            }
            else if(percentage>=70){
                return 'C';
            }
            else if(percentage>=60){
                return 'D';
            }
            else{
                return 'F';
            }
        }
        public static int FinfTopper(double[] percentages){
            int topperIndex=0;
            for(int i=1;i<percentages.length;i++){
                if(percentages[i]>percentages[topperIndex]){
                    topperIndex=i;
                }
            }
            return topperIndex;
            
        }

public static void displayResults(String[] names,int[][] marks,double[] percentages,char[] grades,int n,int m,int topperIndex){
    System.out.println("=======================STUDENT PERFORMANCE CARD ===============================");
    System.out.println("Student Name\tMarks\tPercentage\tGrade");
    for(int i=0;i<n;i++){
        int total=0;
        System.out.print(names[i]+"\t");
        for(int j=0;j<m;j++){
            total+=marks[i][j];
           
        }
        if(i==topperIndex){
            System.out.print(total+"\t"+percentages[i]+"\t"+grades[i]+"\t"+"TOPPER\n");
        }
        else{
            System.out.print(total+"\t"+percentages[i]+"\t"+grades[i]+"\n");
    
        }
      
    }
}

}

       
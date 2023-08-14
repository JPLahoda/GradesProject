/* Jason Lahoda
 * Section 4
   This program accepts your homework and two exam scores as input and computes your grade in the course. */
import java.util.Scanner;
public class Grades {
	
	public static void main(String[] args) {	
		
		Scanner myObj = new Scanner(System.in);
		System.out.println("Homework weight?");
		int homeworkWeight = myObj.nextInt();
		
		Scanner myObj2 = new Scanner(System.in);
		System.out.println("Exam 1 weight?");
		int exam1Weight = myObj2.nextInt();
		
		
		
		System.out.println("Using weights of " + homeworkWeight + " " + exam1Weight + " 30");
		
		
		System.out.println("Homework:");
		
		Scanner myObj3 = new Scanner(System.in);
		System.out.println("Number of Assignments?");
		int numberOfAssign = myObj3.nextInt();
		
		Scanner myObj4 = new Scanner(System.in);
		System.out.println("Average Homework grade?");
		float averageHomework = myObj4.nextFloat();
		
		Scanner myObj5 = new Scanner(System.in);
		System.out.println("Number of late days used?");
		int numberOfLate = myObj5.nextInt();
		
		Scanner myObj6 = new Scanner(System.in);
		System.out.println("Labs attended?");
		int numberOfLabs = myObj6.nextInt();
		
		System.out.println("Total points = " + totalHomeworkScore(numberOfAssign, averageHomework, numberOfLate, numberOfLabs) + " / " + "140");
		System.out.println("Weighted score = " + weight1(numberOfLabs, averageHomework, homeworkWeight));
		
		

		System.out.println("Exam 1:");
		
		Scanner myObj7 = new Scanner(System.in);
		System.out.println("Score?");
		int exam1Score = myObj7.nextInt();
		
		Scanner myObj8 = new Scanner(System.in);
		System.out.println("Curve?");
		int exam1Curve = myObj8.nextInt();
		
		System.out.println("Total points = " + totalExam1Score(exam1Score, exam1Curve) + " / 100");
		System.out.println("Weighted score = " + (exam1Weight * totalExam1Score(exam1Score, exam1Curve) / 100));

		
		
		System.out.println("Exam 2:");

		Scanner myObj9 = new Scanner(System.in);
		System.out.println("Score?");
		int exam2Score = myObj9.nextInt();
		
		Scanner myObj10 = new Scanner(System.in);
		System.out.println("Curve?");
		int exam2Curve = myObj10.nextInt();
		
		System.out.println("Total points = " + totalExam2Score(exam2Score, exam2Curve) + " / 100");
		System.out.println("Weighted score = " + (30 * totalExam2Score(exam2Score, exam2Curve) / 100));
		
		
		
		System.out.println("Course grade = " + (weight1(numberOfLabs, averageHomework, homeworkWeight) + (exam1Weight * totalExam1Score(exam1Score, exam1Curve) / 100) + (30 * totalExam2Score(exam2Score, exam2Curve) / 100)));
		
	}
	
	public static double weight1(int numberOfLabs, double averageHomework, int homeworkWeight) {
		
		return (homeworkWeight * (averageHomework * 10 + numberOfLabs * 4) / 140);
	
	}
	
	public static double totalExam1Score(int exam1Score, int exam1Curve) {
		
		int exam1Final = exam1Score;
		if (exam1Score <= 0) {
			exam1Score = 0;
			return exam1Score;
		}
		else if (exam1Score > 0) {
			if (exam1Score + exam1Curve >= 100) {
				exam1Final = 100;
			}
			else {
				exam1Final += exam1Curve;
			}
		}
		return exam1Final;
	}
				
	public static double totalExam2Score(int exam2Score, int exam2Curve) {
		
		int exam2Final = exam2Score;
		if (exam2Score <= 0) {
			exam2Score = 0;
			return exam2Score;
		}
		else if (exam2Score > 0) {
			if (exam2Score + exam2Curve >= 100) {
				exam2Final = 100;
			}
			else {
				exam2Final += exam2Curve;
			}
		}
		return exam2Final;
		
	}

	
	public static double totalHomeworkScore(int numberOfAssign, double averageHomework, int numberOfLate, int numberOfLabs) {
		
		if (averageHomework <= 0) {
			averageHomework = 0;
		}
		
		else if (averageHomework > 10) {
			averageHomework = 10;
		}
		
		double totalPoints = numberOfAssign * averageHomework + numberOfLabs * 4;
		double maxPoints = numberOfAssign * 14;
				
		if (numberOfLate > numberOfAssign / 2) {
			totalPoints *= .9;
		}
		
		else if (numberOfLate == 0) {
			totalPoints += 5;
			if (totalPoints > maxPoints) {
				totalPoints = maxPoints;
			}
		}
		
		
		if (numberOfAssign <= 0) {
			totalPoints = maxPoints;
		}
		
		return totalPoints;
		
	}
	

}

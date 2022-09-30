import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to Student Management App");
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("PRESS 1 to ADD student");
			System.out.println("PRESS 2 to Delete student");
			System.out.println("PRESS 3 to Display student");
			System.out.println("PRESS 4 to Exit App");
			
			int c=Integer.parseInt(br.readLine());
		
			if(c == 1) {
				//add student..
				System.out.println("Enter user Name: ");
				String name = br.readLine();
				
				System.out.println("Enter user Phone: ");
				String phone = br.readLine();
				
				System.out.println("Enter user City");
				String city = br.readLine();
				
				//create student object
				Student st = new Student(name,phone,city);
				boolean answer = StudentDao.inserStudentToDB(st);
				if(answer) {
					System.out.println("Student added successfully...");
				}
				else {
					System.out.println("Something went wrong.Try again....");
				}
				System.out.println(st);
				
				
			}
			else if(c == 2) {
				//delete student..
				System.out.println("Enter student ID to delete: ");
				int userId = Integer.parseInt(br.readLine());
				boolean f = StudentDao.deleteStudent(userId);
				if(f) {
					System.out.println("Deleted....");
				}
				else {
					System.out.println("Something went wrong....");
				}
				
			}
			else if(c == 3) {
				//display students..
				StudentDao.showAllStudent();
			}
			else if(c == 4) {
				break;
			}
			else {
				
			}
		}
		System.out.println("Thankyou for using my application...");
		System.out.println("See you soon! Bye:)");
	
	}

}

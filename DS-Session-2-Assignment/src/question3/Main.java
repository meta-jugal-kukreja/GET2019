package question3;

/**
 * This class handles the UI part of the CollegeCounselling class
 * @author Jugal
 * Dated 08/01/2019
 */
public class Main {

	public static void main(String[] args) throws Exception {
		CollegeCounseling obj = new CollegeCounseling();
		Queue<Student> queue = obj.allocateStudentsToQueue();
		obj.getProgramList();
		System.out.println("Program List : ");
		for(int i = 0; i < obj.programList.size(); i++)
		{
			System.out.println(obj.programList.get(i).getName() + " " + obj.programList.get(i).getCapacity());
		}
		
		System.out.println("Student List : ");
		queue.displayQueue();
		
		obj.allocateStudentToProgram(queue);
		System.out.println("\nStudent List after allocation : \n");
		for(int i = 0; i < obj.studentList.size(); i++)
		{
			System.out.println(obj.studentList.get(i).getName() + " " + obj.studentList.get(i).getAllocatedProgram());
		}
		
		obj.makeExcelSheet();
		System.out.println("\n\nExcel sheet is ready");
	}
}

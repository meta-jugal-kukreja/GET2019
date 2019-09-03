package question3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * This class handles the functionality of the counseling process
 * @author Jugal
 * Date 08/01/2019
 */
public class CollegeCounseling {
	
	 List<Program> programList = new ArrayList<>();
	 List<Student> studentList = new ArrayList<>();
	
	/**
	 * This method gets the data from the excel sheet and generates the programList
	 */
	void getProgramList()
	{
		try {
			Workbook workbook = Workbook.getWorkbook(new java.io.File("Programs.xls"));
			// Obtain the reference to the first sheet in the workbook
			Sheet sheet = workbook.getSheet(0);
			// Obtain reference to the Cell using getCell(int col, int row)
			// method of sheet
			String programName = null;
			int capacity = 0;
			for (int i = 0; i < sheet.getRows(); i++) {
				for (int j = 0; j < sheet.getColumns(); j++) {
					Cell cell = sheet.getCell(j, i);
					CellType type = cell.getType();
					if (type == CellType.LABEL) {
						programName = cell.getContents();
					} else if (type == CellType.NUMBER) {
						capacity = Integer.parseInt(cell.getContents());
					}
				}
				Program program = new Program(programName, capacity);
				programList.add(program);
				}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method gets the student data from the excel sheet and generates the student queue
	 * @return {Queue<Student>} the student queue
	 * @throws Exception
	 */
	Queue<Student> allocateStudentsToQueue() throws Exception
	{
		Queue<Student> studentQueue = new StudentQueue();
		try {
			Workbook workbook = Workbook.getWorkbook(new java.io.File("Students.xls"));
			// Obtain the reference to the first sheet in the workbook
			Sheet sheet = workbook.getSheet(0);
			// Obtain reference to the Cell using getCell(int col, int row)
			// method of sheet

			for (int i = 0; i < sheet.getRows(); i++) {
				Cell name = sheet.getCell(0, i);
				String studentName = name.getContents();
				String[] prefrences = new String[5];
				for (int j = 1; j < sheet.getColumns(); j++) {
					Cell cell = sheet.getCell(j, i);
					CellType type = cell.getType();
					if (type == CellType.LABEL) {
						prefrences[j - 1] = cell.getContents();
					}
				}
				Student student = new Student(studentName, prefrences, null);
				studentQueue.enqueue(student);

			}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return studentQueue;
	}
	
	/**
	 * This method allocates a particular program according to availability to the student
	 * @param studentQueue is the student queue
	 * @throws Exception
	 */
	void allocateStudentToProgram(Queue<Student> studentQueue) throws Exception
	{
		while (!studentQueue.isQueueEmpty()) 
		{
			Student student =  studentQueue.dequeue();
			String preferences[] = student.getPreferredPrograms();
			outerloop: for (int i = 0; i < preferences.length; i++) 
			{
				for (int j = 0; j < this.programList.size(); j++) 
				{
					String programName = this.programList.get(j).getName();
					if (preferences[i].equalsIgnoreCase(programName)) 
					{
						int remaining = programList.get(j).getRemainig();
						if (remaining > 0)
						{
							String allocatedProgram = programName;
							student.setAllocatedProgram(allocatedProgram);
							this.studentList.add(student);
							programList.get(j).setRemainig(remaining - 1);
							break outerloop;
						}
					}

				}

			}

		}
	}
	
	/**
	 * This method makes a new excel sheet which contains the Student's Name and the Program allocated to it.
	 */
	void makeExcelSheet()
	{
		int i=0;
		try {
			WritableWorkbook workbook = Workbook.createWorkbook(new File("AllocationList.xls"));
			WritableSheet workbookSheet = workbook.createSheet("sheet1",0);
			int j;
			for (j = 0; j < this.studentList.size(); j++) {
				String name= this.studentList.get(i).getName();
				Label nameLabel = new Label(0, j, name);
				workbookSheet.addCell(nameLabel);
				String program = this.studentList.get(i).getAllocatedProgram();
				Label programLabel = new Label(1, j, program);
				i++;
				workbookSheet.addCell(programLabel);
				
			}
			
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

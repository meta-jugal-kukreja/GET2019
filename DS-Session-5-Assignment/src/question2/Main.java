package question2;

public class Main {

	public static void main(String[] args) {
		
		EmployeeList employeeList = new EmployeeList();
		
		employeeList.addNode(20, 30, "A");
		employeeList.addNode(30, 40, "B");
		employeeList.addNode(30, 25, "C");
		employeeList.addNode(10, 22, "D");
		
		employeeList.sortEmployeeList();
		
		employeeList.printList(employeeList.sortedLinkedListHead);

	}

}

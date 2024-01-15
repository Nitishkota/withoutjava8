package employeesalary;

import java.util.*;



public class Employee {
    public static void main(String[] args) {
    	
        List<Employee> employees = new ArrayList<>();

       
        List<Employee> highPaidEmployees = filterEmployeesBySalary(employees, 1000);

        Employee highestPaidEmployee = findHighestPaidEmployee(employees);

        Employee fourthHighestPaidEmployee = findNthHighestPaidEmployee(employees, 4);

        int totalSalary = calculateTotalSalary(employees);

        Map<String, Integer> salaryByDepartment = calculateSalaryByDepartment(employees);

        Map<String, List<Employee>> employeesByDepartment = groupEmployeesByDepartment(employees);

        String targetFirstName = "TargetFirstName";
        String targetLastName = "TargetLastName";
        Employee matchingEmployee = findEmployeeByName(employees, targetFirstName, targetLastName);

        List<Employee> sortedEmployees = sortEmployeesBySalaryAndRating(employees);
    }

    
    private static List<Employee> filterEmployeesBySalary(List<Employee> employees, int threshold) {
        List<Employee> highPaidEmployees = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getSalary() > threshold) {
                highPaidEmployees.add(emp);
            }
        }
        return highPaidEmployees;
    }

    private int getSalary() {
		// TODO Auto-generated method stub
		return 0;
	}

	// Method to find the employee with the highest salary
    private static Employee findHighestPaidEmployee(List<Employee> employees) {
        Employee highestPaidEmployee = null;
        int maxSalary = Integer.MIN_VALUE;
        for (Employee emp : employees) {
            if (emp.getSalary() > maxSalary) {
                maxSalary = emp.getSalary();
                highestPaidEmployee = emp;
            }
        }
        return highestPaidEmployee;
    }

    // Method to find the employee with the nth highest salary
    private static Employee findNthHighestPaidEmployee(List<Employee> employees, int n) {
        List<Employee> sortedBySalary = new ArrayList<>(employees);
        sortedBySalary.sort(Comparator.comparingInt(Employee::getSalary).reversed());
        return sortedBySalary.size() >= n ? sortedBySalary.get(n - 1) : null;
    }

    // Method to calculate the total salary of all employees
    private static int calculateTotalSalary(List<Employee> employees) {
        int totalSalary = 0;
        for (Employee emp : employees) {
            totalSalary += emp.getSalary();
        }
        return totalSalary;
    }

    // Method to calculate the sum of salary by department
    private static Map<String, Integer> calculateSalaryByDepartment(List<Employee> employees) {
        Map<String, Integer> salaryByDepartment = new HashMap<>();
        for (Employee emp : employees) {
            String department = emp.getDepartment();
            int currentSalary = salaryByDepartment.getOrDefault(department, 0);
            salaryByDepartment.put(department, currentSalary + emp.getSalary());
        }
        return salaryByDepartment;
    }

    private String getDepartment() {
		// TODO Auto-generated method stub
		return null;
	}

	// Method to group employees by department
    private static Map<String, List<Employee>> groupEmployeesByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> employeesByDepartment = new HashMap<>();
        for (Employee emp : employees) {
            String department = emp.getDepartment();
            List<Employee> departmentEmployees = employeesByDepartment.getOrDefault(department, new ArrayList<>());
            departmentEmployees.add(emp);
            employeesByDepartment.put(department, departmentEmployees);
        }
        return employeesByDepartment;
    }

    // Method to find an employee by first name and last name
    private static Employee findEmployeeByName(List<Employee> employees, String firstName, String lastName) {
        for (Employee emp : employees) {
            if (emp.getFirstName().equals(firstName) && emp.getLastName().equals(lastName)) {
                return emp;
            }
        }
        return null;
    }

    private Object getLastName() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object getFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	// Method to sort employees by salary and rating in descending order
    private static List<Employee> sortEmployeesBySalaryAndRating(List<Employee> employees) {
        List<Employee> sortedEmployees = new ArrayList<>(employees);
        sortedEmployees.sort((emp1, emp2) -> {
            if (emp1.getSalary() != emp2.getSalary()) {
                return Integer.compare(emp2.getSalary(), emp1.getSalary());
            } else {
                return Integer.compare(emp2.getRating(), emp1.getRating());
            }
        });
        return sortedEmployees;
    }

	private int getRating() {
		// TODO Auto-generated method stub
		return 0;
	}
}

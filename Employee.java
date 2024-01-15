package salaries;

import java.util.*;


public class Employee {
    private String firstName;
    private String lastName;
    private String department;
    private int salary;
    private int rating;

    public Employee(String firstName, String lastName, String department, int salary, int rating) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        this.rating = rating;
    }

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

    private static List<Employee> filterEmployeesBySalary(List<Employee> employees, int salary) {
        List<Employee> highPaidEmployees = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getSalary() > salary) {
                highPaidEmployees.add(emp);
            }
        }
        return highPaidEmployees;
    }

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

    private static Employee findNthHighestPaidEmployee(List<Employee> employees, int n) {
        List<Employee> sortedBySalary = new ArrayList<>(employees);
        Collections.sort(sortedBySalary, Comparator.comparingInt(Employee::getSalary).reversed());
        return sortedBySalary.size() >= n ? sortedBySalary.get(n - 1) : null;
    }

    private static int calculateTotalSalary(List<Employee> employees) {
        return employees.stream().mapToInt(Employee::getSalary).sum();
    }

    private static Map<String, Integer> calculateSalaryByDepartment(List<Employee> employees) {
        Map<String, Integer> salaryByDepartment = new HashMap<>();
        for (Employee emp : employees) {
            salaryByDepartment.put(emp.getDepartment(),
                    salaryByDepartment.getOrDefault(emp.getDepartment(), 0) + emp.getSalary());
        }
        return salaryByDepartment;
    }

    private static Map<String, List<Employee>> groupEmployeesByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> employeesByDepartment = new HashMap<>();
        for (Employee emp : employees) {
            employeesByDepartment.computeIfAbsent(emp.getDepartment(), k -> new ArrayList<>()).add(emp);
        }
        return employeesByDepartment;
    }

    private static Employee findEmployeeByName(List<Employee> employees, String firstName, String lastName) {
        for (Employee emp : employees) {
            if (emp.getFirstName()==(firstName) && emp.getLastName()==(lastName)) {
                return emp;
            }
        }
        return null;
    }

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

        private String getDepartment() {
        return this.department;
    }

    private String getLastName() {
        return this.lastName;
    }

    private String getFirstName() {
        return this.firstName;
    }

    private int getRating() {
        return this.rating;
    }

    private int getSalary() {
        return this.salary;
    }
}


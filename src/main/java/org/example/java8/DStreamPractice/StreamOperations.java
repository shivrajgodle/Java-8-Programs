package org.example.java8.DStreamPractice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {

    public static List<Employee> getEmployees(){
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(6, "Six", 43, "Male", "Security", 2016, 9500.0, "Pune"));
        employeeList.add(new Employee(7, "Seven", 35, "Male", "Finance", 2010, 27000.0, "Pune"));
        employeeList.add(new Employee(3, "Three", 29, "Male", "Infrastructure", 2012, 18000.0, "Hyderabad"));
        employeeList.add(new Employee(8, "Eight", 31, "Male", "Development", 2015, 34500.0, "Pune"));
        employeeList.add(new Employee(9, "Nine", 24, "Female", "Sales", 2016, 11500.0, "Hyderabad"));
        employeeList.add(new Employee(10, "Ten", 25, "Female", "Sales", 2009, 22500.0, "Pune"));
        employeeList.add(new Employee(2, "Two", 25, "Male", "Sales", 2015, 13500.0, "Hyderabad"));
        employeeList.add(new Employee(4, "Four", 28, "Female", "Development", 2014, 32500.0, "Pune"));
        employeeList.add(new Employee(5, "Five", 27, "Female", "HR", 2013, 22700.0, "Pune"));
        employeeList.add(new Employee(1, "One", 32, "Female", "HR", 2011, 25000.0, "Hyderabad"));
        return employeeList;
    }


    public static void main(String[] args) {

        List < Employee > employeeList = getEmployees();

        //Stream methods / operations
        List < String > empList = new ArrayList < String > ();
        for (Employee employee: employeeList) {
            empList.add(employee.getName());
        }
        //System.out.println("empList name list:-"+empList);

        //Stream pipeline
        Stream < Employee > stream = employeeList.stream();
        List < String > empNames = stream.map(emp -> emp.getName()).toList();
        //System.out.println("empNames are:-"+empNames);

        //Get name of Employee who's age is greater than 25
        List < String > EmpNameslist = employeeList.stream().filter(emp -> emp.getAge() > 25).map(emp -> emp.getName()).toList();
        System.out.println("EmpNameslist who's age is greater than 25:-" + EmpNameslist);

        //get all employee unique cities
        //foreach
        //distinct
        employeeList.stream().map(emp -> emp.getCity())
                .distinct()
                .forEach(System.out::println);

        // count number of employees who's salary is greater than 20K
        //count()
        long countEmpWith20K = employeeList.stream().filter(emp -> emp.getSalary() > 20000).count();
        System.out.println("countEmpWith20K is:-" + countEmpWith20K);

        //get first 3 employees
        List < Employee > first3Employee = employeeList.stream().limit(3).toList();
        System.out.println("first3Employee is:-" + first3Employee);

        //skip first 3 employees
        List < Employee > skip3Employees = employeeList.stream().skip(3).toList();
        System.out.println("skip3Employees is:-" + skip3Employees);

        //any match
        //anyMatch
        boolean isAnyMatch = employeeList.stream().anyMatch(emp -> emp.getAge() < 28);
        System.out.println("isAnyMatch is:-" + isAnyMatch);

        //All match
        //allMatch
        boolean isAllMatch = employeeList.stream().anyMatch(emp -> emp.getYearOfJoining() > 2010);
        System.out.println("isAllMatch is:-" + isAllMatch);

        //none match
        //noneMatch
        boolean isnoneMatch = employeeList.stream().noneMatch(emp -> emp.getCity() == "Nanded");
        System.out.println("isnoneMatch is:-" + isnoneMatch);

        //find any
        //find any value from the employee list
        Employee employee = employeeList.stream().findAny().get();
        System.out.println("employee is:-" + employee);

        //find first
        //find first value from the employee list
        Employee employee1 = employeeList.stream().findFirst().get();
        System.out.println("employee1 is:-" + employee1);

        //sort list by employee id by ascending order
        //sorted
        List < Integer > sortedEmployeeIds = employeeList.stream().map(emp -> emp.getId()).sorted().toList();
        System.out.println("sortedEmployeeIds is:-" + sortedEmployeeIds);

        //sort list by employee id by decending order
        //sorted
        List < Integer > sortedByDescending = employeeList.stream().map(emp -> emp.getId()).sorted(Comparator.reverseOrder()).toList();
        System.out.println("sortedByDescending is:-" + sortedByDescending);

        //get top fifth empid
        int i = employeeList.stream().map(emp -> emp.getId()).sorted(Comparator.reverseOrder()).skip(5).findFirst().get();
        System.out.println("sortedByDescending is:-" + i);

        // sorted : Comparator Arg.
        // Define Sorting based on employee Id's
        // Sort Employee Objects
        // Comparator

        List < Employee > sortEmpByComparator = employeeList.stream().sorted((e1, e2) -> {
            return e1.getId() - e2.getId();
        }).toList();
        System.out.println("sortEmpByComparator is:-" + sortEmpByComparator);

        //minimum salary of the employee
        //min()
        Employee minSalemployee = employeeList.stream().min((e1, e2) -> (int)(e1.getSalary() - e2.getSalary())).get();
        System.out.println("minSalemployee is:-" + minSalemployee);

        //maximum salary of the employee
        //max()

        Employee maxSalemployee = employeeList.stream().max((e1, e2) -> (int)(e1.getSalary() - e2.getSalary())).get();
        System.out.println("maxSalemployee is:-" + maxSalemployee);

        //avrage salary of the employee
        //average()
        Double avgSalary = employeeList.stream().mapToDouble(emp -> emp.getSalary()).average().getAsDouble();
        System.out.println("avgSalary is:-" + avgSalary);

        //find average age of the employee
        Double avgAge = employeeList.stream().mapToInt(emp -> emp.getAge()).average().getAsDouble();
        System.out.println("avgAge is:-" + avgAge);

        //peek()
        //Out of all employees, find whose date of joining > 2015
        // Track How many Employees are processed.
        List < Employee > employees = employeeList.stream().peek(System.out::println).filter(emp -> emp.getYearOfJoining() > 2010).collect(Collectors.toList());
        System.out.println("List of employees who joined after 2010 is:-: " + employees);

        //parallel stream
        System.out.println("*********parallel stream*****");
        List < Employee > parallelEmployees = employeeList.parallelStream().peek(System.out::println).filter(emp -> emp.getYearOfJoining() > 2015).collect(Collectors.toList());
        System.out.println("parallelEmployees is:-" + parallelEmployees);

        //collect()
        //Collectors : JDK8 , as part of Stream API operations
        // Collect All Employees Names as a LIST, whose age is greater than 32

        List < String > empNamesWithAgeGtThan25 = employeeList.stream().filter(e -> e.getAge() > 32).map(Employee::getName).collect(Collectors.toList());
        System.out.println("empNamesWithAgeGtThan25 is:-" + empNamesWithAgeGtThan25);

        //Unique Department names
        //using toSet()
        Set < String > uniqueDeptNames = employeeList.stream().map(Employee::getDepartment).collect(Collectors.toSet());
        System.out.println("uniqueDeptNames is:-" + uniqueDeptNames);

        //using distinct

        List < String > uniqueDeptNamesWithDistinct = employeeList.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
        System.out.println("uniqueDeptNamesWithDistinct is:-" + uniqueDeptNamesWithDistinct);

        //collect employees with employee id and salary as map

        Map < Integer, Double > empIdWithSalary = employeeList.stream().collect(Collectors.toMap((Employee::getId), (Employee::getSalary)));
        System.out.println("empIdWithSalary is:-" + empIdWithSalary);

        //groupingBy()
        // get avg salary of each department
        Map < String, Double > deptWithAvgSalary = employeeList.stream().collect(Collectors.groupingBy((Employee::getDepartment), Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("deptWithAvgSalary is:-" + deptWithAvgSalary);

        //count Employees gender wise
        Map <String, Long> genderWiseEmployees = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("genderWiseEmployees is:-" + genderWiseEmployees);

        //summing All employee salaries
        System.out.println("summingDouble is:-"+employeeList.stream().collect(Collectors.summingDouble(Employee::getSalary)));
        System.out.println("summarizingDouble is:-"+employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary)));

        //finding max age employee
        //Collectors.maxBy()
        Employee maxAgeEmployee = employeeList.stream().collect(Collectors.maxBy((e1, e2) -> e1.getAge() - e2.getAge())).get();
        System.out.println("maxAgeEmployee is:-"+maxAgeEmployee);


        //joining
        // All Department names with delimiter :::
        String departmentNames = employeeList.stream().map(Employee::getDepartment).collect(Collectors.joining("<-*|*->"));
        System.out.println("departmentNames is:-"+departmentNames);
    }
}

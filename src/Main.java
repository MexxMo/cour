public class Main {


    public static void main(String[] args) {
        // легкая сложность
        System.out.println("Список всех сотрудников");
        printEmployee();
        System.out.println();


        System.out.println("Траты на ЗП в месяц " + calculateTotalSalary());
        System.out.println("Минимальная ЗП " + findEmployeeWithMinSalary());
        System.out.println("Максимальная ЗП " + findEmployeeWithMaxSalary());
        System.out.println("Средняя зарплата " + calculateAverageSalary());

        System.out.println();
        System.out.println("Ф.И.О. всех сотрудников:");
        printFullNames();
        // средняя сложность
        System.out.println("Индексация зарплат");
        indexSalary(10);
        System.out.println();
        System.out.println("Поиск минимальной зарплаты по отделу");
        System.out.println(findMinSalaryOfDepartment(2));
        System.out.println("Поиск максимальной зарплаты по отделу");
        System.out.println(findMaxSalaryOfDepartment(2));
        System.out.println("Подсчёт средней зарплаты по отделу");
        System.out.println(calculateTotalSalaryOfDepartment(2));
        System.out.println("Индексация зарплат по отделу");
        System.out.println(calculateAverageSalaryOfDepartment(2));
        indexSalaryByDep(10,2);
        System.out.println("Вывод всех работников по отделу");
        printDepart(2);
        System.out.println("Вывод всех работников, чья зарплата меньше n");
        printAllEmployeesWithSalaryLessThan(25000);
        System.out.println();
        System.out.println("Вывод всех работников, чья зарплата больше n");
        printAllEmployeesWithSalaryMoreThan(10000);
        System.out.println();
    }
    // тяжкая

    private static final Employee[] employees = {
            new Employee("Котов Адольф Егорович", 10000, 1),
            new Employee("Гаврилов Константин Андреевич", 20000, 2),
            new Employee("Селиверстов Орест Рудольфович", 30000, 1),
            new Employee("Гуляев Мстислав Павлович", 50000, 2),
            new Employee("Гаврилова Милда Игнатьевна", 40000, 3),
            new Employee("Цветкова Тамара Романовна", 20000, 3),
            new Employee("Сафонова Илона Улебовна", 9000, 4),
            new Employee("Соболев Геннадий Пётрович", 30000, 4),
            new Employee("Данилов Анатолий Аркадьевич", 40000, 5),
            new Employee("Лихачёв Артём Мэлорович", 90000, 5)
    };

    // легкая сложность
    public static void printEmployee() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static int calculateTotalSalary() {
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public static Employee findEmployeeWithMinSalary() {
        Employee result = employees[0];
        int minSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public static Employee findEmployeeWithMaxSalary() {
        Employee result = employees[0];
        int maxSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public static float calculateAverageSalary() {
        return calculateTotalSalary() / (float) employees.length;
    }

    public static void printFullNames() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }

// Средняя сложность

    public static void indexSalary(int percent) {
        for (Employee employee : employees) {
            int currentSalary = employee.getSalary();
            currentSalary += (currentSalary / 100) * percent;
            employee.setSalary(currentSalary);
        }
    }

    public static Employee findMinSalaryOfDepartment(int departmentId) {
        int minSalary = Integer.MAX_VALUE;
        Employee result = null;
        for (Employee employee : employees) {
            if (employee.getDepartmentId() != departmentId) {
                continue;
            }
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public static Employee findMaxSalaryOfDepartment(int departmentId) {
        int maxSalary = Integer.MIN_VALUE;
        Employee result = null;
        for (Employee employee : employees) {
            if (employee.getDepartmentId() != departmentId) {
                continue;
            }
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public static int calculateTotalSalaryOfDepartment(int departmentId) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartmentId() == departmentId) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public static float calculateAverageSalaryOfDepartment(int departmentId) {
        int sum = 0;
        int employeesCount = 0;
        for (Employee employee : employees) {
            if (employee.getDepartmentId() == departmentId) {
                sum += employee.getSalary();
                employeesCount++;
            }
        }
        return sum / (float) employeesCount;
    }

    public static void indexSalaryByDep(int percent, int departmentId) {
        for (Employee employee : employees) {
            if (employee.getDepartmentId() == departmentId) {
                int salary = employee.getSalary();
                salary += (salary / 100) * percent;
                employee.setSalary(salary);
            }
        }
    }

    public static void printDepart(int departmentId) {
        for (Employee employee : employees) {
            if (employee.getDepartmentId() == departmentId) {
                System.out.println(employee);
            }
        }
    }

    public static void printAllEmployeesWithSalaryLessThan(int salary) {
        for (Employee employee : employees) {
            if (employee.getSalary() < salary) {
                System.out.println(employee);
            }
        }
    }

    public static void printAllEmployeesWithSalaryMoreThan(int salary) {
        for (Employee employee : employees) {
            if (employee.getSalary() >= salary) {
                System.out.println(employee);
            }
        }
    }

}

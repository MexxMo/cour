public class Main {


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


    public static void main(String[] args) {

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


    }
}
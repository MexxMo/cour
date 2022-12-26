
public class Employee {

    private final Integer id;
    private final String fullName;
    private Integer salary;
    private Integer departmentId;
    private static Integer idCounter = 1;



    public Employee(String fullName,Integer salary,Integer departmentId){
        this.departmentId =  departmentId;
        this.id = idCounter++;
        this.fullName = fullName;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getSalary() {
        return salary;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }


    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", Ф.И.О.: " + fullName +
                ", зарплата " + salary +
                ", отдел " + departmentId;
    }
}





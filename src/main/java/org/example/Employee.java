import java.time.LocalDate;

public class Employee extends BaseEmployee{

    protected Employee(String name, int[] birthday, int salary) {
        super(name, birthday, salary);
    }

    public static Employee create(String name, int[] birthday, int salary){
        if(name == null || name.length() < 1){
            throw new RuntimeException("Incorrect name");
        }
        if(birthday == null ||  birthday.length != 3 || LocalDate.now().getYear() - birthday[1] < 18){
            throw new RuntimeException("Too young for work" );
        }
        if(salary <= 0){
            throw new RuntimeException("Incorrect salary");
        }
        return new Employee(name,birthday,salary);
    }

}

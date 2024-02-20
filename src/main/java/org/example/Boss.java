package org.example;

public class Boss extends Employee{
    private Employee[] employees;

    /**
     * Конструктор класса
     * @param name имя
     * @param birthday дата рождения представлена массивом int
     * @param salary зарплата
     */
    protected Boss(String name, int[] birthday, int salary) {
        super(name, birthday, salary);
    }

    /**
     * Конструктор класса
     * @param name имя
     * @param birthday дата рождения представлена массивом int
     * @param salary зарплата
     * @param employees массив работников
     */
    private Boss(String name, int[] birthday, int salary, Employee[] employees) {
        super(name, birthday, salary);
        this.employees = employees;
    }

    /**
     * Метод возвращает массив работников текущего объекта
     * @return массив работников
     */
    public Employee[] getEmployees() {
        return employees;
    }

    /**
     * Метод изменяет массив работников текущего объекта
     * @param employees массив работников
     */
    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    /**
     * Фобричные метод создания объектов класса Boss
     * @param name имя
     * @param birthday дата рождения представлена массивом int
     * @param salary зарплата
     * @param employees массив работников
     * @return объект класса Boss
     */
    public static Boss create(String name, int[] birthday, int salary, Employee[] employees){
        Employee em = Employee.create(name, birthday, salary);
        if(employees == null){
            throw new RuntimeException("Boss have not had any employees");
        }
        return new Boss(em.getName(),em.getBirthday(),em.getSalary(),employees);
    }

    /**
     * Метод увеличения зарплаты всем кроме объектов класса Boss
     * @param o объект
     * @param rate коэфициент увеличения зарплаты
     */
    public static void upSalary(Object o,float rate){
        if(!(o instanceof Boss)){
            ((Employee) o).setSalary((int) (((Employee) o).getSalary() * rate));
        }
    }
}

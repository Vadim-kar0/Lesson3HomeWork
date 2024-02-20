package org.example;

import java.time.LocalDate;

public class Employee{

    private String name;
    private int[] birthday;
    private int salary;

    /**
     * Конструктор класса
     * @param name имя
     * @param birthday дата рождения представлена массивом int
     * @param salary зарплата
     */
    protected Employee(String name, int[] birthday, int salary) {
        this.name = name;
        this.birthday = birthday;
        this.salary = salary;
    }

    /**
     * Метод возвращает имя объекта
     * @return имя
     */
    public String getName() {
        return name;
    }

    /**
     * Метод изменяет имя объекта
     * @param name имя
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод возвращает дату рождения объекта
     * @return дата рождения
     */
    public int[] getBirthday() {
        return birthday;
    }

    /**
     * Метод изменяет дату рождения объекта
     * @param birthday дата рождения
     */
    public void setBirthday(int[] birthday) {
        this.birthday = birthday;
    }

    /**
     * Метод возвращает зарплату объекта
     * @return зарплата
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Метод изменяет зарплату объекта
     * @param salary зарплата
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }


    /**
     * Фабричные метод создания объектов
     * @param name имя
     * @param birthday дата рождения
     * @param salary зарплата
     * @return объект класса Employee
     */
    public static Employee create(String name, int[] birthday, int salary){
        if(name == null || name.length() < 1){
            throw new RuntimeException("Incorrect name");
        }
        if(birthday == null ||  birthday.length != 3){
            throw new RuntimeException("Incorrect birthday" );
        } else if(LocalDate.now().getYear() - birthday[0] < 18){
            throw new RuntimeException("Too young for work");
        } else if(LocalDate.now().getYear() - birthday[0] == 18){
            if(LocalDate.now().getDayOfYear() < LocalDate.of(birthday[1],birthday[2],birthday[3]).getDayOfYear()){
                throw new RuntimeException("Too young for work");
            }
        }
        if(salary <= 0){
            throw new RuntimeException("Incorrect salary");
        }
        return new Employee(name,birthday,salary);
    }

    /**
     * Метод возвращает возраст в днях
     * @return количество дней
     */
    private int getAgeInDays(){
        return getBirthday()[0] * 365 + getBirthday()[1] * 30 + getBirthday()[2];
    }


    /**
     * Метод сравнивает объектов по дате рождения, результатом будет
     * целочисленное значение для сортировки по возрастанию
     * @param employee объект класса Employee
     * @return целочисленное значение
     */
    //Для даты я бы использовал LocalDate но в задании указано что нужно три числа и я использую массив
    //Также я не имплементировал интерфейс Comparable и не создавал класс EmployeeComparator просто написал метод
    //который можно использовать для компаратора в методе compare(T o1,T o2)
    public int compareTo(Employee employee){
        if(getBirthday() == null || employee.getBirthday() == null){
            return 0;
        }
        return getAgeInDays() - employee.getAgeInDays();
    }
}


//2024 02 20      2006 02 21
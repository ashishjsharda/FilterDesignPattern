import java.util.ArrayList;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        List<Person> persons=new ArrayList<Person>();
        persons.add(new Person("Rob","Male","Married"));
        persons.add(new Person("John","Male","Single"));
        persons.add(new Person("Sara","Female","Single"));
        persons.add(new Person("Nathan","Male","Single"));
        persons.add(new Person("Kittu","Female","Married"));
        Criteria male=new CriteriaMale();
        Criteria female=new CriteriaFemale();
        Criteria single=new CriteriaSingle();
        Criteria singleMale=new AndCriteria(single,male);
        Criteria singleFemale=new OrCriteria(single,female);
        System.out.println("List of all Males");
        printPersons(male.meetCriteria(persons));
        System.out.println("List of all Females");
        printPersons(female.meetCriteria(persons));
        System.out.println("List of all Single Males");
        printPersons(singleMale.meetCriteria(persons));
        System.out.println("Single Or Females: ");
        printPersons(singleFemale.meetCriteria(persons));


    }
    public static void printPersons(List<Person> personList)
    {
        for (Person person:personList)
        {
            System.out.println("Person Name   " + person.getName() +" " +"Person Gender is " +person.getGender() + "  " + "  Marital Status is " +person.getMaritalStatus());

        }
    }
}

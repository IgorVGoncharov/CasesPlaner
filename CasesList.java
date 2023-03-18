import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class CasesList <T extends Case> {
    private ArrayList<T> listOfCases = new ArrayList<>();

    public void AddCase(T newCase){
        this.listOfCases.add(newCase);
    }

    public T findCaseByID(Integer id){
        for (T t : listOfCases) {
            if (t.getId() == id){
                return t;
            }
        }
        return null;    
    }
    
    public void deleteCase(Integer id){
        Iterator<T> iterator = listOfCases.iterator();
        while (iterator.hasNext()){
            T next = iterator.next();
            if (next.getId() == id){
                iterator.remove();
            }
        }
    }

    public void findByImputDate(LocalDate date){
        int n = 0;
        for (T t : listOfCases) {
            if (t.getDateOfCreate().equals(date)){
                System.out.println(t);
                n += 1;
            }
        }
        if (n == 0){
            System.out.println("С таким условием задач не найдено.");
        }
    }

    public void findByDeadlineDate(LocalDate date){
        int n = 0;
        for (T t : listOfCases) {
            if (t.getDeadlineDate().equals(date)){
                System.out.println(t);
                n += 1;
            }
        }
        if (n == 0){
            System.out.println("С таким условием задач не найдено.");
        }
    }

    public void findCaseByPriority(Integer val){
        int n = 0;
        for (T t : listOfCases) {
            if (val == 1){
                if (t instanceof LowPriorityCase){
                    System.out.println(t);
                    n += 1;
                }
            }
            else if (val == 2){
                if (t instanceof MidlePriorityCase){
                    System.out.println(t);
                    n += 1;
                }
            }
            else if (val == 3){
                if (t instanceof HighPriorityCase){
                    System.out.println(t);
                    n += 1;
                }
            } 
        }
        if (n == 0){
            System.out.println("С таким условием задач не найдено.");
        }
    }

    public void findCaseByDone(Integer val){
        int n = 0;
        for (T t : listOfCases) {
            if (val == 1){
                if (t.getDoneOrNot() == true){
                    System.out.println(t);
                    n += 1;
                }
            }
            else if (val == 2){
                if (t.getDoneOrNot() == false){
                    System.out.println(t);
                    n += 1;
            }
            }
        }
        if (n == 0){
            System.out.println("С таким условием задач не найдено.");
        }
    }

    public void findAllCases(){
        for (T t : listOfCases) {
            System.out.println(t);
        }
    }

}



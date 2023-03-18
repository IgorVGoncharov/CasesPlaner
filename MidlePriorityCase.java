public class MidlePriorityCase extends Case {
    private String priority;  
    private Integer priotiryDegree; 
    
    
    
    public MidlePriorityCase(String textOfCase, String Date, String time, Peoples person) {
        super(textOfCase, Date, time, person);
        this.priority = "Средний";
        this.priotiryDegree = 2;
    }



    public String getPriority() {
        return priority;
    }



    public void setPriority(String priority) {
        this.priority = priority;
    }



    public Integer getPriotiryDegree() {
        return priotiryDegree;
    }



    public void setPriotiryDegree(Integer priotiryDegree) {
        this.priotiryDegree = priotiryDegree;
    }

    @Override
    public String toString() {
        return super.toString() + "\nПриоритет: \t\t" + priority;
    }
    
}

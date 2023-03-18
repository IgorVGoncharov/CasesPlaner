public class HighPriorityCase extends Case {
    private String priority;  
    private Integer priotiryDegree; 
    
    
    
    public HighPriorityCase(String textOfCase, String Date, String time, Peoples person) {
        super(textOfCase, Date, time, person);
        this.priority = "Высокий";
        this.priotiryDegree = 3;
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

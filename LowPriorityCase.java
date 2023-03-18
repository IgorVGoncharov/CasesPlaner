public class LowPriorityCase extends Case{
    private String priority;  
    private Integer priotiryDegree; 
    
    
    public LowPriorityCase(String textOfCase, String Date, String time, Peoples person) {
        super(textOfCase, Date, time, person);
        this.priority = "Низкий";
        this.priotiryDegree = 1;
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

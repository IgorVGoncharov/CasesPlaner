import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class Case {
    private static int nextId = 1;
    private int id;
    private LocalDate dateOfCreate;
    private LocalTime timeOfCreate;
    private String textOfCase;
    private Peoples person;
    private LocalDate deadlineDate;
    private LocalTime deadlineTime;
    private Boolean doneOrNot;
    private Integer priorityDegree;  
    
    final DateTimeFormatter DATE_FORMATER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    final DateTimeFormatter tIME_FORMATER = DateTimeFormatter.ofPattern("HH:mm");
    
    public Case(String textOfCase, String Date, String time, Peoples person) {
        this.id = nextId++;
        this.dateOfCreate = LocalDate.now();
        this.timeOfCreate = LocalTime.now();
        this.textOfCase = textOfCase;
        this.person =  person;
        this.deadlineDate = LocalDate.parse(Date, DATE_FORMATER);
        this.deadlineTime = LocalTime.parse(time, tIME_FORMATER);
        this.doneOrNot = false;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public LocalDate getDateOfCreate() {
        return dateOfCreate;
    }
    
    public void setDateOfCreate(LocalDate dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }
    
    public LocalTime getTimeOfCreate() {
        return timeOfCreate;
    }
    
    public void setTimeOfCreate(LocalTime timeOfCreate) {
        this.timeOfCreate = timeOfCreate;
    }
    
    public String getTextOfCase() {
        return textOfCase;
    }
    
    public void setTextOfCase(String textOfCase) {
        this.textOfCase = textOfCase;
    }
    
    public Peoples getPerson() {
        return person;
    }
    
    public void setPerson(Peoples person) {
        this.person = person;
    }
    
    public LocalDate getDeadlineDate() {
        return deadlineDate;
    }
    
    public void setDeadlineDate(LocalDate deadlineDate) {
        this.deadlineDate = deadlineDate;
    }
    
    public LocalTime getDeadlineTime() {
        return deadlineTime;
    }
    
    public void setDeadlineTime(LocalTime deadlineTime) {
        this.deadlineTime = deadlineTime;
    }
    
    public Boolean getDoneOrNot() {
        return doneOrNot;
    }
    
    public void setDoneOrNot(Boolean doneOrNot) {
        this.doneOrNot = doneOrNot;
    }
    
    public Integer getPriorityDegree() {
        return priorityDegree;
    }
    
    public void setPriorityDegree(Integer priorityDegree) {
        this.priorityDegree = priorityDegree;
    }

    @Override
    public String toString() {
        String done = new String();
        if (this.doneOrNot == false){
            done = "В работе";
        }
        else if (this.doneOrNot == true) {
            done = "Выполнено";
        }
        return "\nЗадача: id = " + id +
        "\nДата ввода: \t\t" + dateOfCreate + "\nВремя ввода: \t\t" + timeOfCreate + 
        "\nТекст задачи: \t\t" + textOfCase + "\nПользователь: \t\t" + person.getFullName() + 
        "\nСрок выполнения: \t" + deadlineDate + " " + deadlineTime + "\nCтатус: \t\t" + done;
    } 

}   

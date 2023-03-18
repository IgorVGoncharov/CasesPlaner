
public class Main {
    public static void main(String[] args) {
        System.out.println("\tДобро пожаловать в Планировщик задач!");
        CasesList casesList = new CasesList<>();
        Peoples nesPerson = new Menu().newPerson();
        new Menu().programMenu(nesPerson, casesList);
    }
}

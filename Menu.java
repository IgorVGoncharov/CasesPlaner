import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Menu {

    final DateTimeFormatter DATE_FORMATER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    final DateTimeFormatter TIME_FORMATER = DateTimeFormatter.ofPattern("HH:mm");
    Scanner iScanner = new Scanner(System.in, "CP866");
    

    public Peoples newPerson(){
        System.out.println("\nВведите данные пользователя:");
        System.out.print("Фамилия: ");
        String lastName = iScanner.nextLine();
        System.out.print("Имя: ");
        String firstName = iScanner.nextLine();
        System.out.print("Отчество: ");
        String secName = iScanner.nextLine();
        return new Peoples(lastName, firstName, secName);
    }

    public void programMenu(Peoples newPerson, CasesList casesList){
        try {
            System.out.println("\n\tМеню программы: ");
            System.out.println("1. Добавить задачу\n2. Изменить задачу\n3. Удалить задачу\n4. Найти задачу\n5. Показать все задачи\n6. Выход");
            System.out.print("Введите значение: ");
            String val = iScanner.nextLine();
            Integer choise = Integer.parseInt(val);
            if (choise == 1){
                addNewCase(newPerson, casesList);
            }
            else if(choise == 2){
                editCase(newPerson, casesList);
            }
            else if(choise == 3){
                deleteCase(newPerson, casesList);
            }
            else if (choise == 4){
                findCase(newPerson, casesList);
            }
            else if (choise == 5){
                findAllCases(newPerson, casesList);
            }
            else if (choise == 6){
                System.out.println("До новых встреч!");
            }
            else{
                System.out.println("Введено не корректное значение!");
                programMenu(newPerson, casesList);
            }
        } 
        catch (Exception e) {
            System.out.print("\nВведено не число, попробуйте еще раз!\n ");
            programMenu(newPerson, casesList);
        }    
    }
        
    public void addNewCase(Peoples newPerson, CasesList casesList){
        try {
            System.out.println("\nДобавление новой задачи:");
            System.out.print("Выберите приоритет задачи:\n1. Низкий\n2. Средний\n3. Высокий\nВведите значение: ");
            String val = iScanner.nextLine();
            int prior = Integer.parseInt(val);
            if (prior != 1 && prior != 2 && prior != 3){
                System.out.println("\nВведено не верное значение, попробуйте еще раз.");
                addNewCase(newPerson, casesList);
            }
            System.out.print("Введите описание задачи: ");
            String textOfCase = iScanner.nextLine();
            System.out.print("Введите крайнюю дату выполнения задачи в формате {dd.mm.yyyy}: ");
            String deadlineDate = iScanner.nextLine();
            System.out.print("Введите крайнее время выполнения задачи в формате {hh:mm}: ");
            String deadlineTime = iScanner.nextLine();
            if (prior == 1){
                LowPriorityCase newCase = new LowPriorityCase(textOfCase, deadlineDate, deadlineTime, newPerson);
                casesList.AddCase(newCase);
            }
            else if (prior == 2){
                MidlePriorityCase newCase = new MidlePriorityCase(textOfCase, deadlineDate, deadlineTime, newPerson);
                casesList.AddCase(newCase);
            }
            else {
                HighPriorityCase newCase = new HighPriorityCase(textOfCase, deadlineDate, deadlineTime, newPerson);
                casesList.AddCase(newCase);
            }
            choiseAddCase(newPerson, casesList);
            
        } catch (Exception e) {
            System.out.println("\nНе корректно введено одно из значений, попробуйте еще раз!");
            addNewCase(newPerson, casesList);
        } 

    }

    public void editCase(Peoples newPerson, CasesList casesList){
        try {
            System.out.print("Введите id задачи, которую хотите изменить: ");
            String val = iScanner.nextLine();
            Integer id = Integer.parseInt(val);
            Case editCase = casesList.findCaseByID(id);
            if (editCase == null){
                System.out.println("Такая задача не найдена!");
                programMenu(newPerson, casesList);
            }
            else{
                System.out.println(editCase);
            }
            System.out.println("\nВыберите поле, которое хотите изменить:");
            System.out.print("1. Описание задачи\n2. Крайняя дата\n3. Присвоить статус 'Выполненo'\nВведите значение: ");
            String value = iScanner.nextLine();
            Integer choise = Integer.parseInt(value);
            if (choise == 1){
                System.out.print("Введите новый текст задачи: ");
                String textOfCase = iScanner.nextLine();
                editCase.setTextOfCase(textOfCase);
                System.out.println(editCase);
                choiseEditCase(newPerson, casesList);
            }
            else if (choise == 2){
                System.out.print("Введите новую дату выполнения задачи в формате [dd.mm.yyyy]: ");
                String date = iScanner.nextLine();
                editCase.setDeadlineDate(LocalDate.parse(date, DATE_FORMATER));
                System.out.println(editCase);
                choiseEditCase(newPerson, casesList);
            }
            else if (choise == 3){
                editCase.setDoneOrNot(true);
                System.out.println(editCase);
                choiseEditCase(newPerson, casesList);
            }
            else{
                System.out.println("Введено не корректное значение!");
                editCase(newPerson, casesList);
            }
            
        } catch (Exception e) {
            System.out.println("Введено не верное значение, попробуйте еще раз");
            editCase(newPerson, casesList);
        }
    }

    public void deleteCase(Peoples newPerson, CasesList casesList){
        try {
            System.out.print("Введите id задачи, которую хотите удалить: ");
            String val = iScanner.nextLine();
            Integer id = Integer.parseInt(val);
            Case deleteCase = casesList.findCaseByID(id);
            if (deleteCase == null){
                System.out.println("Такая задача не найдена!");
                programMenu(newPerson, casesList);
            }
            else{
                System.out.println(deleteCase);
            }
            System.out.println("\nПодвердите удаление задачи:");
            System.out.print("1. Подтверждаю\n2. Передумал\nВведите значение: ");
            String value = iScanner.nextLine();
            Integer choise = Integer.parseInt(value);
            if (choise == 1){
                casesList.deleteCase(id);
                System.out.println("\nЗадача удалена!");
                programMenu(newPerson, casesList);
            }
            else if (choise == 2){
                programMenu(newPerson, casesList);
            }
            else{
                System.out.println("Введено не корректное значение, попробуйте еще раз");
                deleteCase(newPerson, casesList);
            }
        } catch (Exception e) {
            System.out.println("Введено не число, попробуйте еще раз.");
            deleteCase(newPerson, casesList);
        }
    
    }

    public void findCase(Peoples newPerson, CasesList casesList){
        System.out.println("\nВведите параметр для поиска: ");
        System.out.println("\n1. Поиск по ID\n2. Поиск по дате ввода\n3. Поиск по дате окночания\n4. Поиск по приоритету\n5. поиск по статусу выполнения");
        System.out.print("Введите значение: ");
        String value = iScanner.nextLine();
        Integer choise = Integer.parseInt(value);
        if (choise == 1){
            System.out.print("Введите id задачи: ");
            String val = iScanner.nextLine();
            Integer id = Integer.parseInt(val);
            Case findCase = casesList.findCaseByID(id);
            if (findCase == null){
                System.out.println("Такая задача не найдена!");
                programMenu(newPerson, casesList);
            }
            else{
                System.out.println(findCase);
                choiseFindCase(newPerson, casesList);
            }
        }
        else if (choise == 2){
            System.out.print("Введите дату ввода задачи в формате [dd.mm.yyyy]: ");
            String date = iScanner.nextLine();
            LocalDate ImputDate = LocalDate.parse(date, DATE_FORMATER);
            casesList.findByImputDate(ImputDate);
            choiseFindCase(newPerson, casesList);
        } 
        else if (choise == 3){
            System.out.print("Введите окончательную дату выполнения задачи в формате [dd.mm.yyyy]: ");
            String date = iScanner.nextLine();
            LocalDate deadlineDate = LocalDate.parse(date, DATE_FORMATER);          
            casesList.findByDeadlineDate(deadlineDate);
            choiseFindCase(newPerson, casesList);
        } 
        else if (choise == 4){
            System.out.println("Выберите преоритет: \n1. Низкий\n2. Средний\n3. Высокий");
            System.out.print("Введите значение: ");
            String val = iScanner.nextLine();
            Integer chois = Integer.parseInt(val);
            if (chois != 1 && chois != 2 && chois != 3){
                System.out.println("Введено не верное значение.");
                choiseFindCase(newPerson, casesList);
            }
            casesList.findCaseByPriority(chois);
            choiseFindCase(newPerson, casesList);
        }
        else if (choise == 5){
            System.out.println("Введите статус выполнения: ");
            System.out.print("1. Выполнено\n2. Не выполнено\nВведите значение: ");
            String val = iScanner.nextLine();
            Integer chois = Integer.parseInt(val);
            if (chois != 1 && chois != 2){
                System.out.println("Введено не верное значение.");
                choiseFindCase(newPerson, casesList);
            casesList.findCaseByDone(chois);
            choiseFindCase(newPerson, casesList);
        }
        }
        else{
            System.out.println("Введено не верно число.");
            choiseFindCase(newPerson, casesList);
        }

    }
        
    

    public void findAllCases(Peoples newPerson, CasesList casesList){
        casesList.findAllCases();
        System.out.print("Для возврата в основное меню, введите 1: ");
        String val = iScanner.nextLine();
        Integer chois = Integer.parseInt(val);
        if (chois == 1){
            programMenu(newPerson, casesList);
        }
        else{
            System.out.println("Введено не корректное значение, но все равно идем в меню)");
            programMenu(newPerson, casesList);
        }

    }

    public void choiseEditCase(Peoples newPerson, CasesList casesList){
        try {
            System.out.println("\nЕсли хотите сделать еще изменение, нажмите 1\nЕсли хотите выйти в основное меню, нажмите 2");
            System.out.print("Введите значение: ");
            String val = iScanner.nextLine();
            Integer chois = Integer.parseInt(val);
            if (chois == 1){
                editCase(newPerson, casesList);
            }
            else if (chois == 2){
                programMenu(newPerson, casesList);
            }
            else{
                System.out.println("Введено не верное число, попробуйте еще раз");
                choiseEditCase(newPerson, casesList);
            }
        } catch (Exception e) {
            System.out.println("Введено не число, попробуйне еще раз.");
            choiseEditCase(newPerson, casesList);
        }
        
    }

    public void choiseAddCase(Peoples newPerson, CasesList casesList){
        try {
            System.out.println("\nЕсли хотите добавить еще одну задачу, нажмите - 1 \nвернуться в основное меню - 2");
            System.out.print("Ведите значение: ");
            String value = iScanner.nextLine();
            Integer choise = Integer.parseInt(value);
            if (choise == 1){
                addNewCase(newPerson, casesList);
            }
            else if (choise == 2){
                programMenu(newPerson, casesList);
            }
            else{
                System.out.println("Введено не корректное значение");
                choiseAddCase(newPerson, casesList);
            }
            
        } catch (Exception e) {
            System.out.println("Введено не корректное значение, попробуйте еще раз.");
            choiseAddCase(newPerson, casesList);
        }
        
    }

    public void choiseFindCase(Peoples newPerson, CasesList casesList){
        try {
            System.out.println("\nЕсли хотите повторить поиск, нажмите - 1 \nвернуться в основное меню - 2");
            System.out.print("Ведите значение: ");
            String value = iScanner.nextLine();
            Integer choise = Integer.parseInt(value);
            if (choise == 1){
                findCase(newPerson, casesList);
            }
            else if (choise == 2){
                programMenu(newPerson, casesList);
            }
            else{
                System.out.println("Введено не корректное значение");
                choiseFindCase(newPerson, casesList);
            }
            
        } catch (Exception e) {
            System.out.println("Введено не корректное значение, попробуйте еще раз.");
            choiseFindCase(newPerson, casesList);
        }
        
    }
}   


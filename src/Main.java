import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        YearlyReport yearlyReport = null;
        MonthReports monthReports = null;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            int userInput = scanner.nextInt();

            if (userInput == 0) {
                break;
            } else if (userInput == 1) {
                monthReports = new MonthReports();
                System.out.println("Месячные отчеты успешно считаны");

            } else if (userInput == 2) {
                yearlyReport = new YearlyReport(2021, "resources/y.2021.csv");
                System.out.println("Годовой отчет успешно считан");


            } else if (userInput == 3) {
                if (yearlyReport == null || monthReports == null) {
                    System.out.println("Файлы не считаны. Для сверки выполните 1 и 2 команды");
                    continue;
                }
                yearlyReport.checkReports(monthReports);


            } else if (userInput == 4) {
                if (monthReports == null) {
                    System.out.println("Файлы не считаны. Перед выводом информации выполните 1 команду");
                    continue;
                }
                monthReports.getInfoMonth();


            } else if (userInput == 5) {
                if (yearlyReport == null) {
                    System.out.println("Годовой файл не считан. Перед выводом информации выполните 2 команду");
                    continue;
                }
                yearlyReport.printYearYearlyReport();
                yearlyReport.countMonthlyProfit();
                yearlyReport.calculateAverage(true);
                yearlyReport.calculateAverage(false);


            } else {
                System.out.println("Извините, такой команды пока нет.");
            }

        }
        System.out.println("Программа завершена");
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт ");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");
    }
}



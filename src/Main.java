import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        YearlyReport yearlyReport = null;
        MonthReports monthReports = null;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            int inputMenuItem = scanner.nextInt();

            switch (inputMenuItem) {
                case 0:
                    break;
                case 1:
                    monthReports = new MonthReports();
                    System.out.println("Месячные отчеты успешно считаны");
                    break;
                case 2:
                    yearlyReport = new YearlyReport(2021, "resources/y.2021.csv");
                    System.out.println("Годовой отчет успешно считан");
                    break;
                case 3:
                    if (yearlyReport == null || monthReports == null) {
                        System.out.println("Файлы не считаны. Для сверки выполните 1 и 2 команды");
                        continue;
                    }
                    yearlyReport.checkReports(monthReports);
                    break;

                case 4:
                    if (monthReports == null) {
                        System.out.println("Файлы не считаны. Перед выводом информации выполните 1 команду");
                        continue;
                    }
                    monthReports.getInfoMonth();
                    break;
                case 5:
                    if (yearlyReport == null) {
                        System.out.println("Годовой файл не считан. Перед выводом информации выполните 2 команду");
                        continue;
                    }
                    yearlyReport.printYearYearlyReport();
                    yearlyReport.countMonthlyProfit();
                    yearlyReport.calculateAverage(true);
                    yearlyReport.calculateAverage(false);
                    break;
                default:
                    System.out.println("Извините, такой команды пока нет.");

            }

            System.out.println("Программа завершена");
            scanner.close();
        }
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




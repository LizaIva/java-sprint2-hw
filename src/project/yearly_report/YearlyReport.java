package project.yearly_report;

import project.FileReader;
import project.monthly_report.MonthReports;
import project.monthly_report.MonthlyReport;

import java.util.ArrayList;

public class YearlyReport {
    private static final String REPORT_TYPE = "годовым";
    private final int year;
    private final ArrayList<YearlyRecordReport> rows = new ArrayList<>();

    public YearlyReport(int year, String path) {
        this.year = year;
        String content = FileReader.readFileContentsOrNull(path, REPORT_TYPE);
        String[] lines = content.split("\n");
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] parts = line.split(",");
            int month = Integer.parseInt(parts[0]);
            int amount = Integer.parseInt(parts[1]);
            boolean isExpense = Boolean.parseBoolean(parts[2]);
            rows.add(new YearlyRecordReport(month, amount, isExpense));
        }
    }

    public void printYearYearlyReport() {
        System.out.println("Год отчета " + year);
    }

    public void calculateAverage(boolean isExpense) {
        int amountSum = 0;
        int count = 0;
        for (YearlyRecordReport row : rows) {
            if (row.isExpense() == isExpense) {
                amountSum = amountSum + row.getAmount();
                count++;
            }
        }

        int avg = amountSum / count;
        if (isExpense) {
            System.out.println("Средний расход за все месяцы составил: " + avg + " рублей");
        } else {
            System.out.println("Средний доход за все месяцы составил: " + avg + " рублей");
        }
    }

    public int getAmount(int monthNumber, boolean isExpense) {
        for (YearlyRecordReport row : rows) {
            if (row.getMonth() == monthNumber && row.isExpense() == isExpense) {
                return row.getAmount();
            }
        }
        return 0;
    }

    public void countMonthlyProfit() {
        for (int i = 1; i < 13; i++) {
            int expenseAmount = getAmount(i, true);
            int notExpenseAmount = getAmount(i, false);
            int monthlyProfit = notExpenseAmount - expenseAmount;
            if (monthlyProfit != 0) {
                System.out.println("Прибыль за " + i + " месяц составила " + monthlyProfit + " рублей.");
            }
        }
    }

    public void checkReports(MonthReports monthReports) {
        for (YearlyRecordReport row : rows) {
            MonthlyReport monthlyReport = monthReports.getMonthlyReportByMonth(row.getMonth());
            int countBalance = monthlyReport.countBalance(row.isExpense());
            if (countBalance == row.getAmount()) {
                System.out.println("Сверка месячного и годового отчета прошла успешно");
            } else {
                System.out.println("Обнаружено несоответсвие в месяце номер " + row.getMonth());
            }
        }
    }
}

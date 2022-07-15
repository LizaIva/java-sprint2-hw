
import java.util.ArrayList;

public class MonthReports {

    ArrayList<MonthlyReport> months;

    public MonthReports() {
        this.months = new ArrayList<>();

        for (int i = 1; i < 4; i++) {
            String path = "resources/m.20210" + i + ".csv";
            MonthlyReport monthlyReport = new MonthlyReport(i, path);
            months.add(monthlyReport);
        }
    }


    public MonthlyReport getMonthlyReportByMonth(int month) {
        for (MonthlyReport monthlyReport : months) {
            if (monthlyReport.month == month) {
                return monthlyReport;
            }
        }

        return null;
    }

    public void getInfoMonth() {
        for (MonthlyReport monthlyReport : months) {
            System.out.println("Месяц номер "+monthlyReport.month);
            String maxItem = null;
            String maxWaste = null;
            int maxSum = 0;
            int maxWasteSum = 0;
            for (MonthlyRecordReport row : monthlyReport.rows) {

                if (!row.isExpense) {
                    int sum = row.quantity * row.sumOfOne;
                    if (sum > maxSum) {
                        maxSum = sum;
                        maxItem = row.itemName;
                    }


                } else {
                    int sum = row.quantity * row.sumOfOne;
                    if (sum > maxWasteSum) {
                        maxWasteSum = sum;
                        maxWaste = row.itemName;
                    }


                }

            }
            System.out.println("Самый прибыльный товар '" + maxItem + "' продан на сумму " + maxSum + " рублей");
            System.out.println("Самая большая трата  '" + maxWaste + "'. Потрачено " + maxWasteSum + " рублей");

        }
    }


}






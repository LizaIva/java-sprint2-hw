
import java.util.ArrayList;

public class MonthReports {

    private final ArrayList<MonthlyReport> months;

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
            if (monthlyReport.getMonth() == month) {
                return monthlyReport;
            }
        }

        return null;
    }

    public void getInfoMonth() {
        for (MonthlyReport monthlyReport : months) {
            System.out.println("Месяц номер " + monthlyReport.getMonth());
            String maxItem = null;
            String maxWaste = null;
            int maxSum = 0;
            int maxWasteSum = 0;
            for (MonthlyRecordReport row : monthlyReport.getRows()) {

                int sum = row.getQuantity() * row.getSumOfOne();
                if (!row.isExpense()) {
                    if (sum > maxSum) {
                        maxSum = sum;
                        maxItem = row.getItemName();
                    }


                } else {
                    if (sum > maxWasteSum) {
                        maxWasteSum = sum;
                        maxWaste = row.getItemName();
                    }
                }
            }
            System.out.println("Самый прибыльный товар '" + maxItem + "' продан на сумму " + maxSum + " рублей");
            System.out.println("Самая большая трата  '" + maxWaste + "'. Потрачено " + maxWasteSum + " рублей");
        }
    }
}






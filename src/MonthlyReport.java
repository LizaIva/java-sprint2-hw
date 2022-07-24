import java.util.ArrayList;


public class MonthlyReport {
    private static final String REPORT_TYPE = "месячным";

    private final int month;
    private final ArrayList<MonthlyRecordReport> rows = new ArrayList<>();

    public MonthlyReport(int month, String path) {
        this.month = month;
        String content = FileReader.readFileContentsOrNull(path, REPORT_TYPE);
        if (content == null) {
            return;
        }
        String[] lines = content.split("\n");
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] parts = line.split(",");
            String itemName = parts[0];
            boolean isExpense = Boolean.parseBoolean(parts[1]);
            int quantity = Integer.parseInt(parts[2]);
            int sumOfOne = Integer.parseInt(parts[3]);
            rows.add(new MonthlyRecordReport(itemName, isExpense, quantity, sumOfOne));
        }
    }

    public int countBalance(boolean isExpense) {
        int sum = 0;
        for (MonthlyRecordReport row : rows) {
            if (row.isExpense() == isExpense) {
                sum = sum + row.getQuantity() * row.getSumOfOne();
            }
        }
        return sum;
    }

    public int getMonth() {
        return month;
    }

    public ArrayList<MonthlyRecordReport> getRows() {
        return rows;
    }
}




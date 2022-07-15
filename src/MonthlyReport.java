import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class MonthlyReport {
    int month;
    ArrayList<MonthlyRecordReport> rows = new ArrayList<>();

    public MonthlyReport(int month, String path) {
        this.month = month;
        String content = readFileContentsOrNull(path);
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
            if (row.isExpense == isExpense) {
               sum = sum + row.quantity*row.sumOfOne;
            }
        }
        return sum;
    }


    private String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            System.out.println(path);
            return null;
        }
    }


}




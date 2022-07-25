package project.yearly_report;

public class YearlyRecordReport {
    private final int month;
    private final int amount;
    private final boolean isExpense;

    public YearlyRecordReport(int month, int amount, boolean isExpense) {
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
    }

    public int getMonth() {
        return month;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isExpense() {
        return isExpense;
    }
}



package sample;

public class TableData {
    private String col_a;
    private String col_b;

    public TableData(String col_a,String col_b){
        this.col_a = col_a;
        this.col_b = col_b;
    }

    public String getCol_a() {
        return col_a;
    }

    public void setCol_a(String col_a) {
        this.col_a = col_a;
    }

    public String getCol_b() {
        return col_b;
    }

    public void setCol_b(String col_b) {
        this.col_b = col_b;
    }
}

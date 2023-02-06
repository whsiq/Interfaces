import java.util.ArrayList;

public class Collect {

    private Filter filter;
    private ArrayList<Object> list;
    public static ArrayList<Object> collectAll(Filter filter, ArrayList<Object> list) {
        ArrayList<Object> valid = new ArrayList<>();
        for (Object i : list) {
            if (filter.accept(i)) {
                valid.add(i);
            }
        }
        return valid;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public ArrayList<Object> getList() {
        return list;
    }

    public void setList(ArrayList<Object> list) {
        this.list = list;
    }
}
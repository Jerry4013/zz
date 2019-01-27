public class People {
    private int hight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        People people = (People) o;

        return hight == people.hight;
    }

    @Override
    public int hashCode() {
        return hight;
    }
}

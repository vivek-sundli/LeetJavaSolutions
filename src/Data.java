class Data {
    Integer val;
    String name;

    public Data(Integer val, String name) {
        this.val = val;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Data data = (Data) obj;
        return (val != null ? val.equals(data.val) : data.val == null) &&
                (name != null ? name.equals(data.name) : data.name == null);
    }

    @Override
    public int hashCode() {
        int result = val != null ? val.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
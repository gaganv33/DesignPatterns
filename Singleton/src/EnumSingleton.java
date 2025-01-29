public enum EnumSingleton {
    INSTANCE;
    private EnumSingleton() {

    }
    void printClassDetails() {
        System.out.println(getClass());
    }
}

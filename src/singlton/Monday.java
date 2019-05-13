package singlton;

public enum Monday {
    MONDAY("monday");

    private String name;
    private Monday(String name) {
        this.name = name;
    }

    public void go() {

    }

    public static void main(String[] args) {
        Monday monday = Monday.MONDAY;
        monday.go();
    }

}

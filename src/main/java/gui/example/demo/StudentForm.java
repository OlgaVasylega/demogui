package gui.example.demo;

public class StudentForm {
    private int id;
    private String name;
    private String grupa;
    private int mark;

    public StudentForm() {
    }

    public StudentForm(int id, String name, int mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    public StudentForm(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;

    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    @Override
    public String toString() {
        return "StudentForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grupa='" + grupa + '\'' +
                ", mark=" + mark +
                '}';
    }
}

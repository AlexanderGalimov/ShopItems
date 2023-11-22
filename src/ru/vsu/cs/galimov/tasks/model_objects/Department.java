package ru.vsu.cs.galimov.tasks.model_objects;

public class Department implements ShopStored {
    protected Integer id;
    protected String name;
    protected String workingHours;

    public Department(String name, String workingHours) {
        this.id = null;
        this.name = name;
        this.workingHours = workingHours;
    }

    public Department(Integer id, String name, String workingHours) {
        this.id = id;
        this.name = name;
        this.workingHours = workingHours;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", workingHours=" + workingHours +
                '}';
    }
}

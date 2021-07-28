package hu.ulyssys.java.course.database.jdbc;

public class Address {
    private Long id;
    private Long employeeId;
    private String value;

    public Address() {
    }

    public Address(Long id, Long employeeId, String value) {
        this.id = id;
        this.employeeId = employeeId;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

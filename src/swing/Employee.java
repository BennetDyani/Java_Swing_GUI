package swing;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author BENNET DYANI <bennet.dyani>
 */
public class Employee {

    private String department;
    private String name;
    private String surname;
    private String empNumber;
    private String empType;

    public Employee() {
    }

    public Employee(String department, String name, String surname, String empNumber, String empType) {
        this.department = department;
        this.name = name;
        this.surname = surname;
        this.empNumber = empNumber;
        this.empType = empType;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmpNumber() {
        return empNumber;
    }

    public String getEmpType() {
        return empType;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    @Override
    public String toString() {
        return "department: " + department + " name:" + name + " surname:" + surname + " empNumber:" + empNumber + " empType:" + empType ;
    }

    public void fileWritter(String write) {

        try {

            FileHandlerClass handler = new FileHandlerClass();
            handler.openFile();
            handler.processFile(write);
            handler.closeFile();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "The problem is the fileWriter method! ");
        }

    }

}

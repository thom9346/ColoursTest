package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer {

    private StringProperty  id;
    private StringProperty date;

    public Customer(String  id, String date){
        this.id = new SimpleStringProperty(id);

        this.date = new SimpleStringProperty(date);
    }

    public StringProperty  getId() {
        return id;
    }
    public StringProperty getDate() {
        return date;
    }


}

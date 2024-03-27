package proiectfx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;
import javafx.beans.property.ObjectProperty;
import java.util.Date;
import javafx.beans.property.SimpleObjectProperty;

public class Actor {

    private final IntegerProperty idactor;
    private final StringProperty Nume;
    private final StringProperty Prenume;
    private final StringProperty Nationalitate;
    private ObjectProperty<CheckBox> Select;

    public Actor(Integer idactor, String Nume, String Prenume, String Nationalitate, CheckBox Select) {
        this.idactor = new SimpleIntegerProperty(idactor);
        this.Nume = new SimpleStringProperty(Nume);
        this.Prenume = new SimpleStringProperty(Prenume);
        this.Nationalitate = new SimpleStringProperty(Nationalitate);
        this.Select = new SimpleObjectProperty<>(Select);
    }

    public Integer getIdactor() {
        return idactor.get();
    }

    public String getNume() {
        return Nume.get();
    }

    public String getPrenume() {
        return Prenume.get();
    }

    public String getNationalitate() {
        return Nationalitate.get();
    }
    
    public CheckBox getSelect() {
        return Select.get();
    }

    public void setIdActor(Integer valoare) {
        idactor.set(valoare);
    }

    public void setNume(String valoare) {
        Nume.set(valoare);
    }

    public void setPrenume(String valoare) {
        Prenume.set(valoare);
    }

    public void setNationalitate(String valoare) {
        Nationalitate.set(valoare);
    }
    
    public void setSelect(CheckBox selected) {
		Select.set(selected);;
	}

    public IntegerProperty idactorProperty() {
        return idactor;
    }

    public StringProperty NumeProperty() {
        return Nume;
    }

    public StringProperty PrenumeProperty() {
        return Prenume;
    }

    public StringProperty NationalitateProperty() {
        return Nationalitate;
    }
    
    public ObjectProperty<CheckBox> SelectProperty() {
        return Select;
    }
}
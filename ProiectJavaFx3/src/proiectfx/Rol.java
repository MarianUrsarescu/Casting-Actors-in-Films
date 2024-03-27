package proiectfx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Rol {

    private final IntegerProperty idRol;
    private final IntegerProperty idActor;
    private final IntegerProperty idFilm;
    private final StringProperty NumePersonaj;
    private ObjectProperty<CheckBox> Select;

    public Rol(Integer idRol, Integer idActor, Integer idFilm, String NumePersonaj, CheckBox Select) {
        this.idRol = new SimpleIntegerProperty(idRol);
        this.idActor = new SimpleIntegerProperty(idActor);
        this.idFilm = new SimpleIntegerProperty(idFilm);
        this.NumePersonaj = new SimpleStringProperty(NumePersonaj);
        this.Select = new SimpleObjectProperty<>(Select);
    }

    public Integer getIdrol() {
        return idRol.get();
    }

    public Integer getidActor() {
        return idActor.get();
    }

    public Integer getidFilm() {
        return idFilm.get();
    }

    public String getNumePersonaj() {
        return NumePersonaj.get();
    }
    
    public CheckBox getSelect() {
        return Select.get();
    }

    public void setIdrol(Integer valoare) {
    	idRol.set(valoare);
    }

    public void setidActor(Integer valoare) {
    	idActor.set(valoare);
    }

    public void setidFilm(Integer valoare) {
    	idFilm.set(valoare);
    }

    public void setNumePersonaj(String valoare) {
    	NumePersonaj.set(valoare);
    }
    
    public void setSelect(CheckBox selected) {
		Select.set(selected);;
	}

    public IntegerProperty idRolProperty() {
        return idRol;
    }

    public IntegerProperty idActorProperty() {
        return idActor;
    }

    public IntegerProperty idFilmProperty() {
        return idFilm;
    }

    public StringProperty NumePersonajProperty() {
        return NumePersonaj;
    }
    
    public ObjectProperty<CheckBox> SelectProperty() {
        return Select;
    }
}
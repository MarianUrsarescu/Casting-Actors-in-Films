package proiectfx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.FloatProperty;

public class Film {

    private final IntegerProperty idfilm;
    private final StringProperty Titlu;
    private final StringProperty TipFilm;
    private ObjectProperty<CheckBox> Select;
    

    public Film(Integer idfilm, String Titlu, String TipFilm, CheckBox Select) {
        this.idfilm = new SimpleIntegerProperty(idfilm);
        this.Titlu = new SimpleStringProperty(Titlu);
        this.TipFilm = new SimpleStringProperty(TipFilm);
        this.Select = new SimpleObjectProperty<>(Select);
    }

    public Integer getIdfilm() {
        return idfilm.get();
    }

    public String getTitlu() {
        return Titlu.get();
    }

    public String getTipFilm() {
        return TipFilm.get();
    }
    
    public CheckBox getSelect() {
        return Select.get();
    }

    public void setIdFilm(Integer valoare) {
        idfilm.set(valoare);
    }

    public void setTitlu(String valoare) {
    	Titlu.set(valoare);
    }

    public void setTipFilm(String valoare) {
    	TipFilm.set(valoare);
    }
    
    public void setSelect(CheckBox selected) {
		Select.set(selected);;
	}


    public IntegerProperty idfilmProperty() {
        return idfilm;
    }

    public StringProperty TitluProperty() {
        return Titlu;
    }

    public StringProperty TipFilmProperty() {
        return TipFilm;
    }
    
    public ObjectProperty<CheckBox> SelectProperty() {
        return Select;
    }

}
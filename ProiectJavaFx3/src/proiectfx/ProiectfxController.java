package proiectfx;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
//import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;


public class ProiectfxController implements Initializable {
    
    @FXML
    private TableView<Film> tabela_Filme;
    @FXML
    private Tab tab_Filme;
    @FXML
    private Button buton_IncarcareFilme;
    @FXML
    private TableColumn<Film, Integer> atribut_idfilm;
    @FXML
    private TableColumn<Film, String> atribut_TitluF;
    @FXML
    private TableColumn<Film, String> atribut_TipFilmF;
    @FXML
    private TableColumn<Film, CheckBox> atribut_SelectF;
    @FXML
    private Button buton_StergeFilme;
    @FXML
    private Button buton_ModificaFilme;
    @FXML
	private TextField inputTitluF = new TextField();
	@FXML
	private TextField inputTipF = new TextField();
	@FXML
    private TableView<Actor> tabela_Actori;
    @FXML
    private Tab tab_Actori;
    @FXML
    private Button buton_IncarcareActori;
    @FXML
    private TableColumn<Actor, Integer> atribut_idactor;
    @FXML
    private TableColumn<Actor, String> atribut_NumeA;
    @FXML
    private TableColumn<Actor, String> atribut_PrenumeA;
    @FXML
    private TableColumn<Actor, String> atribut_NationalitateA;
    @FXML
    private TableColumn<Actor, CheckBox> atribut_SelectA;
    @FXML
    private Button buton_StergeActori;
    @FXML
    private Button buton_ModificaActori;
    @FXML
	private TextField inputNumeA= new TextField();
	@FXML
	private TextField inputPrenumeA= new TextField();
	@FXML
	private TextField inputNationalitateA= new TextField();
	@FXML
    private TableView<Rol> tabela_Roluri;
    @FXML
    private Tab tab_Roluri;
    @FXML
    private Button buton_IncarcareRoluri;
    @FXML
    private TableColumn<Actor, Integer> atribut_idRol;
    @FXML
    private TableColumn<Actor, Integer> atribut_idActorR;
    @FXML
    private TableColumn<Actor, Integer> atribut_idFilmR;
    @FXML
    private TableColumn<Actor, String> atribut_NumePersonajR;
    @FXML
    private TableColumn<Actor, CheckBox> atribut_SelectR;
    @FXML
    private Button buton_StergeRoluri;
    @FXML
    private Button buton_ModificaRoluri;
    @FXML
	private ComboBox combobox_filme;
	@FXML
	private ComboBox combobox_actori;
	@FXML
	private TextField inputidActorR = new TextField();
	@FXML
	private TextField inputidFilmR= new TextField();
	@FXML
	private TextField inputNumePersonajR = new TextField();
	@FXML
    
    private ObservableList<Film> dateFilme;
    private ObservableList<Actor> dateActori;
    private ObservableList<Rol> dateRoluri;
    private DBOperations jb;
    
    private ObservableList<Film> dataFilmelist;
    private ObservableList<Actor> dataActorilist;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jb = new DBOperations();
        if (combobox_filme != null) {
			ObservableList<Integer> dateIdFilme = FXCollections.observableArrayList();
			try {
				jb.connect();
				ResultSet rs = jb.vedeTabel("Filme");
				while (rs.next()) {
					dateIdFilme.add(rs.getInt("idFilm"));
				}
				jb.disconnect();
				combobox_filme.setItems(dateIdFilme);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			
		}
		if (combobox_actori != null) {
			ObservableList<Integer> dateIdActori = FXCollections.observableArrayList();
			try {
				jb.connect();
				ResultSet rs = jb.vedeTabel("Actori");
				while (rs.next()) {
					dateIdActori.add(rs.getInt("idActor"));
				}
				jb.disconnect();
				combobox_actori.setItems(dateIdActori);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			
		}	
		
    }    

    @FXML
    private void incarcaFilme(ActionEvent event) throws SQLException, Exception {
        jb.connect();
        dateFilme = FXCollections.observableArrayList();

        ResultSet rs = jb.vedeTabel("filme");
        while (rs.next()) {
        	CheckBox Select = new CheckBox("");
        	dateFilme.add(new Film(rs.getInt("idfilm"), rs.getString("Titlu"), rs.getString("TipFilm"), Select));
        }

        atribut_idfilm.setCellValueFactory(new PropertyValueFactory<>("idfilm"));
        atribut_TitluF.setCellValueFactory(new PropertyValueFactory<>("Titlu"));
        atribut_TipFilmF.setCellValueFactory(new PropertyValueFactory<>("TipFilm"));
        atribut_SelectF.setCellValueFactory(new PropertyValueFactory<>("Select"));
        
        tabela_Filme.setItems(null);
        tabela_Filme.setItems(dateFilme);
        jb.disconnect();
    }
    
    @FXML
	private void startAdaugaFilm() throws IOException {
		Stage stage = new Stage();
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("AdaugaFilme.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	private void adaugaFilm() throws SQLException, Exception {
		String titlu = inputTitluF.getText();
		String tip = inputTipF.getText();
		
		jb.connect();
		jb.adaugaFilm(titlu, tip);
		jb.disconnect();
	}

    @FXML
    private void incarcaActori(ActionEvent event) throws SQLException, Exception {
        jb.connect();
        dateActori = FXCollections.observableArrayList();

        ResultSet rs = jb.vedeTabel("actori");
        while (rs.next()) {
        	CheckBox Select = new CheckBox("");
            dateActori.add(new Actor(rs.getInt("idactor"), rs.getString("Nume"), rs.getString("Prenume"), rs.getString("Nationalitate"), Select));
        }

        atribut_idactor.setCellValueFactory(new PropertyValueFactory<>("idactor"));
        atribut_NumeA.setCellValueFactory(new PropertyValueFactory<>("Nume"));
        atribut_PrenumeA.setCellValueFactory(new PropertyValueFactory<>("Prenume"));
        atribut_NationalitateA.setCellValueFactory(new PropertyValueFactory<>("Nationalitate"));
        atribut_SelectA.setCellValueFactory(new PropertyValueFactory<>("Select"));
        
        tabela_Actori.setItems(null);
        tabela_Actori.setItems(dateActori);
        jb.disconnect();
    } 
    
    @FXML
	private void startAdaugaActor() throws IOException {
		Stage stage = new Stage();
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("AdaugaActori.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	private void adaugaActor() throws SQLException, Exception {
		String nume = inputNumeA.getText();
		String prenume = inputPrenumeA.getText();
		String nationalitate = inputNationalitateA.getText();
		
		jb.connect();
		jb.adaugaActor(nume, prenume, nationalitate);
		jb.disconnect();
	}
    
    @FXML
    private void incarcaRoluri(ActionEvent event) throws SQLException, Exception {
        jb.connect();
        dateRoluri = FXCollections.observableArrayList();

        ResultSet rs = jb.vedeTabel("roluri");
        while (rs.next()) {
        	CheckBox Select = new CheckBox("");
            dateRoluri.add(new Rol(rs.getInt("idRol"), rs.getInt("idActor"), rs.getInt("IdFilm"), rs.getString("NumePersonaj"), Select));
        }

        atribut_idRol.setCellValueFactory(new PropertyValueFactory<>("idRol"));
        atribut_idActorR.setCellValueFactory(new PropertyValueFactory<>("idActor"));
        atribut_idFilmR.setCellValueFactory(new PropertyValueFactory<>("idFilm"));
        atribut_NumePersonajR.setCellValueFactory(new PropertyValueFactory<>("NumePersonaj"));
        atribut_SelectR.setCellValueFactory(new PropertyValueFactory<>("Select"));
        
        tabela_Roluri.setItems(null);
        tabela_Roluri.setItems(dateRoluri);
        jb.disconnect();
    } 
    
    @FXML
	private void startAdaugaRol() throws IOException {
		Stage stage = new Stage();
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("AdaugaRoluri.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	private void adaugaRol() throws SQLException, Exception {
		String nume = inputNumePersonajR.getText();
		Integer idFilm = (Integer) combobox_filme.getValue();
		Integer idActor = (Integer) combobox_actori.getValue();
		
		jb.connect();
		jb.adaugaRol(idFilm, idActor, nume);
		jb.disconnect();
	}
	
	@FXML
    private void stergeFilme(ActionEvent event) throws SQLException, Exception {
    	jb.connect();
        
        for(int i = 0; i < tabela_Filme.getItems().size(); i ++) {
        	if(tabela_Filme.getItems().get(i).getSelect().isSelected()) {
        		long pk = tabela_Filme.getItems().get(i).getIdfilm();
        		jb.stergeTabela("filme", "idfilm", pk);
        	}
        }
        
      dateFilme = FXCollections.observableArrayList();

      ResultSet rs = jb.vedeTabel("filme");
      while (rs.next()) {
      	CheckBox Select = new CheckBox("");
          dateFilme.add(new Film(rs.getInt("idfilm"), rs.getString("Titlu"), rs.getString("TipFilm"), Select));
      }
      
      tabela_Filme.setItems(null);
      tabela_Filme.setItems(dateFilme);
        
        
        jb.disconnect();
    }
	
	@FXML
    private void stergeActori(ActionEvent event) throws SQLException, Exception {
    	jb.connect();
        
        for(int i = 0; i < tabela_Actori.getItems().size(); i ++) {
        	if(tabela_Actori.getItems().get(i).getSelect().isSelected()) {
        		long pk = tabela_Actori.getItems().get(i).getIdactor();
        		jb.stergeTabela("actori", "idactor", pk);
        	}
        }
        
      dateActori = FXCollections.observableArrayList();

      ResultSet rs = jb.vedeTabel("actori");
      while (rs.next()) {
      	CheckBox Select = new CheckBox("");
          dateActori.add(new Actor(rs.getInt("idactor"), rs.getString("Nume"), rs.getString("Prenume"), rs.getString("Nationalitate"), Select)); 
      }
      
      tabela_Actori.setItems(null);
      tabela_Actori.setItems(dateActori);
        
        
        jb.disconnect();
    }
	
	@FXML
    private void stergeRoluri(ActionEvent event) throws SQLException, Exception {
    	jb.connect();
        
        for(int i = 0; i < tabela_Roluri.getItems().size(); i ++) {
        	if(tabela_Roluri.getItems().get(i).getSelect().isSelected()) {
        		long pk = tabela_Roluri.getItems().get(i).getIdrol();
        		jb.stergeTabela("roluri", "idrol", pk);
        	}
        }
        
        dateRoluri = FXCollections.observableArrayList();

        ResultSet rs = jb.vedeTabel("roluri");
        while (rs.next()) {
        	CheckBox Select = new CheckBox("");
            dateRoluri.add(new Rol(rs.getInt("idRol"), rs.getInt("idActor"), rs.getInt("IdFilm"), rs.getString("NumePersonaj"), Select));
        }
        
        tabela_Roluri.setItems(null);
        tabela_Roluri.setItems(dateRoluri);      
        
        jb.disconnect();
    }
	
	
	@FXML
    private void modificaFilme(ActionEvent event) throws SQLException, Exception {
    	jb.connect();
    	ArrayList<String> campuri = new ArrayList<>();
    	ArrayList<String> valori = new ArrayList<>();
    	
        String titlu = inputTitluF.getText();
        if(!titlu.isEmpty()) {
        	valori.add(titlu);
        	campuri.add("titlu");
        }
        String tipfilm = inputTipF.getText();
        if(!tipfilm.isEmpty()) {
        	valori.add(tipfilm);
        	campuri.add("tipfilm");
        }
        
        String[] campuri_array = campuri.toArray(new String[0]);
        String[] valori_array = valori.toArray(new String[0]);
        
        for(int i = 0; i < tabela_Filme.getItems().size(); i ++) {
        	if(tabela_Filme.getItems().get(i).getSelect().isSelected()) {
        		long pk = tabela_Filme.getItems().get(i).getIdfilm();
        		jb.modificaTabela("filme", "idfilm", pk, campuri_array, valori_array);
        	}
        }
        
        dateFilme = FXCollections.observableArrayList();

        ResultSet rs = jb.vedeTabel("filme");
        while (rs.next()) {
        	CheckBox Select = new CheckBox(null);
            dateFilme.add(new Film(rs.getInt("idfilm"), rs.getString("Titlu"), rs.getString("TipFilm"), Select));
        }
        
        inputTitluF.clear();
        inputTipF.clear();
        
        tabela_Filme.setItems(null);
        tabela_Filme.setItems(dateFilme);
        jb.disconnect();
    }
	
	@FXML
    private void modificaActori(ActionEvent event) throws SQLException, Exception {
    	jb.connect();
    	ArrayList<String> campuri = new ArrayList<>();
    	ArrayList<String> valori = new ArrayList<>();
    	
    	
        String nume = inputNumeA.getText();
        if(!nume.isEmpty()) {
        	valori.add(nume);
        	campuri.add("nume");
        }
        String prenume = inputPrenumeA.getText();
        if(!prenume.isEmpty()) {
        	valori.add(prenume);
        	campuri.add("prenume");
        }
        String nationalitate = inputNationalitateA.getText();
        if(!nationalitate.isEmpty()) {
        	valori.add(nationalitate);
        	campuri.add("nationalitate");
        }
        String[] campuri_array = campuri.toArray(new String[0]);
        String[] valori_array = valori.toArray(new String[0]);
        
        for(int i = 0; i < tabela_Actori.getItems().size(); i ++) {
        	if(tabela_Actori.getItems().get(i).getSelect().isSelected()) {
        		long pk = tabela_Actori.getItems().get(i).getIdactor();
        		jb.modificaTabela("actori", "idActor", pk, campuri_array, valori_array);
        	}
        }
        
        dateActori = FXCollections.observableArrayList();

        ResultSet rs = jb.vedeTabel("actori");
        while (rs.next()) {
        	CheckBox Select = new CheckBox(null);
            dateActori.add(new Actor(rs.getInt("idactor"), rs.getString("Nume"), rs.getString("Prenume"), rs.getString("Nationalitate"), Select));
        }
        
        inputNumeA.clear();
        inputPrenumeA.clear();
        inputNationalitateA.clear();
        
        tabela_Actori.setItems(null);
        tabela_Actori.setItems(dateActori);
        jb.disconnect();
    }
	
	@FXML
    private void modificaRoluri(ActionEvent event) throws SQLException, Exception {
    	jb.connect();
    	ArrayList<String> campuri = new ArrayList<>();
    	ArrayList<String> valori = new ArrayList<>();
    	
        String idactor = inputidActorR.getText();
        if(!idactor.isEmpty()) {
        	valori.add(idactor);
        	campuri.add("idactor");
        }
        String idfilm = inputidFilmR.getText();
        if(!idfilm.isEmpty()) {
        	valori.add(idfilm);
        	campuri.add("idfilm");
        }
        String numepersonaj = inputNumePersonajR.getText();
        if(!numepersonaj.isEmpty()) {
        	valori.add(numepersonaj);
        	campuri.add("numepersonaj");
        }
        
        String[] campuri_array = campuri.toArray(new String[0]);
        String[] valori_array = valori.toArray(new String[0]);
        
        for(int i = 0; i < tabela_Roluri.getItems().size(); i ++) {
        	if(tabela_Roluri.getItems().get(i).getSelect().isSelected()) {
        		long pk = tabela_Roluri.getItems().get(i).getIdrol();
        		jb.modificaTabela("roluri", "idRol", pk, campuri_array, valori_array);
        	}
        }
        
        dateRoluri = FXCollections.observableArrayList();

        ResultSet rs = jb.vedeTabel("roluri");
        while (rs.next()) {
        	CheckBox Select = new CheckBox("");
            dateRoluri.add(new Rol(rs.getInt("idRol"), rs.getInt("idActor"), rs.getInt("IdFilm"), rs.getString("NumePersonaj"), Select));
        }
        
        inputidActorR.clear();
        inputidFilmR.clear();
        inputNumePersonajR.clear();
        
        tabela_Roluri.setItems(null);
        tabela_Roluri.setItems(dateRoluri);
        jb.disconnect();
    }
}
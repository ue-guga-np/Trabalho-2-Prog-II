package uenp.maquinacoxinhas;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TelaPrincipalController {
    
    @FXML
    private Maquina maquina;
    
    @FXML
    private TextField campoQuantidadeComprar;
    
    @FXML
    private TextField campoAbastecimento;
    
    @FXML
    private Label labelQtdCoxinhas;
    
    @FXML
    private Label labelPreco;
    
    @FXML
    private Label labelTotalVendido;
    
    @FXML
    private Label labelTotalArrecadado;
    
    @FXML
    private void initialize(){
        maquina = new Maquina(0, 3.50);
        labelQtdCoxinhas.setText(Integer.toString(maquina.getQuantCoxinhas()));
        labelPreco.setText("R$" + Double.toString(maquina.getPreco()));
        labelTotalVendido.setText("0");
        labelTotalArrecadado.setText("R$0.0");
    }
    
    @FXML
    private void comprar1(){
        if (maquina.getQuantCoxinhas() < 1){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Sem coxinhas para vender!");
            alert.show();
            return;
        }
        
        maquina.vender();
        atualizarStatus();
    }
    
    @FXML
    private void comprarVarias(){
        if (maquina.getQuantCoxinhas() < Integer.parseInt(campoQuantidadeComprar.getText())){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Quantidade de coxinhas indisponível!");
            alert.show();
            return;
        }
        
        maquina.vender(Integer.parseInt(campoQuantidadeComprar.getText()));
        atualizarStatus();
    }
    
    @FXML
    private void abastecer(){
        int quantAbastecimento = Integer.parseInt(campoAbastecimento.getText());
        
        if (quantAbastecimento + maquina.getQuantCoxinhas() > maquina.getMaxCoxinhas())
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Contêm espaço apenas para mais " + (maquina.getMaxCoxinhas() - maquina.getQuantCoxinhas()) + " coxinhas.");
            alert.show();
            return;
        }
        
        maquina.abastecer(quantAbastecimento);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Coxinhas abastecidas com sucesso!");
        atualizarStatus();
        alert.show();
    }
    
    @FXML
    private void zerar(){
        maquina.setQuantCoxinhas(0);
        
        Alert alert = new Alert(AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Coxínhas zeradas!");
        atualizarStatus();
        alert.show();
    }
    
    private void atualizarStatus(){
        labelQtdCoxinhas.setText(Integer.toString(maquina.getQuantCoxinhas()));
        labelTotalVendido.setText(Integer.toString(maquina.getQuantCoxinhasVendidas()));
        labelTotalArrecadado.setText("R$" + Double.toString(maquina.getDinheiroAdquirido()));        
    }
   
}

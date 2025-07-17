package uenp.maquinacoxinhas;

public class Maquina {

    private int quantCoxinhas;
    private double dinheiroAdquirido;
    private double preco;
    private int quantCoxinhasVendidas;
    private int maxCoxinhas;

    public int getQuantCoxinhas() {
        return quantCoxinhas;
    }

    public void setQuantCoxinhas(int quantCoxinhas) {
        this.quantCoxinhas = quantCoxinhas;
    }

    public double getDinheiroAdquirido() {
        return dinheiroAdquirido;
    }

    public void setDinheiroAdquirido(double dinheiroAdquirido) {
        this.dinheiroAdquirido = dinheiroAdquirido;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantCoxinhasVendidas() {
        return quantCoxinhasVendidas;
    }

    public void setQuantCoxinhasVendidas(int quantCoxinhasVendidas) {
        this.quantCoxinhasVendidas = quantCoxinhasVendidas;
    }

    public int getMaxCoxinhas() {
        return maxCoxinhas;
    }

    public void setMaxCoxinhas(int maxCoxinhas) {
        this.maxCoxinhas = maxCoxinhas;
    }
    
    public Maquina(){
        quantCoxinhas = 0;
        dinheiroAdquirido = 0; 
        preco = 3.5;
        quantCoxinhasVendidas = 0;
        maxCoxinhas = 250;
    }
    
    public Maquina(int quant_coxinhas, double preco){
        this.quantCoxinhas = quant_coxinhas;
        dinheiroAdquirido = 0; 
        this.preco = preco;
        quantCoxinhasVendidas = 0;
        maxCoxinhas = 250;
    }
    
    public void abastecer(int qtd){
        if (qtd > 0)
            quantCoxinhas += qtd;
        else
            System.out.println("Quantidade inválida de reabastecimento.");
    }
    
    public void vender(){
        if (quantCoxinhas > 0){
            quantCoxinhas--;
            dinheiroAdquirido += preco;
        }
        
        else
            System.out.println("Nenhuma coxinha para vender.");
    }
    
    public void vender(int qtd){
        if (quantCoxinhas - qtd >= 0)
        {
            quantCoxinhas -= qtd;
            dinheiroAdquirido += preco * qtd;
        }
        
        else 
            System.out.println("Quantidade de coxinhas indisponível para venda.");
    }
    
    public void zerarCoxinhas(){
        quantCoxinhas = 0;
    }
    
    public void zerarDinheiro(){
        dinheiroAdquirido = 0;
    }
}

import javax.swing.*;
import java.awt.*;

public class BancoVisao extends JFrame {
    private JTextField campoTitular;
    private JTextField campoValor;
    private JLabel rotuloSaldo;
    private JButton botaoCriarConta;
    private JButton botaoDepositar;
    private JButton botaoSacar;

    public BancoVisao() {
        setTitle("BancoFinanceiro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

    
        add(new JLabel("Titular da Conta:"));
        campoTitular = new JTextField();
        add(campoTitular);

        add(new JLabel("Valor:"));
        campoValor = new JTextField();
        add(campoValor);

        add(new JLabel("Saldo:"));
        rotuloSaldo = new JLabel("0.0");
        add(rotuloSaldo);

        botaoCriarConta = new JButton("Criar Conta");
        add(botaoCriarConta);

        botaoDepositar = new JButton("Depositar");
        add(botaoDepositar);

        botaoSacar = new JButton("Sacar");
        add(botaoSacar);
    }

    public JTextField getCampoTitular() {
        return campoTitular;
    }

    public JTextField getCampoValor() {
        return campoValor;
    }

    public JLabel getRotuloSaldo() {
        return rotuloSaldo;
    }

    public JButton getBotaoCriarConta() {
        return botaoCriarConta;
    }

    public JButton getBotaoDepositar() {
        return botaoDepositar;
    }

    public JButton getBotaoSacar() {
        return botaoSacar;
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BancoControle {
    private BancoVisao visao;
    private ContaBancaria modelo;

    public BancoControle(BancoVisao visao) {
        this.visao = visao;
        initControle();
    }

    private void initControle() {
        visao.getBotaoCriarConta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarConta();
            }
        });

        visao.getBotaoDepositar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depositar();
            }
        });

        visao.getBotaoSacar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sacar();
            }
        });
    }

    private void criarConta() {
        String titular = visao.getCampoTitular().getText();
        if (!titular.isEmpty()) {
            modelo = new ContaBancaria(titular);
            JOptionPane.showMessageDialog(visao, "Conta criada para: " + titular);
            visao.getRotuloSaldo().setText("0.0");
        } else {
            JOptionPane.showMessageDialog(visao, "Por favor, insira um nome válido para o titular.");
        }
    }

    private void depositar() {
        if (modelo != null) {
            try {
                double valor = Double.parseDouble(visao.getCampoValor().getText());
                modelo.depositar(valor);
                visao.getRotuloSaldo().setText(String.valueOf(modelo.getSaldo()));
                JOptionPane.showMessageDialog(visao, "Valor depositado: " + valor);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(visao, "Por favor, insira um valor válido.");
            }
        } else {
            JOptionPane.showMessageDialog(visao, "Por favor, crie uma conta primeiro.");
        }
    }

    private void sacar() {
        if (modelo != null) {
            try {
                double valor = Double.parseDouble(visao.getCampoValor().getText());
                if (modelo.sacar(valor)) {
                    visao.getRotuloSaldo().setText(String.valueOf(modelo.getSaldo()));
                    JOptionPane.showMessageDialog(visao, "Valor sacado: " + valor);
                } else {
                    JOptionPane.showMessageDialog(visao, "Saldo insuficiente.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(visao, "Por favor, insira um valor válido.");
            }
        } else {
            JOptionPane.showMessageDialog(visao, "Por favor, crie uma conta primeiro.");
        }
    }
}

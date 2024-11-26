public class Principal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BancoVisao visao = new BancoVisao();
            new BancoControle(visao);
            visao.setVisible(true);
        });
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            // conecta no banco
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_psc2023s01","freedb_psc2023s01","uds?rM#c?7gT2CQ");
            Statement clausula = con.createStatement();

            // executa a clasusula SQL - inserção - inserir no banco 
            clausula.executeUpdate("INSERT INTO Pessoa VALUES (2, '230.203.032/22', 'Joao', 'Menezes')" );

            // executa a clausula SQL - Consultan no banco
            ResultSet result = clausula.executeQuery("SELECT * FROM Pessoa");

            // acessando a resposta do banco
            while (result.next()) {
                System.out.println(result.getString("Nome"));
            }
            // fechando a conexao
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Deu errado!");
        }
    }
}
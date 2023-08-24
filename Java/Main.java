import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

// Classe que calcula o número de dias trabalhados com base nas datas de admissão e demissão.
class CalculadoraDiasTrabalhados {
    public static long calcularDiasTrabalhados(Date dataAdmissao, Date dataDemissao) {
        long diffInMilliseconds = dataDemissao.getTime() - dataAdmissao.getTime();
        return TimeUnit.DAYS.convert(diffInMilliseconds, TimeUnit.MILLISECONDS) + 1;
    }
}

// Classe que calcula o valor total a ser recebido com base no número de dias trabalhados.
class CalculadoraValorTotal {
    public static double calcularValorTotal(long diasTrabalhados) {
        int horasTrabalhadasPorDia = 8;
        double valorPorHora = 12.50;
        return diasTrabalhados * horasTrabalhadasPorDia * valorPorHora;
    }
}

// Classe principal do programa.
public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false); // Impede datas inválidas, como 32 de janeiro.

        Date dataAdmissao = null;
        Date dataDemissao = null;

        // Loop para solicitar datas até que entradas válidas sejam fornecidas.
        while (dataAdmissao == null || dataDemissao == null) {
            String dataAdmissaoStr = JOptionPane.showInputDialog("Digite a data de admissão (no formato dd-MM-yyyy):");
            
            // Verifica se a entrada para a data de admissão está no formato correto.
            if (!isValidDateFormat(dataAdmissaoStr)) {
                JOptionPane.showMessageDialog(null, "Erro: Formato de data inválido. Use o formato dd-MM-yyyy.");
                continue; // Volta ao início do loop para solicitar uma nova entrada.
            }

            String dataDemissaoStr = JOptionPane.showInputDialog("Digite a data de demissão (no formato dd-MM-yyyy):");
            
            // Verifica se a entrada para a data de demissão está no formato correto.
            if (!isValidDateFormat(dataDemissaoStr)) {
                JOptionPane.showMessageDialog(null, "Erro: Formato de data inválido. Use o formato dd-MM-yyyy.");
                continue; // Volta ao início do loop para solicitar uma nova entrada.
            }

            try {
                dataAdmissao = sdf.parse(dataAdmissaoStr);
                dataDemissao = sdf.parse(dataDemissaoStr);

                // Verifica se a data de demissão não é anterior à data de admissão.
                if (dataDemissao.before(dataAdmissao)) {
                    JOptionPane.showMessageDialog(null, "Erro: A data de demissão não pode ser anterior à data de admissão.");
                    dataAdmissao = null;
                    dataDemissao = null;
                }
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Erro: Data inválida. Use o formato dd-MM-yyyy.");
            }
        }

        // Calcula o número de dias trabalhados e o valor total a receber.
        long diasTrabalhados = CalculadoraDiasTrabalhados.calcularDiasTrabalhados(dataAdmissao, dataDemissao);
        double valorTotal = CalculadoraValorTotal.calcularValorTotal(diasTrabalhados);

        // Exibe o resultado.
        String resultado = "Dias Trabalhados: " + diasTrabalhados + "\nValor Total a Receber: R$ " + valorTotal;

        JOptionPane.showMessageDialog(null, resultado);
    }

    // Função para verificar se uma data está no formato correto.
    public static boolean isValidDateFormat(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}

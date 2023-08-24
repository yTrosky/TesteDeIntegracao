<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <title>Teste de Integração</title>
</head>

<body>  
    <div class="container"> 
        <!-- Formulário para inserção das data de admissão e demissão -->
        <form class="form" method="post" action=""> 
            <h2>Entrada de Datas</h2>
            <label for="admissao">Data de Admissão:</label>
            <br>
            <input type="date" id="admissao" name="admissao" placeholder="Digite a sua data de Admissão" required>
            <label for="demissao">Data de Demissão:</label>
            <br>
            <input type="date" id="demissao" name="demissao" placeholder="Digite a sua data de Demissão" required>
            <br>
            <button type="submit" name="botaoCalcular">Enviar</button>
            <h2>Resultado</h2>

        <?php

        require_once 'CalcularDiasTrabalhados.class.php';
        require_once 'CalcularValorTotal.class.php';

        // Após envio do formulário, o PHP verifica se o botão calcular foi pressionado
        if (isset($_POST["botaoCalcular"])) {
          
            // Se o botão foi pressionado, serão capturadas e armazenadas as duas datas digitadas em duas variáveis
            $dataAdmissao = $_POST["admissao"];
            $dataDemissao = $_POST["demissao"];

            // Aqui, as variáveis das datas são enviadas como parâmetros para a função calcular da Classe Calcular Dias Trabalhados
            $diasTrabalhados = CalcularDiasTrabalhados::calcularDias($dataAdmissao, $dataDemissao);
            
            // Verifica se os dias trabalhados é falso
            if ($diasTrabalhados === false) {
                echo "<p class='error-message'>Aviso: A data de admissão não pode ser maior do que a data de demissão.</p>";
            } else {
                
                // Se não for falso, chama a função calcular da classe Calcular Valor Total, enviando como parâmetros a variável dias Trabalhados
                $valorTotal = CalcularValorTotal::calcularValor($diasTrabalhados);

                // Se tudo ocorrer bem, serão mostradas na tela as duas variáveis calculadas
                echo "<p class='success-message'>Dias trabalhados: $diasTrabalhados dias.</p>";
                echo "<p class='success-message'>Valor total: R$ $valorTotal.</p>";
            }
        }
        ?>
        </form>

    </div>
</body>
</html>

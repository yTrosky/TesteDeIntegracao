<?php
class CalcularDiasTrabalhados { // Classe para calcular os dias Trabalhados
    public static function calcularDias($dataAdmissao, $dataDemissao) { // Função para calcular

        // Recupera as variáveis de data
        $dataAdmissao = new DateTime($dataAdmissao);
        $dataDemissao = new DateTime($dataDemissao);

        // Se a data de admissão for maior que a de demissão ele retorna falso
        if ($dataAdmissao > $dataDemissao) {
            return false;
        }

        // Calculando a diferença entre as datas e armazenando em uma variável
        $interval = $dataAdmissao->diff($dataDemissao)->days + 1;

        return $interval;
    }
}
?>







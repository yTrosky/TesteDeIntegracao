<?php
class CalcularValorTotal { // Classe Valor Total
    public static function calcularValor($diasTrabalhados) { // Função calcularValor
        
        // Calculando horas trabalhadas
        $horasTrabalhadas = $diasTrabalhados * 8;

        // Armazenando taxa de cada hora
        $taxaHora = 12.50;

        // Calculando o valor total
        $valorTotal = $horasTrabalhadas * $taxaHora;

        return $valorTotal;
    }
}
?>







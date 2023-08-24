from datetime import datetime

class CalculadoraDiasTrabalhados:
    def calcular_dias_trabalhados(self, data_admissao, data_demissao):
        data_admissao = datetime.strptime(data_admissao, "%Y-%m-%d")
        data_demissao = datetime.strptime(data_demissao, "%Y-%m-%d")
        
        if data_admissao > data_demissao:
            return False
        
        dias_trabalhados = (data_demissao - data_admissao).days + 1
        return dias_trabalhados

class CalculadoraValorTotal:
    def calcular_valor_total(self, dias_trabalhados):
        horas_trabalhadas = dias_trabalhados * 8
        valor_por_hora = 12.50
        valor_total = horas_trabalhadas * valor_por_hora
        return valor_total


data_admissao = input("Digite a data de admissão (YYYY-MM-DD): ")
data_demissao = input("Digite a data de demissão (YYYY-MM-DD): ")

calculadora_dias = CalculadoraDiasTrabalhados()
calculadora_valor = CalculadoraValorTotal()

dias_trabalhados = calculadora_dias.calcular_dias_trabalhados(data_admissao, data_demissao)

if dias_trabalhados is False:
    print("Aviso: A data de admissão não pode ser maior do que a data de demissão.")
else:
    valor_total = calculadora_valor.calcular_valor_total(dias_trabalhados)
    print(f"Quantidade de dias trabalhados: {dias_trabalhados}")
    print(f"Valor total a receber: R$ {valor_total:.2f}")

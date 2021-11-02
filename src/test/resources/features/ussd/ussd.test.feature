# language: es
Característica: Probar USSD - MOBILE
	@USSD
	Esquema del escenario: Prueba ussd MOBILE
		Dado que se proporciona un archivo "<Excel>" con el "<Dato>" para la prueba ussd
		Cuando vamos a la marcación
		Y marcamos el código USSD
		Entonces esperamos la respuesta
		Y consultamos mi prepado
		Entonces esperamos la respuesta
		Y selecionamos una de las opciones para consultar
		Y Eperamos la respuesta final

		Ejemplos:
		| Excel 	| Dato 	|
		|USSD.xlsx	|1    	|
# language: es
Característica: Probar USSD - MOBILE
	@USSD
	Esquema del escenario: Prueba ussd MOBILE
		Dado que se proporciona un archivo "<Excel>" con el "<Dato>" para la prueba ussd
		Cuando iniciamos el teléfono

		Ejemplos:
		| Excel | Dato |
		|USSD.xlsx|1   |
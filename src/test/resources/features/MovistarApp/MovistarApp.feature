# language: es
Característica: Probar USSD - MOBILE
	@MOVISTAR-APP
	Esquema del escenario: Prueba MOBILE app Movistar
		Dado que se tiene un archivo "<Excel>" con el "<caso>"
		Y abrimos la aplicación de Movistar
		Cuando Ingresamos en empezar ahora
		Y ingresamos con todos los productos
		Entonces ingresamos al perfil
		#Entonces consultamos la primera linea personal
		#Y revisamos los detalles de la linea
		#Y volvemos al inicio
		Y cerramos session

		Ejemplos:
		| Excel 			| caso 	|
		|MovistarApp.xlsx	| 1   	|
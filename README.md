# DuxTecnica
DUX SOFTWARE | PRUEBA TÉCNICA
Dada la siguiente estructura de tablas:
![image](https://user-images.githubusercontent.com/84359926/217639642-cce8cc1e-d39a-459b-b541-f289c5165608.png)
Realizar las consultas SQL necesarias para obtener los siguientes datos:
• Todos los productos del rubro "librería", creados hoy.

	SELECT *
	FROM producto
	WHERE rubro = 'libreria' AND DATE(fecha_creacion)= CURRENT_DATE

• Monto total vendido por cliente (mostrar nombre del cliente y monto)

	SELECT cliente.nombre, SUM(venta.precio_unitario) as TOTAL
	FROM venta
	JOIN cliente
	GROUP BY cliente.nombre

• Cantidad de ventas por producto

	SELECT  COUNT(*)
	FROM venta 
	JOIN producto
	GROUP BY producto.nombre

• Cantidad de productos comprados por cliente en el mes actual

	SELECT id_cliente, *
	FROM venta
	WHERE MONTH(venta.fecha) = MONTH(CURRENT_DATE)
	GROUP BY id_cliente

• Ventas que tienen al menos un producto del rubro "bazar".

	SELECT *
	FROM venta
	JOIN producto
	ON venta.codigo_producto = producto.codigo
	WHERE producto.id_rubro = 'bazar'
	GROUP BY venta.id_venta
	HAVING COUNT(*) >= 1

• Rubros que no tienen ventas en los últimos 2 meses.

	SELECT prducto.id_rubro
	FROM producto
	JOIN venta
	ON venta.codigo_producto >= MONTH(CURRENT_DATE) - 2
	WHERE venta.id_venta IS NULL


Parte 2: Java
Crear un programa que simule un partido de tenis, el mismo debe solicitar al usuario ingresar los datos
del partido (jugadores, nombre del torneo, etc) y con estos debe ejecutar punto por punto el transcurso
del partido hasta llegar a su fin.
El programa deberá tener en cuenta la puntuación y reglas utilizadas en este deporte.
Funcionalidades
Antes de comenzar la simulación, el usuario podrá ingresar los siguientes datos:
• Nombres de los jugadores.
• Nombre del torneo.
• Definición de la cantidad de sets: al mejor de 3 o al mejor de 5.
• Probabilidad de que cada jugador gane el partido (tiene que ir del 1 al 100% e influir en el
resultado final).
El programa deberá simular punto por punto de forma automática, donde el ganador de cada uno será
determinado de forma aleatoria (teniendo en cuenta la probabilidad definida al principio), y los mismos
se tienen que visualizar por pantalla. Datos a mostrar:
• Ganador del punto.
• Resultado parcial del game.
• Al comenzar un game, mostrar el jugador que tiene el saque.
• Al finalizar cada SET, se mostrará el ganador y el resultado parcial del partido.
Una vez finalizado el partido:
• Imprimir el resultado en formato de partido de tenis.
• Imprimir el nombre del ganador y del torneo.
• Preguntar al usuario si quiere jugar la revancha, en caso de que la respuesta sea sí, simular
nuevamente.
A considerar
- No se evaluará de forma estricta la interfaz, por lo que puede hacerse por consola.
- No es necesario que haya persistencia.
- El programa tiene que compilar y poder ejecutarse sin problemas.

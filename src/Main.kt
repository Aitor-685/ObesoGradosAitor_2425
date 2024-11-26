fun main() {
    println("*************************************************************************************")
    println("Benvingut al programa, escull alguna de les opcions que vols.")
    println("*************************************************************************************")

    while (true) {
        println("--- Menú ---")
        println("a. Calcula el quadrat d’un nombre")
        println("b. Compara dos nombres")
        println("c. Calcula àres i el volum d’una esfera")
        println("d. Calculadora senzilla")
        println("e. Demana un valor entre 0 i 10")
        println("f. La botiga The Bike House")
        println("g. Percentatge de nois i noies que hi ha al aule")
        println("i. Sortir")
        print("Escull una opció: ")

        when (readlnOrNull()?.trim()?.lowercase()) {
            "a" -> {
                print("Introdueix un nombre: ")
                val num = readln().toDouble()
                println("El quadrat de $num és ${quadrat(num)}")
            }
            "b" -> {
                print("Introdueix el primer nombre: ")
                val num1 = readln().toDouble()
                print("Introdueix el segon nombre: ")
                val num2 = readln().toDouble()
                if (esMajor(num1, num2)) {
                    println("El primer nombre ($num1) és major que el segon ($num2).")
                } else {
                    println("El primer nombre ($num1) no és major que el segon ($num2).")
                }
            }
            "c" -> {
                while (true) {
                    println("--- Menú d’Àrees ---")
                    println("1. Àrea del quadrat")
                    println("2. Àrea del rectangle")
                    println("3. Àrea del triangle")
                    println("4. Radi de una esfera")
                    println("5. Tornar al menú principal")
                    print("Escull una opció: ")

                    when (readln().toInt()) {
                        1 -> {
                            print("Introdueix el costat del quadrat: ")
                            val costat = readln().toDouble()
                            println("L’àrea del quadrat és ${areaQuadrat(costat)}")
                        }
                        2 -> {
                            print("Introdueix l'altura del rectangle: ")
                            val altura = readln().toDouble()
                            print("Introdueix l'amplada del rectangle: ")
                            val amplada = readln().toDouble()
                            println("L’àrea del rectangle és ${areaRectangle(altura, amplada)}")
                        }
                        3 -> {
                            print("Introdueix la base del triangle: ")
                            val base = readln().toDouble()
                            print("Introdueix l'altura del triangle: ")
                            val altura = readln().toDouble()
                            println("L’àrea del triangle és ${areaTriangle(base, altura)}")
                        }
                        4 -> {
                            print("Introdueix el radi de l’esfera: ")
                            val radi = readln().toDouble()
                            println("El volum de l’esfera amb radi $radi és ${calcularVolumEsfera(radi)}")
                        }
                        5 -> {
                            println("Tornant al menú principal...")
                            break
                        }
                        else -> println("Opció no vàlida. Torna-ho a intentar.")
                    }
                }
            }
            "d" -> {
                print("Introdueix el primer número: ")
                val num1 = readln().toDouble()
                print("Introdueix el segon número: ")
                val num2 = readln().toDouble()

                while (true) {
                    println("--- Menú Calculadora ---")
                    println("1. Suma")
                    println("2. Resta")
                    println("3. Multiplicació")
                    println("4. Divisió")
                    println("5. Tornar al menú principal")
                    print("Escull una opció: ")

                    when (readln().toInt()) {
                        1 -> println("Resultat de la suma: ${suma(num1, num2)}")
                        2 -> println("Resultat de la resta: ${resta(num1, num2)}")
                        3 -> println("Resultat de la multiplicació: ${multiplicacio(num1, num2)}")
                        4 -> {
                            if (num2 != 0.0) {
                                println("Resultat de la divisió: ${divisio(num1, num2)}")
                            } else {
                                println("No es pot dividir per zero.")
                            }
                        }
                        5 -> {
                            println("Tornant al menú principal...")
                            break
                        }
                        else -> println("Opció no vàlida. Torna-ho a intentar.")
                    }
                }
            }
            "e" -> {
                var valor: Int
                do {
                    print("Introdueix un valor entre 0 i 10: ")
                    valor = readln().toIntOrNull() ?: -1
                } while (valor !in 0..10)
                println("Has introduït un valor vàlid: $valor")
            }
            "f" -> {
                println("Benvingut a The bike House!")

                println("El client es VIP(si/no): ")
                val esVIP = readlnOrNull()?.trim()?.lowercase() == "si"

                println("Introdueix l'import de la compra:")
                val importCompra = readlnOrNull()?.toDoubleOrNull() ?: 0.0

                println("És la setmana de Black Friday? (si/no): ")
                val esBlackFriday = readlnOrNull()?.trim()?.lowercase() == "si"

                val preuFinal = calcularPreuFinal(importCompra, esVIP, esBlackFriday)
                println("El preu final de la teva compra és: ${"%.2f".format(preuFinal)} €")
            }
            "g" ->{
                println("Introdueix cuants nois hi ha al aule:")
                val nois = readln().toIntOrNull() ?: 0

                println("Introdueix cuants noies hi ha al aule:")
                val noies = readln().toIntOrNull() ?: 0

                val (percentatgeNois, percentatgeNoies) = alumnesDeClase(nois, noies)

                println("El porcentatge de nois que hi ha és de ${"%.2f".format(percentatgeNois)}%")
                println("El porcentatge de nois que hi ha és de ${"%.2f".format(percentatgeNoies)}%")
            }
            "i" -> {
                println("Sortint del programa.")
                break
            }
            else -> println("Opció no vàlida. Torna-ho a intentar.")
        }
    }
}

/**
 * Raiz cuadrada: para calcular la raiz cuadrada de cualquier numero el fun multiplica el numero por si
 * mismo para sacar el resultado
 */
fun quadrat(num: Double): Double = num * num

/**
 * Es major o menor: el fun utiliza el metodo Boolean que es logico de (true/false) si num1 es major que
 * num2 es treu pero si es lo contrario es false
 */
fun esMajor(num1: Double, num2: Double): Boolean = num1 > num2

/**
 * Sub menu: el fun toma el radi como parametro, lo usa como constante para representar el valor pi, para calcular el radio
 * de una esfera, tambien esta calcular el area de un (quadrat, rectangle y triangle). utilizando las formulas para hacerlo
 */
fun calcularVolumEsfera(radi: Double): Double =
    (4.0 / 3.0) * 3.14159265358979 * radi * radi * radi

fun areaQuadrat(costat: Double): Double = costat * costat
fun areaRectangle(altura: Double, amplada: Double): Double = altura * amplada
fun areaTriangle(base: Double, altura: Double): Double = (base * altura) / 2

/**
 * Metodo de operacion de calculadora: la funcion indica que devuelve un valor de tipo Double o null
 * y indica que el cuerpo de la funcion es una expresion unica. Que puede elejir con varias operaciones y si
 * hay un valor de tipus que no coincide devuelve null indicando error o caso no manejado
 */
fun suma(num1: Double, num2: Double): Double = num1 + num2

fun resta(num1: Double, num2: Double): Double = num1 - num2

fun multiplicacio(num1: Double, num2: Double): Double = num1 * num2

fun divisio(num1: Double, num2: Double): Double? =
    if (num2 != 0.0) num1 / num2 else null

/**
 * La botiga The Bike House: el importCompra es el importe antes de aplicar un descuento, esVIP es un
 * valor logico puede ser (treu/false) si es true se aplica el descuento y lo mismo para con el esBlackFriday
 * por ultimo si ninguno de los anteriores es verdadero no se aplica ningun descuento
 */
fun calcularPreuFinal(importCompra: Double, esVIP: Boolean, esBlackFriday: Boolean): Double =
    when {
        esBlackFriday -> importCompra * 0.5
        esVIP || importCompra > 200 -> importCompra * 0.8
        else -> importCompra
    }

/**
 * Percentatge de alumnes que hi ha a clase: el fun es un Pair que es una estructura de datos que contiene dos valores
 * de tipo Double que es de nois y noies. Primero verifica que el numeros de alumnes es major que cero si es true saca
 * el porcentage de nois i noies pero si es false por defecto sera 0.0
 */
fun alumnesDeClase(nois: Int, noies: Int): Pair<Double, Double> =
    if (nois + noies > 0) {
        val total = nois + noies
        val percentatgeNois = (nois.toDouble() / total) * 100
        val percentatgeNoies = (noies.toDouble() / total) * 100
        Pair(percentatgeNois, percentatgeNoies)
    } else {
        Pair(0.0, 0.0)
    }
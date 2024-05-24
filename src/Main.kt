import kotlin.math.pow
import kotlin.math.sqrt

fun desc(b: Double, c: Double): Double {
    return b.pow(2.0) - 4 * c
}

fun roots(b: Double, c: Double): DoubleArray? {
    val delta = desc(b, c)

    return if (delta > 0) {
        doubleArrayOf((b - sqrt(delta)) / 2, (b + sqrt(delta)) / 2)
    } else if (delta == 0.0) {
        doubleArrayOf(b / 2, b / 2)
    } else {
        null
    }
}

fun main() {
    println("Завдання №2")

    print("Введіть коефіцієнт а: ")
    val a: Double = readln().toDouble()

    if (a == 0.0) {
        print("Розв'язків немає")
        return
    }

    print("Введіть коефіцієнт b: ")
    val b: Double = readln().toDouble()

    print("Введіть коефіцієнт c: ")
    val c: Double = readln().toDouble()

    val roots = roots(b, c)

    if (a > 0) {
        if (roots == null) {
            print("x є (0;inf)")
        } else if (roots[0] > 0) {
            print("x є (0;" + roots[0] + ")U(" + roots[1] + ";inf)")
        } else if (roots[1] > 0) {
            print("x є (0;" + roots[1] + ")U(" + roots[1] + ";inf)")
        } else {
            print("x є (0;inf)")
        }
    } else if (a < 0) {
        if (roots == null) {
            print("x є (-inf;0)")
        } else if (roots[1] < 0) {
            print("x є (-inf;" + roots[0] + ")U(" + roots[1] + ";0)")
        } else if (roots[0] < 0) {
            print("x є (-inf;" + roots[0] + ")U(" + roots[0] + ";0)")
        } else {
            print("x є (-inf;0)")
        }
    }
}
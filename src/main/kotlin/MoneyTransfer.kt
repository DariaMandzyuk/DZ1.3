fun main() {
    calculateCommission(5000, "Mir")
}

var commission: Double = 0.0

fun calculateCommission(
    actualTransfer: Int,
    typeOfCard: String = "VKPay",
    previousTransfers: Int = 0
) {
    when (typeOfCard) {
        "VKPay" -> calculateCommissionForVKPay()
        "MasterCard", "Maestro" -> calculateCommissionForMasterCardOrMaestro(previousTransfers, actualTransfer)
        "Visa", "Mir" -> calculateCommissionForVisaOrMir(actualTransfer)
    }
}

fun calculateCommissionForVisaOrMir(actualTransfer: Int) {
    val minLimit = 35
    commission = actualTransfer * 0.0075
    if (commission <= minLimit) {
        commission = 35.0
    }
    println("Ваша комиссия составляет $commission рублей")
}

fun calculateCommissionForMasterCardOrMaestro(previousTransfers: Int, actualTransfer: Int) {
    val allTransfers: Int = previousTransfers + actualTransfer
    val limit = 75000
    commission = if (allTransfers >= limit) {
        ((actualTransfer / 100) * 0.6) + 20
    } else {
        0.0
    }
    println("Ваша комиссия составляет $commission рублей")
}

fun calculateCommissionForVKPay() {
    commission = 0.0
    println("Ваша комиссия составляет $commission рублей")
}






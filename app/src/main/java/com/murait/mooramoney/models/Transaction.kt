package com.murait.mooramoney.models

data class Transaction(
    var thumb: Int,
    var name: String,
    var transDate: String,
    var amount: Double,
    var debitCredit: String
)

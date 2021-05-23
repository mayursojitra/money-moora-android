package com.murait.mooramoney

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.murait.mooramoney.adapter.CreditCardAdapter
import com.murait.mooramoney.adapter.OperationAdapter
import com.murait.mooramoney.adapter.TransactionHistoryAdapter
import com.murait.mooramoney.databinding.ActivityMainBinding
import com.murait.mooramoney.models.CreditCard
import com.murait.mooramoney.models.Operation
import com.murait.mooramoney.models.Transaction

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var cardList: ArrayList<CreditCard>
    private lateinit var operationList: ArrayList<Operation>
    private lateinit var transactionList: ArrayList<Transaction>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

        cardList = ArrayList<CreditCard>()
        cardList.add(CreditCard("Mayur Sojitra1", "**** **** **** 6789", "09-09-2021"))
        cardList.add(CreditCard("Mayur Sojitra2", "**** **** **** 6789", "09-09-2021"))
        cardList.add(CreditCard("Mayur Sojitra3", "**** **** **** 6789", "09-09-2021"))

        val adapter = CreditCardAdapter(this@MainActivity, cardList)
        binding.rvCard.adapter = adapter

        operationList = ArrayList();
        operationList.add(Operation("Money Transfer", R.drawable.ic_money_transfer))
        operationList.add(Operation("Insights Tracking", R.drawable.ic_tracking))
        operationList.add(Operation("Bank Withdraw", R.drawable.ic_withdraw))

        val opAdapter = OperationAdapter(this@MainActivity, operationList)
        binding.rvOperation.adapter = opAdapter

        transactionList = ArrayList();
        transactionList.add(
            Transaction(
                thumb = R.drawable.uber,
                amount = 23.43,
                name = "Uber Ride",
                debitCredit = "-",
                transDate = "19th Apr 2020"
            )
        )
        transactionList.add(
            Transaction(
                thumb = R.drawable.nike,
                amount = 98.43,
                name = "Nike Outlet",
                debitCredit = "-",
                transDate = "17th Apr 2020"
            )
        )
        transactionList.add(
            Transaction(
                thumb = R.drawable.user,
                amount = 298.43,
                name = "Payment Received",
                debitCredit = "+",
                transDate = "10th Apr 2020"
            )
        )

        val thAdapter = TransactionHistoryAdapter(this@MainActivity, transactionList)
        binding.rvTransactionHistory.adapter = thAdapter

    }
}
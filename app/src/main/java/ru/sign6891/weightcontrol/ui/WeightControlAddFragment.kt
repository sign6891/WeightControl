package ru.sign6891.weightcontrol.ui

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import ru.sign6891.weightcontrol.R
import ru.sign6891.weightcontrol.ui.base.BaseFragment
import java.util.*

class WeightControlAddFragment : BaseFragment(), DatePickerDialog.OnDateSetListener {

    companion object {
        val NAVIGATION_LABEL = "fragment_weight_control_add"
    }

    private lateinit var editTextWeight: EditText
    private lateinit var mConstraintSelectDate: ConstraintLayout
    private lateinit var mView: View
    private lateinit var mCalendar: Calendar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initViews()
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_weight_control_add, container, false)
        return mView
    }

    private fun initViews() {
        mConstraintSelectDate = mView.findViewById(R.id.constraint_select_date)
        mConstraintSelectDate.setOnClickListener { showDatePickerDialog() }
    }

    private fun showDatePickerDialog() {


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        editTextWeight = view?.findViewById(R.id.editTextWeight)!!
        if (TextUtils.isEmpty(editTextWeight.text)) {

        }
        configureFloatingActionButton()
    }

    private fun configureFloatingActionButton() {
        val navigationIconId = 0
        val fabIconId = R.drawable.ic_save
        configureFloatingActionButton(navigationIconId, fabIconId)
    }

    fun saveDate(){
        // Leave screen
        leaveScreen()
    }

    private fun leaveScreen() {
        navigateUp()
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        mCalendar.set(p1,p2, p3, )
    }

}
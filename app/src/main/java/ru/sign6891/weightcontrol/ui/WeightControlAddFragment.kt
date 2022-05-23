package ru.sign6891.weightcontrol.ui

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.sign6891.weightcontrol.R
import ru.sign6891.weightcontrol.data.WeightControlApplication
import ru.sign6891.weightcontrol.data.source.local.entity.DataElementEntity
import ru.sign6891.weightcontrol.ui.base.BaseFragment
import java.util.*

class WeightControlAddFragment : BaseFragment() {

    companion object {
        val NAVIGATION_LABEL = "fragment_weight_control_add"
    }

    private lateinit var editTextWeight: EditText
    private lateinit var mSelectDate: TextView
    private lateinit var mOpenDatePickerDialog: ImageView

    private lateinit var mConstraintSelectDate: ConstraintLayout
    private lateinit var mView: View

    /*private val mViewModel: WeightControlAddViewModel by viewModels {
        WeightControlViewModelFactory((activity as WeightControlApplication).repository)
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_weight_control_add, container, false)
        //mWeightControlAddViewModel = ViewModelProvider(this, defaultViewModelProviderFactory).get(WeightControlAddViewModel::class.java)

        initViews()
        return mView
    }

    private fun initViews() {
        mConstraintSelectDate = mView.findViewById(R.id.constraint_select_date)
        mSelectDate = mView.findViewById(R.id.text_view_select_date)
        mOpenDatePickerDialog = mView.findViewById(R.id.imageView)
        showDatePickerDialog()
    }

    @SuppressLint("SetTextI18n")
    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        mSelectDate.setText("" + day + "." + month + "." + year)

        mOpenDatePickerDialog.setOnClickListener {
            val dpd = DatePickerDialog(
                requireActivity(),
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                    // Display Selected date in textbox
                    mSelectDate.setText("" + dayOfMonth + "." + monthOfYear + "." + year)

                }, year, month, day)

            dpd.show()
        }
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

    fun saveDate() {
        if (editTextWeight.text.isNotEmpty() && mSelectDate.text.isNotEmpty()) {
            val mWeightControlAddViewModel: WeightControlViewModel by viewModels {
                WeightControlViewModelFactory((activity as WeightControlApplication).repository)
            }
            mWeightControlAddViewModel.addDataElement(DataElementEntity(mSelectDate.text.toString(), editTextWeight.text.toString()))
        } else {
            Toast.makeText(requireContext(), "Укажите свой вес", Toast.LENGTH_LONG).show()
        }

        // Leave screen
        leaveScreen()
    }

    private fun leaveScreen() {
        navigateUp()
    }

}
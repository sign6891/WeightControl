package ru.sign6891.weightcontrol.ui.base

import android.content.Context
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {

    private var mListener: OnFragmentInteractionListener? = null

    fun navigateScreen(resId: Int) {
        mListener?.onNavigateScreen(resId)
    }

    fun navigateUp() {
        mListener?.onNavigateUpScreen()
    }

    fun configureFloatingActionButton(navigationIconId: Int, fabIconId: Int) {
        mListener?.onConfigureFloatingActionButton(navigationIconId, fabIconId)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = context as OnFragmentInteractionListener

    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

}

interface OnFragmentInteractionListener {
    fun onNavigateScreen(resId: Int)
    fun onNavigateUpScreen()

    fun onConfigureFloatingActionButton(navigationIconId: Int, fabIconId: Int)
}
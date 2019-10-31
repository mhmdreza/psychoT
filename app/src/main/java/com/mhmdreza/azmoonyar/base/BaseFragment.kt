package com.mhmdreza.azmoonyar.base

import androidx.fragment.app.Fragment
import com.mhmdreza.azmoonyar.MainActivity

open class BaseFragment : Fragment(){
    protected val mainActivity get() = activity as MainActivity
}
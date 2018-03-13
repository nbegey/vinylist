package com.theneversleepingwinds.vinylist.presentation

import android.arch.lifecycle.ViewModel
import com.theneversleepingwinds.vinylist.presentation.model.VinylPresentation
import java.util.*

/**
 * @Author Nicolas BEGEY - 18-03-07.
 */
class ListViewModel(var vinyls: ArrayList<VinylPresentation>): ViewModel(){
    fun addVinnyl(vinyl: VinylPresentation) = vinyls.add(vinyl)
}
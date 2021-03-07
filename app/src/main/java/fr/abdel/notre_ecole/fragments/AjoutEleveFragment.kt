package fr.abdel.notre_ecole.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fr.abdel.nature.MainActivity
import fr.abdel.nature.R

class AjoutEleveFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater?.inflate(R.layout.fragment_ajout_eleve, container, false)


        return view
    }
}
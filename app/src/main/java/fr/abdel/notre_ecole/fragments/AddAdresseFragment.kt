package fr.abdel.notre_ecole.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import fr.abdel.nature.MainActivity
import fr.abdel.nature.R
import fr.abdel.notre_ecole.metier.Adresse


class AddAdresseFragment(private val context: MainActivity): Fragment() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater?.inflate(R.layout.fragment_add_adresse, container, false)

        val validerAdr = view.findViewById<Button>(R.id.btn_ajout_adr)


        return view
    }

}
private fun EditText.toInt(): Int {
    TODO("Not yet implemented")
}
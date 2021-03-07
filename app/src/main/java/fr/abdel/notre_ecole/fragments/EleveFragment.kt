package fr.abdel.nature.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import fr.abdel.nature.MainActivity
import fr.abdel.nature.R



class EleveFragment(context: MainActivity) : Fragment() {
    private lateinit var activiteMere: EleveFragment.envoyerInfoActivite

    companion object {
        fun newInstance(): EleveFragment {
            return EleveFragment(context = MainActivity())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater?.inflate(R.layout.fragment_eleves, container, false)

        //page principale eleve
        val rechercherEl = view?.findViewById<Button>(R.id.button)
        rechercherEl?.setOnClickListener { onWhatsUp() }

        //recherche eleve par NOM
        val ajoutEl = view?.findViewById<Button>(R.id.button3)
        ajoutEl?.setOnClickListener { onGo() }
        val rechercheElNm = view.findViewById<EditText>(R.id.nom_eleve_input)
        val validerRechercheEleveN = view.findViewById<Button>(R.id.btn_valider_recherche_eleveN)
        validerRechercheEleveN?.setOnClickListener { rechercherElN() }

        //recherche eleve par ID
        val rechercheElId = view.findViewById<EditText>(R.id.id_eleve_input)
        val validerRechercheEleveI = view.findViewById<Button>(R.id.btn_valider_recherche_eleveI)
        validerRechercheEleveI?.setOnClickListener { rechercherElI() }

        // ajouter un eleve
        // les input
        val inputNom = view.findViewById<EditText>(R.id.editNom)
        val inputPrenom = view.findViewById<EditText>(R.id.editPrenom)
        val inputDate = view.findViewById<EditText>(R.id.editDate)
        val inputAge = view.findViewById<EditText>(R.id.editAge)
        val inputNumRue = view.findViewById<EditText>(R.id.editNumRue)
        val inputNomRue = view.findViewById<EditText>(R.id.editNomRue)
        val inputCodePostal = view.findViewById<EditText>(R.id.editCodePostal)
        val inputVille = view.findViewById<EditText>(R.id.editVille)
        val inputPays = view.findViewById<EditText>(R.id.editpays)
        //le bouton
        val validAjoutEleve = view.findViewById<Button>(R.id.btn_val_ajout_eleve)
        validAjoutEleve?.setOnClickListener { ajouterEl() }

        //modifier un eleve




        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is EleveFragment.envoyerInfoActivite) {
            this.activiteMere = context
        }
    }

    fun onWhatsUp() {
        activiteMere.onClickWhatsUp()
    }

    fun rechercherElN(){
    activiteMere.onClickEln()
    }

    fun rechercherElI(){
        activiteMere.onClickElI()
    }

    fun ajouterEl(){
        activiteMere.onClickAddEl()
    }

    fun onGo(){
        activiteMere.onGoMain()
    }


    interface envoyerInfoActivite {

        fun onClickWhatsUp()
        fun onClickEln()
        fun onClickElI()
        fun onClickAddEl()
        fun onGoMain()

    }

}



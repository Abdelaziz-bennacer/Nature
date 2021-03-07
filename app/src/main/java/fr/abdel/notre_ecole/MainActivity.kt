package fr.abdel.nature

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.google.android.material.bottomnavigation.BottomNavigationView
import fr.abdel.nature.fragments.*
import fr.abdel.notre_ecole.dao.Converters.Companion.toDate
import fr.abdel.notre_ecole.dao.MaBdd
import fr.abdel.notre_ecole.fragments.AdresseFragment
import fr.abdel.notre_ecole.fragments.AjoutEleveFragment
import fr.abdel.notre_ecole.fragments.RechercheEleveFragment
import fr.abdel.notre_ecole.metier.Adresse
import fr.abdel.notre_ecole.metier.Etudiant

class MainActivity : AppCompatActivity(), EleveFragment.envoyerInfoActivite {

    //page Eleve
    override fun onClickWhatsUp() {
        loadFragment(RechercheEleveFragment())
    }

    //recherhe eleve PAR NOM
    override fun onClickEln() {
        val rechercheElNm = this.findViewById<EditText>(R.id.nom_eleve_input)
        val db = Room.databaseBuilder(this, MaBdd::class.java, "ecole").build()
        val texteIn:String = rechercheElNm?.text.toString()
        val dao = db.etudiantDao()
        val texteOut: Etudiant = dao.getNom(texteIn)
        Toast.makeText(this, "l'étudiant est: $texteOut", Toast.LENGTH_LONG).show()
    }

    //page de recherche
    override fun onGoMain() {
       loadFragment(AjoutEleveFragment())
    }

    //recherche eleve PAR ID
    override fun onClickElI() {
        val rechercheElId = this.findViewById<EditText>(R.id.id_eleve_input)
        val db = Room.databaseBuilder(this, MaBdd::class.java, "ecole").build()
        val texteIn2: Long = rechercheElId.text.toString().toLong()
        val dao2 = db.etudiantDao()
        val texteOut2: Etudiant = dao2.get(texteIn2)
        Toast.makeText(this,"l'étudiant est $texteOut2", Toast.LENGTH_LONG).show()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onClickAddEl() {
        val inputNom = this.findViewById<EditText>(R.id.editNom)
        val inputPrenom = this.findViewById<EditText>(R.id.editPrenom)
        val inputDate = this.findViewById<EditText>(R.id.editDate)
        val inputAge = this.findViewById<EditText>(R.id.editAge)
        val inputNumRue = this.findViewById<EditText>(R.id.editNumRue)
        val inputNomRue = this.findViewById<EditText>(R.id.editNomRue)
        val inputCodePostal = this.findViewById<EditText>(R.id.editCodePostal)
        val inputVille = this.findViewById<EditText>(R.id.editVille)
        val inputPays = this.findViewById<EditText>(R.id.editpays)
        val db = Room.databaseBuilder(this, MaBdd::class.java, "ecole").build()
        val n1 = inputNom.text.toString()
        val n2 = inputPrenom.text.toString()
        val n3 = inputDate.text.toString().toLong()
        val n4 = inputAge.text.toString()
        val n5 = inputNumRue.text.toString()
        val n5bis = inputNumRue.text.toString().toLong()
        val n6 = inputNomRue.text.toString()
        val n7 = inputCodePostal.text.toString()
        val n7bis = inputCodePostal.text.toString().toLong()
        val n8 = inputVille.text.toString()
        val n9 = inputPays.text.toString()
        var etudiant = Etudiant(0, n1, n2, toDate(n3), "$n5 $n6 $n7 $n8 $n9")
        var adresse = Adresse(0, n5bis, n6, n7bis, n8, n9 )
        val dao3 = db.etudiantDao()
        val dao4 = db.adresseDao()
        dao3.insertOne(etudiant)
        dao4.insertOne(adresse)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //navigationview
        val navigationView = findViewById<BottomNavigationView>(R.id.navigation_view)
        navigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){

                R.id.home_page ->{loadFragment(HomeFragment(this))
                    return@setOnNavigationItemSelectedListener true}
                R.id.eleves_page ->{loadFragment(EleveFragment(this))
                    return@setOnNavigationItemSelectedListener true}
                R.id.adresse_page ->{loadFragment(AdresseFragment(this))
                    return@setOnNavigationItemSelectedListener true}
                R.id.listes_page ->{loadFragment(ListeFragment(this))
                    return@setOnNavigationItemSelectedListener true}
                R.id.salles_page ->{loadFragment(SalleFragment(this))
                    return@setOnNavigationItemSelectedListener true}
                else -> false
            }

        }


        loadFragment(HomeFragment(this))
    }




    private fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }



}
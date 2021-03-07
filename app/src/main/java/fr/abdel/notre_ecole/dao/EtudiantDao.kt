package fr.abdel.notre_ecole.dao

import androidx.room.*
import fr.abdel.notre_ecole.metier.Etudiant

@Dao
interface EtudiantDao {

    @Query ("SELECT * FROM etudiant")
    fun get(): List<Etudiant>

    @Query ("SELECT * FROM etudiant WHERE Nom = :nom")
    fun getNom(nom:String): Etudiant

    @Query ("SELECT * FROM etudiant WHERE Identifiant = :id")
    fun get(id:Long): Etudiant

    @Insert
    fun insertOne(etudiant: Etudiant)

    @Insert
    fun insertAll(vararg listEtudiant: Etudiant)

    @Update
    fun updateEtudiant(task: Etudiant)

    @Delete
    fun deleteEtudiant(task: Etudiant)
}

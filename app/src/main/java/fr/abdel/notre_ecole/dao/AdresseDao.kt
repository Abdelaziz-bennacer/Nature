package fr.abdel.notre_ecole.dao

import androidx.room.*
import fr.abdel.notre_ecole.metier.Adresse

@Dao
interface AdresseDao {

    @Query("SELECT * FROM adresse")
    fun get(): List<Adresse>

    @Query("SELECT * FROM adresse WHERE idAdresse = :id")
    fun get(id:Long): Adresse

    @Insert
    fun insertOne(adresse: Adresse)

    @Insert
    fun insertAll(vararg listAdresse: Adresse)

    @Update
    fun updateAdresse(task: Adresse)

    @Delete
    fun deleteAdresse(task: Adresse)

}
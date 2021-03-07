package fr.abdel.notre_ecole.dao

import androidx.room.*
import fr.abdel.notre_ecole.metier.Salle

@Dao
interface SalleDao {
    @Query("SELECT * FROM salle")
    fun get(): List<Salle>

    @Query("SELECT * FROM salle WHERE idSalle = :id")
    fun det(id:Long): Salle

    @Insert
    fun insertAll(vararg listSalle: Salle)

    @Update
    fun updateSalle(task: Salle)

    @Delete
    fun deleteSalle(task: Salle)

}
package com.example.teamapp.repository

import com.uvg.teamapp.model.TeamMember

class FakeTeamRepository {

    fun getTeamMembers(): List<TeamMember> {
        return listOf(
            TeamMember("Pablo Vásquez", "Encargado de crear la data class"),
            TeamMember("David López", "Encargado del repositorio falso"),
            TeamMember("Jonathan Tubac", "Encargado de la lista en Compose"),
        )
    }
}
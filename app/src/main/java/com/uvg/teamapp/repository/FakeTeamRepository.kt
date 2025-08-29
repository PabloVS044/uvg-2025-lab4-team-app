package com.example.teamapp.repository

import com.uvg.teamapp.R
import com.uvg.teamapp.model.TeamMember

class FakeTeamRepository {

    fun getTeamMembers(): List<TeamMember> {
        return listOf(
            TeamMember(R.string.member_1_name, R.string.member_1_description),
            TeamMember(R.string.member_2_name,R.string.member_2_description),
            TeamMember(R.string.member_3_name,R.string.member_3_description),
        )
    }
}
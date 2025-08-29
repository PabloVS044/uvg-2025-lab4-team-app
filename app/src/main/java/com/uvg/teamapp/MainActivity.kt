package com.uvg.teamapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teamapp.repository.FakeTeamRepository
import com.uvg.teamapp.ui.theme.TeamAppTheme
import com.uvg.teamapp.model.TeamMember
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //variables to call the fake repository
            val repo = FakeTeamRepository()
            val teamMembers = repo.getTeamMembers()

            //using the TeamList in the screen
            TeamListScreen(members = teamMembers)
        }
    }
}

//Composable with iteration of each member and to adding it in the list
@Composable
fun TeamListScreen(members: List<TeamMember>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        items(members) { member ->
            TeamMemberItem(member)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

//Composable for the structure of each member in the card
@Composable
fun TeamMemberItem(member: TeamMember) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = member.name, style = MaterialTheme.typography.titleMedium)
            Text(text = member.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
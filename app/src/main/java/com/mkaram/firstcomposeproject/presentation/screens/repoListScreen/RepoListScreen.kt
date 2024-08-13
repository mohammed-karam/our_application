package com.mkaram.firstcomposeproject.presentation.screens.repoListScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mkaram.firstcomposeproject.R
import com.mkaram.firstcomposeproject.presentation.screens.commonComponents.RepoAppBar

@Composable
fun RepoListScreen(
    modifier: Modifier = Modifier,
    repoListUiModel: List<GithubRepoUiModel>,
    navController : NavController,
    onRepoItemClicked: (repoItem: GithubRepoUiModel) -> Unit,


) {
    Scaffold(

        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        topBar = {
            RepoAppBar(
                title = R.string.repository_screen_title,
                showArrowBack = false
            )
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 8.dp, top = 8.dp)
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(repoListUiModel) { repoItem ->
                RepoItem(
                    repoItem = repoItem,
                    onRepoItemClicked = { onRepoItemClicked(it) }
                )

            }
        }


    }
}
